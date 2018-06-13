<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />
<title>个人中心</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/systyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/person_index.js"></script>
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script type="text/javascript">
	function info() {
		window.location.href = "/user/info";
	}
	function userCenter() {
		window.location.href = "/user/userCenter";
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
	function searchKeyword() {
		var keyword = $("#searchInput").val();
		window.location.href = "/product/search?keyword=" + keyword;
	}
</script>
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
						<a href="#" onclick="XXLogin()" target="_top" class="h" id="login">[亲，请登录]</a>
						<a href="#" onclick="XXRegister()" target="_top" id="regist">[免费注册]</a>
						<a href="javascript:;" onclick="XXLogout()" id="logout">[退出]</a>&nbsp<a
							href="#" id="usName" onclick="toUserCenter()"></a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="/" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="#" id="uscc" onclick="toUserCenter()" target="_top"><i
							class="am-icon-user am-icon-fw"></i>个人中心</a>
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
						<div class="menu-hd"><a href="collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>-->
			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="nav white">
			<div class="logoBig">
				<li><a href="/"><img src="../images/logobig.png" /></a></li>
			</div>

			<div class="search-bar pr">
				<div class="search_qw">
					<a name="index_none_header_sysc" href="other/introduction.html"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text"
							placeholder="搜索" autocomplete="off" oninput="search_list();" />
						<input id="ai-topsearch" class="submit am-btn" value="搜索"
							index="1" type="button" onclick="searchKeyword()" />
					</form>
				</div>
			</div>
		</div>

		<div class="clear"></div>
	</div>
	</div>
	</article> </header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">个人中心</span>
		</div>
		<div class="nav-cont">
			<ul>
			</ul>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">
				<div class="wrap-left">
					<div class="wrap-list">
						<div class="m-user">
							<!--个人信息 -->
							<div class="m-bg"></div>
							<div class="m-userinfo">
								<div class="m-baseinfo">
									<a href="information.html"> <img src="${user.pic}"
										onerror="javascript:this.src='<%=request.getContextPath()%>/images/getAvatar.do.jpg'" />
									</a> <em class="s-name">${user.nickname}<span class="vip1" /></em>
									<div class="s-prestige am-btn am-round">站内会员</div>
								</div>
								<div class="m-right">
									<div class="m-new">
										<a href="/user/msgList"><i class="am-icon-bell-o"></i>查看消息通知<span class="hint_num">+${msgNum}</span></a>
									</div>
									<div class="m-address">
										<a href="/user/mailList" class="i-trigger">我的收货地址</a>
									</div>
								</div>
							</div>

						</div>
						<div class="box-container-bottom"></div>

						<!--订单 -->
						<div class="m-order">
							<div class="s-bar">
								<i class="s-icon"></i>我的订单 <a class="i-load-more-item-shadow"
									href="/order/orderList">全部订单</a>
							</div>
							<ul>
								<li><a href="/order/orderList?type=0"><i><img
											src="../images/pay.png" /></i><span>待付款<em class="m-num">${a}</em></span></a></li>
								<li><a href="/order/orderList?type=1"><i><img
											src="../images/send.png" /></i><span>待发货<em class="m-num">${b}</em></span></a></li>
								<li><a href="/order/orderList?type=2"><i><img
											src="../images/receive.png" /></i><span>待收货<em class="m-num">${c}</em></span></a></li>
								<li><a href="/order/orderList?type=3"><i><img
											src="../images/comment.png" /></i><span>待评价<em
											class="m-num">${d}</em></span></a></li>
								<li><a href="/order/toChange"><i><img
											src="../images/refund.png" /></i><span>售后<em class="m-num">${e}</em></span></a></li>
							</ul>
						</div>
						<!--九宫格-->
						<div class="user-patternIcon">
							<div class="s-bar">
								<i class="s-icon"></i>我的常用
							</div>
							<ul>

								<a href="../other/shopcart.html"><li class="am-u-sm-4"><i
										class="am-icon-shopping-basket am-icon-md"></i><img
										src="../images/iconbig.png" />
										<p>购物车</p></li></a>
								<a href="collection.html"><li class="am-u-sm-4"><i
										class="am-icon-heart am-icon-md"></i><img
										src="../images/iconsmall1.png" />
										<p>我的收藏</p></li></a>
								<a href="../home.html"><li class="am-u-sm-4"><i
										class="am-icon-gift am-icon-md"></i><img
										src="../images/iconsmall0.png" />
										<p>为你推荐</p></li></a>
								<a href="comment.html"><li class="am-u-sm-4"><i
										class="am-icon-pencil am-icon-md"></i><img
										src="../images/iconsmall3.png" />
										<p>好评宝贝</p></li></a>
								<a href="/order/orderList"><li class="am-u-sm-4"><i
										class="am-icon-clock-o am-icon-md"></i><img
										src="../images/iconsmall2.png" />
										<p>订单管理</p></li></a>
							</ul>
						</div>
						<!--最新订单 -->
							<div class="m-logistics">

								<div class="s-bar">
									<i class="s-icon"></i>最新订单
								</div>
								<div class="s-content">
									<div class="lg-list-hide">
										暂无最新订单
									</div>
									<ul class="lg-list">
									<c:forEach items="${orders}" var="o">
										<li class="lg-item">
											<div class="item-info">
												<a href="../other/introduction.html">
													<img src="${o.orderProduct.sku.product.pic}" />
												</a>
											</div>
											<div class="lg-info">
												<p>${o.orderProduct.sku.product.name}</p>
												<label>下单时间：<span><date:date value="${o.addtime}" /></span></label><br />
											</div>
											<div class="lg-confirm" >
												<a class="i-btn-typical" href="/order/orderInfo?oid=${o.id}">查看详情</a>
											</div>
										</li>
									</c:forEach>	
									</ul>
									<div class="lg-list_too">
										<img src="../images/break.png" class="img_break"/ >
										<a href="/order/orderList">查看更多</a>
									</div>
								</div>
							</div>
							<!--最新订单 -->

						<!--收藏夹 -->
						<!--  
							<div class="you-like">
								<div class="s-bar">我的收藏
									<a class="am-badge am-badge-danger am-round">降价</a>
									<a class="am-badge am-badge-danger am-round">下架</a>
									<a class="i-load-more-item-shadow"href="collection.html" ><i class="am-icon-refresh am-icon-fw"></i>查看全部</a>
								</div>
								<div class="s-content">
									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/0-item_pic.jpg_220x220.jpg" alt="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰" title="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">42.50</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">68.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰">包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 98.03%</span>
												<span class="s-sales">月销: 219</span>

											</div>
										</div>
									</div>

									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/1-item_pic.jpg_220x220.jpg" alt="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰" title="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">49.90</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">88.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰">s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.74%</span>
												<span class="s-sales">月销: 69</span>

											</div>
										</div>
									</div>

									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/-0-saturn_solar.jpg_220x220.jpg" alt="4折抢购!十二生肖925银女戒指,时尚开口女戒" title="4折抢购!十二生肖925银女戒指,时尚开口女戒" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">378.00</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">1888.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="4折抢购!十二生肖925银女戒指,时尚开口女戒">4折抢购!十二生肖925银女戒指,时尚开口女戒</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.93%</span>
												<span class="s-sales">月销: 278</span>

											</div>
										</div>
									</div>

									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/0-item_pic.jpg_220x220.jpg" alt="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰" title="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">42.50</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">68.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰">包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 98.03%</span>
												<span class="s-sales">月销: 219</span>

											</div>
										</div>
									</div>

									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/1-item_pic.jpg_220x220.jpg" alt="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰" title="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">49.90</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">88.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰">s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.74%</span>
												<span class="s-sales">月销: 69</span>

											</div>
										</div>
									</div>

									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/-0-saturn_solar.jpg_220x220.jpg" alt="4折抢购!十二生肖925银女戒指,时尚开口女戒" title="4折抢购!十二生肖925银女戒指,时尚开口女戒" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">378.00</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">1888.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="4折抢购!十二生肖925银女戒指,时尚开口女戒">4折抢购!十二生肖925银女戒指,时尚开口女戒</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.93%</span>
												<span class="s-sales">月销: 278</span>

											</div>
										</div>
									</div>
									
									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/-0-saturn_solar.jpg_220x220.jpg" alt="4折抢购!十二生肖925银女戒指,时尚开口女戒" title="4折抢购!十二生肖925银女戒指,时尚开口女戒" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">378.00</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">1888.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="4折抢购!十二生肖925银女戒指,时尚开口女戒">4折抢购!十二生肖925银女戒指,时尚开口女戒</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.93%</span>
												<span class="s-sales">月销: 278</span>

											</div>
										</div>
									</div>
									
									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/-0-saturn_solar.jpg_220x220.jpg" alt="4折抢购!十二生肖925银女戒指,时尚开口女戒" title="4折抢购!十二生肖925银女戒指,时尚开口女戒" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">378.00</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">1888.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="4折抢购!十二生肖925银女戒指,时尚开口女戒">4折抢购!十二生肖925银女戒指,时尚开口女戒</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.93%</span>
												<span class="s-sales">月销: 278</span>

											</div>
										</div>
									</div>
									
									<div class="s-item-wrap">
										<div class="s-item">

											<div class="s-pic">
												<a href="../other/introduction.html" class="s-pic-link">
													<img src="../images/-0-saturn_solar.jpg_220x220.jpg" alt="4折抢购!十二生肖925银女戒指,时尚开口女戒" title="4折抢购!十二生肖925银女戒指,时尚开口女戒" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">378.00</em></span>
												<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">1888.00</em></span>

											</div>
											<div class="s-title"><a href="#" title="4折抢购!十二生肖925银女戒指,时尚开口女戒">4折抢购!十二生肖925银女戒指,时尚开口女戒</a></div>
											<div class="s-extra-box">
												<span class="s-comment">好评: 99.93%</span>
												<span class="s-sales">月销: 278</span>

											</div>
										</div>
									</div>
								</div>

							</div>-->

					</div>
				</div>
				<div class="wrap-right">

					<!-- 日历-->
					<div class="day-list">
						<div class="s-bar">
							<a class="i-history-trigger s-icon" href="#"></a>我的日历 <a
								class="i-setting-trigger s-icon" href="#"></a>
						</div>
						<div class="s-care s-care-noweather">
							<div class="s-date">
								<em id="time_date">21</em> <span id="time_day">星期一</span> <span
									id="time_year">2015.12</span>
							</div>
						</div>
					</div>
					<!--广告位-->
					<div class="preson_ad_box">
						<div class="preson_ad_list">
							<c:forEach items="${banners}" var="b">
								<img src="${b.pic}"
									onclick="window.location.href='${b.url}'"
									onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong3.jpg'" />
							</c:forEach>
						</div>
					</div>
					<!--广告位-->

				</div>
			</div>
			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p>
						<a href="/">杭州临武医药科技有限公司</a> <b>|</b> <a href="/">商城首页</a> <b>|</b>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="/aboutUs">关于我们</a>
					</p>
				</div>
			</div>

		</div>

		<aside class="menu">
		<ul>
			<li class="person" class="active"><a href="/user/userCenter">个人中心</a>
			</li>
			<li class="person"><a href="#" onclick="userCenter()">个人资料</a>
				<ul>
					<li><a href="#" onclick="info()">个人信息</a></li>
					 
				<li> <a href="/user/toSafety">安全设置</a></li>
					<li><a href="/user/mailList">收货地址</a></li>
				</ul></li>
			<li class="person"><a href="/order/orderList">我的交易</a>
				<ul>
					<li><a href="/order/orderList">订单管理</a></li>
					<li><a href="/order/toChange">售后管理</a></li>
				</ul></li>
			<li class="person"><a href="#">我的小窝</a>
				<ul>
					<li><a href="/user/toBill">账单明细</a></li>
					<!--  
					<li><a href="collection.html">收藏</a></li>-->
					<li><a href="/user/commList">评价</a></li>
					<li><a href="/user/msgList">消息</a></li>
				</ul></li>
		</ul>
		</aside>
	</div>
	<!--引导 -->
	<div class="navCir">
		<li><a href="../home.html"><i class="am-icon-home "></i>首页</a></li>
		<li><a href="../sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="../other/shopcart.html"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li class="active"><a href="index.html"><i
				class="am-icon-user"></i>我的</a></li>
	</div>
</body>

</html>