<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>业主交费信息输入模块</title>
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
        业主交费信息录入
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">业主交费情况</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <form id="add_user_cost_form" method="POST" action="/manager/user_cost/doAdd.do">
        	<div class="box-body">
	          <div class="row">
			    <div class="col-xs-3">
					
				</div>
				<div class="col-xs-6">
					<div class="box box-success">
						
						<div class="box-body">
							<label for="user_id">住户ID</label>
							<input readonly id="user_id" name="user_id" class="form-control" type="text" placeholder="住户编号" value="${user.userId }">
							<br/>
							<label for="name">姓名</label>
							<input readonly id="name" name="name" class="form-control" type="text" placeholder="住户姓名"  value="${user.name }">
							<br/>
							<label for="cost_name" >所交费用</label>
							<div  class="form-group">
							  <select id="cost_name" name="cost_name" class="form-control">
							  	<option>请选择..</option>
								<c:forEach items="${costs}" var="cost">
					                <option value="${cost.id }">${cost.costName }</option>
				                </c:forEach>
							  </select>
							</div>
							<label for="price">单价</label>
								<input readonly id="price" name="price" class="form-control" type="text" placeholder="费用单价" value="${cost.price }">
							<br/>
							<label for="cost_num">数量</label>
							<input name="cost_num" id="cost_num" class="form-control" type="text" placeholder="缴费数量">
							<br/>
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
					<button id="add_user_cost_btn" type="submit" class="btn btn-primary" style="margin-left:5px;">确定</button> 
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
<script src="/manager/static/dist/js/usercost.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
