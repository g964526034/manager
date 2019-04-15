$(function(){
	$("#add_fix_btn").click(function(event){
		event.preventDefault();
		var title = $("#add_fix_form input[name='title']").val().trim();
		
		if(!title){
			return alert("标题不能为空");
		}
		
		$("#add_fix_form").submit();
	});
	
	$(".fix_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/fix/userDel.json";
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
	
	$("#update_fix_btn").click(function(){
		
		var title = $("#update_fix_form input[name='title']").val();
		var solution = $("#update_fix_form select[name='solution']").val();
		var fixMessage = $("#update_fix_form input[name='fix_message']").val();
		
		var url = $("#update_fix_form").attr("action");
		var postData = $("#update_fix_form").serialize();
		alert(postData);
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/fix/doUserBrowse.do";
			} else {
				alert("修改失败");
			}
		})
	});
	
	$("#response_fix_btn").click(function(){
			
		var response = $("#response_fix_form input[name='response']").val();
		
		var url = $("#response_fix_form").attr("action");
		var postData = $("#response_fix_form").serialize();
		alert(postData);
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/fix/doBrowse.do";
			} else {
				alert("修改失败");
			}
		})
	});
	
	$(".fix_adminDel_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/fix/adminDel.json";
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
})