<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>SubMenu</title>
    <style>
    html, body {
    background:#efefef;
    margin: 0 0 0 0;
}

#window {
    height:600px;
    width: 1200px;
    margin: 20px auto 0 auto;
    padding: 0;
    background: white;
}

#nav_wrap {
    width: 170px; 
    height: 990px;  
    margin: 0; 
    position: absolute; 
    background-color: #efefef;
}

#navigation { font-size:0.75em; width:150px; }
#navigation ul { margin:0px; padding:0px; }
#navigation li { list-style: none; } 

ul.top-level { background:#666; }

ul.top-level li {
    border-bottom: #fff solid;
    border-top: #fff solid;
    border-width: 1px;
}

#navigation a {
    color: #fff;
    cursor: pointer;
    display:block;
    height:25px;
    line-height: 25px;
    text-indent: 10px;
    text-decoration:none;
    width:100%;
}

#navigation a:hover{ text-decoration:underline; }

#navigation li:hover {
    background: #f90;
    position: relative;
}

ul.sub-level { display: none; }

li:hover .sub-level {
    background: #999;
    border: #fff solid;
    border-width: 1px;
    display: block;
    position: absolute;
    left: 75px;
    top: 5px;
}

ul.sub-level li {
    border: none;
    float:left;
    width:150px;
}
    </style>
</head>
<%	HttpSession sUser = request.getSession(true);
	String UserId = (String)sUser.getAttribute("UserId");
	sUser.setAttribute("UserId",UserId);
	if(sUser.getAttribute("UserId") == null) 
	{
 		response.sendRedirect ("./logout.jsp");
	  }
%>
<body>    
<div id="window">
    <nav id="nav_wrap">
        <div id="navigation">
            <ul class="top-level">
                <li><a href="#">New Booking</a>
                <ul class="sub-level">
                        <li><a href="./Room_Booking.jsp" target='body'>Room-Booking</a></li>
                        <li><a href="./Table_Booking.jsp" target='body'>Table-Booking</a></li>
                    </ul>
                </li>
                
                <li><a href="./billing.jsp" target='body'>Billing</a></li>
                <li> <a href="./Cancel_Booking.jsp" target='body'>Cancel Booking</a></li>
                <li> <a href="./logout.jsp" target='body'>Logout</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>