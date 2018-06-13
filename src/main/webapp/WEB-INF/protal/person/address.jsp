<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0"/>
		<title>地址管理</title> <script src="../js/jquery-1.8.3.min.js"></script>
		<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
			<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
				type="text/css"/>

				<link href="../css/personal.css" rel="stylesheet" type="text/css"/>
					<link href="../css/addstyle.css" rel="stylesheet" type="text/css"/>
						<script src="../js/jquery.min.js" type="text/javascript"></script>
						<script src="../js/amazeui.js"></script>
						<script src="../js/person_address.js"></script>
						<link href="../css/search_list.css" rel="stylesheet"
							type="text/css" />
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
								<div class="menu-hd"><a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
							</div>	-->
				<!--  
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="../person/collection.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
					</div>
				</div>-->
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

				<div class="user-address">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small>
						</div>
					</div>
					<hr />
					<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails"
						id="address_ul_box">
						<c:forEach items="${mails}" var="mail">
							<li class="user-addresslist"><input type="hidden" id="XXID"
								value="${mail.id}" /> <span class="new-option-r" onclick=""><i
									id="is_default" class="am-icon-check-circle"></i>
								<c:if test="${mail.isDefault}">默认地址</c:if> <c:if
										test="${!mail.isDefault}">
										<span onclick="window.location.href='/user/setDefault?mailId=${mail.id}'">设置为默认地址</span>
									</c:if> </span>
								<p class="new-tit new-p-re">
									<span class="new-txt">${mail.name}</span> <span
										class="new-txt-rd2">${mail.tel}</span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">地址：</span> <span
											class="buy--address-detail">${mail.address}</span>
									</p>
								</div>
								<div class="new-addr-btn">
									<a onclick="rewrite_address(this)"><i class="am-icon-edit"></i>编辑</a>
									<span class="new-addr-bar">|</span> <a
										href="javascript:void(0);" onclick="delClick(this);"><i
										class="am-icon-trash"></i>删除</a>
								</div></li>
						</c:forEach>
					</ul>
					<span style="color: red; font-weight: bold; margin: 10px">${msg}</span>
					<div class="clear"></div>
					<a class="new-abtn-type"
						data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>

					<!--例子-->
					<div class="am-modal am-modal-no-btn" id="doc-modal-1">

						<div class="add-dress">

							<!--标题 -->
							<div class="am-cf am-padding">
								<div class="am-fl am-cf">
									<strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small>
								</div>
							</div>
							<hr />

							<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">

								<form id="jvForm" action="/user/mailSOU"
									class="am-form am-form-horizontal">
									<input type="hidden" name="id" id="mid" />
									<div class="am-form-group">
										<label for="user-name" class="am-form-label">收货人</label>
										<div class="am-form-content">
											<input type="text" name="name" id="user-name"
												placeholder="收货人" onblur="add_cue()">
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-phone" class="am-form-label">手机号码</label>
										<div class="am-form-content">
											<input id="user-phone" name="tel" placeholder="手机号必填"
												type="text" onblur="add_cue()">
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-form-label">详细地址</label>
										<div class="am-form-content">
											<textarea class="" rows="3" id="user-intro" name="address"
												placeholder="输入详细地址" onblur="add_cue()"></textarea>
											<small>100字以内写出你的详细地址...</small>
											<p>
												<img src="../images/stop.png"
													style="width: 10px; margin-right: 3px; display: none;"
													id="add_address_cue_img" /><small style="color: red;"
													id="add_address_cue"></small>
											</p>
										</div>
									</div>

									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<input class="am-btn am-btn-danger" type="submit" value="保存" />
											<!--  
												<a class="am-btn am-btn-danger" onclick="add_address()">保存</a>-->
											<a href="javascript: void(0)"
												class="am-close am-btn am-btn-danger" data-am-modal-close
												onclick="cancel()">取消</a>
										</div>
									</div>
								</form>
							</div>

						</div>

					</div>

				</div>

				<script type="text/javascript">
					$(document).ready(
							function() {
								$(".new-option-r").click(
										function() {
											$(this).parent('.user-addresslist')
													.addClass("defaultAddr")
													.siblings().removeClass(
															"defaultAddr");
										});

								var $ww = $(window).width();
								if ($ww > 640) {
									$("#doc-modal-1").removeClass(
											"am-modal am-modal-no-btn")
								}

							})
				</script>

				<div class="clear"></div>

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

					<li><a href="/user/toSafety">安全设置</a></li>
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