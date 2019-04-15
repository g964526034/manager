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
			url:"/manager/user/validId.json",
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
		if(idExist == true){
			return alert("身份证号已存在，该用户已注册");
		}
		
		//验证手机号
		var telExist = false;
		if( !telFormat.test(tel)){
			return alert("手机号格式不合法");
		}
		//验证手机号是否已经存在
		$.ajax({
			url:"/manager/user/validTel.json",
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
		if(telExist == true){
			return alert("电话号码已存在");
		}
		
		//验证email
		var emailExist = false;
		if(!emailFormat.test(email)){
			return alert("邮箱格式不合法");
		}
		//验证email是否已经存在
		$.ajax({
			url:"/manager/user/validEmail.json",
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
		if(emailExist == true){
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
		var url = "/manager/user/del.do";
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
				location.href = "/manager/user/doBrowse.do";
			} else {
				alert("修改失败");
			}
		})
	});
	
	$("#register_user_btn").click(function(event){
		event.preventDefault();
		
		var tel = $("#register_user_form input[name='tel']").val().trim();
		var email = $("#register_user_form input[name='email']").val().trim();
		var pwd = $("#register_user_form input[name='pwd']").val().trim();
		var repwd = $("#register_user_form input[name='repwd']").val().trim();
		
		var existte = true;
		$.ajax({
			url:"/manager/user/existTelEmail.json",
			data:{'tel':tel,'email':email},
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);
				if(!rs.data.exist){
					existte = false;
				}
			},
			error:function(data){
				return alert("请求失败");
			}
		});
		if(existte == false){
			return alert("电话号码或邮箱输入错误");
		}
		
		var existPwd = false;
		$.ajax({
			url:"/manager/user/existPwd.json",
			data:{'tel':tel,'email':email},
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);
				if(rs.data.exist){
					existPwd = true;
				}
			},
			error:function(data){
				return alert("请求失败");
			}
		});
		if(existPwd == true){
			return alert("该住户已注册");
		}
		
		if(!pwd){
			return alert("密码不能为空");
		}
		
		if(pwd != repwd) {
			return alert("两次密码不相同");
		}
		//提交表单
		$("#register_user_form").submit();
	});
	
	$("#changepwd_user_btn").click(function(event){
		event.preventDefault();
		
		var tel = $("#changepwd_user_form input[name='tel']").val().trim();
		var email = $("#changepwd_user_form input[name='email']").val().trim();
		var pwd = $("#changepwd_user_form input[name='pwd']").val().trim();
		var newpwd = $("#changepwd_user_form input[name='newpwd']").val().trim();
		var repwd = $("#changepwd_user_form input[name='repwd']").val().trim();
		
		if(!tel){
			return alert("手机号码不能为空");
		}
		if(!email){
			return alert("邮箱不能为空");
		}
		if(!pwd){
			return alert("旧密码不能为空");
		}
		if(!newpwd){
			return alert("新密码不能为空");
		}
		if(newpwd != repwd){
			return alert("两次密码不相等，请重新输入");
		}
		
		$("#changepwd_user_form").submit();
	});
});