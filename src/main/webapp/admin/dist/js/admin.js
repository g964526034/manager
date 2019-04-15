$(function(){
	$("#add_admin_btn").click(function(event){
		//验证表单,阻止元素中默认行为
		event.preventDefault();
		telFormat = /^1[0-9]{10}$/;
		emailFormat = /^[_0-9a-zA-Z]{1,}@[_0-9a-zA-Z]{1,}\.((com)|(cn))$/;
		
		var tel = $("#add_admin_form input[name='tel']").val().trim();
		var email = $("#add_admin_form input[name='email']").val().trim();
		var realName = $("#add_admin_form input[name='real_name']").val().trim();
		var pwd = $("#add_admin_form input[name='pwd']").val().trim();
		var repwd = $("#add_admin_form input[name='repwd']").val().trim();
		
		
		//验证手机号
		var telExist = false;
		if( !telFormat.test(tel)){
			return alert("手机号格式不合法");
		}
		//验证手机号是否已经存在
		$.ajax({
			url:"/manager/app/admin/validTel",
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
			url:"/manager/app/admin/validEmail",
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
		
		if(!realName){
			return alert("姓名不能为空");
		}
		
		if(!pwd){
			return alert("密码不能为空");
		}
		
		if(pwd != repwd) {
			return alert("两次密码不相同");
		}
		
		//提交表单
		$("#add_admin_form").submit();
	});
	
	$(".admin_del_btn").click(function(event){
		event.preventDefault();
		var sure = confirm("确定要删除该条信息吗");
		if(!sure){
			return;
		}
		var id = $(this).attr("data-id");
		var url = "/manager/app/admin/del";
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
	
	$("#update_admin_btn").click(function(){
		var marriage = $("#update_admin_form input[name='marriage']").val();
		var work = $("#update_admin_form input[name='work']").val().trim();
		var salary = $("#update_admin_form input[name='salary']").val().trim();
		var privilege = $("#update_admin_form input[name='privilege']").val();
		
		if(!work){
			return alert("工作岗位不能为空");
		}
		if(!salary){
			return alert("薪水不能为空");
		}
		var url = $("#update_admin_form").attr("action");
		var postData = $("#update_admin_form").serialize();
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200){
				alert("修改成功");
				location.href = "/manager/app/admin/browse";
			} else {
				alert("修改失败");
			}
		})
	});
});