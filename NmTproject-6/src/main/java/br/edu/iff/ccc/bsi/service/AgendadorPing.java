package br.edu.iff.ccc.bsi.service;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.entities.Device;
import br.edu.iff.ccc.bsi.exception.DeviceNotFoundException;

@Service
public class AgendadorPing
{
	DeviceService deviceService;
	
	public AgendadorPing(DeviceService deviceService)
	{
		this.deviceService = deviceService;
	}
	
	@Scheduled(fixedRate = 5000)
	public void monitorDevices()
	{
		List<Device> devices = deviceService.listaTodosDevices();
		
		for(Device device : devices)
		{
			boolean alcanca = deviceService.eAlcancavel(device.getAddress(), 1000);
			if(!alcanca)
			{
				throw new DeviceNotFoundException(device.getAddress());
			}
		}
	}
}
