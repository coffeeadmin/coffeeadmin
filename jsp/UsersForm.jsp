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
<title><spring:message code="managers" /></title>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <form method="POST" action="<c:url value="/Users.htm"/>">
    <table class="contents">
      <tr>
	<td colspan="2" rowspan="0"><spring:message code="manager" /></td>
	
      </tr>
      <tr>
	<td><spring:message code="title" /></td>
	<td>
	  <spring:bind path="command.iduser">      
	  <input type=hidden name="iduser" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  <spring:bind path="command.title">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="title" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>      
	</td>
      </tr>
      <tr>
	<td><spring:message code="fname" /></td>
	<td>
	  <spring:bind path="command.fname">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="fname" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	</td>
      </tr>
      <tr>
	<td><spring:message code="lname" />|</td>
	<td>
	  <spring:bind path="command.lname">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="lname" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	</td>
      </tr>
      <tr>
	<td><spring:message code="depmt" /></td>
	<td>
	  <spring:bind path="command.depmt">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="depmt" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	</td>
      </tr>
      <tr>
	<td><spring:message code="corp" /></td>
	<td>
	  <spring:bind path="command.corp">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="corp" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	</td>
      </tr>
      <tr>
	<td><spring:message code="email" /></td>
	<td>
	  <spring:bind path="command.email">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=text name="email" value="<c:out value="${status.value}"/>"/>
	  </spring:bind>
	  
	</td>
      </tr>
      <tr>
	<td><spring:message code="pass" /></td>
	<td>
	  <spring:bind path="command.password">
	  <span class="errorMes"><c:out value="${status.errorMessage}"/></span><BR>
	  <input type=password name="password" value="<c:out value="${status.value}"/>"/>
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

