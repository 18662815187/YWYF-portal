<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta charset="UTF-8">
	<title>重置密码</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
			<meta name="format-detection" content="telephone=no">
				<meta name="renderer" content="webkit">
					<meta http-equiv="Cache-Control" content="no-siteapp" />

					<link rel="stylesheet"
						href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
					<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
						<link href="../css/new.css" rel="stylesheet" type="text/css">
							<script src="../js/jquery.min.js"></script>
							<script src="../js/amazeui.min.js"></script>
							<script type="text/javascript">
								function sendMobileCode(ob) {
									if ($(ob).find("span").text() == "获取") {
										if (null != $("#phone").val()
												&& "" != $("#phone").val()) {
											$(ob).find("span").css({
												"background-color" : "#cdcdcd",
												"color" : "#fff",
												"border-color" : "#cdcdcd"
											})
											var times = ""
											var num = 120
											times = setInterval(
													function() {
														num--
														if (num <= 0) {
															clearInterval(times); //清除js定时器
															$(ob).find("span").disabled = false;
															$(ob).find("span")
																	.text("获取");
															nums = 120; //重置时间
															$(ob)
																	.find(
																			"span")
																	.css(
																			{
																				"background-color" : "#0b74df",
																				"color" : "#fff",
																				"border-color" : "#0b74df"
																			})
														} else {
															$(ob).find("span")
																	.text(num);
														}
													}, 1000);
										}
										$.ajax({
											url : '/czPwdSms', //地址
											dataType : "json",
											data : $('#jvForm').serialize(),
											type : "post",
											timeout : 50000,
											success : function(data) {
												//alert(data.msg);
												$("#token").attr("value",
														data.token);
												$("#cue_text").html(data.msg);
												$("#cue_text_box").css(
														"opacity", "1")
												//alert($("#token").val());
											},
											error : function(XMLHttpRequest,
													textStatus, errorThrown) {
												/*alert(XMLHttpRequest.status);
												alert(XMLHttpRequest.readyState);
												alert(textStatus);*/
												alert("网络请求失败，请联系网站管理员!");
											},

										})
									} else {
										$("#cue_text").html("手机号不能为空!");
										$("#cue_text_box").css("opacity", "1")
									}
								}
								var register_phone = false
								function register() {
									var password1 = $("#password1").val()
									var passwordRepeat1 = $("#passwordRepeat1")
											.val()

									if ($("#phone").val() == ""
											|| $("#phone").val().length < 11) {
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
									} else {
										$("#cue_text_box").css("opacity", "0")
										register_phone = true
									}
								}
								function register_true() {
									register()
									if (register_phone == true) {
										alert("修改成功")
										window.location.href = 'login.html'
									}
								}
								function czApply() {
									window.location.href = "/user/czPwdApply?tel="
											+ $("#phone").val()
											+ "&pwd="
											+ $("#password1").val()
											+ "&pwd1="
											+ $("#passwordRepeat1").val()
											+ "&code="
											+ $("#code").val()
											+ "&token="
											+ $("#token").val();
								}
							</script>
</head>

<body>

	<div class="login-boxtitle">
		<a href="/"><img alt="" src="../images/logobig.png" /></a>
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
						<li><a href="">忘记密码</a></li>
					</ul>

					<div class="am-tabs-bd">

						<div class="am-tab-panel">
							<form id="jvForm" action="/user/czPwdApply" method="post">
								<input type="hidden" name="token" id="token" />
								<div class="user-phone">
									<label for="phone"><i
										class="am-icon-mobile-phone am-icon-md"></i></label> <input
										onblur="register()" type="tel" name="tel" id="phone"
										placeholder="请输入手机号" maxlength="11" var="${tel}"
										onkeyup="value=value.replace(/[^\d]/g,'')">
								</div>
								<div class="verification">
									<label for="code"><i class="am-icon-code-fork"></i></label> <input
										onblur="register()" type="tel" name="code" id="code"
										placeholder="请输入验证码"> <a class="btn"
										href="javascript:void(0);" onclick="sendMobileCode(this);"
										id="sendMobileCode"> <span id="dyMobileButton">获取</span></a>
								</div>
								<div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i></label> <input
										onblur="register()" type="password" name="pwd" id="password1"
										placeholder="设置新密码">
								</div>
								<div class="user-pass">
									<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
									<input onblur="register()" type="password" name="pwd1"
										id="passwordRepeat1" placeholder="确认密码" />
								</div>
							</form>
							<div class="cue_text_box" id="cue_text_box" style="opacity: 1;">
								 <span id="cue_text"
									class="cue_text">${msg}</span>
							</div>
							<div class="am-cf">
								<input type="button" name="" value="修改密码"
									class="am-btn am-btn-primary am-btn-sm am-fl"
									onclick="czApply()">
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