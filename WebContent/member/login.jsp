<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>enter1</title>
</head>
<body bgcolor="#c89f84">
	<table align="left" width=100% border="1">
		<tr>
			<td height=100% align="left"><font size=5>登入</font>
				<form method="post" action="../LoginServlet">
					<!-- c1.servlet -->
					<table align="left" width=100% border="1">
						<tr>
							<td width=20%><font size=5>帳號</font>
							<td width=80%><input type="text"
								style="width: 30%; height: 100%; font-size: 16px;" name="username"
								required>
						<tr>
							<td width=20%><font size=5>密碼</font>
							<td width=80%><input type="password"
								style="width: 30%; height: 100%; font-size: 16px;"
								name="password" required>
						<tr>
							<td ><input type="submit" style="width: 80px; height: 40px; font-size: 24px;" value="登入">
							
					</table>
				</form>
	</table>
</body>
</html>