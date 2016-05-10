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
<title>Room Booking</title>
<script>
$(function() {
	$('#txtin').datepick();
	
});
$(function() {
	$('#txtout').datepick();
	
});
function save(){    
	 var inDT=document.frm.txtin.value;
	 var outDT=document.frm.txtout.value;
   if(document.frm.txtName.value==""){
		alert("Enter Name");
		return false;
	}
	else if(document.frm.txtadd.value==""){
		alert("Enter Address");
		return false;
	}else if(document.frm.txtemail.value==""){
		alert("Enter Email");
		return false;
	}else if(document.frm.txtstate.value==""){
		alert("Enter State");
		return false;
	}else if(document.frm.txtmobile.value==""){
		alert("Enter Mobile");
		return false;
	}else if(document.frm.txtin.value==""){
		alert("Enter In Date");
		return false;
	}else if(document.frm.txtout.value==""){
		alert("Enter Out Date");
		return false;
	}else if(document.frm.txtNoOfPerson.value==""){
		alert("Enter No Of Person");
		return false;
	}else if (document.getElementById("txtRoomType").value == ""){
		alert ("Please Enter Romm Type");
		return false;
	}else if(document.frm.txtNoOfRooms.value==""){
		alert("Enter No Of Rooms");
		return false;
	}else if (!isInteger(document.getElementById("txtNoOfRooms").value)){
		alert ("Please Enter Valid No Of Rooms");
		return false;
	}else if(document.frm.txtRoomNo.value==""){
		alert("Enter Room No");
		return false;
	}else if (!isInteger(document.getElementById("txtRoomNo").value)){
		alert ("Please Enter Valid Room No");
		return false;
	} else if(!datecompare(inDT,outDT)){
		alert("Out Date should not be lessthan In Date");  
		return false;
	}
	else{
		document.frm.action="../RoomBookingServlet";
        document.frm.submit();
		return true;
	}
}	
function on_cancel(){
	  
	document.frm.action="./Room_Booking.jsp";
	document.frm.submit();
}
function onRoomType(){
	 document.frm.action="./Room_Booking.jsp";
	 document.frm.submit();	 
}
function diffDates(){
	var d1 = new Date(document.frm.txtin.value);
	var d2 = new Date(document.frm.txtout.value);
	var timeDiff = d2.getTime() - d1.getTime();
	var DaysDiff = timeDiff / (1000 * 3600 * 24);
	if(DaysDiff==0){
		DaysDiff=1;
	}
	document.frm.txttotalDays.value=DaysDiff;
	var RoomPrice = document.frm.txtRoomPrice.value;
	var NoOfRooms = document.frm.txtNoOfRooms.value;
	var totalBilledAmnt=DaysDiff*RoomPrice*NoOfRooms;
	document.frm.txtBilledAmnt.value=totalBilledAmnt;
}
</script>
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
<form name=frm method="post" >
<TABLE border=1 ID="RoomDetails" style="background-color: #efefef; WIDTH: 710px; POSITION: absolute; TOP: 50px;">
<THEAD>
<tr>
<td colspan="7" align="center"><font size="3">Room Booking</font></td>
</tr>
</THEAD>
 <TBODY>
 <TR>
 <TD><FONT size=4 color=green><b>Room Types:</b></FONT></TD>
 <TD>
 <SELECT id="txtRoomType" style="WIDTH: 163px" name="txtRoomType" onchange="onRoomType()" tabindex="1" > 
 <OPTION  selected value="">Select Room Type</OPTION>
<%
    String type ="";
	UserDetail userdet = new UserDetail();
	ArrayList arrlist = new ArrayList();
	arrlist = userdet.RoomType();	
	for(int i=0;i<arrlist.size();i++)
		{
		String tempArray2[] = new String[10];
		tempArray2 = (String[])arrlist.get(i);
		if((request.getParameter("txtRoomType")!=null)&&(request.getParameter("txtRoomType").trim().equalsIgnoreCase(tempArray2[0].trim()))){
			out.println("<OPTION value='"+tempArray2[0]+"' selected>"+tempArray2[0]+"</OPTION>");
			type=tempArray2[0]; 
         }else{
			out.println("<OPTION value='"+tempArray2[0]+"'>"+tempArray2[0]+"</OPTION>");
		}
	}	
%>
                               
