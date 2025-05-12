package br.edu.iff.ccc.bsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
