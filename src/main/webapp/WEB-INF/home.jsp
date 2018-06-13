<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>医院处方药外配平台,处方外配,院外要</title>
<script src="js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/home.css" rel="stylesheet" type="text/css" />
<link href="css/hmstyle.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
<link href="css/new.css" rel="stylesheet" type="text/css" />
<link href="css/search_list.css" rel="stylesheet" type="text/css" />
<script src="js/search_list.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/home.js"></script>
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
	//点击用户名跳转个人中心
	function toUserCenter() {
		window.location.href = "/user/userCenter";
	}

	function proDatil(id) {
		var pid = Number(id);
		window.location.href = "/product/search?typeId=" + pid;
	}
	function funDatil(id) {
		var fid = Number(id);
		window.location.href = "/product/search?funId=" + fid;
	}
	function disDatil(id) {
		var did = Number(id);
		window.location.href = "/product/search?disId=" + did;
	}
	function ttNews() {
		window.location.href = "/text/list.do";
	}
	function searchKeyword() {
		var keyword = $("#searchInput").val();
		window.location.href = "/product/search?keyword=" + keyword;
	}
	function searchKeyword1() {
		var keyword1 = $("#searchInput2").val();
		window.location.href = "/product/search?keyword=" + keyword1;
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
	<!--动画效果-->
	<div class="animation"></div>
	<!--动画效果-->
	<!--搜索框提示-->
	<div class="search_list_ul_box" onmouseout="search_hide()"
		onmouseover="search_show()">
		<div class="search_list_ul_box1">
			<div class="search_list_ul_box2">
				<ul class="search_list_ul">
				</ul>
			</div>
		</div>
	</div>
	<!--搜索框提示-->
	<div class="hmtop">
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
							<a href="person/collection.html" target="_top"><i
								class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
						</div>
					</div>-->
					<!-- 
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="person/collection.html" target="_top"><i
								class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
						</div>
					</div> -->
				</ul>
			</div>

		</div>
		<!--顶部导航条 -->
		<!--悬浮搜索框-->
		<div class="nav white">
			<div class="logo">
				<img src="images/logo.png" onclick="first()" />
			</div>
			<div class="logoBig">
				<li><a href="#"><img src="images/logobig.png"
						onclick="first()" /></a></li>
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
		<!--悬浮搜索框-->
		<!--悬浮搜索框-->
		<div class="float_search_box">
			<div class="float_search">
				<div class="float_search_b">
					<form>
						<input type="text" name="" id="searchInput2" placeholder="搜索"
							autocomplete="off" oninput="search_list2();" /> <input
							type="button" name="" id="" value="搜索" onclick="searchKeyword1()" />
					</form>
				</div>
			</div>
		</div>
		<!--悬浮搜索框-->
		<div class="clear"></div>
	</div>

	<div class="banner">
		<!--轮播 -->
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<c:forEach items="${banners1}" var="b">
					<li class="banner1"><img src="${b.pic}"
						data-adaptive-background onclick="window.location.href='${b.url}'"
						onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div class="shopNav">
		<div class="slideall">
			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">

						<div class="category">
							<ul class="category-list" id="js_climit_li">
								<c:forEach items="${types}" var="type">
									<li class="appliance js_toggle relative first"
										onmouseover="list_b(this)" onmouseout="list_w(this)">
										<div class="category-info">
											<h3 class="category-name b-category-name">
												<i> <img src="${type.typeLogo}" />
												</i> <a href="#" onclick="proDatil('${type.id}')" class="ml-22"
													title="${type.typeName}">${type.typeName}</a>
												<p class="home_list_m" style="line-height: 1.5em;">
													<c:if test="${not empty type.funTypes}">
														<c:choose>
															<c:when test="${fn:length(type.funTypes)>3}">
																<a href="#" onclick="funDatil('${type.funTypes[0].id}')"><span>${type.funTypes[0].name}</span></a>
																<a href="#" onclick="funDatil('${type.funTypes[1].id}')"><span>${type.funTypes[1].name}</span></a>
																<a href="#" onclick="funDatil('${type.funTypes[2].id}')"><span>${type.funTypes[2].name}</span></a>
															</c:when>
															<c:otherwise>
																<c:forEach items="${type.funTypes}" var="fun">
																	<a href="#" onclick="funDatil('${fun.id}')"><span>${fun.name}</span></a>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</c:if>
												</p>
											</h3>
											<em>&gt;</em>
										</div>
										<div class="menu-item menu-in top">
											<div class="area-in">
												<div class="area-bg">
													<div class="menu-srot">
														<div class="sort-side">
															<c:forEach items="${type.funTypes}" var="f">
																<dl class="dl-sort">
																	<dt>
																		<span title="${f.name}" onclick="funDatil('${f.id}')">${f.name}</span>
																	</dt>
																	<c:forEach items="${f.diseases}" var="d">
																		<dd>
																			<a title="${d.name}" href="#"
																				onclick="disDatil('${d.id}')"><span>${d.name}</span></a>
																		</dd>
																	</c:forEach>
																</dl>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>
										</div> <b class="arrow"></b>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>

				</div>
			</div>

			<!--轮播-->

			<script type="text/javascript">
				(function() {
					$('.am-slider').flexslider();
				});
				$(document)
						.ready(
								function() {
									$("li")
											.hover(
													function() {
														$(
																".category-content .category-list li.first .menu-in")
																.css("display",
																		"none");
														$(
																".category-content .category-list li.first")
																.removeClass(
																		"hover");
														$(this).addClass(
																"hover");
														$(this)
																.children(
																		"div.menu-in")
																.css("display",
																		"block")
													},
													function() {
														$(this).removeClass(
																"hover")
														$(this).children(
																"div.menu-in")
																.css("display",
																		"none")
													});
								})
			</script>
			<!--走马灯 -->
			<!--商城头条 -->
			<div class="marqueen">
				<span class="marqueen-title" onclick="ttNews()">商城头条</span>
				<div class="demo">
					<ul class="title_news" id="title_news">
						<c:forEach items="${articles}" var="ar">
							<li class="title-first"><a target="_blank"
								href="/text/query?id=${ar.id}"> <span>${ar.title}</span>
							</a></li>
						</c:forEach>
					</ul>
					<div class="mod-vip">
						<div class="m-baseinfo">
							<a href="/user/userCenter"> <img src="${user.pic}"
								onerror="javascript:this.src='<%=request.getContextPath()%>/images/getAvatar.do.jpg'" /></a>
							<c:if test="${empty USER_NAME}">
								<em> Hi,<span class="s-name" onclick="">亲，请先登录</span>
								</em>
							</c:if>
							<em id="eem"> Hi,<span class="s-name" id="uus"
								onclick="toUserCenter('${uid}')"></span>
							</em>
						</div>
						<div class="member-logout">
							<a class="am-btn-warning btn" href="#" onclick="XXLogin()"
								id="lgg">登录</a> <a class="am-btn-warning btn" href="#"
								onclick="XXRegister()" id="regg">注册</a> <a
								class="am-btn-warning btn" href="#" onclick="XXLogout()"
								id="louu">注销</a> <a class="am-btn-warning btn" href="#"
								onclick="toUserCenter()" id="userCC">个人中心</a>
						</div>
						<div class="member-login">
							<a href="other/introduction.html"><strong>0</strong>待收货</a> <a
								href="other/introduction.html"><strong>0</strong>待发货</a> <a
								href="other/introduction.html"><strong>0</strong>待付款</a> <a
								href="other/introduction.html"><strong>0</strong>待评价</a>
						</div>
						<div class="clear"></div>
					</div>
					<div class="advTip">
						<c:forEach items="${banners5}" var="b5">
							<img src="${b5.pic}" onclick="window.location.href='${b5.url}'"
								onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong2.jpg'" />
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>


		<div class="advTip">
			<c:forEach items="${banners9}" var="b9">
				<img src="${b9.pic}"
					onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong2.jpg'" />
			</c:forEach>
		</div>
	</div>

	<div class="clear"></div>
	<!--商城头条 -->

	<script type="text/javascript">
		if ($(window).width() < 640) {
			function autoScroll(obj) {
				$(obj).find("ul").animate({
					marginTop : "-39px"
				}, 500, function() {
					$(this).css({
						marginTop : "0px"
					}).find("li:first").appendTo(this);
				})
			}
			$(function() {
				setInterval('autoScroll(".demo")', 3000);
			})
		}
	</script>

	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">
			<!--今日推荐 -->
			<div class="am-g am-g-fixed recommendation">
				<div class="clock am-u-sm-3"">
					<img src="images/2018.png" />
					<p>
						今日<br />推荐
					</p>
				</div>
				<div class="reco">
					<div class="reco_tj_b">
						<c:forEach items="${commend}" var="com">
							<div class="reco_tj">
								<a href="${com.url}"> <img src="${com.pic}"
									onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
									<div>
										<span>${com.name}</span>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="clear "></div>
			<!--中西药品-->
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>中西药品</h4>
					<span class="more "> <a href="/product/search?typeId=1">更多<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>
			<div class="am-g am-g-fixed floodFour ">
				<div class="commodity_table ">
					<div class="commodity_table_new">
						<div style="margin: auto; width: 200px;"
							class="commodity_table_td ">
							<div class="commodity_table_ad ">
								<div class="guan_ad">
									<c:forEach items="${banners2}" var="b2">
										<a href="${b2.url}"><img src="${b2.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong1.jpg'"
											class="guan_ad_img" /></a>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="commodity_table_cp">
							<c:forEach items="${type1}" var="t1">
								<div class="commodity_table_d">
									<a href="${t1.url}">
										<div style="text-overflow: ellipsis; position: relative;">
											<img src="${t1.pic} " class="comm_img "
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
										</div>
										<p class="commodity ">${t1.name}</p>
										<p style="color: red;">
											￥<span class="price ">${t1.price}</span>
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>

				</div>
			</div>
			<div class="clear "></div>

			<!--养生保健-->
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>养生保健</h4>
					<span class="more "> <a href="/product/search?typeId=2">更多<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>
			<div class="am-g am-g-fixed floodFour ">
				<div class="commodity_table ">
					<div class="commodity_table_new">
						<div style="margin: auto; width: 200px;"
							class="commodity_table_td ">
							<div class="commodity_table_ad ">
								<div class="guan_ad">
									<c:forEach items="${banners4}" var="b4">
										<a href="${b4.url}"><img src="${b4.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong1.jpg'"
											class="guan_ad_img" /></a>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="commodity_table_cp">
							<c:forEach items="${type2}" var="t2">
								<div class="commodity_table_d">
									<a href="${t2.url}">
										<div style="text-overflow: ellipsis; position: relative;">
											<img src="${t2.pic} " class="comm_img "
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
										</div>
										<p class="commodity ">${t2.name}</p>
										<p style="color: red;">
											￥<span class="price ">${t2.price}</span>
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>

				</div>
			</div>
			<div class="clear "></div>

			<!--医疗器械-->
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>医疗器械</h4>
					<span class="more "> <a href="/product/search?typeId=3">更多<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>
			<div class="am-g am-g-fixed floodFour ">
				<div class="commodity_table ">
					<div class="commodity_table_new">
						<div style="margin: auto; width: 200px;"
							class="commodity_table_td ">
							<div class="commodity_table_ad ">
								<div class="guan_ad">
									<c:forEach items="${banners3}" var="b3">
										<a href="${b3.url}"><img src="${b3.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong1.jpg'"
											class="guan_ad_img" /></a>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="commodity_table_cp">
							<c:forEach items="${type3}" var="t3">
								<div class="commodity_table_d">
									<a href="${t3.url}">
										<div style="text-overflow: ellipsis; position: relative;">
											<img src="${t3.pic} " class="comm_img "
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
										</div>
										<p class="commodity ">${t3.name}</p>
										<p style="color: red;">
											￥<span class="price ">${t3.price}</span>
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="clear "></div>

			<!--计生用品-->
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>计生用品</h4>
					<span class="more "> <a href="/product/search?typeId=9">更多<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>
			<div class="am-g am-g-fixed floodFour ">
				<div class="commodity_table ">
					<div class="commodity_table_new">
						<div style="margin: auto; width: 200px;"
							class="commodity_table_td ">
							<div class="commodity_table_ad ">
								<div class="guan_ad">
									<c:forEach items="${banners6}" var="b6">
										<a href="${b6.url}"><img src="${b6.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong1.jpg'"
											class="guan_ad_img" /></a>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="commodity_table_cp">
							<c:forEach items="${type9}" var="t9">
								<div class="commodity_table_d">
									<a href="${t9.url}">
										<div style="text-overflow: ellipsis; position: relative;">
											<img src="${t9.pic} " class="comm_img "
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
										</div>
										<p class="commodity ">${t9.name}</p>
										<p style="color: red;">
											￥<span class="price ">${t9.price}</span>
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="clear "></div>
			<!--中药饮片-->
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>中药饮片</h4>
					<span class="more "> <a href="/product/search?typeId=10">更多<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>
			<div class="am-g am-g-fixed floodFour ">
				<div class="commodity_table ">
					<div class="commodity_table_new">
						<div style="margin: auto; width: 200px;"
							class="commodity_table_td ">
							<div class="commodity_table_ad ">
								<div class="guan_ad">
									<c:forEach items="${banners7}" var="b7">
										<a href="${b7.url}"><img src="${b7.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong1.jpg'"
											class="guan_ad_img" /></a>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="commodity_table_cp">
							<c:forEach items="${type10}" var="t10">
								<div class="commodity_table_d">
									<a href="${t10.url}">
										<div style="text-overflow: ellipsis; position: relative;">
											<img src="${t10.pic} " class="comm_img "
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
										</div>
										<p class="commodity ">${t10.name}</p>
										<p style="color: red;">
											￥<span class="price ">${t10.price}</span>
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="clear "></div>
			<!--美容护肤-->
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>美容护肤</h4>
					<span class="more "> <a href="/product/search?typeId=11">更多<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>
			<div class="am-g am-g-fixed floodFour ">
				<div class="commodity_table ">
					<div class="commodity_table_new">
						<div style="margin: auto; width: 200px;"
							class="commodity_table_td ">
							<div class="commodity_table_ad ">
								<div class="guan_ad">
									<c:forEach items="${banners8}" var="b8">
										<a href="${b8.url}"><img src="${b8.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong1.jpg'"
											class="guan_ad_img" /></a>
									</c:forEach>
								</div>

							</div>
						</div>
						<div class="commodity_table_cp">
							<c:forEach items="${type11}" var="t11">
								<div class="commodity_table_d">
									<a href="${t11.url}">
										<div style="text-overflow: ellipsis; position: relative;">
											<img src="${t11.pic} " class="comm_img "
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
										</div>
										<p class="commodity ">${t11.name}</p>
										<p style="color: red;">
											￥<span class="price ">${t11.price}</span>
										</p>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="clear "></div>
			<div class="am-container ">
				<div class="shopTitle ">
					<h4>知名品牌</h4>
					<h3></h3>
					<span class="more "> <a href="/product/brandList">更多品牌<i
							class="am-icon-angle-right " style="padding-left: 10px;"></i></a>
					</span>
				</div>
			</div>

			<div class="producers wt">
				<ul>
					<c:forEach items="${brands}" var="brand">
						<li><a href="product/search?brandId=${brand.id} "> <img
								src="${brand.pic}"
								onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong2.jpg'" />
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="foot ">
				<div class="wt ">
					<p>
						<a href="/aboutUs"><span>关于我们</span></a>|  <a href="http://www.51ywyf.com/Pharmacy//register/toRegister" target=_blank><span>商家入驻</span></a>
						
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
		</div>
	</div>
	<!--引导 -->
	<div class="navCir ">
		<li class="active "><a href="home.html "><i
				class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html "><i class="am-icon-list "></i>分类</a></li>
		<li><a href="shopcart.html "><i
				class="am-icon-shopping-basket "></i>购物车</a></li>
		<li><a href="person/index.html "><i class="am-icon-user "></i>我的</a></li>
	</div>
	<!--  n -->

	<!--菜单 2018-5-22-->
	<div class="tip1">
		<div id="sidebar">
			<div id="wrap ">
				<div id="prof " class="item ">
					<a onclick="window.location.href='/user/userCenter'"> <span
						class="setting "></span>
					</a>
				</div>
				<div id="shopCart " class="item "
					onclick="window.location.href='/cart/toCart'">
					<a> <span class="message "></span>
					</a>
					<p>购物车</p>
					<p class="cart_num ">${countCart}</p>
				</div>

				<div class="quick_toggle">
				<!-- 
					<li class="qtitem "><a href="# "><span class="kfzx "></span></a>
					</li> -->
					<!--二维码 -->
					<li class="qtitem "><a href="#none " id="weixin_hover"><span
							class="mpbtn_qrcode "></span></a>
						<div class="mp_qrcode " style="display: none;">
							<img src="images/weixin_code_145.png " /><i
								class="icon_arrow_white "></i>
						</div>
						<div class="QR_weixin" style="display:none;">
							<div class="QR_weixin_d"></div>
							<img src="images/weixin_code_145.png" />
							<p>扫码关注微信公众号</p>
						</div></li>
					<li class="qtitem "><a href="#top " class="return_top "><span
							class="top "></span></a></li>
				</div>
				<!--回到顶部 -->
			</div>
		</div>

	</div>
	<script type="text/javascript">
		$("#weixin_hover").hover(function() {
			$(".QR_weixin").show();
		}, function() {
			$(".QR_weixin").hide();
		});
	</script>
	<!--菜单 2018-5-22-->
	<script>
		window.jQuery
				|| document.write('<script src="js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript " src="js/quick_links.js "></script>
</body>

</html>