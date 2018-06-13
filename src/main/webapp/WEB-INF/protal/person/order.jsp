<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />
<title>订单管理</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/orstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/person_order.js"></script>
<script type="text/javascript">
	/*每次刷新执行*/
	$(document).ready(function() {
		//var type = ${type};
		var type = $("#XXTYPE").val();
		//var type = 0
		//alert(type);
		if (type == "" || type == null || type == "undefined") {
			$(".am-avg-sm-5").find("li").removeClass("am-active");
			$(".am-avg-sm-5 li").eq(0).addClass("am-active")
		} else if (type == 0) {
			$(".am-avg-sm-5").find("li").removeClass("am-active");
			$(".am-avg-sm-5 li").eq(1).addClass("am-active")
		} else if (type == 1) {
			$(".am-avg-sm-5").find("li").removeClass("am-active");
			$(".am-avg-sm-5 li").eq(2).addClass("am-active")
		} else if (type == 2) {
			$(".am-avg-sm-5").find("li").removeClass("am-active");
			$(".am-avg-sm-5 li").eq(3).addClass("am-active")
		} else if (type == 3) {
			$(".am-avg-sm-5").find("li").removeClass("am-active");
			$(".am-avg-sm-5 li").eq(4).addClass("am-active")
		}
	})

	/**/
	window.onload = function() {
		$(".order_table")
				.each(
						function() {
							var leng = $(this).find("tbody tr").length
							for (i = 1; i < leng; i++) {
								$(this).find("tbody tr").eq(i).find(
										".order_tab_hide").empty();
								$(this).find("tbody tr").eq(i).find(
										".order_tab_hide").css("border-top",
										"#fff");
								$(this).find("tbody tr").eq(i - 1).find(
										".order_tab_hide").css("border-bottom",
										"#fff");
							}
						})

	};
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
</script>
<script type="text/javascript">
	/*点击*/
	function order(id) {
		//$(".am-avg-sm-5").find("li").removeClass("am-active")
		//$(ob).addClass("am-active")
		window.location.href = "/order/orderList?type=" + id;
	}
	//立即支付
	function order_pay(oid) {
		window.location.href = "/order/orderToPayment?oid=" + oid
				+ "&returnUrl=" + encodeURIComponent(window.location.href);
	}
	/*物流状态*/
	//弹框
	function logistics(ob,number) {
		$.ajax({
			url: "/order/expressQuery?number="+number,
			dataType: "json",
			type: "post",
			success: function(data) {
				var strhtml = ""; //设定空值
				var exp = ""
				var zhu = 0;
				var ku = ""
				var quhtml =""
				var numbers =""
				if(data.status==0){
					for(var i = 0; i < data.result.list.length; i++) //循环
					{
						strhtml += '<li class="logistics_list"><p><span>' + data.result.list[i].time + '</span></p><p><label>' + data.result.list[i].status + '</label></p></li>' //整个值修改
					}
					//快递
					ku = data.result.type
					if(ku == "sto") {
						exp = "申通快递"
					} else if(ku == "sfexpress") {
						exp = "顺丰快递"
					} else if(ku == "yto") {
						exp = "圆通快递"
					} else if(ku == "yunda") {
						exp = "韵达快递"
					} else if(ku == "zto") {
						exp = "中通快递"
					} else if(ku == "EMS") {
						exp = "EMS快递"
					} else if(ku == "deppon") {
						exp = "德邦快递"
					} else if(ku == "htky") {
						exp = "百世快递"
					}else if(ku == "ttkdex") {
						exp = "天天快递"
					}else {
						exp = "其他快递（" + ku + "）"
					}
					//订单状态
					zhu = data.result.deliverystatus
					if(zhu == 1) {
						issign = "物流在途中"
					} else if(zhu == 2) {
						issign = "物流已经在派送"
					} else if(zhu == 3) {
						issign = "物流已经签收"
					}  else if(zhu == 4) {
						issign = "物流派送失败（拒收等）"
					}
					//物流单号
					numbers = data.result.number
					
				}
				else{
					exp = "暂无物流信息"
					issign = "暂无物流信息"
					strhtml  = "暂无物流信息"
					numbers = "暂无物流信息"
				}
				//添加物流
				quhtml = '<div class="black_box"><div class="logistics_box"><div class="logistics_tou"><span>物流动态</span><span><img src="../images/ca1.png" onclick="logistics_del()"/></span></div><div class="logistics_head"><p class="logistics_state">物流状态：<span></span></p><p class="logistics_company">物流公司：<span></span></p><p class="logistics_numbers">快递单号：<span></span></p><p>平台电话：<span>0571-8373-1253</span></p></div><ul class="logistics_body" id="logistics_body">' + strhtml + '</ul></div></div>'
				$(ob).parents("body").append(quhtml); //添加到页面
				//添加物流状态
				$(".logistics_state span").text(issign);
				$(".logistics_company span").text(exp)
				$(".logistics_numbers span").text(numbers)
				$(".logistics_box").show();
				$("body").addClass("ovfHiden")
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			},
		});
	}
	/*物流信息删除*/
	function logistics_del() {
		$(".black_box").remove()
		$("body").removeClass("ovfHiden")
	}
	//去评论
	function toComm(id){
		window.location.href="/order/toComm?oid="+id;
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
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">
				<div class="user-order">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active" onclick="order('')"><a href="#tab1">所有订单</a>
							</li>
							<li onclick="order(0)"><a href="#tab2">待付款</a></li>
							<li onclick="order(1)"><a href="#tab3">待发货</a></li>
							<li onclick="order(2)"><a href="#tab4">待收货</a></li>
							<li onclick="order(3)"><a href="#tab5">待评价</a></li>
						</ul>
						<input type="hidden" id="XXTYPE" value="${type}" />
						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<c:forEach items="${pagination.list}" var="order">
											<!--交易成功-->
											<div class="order-status5 order-del">
												<table class="order_table">
													<thead>
														<tr>
															<td colspan="2">订单编号：<span>${order.orderNum}</span></td>
															<td colspan="5">下单时间：<span><date:date
																		value="${order.addtime}" /></span></td>
																		<td><img src="../images/del.png" class="order_del" onclick="order_cancel(this,'${order.id}')" /></td>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${order.orderProducts}" var="od">


															<tr>
																<td class="order_tab1"><img
																	src="${od.sku.product.pic}"
																	onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" /></td>
																<td class="order_tab2">
																	<div class="order_tab2_t">
																		<p>${od.sku.product.name}</p>
																		<p>规格：${od.sku.spec}</p>
																	</div>
																</td>
																<td class="order_tab3">
																	<div>
																		￥<span>${od.sku.price}</span>
																	</div>
																</td>
																<td class="order_tab4">
																	<div>
																		<span>${od.num}</span>
																	</div>
																</td>
																<td class="order_tab5">
																	<div>
																	<c:choose>
																	<c:when test="${od.reNum >0}"><a href="/order/toChange">查看售后进度</a></c:when>
																	<c:when test="${order.orderStatus==1 or order.orderStatus==2}"><a href="/order/toRefund?opId=${od.id}">退货/退款</a></c:when>
																	</c:choose>
																	<!--  
																		<c:if
																			test="${order.orderStatus==1 or order.orderStatus==2}">
																			<a href="refund.html">退货/退款</a>
																		</c:if>
																		<c:if test="${od.reNum>0}"><a href="refund.html">查看售后进度</a></c:if>-->
																	</div>
																</td>
																<td class="order_tab6 order_tab_hide">
																	<div>
																		￥<span>${order.totalfee}</span>
																	</div>
																	<p>
																		含运费：<span>${order.mailFee}</span>
																	</p>
																</td>
																<td class="order_tab7 order_tab_hide">
																	<div>
																		<c:choose>
																			<c:when test="${order.orderStatus==3}">
																				<p>交易完成</p>
																				<p>待评价</p>
																			</c:when>
																			<c:when test="${order.orderStatus==1}">
																				<p>已付款</p>
																			</c:when>
																			<c:when test="${order.orderStatus==2}">
																				<p>已发货</p>
																			</c:when>
																			<c:when test="${order.orderStatus==4}">
																				<p>交易关闭</p>
																			</c:when>
																			<c:when test="${order.orderStatus==5}">
																				<p>交易完成</p>
																				<p>已评价</p>
																			</c:when>
																			<c:otherwise>
																				<p>待付款</p>
																			</c:otherwise>
																		</c:choose>
																		<a href="/order/orderInfo?oid=${order.id}">订单详情</a>
																		<!-- 已发货才显示物流 -->
																		<c:if test="${order.orderStatus==2}">
																			<a href="#" onclick="logistics(this,'${order.expiressNum}')">查看物流</a>
																		</c:if>
																	</div>
																</td>
																<td class="order_tab8 order_tab_hide">
																	 <c:if test="${order.orderStatus==0}">
																		<div class="order_pay" onclick="order_pay('${order.id}')">
																			<span>立即支付</span>
																		</div>
																	</c:if> <!--  
																	<div onclick="delivery(this)">
																		<span>提醒发货</span>
																	</div>--> <c:if test="${order.orderStatus==2}">
																		<div name="100" onclick="recipient(this,'${order.id}')">
																			<span>确认收货</span>
																		</div>
																	</c:if> <c:if test="${order.orderStatus==3 && od.reNum==0}">
																		<div onclick="toComm('${order.id}')">
																			<span>评价商品</span>
																		</div>
																	</c:if>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</c:forEach>
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