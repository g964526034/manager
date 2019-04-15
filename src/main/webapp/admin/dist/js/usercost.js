$(function(){
	$("#cost_name").change(function(event){
		alert();
//		$.ajax({
//			url:"/manager/user_cost/edit",
//			data:{'cost_id':email},
//			type:"POST",
//			async:true,//异步请求
//	})
		
	})
	
	$("#add_user_cost_btn").click(function(event){
		//验证表单,阻止元素中默认行为
		event.preventDefault();
		var costNum = $("#add_user_cost_form input[name='cost_num']").val().trim();
		if(!costNum){
			return alert("数量不能为空");
		}
		
		//提交表单
		$("#add_user_cost_form").submit();
	})
})