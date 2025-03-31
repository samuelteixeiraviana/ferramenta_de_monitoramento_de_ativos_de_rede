package br.edu.iff.ccc.bsi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.entities.Device;
import br.edu.iff.ccc.bsi.repository.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRep;
	
	public Optional<Device> findById(long id)
	{
		Optional<Device> task = deviceRep.findById(id);
		return task;
	}
}
