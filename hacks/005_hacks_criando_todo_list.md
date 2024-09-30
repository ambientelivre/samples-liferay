## Hacks - Criando um todo list

### Task.java
``` java
private String description;

public Task(String description) {
  this.description = description;
}

public String getDescription() {
  return description;
}

public void setDescription(String description) {
  this.description = description;
}
```

### TaskService.java
``` java
private static List<Task> tasks = new ArrayList<>();

public static List<Task> getTasks() {
  return tasks;
}

public static void addTask(Task task) {
  tasks.add(task);
}
```

### TodoListPortlet.java
``` java
@Override
public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

	// Cria o URL do formulário
	PortletURL portletURL = renderResponse.createActionURL();
		
	// Define a URL como atributo (não como String)
	renderRequest.setAttribute("portletURL", portletURL);
	
	 // Passa a lista de tasks para o JSP
	renderRequest.setAttribute("tasks", TaskService.getTasks());

	 // Chama o super para renderizar a view padrão
	super.doView(renderRequest, renderResponse);
}

@ProcessAction(name = "addTask")
public void addTask(ActionRequest actionRequest, ActionResponse actionResponse) {
	
	String taskDescription = ParamUtil.getString(actionRequest, "task");
	TaskService.addTask(new Task(taskDescription));
}
```

### View.jsp
``` jsp
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-task">
 	<div class="new-task-container">
		<aui:form method="post" action="${portletURL}">
			<aui:input name="task" label="New Task"/>
			<aui:button type="submit" value="Add Task"/>

			<!-- Campo oculto que define a acao do portlet -->
			<aui:input type="hidden" name="javax.portlet.action" value="addTask" />
		</aui:form>
	</div>

	<ul class="tasks-list">
		<!-- Aqui voce exibira as tarefas  -->
		<c:forEach var="task" items="${tasks}" varStatus="status">
			<li class="task">${task.description}</li>
		</c:forEach>
	</ul>
</div>
```

### Main.scss
``` css
.container-task{
	padding: 1.25rem;
}
.new-task-container{
	padding: 1.25rem 0.625rem;
	border-radius: 5px;
	box-shadow: 0 15px 30px rgba(0, 0, 0, 0.3);
	width: 100%;
	margin: 0 auto;
}
.new-task-container button,
.buttons button {
	background: #222;
	color: #fff;
	border: none;
}
.new-task-container button:hover,
.buttons button:hover {
	background: #444;
	color: #fff;
}
.tasks-list {
	padding: 0.625rem;
	margin: 1.25rem auto 0;
	border-radius: 5px;
	box-shadow: 0 15px 30px rgba(0, 0, 0, 0.3);
	width: 100%;
}
.task{
	background-color: #B6124A;
	color: #fff;
	padding: 0.625rem;
	border-radius: 5px;
	margin-top: 5px;
	list-style: none;
	font-size: 1rem;
	display: flex;
	justify-content: space-between;
	align-items: center;
}
.buttons {
	display: flex;
	gap: 0.625rem;
	align-items: center;
}
```
