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
				<td width=100% colspan="2">��ܤ���G
				<input  type="month" id="eindate1"
					min="2010-01" max="2025-12" value="2019-10">~
				<input  type="month" id="eindate2"
					min="2010-01" max="2025-12" value="2019-10">
			<tr>
				<td width=50%>���B�G<select id="totalprice">
						<option value="-1">
						<option value="0~999">0~999
						<option value="1000~4999">1000~4999
						<option value="5000~9999">5000~9999
						<option value="10000�H�W">10000�H�W
				</select>
				<td width=50%>���O�G<select id="sortID">
						<option value="-1">
						<option value="1">����
						<option value="2">��q
						<option value="3">��`�ͬ�
						<option value="4">�T��
						<option value="5">����
						<option value="6">��L
				</select>
			<tr>
				<td width=100% colspan="2">
				<input type="submit" value="���d��" id="s1"> 
				<input type="submit" value="�Ϫ�d��" id="s2">
		</table>
	
		<script type="text/javascript">
		    $(document).ready(function(){
		        $("#s1").click(function(){ 
		            var date1=$("#eindate1").val();
		            var date2=$("#eindate2").val();
		            var price=$("#totalprice").val();
		            var sort=$("#sortID").val();
		            
		            
		            $.post("../RegistRecep", {"eindate1":date1 , "eindate2":date2, "totalprice":price, "sortID":sort}, function(data){ //�����Ȱe��control (�s��session��)
		            	$("#d1").html(data)
		           
		                //alert(data);
		            });
		        });
		        
		    });
		</script>
		
	<div id="d1">
	�d�߮榡�w��
	<table border='1'>
		<tr>
		<td>���</td><td>���B</td><td>����</td><td>�Ƶ�</td><td>�ާ@</td>
		<tr>
		
	</table>
	
	</div>
	
</body>
</html>