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

<title><spring:message code="file.up" /></title>
<script language="JavaScript">
<!--
function setForm(fileindex)
{

    if ( fileindex != null ){
	
    document.forms[0].encoding="text/html";
    document.forms[0].fileindex.value = fileindex;

    document.forms[0].submit(); 
	} else if (document.forms[0].file.value == "") {
     		
        alert("Please choose a file to upload");		
        }else {
    document.forms[0].encoding="multipart/form-data";

    document.forms[0].submit();
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
      <tr><td colspan="2"><p><spring:message code="file.up" /></p>
	<form method="POST" action="<c:url value="/Works.htm"/>" enctype="multipart/form-data">
	
	<input type="hidden" name="fileindex" value=""/>
      </td></tr>
      <c:forEach items="${files}" var="file" varStatus="status" >
      <tr><td>
	<c:out value="${file.name}"/></td><td><input type="button" class="button" name="_target1" onClick='javascript:setForm("<c:out value="${status.index}"/>");' value="<spring:message code="del.file" />" />
      </td></tr>        
      </c:forEach>
      <tr><td colspan="2">
	<input type="file" name="file" />
	<input type="hidden" name="_page" value="<c:out value="${currentPage}"/>"/>
      </td></tr> 
      <tr><td> 
	<input type="button" class="button" name="_target1" onClick='javascript:setForm();' value="<spring:message code="file.up" />" /></td><td>
	<input type="submit" class="button" name="_target0" value="<spring:message code="cancel" />" />
      </td></tr>  
      </form>
      <table>
	<!-- ends container table-->
	</td></tr>
      </table>
<!--  -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"/>
