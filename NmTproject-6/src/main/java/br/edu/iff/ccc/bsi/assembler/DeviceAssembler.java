package br.edu.iff.ccc.bsi.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.edu.iff.ccc.bsi.controller.apirest.MainRestController;
import br.edu.iff.ccc.bsi.entities.Device;

@Component
public class DeviceAssembler extends RepresentationModelAssemblerSupport<Device, EntityModel<Device>>
{
	public DeviceAssembler() {
	    super(MainRestController.class, (Class<EntityModel<Device>>) (Class<?>) EntityModel.class);
	}


	@Override
	public EntityModel<Device> toModel(Device device)
	{
		return EntityModel.of(device,linkTo(methodOn(MainRestController.class).getDeviceEndereco(device.getAddress())).withSelfRel());
	}
}
