<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SingIn</title>
<SCRIPT LANGUAGE="Javascript">
function add()
{
	if(document.frm.txtuserName.value==""){
		
		document.frm.txtuserName.focus();
		alert("Enter User Name");
		return false;
	}
	else if(document.frm.txtpassword.value==""){
		
		document.frm.txtpassword.focus();
		alert("Enter Password");
		return false;
	}else{
		
		document.frm.action="../LoginServlet";
        document.frm.submit();
		return true;
	} 	
}
function on_cancel(){
  
	document.frm.action="./SignIn.jsp";
	document.frm.submit();


}
function isSpclCharLoginName(){

var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";

for (var i = 0; i < document.frm.txtuserName.value.length; i++) {
    if (iChars.indexOf(document.frm.txtuserName.value.charAt(i)) != -1) {
    alert ("The Login Name has special characters. \nThese are not allowed.\n");
    return false;
        }
    }
} 
function isSpclCharPWD(){

var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";

for (var i = 0; i < document.frm.txtpassword.value.length; i++) {
    if (iChars.indexOf(document.frm.txtpassword.value.charAt(i)) != -1) {
    alert ("The Password has special characters. \nThese are not allowed.\n");
    return false;
        }
    }
}   
</SCRIPT>
<%! 
    private String checkNull(String value) {
    	if(value=="null" || value==null)
    	{return "";}
    	return value;
    }
%>

<%	
	String logoff=request.getParameter("logoff");
	HttpSession sMsg = request.getSession();
	String msg = (String)sMsg.getAttribute("msg");
    if((logoff!=null) && (logoff.equals("invalidate")))
    {     
         sMsg.removeAttribute("msg");
         response.sendRedirect("./SignIn.jsp");
    }        
    HttpSession sUser = request.getSession(true);
    String UserId = (String)sUser.getAttribute("UserId");
    sUser.setAttribute("UserId",UserId);
	String url = request.getQueryString();

%>
</head>
<body>
<form name="frm" method="post" >
<INPUT type="hidden" name="url" value="<%=url%>">
<tr><td align="center"><FONT size=2 color=red><%= checkNull(msg)%></FONT></td></tr>
<table width="446px" align="center"	bgcolor="#efefef">

<tr bgcolor="#0000FF"><td><b>SiginIn</b></td> <td bgcolor="#FF0000" align="right"><a href=ForgotPassword.jsp target='_top'><b><font color="#FFFFFF">NewUser?</font></b></a></td></tr>
<tr>
		<td><b>User Name</b></td>
		<td bgcolor=""><input type="text" name="txtuserName" value="" size="23" ></td>
	</tr>
	<tr>
		<td><b>Password</b></td>
		<td><input type="password" name="txtpassword" value="" size="23" ></td>
	</tr>
	<tr>
	<td></td><td><BUTTON style="WIDTH: 70px" type="submit"  value=Save name=cmdSave onclick="add()">SignIn</BUTTON>
	<BUTTON type="button" tabindex="11" style="width: 70px" name="btnCancel" value="Cancel"  onclick="on_cancel()">Cancel</BUTTON>
	</td>
</tr>
	<tr><td><a href=ForgotPassword.jsp target='_top'><B>ForgotPassword</B></a></td></tr>
</table>
</form>
</body>
</html>