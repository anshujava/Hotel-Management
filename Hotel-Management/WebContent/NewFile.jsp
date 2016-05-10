<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script type="text/javascript">

/* Time Picker ©2008 John Davenport Scheuer
   As first seen in http://www.dynamicdrive.com/forums/
   username:jscheuer1 - This notice must remain for legal use
   */

function timepicker(){
var d = new Date();
d.setHours(d.getHours() + timepicker.h);
var p = function(n){return ':' + (n < 10? '0' + n : n);},
h = d.getHours(),
m = p(d.getMinutes()),
s = p(d.getSeconds()),
ampm = h >= 12? 'PM' : 'AM';
h = h%12 || 12;
h = h < 10? '\xa0' + h : h;
document.forms[0].elements['timepick11'].value = h + m + s + ampm;
timepicker.timer = setTimeout(timepicker, 1000);
};
timepicker.h = 0;
timepicker.updown = function(n){
clearTimeout(timepicker.timer);
timepicker.h += n;
timepicker();
};
window.onload = timepicker;
</script>
</head>
<body>
<form action="#">
<div>
<input style="font-family:monospace;" size=11 type="text" name="timepick11">
<input type="button" value="/\" onclick="timepicker.updown(1);">
<input type="button" value="\/" onclick="timepicker.updown(-1);">
</div>
</form>
</body>
</html>