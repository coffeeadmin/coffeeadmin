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

<title><spring:message code="reports" /></title>
<script language="JavaScript">
<!--
function getReport(bol)
{
 if(bol){ 
         //alert("gettin report");
         document.forms[0].action = '<c:url value="/Report.pdf"/>'
	 
	 document.forms[0].submit()   
	
	 }else{
	//alert("back")
	 window.location='<c:url value="/viewReport.htm"/>'
	}
      }	
// -->
</script>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <table class="contents">
      <tbody>
      
      
      <tr>
	<form method="POST">
	
	<c:choose>
	<c:when test="${rname == 'date' }">
	<td colspan="2">
	  <spring:message code="date" />     
	  <input type="hidden" name="rname" value="date"/>
	</td>  
	</c:when>
	<c:when test="${rname == 'user'}">
	<td colspan="2">
	  <spring:bind path="command.iduser.iduser">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><br>
	  <select name="iduser.iduser">
	    <option value="0" selected><spring:message code="sel.manager" /></option>
	      <c:forEach var="user" items="${users}">
	    <option value="<c:out value="${user.iduser}"/>"
	      <c:if test="${user.iduser == status.value}"> selected</c:if>>    
	      <c:out value="${user.fname}"/> <c:out value="${user.lname}"/>
	      </option>  
	      </c:forEach>
	  </select>
	  </spring:bind>
	  <input type="hidden" name="rname" value="user"/>
	</td>
	</c:when>
	
	<c:when test="${rname == 'contact'}">
	<td colspan="2">     
	  <spring:bind path="command.idcontact.idcontact">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><br>
	  <select name="idcontact.idcontact">
	    <option value="0" selected><spring:message code="sel.contact" /></option>
	      <c:forEach var="contact" items="${contacts}">
	    <option value="<c:out value="${contact.idcontact}"/>"
	      <c:if test="${contact.idcontact == status.value}"> selected</c:if>>    
	      <c:out value="${contact.fname}"/> <c:out value="${contact.lname}"/>
	      </option>  
	      </c:forEach>
	  </select>
	  </spring:bind>
	  <input type="hidden" name="rname" value="contact"/>
	</td>
	</c:when>
	<c:when test="${rname == 'worker'}">
	<td colspan="2">  
	  <spring:bind path="command.works_workers">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><br>
	  <select name="works_workers">
	    <option value="" selected><spring:message code="sel.worker" /></option>
	      <c:forEach var="worker" items="${workers}">
	    <option value="<c:out value="${worker.idworker}"/>"
	      <c:if test="${worker.idworker == command.works_workers[0].idworker}"> selected</c:if>>    
	      <c:out value="${worker.fname}"/> <c:out value="${worker.lname}"/> 
	      </option>  
	      </c:forEach>
	  </select>
	  </spring:bind>
	  <input type="hidden" name="rname" value="worker"/>
	</td>
	</c:when>
        <c:when test="${rname == 'group'}">
	<td colspan="2">
  	  <spring:bind path="command.iduser.users_groups">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><br>
	  <select name="iduser.users_groups">
	    <option value="" selected><spring:message code="sel.group" /></option>
	      <c:forEach var="group" items="${groups}">
	    <option value="<c:out value="${group.idgroup}"/>"
	      <c:if test="${group.idgroup == command.iduser.users_groups[0].idgroup}"> selected</c:if>>    
	      <c:out value="${group.description}"/>  
	      </option>  
	      </c:forEach>
	  </select>
	  </spring:bind>
	  <input type="hidden" name="rname" value="group"/>
	</td>
	</c:when>
	</c:choose>
      </tr>
      
      <tr>
	<td><spring:message code="init.date.text" /></td>
	<td>
	  <spring:bind path="command.init">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="init" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	</td>
      </tr>
      <tr>
	<td><spring:message code="end.date.text" /></td>
	<td>
	  <spring:bind path="command.end">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="end" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	</td>
      </tr>
       <tr><td colspan="2"><spring:message code="report.choose" /></td></tr>
      <tr><td colspan="2"><spring:message code="report.template" /></td></tr>
      <tr>
	<td><button class="button" onClick='javascript:getReport("true");'><spring:message code="get.report" /></button>
	  
	</td>
	</form>
	<td>
	  <button name="back" class="button" onClick='javascript:getReport();'><spring:message code="reports.home" /></button>
	</td>
      </tr>
      </tbody>
    </table>
    <!-- ends container table-->
  </td></tr>
</table>
<!--  -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"/>

