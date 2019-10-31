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
				<td width=100% colspan="2">選擇日期：<input type="date" id="eindate" name="eindate"
					min="2010-01-01" max="2025-12-31" value="2019-10-15" required>
			<tr>
				<td width=50%>金額：<input type="number" min="1" id="totalprice" name="totalprice" required>
			<tr>
				<td width=50%>類別：<select id="sortID" name="sortID" required>
						<option value="1">飲食
						<option value="2">交通
						<option value="3">日常生活
						<option value="4">娛樂
						<option value="5">醫療
						<option value="6">其他
				</select>
			<tr>
				<td width=100% colspan="2">備註：<textarea style="width:300px;height:100px;" id="note" name="note" ></textarea>
			<tr>
				<td width=100% colspan="2"><input type="submit" value="確定新增" id="s1">
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