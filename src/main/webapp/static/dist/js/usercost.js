$(function(){
	$("#cost_name").change(function(event){
		var costId = $("#cost_name").val();
		$.ajax({
			url:"/manager/cost/findPrice.json",
			data:{id:costId},
			type:"POST",
			async:false,
			success:function(data){
				data = JSON.parse(data);
				if(data.data) {
					$("#price").val(data.data);
				}
			}
		})
		
		
	});
	
	$("#add_user_cost_btn").click(function(event){
		//验证表单,阻止元素中默认行为
		event.preventDefault();
		var costNum = $("#add_user_cost_form input[name='cost_num']").val().trim();
		var userId = $("#add_user_cost_form input[name='user_id']").val();
		var costId = $("#add_user_cost_form select[name='cost_name'] option:selected").val();
		console.info(costId)
		var userCostExist = false;
		var postData = {'user_id':userId,'cost_name':costId};
		$.ajax({
			url:"/manager/user_cost/validUserCost.json",
			data:postData,
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);
				if(rs.data.exist){
					userCostExist = true;
				}
			},
			error:function(data){
				return alert("请求失败");
			}
		});
		if(userCostExist == true){
			return alert("该住户已交该费用");
		}
		
		if(!costNum){
			return alert("数量不能为空");
		}
		
		//提交表单
		$("#add_user_cost_form").submit();
	});
	
	$(".user_cost_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/user_cost/del.do";
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