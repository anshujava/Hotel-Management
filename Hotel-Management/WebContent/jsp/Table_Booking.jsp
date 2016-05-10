<%@page import="java.util.ArrayList,common.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <LINK href="MainStyle.css" rel="stylesheet" type="text/css">
 <LINK href="Resources/flora.datepick.css" rel="stylesheet"type="text/css">
 <script language="javascript" src="Resources/jquery-1.4.2.js"></script>
 <script language="javascript" src="Resources/jquery.datepick.js"></script>
 <script language = "Javascript" src = "MainScript.js"></script>
<title>Table Booking</title>
<script>
function timepicker(){
	var d = new Date();
	d.setHours(d.getHours() + timepicker.h);
	var p = function(n){return ':' + (n < 10? '0' + n : n);},
	h = d.getHours(),
	m = p(d.getMinutes()),
	ampm = h >= 12? 'PM' : 'AM';
	h = h%12 || 12;
	h = h < 10? '\xa0' + h : h;
	document.forms[0].elements['txtTime'].value = h + m + ampm;
	timepicker.timer = setTimeout(timepicker, 1000);
	};
	timepicker.h = 0;
	timepicker.updown = function(n){
	clearTimeout(timepicker.timer);
	timepicker.h += n;
	timepicker();
	};
	window.onload = timepicker;
$(function() {
	$('#txtDate').datepick();
	
});
function save(){    
	 
   if(document.frm.txtName.value==""){
		alert("Enter Name");
		return false;
	}else if(document.frm.txtCustType.value==""){
		alert("Enter Customer Type");
		return false;
	}
	else if(document.frm.txtAdd.value==""){
		alert("Enter Address");
		return false;
	}else if(document.frm.txtPhoneNo.value==""){
		alert("Enter Contact No");
		return false;
	}else if(document.frm.txtEmail.value==""){
		alert("Enter Email ID");
		return false;
	}else if(document.frm.txtVehicleNo.value==""){
		alert("Enter Vehicle No");
		return false;
	}else if(document.frm.txtDate.value==""){
		alert("Enter Booking Date");
		return false;
	}else if(document.frm.txtTime.value==""){
		alert("Enter Booking Time");
		return false;
	}else if(document.frm.txtNoOfGuest.value==""){
		alert("Enter No Of Guest");
		return false;
	}else if(document.frm.txtTableType.value==""){
		alert("Enter Table Type");
		return false;
	}else if(document.frm.txtNoOfTables.value==""){
		alert("Enter No Of Tables");
		return false;
	}
   
	else{
		document.frm.action="../TableBookingServlet";
        document.frm.submit();
		return true;
	}
}	
function on_cancel(){
	  
	document.frm.action="./Table_Booking.jsp";
	document.frm.submit();
}
function on_CustomerType(){
	  
	document.frm.action="./Table_Booking.jsp";
	document.frm.submit();
}
function onCustomerType(){
	  
	document.getElementById('div1').style.display='none';
	document.getElementById('div2').style.display='none';
}
function showfield(name){
    if(name=='new')document.getElementById('div1').style.display="block";
    else document.getElementById('div1').style.display="none";
  }
function showfield2(name){
    if(name=='existing')document.getElementById('div2').style.display="block";
    else document.getElementById('div2').style.display="none";
  }
</script>
</head>
<body onload="onCustomerType()">
<%	HttpSession sUser = request.getSession(true);
	String UserId = (String)sUser.getAttribute("UserId");
	sUser.setAttribute("UserId",UserId);
	if(sUser.getAttribute("UserId") == null) 
	{
 		response.sendRedirect ("./logout.jsp");
	}
