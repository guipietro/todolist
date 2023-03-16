package com.example.guipietro.todolist;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Description;

public class GetTaskByIdServiceTest {
	
	private final TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
	
	@Test
	@Description("It should return a Task by given Id")
	public void getTaskById() {
		// given
		Task task = new Task(1L, "Do my homework", "Must do my homework until tomorrow",
				Instant.parse("2023-03-13T11:52:00Z"), Instant.parse("2023-03-15T11:52:00Z"), "NOT_STARTED");
		TaskRepository taskRepository = new TaskRepositoryMemory();
		taskRepository.save(task);
		GetTaskByIdService getTaskByIdService = new GetTaskByIdService(taskRepository);
		// when
		Task savedTask = getTaskByIdService.execute(1L);
		// then
		assertThat(savedTask).isEqualTo(task);
	}
	
	@Test
	@Description("It should thrown an exception if the task does not exists")
	void givenIdThrownAnException() {
		//given
		GetTaskByIdService getTaskByIdService = new GetTaskByIdService(taskRepository);
		//when, then
		when(taskRepository.findId(anyLong())).thenReturn(false);
		assertThatThrownBy(() -> getTaskByIdService.execute(anyLong())).isInstanceOf(IllegalStateException.class);
	}
}
