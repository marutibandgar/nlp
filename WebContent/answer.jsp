
<!--A Design by Fusion Project Centre

License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="java.sql.ResultSet"%>
<%@ page import="com.bean.Userbean"%>
<%@ page import="com.dao.Userdao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Answering Natural Language Question by subgraph matching</title>
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
<link href="css/style.css" rel='stylesheet' type='text/css'/>
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
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
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
							<li><a href="ChangePassword.jsp"><i class="fa fa-cog"></i> ChangePassword</a></li>
							<li><a href="logout.jsp"><i class="fa fa-key"></i> Log
									Out</a></li>
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
						<li><a class="active" href="user.jsp"> <i
								class="fa fa-dashboard"></i> <span>Home</span>
						</a></li>

						
					</ul>
				</div>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content" style="margin-top: 5px;height:auto;margin-bottom: 10%;">




			<div>
				<%--  <%for(int j=0; j<searchResults.size();j++){  %> --%>

				<section class="wrapper"
					<%-- <% if (j!=0 ){ %>  --%> style="margin-top: 5px">
					<%--    <%} %>     
             --%>






					<div class="div1" style="margin-top: 100px; margin-left: 20px;">

						<div class="col-sm-12" >
							<% 
							if(null!=request.getAttribute("errorMessage"))
						    {
								System.out.println("In answer.jsp");
						        out.println(request.getAttribute("errorMessage"));
						    }
							else{
							  String email=(String)session.getAttribute("uname");
  
    List<Userbean> searchResults = (List<Userbean>)request.getSession().getAttribute("bean");
    
    ArrayList<Integer> al2 = new ArrayList<Integer>();
    
  
    for(Userbean s:searchResults ){     	    	                   
%>
							<form action="Ratings" method="post">
							
								<div class="col-sm-12">
								    <input type="hidden" name="email" value="<%=email %>">
									<input type="hidden" name="ans_id" value="<%=s.getAns_id()%>">
									<input type="hidden" name="question"
										value="<%=s.getQuestion()%> ">
										
									<% if (!al2.contains(s.getQue_id())){ %>
									  <% al2.add(s.getQue_id()); %> 										
									  <%= s.getQuestion()%>	
									<% } %>
								</div>
								
								<div class="col-sm-12">
									<div wrap="hard" class="form-control" name="answer"
										rows="1" id="comment" style="height:auto"> <%=s.getAnswer()%>
									</div>
								</div>


								<div class="col-sm-12">

									<button name="action" class="fa fa-thumbs-up" value="likes">
										like<span class="badge"><%=s.getLike()%></span>
									</button>

									<button name="action" value="dislikes" class="fa fa-thumbs-down"
										 id="btnDisLike">
										DisLike<span class="badge"><%=s.getDislike()%></span>
									</button>
									<span id="resultdislike" style="color: #f00"></span>
								</div>								
							</form>
							<%  } %>
							<%
                if(null!=request.getAttribute("RattingMessage"))
                  {
                    %>
							<script> 
                     alert("Already given rating for this answer")
                     </script>
							<% } }%>

							<%--   <%  } %>	 --%>
						</div>

					</div>
		</section>
				<!-- footer -->
				 <jsp:include page="footer.jsp"/>
				<!-- / footer -->
			</div>

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
                $("#btnLike, #btnDisLike").click(function(){
  $("#btnLike, #btnDisLike").hide(100);
});
</script>
</body>
</html>
