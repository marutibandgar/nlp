<!--A Design by Fusion Project Centre

License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@page import="com.dao.Utildb"%>
<%@ page import="com.bean.Userbean"%>
<%@ page import="com.dao.Userdao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Answering Natural Language Question by subgraph matching:: User Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<meta name="keywords"
	content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet" />
<!-- font CSS -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/morris.css" type="text/css" />
<!-- calendar -->

<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
</head>
<body> 
 	<section id="container">
		<!--header start-->
		<header class="header fixed-top clearfix">
			<!--logo start-->
			<div class="brand">
				<a href="index.jsp" class="logo"> NLP </a>
				<div class="sidebar-toggle-box">
					<div class="fa fa-bars"></div>
				</div>
			</div> 
			<!--logo end-->
						<div class="top-nav clearfix">
				<!--search & user info start-->
				<ul class="nav pull-right top-menu">
					<li><input type="text" class="form-control search"
						placeholder=" Search"></li>
					<!-- user login dropdown start-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <img alt=""
							src="images/uday.JPG"> <span class="username"><%=session.getAttribute("uname") %></span>
							<b class="caret"></b>
					</a>
					
						<ul class="dropdown-menu extended logout">
							<li><a href="Userprofile.jsp"><i class=" fa fa-suitcase"></i>Profile</a></li>
							<li><a href="ChangePassword.jsp"><i class="fa fa-cog"></i> Change Password</a></li>
							<li><a href="logout.jsp"><i class="fa fa-key"></i> Log Out</a></li>
						</ul></li>
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
						<li><a class="active" href="index.jsp"> <i
								class="fa fa-dashboard"></i> <span>Home</span>
						</a></li>
						<li><a class="active" href="#"> <i
								class="fa fa-dashboard"></i> <span>BookMarked Answers</span>
						</a></li>

						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-book"></i> <span>Interview Questions</span>
						</a>
							<ul class="sub">
								<li><a href="typography.html">Java</a></li>
								<li><a href="glyphicon.html">HTML</a></li>
								<li><a href="grids.html">JSP</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
        	<section class="wrapper">

				<form action="QuestionInsert" method="POST">
				<%
				   String user=(String)session.getAttribute("uname");
				%>
                   <input type="hidden" name="user" value="<%=user%>">
					<div class="col-sm-6">
						<input type="text" class="form-control" name="question"  id="comment" />
					</div>

					<div class="col-sm-2">
						<button type="submit" class="btn btn-danger">Search/Add Question</button>
					</div>
					<%-- <%
					Utildb dao=new Utildb();
					Connection con=null;
					con=dao.getConnection();
					PreparedStatement ps1=con.prepareStatement("select DISTINCT(statement) from users_history where email='"+user+"'"+ "order by histroy_id DESC LIMIT 5");
					ResultSet rs=ps1.executeQuery(); 
					while(rs.next()){
					%>
						<div class="col-sm-12">
						<a href="#"><%=rs.getString(1) %></a>
						</div>
						
						<%
					}%> --%>
					<div class="col-sm-12">
					<%
					
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
  %>
  </div>
				</form>	
		
    <%-- <div>
      <table class="table"  ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'>
        <thead>
          <tr>
            <th data-breakpoints="xs">&nbsp;</th>
        </thead>
        <tbody>
         <% int i=1;
          for (Userbean user1 : searchResults) { %>
           <tr data-expanded="true">
             <td><%=user1.getQuestion()%></td>                      
           </tr>
         <% i++;} %>
        </tbody>
      </table>
    </div> --%>
      	<%-- 	<% String str=(String)session.getAttribute("usertype");
				if(str.equals("admin")){%>
				<div class="col-sm-4">
					<a href="admin.jsp">Aministration</a>
				</div>
				<%}%>
				
				 --%>

			</section>
			<!-- footer -->
			<div class="footer">
				 <jsp:include page="footer.jsp"/>
			</div>
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
