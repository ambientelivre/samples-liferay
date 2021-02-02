<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<p>
	<b><liferay-ui:message key="custommvc.caption"/></b>
</p>

User Name is : <b> ${userName}</b>

<portlet:defineObjects/>

<portlet:actionURL name="addName" var="addNameUrl"></portlet:actionURL>

<&nbsp;br>

<a href="${addNameUrl}">Add Name</a>