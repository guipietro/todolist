package com.example.guipietro.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class UpdateTaskStatusServiceTest {
	
	@Test
	@Description("It should update the status of the task")
	public void updateTaskStatus() {
		//given
		Task task = new Task(1L, "Do my homework", "Must do my homework until tomorrow",
				Instant.parse("2023-03-13T11:52:00Z"), Instant.parse("2023-03-15T11:52:00Z"), "NOT_STARTED");
		TaskRepository taskRepository = new TaskRepositoryMemory();
		taskRepository.save(task);
		UpdateTaskStatusService updateTaskStatusService = new UpdateTaskStatusService(taskRepository);
		//when
		Task updatedTask = updateTaskStatusService.execute(task.getId(), "IN_PROGRESS");
		//then
		assertThat(updatedTask.getStatus()).isEqualTo("IN_PROGRESS");
	}
}
