<%@ include file="/init.jsp" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
    // Não precisamos redefinir `locale` e `user`, pois eles já estão disponíveis no Liferay
   
    // Obter a data atual
    Calendar c = Calendar.getInstance();
    Date data = c.getTime();

    // Formatar a data de acordo com o locale do usuário
    DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, locale); 
    String datefull = f.format(data);

    // Obter a URL do retrato do usuário
    String userPortraitURL = user.getPortraitURL(themeDisplay);
%>  

<div class='customProfile_container'>
    <div>
        <img class='customProfile_avatar' src="<%=userPortraitURL%>" alt="<%=user.getFirstName()%>">
    </div>
    <div class='customProfile_div'>
        <h4 class='customProfile_nameProfile'>
            <liferay-ui:message key="welcome" />, 
            <%=user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName()%>
        </h4>
        <p class='customProfile_datefull'>
            <liferay-ui:message key="today-is" /> <%=datefull%>.
        </p>		
    </div>	
</div>
