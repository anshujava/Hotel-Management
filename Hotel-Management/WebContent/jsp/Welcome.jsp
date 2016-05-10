<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
isThreadSafe="false"
isErrorPage="false"
session="true"
autoFlush="true"
%>
<%! 
       public void jspInit() {
       
       }
%>
<%

	response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
	
	response.setHeader("Pragma","no-cache"); // HTTP 1.0
	
	response.setDateHeader ("Expires", 0); // Prevents caching at the proxy server...

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%	HttpSession sUser = request.getSession(true);
	String UserId = (String)sUser.getAttribute("UserId");
	sUser.setAttribute("UserId",UserId);
	if(sUser.getAttribute("UserId") == null) 
	{
 		response.sendRedirect ("./logout.jsp");
	  }
%>
<TITLE>welcome.jsp</TITLE>
</HEAD>

<SCRIPT LANGUAGE=javascript>
function on_refresh()
{
    window.parent.tBanner.document.location.reload();
    window.parent.sMenu.document.location.reload();
   // window.parent.frames("tBanner").
}
</SCRIPT>
<BODY onload="on_refresh()">
<TABLE align='center' border='0' BGCOLOR="efefef">
	<TR>
		<TD>&nbsp;</TD>
	</TR>
	<TR>
		<TD>&nbsp;</TD>
	</TR>
	<TR>
		<TD>&nbsp;</TD>
	</TR>
	<TR>
		<TD>&nbsp;</TD>
	</TR>
    <TR>
        <TD>
            <H1 align=center style="color: green; font-family: Times New Roman">Welcome</H1>
    </TD></tr>
  <tr>  <TD>
		<H1 align=center style="color: green; font-family: Times New Roman">To</H1>
			</TD>
	</TR>
         <tr>  <TD>
		<H1 align=center style="color: green; font-family: Times New Roman">Hotel</H1>
			</TD>
	</TR>
	
	<TR>
		<TD align=center><FONT size=2><i></i> </FONT>
		</TD>
	</TR>
	<Tr>
		<TD>&nbsp;
		<img src="./images/1.jpg" width="500" height="90" /></td><td><img src="./images/3.gif" width="500" height="90"/>
		</TD>
	</Tr>
	
	</TABLE>
	
	</BODY>
	
	</HTML>
