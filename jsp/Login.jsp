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

<title><spring:message code="login.coffee" /></title>

<BODY>

<script language="JavaScript">
<!--
function setForm()
{
 if (document.forms[0].email.value == "" || document.forms[0].pass.value == "") {
     		
        alert("Please enter user name and password");		
        }else {
    document.forms[0].submit();
	}
	}
	
// -->
</script>

<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <div align="center">
    <form action="<c:url value="/viewLogin.htm"/>" method="POST">
    <table class="contents">
      
      <tr><td colspan="2">
	<spring:message code="login" />
      </td></tr>
      <tr><td colspan="2">
	<img src="images/cadminlogo.jpg"  alt="www.mexgrp.com/coffee"/>
      </td></tr> 
      <tr><td colspan="2">
	<c:choose>
	<c:when test="${failConn != null}">
	<span class="errorMes">There seems to be problems with your database conn/setup cause is:<span><br>
	<pre><c:out value="${message}"/></pre>
      </td></tr>
      </c:when> 
      <c:when test="${default != null}">
      There seems to be no allowed users on your db <br>
      please log in with default user<br>  
    </td></tr>
    </c:when> 
    <c:otherwise>
    <c:if test="${ invalid != null}"><span class="errorMes"><spring:message code="login.fail" /><span></c:if>
    
  </td></tr>
  </c:otherwise>
  </c:choose> 
  <tr><td><spring:message code="email" /></td><td><input type="text" name="email" size="15" ></td></tr>
  <tr><td><spring:message code="pass" /></td><td><input type="password" name="pass" size="15" ></td></tr>
  <tr><td colspan=2 align="center"><input type="submit" class="button" value="<spring:message code="login" />" /></td></tr>
</table>
</form>
</div>
<!-- ends container table-->
</td></tr>
</table>
<!--  -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"/>

