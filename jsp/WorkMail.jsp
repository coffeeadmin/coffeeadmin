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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<title><spring:message code="mail.send" /></title>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <table class="contents">
      
      <form method="post" action="<c:url value="/Works.htm"/>" >
      <input type="hidden" name="_page" value="<c:out value="${currentPage}"/>"/>
      <input type="hidden" name="send" value=""/>
      <tr>
	<td>
	  <spring:message code="mail.manager" />
	</td>
	<td>
	  <input type="checkbox" name="mailbx" value="usermail" />
	</td>
      </tr>
      
      <tr>
	<td>
	  <spring:message code="mail.contact" />
	</td>
	<td>
	  <input type="checkbox" name="mailbx" value="contactmail" />
	</td>
	<tr>
	  <td>
	    <spring:message code="mail.workers" />
	  </td>
	  <td>
	    <input type="checkbox" name="mailbx" value="workermail" />
	  </td>
	</tr>
	
	<tr>
	  <td>
	    <spring:message code="mail.files" /> 
	  </td>
	  <td>
	    <input type="checkbox" name="mailbx" value="filesmail" />
	  </td>
	</tr>
	<tr>
	  <td colspan="2">
	    <spring:message code="mail.subject" />
	  </td>
	</tr>
	<tr>
	  <td colspan="2">
	    <input type="text" size="30" name="subject" value="a new work has arrived..." />
	  </td>
	</tr>
	<tr>
	  <td colspan="2">
	    <TEXTAREA name="body" rows="3" cols="40"><c:out value="${command.content}"/></TEXTAREA>
	  </td>
	</tr>
	<tr>
	  <td colspan="2">
	    <input type="submit" class="button" name="_target0" value="<spring:message code="cancel" />" />
	    <input type="submit" class="button" name="_target0" value="<spring:message code="mail.send" />" />
	    </form>
	  </td>
	</tr>
	
      </table>
      <!-- ends container table-->
    </td></tr>
  </table>
  <!--  -->
  <jsp:include page="/WEB-INF/jsp/foot.jsp"/>
