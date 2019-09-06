<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8"/>
	<title>房地产后台管理系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<%@include file="/back/base/header.jsp"%>
	<style type="text/css">
		.login {
		  background-color: #444 !important;
		}
		
		.login .logo {
		  margin: 0 auto;
		  margin-top: 60px;
		  padding: 15px;
		  text-align: center;
		}
		
		.login .content {
		  background-color: #fff;
		  width: 360px;
		  margin: 0 auto;
		  margin-bottom: 0px;
		  padding: 30px;
		  padding-top: 20px;
		  padding-bottom: 15px;
		}
		
		.login .content h3 {
		  color: #000;
		}
		
		.login .content h4 {
		  color: #555;
		}
		
		.login .content p {
		  color: #222;
		}
		
		.login .content .login-form,
		.login .content .forget-form {
		  padding: 0px;
		  margin: 0px;
		}
		
		.login .content .input-icon {
		  border-left: 2px solid #35aa47 !important;
		}
		
		.login .content .input-icon .form-control {
		  border-left: 0;
		}
		
		.login .content .forget-form {
		  display: none;
		}
		
		.login .content .register-form {
		  display: none;
		}
		
		.login .content .form-title {
		  font-weight: 300;
		  margin-bottom: 25px;
		}
		
		.login .content .form-actions {
		  background-color: #fff;
		  clear: both;
		  border: 0px;
		  border-bottom: 1px solid #eee;
		  padding: 0px 30px 25px 30px;
		  margin-left: -30px;
		  margin-right: -30px;
		}
		
		.login .content .form-actions .checkbox {
		  margin-left: 0;
		  padding-left: 0;
		}
		
		.login .content .forget-form .form-actions {
		  border: 0;
		  margin-bottom: 0;
		  padding-bottom: 20px;
		}
		
		.login .content .register-form .form-actions {
		  border: 0;
		  margin-bottom: 0;
		  padding-bottom: 0px;
		}
		
		.login .content .form-actions .checkbox {
		  margin-top: 8px;
		  display: inline-block;
		}
		
		.login .content .form-actions .btn {
		  margin-top: 1px;
		}
		
		.login .content .forget-password {
		  margin-top: 25px;
		}
		
		.login .content .create-account {
		  border-top: 1px dotted #eee;
		  padding-top: 10px;
		  margin-top: 15px;
		}
		
		.login .content .create-account a {
		  display: inline-block;
		  margin-top: 5px;
		}
		
		/* select2 dropdowns */
		.login .content .select2-container {
		  border-left: 2px solid #35aa47 !important;
		}
		
		.login .content .select2-container .select2-choice {
		  border-left: none !important;
		}
		
		.login .content .select2-container i {
		  display: inline-block;
		  position: relative;
		  color: #ccc;
		  z-index: 1;
		  top: 1px;
		  margin: 4px 4px 0px -1px;
		  width: 16px;
		  height: 16px;
		  font-size: 16px;
		  text-align: center;
		}
		
		.login .content .has-error .select2-container i {
		  color: #b94a48;
		}
		
		.login .content .select2-container a span {
		  font-size: 13px;
		}
		
		.login .content .select2-container a span img {
		  margin-left: 4px;
		}
		
		/* footer copyright */
		.login .copyright {
		  text-align: center;
		  margin: 0 auto;
		  padding: 10px;
		  color: #999;
		  font-size: 13px;
		}
		
		@media (max-width: 480px) {
		  /***
		  Login page
		  ***/
		  .login .logo {
		    margin-top: 10px;
		  }
		
		  .login .content {
		    width: 280px;
		  }
		
		  .login .content h3 {
		    font-size: 22px;
		  }
		
		  .login .checkbox {
		    font-size: 13px;
		  }
		}
	</style>
	<body class="login">
	<!-- BEGIN LOGO -->
		<div class="logo">
			<img src="/HouseMS/static/img/logo-big.png" alt=""/>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN LOGIN -->
		<div class="content" style="height:237px;">
			<!-- BEGIN LOGIN FORM -->
			<form class="login-form" action="javascript:void(0)" method="post">
				<h3 class="form-title">账号登录</h3>
				<div class="form-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
					<label class="control-label visible-ie8 visible-ie9">登录名</label>
					<div class="input-icon">
						<i class="fa fa-user"></i>
						<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="登录名" id="username" name="username"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" id="password" name="password"/>
					</div>
				</div>
				<div class="form-actions" style="border-bottom:0px;">
					<button type="botton" id="submit" class="btn green pull-right" style="background-color:#35aa47;width:100px;">
						登录
					</button>
				</div>
			</form>
			<!-- END LOGIN FORM -->
			<!-- END REGISTRATION FORM -->
		</div>
		<!-- END LOGIN -->
		<!-- BEGIN CORE PLUGINS -->
		<!--[if lt IE 9]>
		<!-- END PAGE LEVEL SCRIPTS -->
	</body>
	<!-- END BODY -->
	<script>
		$(function(){
			$("#submit").click(function(){
				var username = $("#username").val();
				var password = $("#password").val();
				if(username == null || username == "")
					layer.alert("请输入登录名");
				if(password == null || password == "")
					layer.alert("请输入密码");
				$.ajax({
					type: "post",
					url: "/HouseMS/sysUser/userLogin.action",
					data:{
						username: username,
						password: password
					},
					success:function(data){
						layer.closeAll('loading');
						data = eval("(" + data + ")");
						layer.msg(data.message);
						if(data.succ){
							setTimeout("location.href='/HouseMS/sysUser/loginSucc.action'", 1500);
						}
	        		},
	        		beforeSend:function(){
						layer.load(1, {
							shade: [0.1, '#fff']
						});
					},
					error: function(){
						layer.closeAll("loading");
					}
				})
			})
		})
	</script>
</html>