<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>add1</title>
</head>
<body bgcolor="#c89f84">
	<table align="left" width=100% border="1">
		<tr>
			<td height=100% align="left"><font size=5>註冊</font>
				<form method="post"	action="../AddMember">
					<!-- c0.servlet -->
					<table align="left" width=100% border="1">
						<tr>
							<td width=20%><font size=5>帳號</font>
							<td width=80%><input type="text"
								style="width: 30%; height: 100%; font-size: 16px;"
								name="username" required>
						<tr>
							<td width=20%><font size=5>密碼</font>
							<td width=80%><input type="password"
								style="width: 30%; height: 100%; font-size: 16px;"
								name="password" required>
						<tr>
							<td width=20%><font size=5>信箱</font>
							<td width=80%><input type="email"
								style="width: 30%; height: 100%; font-size: 16px;" name="email"
								required>
						<tr>
							<td colspan="2" align="left"><input type="submit"
								style="width: 80px; height: 50px; font-size: 24px;" value="申請">
					</table>
				</form>
	</table>
</body>
</html>