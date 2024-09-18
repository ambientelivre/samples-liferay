package br.com.ambientelivre.todo.portlet;

import br.com.ambientelivre.todo.constants.TodoListPortletKeys;
import br.com.ambientelivre.todo.model.Task;
import br.com.ambientelivre.todo.service.TaskService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author ambientelivre
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.admin",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TodoList",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TodoListPortletKeys.TODOLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TodoListPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {
	    // Cria o URL do formulário
	    PortletURL portletURL = renderResponse.createActionURL();
	    
	    // Define a URL como atributo (não como String)
	    renderRequest.setAttribute("portletURL", portletURL);

	    // Passa a lista de tasks para o JSP
	    renderRequest.setAttribute("tasks", TaskService.getTasks());

	    // Chama o super para renderizar a view padrão
	    super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {

	    String action = ParamUtil.getString(actionRequest, ActionRequest.ACTION_NAME);
	    
	    //Adicionar uma tarefa
	    if (action.equals("addTask")) {
	        String taskDescription = ParamUtil.getString(actionRequest, "task");
	        if (taskDescription != null && !taskDescription.trim().isEmpty()) {
	            TaskService.addTask(new Task(taskDescription));
	        }
	    //Excluir tarefa
	    } else if (action.equals("deleteTask")) {
	        int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
	        TaskService.deleteTask(taskIndex);
	    //Marcar/desmarcar tarefa
	    } else if (action.equals("toggleTaskCompletion")) {
			int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
			boolean completed = ParamUtil.getBoolean(actionRequest, "completed");
			TaskService.toggleTaskCompletion(taskIndex, completed);
		//Editar tarefa
		} else if (action.equals("editTask")) {
	        int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
	        TaskService.setTaskEditing(taskIndex, true);
	    //Salvar tarefa editada
	    } else if (action.equals("saveTask")) {
	        int taskIndex = ParamUtil.getInteger(actionRequest, "taskIndex");
	        String newTaskDescription = ParamUtil.getString(actionRequest, "task");
	        TaskService.updateTaskDescription(taskIndex, newTaskDescription);
	        TaskService.setTaskEditing(taskIndex, false);
	    }
	}
}