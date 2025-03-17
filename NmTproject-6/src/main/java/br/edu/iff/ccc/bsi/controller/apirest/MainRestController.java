package br.edu.iff.ccc.bsi.controller.apirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path ="/api/v1")
@Tag(name = "MainRest", description="Exemplo de um RestController")
public class MainRestController {
	
	@Autowired
	private TaskRepository taskService;

	@Operation(summary = "Retorna todos os exemplos armazenados")
	@GetMapping(path = "/exemplos")
	public ResponseEntity<List<Map<String, String>>> getExemplo() {
		String body = "exemplo API em construção";
		List<Map<String, String>> lista = new ArrayList();
		Map<String, String> item1 = new HashMap();
		Map<String, String> item2 = new HashMap();
		item1.put("id", "1234");
		item1.put("nome", "teste");
		lista.add(item1);
		item2.put("id", "2345");
		item2.put("nome", "teste2");
		lista.add(item2);
		return ResponseEntity.ok(lista);
	}
	
	@Operation(summary = "Retorna o exemplo por Id")
	@GetMapping(path = "/exemplos/{id}")
	public ResponseEntity<String> getExemploId(@PathVariable("id") int id) {
		
		return ResponseEntity
				.ok()
				.header("Content-Type", "application/json").body("Exemplo -> " + id);
	}
	
	@Operation(summary = "Atualiza um exemplo por Id")
	@PutMapping(path = "/exemplos/{id}")
	public ResponseEntity<String> getExemploIdParam(@PathVariable("id") int id, @RequestParam("nome") String nome) {
		
		return ResponseEntity
				.ok()
				.header("Content-Type", "application/json").body("Exemplo -> " + id + "nome -> " +nome);
	}
	
	@Operation(summary = "Insere objeto")
	@PostMapping(path = "/host/new/{id}") //id é para ser o endereço IPv4
	public ResponseEntity<String> postHostIdParam(@PathVariable("id") int id, @RequestParam("nome") String nome)
	{
		return ResponseEntity
				.ok()
				.header("Content-Type", "application/json")
				.body("Objeto -> " + id + " nome -> " + nome + " criado");
	}
	
	@Operation(summary = "Remove objeto")
	@DeleteMapping(path = "/host/delete/{id}") // id é para ser o endereço IPv4
	public ResponseEntity<String> deleteHostById(@PathVariable("id") int id) {
		
		// Teste pra simular as duas situações de remoção
	    boolean removido = false;
//		boolean removido = true;
		
	    if (removido) {
	        return ResponseEntity.ok("Host com ID " + id + " removido com sucesso!");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Host com ID " + id + " não encontrado.");
	    }
	}

}