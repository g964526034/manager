<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>依晨小区物业管理系统</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<link href="<%=application.getContextPath() %>/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=application.getContextPath() %>/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="<%=application.getContextPath() %>/static/css/flexslider.css" type="text/css" media="screen" property="" />
<!-- js -->
<script src="/manager/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<link href="<%=application.getContextPath() %>/static/css/font-awesome.css" rel="stylesheet"> 
<!-- <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css"> -->
</head>
	
<body>
<!-- header -->
	<%@ include file="../fragment/divHeader.jspf" %>
	
<!-- header -->
<!-- banner -->
	<div class="banner1">
		<div class="container"> 
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav class="link-effect-12">
						<ul class="nav navbar-nav w3_agile_nav">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">业主投诉</span> <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="/manager/complain/add.do">新建投诉信息</a></li>
									<li><a href="/manager/complain/doUserBrowse.do">查看投诉信息</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">业主报修</span> <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="/manager/fix/add.do">新建报修信息</a></li>
									<li><a href="/manager/fix/doUserBrowse.do">查看报修信息</a></li>
								</ul>
							</li>
							<li class="active dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">业主收费信息</span> <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="/manager/cost/doUserBrowse.do">查看近期费用信息</a></li>
									<li><a href="/manager/user_cost/doUserBrowse.do">查看自身缴费信息</a></li>
								</ul>
							</li>
							<li class=""><a href="/manager/announce/doUserBrowse.do"><span>小区公告</span></a></li>
							<!--<li><a href="mail.html"><span>我的主页</span></a></li>-->
						</ul>
						<div class="w3_agileits_search_form">
							<form action="#" method="post">
								<input type="search" name="Search" placeholder="Search" required="">
								<input type="submit" value=" ">
							</form>
						</div>
					</nav>
				</div>
			</nav>
		</div>
	</div>
<!-- //banner -->
<!-- about -->
	<div class="services">
		<div class="container">
			<table class="table table-bordered table-hover">
                <thead>
	                <tr>
					  <th>ID</th>
	                  <th>住户姓名</th>
					  <th>费用名称</th>
					  <th>缴费数量</th>
					  <th>总价</th>
					  <th>创建时间</th>
	                </tr>
                </thead>
                <tbody>
                	<c:forEach items="${userCosts.data }" var="userCost">
                	  <tr>
		                  <td>${userCost.id }</td>
		                  <td>${userCost.user.name }</td>
		                  <td>${userCost.cost.costName }</td>
		                  <td>${userCost.costNum }</td>
		                  <td>${userCost.totalCost }</td>
						  <td>${userCost.createTime }</td>
	                  </tr>
                	</c:forEach>
                </tbody>
                <tfoot>
                	<tr>
					  <th>ID</th>
	                  <th>住户姓名</th>
					  <th>费用名称</th>
					  <th>缴费数量</th>
					  <th>总价</th>
					  <th>创建时间</th>
	                </tr>
                </tfoot>
              </table>
		</div>
	</div>
<!-- //about -->
<!-- stats -->
	
	<div class="container">
		<div class="box-footer">
			<ul class="pagination pagination-sm no-margin pull-right">
              <c:if test="${userCosts.curPage > 1 }">
              	<li><a href="<%=application.getContextPath() %>/user_cost/doUserBrowse.do?page=${userCosts.curPage - 1}&keyword=${keyword}">上一页</a></li>
              </c:if>
              
              <c:forEach begin="1" var="pageNum" end="${userCosts.totalPage }" step="1">
              	<li><a href="<%=application.getContextPath() %>/user_cost/doUserBrowse.do?page=${pageNum}&keyword=${keyword}">${pageNum }</a></li>
              </c:forEach>
              
              <c:if test="${userCosts.curPage < userCosts.totalPage }">
              	<li><a href="<%=application.getContextPath() %>/user_cost/doUserBrowse.do?page=${userCosts.curPage + 1}&keyword=${keyword}">下一页</a></li>
              </c:if>
          	</ul>
		</div>
	</div>
	
<!-- //stats -->
<!-- flexSlider -->
	<script defer src="<%=application.getContextPath() %>/static/js/jquery.flexslider.js"></script>
	<script type="text/javascript">
	$(window).load(function(){
	  $('.flexslider').flexslider({
		animation: "slide",
		start: function(slider){
		  $('body').removeClass('loading');
		}
	  });
	});
  </script>
<!-- //flexSlider -->
<!-- stats -->
	<script src="<%=application.getContextPath() %>/static/js/jquery.waypoints.min.js"></script>
	<script src="<%=application.getContextPath() %>/static/js/jquery.countup.js"></script>
		<script>
			$('.counter').countUp();
		</script>
<!-- //stats -->
<!-- footer -->
	<footer>
		
	</footer>
<!-- //footer -->
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="<%=application.getContextPath() %>/static/js/move-top.js"></script>
<script type="text/javascript" src="<%=application.getContextPath() %>/static/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smooth-scrolling -->
<!-- for bootstrap working -->
	<script src="<%=application.getContextPath() %>/static/js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	<script type="text/javascript" src="<%=application.getContextPath() %>/static/dist/js/cost.js"></script>

<!-- //here ends scrolling icon -->
</body>
</html>