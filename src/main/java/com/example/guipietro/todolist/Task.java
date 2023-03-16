package com.example.guipietro.todolist;

import java.time.Instant;

public class Task {
	
	private Long id;
	private String title;
	private String description;
	private Instant createDateTime;
	private Instant dueDateTime;
	private String status;
	
	public Task(Long id, String title, String description, Instant createDateTime, Instant dueDateTime, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createDateTime = createDateTime;
		this.setDueDateTime(dueDateTime);
		this.status = status;
	}
	
	public Task() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Instant createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Instant getDueDateTime() {
		return dueDateTime;
	}

	public void setDueDateTime(Instant dueDateTime) {
		if (dueDateTime.isBefore(this.createDateTime)) {
			throw new IllegalStateException("Due date less than create date!");
		}
		this.dueDateTime = dueDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
