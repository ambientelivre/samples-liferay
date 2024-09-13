<%@ include file="/init.jsp" %>

	<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


		<p>User Name is : <strong> ${userName}</strong></p>

		<portlet:defineObjects />

		<portlet:actionURL name="addName" var="addNameUrl"></portlet:actionURL>

		<form action="${addNameUrl}" method="post">
			<input name="<portlet:namespace/>userName" type="text" placeholder="Adicione um nome" />
			<br>
			<div class=buttons>
				<input type="submit" value="Adicionar Nome" />
				<a href="${addNameUrl}" class="clear">Limpar campo</a>
			</div>
		</form>