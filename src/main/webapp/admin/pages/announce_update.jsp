<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>更新公告信息</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

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
        更新公告信息
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title"></h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <form id="update_announce_form" method="POST" action="/manager/app/anounce/update">
        	<div class="box-body">
	            <div class="row">
				  <div class="col-md-3">
					  <div class="form-group">
						<label for="id" class="col-sm-5 control-label">ID</label>
						<div class="col-sm-7">
							<input readonly name="id" id="id" class="form-control" type="text" placeholder="公告信息id" value="${announce.id }">
						</div>
					  </div>
				  </div>
				  <div class="col-md-3">
					  <div class="form-group">
						<label class="col-sm-5 control-label">公告标题</label>
						<div for="title" class="col-sm-7">
						  <input readonly name="title" id="title" class="form-control" type="text" placeholder="公告信息标题" value="${announce.title }">
						</div>
					  </div>
				  </div>
				  <div class="col-md-3">
					  <div class="form-group">
						<label for="real_name" class="col-sm-5 control-label">管理员姓名</label>
						<div class="col-sm-7">
						  <input readonly name="real_name" id="real_name" class="form-control" type="text" placeholder="公告信息发布人" value="${announce.admin.realName }">
						</div>
					  </div>
				  </div>
				  <div class="col-md-3">
					  <div class="form-group">
						<label for="create_time" class="col-sm-5 control-label">发布时间</label>
						<div class="col-sm-7">
						  <input readonly name="create_time" id="create_time" class="form-control" type="text" placeholder="公告信息发布人" value="${announce.createTime }">
						</div>
					  </div>
				  </div>
				</div>
				<div class="form-group">
				  <label>公告内容如下</label>
				  <textarea style="height:300px;" class="form-control" rows="3" placeholder="Enter ..." ></textarea>
	            </div>
	        </div>
	        <!-- /.box-body -->
	        <div class="box-footer">
	            <div class="col-xs-3">
								  
				</div>
				<div class="col-xs-6" style="text-align:center;">
					<a href="/manager/app/announce/browse" type="button" class="btn btn-default" style="margin-right:5px;">返回</a>
					<button type="button" id="update_announce_btn" class="btn btn-primary" style="margin-left:5px;">确定</button> 
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
<!-- ../wrapper -->

<!-- jQuery 3 -->
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
