<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/UserList.css">
	<title>User List</title>
</head>
	<body>
		<h1 class = "UserList">ユーザー一覧</h1>
		<p class = "position"><a href ="UserEntryServlet" class = "position">新規登録</a></p>
		<table class = "out">
			<tr>
				<td>${userInfo.name}</td>
				<td><a href = "LogoutServlet">ログアウト</a></td>
			</tr>
		</table>
		<form action = "UserListServlet" method = "post" action = "LoginServlet" method = "post">
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
			<td class = "UserList"><input type = "submit" value = "検索"></td>
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
				<tr>
			</tr>
				<c:forEach var = "use" items = "${userList}">
				<input type = "hidden" name = "id" id = {use.id}>
				<tr>
					<td>${use.loginId}</td>
                     <td>${use.name}</td>
                     <td>${use.birthDate}</td>
					<td>
					<c:choose>
					<c:when test = "${userInfo.id == 1}">
						<a href="UserDetailServlet?id=${use.id}"><button type="button">詳細</button></a>
						<a href="UserUpdateServlet?id=${use.id}"><button type="button">更新</button></a>
						<a href="UserDeleteServlet?id=${use.id}"><button type="button">削除</button></a>
					</c:when>
					<c:when test = "${use.id == userInfo.id}">
						<a href="UserDetailServlet?id=${use.id}"><button type="button">詳細</button></a>
						<a href="UserUpdateServlet?id=${use.id}"><button type="button">更新</button></a>
					</c:when>
					<c:otherwise>
						<a href="UserDetailServlet?id=${use.id}"><button type="button">詳細</button></a>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</form>
	</body>
</html>