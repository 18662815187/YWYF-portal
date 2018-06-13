<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>请选择支付方式</title>
<script src="../js/jquery-1.8.3.min.js"></script>
<script src="../js/payment.js"></script>
<link rel="stylesheet" type="text/css" href="../css/payment.css" />
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function first() {
		window.location.href = "/"
	}
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
	//点击用户名跳转个人中心
	function toUserCenter() {
		window.location.href = "/user/userCenter";
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
	function pay() {
		var type = $("input[name='payment']:checked").val();
		var oid = '${orderUtil.oid}';
		//alert(type + "----" + oid);
		window.location.href = "/order/startPay?oid=" + oid + "&type=" + type;
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
						<a href="#" id="uscc" onclick="toUserCenter()" target="_top">个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="/cart/toCart" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">${a}</strong></a>
					</div>
				</div>
				<!--  
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
						</div>
					</div>-->
					<!--  
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="../person/collection.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
					</div>
				</div>-->
			</ul>
		</div>
	</div>
	<div class="body_b">
		<div class="head">
			<img src="../images/logobig.png" onclick="first()"/> <span class="head_w_text"
				style="float: right; font-size: 18px; padding: 35px;">我的收银台</span>
		</div>

		<div class="body">

			<div class="container">
				<div class="fle">
					<div class="fle1">
						<p>
							<strong>订单提交成功，请尽快付款！订单号：</strong><span>${orderUtil.orderNum}</span>
						</p>
					</div>

					<div style="float: right; padding: 10px;">
						实际支付 <b id="payment_price">${orderUtil.totalFee}</b> 元<br />

					</div>
					<div class="tou_b">
						<div class="tou" onclick="details()">
							订单详情 <img src="../images/la.png" width="10px" class="details_sdf" />
						</div>
					</div>
					<div class="table_1" id="table_1">
						<div>
							收货地址：<span>${orderUtil.mailList.address}</span>收货人：<span>${orderUtil.mailList.name}
							</span>联系电话：<span>${orderUtil.mailList.tel}</span>
						</div>
						<div>
							商品名称：
							<p>${orderUtil.proName}</p>
						</div>
					</div>
				</div>

			</div>

			<table width="100%" class="table_2">
				<tr>
					<td>
						<div class="payment" >
							<input type="radio" name="payment" id="" value="0"
								checked="checked" style="padding-bottom: 10px;" /> <img
								src="../images/zifubao.png" width="28px" /> <span> 支付宝
							</span>

						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="payment " >
							<input type="radio" name="payment" id="" value="1" /> <img
								src="../images/weixing.png" width="25px" /> <span id="">
								微信 </span>
						</div>
					</td>
				</tr>
				<tr>
					<td><hr style="border: 1px dashed #cdcdcd; margin: 20px;" /></td>
				</tr>
				<tr>
					<td><input type="button" id="pay" class="pay" value="确认付款"
						onclick="pay()" /> <span>
							请您确认金额并完成支付，“院外要”提醒您，官方客服绝不会向您索要验证码或者密码！ </span></td>
				</tr>
			</table>

			<div style="text-align: center; margin-top: 15px; color: #666;">
				<span style="color: red">${msg}</span>
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
