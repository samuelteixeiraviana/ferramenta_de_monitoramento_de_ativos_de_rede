package br.edu.iff.ccc.bsi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.entities.Device;

@Service
public class AgendadorPing
{
	DeviceService deviceService;
	
	public AgendadorPing(DeviceService deviceService)
	{
		this.deviceService = deviceService;
	}
	
	@Scheduled(fixedRate = 5000)
	public Map<String, List<Device>> monitorDevices()
	{
		List<Device> devices = deviceService.listaTodosDevices();
		List<Device> devicesAlcancaveis = new ArrayList<>();
		List<Device> devicesNaoAlcancaveis = new ArrayList<>();
		
		for(Device device : devices)
		{
			boolean alcanca = deviceService.eAlcancavel(device.getAddress(), 1000);
			if(!alcanca)
			{
				devicesNaoAlcancaveis.add(device);
			}
			else
			{
				devicesAlcancaveis.add(device);
			}
		}
		
		Map<String, List<Device>> resultado = new HashMap<>();
		resultado.put("UP", devicesAlcancaveis);
		resultado.put("DOWN", devicesNaoAlcancaveis);
		
		return resultado;
	}
}
