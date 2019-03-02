<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Answering Natural Language Question by subgraph matching | Registration </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script>
<script type="text/javascript">
function validate()
{ 
if( document.mobilenumbervalidation.mobileno.value == "" ||
isNaN( document.mobilenumbervalidation.mobileno.value) ||
document.mobilenumbervalidation.mobileno.value.length != 10 )
{
alert( "Please provide a Mobile No in the format 123." );
document.mobilenumbervalidation.mobileno.focus() ;
return false;
}
return true;
}
</script>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache ,no-store,must-revlidate"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<div class="reg-w3">
<div class="w3layouts-main">
	<h2>Register Now</h2>
		<form action="SaveServlet" method="post">
			<input type="text" class="ggg" name="name" placeholder="Insert full NAME" required="required">
			<input type="email" class="ggg" name="email" placeholder="E-MAIL" required="required">
			<input type="text" title="Enter Valid Mob No"  class="ggg" name="mobile" placeholder="PHONE" pattern="[7-9]{1}[0-9]{9}" required="required">
			<input type="password" class="ggg" id="confirnmPassword" name="password" placeholder="PASSWORD" required="required">
			<!-- <input type="password" class="ggg" name="password" placeholder="Confirm PASSWORD"  data-match="password" data-match-field="confirnmPassword" required="required"> -->
			<input type="text" class="ggg" name="dob" placeholder="DD-MM-YYYY" required="required">
			<label class="form-check-label" for="materialInline2">Gender</label><br>
		    <div>
		       <span><input type="radio" name="gender" value="male" required="required"> Male</span>   
		       <span><input type="radio" name="gender" value="female" required="required"> Female</span>
		    </div>
		    <br><br>
			
				<div class="clearfix"></div>
				<input type="submit" value="submit" name="register">
		</form>
		<p>Already Registered.<a href="login.jsp">Login</a></p>
</div>
</div>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
