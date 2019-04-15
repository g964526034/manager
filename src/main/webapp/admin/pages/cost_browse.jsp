<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>浏览收费信息</title>
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
        收费信息浏览
      </h1>
      <ol class="breadcrumb">
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">

          <a href="cost_add.jsp" style="background-color:#2F4F4F;border-color:#D3D3D3;" class="btn btn-info btn-flat pull-right">添加收费信息</a>
        </div>
        <div class="box-body">
          <div class="box">
            <div class="box-header">
              <form action="<%=application.getContextPath() %>/app/cost/browse">
	              <div class="col-xs-3">
				  
				  </div>
				  <div class="col-xs-6">
					  <div class="form-group has-feedback">
						<input type="text" value="${keyword }" name="keyword" class="form-control" placeholder="请输入费用名称">
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
					  <th>ID</th>
	                  <th>费用名称</th>
	                  <th>费用金额</th>
	                  <th>创建时间</th>
	                  <th></th>
	                </tr>
                </thead>
                <tbody>
                	<c:forEach items="${costs.data }" var="cost">
		                <tr>
		                  <td>${cost.id }</td>
		                  <td>${cost.costName }</td>
		                  <td>${cost.price}</td>
		                  <td>${cost.createTime }</td>
		                  <td>
		                  	<a href="/manager/app/admin/find?id=${cost.id}">查看</a>
		                  	<a href="/manager/app/admin/edit?id=${cost.id}">编辑</a>
		                  	<a class="cost_del_btn" href="#" data-id="${cost.id }">删除</a>
		                  </td>
		                </tr>
	                </c:forEach>
                </tbody>
                <tfoot>
	                <tr>
	                  <th>ID</th>
	                  <th>费用名称</th>
	                  <th>费用金额</th>
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
              <c:if test="${costs.curPage > 1 }">
              	<li><a href="<%=application.getContextPath() %>/app/admin/browse?page=${costs.curPage - 1}&keyword=${keyword}">上一页</a></li>
              </c:if>
              
              <c:forEach begin="1" var="pageNum" end="${costs.totalPage }" step="1">
              	<li><a href="<%=application.getContextPath() %>/app/admin/browse?page=${pageNum}&keyword=${keyword}">${pageNum }</a></li>
              </c:forEach>
              
              <c:if test="${costs.curPage < costs.totalPage }">
              	<li><a href="<%=application.getContextPath() %>/app/admin/browse?page=${costs.curPage + 1}&keyword=${keyword}">下一页</a></li>
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
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script>
</body>
</html>

