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
<title><spring:message code="works" /></title>

<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <form method="POST" action="<c:url value="/Works.htm"/>">
    <table class="contents">
      <tr>
	<td colspan="3" rowspan="0"><spring:message code="work" /></td>
	
      </tr>
      <tr>
	<td><spring:message code="desc" /></td>
	<td>
	  
	  <spring:bind path="command.idwork">
	  
	  <input type=hidden name="idwork" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  
	  <spring:bind path="command.content">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  
	  <input type=text name="content" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  
	</td>
	
	
	
      </tr>
      <tr>
	<td><spring:message code="manager" /></td>
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
	<td><spring:message code="contact" /></td>
	<td>
	  
	  
	  <spring:bind path="command.idcontact.idcontact">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><br>
	  <select name="idcontact.idcontact">
	    <c:if test="${status.value == 0}"><option value="" selected><spring:message code="sel.contact" /></option></c:if>
	      <c:forEach var="contact" items="${contacts}">
	    <option value="<c:out value="${contact.idcontact}"/>" 
	      <c:if test="${contact.idcontact == status.value}"> selected</c:if>>    
	      <c:out value="${contact.fname}"/> <c:out value="${contact.lname}"/>
	      </option>  
	      </c:forEach>
	  </select>
	  </spring:bind>
	  
	  
	  
	</td>
      </tr>
      <tr>
	<td><spring:message code="init.date.text" /></td>
	<td>
	  <spring:bind path="command.init">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  
	  <input type=text name="init" 
	  <c:choose>
	  <c:when test="${command.idwork == null}">
	  value="<c:out value="${idate}"/>"/>
	  </c:when> 
	  <c:otherwise>
	  value="<c:out value="${status.value}"/>"/> 
	  </c:otherwise>
	  </c:choose> 
	  
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
      <tr>
	<td><spring:message code="status" /></td>
	<td>
	  <spring:bind path="command.status">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="status" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  
	</td>
      </tr>
      
      <tr>
	<td></td>
	<td>
	  <spring:message code="work.files" />
	</td>
      </tr>
    <td>
      <span><spring:message code="work.this" /></span><br>
      <spring:bind path="command.works_workers">
      <input type="hidden" name="<c:out value ="_${status.expression}"/>"/>
      <select name="<c:out value ="${status.expression}"/>" multiple >
	<c:forEach items="${worker}" var="workers">
	<option value="<c:out value ="${workers.idworker}" />"
	  <c:forEach items="${command.works_workers}" var="worker">
	  <c:if test="${workers.idworker == worker.idworker}"> selected</c:if>
	  </c:forEach>>
	  <c:out value ="${workers.fname}"/> <c:out value ="${workers.lname}"/> 
	  </option>
	  </c:forEach>
      </select>
      </spring:bind>
      
    </td>
    <td>
      <spring:bind path="command.work_files">
      <input type="hidden" name="<c:out value ="_${status.expression}"/>"/>
      <c:forEach items="${command.work_files}" var="works_files">
      <input type="hidden" name="<c:out value ="${status.expression}"/>" value="<c:out value="${works_files.name}"/>"/>
      </c:forEach>
      </spring:bind>
      
      <c:if test="${command.idwork != null}">
      <div class="scroll">
      <c:forEach items="${command.work_files}" var="works_files">
      <c:out value="${works_files.name}"/><br>
      </c:forEach>
      </div>
      </c:if>
    </td></tr>
    <tr>
      <td colspan="2">
	<input type="hidden" name="_page" value="<c:out value="${currentPage}"/>"/>
	<c:if test="${command.idwork != null}">
	<input type="submit" class="button" name="_target1" value="<spring:message code="work.files.a.e" />" />
	<input type="submit" class="button" name="_target2" value="<spring:message code="mail.send" />" />
	</c:if>
	 
	<input type="submit" class="button" name="_finish" value="<spring:message code="save" />">
	</form>
	<button class="button" onClick="window.location='<c:url value="/viewWorks.htm"/>'"><spring:message code="cancel" /></button>
      </td></tr>
    </table>
    
    
    
    <!-- ends container table-->
  </td></tr>
</table>
<!--  -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"/>

