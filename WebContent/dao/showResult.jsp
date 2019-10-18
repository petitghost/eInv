<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	  <td><c:out value="${pt.sortId}" /></td>
	  <td><c:out value="${pt.note}" /></td>
	  <td>
	  	<button onclick="myupdate('${pt.einnumber}', '${pt.eindate}', '${pt.totalprice}', '${pt.sortId}', '${pt.note}')">Update</button>
	  	<button onclick="mydelete('${pt.einnumber}', '${pt.sourceId}')">Delete</button>
	  </td>	  
	</tr>
</c:forEach>
</table>

<script>
	function myupdate(){
	   //String url = "update.jsp?einnumber=" + id + "&eindate=" + date + "&totalprice=" + price + "&sortId=" + sortid + "&note=" +  note; 
	   window.open('update.jsp', 'window', config='height=450,width=450,toolbar=no');
	   //new_open.focus();
	   //new_open.document.fm.note.value=price;
	};


   function mydelete(id, sourceId){
	  
	   $.post("../DelEntry", {"einnumber":id, "sourceId":sourceId}, function(data){ 
		   alert("確定刪除")
		   $("#d1").html(data)
   })};
</script>

<div id="d1"></div>
</body>
</html>