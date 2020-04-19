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
      alert("<spring:message code="alert.works" />")
      }else{
         var sure = window.confirm("<spring:message code="del.deps" />");
	 if (sure == true){       
         document.forms[0].action = '<c:url value="/viewWorks.htm"/>?del=true'
	 document.forms[0].submit()   
	}
      }}	
       // -->
</script>

<title><spring:message code="works" /></title>

<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<!-- container table-->
<%
  String pag = "";  
  String pagen = null; 
  int defSort = 0;
  pagen = (String)request.getAttribute("pageSortNum"); 
  pag =  "viewWorks.htm?pageSort=" + pagen;
  if(request.getAttribute("defSort") != null ){
   defSort = 2; 
 }
%>

<table class="container">
  <tr><td>
    <!--  -->
    <table width="100%">
      <tbody>
      <form method="POST" >
      <tr><td>
	<!-- starts display table-->
	<display:table name="works" id="work" class="displaytable"
        requestURI="<%=pag%>" export="true"  cellspacing="0"
	sort="external" partialList="true" size="size" 
	excludedParams="pageSort" defaultsort="<%=defSort%>" defaultorder="ascending">
	
      <td><display:column titleKey="select" media="html">
	<input type="checkbox" name="delItem" value="<c:out value="${work.idwork}"/>" />
	</display:column></td>
	
	<td><display:column titleKey="init.date" media="html" sortable="true" headerClass="sortable">
	  <a href="<c:url value="/viewWorks.htm"/>?idwork=<c:out value="${work.idwork}"/>"><c:out value="${work.init}"/></a>
	  </display:column></td>
	  <td><display:column property="init" titleKey="init.date"  media="csv excel pdf rtf xml"/></td>
	  <td><display:column property="iduser.fname" titleKey="manager" sortable="true" headerClass="sortable"/></td>
	  <td><display:column property="idcontact.fname" titleKey="contact"/></td>
	  <td><display:column property="status" titleKey="status" sortable="true" headerClass="sortable"/></td>
	  	  
	  </display:table>
	  <!-- ends display table-->
	  </td>
	</tr>
	
	<tr>      
	  <td align="center"><button class="button" onClick='javascript:delItems();'><spring:message code="del.works" /></button></form>
	    <button class="button" onClick="window.location='<c:url value="/Works.htm"/>'"><spring:message code="add.works" /></button>
	  </td>
	  
	</tr>
	
	</tbody>
      </table>
      
      <!-- ends container table-->
    </td></tr>
  </table>
  <!--  -->
  <jsp:include page="/WEB-INF/jsp/foot.jsp"/>

