package br.edu.iff.ccc.bsi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.iff.ccc.bsi.entities.Task;
import br.edu.iff.ccc.bsi.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest
{
	@InjectMocks
	private TaskService taskService;
	
	@Mock
	private TaskRepository taskRepo;
	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("Busca por Id em TaskService com suceso")
	void testFindById()
	{
		//cenário
		Task mockedTask = new Task(1L, "Task1", "Task d", true);
		
		//Deepseek mandou colocar isso
		// Configura o comportamento do mock do TaskRepository
	    when(taskRepo.findById(1L)).thenReturn(Optional.of(mockedTask));
	    
		//ação
		Optional<Task> result =taskService.findById(1L);
		
		//verificação
		assertNotNull(result);
		assertEquals("Task1", result.get().getName());
		assertEquals("Task d", result.get().getDescription());
		assertEquals(true, result.get().isCompleted());
		assertEquals(mockedTask.hashCode(), result.hashCode());
		verify(taskRepo).findById(1L);
	}
}
