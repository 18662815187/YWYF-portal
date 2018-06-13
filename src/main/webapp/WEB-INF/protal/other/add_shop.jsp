<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>成功加入购物车</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script src="../js/search_list.js"></script>
<script type="text/javascript" src="../js/search.js"></script>
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/seastyle.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<link href="../css/non_existent.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function toCart() {
		window.location.href="/cart/toCart?returnUrl="+encodeURIComponent(window.location.href);
	}
</script>
</head>

<body>
	<!--相关连接-->
	<div class="search_list_ul_box" onmouseout="search_hide()"
		onmouseover="search_show()">
		<div class="search_list_ul_box1">
			<div class="search_list_ul_box2">
				<ul class="search_list_ul">
				</ul>
			</div>
		</div>
	</div>
	<!--相关连接-->
	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<a>欢迎来到生医容美大药房！</a> <a href="login.html" target="_top" class="h">亲，请登录</a>
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
					<a id="mc-menu-hd" href="shopcart.html" target="_top"><i
						class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h">0</strong></a>
				</div>
			</div>
			<!-- 
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
				</div> -->
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="../person/collection.html" target="_top"><i
						class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
				</div>
			</div>
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="../images/logo.png" />
		</div>
		<div class="logoBig">
			<li><a href="../home.html"><img src="../images/logobig.png" /></a>
			</li>
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form>
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off" oninput="search_list()">
					<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="button" onclick="location.href='search.html';">
			</form>
		</div>
	</div>
	<!--悬浮搜索框-->
	<div class="float_search_box">
		<div class="float_search">
			<div class="float_search_b">
				<form>
					<input type="text" name="" id="searchInput2" placeholder="搜索"
						autocomplete="off" oninput="search_list()" /> <input
						type="button" name="" id="" value="搜索"
						onclick="location.href='search.html';" />
				</form>
			</div>
		</div>
	</div>
	<!--悬浮搜索框-->
	<div class="clear"></div>
	<b class="line"></b>
	<div class="search">
		<div class="search-list">
			<div class="nav-table">
				<div class="long-title">
					<span class="all-goods">加入购物车</span>
				</div>
				<div class="nav-cont">
					<ul>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--分类-->
	<div class="success_add_b">
		<div class="success_add_box">
			<div class="success_add_txt">
				<img src="../images/good.png" class="success_add" />
				<h2>商品已成功加入购物车！</h2>
			</div>
			<div class="success_add_pro">
				<img src="${sku.product.pic}"
					onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'"
					class="" />
				<p>
					<a href="introduction.html">${sku.product.name}</a>
				</p>
				<p>
					规格：<span>${sku.spec}</span>&nbsp;/&nbsp;数量：<span>${amount}</span>
				</p>
				<a class="see_shop" href="#" onclick="toCart()">去购物车结算</a> <a
					class="see_commodity" href="/product/query?id=${pid}">查看商品详情</a>
			</div>
		</div>
	</div>
	<div class="success_add_b1">
		<div class="existent_b2">

			<div class="recom_box">
				<div class="recom_head">商品推荐</div>
				<ul>
					<c:forEach items="${disProducts}" var="dis">
						<li class="recom_list"><a href="${dis.url}"> <img
								src="${dis.pic}"
								onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
								<div class="recommend_text text_box">
									<span>${dis.name}</span>
								</div> <!-- 
								<div class="recommend_text text_box">
									<span class="font_999">30g*5</span>
								</div>
								<div class="recommend_text">
									<span class="limit_text font_999">麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
								</div> -->
								<div class="recommend_text text_box red" style="color: red;">
									￥ <span>${dis.price}</span>
								</div>
						</a></li>
					</c:forEach>
				</ul>
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