<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username="";
String name="";
String phoneNumber="";
boolean exists=false;
String check=(String)request.getAttribute("check");
if(check!=null && check.equals("exists")){
	exists=true;
	username=request.getParameter("username");
	name=request.getParameter("name");
	phoneNumber=request.getParameter("phoneNumber");
}
%>
<form action="register" method="post">
<%if(exists){ %>
<font color="red">The username already exists</font><br><br>
<%} %> 
Username:<input type="text" name="username" value=<%=username %>><br><br>
Password:<input type="password" name="password"><br><br>
Full name:<input type="text" name="name" value=<%=name %>><br><br>
Phone number:<input type="text" name="phoneNumber" value=<%=phoneNumber %>><br><br>
<input type="submit" value="Register">
</form>
</body>
</html>