<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>管理员信息输入模块</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="/manager/admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/manager/admin/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/manager/admin/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/manager/admin/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/manager/admin/dist/css/skins/_all-skins.min.css">

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
        管理员信息录入
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">管理员基本信息</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <form id="add_admin_form" method="POST" action="/manager/app/admin/add">
        	<div class="box-body">
	          <div class="row">
			    <div class="col-xs-3">
					
				</div>
				<div class="col-xs-6">
					<div class="box box-success">
						
						<div class="box-body">
							<label for="tel">联系方式</label>
							<input name="tel" id="tel" class="form-control" type="text" placeholder="联系方式">
							<br/>
							<label for="email">Email</label>
							<input name="email" id="email" class="form-control" type="text" placeholder="email">
							<br/>
							<label for="real_name">真实姓名</label>
							<input name="real_name" id="real_name" class="form-control" type="text" placeholder="真实姓名">
							<br/>
							<label for="gender" for="exampleInputEmail1">性别</label>
							<div class="form-group">
							  <select name="gender" id="gender" class="form-control">
								<option value="1">男</option>
								<option value="0">女</option>
							  </select>
							</div>
							<label for="pwd">密码</label>
							<input name="pwd" id="pwd" class="form-control" type="password" placeholder="密码">
							<br/>
							<label for="repwd" for="exampleInputEmail1">确认密码</label>
							<input name="repwd" id="repwd" class="form-control" type="password" placeholder="确认密码">
							<br/>
							<label for="marriage">婚姻状况</label>
							<div class="form-group">
							  <select name="marriage" id="marriage" class="form-control">
								<option value="0">未婚</option>
								<option value="1">已婚</option>
							  </select>
							</div>
							<label for="work">工作</label>
							<input name="work" id="work" class="form-control" type="text" placeholder="工作岗位">
							<br/>
							<label for="salary">薪水</label>
							<input name="salary" id="salary" class="form-control" type="text" placeholder="薪水">
							<br/>
							<label for="privilege">权限</label>
							<div class="form-group">
							  <select name="privilege" id="privilege" class="form-control">
								<option value="0">普通管理员</option>
								<option value="1">超级管理员</option>
							  </select>
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
					<button type="submit" id="add_admin_btn" class="btn btn-primary" style="margin-left:5px;">确定</button> 
				</div>
				<div class="col-xs-3">	
						  
				</div>          
	        </div>
	        <!-- /.box-footer-->
        </form>
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
<!-- /manager/admin/wrapper -->

<!-- jQuery 3 -->
<script src="/manager/admin/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/manager/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/manager/admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/manager/admin/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/manager/admin/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/manager/admin/dist/js/demo.js"></script>
<script src="/manager/admin/dist/js/admin.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
