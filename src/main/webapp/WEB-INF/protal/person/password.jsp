<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0"/>
		<title>修改密码</title>
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>

		<link href="../css/personal.css" rel="stylesheet" type="text/css"/>
		<link href="../css/stepstyle.css" rel="stylesheet" type="text/css"/>
		<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
		<script src="../js/search_list.js"></script>	
		<script src="../js/amazeui.js"></script>
		<script src="../js/person_pass.js"></script>
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
							$(function() {
								//初始化加载，触发click事件,选中第一个,li标签
								$("#address_ul_box li:first").trigger("click");
							});
							function searchKeyword() {
								var keyword = $("#searchInput").val();
								window.location.href = "/product/search?keyword=" + keyword;
							}
							function searchKeyword1() {
								var keyword1 = $("#searchInput2").val();
								window.location.href = "/product/search?keyword=" + keyword1;
							}
						</script>
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
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong> / <small>Password</small></div>
					</div>
					<hr/>
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">重置密码</p>
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
					<form class="am-form am-form-horizontal" id="jvForm">
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label">原密码</label>
							<div class="am-form-content">
								<input type="password" name="pwd" id="user-old-password" placeholder="请输入原登录密码" onblur="add_cue()">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-password" class="am-form-label">新密码</label>
							<div class="am-form-content">
								<input type="password" name="pwd1" id="user-new-password" placeholder="由数字、字母组合" onblur="add_cue()">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">确认密码</label>
							<div class="am-form-content">
								<input type="password" name="pwd2" id="user-confirm-password" placeholder="请再次输入上面的密码" onblur="add_cue()">
								<p><img src="../images/stop.png" style="width: 10px;margin-right: 3px;display: none;margin-top: 10px;" id="add_address_cue_img"/><small style="color: red;" id="add_address_cue"></small></p>
							</div>
							
						</div>
						
						<div class="info-btn">
							<div class="am-btn am-btn-danger" onclick="add_address()">保存修改</div>
						</div>

					</form>

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

	</body>

</html>