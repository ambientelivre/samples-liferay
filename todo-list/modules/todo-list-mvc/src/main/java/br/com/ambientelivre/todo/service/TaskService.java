package br.com.ambientelivre.todo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ambientelivre.todo.model.Task;

public class TaskService {
	private static List<Task> tasks = new ArrayList<>();
	
	public static List<Task> getTasks(){
		return tasks;
	}
	
	public static void addTask(Task task) {
		tasks.add(task);
	}
	
	public static void deleteTask(int index) {
		if(index >= 0 && index < tasks.size()) {
			tasks.remove(index);
		}
	}
	
	public static void toggleTaskCompletion(int index, boolean completed) {
		if(index >= 0 && index < tasks.size()) {
			Task task = tasks.get(index);
			task.setCompleted(completed);
		}
	}
	
	public static void setTaskEditing(int taskIndex, boolean editing) {
		Task task = tasks.get(taskIndex);
		task.setEditing(editing);
	}
	
	public static void updateTaskDescription(int taskIndex, String newDescription) {
		Task task = tasks.get(taskIndex);
		task.setDescription(newDescription);
	}
}
