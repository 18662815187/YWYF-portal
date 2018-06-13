<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>支付</title>
<script src="../js/jquery-1.8.3.min.js"></script>
<script src="../js/payment.js"></script>
<script src="../js/jquery.qrcode.min.js"></script>
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<link href="../css/wechat_pay.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		var codeUrl = $("#codeurl").val();//erWeiMa是后端传的二维码url
		$("#code").qrcode({
			render : "canvas", //table方式 
			width : 240, //宽度 
			height : 240, //高度 
			text : codeUrl
		});
		//每5S查询一次订单状态
		//setInterval("ajaxstatus()", 5000);
	});
</script>
<script type="text/javascript">
$(function() {
	//去判断是否登录 0、1
	$.ajax({
		url : "/login/isLogin.do",
		type : "post",
		dataType : "json",
		success : function(data) {
			//0、1判断
			//alert(data);
			if (data.status == 1) {
				$("#login").hide();
				$("#regist").hide();
				$("#usName").html(data.us);
				$("#uus").html(data.us);
				$("#lgg").hide();
				$("#regg").hide();
			} else {
				$("#logout").hide();
				$("#eem").hide();
				$("#uscc").hide();
				$("#louu").hide();
				$("#userCC").hide();
			}
		}
	});
})
	//每3S查询一次订单状态
	$(document).ready(function() {
		setInterval("ajaxstatus();", 3000);
	});
	function px(){
		alert(1);
	}
	function ajaxstatus() {
		var a = $("#out_trade_no").val();
		//alert(a);
		if (a != 0 && null != a) {
			$.ajax({
						url : "/order/queryStatus?payNum=" + a,
						type : "GET",
						dataType : "json",
						data : "",
						success : function(data) {
							//	 	            	alert(data);
							if (data.status == 1) { //订单状态为1表示支付成功
								window.location.href = "/weixinpay/pagesf?type=1&payNum="
										+ a; //页面跳转
							} else if(data.status==-1){
								window.location.href = "/weixinpay/pagesf?type=0&payNum="
										+ a;
							}
						},
						error : function() {
							alert("查询订单状态超时");
						}
					});
		}

	}
	//点击用户名跳转个人中心
	function toUserCenter() {
		window.location.href = "/user/userCenter";
	}
	function first() {
		window.location.href = "/"
	}
	function XXLogin() {
		//对携带的url进行转义，不转会导致回传的URL丢失数据encodeURIComponent
		window.location.href = "/login/toLogin?returnUrl="
				+ encodeURIComponent(window.location.href);
	}
	function XXRegister() {
		//对携带的url进行转义，不转会导致回传的URL丢失数据encodeURIComponent
		window.location.href = "/register/toRegister?returnUrl="
				+ encodeURIComponent(window.location.href);
	}
	function XXLogout() {
		window.location.href = "/login/exit";
	}
</script>
</head>
<body>
	<!--顶部导航条 -->
	<div style="background-color: #f1f1f1;">
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
						<div class="menu-hd">
							<a>欢迎来到医院处方药配送平台！</a> <a href="#" onclick="XXLogin()"
								target="_top" class="h" id="login">[亲，请登录]</a> <a href="#"
								onclick="XXRegister()" target="_top" id="regist">[免费注册]</a> <a
								href="javascript:;" onclick="XXLogout()" id="logout">[退出]</a><a
								href="#" id="usName" onclick="toUserCenter()"></a>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng">
							<a href="#" target="_top" id="uscc" onclick="toUserCenter()">个人中心</a>
						</div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="/cart/toCart" target="_top"><i
								class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
								id="J_MiniCartNum" class="h">${countCart}</strong></a>
						</div>
					</div>
				<!--  
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="../person/collection.html" target="_top"><i
							class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="../person/collection.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
					</div>
				</div>
				-->
			</ul>
		</div>
	</div>
	<div class="body_b">
		<div class="head">
			<img src="../images/logobig.png" onclick="first()"/> <span class="head_w_text"
				style="float: right; font-size: 18px; padding: 35px;">我的收银台</span>
		</div>
		<input type="hidden" id="codeurl" value="${urlCode}" /> <input
			type="hidden" id="out_trade_no" value="${payNum}" />
		<div class="body">

			<div class="container">
				<div class="fle">
					<div class="fle1">
						<p>
							<strong>订单提交成功，请尽快付款！订单号：</strong><span>${orders}</span>
						</p>
					</div>

					<div style="float: right; padding: 10px;">
						实际支付 <b id="payment_price">${total}</b> 元<br />

					</div>
				</div>

			</div>

			<div class="wechat_pay">
				<div class="wechat_time">
					<span>微信支付</span> <span class="">如提示二维码过期，请刷新页面重新获取二维码。</span> <span>${msg}</span>
				</div>
				<div id="code" class="QR_code">
					<!--  
				<img src="../images/two.png" / class="QR_code">-->
				</div>
				<div class="wechat_cue">
					<img src="../images/jiaodian.png" />
					<p>请使用微信扫一扫</p>
					<p>扫描 二维码支付</p>
				</div>
				<img src="../images/phone-bg.png" class="wechat_img" />
				<!--  
					<div class="wechat_back">
						<img src="../images/left.png"/>
						<a href="payment.html">选择其他支付方式</a>
					</div>-->
			</div>

			<div style="text-align: center; margin-top: 15px; color: #666;">
				注意:<span>请核对订单金额尽快完成支付!</span>
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