<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="x-ua-compatible" content="IE=10" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>支付异常</title>

		<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
		<link href="../css/sustyle.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="../js/jquery-1.7.min.js"></script>
		<link href="../css/new.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../css/demo.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<!--顶部导航条 -->
		<div style="background-color: #f1f1f1;">
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
							<a>欢迎来到生医容美大药房！</a>
							<a href="login.html" target="_top" class="h">亲，请登录</a>
							<a href="register.html" target="_top">免费注册</a>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng">
							<a href="../person/index.html" target="_top">个人中心</a>
						</div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="shopcart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a>
						</div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
						</div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="../person/collection.html" target="_top"><i class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
						</div>
					</div>
				</ul>
			</div>
		</div>
		

		<!--悬浮搜索框-->


		<div class="clear"></div>

		<div class="take-delivery">
			<div class="status">
				<img src="../images/sty-ca.png" class="icon"/>
				<h2 style="color: #cc0000;">支付异常</h2>
				<div class="successInfo" >
					<div>
						<del>付款金额<del>¥${total}</del></del>
						<div class="user-info">
							<p>支付流水号：<span>${payNum}</span></p>
						</div>${msg}<c:if test="${empty msg}">
						支付异常，可能存在商品已被下架，如有资金错误，请联系客服。</c:if>

					</div>
					<div class="option">
						<span class="info">您可以</span>
						<a href="/" class="J_MakePoint">返回<span>首页</span></a>
						<a href="/order/orderList" class="J_MakePoint">查看<span>买到的宝贝</span></a>
					</div>
				</div>
				<div class="take_img">
					<img src="../images/2019.png"/ >
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