<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/dlstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	/* 刷新生成验证码 */
	function flushValidateCode() {
		var validateImgObject = document.getElementById("codeValidateImg");
		validateImgObject.src = "/getSysManageLoginCode?time=" + new Date();
	}
	$(document).ready(function() {
		//验证码
		//createCode();
		flushValidateCode();
	})
	function XXRegister() {
		var a = $("#returnUrl").val();
		if (null != a && "" != a) {
			window.location.href = "/register/toRegister?returnUrl=" + encodeURIComponent(a);
		}else{
			window.location.href = "/register/toRegister";
		}
		
	}
	function first(){
		window.location.href="/"
	}
</script>
</head>
<body>
	<div class="login-boxtitle">
		<a href="#" onclick="first()"><img alt="logo" src="../images/logobig.png" /></a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span>
			</div>
			<div class="login-box">

				<h3 class="title">登录</h3>

				<div class="clear"></div>

				<div class="login-form">
					<form id="jvForm">
						<input type="hidden" id="returnUrl" name="returnUrl"
							value="${returnUrl}" />
						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i></label> <input
								type="text" name="tel" id="user" placeholder="手机号码"
								onblur="login()" maxlength="11" value="${loginUtil.user.tel}"
								onkeyup="value=value.replace(/[^\d]/g,'')" />
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i></label> <input
								type="password" name="password" id="password" onblur="login()"
								value="${loginUtil.user.pwd}" placeholder="请输入密码" />
						</div>
						<div class="user-pass user-test">
							<label for="password"><i class="am-icon-code-fork"></i></label> <input
								type="text" name="verifyCode" id="user-test" onblur="login()"
								placeholder="请输入图形验证码" /> <img src="../images/2016.png"
								id="codeValidateImg" onclick="javascript:flushValidateCode();" />
						</div>
					</form>
				</div>

				<div class="login-links">
					<label for="remember-me"><input id="remember-me"
						type="checkbox" onclick="mima()" />记住密码</label> <br />
				</div>
				<div class="cue_text_box" id="cue_text_box" style="opacity: 0;">
					<img src="../images/stop.png" /> <span id="cue_text"
						class="cue_text"> 你输入的手机号码格式不正确 </span>
				</div>
				<div class="am-cf">
					<input type="button" name="" value="登 录"
						class="am-btn am-btn-primary am-btn-sm" onclick="login_true()" />
					<label for="remember-me " /><a href="#"
						class="am-fr text_login_14" onclick="XXRegister()">立即注册</a></label> <a
						href="/user/toModifyPwd" class="am-fr text_login_14">忘记密码</a>
				</div>
			</div>
		</div>
	</div>

	<div class="foot ">
				<div class="wt ">
					<p>
						<a href="/aboutUs"><span>关于我们</span></a>|  <a href="# "><span>商家入驻</span></a>
						
					</p>
					<p>
						<div>
							<a href="http://www.miibeian.gov.cn" target=_blank><span>湘ICP备18006584号</span></a>
						</div>
					</p>
					<p>©2013-2018版权所有 杭州临武医药科技有限公司</p>
					<p></p>
				</div>
			</div>
</body>

</html>