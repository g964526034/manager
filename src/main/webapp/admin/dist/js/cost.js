$(function(){
	$("#add_cost_btn").click(function(event){
		event.preventDefault();
		var costName = $("#add_cost_form input[name='cost_name']").val().trim();
		
		if(!costName){
			return alert("标题不能为空");
		}
		
		$("#add_cost_form").submit();
	});
	
	$(".cost_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/cost/del.do";
		$.get(url,{"id":id},function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("删除成功");
				location.reload();
			} else{
				alert("删除失败");
			}
		});
	});
	
	/*$("#update_announce_btn").click(function(){
		
		var content = $("#update_announce_form input[name='content']").val().trim();
		
		var url = $("#update_announce_form").attr("action");
		var postData = $("#update_announce_form").serialize();
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/app/announce/browse";
			} else {
				alert("修改失败");
			}
		})
	});*/
});