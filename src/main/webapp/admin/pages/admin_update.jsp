<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>更新管理员信息</title>
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
        更新管理员信息
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <form id="update_admin_form" method="POST" action="/manager/app/admin/update">
        	<div class="box-body">
	          <div class="box">
	              <div class="col-xs-3">
				  
				  </div>
				  <div class="col-xs-6">
					<div class="box-body">
					  <label for="id">管理员ID</label>
					  <input readonly name="id" id="id" class="form-control" type="text" placeholder="管理员id" value="${admin.id }">
					  <br/>
					  <label for="tel">联系方式</label>
					  <input readonly name="tel" id="tel" class="form-control" type="text" placeholder="联系方式" value="${admin.tel }">
					  <br/>
					  <label for="email">Email</label>
					  <input readonly name="email" id="email" class="form-control" type="text" placeholder="email" value="${admin.email }">
					  <br/>
					  <label for="real_name">姓名</label>
					  <input readonly name="real_name" id="real_name" class="form-control" type="text" placeholder="姓名" value="${admin.realName }">
					  <br/>
					  <label for="marriage">婚姻状况</label>
					  <div class="form-group">
						  <select name="marriage" class="form-control">
							<option value="0" <c:if test="${admin.marriage == 0 }"> selected </c:if>>未婚</option>
							<option value="1" <c:if test="${admin.marriage == 1 }"> selected </c:if>>已婚</option>
						  </select>
					  </div>
					  <label for="work">工作</label>
					  <input name="work" id="work" class="form-control" type="text" placeholder="工作" value="${admin.work }">
					  <label for="salary">薪水</label>
					  <input name="salary" id="salary" class="form-control" type="text" placeholder="薪水" value="${admin.salary }">
					  <br/>
					  <label for="privilege">备注</label>
					  <div class="form-group">
						  <select name="privilege" class="form-control">
							<option value="0" <c:if test="${admin.privilege == 0 }"> selected </c:if>>普通管理员</option>
							<option value="1" <c:if test="${admin.privilege == 1 }"> selected </c:if>>超级管理员</option>
						  </select>
					  </div>
					  
					</div>
			  </div>
			  <div class="col-xs-3">
				<div class="col-xs-6">
					
				</div> 
				<div class="col-xs-6">
				
				</div> 
			  </div>
	            <div class="box-body">
	              
	            </div>
	            <!-- /.box-body -->
	          </div>
	        </div>
	        <!-- /.box-body -->
        	<div class="box-footer">
	          <div class="col-xs-3">
								  
				</div>
				<div class="col-xs-6" style="text-align:center;">
					<a href="/manager/app/admin/browse" type="button" class="btn btn-default" style="margin-right:5px;">返回</a>
					<button type="button" id="update_admin_btn" class="btn btn-primary" style="margin-left:5px;">确定</button> 
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
