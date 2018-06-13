<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="UTF-8"/>
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0"/>
		<title>安全设置</title> <script type="text/javascript"
			src="../js/jquery-1.8.3.min.js"></script>
		<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
			<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
				type="text/css"/>
				<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
				<script src="../js/search_list.js"></script>
				<link href="../css/personal.css" rel="stylesheet" type="text/css"/>
					<link href="../css/infstyle.css" rel="stylesheet" type="text/css"/>
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
							function searchKeyword1() {
								var keyword1 = $("#searchInput2").val();
								window.location.href = "/product/search?keyword=" + keyword1;
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
			<span class="all-goods">全部分类</span>
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

				<!--标题 -->
				<div class="user-safety">
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">账户安全</strong> / <small>Set&nbsp;up&nbsp;Safety</small>
						</div>
					</div>
					<hr />

					<!--头像 -->
					<div class="user-infoPic">

						<div class="filePic">
							<img class="am-circle am-img-thumbnail" src="${user.pic}"
								onerror="javascript:this.src='<%=request.getContextPath()%>/images/getAvatar.do.jpg'"
								alt="" />
						</div>

						<p class="am-form-help">头像</p>
						<div class="info-m">
							<div>
								<b>用户名：<i>${user.nickname}</i></b>
							</div>
							<div class="u-level">
								<span class="rank r2"> <s class="vip1"></s><a
									class="classes" href="#">站内会员</a>
								</span>
							</div>

						</div>
					</div>

					<div class="check">
						<ul>
							<li><i class="i-safety-lock"></i>
								<div class="m-left">
									<div class="fore1">登录密码</div>
									<div class="fore2">
										<small>为保证您购物安全，建议您定期更改密码以保护账户安全。</small>
									</div>
								</div>
								<div class="fore3">
									<a href="/user/toCzPwd">
										<div class="am-btn am-btn-secondary">修改</div>
									</a>
								</div></li>
							<!--
                                <li>
									<i class="i-safety-wallet"></i>
									<div class="m-left">
										<div class="fore1">支付密码</div>
										<div class="fore2"><small>启用支付密码功能，为您资产账户安全加把锁。</small></div>
									</div>
									<div class="fore3">
										<a href="setpay.html">
											<div class="am-btn am-btn-secondary">立即启用</div>
										</a>
									</div>
								</li>
								-->
								<!-- 
							<li><i class="i-safety-iphone"></i>
								<div class="m-left">
									<div class="fore1">手机验证</div>
									<div class="fore2">
										<small>您验证的手机：186XXXXXXXX 若已丢失或停用，请立即更换</small>
									</div>
								</div>
								<div class="fore3">
									<a href="/user/toCzTel">
										<div class="am-btn am-btn-secondary">换绑</div>
									</a>
								</div></li> -->
							<!--<li>
									<i class="i-safety-mail"></i>
									<div class="m-left">
										<div class="fore1">邮箱验证</div>
										<div class="fore2"><small>您验证的邮箱：5831XXX@qq.com 可用于快速找回登录密码</small></div>
									</div>
									<div class="fore3">
										<a href="email.html">
											<div class="am-btn am-btn-secondary">换绑</div>
										</a>
									</div>
								</li>
								<li>
									<i class="i-safety-idcard"></i>
									<div class="m-left">
										<div class="fore1">实名认证</div>
										<div class="fore2"><small>用于提升账号的安全性和信任级别，认证后不能修改认证信息。</small></div>
									</div>
									<div class="fore3">
										<a href="idcard.html">
											<div class="am-btn am-btn-secondary">认证</div>
										</a>
									</div>
								</li>
								<li>
									<i class="i-safety-security"></i>
									<div class="m-left">
										<div class="fore1">安全问题</div>
										<div class="fore2"><small>保护账户安全，验证您身份的工具之一。</small></div>
									</div>
									<div class="fore3">
										<a href="question.html">
											<div class="am-btn am-btn-secondary">认证</div>
										</a>
									</div>
								</li>
								-->
						</ul>
					</div>

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

</body>

</html>