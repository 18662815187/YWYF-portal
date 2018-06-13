<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
	<title>通知、公告、信息提示</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
			<meta name="format-detection" content="telephone=no">
				<meta name="renderer" content="webkit">
					<meta http-equiv="Cache-Control" content="no-siteapp" />
					<script src="../js/jquery-1.8.3.min.js"></script>

					<link href="../css/admin.css" rel="stylesheet" type="text/css">
						<link href="../AmazeUI-2.4.2/assets/css/amazeui.css"
							rel="stylesheet" type="text/css">
							<link href="../css/personal.css" rel="stylesheet" type="text/css">
								<link href="../css/search_list.css" rel="stylesheet"
									type="text/css" />
								<script src="../js/search_list.js"></script>
</head>
<body>
	<!--相关连接-->
	<div class="search_list_ul_box">
		<div class="search_list_ul_box1">
			<div class="search_list_ul_box2">
				<ul class="search_list_ul">
				</ul>
			</div>
		</div>
	</div>
	<!--相关连接-->
	<!--头 -->
	<header> <article>
	<div class="mt-logo">
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<span>欢迎来到医院处方药外配平台！</span> <a href="../other/login.html"
							target="_top" class="h">亲，请登录</a> <a
							href="../other/register.html" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="index.html" target="_top">个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="../other/shopcart.html" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">0</strong></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="person/collection.html" target="_top"><i
							class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="person/collection.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
					</div>
				</div>
			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="nav white">
			<div class="logoBig">
				<li><a href="../home.html"><img src="../images/logobig.png" /></a></li>
			</div>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form>
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off" oninput="search_list()">
						<input id="ai-topsearch" class="submit am-btn" value="搜索"
						index="1" type="button"
						onclick="location.href='../other/search.html';">
				</form>
			</div>
		</div>

		<div class="clear"></div>
	</div>
	</div>
	</article> </header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">${title}</span>
		</div>
		<div class="nav-cont">
			<ul>
			</ul>
		</div>
	</div>
	<b class="line"></b>
	<!--文章 -->
	<div class="am-g am-g-fixed blog-g-fixed bloglist">
		<div class="am-u-md-9">
			<article class="blog-main">
			<h3 class="am-article-title blog-title">
				<a href="#">${article.title}</a>
			</h3>
			<h4 class="am-article-meta blog-meta">
				<date:date value="${article.addtime} " />
			</h4>

			<div class="am-g blog-content">
				<div class="am-u-sm-12">${article.content}</div>

			</div>
			</article>
			<hr class="am-article-divider blog-hr">
				<ul class="am-pagination blog-pagination">

				</ul>
		</div>

		<div class="am-u-md-3 blog-sidebar">
			<div class="am-panel-group">

				<section class="am-panel am-panel-default">
				<div class="am-panel-hd">热门话题</div>
				<ul class="am-list blog-list">
					<c:forEach items="${ars}" var="ar">
						<li><a href="/text/query?id=${ar.id}"><p>${ar.title}</p></a></li>
					</c:forEach>
				</ul>
				</section>

			</div>
		</div>

	</div>

	<div class="footer">
		<div class="footer-hd">
			<p>
				<a href="#">杭州临武医药科技有限公司</a> <b>|</b> <a href="#">商城首页</a> <b>|</b>
				<a href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
			</p>
		</div>
		<div class="footer-bd">
			<p>
				<a href="#">关于临武医药</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
					href="#">网站地图</a>
			</p>
		</div>
	</div>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="{{assets}}js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="js/amazeui.min.js"></script>

</body>
</html>
