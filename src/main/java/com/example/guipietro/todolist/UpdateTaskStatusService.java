package com.example.guipietro.todolist;

import org.springframework.beans.factory.annotation.Autowired;

public class UpdateTaskStatusService {

	private final TaskRepository taskRepository;

	@Autowired
	public UpdateTaskStatusService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task execute(Long id, String status) {
		Task task = this.taskRepository.getTask(id);
		task.setStatus(status);
		return this.taskRepository.update(task);
	}

}
