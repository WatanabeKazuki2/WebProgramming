<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/UserList.css">
	<title>User List</title>
</head>
	<body>
		<h1 class = "UserList">ユーザー一覧</h1>
		<p class = "position"><a href ="UserEntryServlet" class = "position">新規登録</a></p>
		<table class = "out">
			<tr>
				<td>ユーザー名</td>
				<td><a href = "LogoutServlet">ログアウト</a></td>
			</tr>
		</table>
		<form action = "UserListServlet" method = "post">
			<table class = "style">
				<tr>
					<td>ログインID</td>
					<td><input type = "text" name = "loginId"  loginId= "ログインID"></td>
				</tr>
				<tr>
					<td>ユーザー名</td>
					<td><input type = "text" name = "userName" userName = "ユーザー名"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type ="date" name ="birthDate" birthDate = "生年月日">～<input type ="date"  name = "birthDate2" bithdate2 = "生年月日"></td>
				</tr>
			</table>
			<table border = "1" class = style>
			<thead>
				<tr>
					<th>ログインID</th>
					<th>ユーザー名</th>
					<th>生年月日</th>
					<th></th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var = "user" items = "${userList}">
				<tr>
					<td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.birthDate}</td>
					<td>
						<a href="UserDetailServlet?id=${userList}"><input type="submit" value="詳細"></a>
						<a href="UserUpdateServlet?id=${userList}"></a><input type="submit" value = "更新">
						<a href="UserDeleteServlet?id=${userList}"></a><input type="submit" value = "削除">
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			<p class = "position"><input type = "submit" value = "検索"></p>
		</form>
	</body>
</html>