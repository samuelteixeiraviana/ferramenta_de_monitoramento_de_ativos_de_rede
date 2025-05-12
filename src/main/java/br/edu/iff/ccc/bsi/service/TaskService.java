package br.edu.iff.ccc.bsi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.entities.Task;
import br.edu.iff.ccc.bsi.repository.TaskRepository;

@Service
public class TaskService 
{
	@Autowired
	private TaskRepository TaskRep;
	
	public Optional<Task> findById(long id)
	{
		Optional<Task> task = TaskRep.findById(id);
		return task;
	}
}
