<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />

<title>订单详情</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<script src="../js/person_order.js"></script>
<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/orstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.js"></script>
<style type="text/css">
.order_detail {
	width: 100%;
	display: flex;
	margin-top: 15px;
}

.order_address {
	width: 300px;
	flex: 1 1 auto;
}

.order_express {
	width: 60%;
	border: 1px solid #f1f1f1;
	flex: 1 1 auto;
	padding: 25px;
	position: relative;
}

.order_express img {
	width: 30px;
	height: 30px;
	position: absolute;
}

.order_express strong {
	margin-left: 40px;
	padding-bottom: 25px;
	font-size: 16px;
}

.order_express p {
	margin-left: 40px;
	margin-top: 5px;
}

.order_address_h {
	background-color: #f1f1f1;
	padding: 10px;
}

.order_address_b {
	padding: 10px;
}

.order_address_b label {
	color: #666;
}
</style>
<script type="text/javascript">
	function receipt(ob) {
		$(ob).text("已收货")
	}
	/*去除多余*/
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
		//加载状态
		flow()
	}
	/*显示状态*/
	function flow() {
		var flow = $("#os").val();
		if (flow == "" || flow == 0) {
			$(".step-1").find(".bg").addClass("flow_order2");
			$(".step-2").find(".bg").addClass("flow_order1");
		} else if (flow == 1) {
			$(".step-1").find(".bg").addClass("flow_order2");
			$(".step-2").find(".bg").addClass("flow_order2");
			$(".step-3").find(".bg").addClass("flow_order1");
		} else if (flow == 2) {
			$(".step-1").find(".bg").addClass("flow_order2");
			$(".step-2").find(".bg").addClass("flow_order2");
			$(".step-3").find(".bg").addClass("flow_order2");
			$(".step-4").find(".bg").addClass("flow_order1");
		} else if (flow == 3 || flow == 5) {
			$(".step-1").find(".bg").addClass("flow_order2");
			$(".step-2").find(".bg").addClass("flow_order2");
			$(".step-3").find(".bg").addClass("flow_order2");
			$(".step-4").find(".bg").addClass("flow_order2");
			$(".step-5").find(".bg").addClass("flow_order2");
		} else if (flow == 6) {
			$(".step-1").find(".bg").addClass("flow_order2");
			$(".step-6").find(".bg").addClass("flow_order1");
			$(".after_sale_hide").show()
		}
	}
	/*加载订单状态*/
	$(document).ready(function() {
		var number=$("#sn").val();
		$.ajax({
			url: "/order/expressQuery?number="+number,
			dataType: "json",
			type: "post",
			success: function(data) {
				var strhtml = ""; //设定空值
				var exp = ""
				var zhu = ""
				var ku = ""
				var quhtml =""
				var numbers =""
				if(data.status==0){ //存在订单的状况下
					quhtml = data.result.list[1].time+data.result.list[1].status;
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
					if(zhu == "1") {
						issign = "物流在途中"
					} else if(zhu == "2") {
						issign = "物流已经在派送"
					} else if(zhu == "3") {
						issign = "物流已经签收"
					}  else if(zhu == "4") {
						issign = "物流派送失败（拒收等）"
					}
					//物流单号
					numbers = data.result.number
					
				}
				else{
					quhtml = "暂无物流信息"
					exp = "暂无物流信息"
					issign = "暂无物流信息"
					numbers = "暂无物流信息"
				}
				//添加物流状态
				$("#new_express").text(quhtml);
				$("#express_company").text(exp);
				$("#express_num").text(numbers);
				$("#express_issign").text(issign)
				
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				//alert(XMLHttpRequest.status);
				//alert(XMLHttpRequest.readyState);
				//alert(textStatus);
			},
		});
	})
	
	//立即支付
	function order_pay(oid) {
		window.location.href = "/order/orderToPayment?oid=" + oid
				+ "&returnUrl=" + encodeURIComponent(window.location.href);
	}
	//评价商品
	function assess(ob) {
		var ma = $(ob).parents(".order-status5");
		var va = 0
		var arr = new Array();
		var fileimg  = ""
		if($(ob).find("span").text() == "评价商品") {
			$(".order_button").show()
			$(ob).hide()
			$(ob).parents(".order-status5").find(".order-pin").css("display", "table-row")
		} else if($(ob).val() == "提交全部评价") {
			//判断有几个评论
			for(i = 0; i < $(".order-pin").length; i++) {

				if($(".order-pin").eq(i).find("textarea").val().length < 6) {
					alert("第" + (i + 1) + "个评价至少为六个字");
				} else if($(".order-pin").eq(i).find("textarea").val().length > 6) {
					va = va + 1
				}
			}
			if(va == 2) { //所有的都有评论
				$(ob).val("已经评论")
				alert("成功提交评论");
				$(".order-status5").find(".order-pin").css("display", "none")
				$(".order_button").hide()

				//ajax
				for(i = 0; i < $(".order-pin").length; i++) {
					arr[i] = new Array();
					//获取四个评论数据

					//商品品级
					for(u = 0; u < 3; u++) {
						if($(".item-opinion").eq(i).find("li").eq(u).find("i").attr("name") == 1) {
							arr[i][0] = (u + 1);			//商品品级
						}
					}
					arr[i][1] = $(".order_tab2_t").eq(i).find("p").eq(0).text(); //商品id
					arr[i][2] = $(".order-pin").eq(i).find("textarea").val(); //商品评价
					for(j = 1; j < 3; j++){
						fileimg += $(".order-pin").eq(i).find(".filePic").eq(j).find(".fileimg_imgs").attr("src")+","
					}
					
					arr[i][3] = fileimg; //评论图片
					
				}
				//console.log(arr)
			}
		} else if($(ob).find("span").text() == "已经评论") {

		} else {
			alert("html页面出现问题");
		}

	}
	/*取消评价*/
	function assess_none () {
		$(".order_button").hide()
		$(".assess").show()
		$(".order-status5").find(".order-pin").css("display", "none");
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
				<a name="index_none_header_sysc" href="#"></a>
				<form>
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off" oninput="search_list()" /> <input
						id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
						type="button" onclick="location.href='../other/search.html';" />
				</form>
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

				<div class="user-orderinfo">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单详情</strong> / <small>Order&nbsp;details</small>
						</div>
					</div>
					<hr />
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step"> <em class="u-progress-stage-bg"></em>
								<i class="u-stage-icon-inner">1<em class="bg "></em></i>
								<p class="stage-name">拍下商品</p>
							</span> <span class="step-2 step"> <em
								class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">2<em
									class="bg "></em></i>
								<p class="stage-name">已付款</p>
							</span> <span class="step-3 step"> <em
								class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">3<em
									class="bg"></em></i>
								<p class="stage-name">卖家发货</p>
							</span> <span class="step-4 step"> <em
								class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">4<em
									class="bg"></em></i>
								<p class="stage-name">确认收货</p>
							</span> <span class="step-5 step"> <em
								class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">5<em
									class="bg"></em></i>
								<p class="stage-name">交易完成</p>
							</span> <span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner"></div>
						</div>
						<div class="after_sale_hide">
							<div class="after_sale">
								<div class=""></div>
							</div>
							<span class="step-6 step"> <em class="u-progress-stage-bg"></em>
								<i class="u-stage-icon-inner">6<em class="bg"></em></i>
								<p class="stage-name">售后处理</p>
							</span>
						</div>

					</div>

					<div class="order-infomain">

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
						<input type="hidden" id="os" value="${order.orderStatus}"/>
									<input type="hidden" id="sn" value="${order.expiressNum}"/>

							<!--交易成功-->
							<div class="order-status5 order-del">
								<table class="order_table">
									<thead>
										<tr>
											<td colspan="2">订单编号：<span>${order.orderNum}</span></td>
											<td colspan="5">下单时间：<span><date:date
														value="${order.addtime}" /></span></td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${order.orderProducts}" var="od">
											<tr>
												<td class="order_tab1"><img src="${od.sku.product.pic}"
													onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" />
												</td>
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
														<c:if test="${order.orderStatus==1 or order.orderStatus==2}">
															<a href="/order/toRefund?opId=${od.id}">退货/退款</a>
														</c:if>
													</div>
												</td>
												<td class="order_tab6 order_tab_hide">
													<div>
														￥<span>${order.totalfee}</span>
													</div>
													<div class="order_tab6_t">
														<span>运费：￥<span>${order.mailFee}</span></span>
													</div>
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
																	</c:if> <c:if test="${order.orderStatus==3}">
																		<div onclick='assess(this)'>
																			<span>评价商品</span>
																		</div>
																	</c:if>
												</td>
											</tr>
											<tr class="order-pin">
												<td colspan="8">
													<div class="item-comment"><textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea></div>
													<div class="item-comment">
														<p>晒照片(<label class="fileimg_num">0</label>/5)</p>
														<div class="imgOnloadWrap">
															<div class="filePic">
																<input type="file" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" onchange="upimg(this)" class="fileimg_f" />
																<img src="../images/image.jpg" />
																<img src="../images/ca1.png" class="fileimg_del" onclick="fileimg_del(this)" />
															</div>
														</div>
														<div class="item-opinion">
															<li><i class="op1" name="1" onclick="op1(this)">好评</i></li>
															<li><i class="op2" onclick="op2(this)">中评</i></li>
															<li><i class="op3" onclick="op3(this)">差评</i></li>
														</div>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									
								</table>
							</div>
						</div>
					</div>
					<div class="order_detail">
						<div class="order_address">
							<div class="order_address_h">
								<b>收货信息</b>
							</div>
							<div class="order_address_b">
								<p>
									收货姓名：<label>${order.mailList.name}</label>
								</p>
								<p>
									收货地址：<label>${order.mailList.address}</label>
								</p>
								<p>
									收货手机：<label>${order.mailList.tel}</label>
								</p>
							</div>
						</div>
						<div class="order_express">
							<img src="../images/T13iv.XiFdXXa94Hfd-32-32.png" /> <strong>物流状态:
								<b id="express_issign">暂无物流信息</b>
							</strong>
							<p>
								物流：<span id="express_company">暂无物流信息</span>
							</p>
							<p>
								运单号:<span id="express_num">暂无物流信息</span>
							</p>
							<p>
								最新状态：<span id="new_express">暂无最新快递信息</span>
							</p>
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