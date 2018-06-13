<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>绑定手机</title>
		<script src="../js/jquery-1.8.3.min.js"></script>	
		<link href="../css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/stepstyle.css" rel="stylesheet" type="text/css">
		<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script src="../js/search_list.js"></script>	
		<script src="../js/amazeui.js"></script>
		<script src="../js/person_bind.js"></script>
	</head>

	<body>
		<!--相关连接-->
		<div class="search_list_ul_box" >
			<div class="search_list_ul_box1">
				<div class="search_list_ul_box2">
					<ul class="search_list_ul" >
					</ul>
				</div>
			</div>
		</div>
		<!--相关连接-->
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<span>欢迎来到生医容美大药房！</span>
									<a href="../other/login.html" target="_top" class="h">亲，请登录</a>
									<a href="../other/register.html" target="_top">免费注册</a>
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage my-shangcheng" style="border-color: ;">
								<div class="menu-hd MyShangcheng"><a href="index.html" target="_top">个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="../other/shopcart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
							</div>
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
							</div>	
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="person/collection.html" target="_top"><i class="am-icon-user am-icon-fw"></i><span>客服中心</span></a></div>
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
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off" oninput="search_list()"  />
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="button" onclick="location.href='../other/search.html';" />
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
							</ul>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">绑定手机</strong> / <small>Bind&nbsp;Phone</small></div>
					</div>
					<hr/>
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">绑定手机</p>
                            </span>
							<span class="step-2 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                <p class="stage-name">完成</p>
                            </span>
							<span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner"></div>
						</div>
					</div>
					<form class="am-form am-form-horizontal" id="am-form-horizontal">
						
						<div class="am-form-group bind">
							<label for="user-phone" class="am-form-label">验证手机</label>
							<div class="am-form-content">
								<span id="user-phone">186XXXX0531</span>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-phone" class="am-form-label">验证手机</label>
							<div class="am-form-content">
								<input type="tel" id="user-new-phone" placeholder="绑定新手机号" maxlength="11" onblur="binding_phone()"/>
							</div>
						</div>
						<div class="am-form-group code">
							<label for="user-new-code" class="am-form-label">验证码</label>
							<div class="am-form-content">
								<input type="tel" id="user-new-code" placeholder="短信验证码" onblur="binding_phone()"/>
							</div>
							<a class="btn" href="javascript:void(0);" onclick="sendMobileCode(this);" id="sendMobileCode">
								<div class="am-btn am-btn-danger">验证码</div>
							</a>
						</div>
						<div class="cue_text_box" id="cue_text_box" style="opacity: 0;padding:10px 80px;">
								<img src="../images/stop.png" width="12px"/>
								<span id="cue_text" class="cue_text" style="color: #FF4200;">
								</span>
						</div>
						<div class="info-btn">
							<div class="am-btn am-btn-danger" onclick="binding_true()">保存修改</div>
						</div> 

					</form>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">杭州临武医药科技有限公司</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于临武医药</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="index.html">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
							<li> <a href="information.html">个人信息</a></li>
							<li class="active"> <a href="safety.html">安全设置</a></li>
							<li > <a href="address.html">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li> <a href="order.html">订单管理</a></li>
							<li> <a href="change.html">退款售后</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的小窝</a>
						<ul>
							<li> <a href="bill.html">账单明细</a></li>
							<li> <a href="collection.html">收藏</a></li>
							<li> <a href="comment.html">评价</a></li>
							<li> <a href="news.html">消息</a></li>
						</ul>
					</li>
				</ul>
			</aside>
		</div>

	</body>

</html>