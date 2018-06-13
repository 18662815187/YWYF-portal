<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />

<title>退换货管理</title>
<script src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />

<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/orstyle.css" rel="stylesheet" type="text/css" />

<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.js"></script>
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script type="text/javascript">
	/*每次刷新执行*/
	$(document).ready(function() {
		var type = 0
		if (type == "" || type == null) {
			$(".am-avg-sm-4").find("li").removeClass("am-active");
			$(".am-avg-sm-4 li").eq(0).addClass("am-active")
		} else if (type == 1) {
			$(".am-avg-sm-4").find("li").removeClass("am-active");
			$(".am-avg-sm-4 li").eq(1).addClass("am-active")
		} else if (type == 2) {
			$(".am-avg-sm-4").find("li").removeClass("am-active");
			$(".am-avg-sm-4 li").eq(2).addClass("am-active")
		} else if (type == 3) {
			$(".am-avg-sm-4").find("li").removeClass("am-active");
			$(".am-avg-sm-4 li").eq(3).addClass("am-active")
		}
	})
	/*点击*/
	function order(ob, nu) {
		$(".am-avg-sm-4").find("li").removeClass("am-active");
		$(ob).addClass("am-active");
	}
	/*点击填写单号*/
	function fill(ob) {
		$(".order-list").attr("bla", "0")
		$(".change_black").show()
		$(ob).parents(".order-list").attr("bla", "bla")
	}
	/*取消弹窗*/
	function del() {
		$(".change_black").hide()
	}
	/*提交弹窗*/
	function butt(ob) {
		if ($("#change_number_con").val().length != 0) {
			$(".change_black").hide()
			for (i = 0; i < $(".order-list").length; i++) {
				if ($(".order-list").eq(i).attr("bla") == "bla") {
					var id = $(".order-list").eq(i).find("#XXXXID").val();
					var kdNum = $("#change_number_con").val();
					window.location.href="/order/upKdNum?id="+id+"&kdNum="+kdNum;
				}
			}
		} else {
			alert("快递单号不能为空!")
		}
	}
	//取消售后
	function refund_none(id, txt) {
		var mymessage = confirm(txt);
		if (mymessage == true) {
			window.location.href = "/order/cancel?rid=" + id;
		}
	}

	/*查看新订单*/
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
				<!--  
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>-->
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
				<li class="index"></li>
			</ul>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-order">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">退换货管理</strong> / <small>Change</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-4 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active" onclick="order(this,0)"><a href="#">退款管理</a>
							</li>
							<!--  
							<li onclick="order(this,1)"><a href="#">退款/退货管理</a></li>
							<li onclick="order(this,2)"><a href="#">换货管理</a></li>
							<li onclick="order(this,3)"><a href="#">历史售后记录</a></li>-->

						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-orderprice th-price">
										<td class="td-inner">产品售价</td>
									</div>
									<div class="th th-changeprice th-price">
										<td class="td-inner">购买数量</td>
									</div>
									<div class="th th-status th-moneystatus">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change th-changebuttom">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<!-- 退款退货管理-->
									
										<c:forEach items="${pagination.list}" var="re">
										<div class="order-list">
											<div class="order-title">
												<div class="dd-num">
													售后编号： <a href="javascript:;">${re.opNum}</a>
												</div>
												<span>申请时间：<date:date value="${re.addtime}"></date:date></span>
												<img src="../images/wen.png" /> <label>在卖家未同意退货或者换货时，请不要把快件寄出去</label>
											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="${re.orderProduct.sku.product.pic}"
																	onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'"
																	class="itempic J_ItemImg"></a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>${re.orderProduct.sku.product.name}</p>
																		<p class="info-little">
																			规格：${re.orderProduct.sku.spec}</p>
																	</a>
																</div>
															</div>
														</li>
														<input type="hidden" id="XXXXID" value="${re.id}"/>
														<ul class="td-changeorder">
															<li class="td td-orderprice">
																<div class="item-orderprice">${re.orderProduct.sku.price}</div>
															</li>
															<li class="td td-changeprice">
																<div class="item-changeprice">${re.orderProduct.num}</div>
															</li>
														</ul>
														<div class="clear"></div>
													</ul>

													<div class="change move-right">
														<li class="td td-moneystatus td-status">
															<div class="item-status">
																<c:choose>
																	<c:when test="${not empty re.expressNum && re.status!=6}">
																		<p class="Mystatus">换货商品已发出</p>
																	</c:when>
																	<c:when test="${re.status==0}">
																		<p class="Mystatus">申请售后</p>
																	</c:when>
																	<c:when test="${re.status==1}">
																		<p class="Mystatus">商家同意售后申请,耐心等待处理</p>
																	</c:when>
																	<c:when test="${re.status==2}">
																		<p class="Mystatus">商家拒绝售后申请</br>原因：${re.content}</p>
																	</c:when>
																	<c:when test="${re.status==3}">
																		<p class="Mystatus">退款已完成,原路退回</p>
																	</c:when>
																	<c:when test="${re.status==4}">
																		<p class="Mystatus">换货已完成,请注意查收</p>
																	</c:when>
																	<c:when test="${re.status==5}">
																		<p class="Mystatus">售后已取消</p>
																	</c:when>
																	<c:when test="${re.status==6}">
																		<p class="Mystatus">售后确认完成</p>
																	</c:when>
																</c:choose>
															</div>
														</li>
													</div>
													<li class="td td-change td-changebutton"><a href="#">
															<c:if
																test="${re.status!=2 &&re.status!=3&&re.status!=4&&re.status!=5 && empty re.kdNum}">
															<div class="am-btn am-btn-danger anniu refund_none"
																onclick="refund_none('${re.id}','确认取消退款？')">取消售后</div></c:if> <c:if
																test="${re.status==1 && re.reStyle !=3 && empty re.kdNum}">
																<div class="am-btn am-btn-danger anniu refund_button"
																	onclick="fill(this)">填写运单号</div>
															</c:if>
															<c:choose>
															<c:when test="${!empty re.expressNum}">
																<a class="am-btn am-btn-danger anniu" href="#" onclick="logistics(this,'${re.expressNum}')">查看物流</a>
															</c:when>
															<c:when test="${re.status==1 && re.reStyle !=3 && !empty re.kdNum}">
																<span>快递单号已提交,请耐心等待 </span>
															</c:when>
															</c:choose>
															<c:if test="${re.status==1&&!empty re.expressNum}">
															<a class="am-btn am-btn-danger anniu" href="/order/confirmRefund?rid=${re.id}">确认售后完成</a>
															</c:if>
															 <!-- 
															<div class="am-btn am-btn-danger anniu "
																onclick="refund_none(this,'确认收货？')">确认收货</div> --> <!-- 
															<div class="am-btn am-btn-danger anniu "
																onclick="logistics(this)">查看新订单</div>
															<div class="am-btn am-btn-danger anniu refund_del"
																onclick="refund_none(this,'确认删除订单？')">删除订单</div> -->
													</a></li>

												</div>
											</div>
											</div>
										</c:forEach>
									

								</div>
								<div class="order-pages">
									<div style="float: right;">
										<span style="font-size: 15px;">当前数据总数
											${pagination.totalCount} 条,单页最大显示 ${pagination.pageSize} 条. </span>
										&nbsp&nbsp&nbsp
										<c:forEach items="${pagination.pageView}" var="page">
				${page}
				</c:forEach>
									</div>
								</div>
							</div>
							<div class="am-tab-panel am-fade" id="tab2">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-orderprice th-price">
										<td class="td-inner">交易金额</td>
									</div>
									<div class="th th-changeprice th-price">
										<td class="td-inner">退款金额</td>
									</div>
									<div class="th th-status th-moneystatus">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change th-changebuttom">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<div class="order-title">
											<div class="dd-num">
												退款编号： <a href="javascript:;">1601430</a>
											</div>
											<span>申请时间：2015-12-20</span>
											<!--    <em>店铺：小桔灯</em>-->
										</div>
										<div class="order-content">
											<div class="order-left">
												<ul class="item-list">
													<li class="td td-item">
														<div class="item-pic">
															<a href="#" class="J_MakePoint"> <img
																src="../images/kouhong.jpg_80x80.jpg"
																class="itempic J_ItemImg"></a>
														</div>
														<div class="item-info">
															<div class="item-basic-info">
																<a href="#">
																	<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																	<p class="info-little">
																		颜色：12#川南玛瑙 <br />包装：裸装
																	</p>
																</a>
															</div>
														</div>
													</li>

													<ul class="td-changeorder">
														<li class="td td-orderprice">
															<div class="item-orderprice">
																<span>交易金额：</span>72.00
															</div>
														</li>
														<li class="td td-changeprice">
															<div class="item-changeprice">
																<span>退款金额：</span>70.00
															</div>
														</li>
													</ul>
													<div class="clear"></div>
												</ul>

												<div class="change move-right">
													<li class="td td-moneystatus td-status">
														<div class="item-status">
															<p class="Mystatus">卖家已同意退货</p>

														</div>
													</li>
												</div>
												<li class="td td-change td-changebutton"><a
													href="record.html">
														<div class="am-btn am-btn-danger anniu">钱款去向</div>
												</a></li>

											</div>
										</div>
									</div>
									<div class="order-list">
										<div class="order-title">
											<div class="dd-num">
												退款编号： <a href="javascript:;">1601430</a>
											</div>
											<span>申请时间：2015-12-20</span>
											<!--    <em>店铺：小桔灯</em>-->
										</div>
										<div class="order-content">
											<div class="order-left">
												<ul class="item-list">
													<li class="td td-item">
														<div class="item-pic">
															<a href="#" class="J_MakePoint"> <img
																src="../images/kouhong.jpg_80x80.jpg"
																class="itempic J_ItemImg"></a>
														</div>
														<div class="item-info">
															<div class="item-basic-info">
																<a href="#">
																	<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																	<p class="info-little">
																		颜色：12#川南玛瑙 <br />包装：裸装
																	</p>
																</a>
															</div>
														</div>
													</li>

													<ul class="td-changeorder">
														<li class="td td-orderprice">
															<div class="item-orderprice">
																<span>交易金额：</span>72.00
															</div>
														</li>
														<li class="td td-changeprice">
															<div class="item-changeprice">
																<span>退款金额：</span>70.00
															</div>
														</li>
													</ul>
													<div class="clear"></div>
												</ul>

												<div class="change move-right">
													<li class="td td-moneystatus td-status">
														<div class="item-status">
															<p class="Mystatus">卖家已同意退货</p>

														</div>
													</li>
												</div>
												<li class="td td-change td-changebutton"><a
													href="record.html">
														<div class="am-btn am-btn-danger anniu">钱款去向</div>
												</a></li>

											</div>
										</div>
									</div>
								</div>
								<div class="order-pages">
									<input type="button" name="" id="" class="pages pages_down"
										value="下一页" onclick="pages(this)" /> <span class="pages_num">1</span>
									<input type="button" name="" id="" class="pages pages_up"
										value="上一页" onclick="pages(this)" />
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
	<div class="change_black" uid="">
		<div class="change_number">
			<div class="change_number_h">
				<span>填写快递单号</span> <img src="../images/ca1.png" onclick="del()" />
			</div>
			<div class="change_number_b">
				<input type="text" name="" id="change_number_con" value=""
					placeholder="请输入快递订单号" /> <span>请检查快递单号是否填写正确，点击确认后，将无法取消退款请求</span>
				<input type="button" name="" id="" value="确认" onclick="butt(this)" />
			</div>
		</div>
	</div>

</body>

</html>