%>
<form name=frm method="post" >
<TABLE border=1 ID="TableDetails" style="background-color: #efefef; WIDTH: 500px; POSITION: absolute; TOP: 50px;">
<THEAD>
<tr>
<td colspan="7" align="center"><font size="3">Table Booking</font></td>
</tr>
</THEAD>
 <TBODY>
  <TR>
 <TD><FONT size=4 color=green><b>Personal Details:</b></FONT></TD></TR>
 <tr>
 <TD><FONT size=4 color=green><b>Customer Type</b></FONT></TD>
 <td><SELECT id="txtCustType" style="WIDTH: 163px" name="txtCustType"  tabindex="1" onchange="showfield(this.options[this.selectedIndex].value),showfield2(this.options[this.selectedIndex].value)"> 
 <OPTION  selected value="">Select Customer Type</OPTION>
 <OPTION  value="existing">Existing Customer</OPTION>
 <OPTION  value="new">New Customer</OPTION>                         
 </SELECT></td> </tr>
 <TR>
 <TD ><FONT size=4 color=green><B>Customer Name:</B></FONT></TD>
 <td><div id="div1"><INPUT id=txtName tabIndex=2 maxLength=50 name= txtName size="24" ></div>
 <div id="div2">
 <SELECT id="txtName" style="WIDTH: 163px" name="txtName"  tabindex="1" > 
 <OPTION  selected value="">Select Customer Name</OPTION>
<%
	UserDetail userdet = new UserDetail();
	ArrayList arrlist = new ArrayList();
	arrlist = userdet.getCustomer();	
	for(int i=0;i<arrlist.size();i++)
		{
		String tempArray2[] = new String[10];
		tempArray2 = (String[])arrlist.get(i);
		if((request.getParameter("txtName")!=null)&&(request.getParameter("txtName").trim().equalsIgnoreCase(tempArray2[0].trim()))){
			out.println("<OPTION value='"+tempArray2[1]+"' selected>"+tempArray2[0]+"</OPTION>");
         }else{
			out.println("<OPTION value='"+tempArray2[1]+"'>"+tempArray2[0]+"</OPTION>");
		}
	}	
%>                       
 </SELECT>
 </div>
 </TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Address:</B></FONT></TD>
 <td><INPUT id=txtAdd tabIndex=3 maxLength=50 name= txtAdd size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Contact Number:</B></FONT></TD>
 <td><INPUT id=txtPhoneNo tabIndex=4 maxLength=50 name= txtPhoneNo size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>E-Mail Id:</B></FONT></TD>
 <td><INPUT id=txtEmail tabIndex=5 maxLength=50 name= txtEmail size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Vehicle No:</B></FONT></TD>
 <td><INPUT id=txtVehicleNo tabIndex=6 maxLength=50 name= txtVehicleNo size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Booking Date:</B></FONT></TD>
 <td><INPUT id=txtDate tabIndex=7 maxLength=50 name= txtDate size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Booking Time:</B></FONT></TD>
 <td><INPUT id=txtTime tabIndex=8 maxLength=50 name= txtTime size="24" >
 <input type="button" value="/\" onclick="timepicker.updown(1);">
<input type="button" value="\/" onclick="timepicker.updown(-1);">
 </TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>No Of Guest:</B></FONT></TD>
 <td><INPUT id=txtNoOfGuest tabIndex=9 maxLength=50 name= txtNoOfGuest size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Table Type:</B></FONT></TD>
 <td><INPUT id=txtTableType tabIndex=10 maxLength=50 name= txtTableType size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>No Of Tables:</B></FONT></TD>
 <td><INPUT id=txtNoOfTables tabIndex=11 maxLength=50 name= txtNoOfTables size="24" ></TD></TR>
 </TBODY>
 <tr><td></td>
 <TD >
 <BUTTON  style="WIDTH: 70px" TABINDEX="11" type=button  value=save name=cmdsave onclick="save()" >Save</BUTTON>&nbsp;&nbsp; 
 <BUTTON  style="WIDTH: 70px" TABINDEX="12" type="button" value="Cancel" id="button" name="cmdCancel" ONCLICK="on_cancel()">Cancel</BUTTON>
 </TD>
 </tr>
</TABLE>
</form>
</body>
</html>