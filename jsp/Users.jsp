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

<script language="JavaScript">
<!--
function checkAll(obj)
{
var bol = obj.checked;
count = document.forms[0].delItem.length;
for (i=0; i < count; i++) {
document.forms[0].delItem[i].checked = bol; 
}
}      

function delItems(){
if (document.forms[0].delItem.checked){
var bol = false
}else{
var bol = true
}

var val
for(var i = 0; i < document.forms[0].delItem.length ; i++) {
		if(document.forms[0].delItem[i].checked) {
	          bol = false
   }   }
 if (bol){
      alert("<spring:message code="alert.managers" />" )
      }else{
          var sure = window.confirm("<spring:message code="del.deps" />");
	 if (sure == true){
         document.forms[0].action = '<c:url value="/viewUsers.htm"/>?del=true'
	 document.forms[0].submit()   
	}
      }}	
       // -->
</script>

<title><spring:message code="managers" /></title>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- container table-->

<table class="container">
  <tr><td>
    <!--  -->
    <table width="100%">
      <tbody>
      <form method="POST" >
      <tr><td>
	<!-- starts display table-->
	<display:table name="users" id="user" class="displaytable" requestURI="" pagesize="15" export="true" defaultsort="1" defaultorder="ascending" cellspacing="0">
	
      <td><display:column titleKey="select" media="html">
	<input type="checkbox" name="delItem" value="<c:out value="${user.iduser}"/>" />
	</display:column></td>
	
	<td><display:column titleKey="fname" media="html" sortable="true" headerClass="sortable">
	  <a href="<c:url value="/viewUsers.htm"/>?iduser=<c:out value="${user.iduser}"/>"><c:out value="${user.fname}"/></a>
	  </display:column></td>
	  <td><display:column property="fname" titleKey="fname"  media="csv excel pdf rtf xml"/></td>
	  <td><display:column property="lname" titleKey="lname" sortable="true" headerClass="sortable"/></td>
	  <td><display:column property="depmt" titleKey="depmt"/></td>
	  <td><display:column property="email" titleKey="email" sortable="true" headerClass="sortable"/></td>
	  </display:table>
	  <!-- ends display table-->
	  </td>
	</tr>
	
	<tr>     
	  <td align="center"><button class="button" onClick='javascript:delItems();'><spring:message code="del.managers" /></button></form>
	    
	    <button class="button" onClick="window.location='<c:url value="/Users.htm"/>'"><spring:message code="add.managers" /></button>
	  </td>
	  
	</tr>
	
	</tbody>
      </table>
      
      <!-- ends container table-->
    </td></tr>
  </table>
  <!--  -->
  <jsp:include page="/WEB-INF/jsp/foot.jsp"/>

