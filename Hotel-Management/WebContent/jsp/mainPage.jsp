<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MainPage</title>
 <script>

  window.history.forward(1);

</script>
<%	HttpSession sUser = request.getSession(true);
	String UserId = (String)sUser.getAttribute("UserId");
	sUser.setAttribute("UserId",UserId);
	if(sUser.getAttribute("UserId") == null) 
	{
 		response.sendRedirect ("./logout.jsp");
	  }
%>
<SCRIPT LANGUAGE=javascript> 

function onrefresh()
{
    window.parent.tBanner.document.location.reload();
    window.parent.sMenu.document.location.reload();
    window.parent.body.document.location.reload();
}
</script>
</head>
<FRAMESET rows="110,*">
	<FRAME src="./topbanner.jsp" scrolling="auto" name="tBanner" frameborder="1" >
	<FRAMESET cols="23%,*" frameborder="no" onload="onrefresh()">
		<FRAME src="./submenu.jsp" scrolling="auto" name="sMenu" frameborder="1">
		<FRAME src="./Welcome.jsp" scrolling="auto" name="body" frameborder="1">
	</FRAMESET>
	<NOFRAMES>
	<BODY onload="onrefresh()">
	</BODY>
	</NOFRAMES>
</FRAMESET>
</html>