</SELECT>

 </TD>
 <TD ><FONT size=4 color=green><B>In Date:</B></FONT></TD>
 <td><INPUT id=txtin tabIndex=10 maxLength=50 name= txtin size="24" value="" readonly></TD>
 </TR>
 <TR>
 <TD ><FONT size=4 color=green><B>No Of Person:</B></FONT></TD>
 <td><INPUT id=txtNoOfPerson tabIndex=3 maxLength=50 name= txtNoOfPerson size="24" ></TD>
 
 <TD><FONT size=4 color=green><b>Out Date:</b></FONT></TD>
 <td><INPUT id=txtout tabIndex=11 maxLength=50 name= txtout size="24" readonly ></TD></TR>
 <TR>
 <TD><FONT size=4 color=green><b>Room No:</b></FONT></TD>
 <td>
 <select id="txtRoomNo" name="txtRoomNo" style="WIDTH: 165px" tabindex="2">
 <OPTION  selected >Select Room No</OPTION>
  <%
  String price ="";
  UserDetail userst = new UserDetail();
  ArrayList vSPEst = new ArrayList();
  vSPEst = userst.getRoomNO(request.getParameter("txtRoomType"));	
   for(int i=0;i<vSPEst.size();i++)
	{
	String tempArrayst[] = new String[10];
	tempArrayst = (String[])vSPEst.get(i);
	if((request.getParameter("txtRoomNo")!=null)&&(request.getParameter("txtRoomNo").trim().equalsIgnoreCase(tempArrayst[0].trim()))){
		out.println("<OPTION value='"+tempArrayst[0]+"' selected>"+tempArrayst[0]+"</OPTION>");
		price=tempArrayst[1];
      }else{
		out.println("<OPTION value='"+tempArrayst[0]+"'>"+tempArrayst[0]+"</OPTION>");
		price=tempArrayst[1];
	}
}	
%></select>
 </TD>
 <TD ><FONT size=4 color=green><B>No Of Rooms:</B></FONT></TD>
 <td><INPUT id=txtNoOfRooms tabIndex=3 maxLength=50 name=txtNoOfRooms size="24" ></TD>
 </TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Total Days</B></FONT></TD>
 <td><INPUT id=txttotalDays tabIndex=4 maxLength=50 name=txttotalDays size="24" ONBLUR="diffDates()" value=""></TD>
 </TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Room Price Per Day</B></FONT></TD>
 <td><INPUT id=txtRoomPrice tabIndex=4 maxLength=50 name=txtRoomPrice size="24" readonly="readonly" VALUE="<%=price%>"></TD>
 <TD><FONT size=4 color=green><b>Total Billed Amount</b></FONT></TD>
 <td><INPUT id=txtBilledAmnt tabIndex=5 maxLength=50 name=txtBilledAmnt size="24" readonly="readonly" value=""></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Name:</B></FONT></TD>
 <td><INPUT id=txtName tabIndex=4 maxLength=50 name=txtName size="24" ></TD>
 <TD><FONT size=4 color=green><b>Address:</b></FONT></TD>
 <td><INPUT id=txtadd tabIndex=5 maxLength=50 name=txtadd size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Email:</B></FONT></TD>
 <td><INPUT id=txtemail tabIndex=6 maxLength=50 name=txtemail size="24" ></TD>
 <TD><FONT size=4 color=green><b>State:</b></FONT></TD>
 <td><INPUT id=txtstate tabIndex=7 maxLength=50 name=txtstate size="24" ></TD></TR>
 <TR>
 <TD ><FONT size=4 color=green><B>Mobile:</B></FONT></TD>
 <td><INPUT id=txtmobile tabIndex=8 maxLength=50 name= txtmobile size="24" ></TD>
 <TD><FONT size=4 color=green><b>Land Line:</b></FONT></TD>
 <td><INPUT id=txtlandline tabIndex=9 maxLength=50 name= txtlandline size="24" ></TD></TR>
 
 
 </TBODY>
 <tr><td></td>
 <TD >
 <BUTTON  style="WIDTH: 70px" TABINDEX="12" type=button  value=save name=cmdsave onclick="save()" >Save</BUTTON>&nbsp;&nbsp; 
 <BUTTON  style="WIDTH: 70px" TABINDEX="13" type="button" value="Cancel" id="button" name="cmdCancel" ONCLICK="on_cancel()">Cancel</BUTTON>
 </TD>
 </tr>
<TR bgcolor="#d6d6d6">
 <TD nowrap><B>Room No</B></TD>
 <TD nowrap><B>Room Type</B></TD>
 <TD nowrap><B>Room Status</B></TD>
 <TD nowrap><B>Rent Per Day</B></TD>
 </TR>
 <TR>
 <%! 
private String checkNull(String value) {
if(value=="null" || value==null)
{return "";}
return value;
}
 %>
 <%     
    ArrayList arr=new ArrayList();
    UserDetail udet = new UserDetail();
    arr= udet.RoomDetails(request.getParameter("txtRoomType"));
    for(int i=0;i<arr.size();i++)
     {
     String temp[]=new String[4];
     temp = (String[])arr.get(i);
 %> 
 <TD nowrap="nowrap"><%=checkNull(temp[0])%></TD>
 <TD nowrap="nowrap"><%=checkNull(temp[1])%></TD>
 <TD nowrap="nowrap"><%=checkNull(temp[2])%></TD>
 <TD nowrap="nowrap"><%=checkNull(temp[3])%></TD>
 </TR>
 <%}%>
 
 </TABLE>
 
</form>
</body>
</html>