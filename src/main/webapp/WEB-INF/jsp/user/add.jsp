<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>用户信息输入模块</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="/manager/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/manager/static/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/manager/static/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/manager/static/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/manager/static/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

  <%@ include file="../fragment/header.jspf" %>
  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        业主信息录入
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">业主及其住房基本信息</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
          <c:if test="${!empty info }">
	        	<div class="alert alert-success alert-dismissible" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <strong>提示!</strong> 添加成功.
				</div>
				<!-- <script>
					setTimeout(function(){
						location.href ="/manager/static/pages/user_add.jsp";
					},3000);
				</script> -->
		   </c:if>
        </div>
        <form id="add_user_form" method="POST" action="/manager/user/doAdd.do">
        	<div class="box-body">
	          <div class="row">
			    <div class="col-xs-3">
					
				</div>
				<div class="col-xs-6">
					<div class="box box-success">
						
						<div class="box-body">
							<label for="name">姓名</label>
							<input name="name" id="name" class="form-control" type="text" placeholder="姓名">
							<br/>
							<label for="gender">性别</label>
							<div class="form-group">
							  <select class="form-control" name="gender">
								<option value="1">男</option>
								<option value="0">女</option>
							  </select>
							</div>
							<label for="id">身份证号</label>
							<input class="form-control" type="text" name="id" id="id" placeholder="身份证号">
							<br/>
							<label for="nation">民族</label>
							<input class="form-control" type="text" name="nation" id="nation" placeholder="民族">
							<br/>
							<label for="tel">联系方式</label>
							<input class="form-control" type="text" name="tel" id="tel" placeholder="联系方式">
							<br/>
							<label for="email">电子邮箱</label>
							<input class="form-control" type="text" name="email" id="email" placeholder="电子邮箱">
							<br/>
							<label for="house_message">房屋信息</label>
							<input class="form-control" type="text" name="house_message" id="house_message" placeholder="Default input">
							<br/>
							<label for="house_situation">房屋状态</label>
							<div class="form-group">
							  <select class="form-control" name="house_situation">
								<option value="1">自己居住</option>
								<option value="2">还未出租</option>
								<option value="3">已出租</option>
							  </select>
							</div>
							<label for="park_message">车位信息</label>
							<input class="form-control" name="park_message" id="park_message" type="text" placeholder="车位信息">
							<div class="form-group">
								<label for="more">备注</label>
								<textarea class="form-control" name="more" rows="3" placeholder="Enter ..."></textarea>
							</div>
						</div>
						
					<!-- /.box-body -->
					</div>
						              
				</div>
				<div class="col-xs-3">
				
	              
				</div>
			  </div>				  
	        </div>
	        <!-- /.box-body -->
	        <div class="box-footer">
				<div class="col-xs-3">
								  
				</div>
				<div class="col-xs-6" style="text-align:center;">
					<button type="button" class="btn btn-default" style="margin-right:5px;">返回</button>
					<button type="submit" id="add_user_btn" class="btn btn-primary" style="margin-left:5px;">确定</button> 
				</div>	
				<div class="col-xs-3">
				
				</div>          
	        </div>
        </form>
        
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  
  <%@ include file="../fragment/footer.jspf" %>
  
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- /manager/static/wrapper -->

<!-- jQuery 3 -->
<script src="/manager/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/manager/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/manager/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/manager/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/manager/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/manager/static/dist/js/demo.js"></script>
<script src="/manager/static/dist/js/user.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
