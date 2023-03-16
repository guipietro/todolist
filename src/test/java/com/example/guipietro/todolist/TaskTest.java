package com.example.guipietro.todolist;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class TaskTest {

	@Test
	@Description("it should thrown an exception when due date less than create date")
	public void givenDueDateThrownAnException() {
		assertThatThrownBy(() -> new Task(1L, "Do my homework", "Must do my homework until tomorrow",
				Instant.parse("2023-03-13T11:52:00Z"), Instant.parse("2023-03-12T11:52:00Z"), "NOT_STARTED"))
				.isInstanceOf(IllegalStateException.class).hasMessageContaining("Due date less than create date!");
	}

}
