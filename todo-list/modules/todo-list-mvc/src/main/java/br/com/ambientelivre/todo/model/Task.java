package br.com.ambientelivre.todo.model;

public class Task {
	private String description;
	private boolean completed;
	private boolean editing;
	
	public Task(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public boolean isEditing() {
		return editing;
	}
	
	public void setEditing(boolean editing) {
		this.editing = editing;
	}

}
