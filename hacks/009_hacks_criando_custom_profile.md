## Hacks - Criando um custom profile

### View.jsp
``` jsp
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
```
### Main.scss
```  css
.customProfile_container {
	display:flex;
	justify-content: flex-start;
	align-items: center;
	gap: 20px;
	flex-wrap: wrap;
	background: linear-gradient( 180deg, rgb(65, 184, 131) 0%, rgb(0, 212, 255) 100%);
	padding: 10px 0px 10px 10px;
}
.customProfile_avatar {  
	width: 80px;
	height: 80px;
	border-radius: 50%;
}
.customProfile_div {
	display: flex;
	flex-direction: column;
	align-content: center;
	justify-content: center;
	gap: 10px;
}
.customProfile_nameProfile, .customProfile_datefull{
	margin: 0;
}
```