package com.example.guipietro.todolist;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryMemory implements TaskRepository{

	List<Task> tasks = new ArrayList<Task>();
	
	@Override
	public void save(Task task) {
		this.tasks.add(task);
		
	}

	@Override
	public Task getTask(Long id) {
		
		for (Task task : this.tasks) {
			if (task.getId() == id) {
				return task;
			}
		}
		return null;
	}
	
	@Override
	public boolean findId(Long id) {
		for (Task task : this.tasks) {
			if (task.getId() == id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Task update(Long id, Task task) {
		Task value = this.getTask(id);
		value.setTitle(task.getTitle());
		value.setCreateDateTime(task.getCreateDateTime());
		value.setDescription(task.getDescription());
		value.setDueDateTime(task.getDueDateTime());
		value.setStatus(task.getStatus());
		return value;
	}

	@Override
	public boolean delete(Long id) {
		Task value = this.getTask(id);
		return this.tasks.remove(value);
	}
	
	

}
