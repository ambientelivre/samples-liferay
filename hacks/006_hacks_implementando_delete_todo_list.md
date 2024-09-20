## Hacks - Implementando Delete Todo List

### TaskService
``` java
public static void deleteTask(int index){
  if(index >= 0 && index < tasks.size()){
    tasks.remove(index);
  }
}
```

### TodoListPortlet.java
``` java
@Override
public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException {

	String action = ParamUtil.getString(actionRequest, ActionRequest.ACTION_NAME);

	if (action.equals("addTask")) {
		String taskDescription = ParamUtil.getString(actionRequest, "task");
		if (taskDescription != null && !taskDescription.trim().isEmpty()) {
			TaskService.addTask(new Task(taskDescription));
		}
	} else if (action.equals("deleteTask")) {
		int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
		TaskService.deleteTask(taskIndex);
	}
}
```

### View.jsp
``` jsp
<div class="buttons">
	<aui:form method="post" action="${portletURL}" style="display:inline;">
		<aui:input type="hidden" name="javax.portlet.action" value="deleteTask" />
		<aui:input type="hidden" name="taskIndex" value="${status.index}" />
		<aui:button type="submit" value="Delete" />
	</aui:form>
</div>
```