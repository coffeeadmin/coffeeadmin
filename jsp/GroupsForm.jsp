<jsp:include page="/WEB-INF/jsp/top.jsp"/>
  <!------------------------------------------------------------------------------------->
  <!--                      CoffeeAdmin Project   				       -->
  <!-- 										       -->
  <!-- ========================================================================	       -->
  <!-- 										       -->
  <!--  Copyright (C) 2007 CoffeeAdmin Project. All rights reserved.		       -->
  <!-- 										       -->
  <!--  This file may be distributed and/or modified under the terms of the	       -->
  <!--  GNU Lesser General Public License version 2.1 as published by the Free	       -->
  <!--  Software Foundation and appearing in the file LICENSE.txt included	       -->
  <!--  in the packaging of this software.					       -->
  <!-- 										       -->
  <!-- 										       -->
  <!--  This software is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING	       -->
  <!--  THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR	       -->
  <!--  PURPOSE. See the GNU Lesser General Public License for more details.	       -->
  <!-- 										       -->
  <!--  appserver1 (at) yahoo.com 						       -->
  <!--  http://www.mexgrp.com/coffee 						       -->
  <!-- 										       -->
  <!-- 										       -->
  <!-- ========================================================================	       -->
  <!------------------------------------------------------------------------------------->
<%@ include file="/WEB-INF/jsp/tags.jsp" %>
<title><spring:message code="groups" /></title>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <form method="POST" action="<c:url value="/Groups.htm"/>">
    
    <table class="contents">
      <tr>
	<td colspan="2" rowspan="0"><spring:message code="a.e.group" /></td>
      </tr>
      <tr>
	<td><spring:message code="group.name" /></td>
	<td>
	  
	  <spring:bind path="command.idgroup">
	  
	  <input type=hidden name="idgroup" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  
	  <spring:bind path="command.description">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="description" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  <tr>
	    <td>
	      <spring:message code="manager" /> (req)
	    </td>
	    <td>
	      <spring:bind path="command.iduser.iduser">
	      <span class="errorMes"><c:out value="${status.errorMessage}"/></span><br> 
	      <select name="iduser.iduser">
		<c:if test="${status.value == 0}"><option value="" selected><spring:message code="sel.manager" /></option></c:if>
		  <c:forEach var="user" items="${users}">
		<option value="<c:out value="${user.iduser}"/>" 
		  <c:if test="${user.iduser == status.value}"> selected</c:if>>    
		  <c:out value="${user.fname}"/> <c:out value="${user.lname}"/>
		  </option>  
		  </c:forEach>
	      </select>
	      </spring:bind>
</td>
	   </tr>
	         <tr>
	<td colspan="2">
	<input type="submit" class="button"  value="<spring:message code="save" />">
	</form>
	<button class="button" onClick='javascript:history.back();'><spring:message code="cancel" /></button>
		      </td>
	  </tr>
	 </table>
	<!-- ends container table-->
      </td></tr>
    </table>
    <!--  -->
    <jsp:include page="/WEB-INF/jsp/foot.jsp"/>
    
