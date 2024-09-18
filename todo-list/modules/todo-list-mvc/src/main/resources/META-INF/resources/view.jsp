<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-task">
 	<div class="new-task-container">
		<aui:form method="post" action="${portletURL}">
			<aui:input name="task" label="New Task"/>
			<aui:button type="submit" value="Add Task"/>

			<!-- Campo oculto que define a acao do portlet-->
			<aui:input type="hidden" name="javax.portlet.action" value="addTask" />
		</aui:form>
	</div>

	<ul class="tasks-list">
		<%-- Aqui voce exibira as tarefas --%>
		<c:forEach var="task" items="${tasks}" varStatus="status">
			<li class="task">
				<c:choose>
                	<c:when test="${task.editing}">
                    	<!-- Formulario para editar a tarefa -->
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
                
               				<!-- Aqui, o valor enviado será verdadeiro ou falso baseado no estado da tarefa -->
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
		</c:forEach>
	</ul>
</div>