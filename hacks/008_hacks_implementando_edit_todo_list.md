## Hacks - Implementando Edit Todo List

### Task.java
``` java
private boolean editing;

public boolean isEditing() {
	return editing;
}

public void setEditing(boolean editing) {
	this.editing = editing;
}
```

### TaskService.java
``` java
public static void setTaskEditing(int taskIndex, boolean editing) {
	Task task = tasks.get(taskIndex);
	task.setEditing(editing);
}

public static void updateTaskDescription(int taskIndex, String newDescription) {
	Task task = tasks.get(taskIndex);
	task.setDescription(newDescription);
}
```

### TodoListPortlet.java
``` java
else if (action.equals("editTask")) {
	int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
	TaskService.setTaskEditing(taskIndex, true);
} else if (action.equals("saveTask")) {
	int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
	String newTaskDescription = ParamUtil.getString(actionRequest, "task");
	TaskService.updateTaskDescription(taskIndex, newTaskDescription);
	TaskService.setTaskEditing(taskIndex, false);
}
```

### View.jsp
``` jsp
<li class="task">
    <c:choose>
        <c:when test="${task.editing}">
             <!-- Formulario para editar a tarefa  -->
	 <aui:form method="post" action="${portletURL}" style="display:inline;">
	     <aui:input name="task" value="${task.description}" label="Editar Tarefa" />
	     <aui:input type="hidden" name="taskIndex" value="${status.index}" />
	     <aui:input type="hidden" name="javax.portlet.action" value="saveTask" />
	     <aui:button type="submit" value="Salvar" />
	     <aui:button type="button" value="Cancelar" onclick="window.location.href='${portletURL}'" />
            </aui:form>
        </c:when>
        <c:otherwise>
            <aui:form method="post" action="${portletURL}" style="display:inline;">
                <aui:input type="hidden" name="javax.portlet.action" value="toggleTaskCompletion" />
                <aui:input type="hidden" name="taskIndex" value="${status.index}" />
                <aui:input type="hidden" name="completed" value="${!task.completed}" />
	 <!-- Aqui, o valor enviado será verdadeiro ou falso baseado no estado da tarefa  -->
	     <input type="checkbox" name="completed" value="true" 
	         <c:if test="${task.completed}">checked</c:if> 
		onchange="this.form.submit();" />${task.description}
	</aui:form>

	<div class="buttons">
	    <aui:form method="post" action="${portletURL}" style="display:inline;">
	        <aui:input type="hidden" name="javax.portlet.action" value="deleteTask" />
	        <aui:input type="hidden" name="taskIndex" value="${status.index}" />
	        <aui:button type="submit" value="Delete" />
	    </aui:form>
	    <aui:form method="post" action="${portletURL}" style="display:inline;">
	        <aui:input type="hidden" name="javax.portlet.action" value="editTask" />
	        <aui:input type="hidden" name="taskIndex" value="${status.index}" />
	        <aui:button type="submit" value="Editar" />
	    </aui:form>
            </div>
        </c:otherwise>
    </c:choose>
</li>