package br.edu.iff.ccc.bsi.controller.apirest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.edu.iff.ccc.bsi.entities.Device;
import br.edu.iff.ccc.bsi.exception.DeviceAlreadyExistsException;
import br.edu.iff.ccc.bsi.exception.DeviceNotFoundException;
import br.edu.iff.ccc.bsi.repository.DeviceRepository;
import br.edu.iff.ccc.bsi.service.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path ="/api/v1")
@Tag(name = "MainRest", description="Rest Controller com HATEOS")
public class MainRestController {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private DeviceService deviceService;
	
	@Operation(summary = "Retorna o dispositivo buscado pelo nome")
	@GetMapping(path = "/devices/name/{name}")
	public ResponseEntity<CollectionModel<EntityModel<Device>>> getDeviceNome(@PathVariable("name") String name)
	{	
		
		
		if(deviceRepository.findByName(name).isEmpty())
		{
			throw new DeviceNotFoundException(name);
		}
		else
		{
			List<Device> devices = deviceRepository.findByName(name);

			CollectionModel<EntityModel<Device>> model = CollectionModel.of(
		            devices.stream()
		                   .map(device -> EntityModel.of(device,
		                        linkTo(methodOn(MainRestController.class).getDeviceNome(name)).withSelfRel()))
		                   .collect(Collectors.toList()));

	        return ResponseEntity.ok(model);
		}
    }
	
	@Operation(summary = "Retorna o dispositivo buscado pelo endereço")
	@GetMapping(path = "/devices/address/{address}")
	public ResponseEntity<CollectionModel<EntityModel<Device>>> getDeviceEndereco(@PathVariable("address") String address)
	{
		if(deviceRepository.findByAddress(address).isEmpty())
		{
			throw new DeviceNotFoundException(address);
		}
		else
		{
			List<Device> devices = deviceRepository.findByAddress(address);

			CollectionModel<EntityModel<Device>> model = CollectionModel.of(
		            devices.stream()
		                   .map(device -> EntityModel.of(device,
		                        linkTo(methodOn(MainRestController.class).getDeviceEndereco(address)).withSelfRel()))
		                   .collect(Collectors.toList()));

	        return ResponseEntity.ok(model);
		}	
	}
	
	@Operation(summary = "Insere dispositivo")
	@PostMapping(path = "/devices/new/{address}") //address é para ser o endereço IPv4
	public ResponseEntity<CollectionModel<EntityModel<Device>>> postHostIdParam(@PathVariable("address") String address, @RequestParam("name") String name)
	{
		if(!deviceRepository.findByAddress(address).isEmpty())
		{
			throw new DeviceAlreadyExistsException(address);
		}
		else
		{
			deviceService.insertDevice(name, address);
			
			List<Device> devices = deviceRepository.findByAddress(address);

			CollectionModel<EntityModel<Device>> model = CollectionModel.of(
		            devices.stream()
		                   .map(device -> EntityModel.of(device,
		                        linkTo(methodOn(MainRestController.class).postHostIdParam(address, name)).withSelfRel(),
		                        linkTo(methodOn(MainRestController.class).getDeviceNome(name)).withRel("device by name"),
		                        linkTo(methodOn(MainRestController.class).getDeviceEndereco(address)).withRel("device by address"),
		                        linkTo(methodOn(MainRestController.class).deleteDeviceByAddress(address)).withRel("delete by address")))
		                   .collect(Collectors.toList()));

	        return ResponseEntity.ok(model);
			
//			return ResponseEntity.ok().header("Content-Type", "application/json").body("Dispositivo -> " + address + " nome -> " + name + " criado");
		}	
	}
	
	@Operation(summary = "Remove dispositivo")
	@DeleteMapping(path = "/devices/delete/{address}") // address é para ser o endereço IPv4
	public ResponseEntity<CollectionModel<EntityModel<Device>>> deleteDeviceByAddress(@PathVariable("address") String address)
	{
		if(!deviceRepository.findByAddress(address).isEmpty())
		{
			
			List<Device> devices = deviceRepository.findByAddress(address);
			
			deviceRepository.deleteByAddress(address);
			
			CollectionModel<EntityModel<Device>> model = CollectionModel.of(
		            devices.stream()
		                   .map(device -> EntityModel.of(device,
		                        linkTo(methodOn(MainRestController.class).deleteDeviceByAddress(address)).withSelfRel(),
		                        linkTo(methodOn(MainRestController.class).getDeviceEndereco(address)).withRel("device by address")))
		                   .collect(Collectors.toList()));

	        return ResponseEntity.ok(model);
	        
		}
		else
		{
			throw new DeviceNotFoundException(address);
		}
		
	}
	
//	@Autowired
//	private TaskRepository taskService;
//
//	@Operation(summary = "Retorna todos os exemplos armazenados")
//	@GetMapping(path = "/exemplos")
//	public ResponseEntity<List<Map<String, String>>> getExemplo() {
//		String body = "exemplo API em construção";
//		List<Map<String, String>> lista = new ArrayList();
//		Map<String, String> item1 = new HashMap();
//		Map<String, String> item2 = new HashMap();
//		item1.put("id", "1234");
//		item1.put("nome", "teste");
//		lista.add(item1);
//		item2.put("id", "2345");
//		item2.put("nome", "teste2");
//		lista.add(item2);
//		return ResponseEntity.ok(lista);
//	}
//	
//	@Operation(summary = "Retorna o exemplo por Id")
//	@GetMapping(path = "/exemplos/{id}")
//	public ResponseEntity<String> getExemploId(@PathVariable("id") int id) {
//		
//		return ResponseEntity
//				.ok()
//				.header("Content-Type", "application/json").body("Exemplo -> " + id);
//	}
//	
//	@Operation(summary = "Atualiza um exemplo por Id")
//	@PutMapping(path = "/exemplos/{id}")
//	public ResponseEntity<String> getExemploIdParam(@PathVariable("id") int id, @RequestParam("nome") String nome) {
//		
//		return ResponseEntity
//				.ok()
//				.header("Content-Type", "application/json").body("Exemplo -> " + id + "nome -> " +nome);
//	}
//	
//	@Operation(summary = "Insere objeto")
//	@PostMapping(path = "/host/new/{id}") //id é para ser o endereço IPv4
//	public ResponseEntity<String> postHostIdParam(@PathVariable("id") int id, @RequestParam("nome") String nome)
//	{
//		return ResponseEntity
//				.ok()
//				.header("Content-Type", "application/json")
//				.body("Objeto -> " + id + " nome -> " + nome + " criado");
//	}
//	
//	@Operation(summary = "Remove objeto")
//	@DeleteMapping(path = "/host/delete/{id}") // id é para ser o endereço IPv4
//	public ResponseEntity<String> deleteHostById(@PathVariable("id") int id) {
//		
//		// Teste pra simular as duas situações de remoção
//	    boolean removido = false;
////		boolean removido = true;
//		
//	    if (removido) {
//	        return ResponseEntity.ok("Host com ID " + id + " removido com sucesso!");
//	    } else {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Host com ID " + id + " não encontrado.");
//	    }
//	}
}