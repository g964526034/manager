<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>浏览投诉信息</title>
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
        投诉信息浏览
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
        <div class="box-body">
          <div class="box">
            <div class="box-header">
              <div class="col-xs-3">
			  
			  </div>
			  <div class="col-xs-6">
				  <div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="请输入投诉标题">
					<span class="glyphicon glyphicon-search form-control-feedback"></span>
				  </div>
			  </div>
			  <div class="col-xs-3">
				<div class="col-xs-6" style="text-align:left">
					<button type="button" class="btn btn-default btn-sm">搜索</button>
              
				</div> 
				<div class="col-xs-6">
				
              
				</div> 
			  </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered table-hover">
                <thead>
	                <tr>
					  <th>ID</th>
	                  <th>住户姓名</th>
	                  <th>联系方式</th>
	                  <th>投诉信息标题</th>
	                  <th>处理人</th>
					  <th>投诉时间</th>
					  <th>是否解决</th>
					  <th></th>
	                </tr>
                </thead>
                <tbody>
	                <tr>
	                  <c:forEach items="${complains.data }" var="complain">
		                <tr>
		                  <td>${complain.id }</td>
		                  <td>${complain.user.name }</td>
		                  <td>${complain.user.tel }</td>
		                  <td>${complain.title}</td>
		                  <td>${complain.admin.realName }</td>
		                  <td>${complain.createTime }</td>
		                  <td>
		                  	<c:if test="${complain.solution == 0 }">
	                			未解决
	                		</c:if>
	                		<c:if test="${complain.solution == 1 }">
	                			已解决
	                		</c:if>
		                  </td>
		                  <td>
		                  	<a href="/manager/complain/doFind.do?id=${complain.id}">查看</a>
		                  	<c:if test="${sessionScope.admin.realName == complain.admin.realName || complain.admin.realName == '' }">
		                  		<a href="/manager/complain/edit.do?id=${complain.id}">编辑</a>
		                  	</c:if>
		                  	<c:if test="${complain.solution == 1 && sessionScope.admin.realName == complain.admin.realName }">
		                  		<a class="complain_adminDel_btn" href="#" data-id="${complain.id }">删除</a>
		                  	</c:if>
		                  </td>
		                </tr>
	                </c:forEach>
	                </tr>
                </tbody>
                <tfoot>
	                <tr>
	                  <th>ID</th>
	                  <th>住户姓名</th>
	                  <th>联系方式</th>
	                  <th>投诉信息标题</th>
	                  <th>处理人</th>
					  <th>投诉时间</th>
					  <th>是否解决</th>
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
              <c:if test="${complains.curPage > 1 }">
              	<li><a href="<%=application.getContextPath() %>/complain/doBrowse.do?page=${complains.curPage - 1}&keyword=${keyword}">上一页</a></li>
              </c:if>
              
              <c:forEach begin="1" var="pageNum" end="${complains.totalPage }" step="1">
              	<li><a href="<%=application.getContextPath() %>/complain/doBrowse.do?page=${pageNum}&keyword=${keyword}">${pageNum }</a></li>
              </c:forEach>
              
              <c:if test="${complains.curPage < complains.totalPage }">
              	<li><a href="<%=application.getContextPath() %>/complain/doBrowse.do?page=${complains.curPage + 1}&keyword=${keyword}">下一页</a></li>
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
<!-- <%=application.getContextPath() %>/static/wrapper -->

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
<script src="<%=application.getContextPath() %>/static/dist/js/complain.js"></script>
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

