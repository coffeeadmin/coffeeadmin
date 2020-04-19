<%@ include file="/WEB-INF/jsp/tags.jsp" %>
<table class="menuTable">
<tr><td>
<div class="menuLink">
  <a href="viewWorks.htm"><spring:message code="home" /></a>
  <a href="viewUsers.htm"><spring:message code="managers" /></a>
  <a href="viewContacts.htm"><spring:message code="contacts" /></a>
  <a href="viewWorker.htm"><spring:message code="workers" /></a>
  <a href="viewGroups.htm"><spring:message code="groups" /></a>
  <a href="viewReport.htm"><spring:message code="reports" /></a>
  <a href="viewLogin.htm?logout=true"><spring:message code="sign.out" /></a>
</div>
</td></tr>
</table>
