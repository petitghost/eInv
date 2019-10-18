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
	  <td><button onclick="mydelete('${pt.einnumber}')">Delete</button></td>	  
	</tr>
</c:forEach>
</table>

<script>
   function mydelete(id){
	   alert(id);
   }
</script>

</body>
</html>