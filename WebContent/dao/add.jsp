<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Bitter&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Bitter', serif;
	font-size: 24px;
}
</style>
</head>

<body bgcolor="#c89f84">

	
	<form method="post" action="../AddManual">
	
		<table align="left" width=100% border="1">
			<tr>
				<td width=100% colspan="2">��ܤ���G<input type="date" id="eindate" name="eindate"
					min="2010-01-01" max="2025-12-31" value="2019-10-15" required>
			<tr>
				<td width=50%>���B�G<input type="number" min="1" id="totalprice" name="totalprice" required>
			<tr>
				<td width=50%>���O�G<select id="sortID" name="sortID" required>
						<option value="1">����
						<option value="2">��q
						<option value="3">��`�ͬ�
						<option value="4">�T��
						<option value="5">����
						<option value="6">��L
				</select>
			<tr>
				<td width=100% colspan="2">�Ƶ��G<textarea style="width:300px;height:100px;" id="note" name="note" ></textarea>
			<tr>
				<td width=100% colspan="2"><input type="submit" value="�T�w�s�W" id="s1">
		</table>
	</form>
		
		<!--  <script type="text/javascript">
		    $(document).ready(function(){
		        $("#s1").click(function(){ 
		            var date=$("#eindate").val();
		            var price=$("#totalprice").val();
		            var sort=$("#sortID").val();
		            var n=$("#note").val();
		            
		            $.post("../AddManual", {"eindate":date , "totalprice":price, "sortID":sort, "note":n}, function(data){ 
		               
		                alert(data);
		                
		           
		            });
		        });
		        
		    });
		</script>-->
		
	
	
</body>

</html>