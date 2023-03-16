package com.example.guipietro.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class CreateTaskServiceTest {

	@Test
	@Description("It shold create a task")
	public void createTask() {
		// given
		Task task = new Task(1L, "Do my homework", "Must do my homework until tomorrow",
				Instant.parse("2023-03-13T11:52:00Z"), Instant.parse("2023-03-15T11:52:00Z"), "NOT_STARTED");
		TaskRepository taskRepository = new TaskRepositoryMemory();
		CreateTaskService createTaskService = new CreateTaskService(taskRepository);
		// when
		createTaskService.execute(task);
		// then
		Task savedTask = taskRepository.getTask(1L);
		assertThat(savedTask).isEqualTo(task);
	}
}
