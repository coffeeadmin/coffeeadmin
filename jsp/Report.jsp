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
function setReport()
{
var bol = true
var val
for(var i = 0; i < document.forms[0].rname.length ; i++) {
		if(document.forms[0].rname[i].checked) {
	         
                 val = document.forms[0].rname[i].value
		  bol = false
   }   }
 if (bol){
      alert("<spring:message code="alert.reports" />")
      }else{
        
         document.forms[0].action = '<c:url value="/Report.htm"/>?rname=' + val
	 document.forms[0].submit()   
	
      }}	
function clear(){
    document.forms[0].reset()
    }	
	
// -->
</script>

</head>
<BODY onLoad='javascript:clear();'>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<!-- starts container table-->
<table class="container">
  <tr><td align="center">
    <!-- starts contents table-->
    <table class="contents">
      <tbody>
      <tr>
	<td colspan="2">
	  <spring:message code="reports" />
	</td>
      </tr>
      <tr>
	<td>
	  <form method="GET" >
	  
	  <input type="radio" name="rname" value="date"/></td><td><spring:message code="by.date" /> 
	  </td></tr>  
	  <tr>
	    <td>
	      <input type="radio" name="rname" value="user"/></td><td><spring:message code="by.manager" /> 
	      </td></tr>  
	      <tr>
		<td>
		  <input type="radio" name="rname" value="contact"/></td><td><spring:message code="by.contact" /> 
		  </td></tr>  
		  <tr>
		    <td>
		      <input type="radio" name="rname" value="worker"/></td><td><spring:message code="by.worker" /> 
		      </td></tr>  
<tr>
		    <td>
		      <input type="radio" name="rname" value="group"/></td><td><spring:message code="by.group" /> 
		      </td></tr>
		      <tr>
			<td colspan="2">
			  <button class="button" onClick='javascript:setReport();'> <spring:message code="next" /> > </button>
			  
			  </form>
			</td>
		      </tr>
		      
		      </tbody>
		    </table>
		    <!-- ends container table-->
		  </td></tr>
		</table>
		<!--  -->
		<jsp:include page="/WEB-INF/jsp/foot.jsp"/>

