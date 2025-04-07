package br.edu.iff.ccc.bsi.service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.entities.Device;
import br.edu.iff.ccc.bsi.repository.DeviceRepository;
import jakarta.transaction.Transactional;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRep;
	
	public Optional<Device> findById(long id)
	{
		Optional<Device> task = deviceRep.findById(id);
		return task;
	}
	
	@Transactional
    public void insertDevice(String name, String address)
	{
        Device device = new Device();
        device.setName(name);
        device.setAddress(address);
        deviceRep.save(device);
	}
	
	public boolean eAlcancavel(String address, int timeout)
	{
		try {
            InetAddress iAddress = InetAddress.getByName(address);
            return iAddress.isReachable(timeout);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public List<Device> listaTodosDevices()
	{
		return deviceRep.findAll();
	}
}
