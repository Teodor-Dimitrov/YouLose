<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
</head>
<body bgcolor="lightgreen">
<%! boolean logged;
	String button1 = "Register";
	String button2 = "Log in";
	String button3 = "Upload";
	String link1 = "register.jsp";
	String link2 = "login.jsp";
	String link3 = "main.jsp";%>
	<% if(session.getAttribute("logged")!=null){
		logged = (Boolean) session.getAttribute("logged");
		if(logged){
			String button1 = "Register";
			String button2 = "Log in";
			String button3 = "Upload";
			String link1 = "register.jsp";
			String link2 = "login.jsp";
			String link3 = "login.jsp";
		}
		else{
			%><!--	button1 = (String)session.getAttribute("username");
			button2 = "Log out";
			button3 = "upload file";
			link1 = "profile.jsp";
			link2 = "main.jsp";
			link3 = "upload.jsp";--><% 
		}
	}
	%>
	<div align = "right">
	<% if (session.getAttribute("mail")!=null){ %>
	<%= session.getAttribute("mail") %>
	<% } %>
		<a href = "<%= link1%>" ><%= button1%></a>
		<a href = "<%= link2%>" ><%= button2%></a>
		<a href = "<%= link3%>" ><%= button3%></a>
	</div>
	
	<table>
	<tr>
	<td>
	<img src="youlose.png" alt="logo" style="width:75px;height:;">
	</td>
	<td>
	<font face="Helvetica Rounded Bold" size="7">YouLose</font>
	</td>
	<td>
	<form action="../search" method="post">
	<input type="submit" value = "Search">
	 <select name="searched" style="width: 150px;">
			<option value="1">VIDEO</option>
			<option value="2">PLAYLIST</option>
			<option value="3">USER</option>
	</select>
	</form>
	</td>
	</tr>
	</table>
	<hr>
	
</body>
</html>