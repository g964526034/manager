<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>查找业主信息</title>
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
        查找业主信息
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
        <form id="update_user_form" method="POST" action="/manager/app/user/update">
        	<div class="box-body">
	          <div class="box">
	            <div class="col-xs-3">
				  
				  </div>
				  <div class="col-xs-6">
					<div class="box-body">
					  <label for="user_id">住户ID</label>
					  <input readonly name="user_id" id="user_id" class="form-control" type="text" placeholder="住户id" value="${user.userId }">
					  <br/>
					  <label for="name">姓名</label>
					  <input readonly name="name" id="name" class="form-control" type="text" placeholder="姓名" value="${user.name }">
					  <br/>
					  <label for="gender">性别</label>
					  <input readonly name="gender" id="gender" class="form-control" type="text" placeholder="性别" value="${user.gender == 1 ? '男' : '女' }" >
					  <br/>
					  <label for="id">身份证号</label>
					  <input readonly name="id" id="id" class="form-control" type="text" placeholder="身份证号" value="${user.id }">
					  <br/>
					  <label for="nation">民族</label>
					  <input readonly name="nation" id="nation" class="form-control" type="text" placeholder="民族" value="${user.nation }">
					  <br/>
					  <label for="tel">联系方式</label>
					  <input readonly name="tel" id="tel" class="form-control" type="text" placeholder="民族" value="${user.tel }">
					  <br/>
					  <label for="email">电子邮箱</label>
					  <input readonly name="email" id="email" class="form-control" type="text" placeholder="民族" value="${user.email }">
					  <br/>
					  <label for="house_message">房屋信息</label>
					  <input readonly name="house_message" id="house_message" class="form-control" type="text" placeholder="房屋信息" value="${user.houseMessage }">
					  <br/>
					  <label for="house_situation">房屋状态</label>
					  <div class="form-group">
						  <select disabled name="house_situation" class="form-control">
							<option value="1" <c:if test="${user.houseSituation == 1 }"> selected </c:if>>自己居住</option>
							<option value="2" <c:if test="${user.houseSituation == 2 }"> selected </c:if>>还未出租</option>
							<option value="3" <c:if test="${user.houseSituation == 3 }"> selected </c:if>>已出租</option>
						  </select>
					  </div>
					  <label for="park_message">车位信息</label>
					  <input readonly name="park_message" id="park_message" class="form-control" type="text" placeholder="车位信息" value="${user.parkMessage }">
					  <br/>
					  <div class="form-group">
						<label for="more">备注</label>
						<textarea readonly name="more" id="more" class="form-control" rows="3" placeholder="Enter ...">${user.more }</textarea>
					  </div>
					
					</div>
			  </div>
			  <div class="col-xs-3">
				<div class="col-xs-6">
					
				</div> 
				<div class="col-xs-6">
				
				</div> 
			  </div>
	          </div>
	        </div>
	        <!-- /.box-body -->
	        <div class="box-footer">
				<div class="col-xs-3">
								  
				</div>
				<div class="col-xs-6" style="text-align:center;">
					<a href="/manager/user/doBrowse.do" type="button" class="btn btn-default" style="margin-right:5px;">返回</a>
					<a href="/manager/user/edit.do?user_id=${user.userId}" type="button" class="btn btn-primary" style="margin-left:5px;">编辑</a> 
				</div>
				
					
				<div class="col-xs-3" style="text-align:right;">
					<a type="button" class="btn btn-default glyphicon glyphicon-trash "></a>
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
<script src="/manager/static/dist/js/demo.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
