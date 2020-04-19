<jsp:include page="/WEB-INF/jsp/top.jsp"/>
  <!--=================================================================================-->
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
  <!--=================================================================================-->
<%@ include file="/WEB-INF/jsp/tags.jsp" %>
 


<title><spring:message code="det.works" /></title>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<c:forEach items="${work}" var="work">
<script language="JavaScript">
<!--
function delItems(){
var sure = window.confirm("<spring:message code="del.deps" />");
if (sure == true){       
window.location = '<c:url value="/viewWorks.htm"/>?idwork=<c:out value="${work.idwork}"/>&del=true'
}}
// -->
</script>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <table class="contents">
      <tr>
	
	<td colspan="2"><spring:message code="det.works" /></td>
	
      </tr>
      <tr>
	<td><spring:message code="desc" /></td>
	<td><c:out value="${work.content}"/></td>
	
      </tr>
      <tr>
	<td><spring:message code="manager" /></td>
	<td><c:out value="${work.iduser.fname}"/></td>
      </tr>
      <tr>
	<td><spring:message code="contact" /></td>
	<td><c:out value="${work.idcontact.fname}"/></td>
      </tr>
      <tr>
	<td><spring:message code="init.date" /></td>
	<td><c:out value="${work.init}"/></td>
      </tr>
      <tr>
	<td><spring:message code="end.date" /></td>
	<td><c:out value="${work.end}"/></td>
      </tr>
      <tr>
	<td><spring:message code="status" /></td>
	<td><c:out value="${work.status}"/></td>
      </tr>
      <tr>
	<td>
	  
	</td>
      </tr>
      
      <tr>
	<td>
	  <spring:message code="work.this" />
	</td>
	<td><spring:message code="work.files" /></td>
      </tr> 
      <tr><td>
	<div class="scroll">
	<c:forEach items="${work.works_workers}" var="works_workers">
	<c:out value="${works_workers.fname}"/>&nbsp;<c:out value="${works_workers.lname}"/><br>
	</c:forEach>
	</div>
      </td>
      <td>
	<div class="scroll">
	<c:forEach items="${work.work_files}" var="works_files">
	<a href="<c:out value="viewFile.htm?dload="/><c:out value="${works_files.name}"/>"><c:out value="${works_files.name}"/></a><br>
	</c:forEach>
	</div>
      </td></tr> 
      <tr>
	<td colspan="2" align="center"><button class="button" onClick="window.location='<c:url value="/Works.htm"/>?idwork=<c:out value="${work.idwork}"/>'"><spring:message code="work.ed.em" /></button>
	  <button class="button" onClick='javascript:delItems();'><spring:message code="del.works" /></button>
	  <button class="button" onClick='javascript:history.back();'><spring:message code="cancel" /></button></td>
	</tr>
      </table>
      <!-- ends container table-->
    </td></tr>
  </table>
  <!--  -->
  
  </c:forEach>
  <jsp:include page="/WEB-INF/jsp/foot.jsp"/>

