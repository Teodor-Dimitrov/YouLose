<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body bgcolor="lightgreen">
<jsp:include page="header.jsp" />
<table >
		<td>
			<a href="main.jsp">Home</a><br><br>
			<a href="profile.jsp">My profile</a><br><br>
			<a href="forLater.jsp">Watch later</a><br><br>
			<a href="watched.jsp">Watched</a><br><br>
			<a href="liked.jsp">Liked</a><br><br>
			<a href="subscriptions.jsp">Subscriptions</a><br><br>
		</td>
		<td>
			<img src="image/<%session.getAttribute("username"); %>">
			<h1><%session.getAttribute("username"); %></h1></br>
			<h3>Change profile picture:</h3>
	<form method="POST" enctype="multipart/form-data">
		<input type="file" id="profilePic" name="profilePicture" accept="image/*">
		<input type="submit" value="Upload">
	</form></br>
	<form action="../changeUsername" method="post">
		<h3>Change username:</h3>
		<input type="submit" value="Change">
	</form>
	<form action="../changeEmail" method="post">
		<h3>Change e-mail:</h3>
		<input type="submit" value="Change">
	</form>
	<form action="../changePassword" method="post">
		<h3>Change password:</h3>
		<input type="submit" value="Change">
	</form>
		</td>
	</table>
</body>
</html>