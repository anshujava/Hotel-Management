<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TopBanner</title>
</head>
<body>
<%	HttpSession sUser = request.getSession(true);
	String UserId = (String)sUser.getAttribute("UserId");
	sUser.setAttribute("UserId",UserId);
	if(sUser.getAttribute("UserId") == null) 
	{
 		response.sendRedirect ("./logout.jsp");
	  }
%>
<TABLE cellpadding="0" cellspacing="0" border="0" width=100% height="20" BGCOLOR="efefef">
<tr><td>
<img src="./images/2.png" width="500" height="90" /></td><td><img src="./images/3.gif" width="500" height="90"/>
</td>
</tr>
</TABLE>
</body>
</html>