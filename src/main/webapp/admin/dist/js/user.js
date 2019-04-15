$(function(){
	$("#add_user_btn").click(function(event){
		//验证表单,阻止元素中默认行为
		event.preventDefault();
		idFormat = /^1[0-9]{16}[0-9X]$/;
		telFormat = /^1[0-9]{10}$/;
		emailFormat = /^[_0-9a-zA-Z]{1,}@[_0-9a-zA-Z]{1,}\.((com)|(cn))$/;
		
		var id = $("#add_user_form input[name='id']").val().trim();
		var tel = $("#add_user_form input[name='tel']").val().trim();
		var houseMessage = $("#add_user_form input[name='house_message']").val().trim();
		var email = $("#add_user_form input[name='email']").val().trim();
		var name = $("#add_user_form input[name='name']").val().trim();
		
		
		if(!name){
			return alert("姓名不能为空");
		}
		
		//验证身份证号
		var idExist = false;
		if( !idFormat.test(id)){
			return alert("身份证号格式不合法");
		}
		//验证身份证号是否存在
		$.ajax({
			url:"/manager/app/user/validId",
			data:{'id':id},
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);
				if(rs.data.exist){
					idExist = true;
				}
			},
			error:function(data){
				return alert("请求失败");
			}
		});
		if(idExist){
			return alert("身份证号已存在，该用户已注册");
		}
		
		//验证手机号
		var telExist = false;
		if( !telFormat.test(tel)){
			return alert("手机号格式不合法");
		}
		//验证手机号是否已经存在
		$.ajax({
			url:"/manager/app/user/validTel",
			data:{'tel':tel},
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);
				if(rs.data.exist){
					telExist = true;
				}
			},
			error:function(data){
				return alert("请求失败");
			}
		});
		if(telExist){
			return alert("电话号码已存在");
		}
		
		//验证email
		var emailExist = false;
		if(!emailFormat.test(email)){
			return alert("邮箱格式不合法");
		}
		//验证email是否已经存在
		$.ajax({
			url:"/manager/app/user/validEmail",
			data:{'email':email},
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);
				if(rs.data.exist){
					emailExist = true;
				}
			},
			error:function(data){
				return alert("请求失败");
			}
		});
		if(emailExist){
			return alert("该邮箱号已存在");
		}
		
		if(!houseMessage){
			return alert("房屋信息不能为空");
		}
		
		//提交表单
		$("#add_user_form").submit();
	});
	
	$(".user_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var userId = $(this).attr("data-id");
		var url = "/manager/app/user/del";
		$.get(url,{"user_id":userId},function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("删除成功");
				location.reload();
			} else{
				alert("删除失败");
			}
		});
	});
	
	$("#update_user_btn").click(function(){
		var houseMessage = $("#update_user_form input[name='house_message']").val().trim();
		var houseSituation = $("#update_user_form input[name='house_situation']").val();
		var parkMessage = $("#update_user_form input[name='park_message']").val().trim();
		var more = $("#update_user_form input[name='more']").val();
		
		if(!houseMessage){
			return alert("住房信息不能为空");
		}
		var url = $("#update_user_form").attr("action");
		var postData = $("#update_user_form").serialize();
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/app/user/browse";
			} else {
				alert("修改失败");
			}
		})
	});
});