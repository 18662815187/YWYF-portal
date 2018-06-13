<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />
<title>我的评价</title>
<script src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/cmstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.js"></script>
<script type="text/javascript">
	window.onload = function() {
		for (i = 0; i < $(".comment_zhi").length; i++) {
			console.log($(".comment_zhi").eq(i).height())
			if ($(".comment_zhi").eq(i).height() > 15) {
				$(".comment_zhi").eq(i).addClass("comment_hide").attr("hides",
						"1")
			}
		}
	}

	function comm_on(ob) {
		if ($(ob).attr("hides") == 1) {
			$(ob).removeClass("comment_hide").attr("hides", "0")
		} else if ($(ob).attr("hides") == 0) {
			$(ob).addClass("comment_hide").attr("hides", "1")
		}
	}
	
</script>
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
				<li><a href="/"><img src="../images/logobig.png" /></a>
				</li>
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

				<div class="user-comment">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">评价管理</strong> / <small>Manage&nbsp;Comment</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-2 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a href="#tab1">所有评价</a></li>
						</ul>
						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="comment_table_w">
									<table>
										<thead>
											<tr>
												<th colspan="2">商品</th>
												<th>评论时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${pagination.list}" var="com">
												<tr>
													<td><img src="${com.product.pic}" onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'"/></td>
													<td>
														<p class="comment_tab_name">${com.product.name}</p>
													</td>
													<td><span><date:date value="${com.addtime}"/></span></td>
													<td>
														<p class="comment_tab_f1">
														<c:choose>
														<c:when test="${com.greade==0}"><label>好评</label></c:when>
														<c:when test="${com.greade==1}"><label>中评</label></c:when>
														<c:otherwise><label>差评</label></c:otherwise>
														</c:choose>
														</p>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<p class="comment_zhi " onclick="comm_on(this)"><span style="color:black">评论内容：</span>${com.content}</p>
													</td>
												</tr>
											</c:forEach>

										</tbody>

									</table>
								</div>
								<div class="order-pages">
									<div style="float: right;">
											<span style="font-size: 15px;">当前数据总数
												${pagination.totalCount} 条,单页最大显示 ${pagination.pageSize} 条.
											</span> &nbsp&nbsp&nbsp
											<c:forEach items="${pagination.pageView}" var="page">
				${page}
				</c:forEach>
										</div>
								</div>
							</div>
							<div class="am-tab-panel am-fade" id="tab2">

								<div class="comment-main">
									<div class="comment-list">
										<ul class="item-list">

											<div class="comment-top">
												<div class="th th-price">
													<td class="td-inner">评价</td>
												</div>
												<div class="th th-item">
													<td class="td-inner">商品</td>
												</div>
											</div>
											<li class="td td-item">
												<div class="item-pic">
													<a href="#" class="J_MakePoint"> <img
														src="../images/kouhong.jpg_80x80.jpg" class="itempic"></a>
												</div>
											</li>

											<li class="td td-comment">
												<div class="item-title">
													<div class="item-opinion">好评</div>
													<div class="item-name">
														<a href="#">
															<p class="item-basic-info">美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
														</a>
													</div>
												</div>
												<div class="item-comment">
													宝贝非常漂亮，超级喜欢！！！
													口红颜色很正呐，还有第两支半价，买三支免单一支的活动，下次还要来买。就是物流太慢了，还要我自己去取快递，店家不考虑换个物流么？
													<div class="filePic">
														<img src="../images/image.jpg" alt="">
													</div>
												</div>

												<div class="item-info">
													<div>
														<p class="info-little">
															<span>颜色：12#玛瑙</span> <span>包装：裸装</span>
														</p>
														<p class="info-time">2015-12-24</p>

													</div>
												</div>
											</li>

										</ul>

									</div>
								</div>

							</div>
						</div>
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