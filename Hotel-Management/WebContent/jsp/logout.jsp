<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<script>

  window.history.forward(1);

</script>
<%

HttpSession sUser = request.getSession(true);
String UserId = (String)sUser.getAttribute("UserId");
sUser.setAttribute("UserId",UserId);


try
{
	session.invalidate();
	response.sendRedirect("./SignIn.jsp");
	
}
catch (Exception e)
{
	e.printStackTrace();
}
%> 

</body>
</html>