package com.example.guipietro.todolist;

public interface TaskRepository {

	public void save(Task task);
	
	public Task getTask(Long id);

	public boolean findId(Long id);
	
	public Task update(Long id, Task task);
	
	public boolean delete(Long id);
}
