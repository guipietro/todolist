package com.example.guipietro.todolist;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateTaskService {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public CreateTaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public void execute(Task task) {
		this.taskRepository.save(task);
	}

}
