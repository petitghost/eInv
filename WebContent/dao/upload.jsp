<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>�W���ɮ�</title>
<link href="https://fonts.googleapis.com/css?family=Bitter&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Bitter', serif;
	font-size: 24px;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.8.3.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#submit").click(function() {
			 $.get("http://10.10.2.122:8080/eInvoiceProject/upload",function(data){
                 alert(data);
            });

		});
	});
</script>
</head>
<body>
	<form method="POST" enctype="multipart/form-data"
		action="../UploadCsv">
		<!-- c4.servlet -->
		�W��CSV�ɮ�:<input type="file" name="file1" size="30" /> 
		<input id="submit" type="submit" name="submit" value="����">
		<!-- ���椧��g��alert��ܦ��\�Υ��� -->
		<input type="reset" name="reset" value="���m">
	</form>
</body>
</html>