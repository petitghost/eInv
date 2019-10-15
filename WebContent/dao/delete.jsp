<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

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
<body bgcolor="#c89f84">
	<table align="center" width=75% border="1">
			
			<tr>
				<td width=50%>金額：<input type="number" min="1" id="einnumber" required>
				
			
			<tr>
				<td width=100% colspan="2"><input type="submit" value="刪除" id="s1">
	</table>
	
	<script type="text/javascript">
	    $(document).ready(function(){
	        $("#s1").click(function(){ 
	            var number=$("#einnumber").val();
	            
	            
	            $.post("../DelEntry", {"einnumber":number }, function(data){ 
	               
	                alert(data);
	            });
	        });
	        
	    });
	</script>
	<p>
		<font size=5><b><a href="../../main.jsp">回主功能頁</a></b></font>
	</p>
</body>
</html>