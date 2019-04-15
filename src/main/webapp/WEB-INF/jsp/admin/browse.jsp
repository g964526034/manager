<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>浏览管理员信息</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="<%=application.getContextPath() %>/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=application.getContextPath() %>/static/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<%=application.getContextPath() %>/static/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=application.getContextPath() %>/static/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="<%=application.getContextPath() %>/static/dist/css/skins/_all-skins.min.css">

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
        管理员信息浏览
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">

          <a href="add.do" style="background-color:#2F4F4F;border-color:#D3D3D3;" class="btn btn-info btn-flat pull-right">添加管理员</a>
        </div>
        <div class="box-body">
          <div class="box">
            <div class="box-header">
	            <form action="<%=application.getContextPath() %>/admin/doBrowse.do">
	              <div class="col-xs-3">
				  
				  </div>
				  <div class="col-xs-6">
					  <div class="form-group has-feedback">
						<input type="text" value="${keyword }" name="keyword" class="form-control" placeholder="请输入管理员基本信息">
						<span class="glyphicon glyphicon-search form-control-feedback"></span>
					  </div>
				  </div>
				  <div class="col-xs-3">
					<div class="col-xs-6" style="text-align:left">
						<button type="submit" class="btn btn-default btn-sm">搜索</button>
					</div> 
					<div class="col-xs-6">
					</div> 
				  </div>
	            </form>
              
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered table-hover">
                <thead>
	                <tr>
					  <th>id</th>
	                  <th>联系方式</th>
	                  <th>邮箱</th>
	                  <th>真实姓名</th>
	                  <th>婚姻状况</th>
					  <th>工作</th>
					  <th>创建时间</th>
					  <th></th>
	                </tr>
                </thead>
                <tbody>
	                <c:forEach items="${admins.data }" var="admin">
		                <tr>
		                  <td>${admin.id }</td>
		                  <td>${admin.tel }</td>
		                  <td>${admin.email}</td>
		                  <td>${admin.realName }</td>
		                  <td>
		                  	<c:if test="${admin.marriage == 0 }">
	                			未婚
	                		</c:if>
	                		<c:if test="${admin.marriage == 1 }">
	                			已婚
	                		</c:if>
		                  </td>
		                  <td>${admin.work }</td>
		                  <td>${admin.createTime }</td>
		                  <td>
		                  	<a href="/manager/admin/doFind.do?id=${admin.id}">查看</a>
		                  	<a href="/manager/admin/edit.do?id=${admin.id}">编辑</a>
		                  	<a class="admin_del_btn" href="#" data-id="${admin.id }">删除</a>
		                  </td>
		                </tr>
	                </c:forEach>
                </tbody>
                <tfoot>
	                <tr>
	                  <th>id</th>
	                  <th>联系方式</th>
	                  <th>邮箱</th>
	                  <th>真实姓名</th>
	                  <th>是否已婚</th>
					  <th>工作岗位</th>
					  <th>创建时间</th>
					  <th></th>
	                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          <ul class="pagination pagination-sm no-margin pull-right">
              <c:if test="${admins.curPage > 1 }">
              	<li><a href="<%=application.getContextPath() %>/admin/doBrowse.do?page=${admins.curPage - 1}&keyword=${keyword}">上一页</a></li>
              </c:if>
              
              <c:forEach begin="1" var="pageNum" end="${admins.totalPage }" step="1">
              	<li><a href="<%=application.getContextPath() %>/admin/doBrowse.do?page=${pageNum}&keyword=${keyword}">${pageNum }</a></li>
              </c:forEach>
              
              <c:if test="${admins.curPage < admins.totalPage }">
              	<li><a href="<%=application.getContextPath() %>/admin/doBrowse.do?page=${admins.curPage + 1}&keyword=${keyword}">下一页</a></li>
              </c:if>
          </ul>
        </div>
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
<!-- ../wrapper -->

<!-- jQuery 3 -->
<script src="<%=application.getContextPath() %>/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=application.getContextPath() %>/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="<%=application.getContextPath() %>/static/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="<%=application.getContextPath() %>/static/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="<%=application.getContextPath() %>/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=application.getContextPath() %>/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=application.getContextPath() %>/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=application.getContextPath() %>/static/dist/js/demo.js"></script>
<script src="<%=application.getContextPath() %>/static/dist/js/admin.js"></script>
<script>
$(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>

