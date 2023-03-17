package com.example.guipietro.todolist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Description;

public class UpdateTaskServiceTest {

	private final TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
	private final Task taskMock = Mockito.mock(Task.class);

	@Test
	@Description("It should update the status of the task")
	public void updateTaskStatus() {
		// given
		Task task = new Task(1L, "Do my homework", "Must do my homework until tomorrow",
				Instant.parse("2023-03-13T11:52:00Z"), Instant.parse("2023-03-15T11:52:00Z"), "NOT_STARTED");
		TaskRepository taskRepository = new TaskRepositoryMemory();
		taskRepository.save(task);
		task.setStatus("IN_PROGRESS");
		UpdateTaskService updateTaskStatusService = new UpdateTaskService(taskRepository);
		// when
		Task updatedTask = updateTaskStatusService.execute(task.getId(), task);
		// then
		assertThat(updatedTask.getStatus()).isEqualTo("IN_PROGRESS");
	}

	@Test
	@Description("it should thrown an exception if the task not exists")
	void givenIdThrownAnException() {
		UpdateTaskService updateTaskService = new UpdateTaskService(taskRepository);
		when(taskRepository.findId(anyLong())).thenReturn(false);
		assertThatThrownBy(() -> updateTaskService.execute(anyLong(), taskMock))
				.isInstanceOf(IllegalStateException.class).hasMessageContaining("Task not found!");
	}

}
