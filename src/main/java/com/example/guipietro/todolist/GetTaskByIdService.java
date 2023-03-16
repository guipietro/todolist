package com.example.guipietro.todolist;

import org.springframework.beans.factory.annotation.Autowired;

public class GetTaskByIdService {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public GetTaskByIdService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task execute(Long id) {
		if (!this.taskRepository.findId(id)) {
			throw new IllegalStateException("Task not found!");
		}
		return this.taskRepository.getTask(id);
	}

}
