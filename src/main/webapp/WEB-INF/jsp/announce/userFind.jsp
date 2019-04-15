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
<link href="/manager/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="/manager/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="/manager/static/css/flexslider.css" type="text/css" media="screen" property="" />
<!-- js -->
<script src="/manager/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<link href="/manager/static/css/font-awesome.css" rel="stylesheet"> 
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
									<li><a href="icons.html">新建投诉信息</a></li>
									<li><a href="typography.html">查看投诉信息</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">业主报修</span> <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="icons.html">新建报修信息</a></li>
									<li><a href="typography.html">查看报修信息</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">业主收费信息</span> <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="icons.html">查看近期费用信息</a></li>
									<li><a href="typography.html">查看自身缴费信息</a></li>
								</ul>
							</li>
							<li class="active"><a href="#"><span>小区公告</span></a></li>
							<!--<li><a href="mail.html"><span>我的主页</span></a></li>-->
						</ul>
					</nav>
				</div>
			</nav>
		</div>
	</div>
<!-- //banner -->
<!-- about -->
	<div class="services">
		<div class="container">
			<form id="#" action="/manager/complain/doUpdate.do" method="post">
				<div class="row">
				  <div class="col-md-6">
				
				  <div class="form-group">
					<label for="real_name" style="text-align:left;padding-left:20px;" class="col-sm-3 control-label">管理员姓名</label>
					<div class="col-sm-9">
					  <input readonly name="real_name" id="real_name" class="form-control" type="text" placeholder="公告信息发布人" value="${announce.admin.realName }">
					</div>
				  </div>
				
			  </div>
			  <div class="col-md-6">
				
				  <div class="form-group">
					<label for="create_time" style="text-align:left;padding-left:20px;" class="col-sm-3 control-label">发布时间</label>
					<div class="col-sm-9">
					  <input readonly name="create_time" id="create_time" class="form-control" type="text" placeholder="公告信息发布人" value="${announce.createTime }">
					</div>
				  </div>
				
			  </div>
			</div>
			<br/>
			<div class="form-group">
			  <label for="content">公告内容如下</label>
			  <textarea id="content" name="content" readonly style="height:300px;" class="form-control" rows="3" placeholder="Enter ..." >${announce.content }</textarea>
            </div>
		  </form>
		  <div style="text-align:right;">
				<a href="/manager/announce/doUserBrowse.do" type="button" class="btn btn-default" style="margin-right:5px;">返回</a>
					
		  </div>
		</div>
	</div>
<!-- //about -->
<!-- stats -->
	
<!-- //stats -->

<!-- flexSlider -->
	<script defer src="/manager/static/js/jquery.flexslider.js"></script>
	<script type="text/javascript">
	/* $(window).load(function(){
	  $('.flexslider').flexslider({
		animation: "slide",
		start: function(slider){
		  $('body').removeClass('loading');
		}
	  });
	}); */
  </script>
<!-- //flexSlider -->
<!-- stats -->
	<script src="/manager/static/js/jquery.waypoints.min.js"></script>
	<script src="/manager/static/js/jquery.countup.js"></script>
		<script>
			$('.counter').countUp();
		</script>
<!-- //stats -->
<!-- footer -->
	<footer>
		
	</footer>
<!-- //footer -->
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="/manager/static/js/move-top.js"></script>
<script type="text/javascript" src="/manager/static/js/easing.js"></script>
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
	<script src="/manager/static/js/bootstrap.js"></script>
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
	<script type="text/javascript" src="/manager/static/dist/js/complain.js"></script>
<!-- //here ends scrolling icon -->
</body>
</html>