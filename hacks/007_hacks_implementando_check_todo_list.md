## Hacks - Implementando Delete Todo List

### Task.java
``` java
private boolean completed;

public boolean isCompleted() {
	return completed;
}

public void setCompleted(boolean completed) {
	this.completed = completed;
}
```

### TaskService.java
``` java
public static void toggleTaskCompletion(int index, boolean completed) {
	if(index >= 0 && index < tasks.size()) {
		Task task = tasks.get(index);
		task.setCompleted(completed);
	}
}
```

### TodoListPortlet.java
``` java
else if (action.equals("toggleTaskCompletion")) {
	int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
	boolean completed = ParamUtil.getBoolean(actionRequest, "completed");
 	TaskService.toggleTaskCompletion(taskIndex, completed);
}
```