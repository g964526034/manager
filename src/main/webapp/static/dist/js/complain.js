$(function(){
	$("#add_complain_btn").click(function(event){
		event.preventDefault();
		var title = $("#add_complain_form input[name='title']").val().trim();
		
		if(!title){
			return alert("标题不能为空");
		}
		
		$("#add_complain_form").submit();
	});
	
	$(".complain_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/complain/userDel.json";
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
	
	$("#update_complain_btn").click(function(){
		
		var title = $("#update_complain_form input[name='title']").val();
		var solution = $("#update_complain_form select[name='solution']").val();
		var compMessage = $("#update_complain_form input[name='comp_message']").val();
		
		var url = $("#update_complain_form").attr("action");
		var postData = $("#update_complain_form").serialize();
		alert(postData);
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/complain/doUserBrowse.do";
			} else {
				alert("修改失败");
			}
		})
	});
	
	$("#response_complain_btn").click(function(){
			
		var response = $("#response_complain_form input[name='response']").val();
		
		var url = $("#response_complain_form").attr("action");
		var postData = $("#response_complain_form").serialize();
		alert(postData);
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/complain/doBrowse.do";
			} else {
				alert("修改失败");
			}
		})
	});
	
	$(".complain_adminDel_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/complain/adminDel.json";
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