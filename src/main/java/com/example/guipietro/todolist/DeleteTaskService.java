package com.example.guipietro.todolist;

import org.springframework.beans.factory.annotation.Autowired;

public class DeleteTaskService {

	private final TaskRepository taskRepository;

	@Autowired
	public DeleteTaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public boolean execute(Long id) {
		return this.taskRepository.delete(id);
	}
	
}
