<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />

<title>消息通知</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />

<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/newstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.js"></script>
<script type="text/javascript">
	window.onload = function() {
		he()
		read_tf()
	}

	function del(ob, id) {
		var mymessage = confirm("确认删除？");
		if (mymessage == true) {
			window.location.href = "/user/delMsg?msgId=" + id;
		}
	}

	function he() {
		$(".index_new_box").each(function() {
			var num = $(this).parent(".am-tab-panel").height()
			$(this).height(num)
		})
	}
	//判断是否已读
	function read_tf() {
		for (i = 0; i < $(".news_list").length; i++) {
			if ($(".news_list").eq(i).find(".read").attr("name") == 0) {
				$(".news_list").eq(i).find(".read").text("未读").removeClass(
						"onread")

			} else {
				$(".news_list").eq(i).find(".read").text("已读").addClass(
						"onread")
			}
		}
	}
	//进行展开
	function read_top(ob) {
		if ($(ob).find(".read").attr("untf") == 0) {
			if ($(ob).find(".read").attr("name") == 0) {
				$(ob).find(".read").attr("name", "1");
				$(ob).find(".read").attr("untf", "1");
				$(ob).find(".new_t").removeClass("news_text");
			} else {
				$(ob).find(".read").attr("untf", "1");
				$(ob).find(".new_t").removeClass("news_text");
			}

		} else {
			$(ob).find(".read").attr("untf", "0")
			$(ob).find(".new_t").addClass("news_text")
		}
	}
	//点击事件，成功已读
	function read(ob, id) {
		//成功已读并且展开
		$.ajax({
			url : "/user/modifyMsgStatus?msgId=" + id, //地址
			dataType : "json",
			type : "post",
			timeout : 5000,
			success : function(data) {
				if (data.status == 1) {
					//成功已读并且展开
					read_top(ob)
					read_tf()
				}

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				/*alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);*/
				alert("请求超时,请重试!");
			},

		})
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
				<li><a href="../home.html"><img src="../images/logobig.png" /></a>
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
				<div class="user-news">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">我的消息</strong> / <small>News</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2" data-am-tabs>
						<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a href="#tab1">消息中心</a></li>
						</ul>
						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<!--消息 -->
								<ul>
									<c:forEach items="${msgs}" var="msg">
										<li onclick="read(this,'${msg.id}')">
											<div class="news_list">
												<b class="tab">官方</b> <strong>${msg.title}</strong> <span><date:date
														value="${msg.addtime}"></date:date></span>
												<!---->
												<b class="read onread" name="${msg.isRead}" untf="0"></b> <img
													src="../images/ca1.png" class="del"
													onclick="del(this,'${msg.id}')" />
												<div class="news_text new_t">
													<p>${msg.msg}</p>
												</div>
											</div>
										</li>
									</c:forEach>
								</ul>
								<!--<div class="order-pages">
										<input type="button" name="" id="" class="pages pages_down" value="下一页" onclick="pages(this)" />
										<span class="pages_num">1</span>
										<input type="button" name="" id="" class="pages pages_up" value="上一页" onclick="pages(this)" />
									</div>-->
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