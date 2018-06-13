<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta charset="UTF-8" />
<title>注册</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/dlstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script type="text/javascript">
	function sendMobileCode(ob) {
		if ($(ob).find("span").text() == "获取") {
			if(null!=$("#phone").val()&&""!=$("#phone").val()){
				$(ob).find("span").css({
					"background-color" : "#cdcdcd",
					"color" : "#fff",
					"border-color" : "#cdcdcd"
				})
				var times = ""
				var num = 120
				times = setInterval(function() {
					num--
					if (num <= 0) {
						clearInterval(times); //清除js定时器
						$(ob).find("span").disabled = false;
						$(ob).find("span").text("获取");
						nums = 120; //重置时间
						$(ob).find("span").css({
							"background-color" : "#0b74df",
							"color" : "#fff",
							"border-color" : "#0b74df"
						})
					} else {
						$(ob).find("span").text(num);
					}
				}, 1000);
				$.ajax({
					url : '/sendSms', //地址
					dataType : "json",
					data : $('#jvForm').serialize(),
					type : "post",
					timeout : 50000,
					success : function(data) {
						//alert(data.msg);
						$("#token").attr("value", data.token);
						$("#cue_text").html(data.msg);
						$("#cue_text_box").css("opacity","1")
						//alert($("#token").val());
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						/*alert(XMLHttpRequest.status);
						alert(XMLHttpRequest.readyState);
						alert(textStatus);*/
						alert("网络请求失败，请联系网站管理员!");
					},

				})
			}else{
				$("#cue_text").html("手机号不能为空!");
				$("#cue_text_box").css("opacity","1")
			}
		}
		
	}
	var register_phone = false
	function register() {
		var password1 = $("#password1").val()
		var passwordRepeat1 = $("#passwordRepeat1").val()

		if ($("#phone").val() == "" || $("#phone").val().length < 11) {
			$("#cue_text").text("你输入的手机号码格式不正确")
			$("#cue_text_box").css("opacity", "1")
			register_phone = false
		} else if ($("#code").val() == "") {
			$("#cue_text").text("你输入的验证码为空")
			$("#cue_text_box").css("opacity", "1")
			register_phone = false
		} else if ($("#password1").val() == "") {
			$("#cue_text").text("你输入的设置密码为空")
			$("#cue_text_box").css("opacity", "1")
			register_phone = false
		} else if ($("#passwordRepeat1").val() == "") {
			$("#cue_text").text("你输入的确认密码为空")
			$("#cue_text_box").css("opacity", "1")
			register_phone = false
		} else if (password1 != passwordRepeat1) {
			$("#cue_text").text("你输入的两次密码不一样")
			$("#cue_text_box").css("opacity", "1")
			register_phone = false
		} else if ($("#reader-me1").is(':checked') == false) {
			$("#cue_text").text(" 请勾选同意按钮")
			$("#cue_text_box").css("opacity", "1")
			register_phone = false
		} else {
			$("#cue_text_box").css("opacity", "0")
			register_phone = true
		}
	}

	function register_true() {

		register()

		if (register_phone == true) {
			$.ajax({
				url : '/register/apply', //地址
				dataType : "json",
				data : $('#jvForm').serialize(),
				type : "post",
				timeout : 5000,
				success : function(data) {
					alert(data.msg);
					if (data.status == 10000) {
						window.location.href = "/login/toLogin";
					} else {
						window.location.href = "/register/toRegister";
					}

					//alert($("#token").val());
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					/*alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);*/
					alert("网络请求失败，请联系网站管理员!");
				},

			})
		}
	}
	
	function first(){
		window.location.href="/"
	}
</script>
</head>

<body>

	<div class="login-boxtitle">
		<a href="#" onclick="first()"><img alt="" src="../images/logobig.png" /></a>
	</div>

	<div class="res-banner">
		<div class="res-main">
			<div class="login-banner-bg">
				<span></span><img src="" />
			</div>
			<div class="login-box">

				<div class="am-tabs" id="doc-my-tabs">
					<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
						<!-- <li class="am-active">
								<a href="">邮箱注册</a>
							</li>-->
						<li><a href="">手机号注册</a></li>
					</ul>

					<div class="am-tabs-bd">

						<div class="am-tab-panel">
							<form id="jvForm" method="post">
							<input type="hidden" name="returnUrl" value="${returnUrl}" />
								<input type="hidden" name="token" id="token" /> <input
									type="hidden" name="addType" value="2" />
								<div class="user-phone">
									<label for="phone"><i
										class="am-icon-mobile-phone am-icon-md"></i></label> <input
										onblur="register()" type="tel" name="tel" id="phone"
										placeholder="请输入手机号" maxlength="11"
										onkeyup="value=value.replace(/[^\d]/g,'')" />
								</div>
								<div class="verification">
									<label for="code"><i class="am-icon-code-fork"></i></label> <input
										onblur="register()" type="tel" name="code" id="code"
										placeholder="请输入验证码" /> <a class="btn"
										href="javascript:void(0);" onclick="sendMobileCode(this);"
										id="sendMobileCode"> <span id="dyMobileButton">获取</span></a>
								</div>
								<div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i></label> <input
										onblur="register()" type="password" name="pwd" id="password1"
										placeholder="设置密码" />
								</div>
								<div class="user-pass">
									<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
									<input onblur="register()" type="password" name="pwd1"
										id="passwordRepeat1" placeholder="确认密码" />
								</div>
							</form>
							<div class="login-links">
								<label for="reader-me"> <input id="reader-me1"
									type="checkbox" checked="checked"> 点击表示您同意商城《服务协议》 </label>
							</div>
							<div class="cue_text_box" id="cue_text_box" style="opacity: 0;">
								<img src="../images/stop.png" /> <span id="cue_text"
									class="cue_text"> 你输入的手机号码格式不正确 </span>
							</div>
							<div class="am-cf">
								<input type="button" name="" value="注册"
									class="am-btn am-btn-primary am-btn-sm am-fl"
									onclick="register_true()">
							</div>

						</div>

						<script>
							$(function() {
								$('#doc-my-tabs').tabs();
							})
						</script>

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