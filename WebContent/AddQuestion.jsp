<!--A Design by Fusion Project Centre

License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="com.dao.* " %>
<%@page import="java.sql.* " %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Answering Natural Language Question by subgraph matching |Add Question</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
    <script type="text/javascript">
        function addTextArea(){
            var div = document.getElementById('div_quotes');
            div.innerHTML += "<textarea name='new_quote[]'style='width:503px; height:38px;' />";
            div.innerHTML += "\n<br />";
        }
    </script>
    <script type="text/javascript">
            function Validate()
            { 
            	alert("in fun");
            	var tech=document.getElementById("ddlView").value;
            	var ques=document.getElementById("comment").value;
            	
            	if(tech==0){
            		alert("Please select Technology & add question");
            	}
            	elseif
            
            
//                
            }
        </script>
</head>
<body>

<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="admin.jsp" class="logo">
    NLP
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="images/uday.JPG">
                <span class="username"><%=session.getAttribute("uname") %></span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="Userprofile.jsp"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="ChangePassword.jsp"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="logout.jsp"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="admin.jsp">
                        <i class="fa fa-dashboard"></i>
                        <span>Home</span>
                    </a>
                </li>
                 <li>
                    <a class="active" href="#">
                        <i class="fa fa-dashboard"></i>
                        <span>BookMarked Answers</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>Interview Questions</span>
                    </a>
                    <ul class="sub">
						<li><a href="typography.html">Java</a></li>
						<li><a href="glyphicon.html">HTML</a></li>
                        <li><a href="grids.html">JSP</a></li>
                    </ul>
                </li>
                   </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
		<section id="main-content">
			
			
			<section class="wrapper">
			
           <form action="AddQuestion" method="post"><!-- // AddQuestion -->
           
           <% String email=(String)session.getAttribute("uname"); %>
           <input type="hidden" name="email" value="<%=email %>">
			
			<%
			   Utildb dao=new Utildb();
			     Connection con =dao.getConnection();
			     String query="select * from languages";
		    	 ResultSet rs = con.createStatement().executeQuery(query);
				  
            %>
            <div id="div_quotes" class="col-sm-3">
			<select class="ggg" name="language_id" id="ddlView" required>
			 <option value="0">Select Technology</option>
			<% while(rs.next()){ 
			   String str=rs.getString(2);
			   	   
			%>
			     
					  <option value="<%=str %>"><%=str%></option>
			  <% } %>
			</select>
			</div>
	        <div class="col-sm-5">
	        <% 
            
               String question=request.getParameter("question");
	           System.out.println("New question is : "+question);
	        if(question != null){ %>
		<textarea class="form-control" name="question"  value="<%=question %>" rows="1" id="comment" style="width:500px; height:65px;" aria-describedby="name-format" required="required"> </textarea>
			    <span id="name-format" class="help"> </span> 
			     <%--  <input type="text" name="q1" value="<%=question %>"> --%>
			   <%}else{ %>
			    <textarea class="form-control" name="question" rows="1" id="comment" style="width:500px; height:65px;" aria-describedby="name-format" required="required" > </textarea>
			    <span id="name-format" class="help"> </span>
			    <%} %>
			</div> 
			<div class="col-md-12" align="center">
				<input type="submit" class="btn btn-danger" onsubmit="Validate()" value="Add Question" name="ADD_New_Question">
		</div>
		 <div class="col-sm-12">
			
			<%
                  if(null!=request.getAttribute("Message"))
                    {
                       out.println(request.getAttribute("Message"));
                    }
             %>
			</div> 			

        
			</form>
			</section>
			<!-- footer -->
			 <jsp:include page="footer.jsp"/>
			<!-- / footer -->
		</section>
		<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
<!-- morris JavaScript -->	

<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	   
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2015 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2015 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2015 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2015 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2016 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2016 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2016 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2016 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2017 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
			
			],
			lineColors:['#eb6f6f','#926383','#eb6f6f'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
		
	   
	});
	</script>
	
<!-- calendar -->
	<script type="text/javascript" src="js/monthly.js"></script>
	<script type="text/javascript">
		$(window).load( function() {

			$('#mycalendar').monthly({
				mode: 'event',
				
			});

			$('#mycalendar2').monthly({
				mode: 'picker',
				target: '#mytarget',
				setWidth: '250px',
				startHidden: true,
				showTrigger: '#mytarget',
				stylePast: true,
				disablePast: true
			});

		switch(window.location.protocol) {
		case 'http:':
		case 'https:':
		// running on a server, should be good.
		break;
		case 'file:':
		alert('Just a heads-up, events will not work when run locally.');
		}

		});
	</script>
	<!-- //calendar -->
</body>
</html>
