<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script  src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>

<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Mono&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Roboto Mono', monospace;
	font-size: 24px;
}
</style>
</head>



<body>
	
		<table align="left" width=100% border="0" style="font-size:14px;">
			
			<tr>
				<td><p id="date" style="font-size:16px;"></p> <!-- <input type="text"  id="date" readonly="readonly">--> 
				
			
			<tr>
				<td>金額：<input type="text" id="totalprice">
				
			<tr>
				<td>類別：<select id="sortID">
						<option value="-1">
						<option value="1">飲食
						<option value="2">交通
						<option value="3">日常生活
						<option value="4">娛樂
						<option value="5">醫療
						<option value="6">其他
				</select>
			<tr>
				<td>備註：<textarea style="width:300px;height:100px;" id="note"> </textarea>
			<tr>
				<td><input type="submit" value="修改" id="s1"> 
		</table>
	
	
<div id="d1"></div>	
	


<script type="text/javascript" charset="utf8">
	$(document).ready(function(){
		<%
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("UTF-8"); 
		
	   
	    String id=request.getParameter("einnumber"); 
	    String date=request.getParameter("eindate"); 
	    String price=request.getParameter("totalprice"); 
	    String sortId=request.getParameter("sortId"); 
	    String note=(String)request.getParameter("note"); 
	    %>
	    
	  
	    	document.getElementById("date").innerHTML = "<%=date%>"
	    	$("#totalprice").val(<%=price%>)
	    	$("#sortID").val(<%=sortId%>)
	    	$("#note").val("<%=note%>") 
	    	
	    	if(<%=sortId%>=="0")
	    		document.getElementById("totalprice").readOnly=true
	    	 
    	
	    	
	    $("#s1").click(function(){ 
	    	
	        var price=$("#totalprice").val();
	        var sort=$("#sortID").val(); 
	        var note=$("#note").val();          
	       
	        
		    	$.post("../UpdateEntry", {"einnumber": "<%=id%>", "totalprice":price, "sortID":sort, "note":note}, function(data){ 
	        		$("#d1").html(data)
		        	//alert(data)
	        	});
		    	
		    	window.close();
   		});
	    
	});
   	
 
</script>


</body>
</html>