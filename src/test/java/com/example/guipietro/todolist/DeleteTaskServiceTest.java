package com.example.guipietro.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class DeleteTaskServiceTest {

	@Test
	@Description("It should delete a task by given Id")
	public void DeleteTask() {
		// given
		Task task = new Task(1L, "Do my homework", "Must do my homework until tomorrow",
				Instant.parse("2023-03-13T11:52:00Z"), Instant.parse("2023-03-15T11:52:00Z"), "NOT_STARTED");
		TaskRepository taskRepository = new TaskRepositoryMemory();
		taskRepository.save(task);
		
		DeleteTaskService deleteTaskService = new DeleteTaskService(taskRepository);
		boolean b = deleteTaskService.execute(1L);
		assertThat(b).isTrue();
	}

}
