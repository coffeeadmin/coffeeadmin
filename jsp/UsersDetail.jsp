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
<title><spring:message code="det.managers" /></title>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
	<!-- starts contents table-->
<c:forEach items="${user}" var="user">
<script language="JavaScript">
<!--
function delItems(){
    var sure = window.confirm("delete with their dependencies ?");
	 if (sure == true){       
         window.location = '<c:url value="/viewUsers.htm"/>?iduser=<c:out value="${user.iduser}"/>&del=true'
      }}
// -->
    </script>
    <table class="contents">
      <tr>
	
	<td colspan="2" rowspan="0"><spring:message code="det.managers" /></td>
	
      </tr>
      <tr>
	<td><spring:message code="title" /></td>
	<td><c:out value="${user.title}"/></td>
      </tr>
      <tr>
	<td><spring:message code="fname" /></td>
	<td><c:out value="${user.fname}"/></td>
      </tr>
      <tr>
	<td><spring:message code="lname" /></td>
	<td><c:out value="${user.lname}"/></td>
      </tr>
      <tr>
	<td><spring:message code="depmt" /></td>
	<td><c:out value="${user.depmt}"/></td>
      </tr>
      <tr>
	<td><spring:message code="corp" /></td>
	<td><c:out value="${user.corp}"/></td>
      </tr>
      <tr>
	<td><spring:message code="email" /></td>
	<td><c:out value="${user.email}"/></td>
      </tr>
      <tr>
	<td></td>
	<td></td>
      </tr>
      <tr>
	<td colspan="2"><button class="button" onClick="window.location='<c:url value="/Users.htm"/>?iduser=<c:out value="${user.iduser}"/>'"><spring:message code="edit.managers" /></button>
	<button class="button" onClick='javascript:delItems();'><spring:message code="del.manager" /></button>
   <button class="button" onClick='javascript:history.back();'><spring:message code="cancel" /></button>  
  </td>
      </tr>
    </table>
    </c:forEach>
    <!-- ends container table-->
  </td></tr>
</table>
<!--  -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"/>

