<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
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



<body bgcolor="#c89f84">

		<table align="left" width=100% border="1">
			<tr>
				<td width=100% colspan="2">選擇日期：
				<input  type="month" id="eindate1"
					min="2010-01" max="2025-12" value="2019-10">~
				<input  type="month" id="eindate2"
					min="2010-01" max="2025-12" value="2019-10">
			<tr>
				<td width=50%>金額：<select id="totalprice">
						<option value="-1">
						<option value="0~999">0~999
						<option value="1000~4999">1000~4999
						<option value="5000~9999">5000~9999
						<option value="10000以上">10000以上
				</select>
				<td width=50%>類別：<select id="sortID">
						<option value="-1">
						<option value="1">飲食
						<option value="2">交通
						<option value="3">日常生活
						<option value="4">娛樂
						<option value="5">醫療
						<option value="6">其他
				</select>
			<tr>
				<td width=100% colspan="2">
				<input type="submit" value="表格查詢" id="s1"> 
				<input type="submit" value="圖表查詢" id="s2">
		</table>
	
		<script type="text/javascript">
		    $(document).ready(function(){
		        $("#s1").click(function(){ 
		            var date1=$("#eindate1").val();
		            var date2=$("#eindate2").val();
		            var price=$("#totalprice").val();
		            var sort=$("#sortID").val();
		            
		            
		            $.post("../RegistRecep", {"eindate1":date1 , "eindate2":date2, "totalprice":price, "sortID":sort}, function(data){ //把欄位值送到control (存到session中)
		            	$("#d1").html(data)
		           
		                //alert(data);
		            });
		        });
		        
		    });
		</script>
		
	<div id="d1">
	查詢格式預覽
	<table border='1'>
		<tr>
		<td>日期</td><td>金額</td><td>種類</td><td>備註</td><td>操作</td>
		<tr>
		
	</table>
	
	</div>
	
</body>
</html>