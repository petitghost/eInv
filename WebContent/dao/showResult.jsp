<%@page import="dbValue.SortId"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dbValue.SortId" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
<table border="1" width="70%">
	<tr><td>日期</td><td>金額</td><td>種類</td><td>備註</td><td>操作</td>
<c:forEach var="pt" items="${data}">
	<tr>
	  <td><c:out value="${pt.eindate}" /></td>
	  <td><c:out value="${pt.totalprice}" /></td>
	  <td><c:out value="${pt.sortName}" /></td>
	  <td><c:out value="${pt.note}" /></td>
	  <td>
	  	<button onclick="myupdate('${pt.einnumber}', '${pt.eindate}', '${pt.totalprice}', '${pt.sortId}', '${pt.note}')">Update</button>
	  	<!--<button onclick="myupdate('${pt}')">Update</button>-->
	  	<button onclick="mydelete('${pt.einnumber}', '${pt.sourceId}')">Delete</button>
	  </td>	  
	</tr>
</c:forEach>
</table>

<script>
	function myupdate(id, date, price, sortId, note){
		
		var iheight = 250;
		var iwidth = 250;
		var iTop = (window.screen.availHeight- iheight) / 2;
	    var iLeft = (window.screen.availWidth - iwidth) / 2;
	    var windowStyle = 'top=' + iTop + ',left=' + iLeft + ',height=' + iheight + ',width=' + iwidth + 
			',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no';
		 
		window.open('update.jsp?einnumber=' + id + 
						'&eindate=' + date + 
						'&totalprice=' + price + 
						'&sortId=' + sortId + 
						'&note=' + note, +
						'&characterEncoding=UTF-8', 
					'win', 
					windowStyle);
	   //new_open.focus();
	   //new_open.document.fm.note.value=price;
	   //document.getElementById("Text1").value = Agrs;
	};


   function mydelete(id, sourceId){
	   if(!confirm("確定刪除"))
	   	return
	   $.post("../DelEntry", {"einnumber":id, "sourceId":sourceId}, function(data){ 
		   //$("#d1").html(data)
		   alert(data)
   })};
</script>

<div id="d1"></div>
</body>
</html>