package com.example.guipietro.todolist;

import org.springframework.beans.factory.annotation.Autowired;

public class UpdateTaskService {

	private final TaskRepository taskRepository;

	@Autowired
	public UpdateTaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task execute(Long id, Task task) {
		if (!this.taskRepository.findId(id)) {
			throw new IllegalStateException("Task not found!");
		}
		return this.taskRepository.update(id, task);
	}

}
