<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=""UTF-8"">
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

<script type="text/javascript">
    $(document).ready(function(){    	
    	var id=request.getParameter("einnumber");
    	//var date=request.getParameter("eindate");
    	//var price=request.getParameter("totalprice");
    	//var sortid=request.getParameter("sortId");
    	//var note=request.getParameter("note");
    	
    	alert("sd")
        //$("#s1").click(function(){ 
        //});
        
    });
</script>


<body>
	<form id=fm name="fm" method="post" action="confirmup.jsp">
		<table align="left" width=100% border="1">
			<tr>
				<td>金額：<select name="totalprice">
						<option value="-1">
						<option value="0~999">0~999
						<option value="1000~4999">1000~4999
						<option value="5000~9999">5000~9999
						<option value="10000以上">10000以上
				</select>
			<tr>
				<td>類別：<select name="sortID">
						<option value="-1">
						<option value="1">飲食
						<option value="2">交通
						<option value="3">日常生活
						<option value="4">娛樂
						<option value="5">醫療
						<option value="6">其他
				</select>
			<tr>
				<td>備註：<input type="text" name="note">
			<tr>
				<td><input type="submit" onclick="closeWindow()" value="確定修改">
		</table>
	</form>
	
	
</body>
</html>