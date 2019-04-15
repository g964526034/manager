$(function(){
	$("#add_announce_btn").click(function(event){
		event.preventDefault();
		var title = $("#add_announce_form input[name='title']").val().trim();
		
		if(!title){
			return alert("标题不能为空");
		}
		
		$("#add_announce_form").submit();
	});
	
	$(".announce_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/announce/del.json";
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
	
	$("#update_announce_btn").click(function(){
		
		var content = $("#update_announce_form input[name='content']").val();
		
		var url = $("#update_announce_form").attr("action");
		var postData = $("#update_announce_form").serialize();
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/announce/doBrowse.do";
			} else {
				alert("修改失败");
			}
		})
	});
});