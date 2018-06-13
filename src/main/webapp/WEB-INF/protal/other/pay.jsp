<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>处方外配平台提醒您确认订单信息</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/jsstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/pay.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/address.js"></script>
<script type="text/javascript" src="../js/pay.js"></script>
<script type="text/javascript">
	var orderType = '${orderType}';
	var preId = '${preId}';
	var midd = 0;
	//alert(midd);
	var skuId = '${skuId}';
	var amount = '${amount}';
	$(function() {
		//初始化加载，触发click事件,选中第一个,li标签
		$("#address_ul_box li:first").trigger("click");
		$("#address_ul_box li:first").addClass("defaultAddr");
		$("#retuurl").val(encodeURIComponent(window.location.href));
		//alert($("#midd").val());
		midd = $("#midd").val()
		if (midd == 0 || midd == null || midd == undefined
				|| midd == "undefined") {
			$("#errpay").html("<span style='color:red'>请选择或者添加收货地址</span>");
		}
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

	});
	function orderDefaultAddr(id) {
		window.location.href = "/order/orderDefaultAddr?mailId=" + id
				+ "&returnUrl=" + encodeURIComponent(window.location.href);
	}
	function first() {
		window.location.href = "/"
	}
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
	//点击对全局变量邮寄地址ID赋值
	function addrClik(id) {
		midd = id;
	}
	//提交订单
	function applyOrder() {
		if (midd == 0 || midd == null || midd == undefined
				|| midd == "undefined") {
			midd=0;
			alert("请选择或者添加收货地址");
		}
		//alert(midd)
		window.location.href = "/order/applyOrder?skuId=" + skuId + "&amount="
				+ amount + "&orderType=" + orderType + "&sendId=" + midd
				+ "&preId=" + preId + "&returnUrl="
				+ encodeURIComponent(window.location.href);
	}
</script>
</head>

<body>
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
						<a href="#" id="uscc" onclick="toUserCenter()" target="_top">个人中心</a>
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
						<a href="../person/collection.html" target="_top"><i
							class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
				</div>-->
				<!--  
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="../person/collection.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
					</div>
				</div>-->
			</ul>
		</div>
	</div>


	<!--悬浮搜索框-->

	<div class="clear"></div>
	<div class="concent">
		<!--logo -->
		<div class="logo_box">
			<div class="logo_img">
				<img src="../images/logobig.png" onclick="first()" />
			</div>
			<div class="logo_texts">
				<div class="logo_add">1. 确认订单信息</div>
				<div class="triangle-left">&nbsp;</div>
				<div>2. 选择支付方式付款</div>
				<div class="triangle-right">&nbsp;</div>
				<div>3. 确认收货</div>
				<div class="triangle-right">&nbsp;</div>
				<div>4. 双方互评</div>
			</div>
		</div>
		<!--logo -->
		<!--地址 -->
		<div class="paycont">
			<div id="UUUULI" class="address">
				<h3>确认收货地址</h3>
				<div class="control">
					<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
				</div>
				<input type="hidden" id="mmmmd" value="0" />
				<div class="clear"></div>
				<ul id="address_ul_box">
					<div class="per-border"></div>
					<c:forEach items="${mailLists}" var="mail">
						<li class="user-addresslist" onclick="addrClik('${mail.id}')"><input
							type="hidden" id="midd" value="${mail.id}" />
							<div class="address-left">
								<div class="user">
									<span class="buy-address-detail"> <span class="buy-user">${mail.name}
									</span> <span class="buy-phone">${mail.tel}</span>
									</span>
								</div>
								<div class="default-address ">
									<span class="buy-line-title buy-line-title-type">收货地址：</span> <span
										class="buy--address-detail">${mail.address}</span>
								</div>
								<ins class="deftip">
									<c:if test="${mail.isDefault}">默认地址</c:if>
								</ins>
							</div>
							<div class="address-right">
								<a href="../person/address.html"> <span
									class="am-icon-angle-right am-icon-lg"></span></a>
							</div>
							<div class="clear"></div>

							<div class="new-addr-btn">
								<c:if test="${!mail.isDefault}">
									<a href="#" class="mo_adress_set"
										onclick="orderDefaultAddr('${mail.id}')">设为默认</a>
								</c:if>
								<span class="new-addr-bar new-addr-bar1 hidden">|</span> <a
									href="#" onclick="rewrite_address(this)">编辑</a> <span
									class="new-addr-bar">|</span> <a href="javascript:void(0);"
									onclick="delClick(this);">删除</a>
							</div></li>
					</c:forEach>
				</ul>
				<div class="per-border"></div>
			</div>
			<input type="hidden" id="ppreId" value="${preId}" /> <input
				type="hidden" id="skkuId" value="${skuId}" /> <input type="hidden"
				id="amtt" value="${amount}" />
			<!--订单 -->
			<div class="body1">
				<table class="order_commodity">
					<tr>
						<td colspan="5" class="order_commodity_tou"><strong>确认订单信息</strong></td>
					</tr>
					<tr>
						<td class=" head_line"><span>商品</span></td>
						<td class=" head_line"><span></span></td>
						<td class=" head_line"><span>规格</span></td>
						<td class=" head_line"><span>单价</span></td>
						<td class=" head_line"><span>数量</span></td>
						<td class=" head_line"><span>优惠方式</span></td>
						<td class=" head_line"><span>小计</span></td>
					</tr>
				</table>
				<c:forEach items="${orderVerfiys}" var="order">
					<table class="order_commodity order_commodity_w">
						<thead>
							<tr class="firm">
								<td colspan="7">
									<div class="firm_w">${order.phName}</div>
								</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order.skus}" var="sku">
								<tr class="firm_list">
									<td><img src="${sku.product.pic}" width="60px"
										height="60px" /></td>
									<td><span class="inventory_cue_b">${sku.product.name}<span
											class="inventory_cue"><c:if test="${!sku.isHave}">库存不足</c:if></span></span></td>
									<td><span class="specifications">${sku.spec}</span></td>
									<td><span class="univalent">${sku.price}</span></td>
									<td><span class="number">${sku.num}</span></td>
									<td><span> 1</span></td>
									<td><span class="subtotal">${sku.price*sku.num}</span></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr class="firm">
								<td colspan="7">
									<div style="float: right;">
										共 <span class="company_total_num">0</span> 类商品，小计 <span
											class="company_total"> 158.08 </span>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="7">
									<div style="float: right;">
										<span>${order.msg}</span> 运费 <b class="red total_y yun">￥</b>
										<b class="red total_w yun">${order.mailFee}</b>
									</div>
								</td>
							</tr>
						</tfoot>
					</table>
				</c:forEach>

				<!--优惠券 -->
				<!--<div class="coupon_o">
							<div onclick="coupon_hide()" >
								<h3>使用优惠券</h3>
								<label class="coupon_dowm" name="1"></label>
							</div>
							<div class="coupon_ul_b">
								<div class="coupon_head">
									<div class="coupon_head_i">
										<span>商品优惠券</span>
									</div>
								</div>
								<div class="coupon_ul">
									<div class="coupon_li" onclick="coupon(this)">
										<div class="coupon_li_blue">
											<div class="coupon_li_x1"></div>
											<p><span class="coupon_li_t1">￥</span ><span class="coupon_li_t1">50</span></p>
											<p class="coupon_li_t2"><span >[消费满100可用]</span></p>
											<p class="coupon_li_t3"><span >2018.1.2</span>-<span>2018.4.2</span></p>
											<div class="coupon_li_x2"></div>
										</div>
										<div class="coupon_li_foot">
											<p  class="coupon_li_t4">劵号：252313133</p>
										</div>
										<div class="coupon_li_hide">
											<span class="coupon_b">100</span><span class="coupon_s">50</span>
										</div>
									</div>
									<div class="coupon_li" onclick="coupon(this)">
										<div class="coupon_li_blue">
											<div class="coupon_li_x1"></div>
											<p><span class="coupon_li_t1">￥</span ><span class="coupon_li_t1">40</span></p>
											<p class="coupon_li_t2"><span >[消费满80可用]</span></p>
											<p class="coupon_li_t3"><span >2018.1.2</span>-<span>2018.4.2</span></p>
											<div class="coupon_li_x2"></div>
										</div>
										<div class="coupon_li_foot">
											<p  class="coupon_li_t4">劵号：252313133</p>
										</div>
										<div class="coupon_li_hide">
											<span class="coupon_b">80</span><span class="coupon_s">40</span>
										</div>
									</div>
								</div>
							</div>-->
			</div>
			<table class="order_commodity">
				<tr>
					<td colspan="5">
						<div style="float: right;">
							合计（含运费）<b class="red">￥</b><b class="red" id="total">111.00</b>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<!--  
						<div style="float: right;">
							<input type="radio" name="defray" id="" value=""
								checked="checked" />自己购买
						</div>-->
					</td>
				</tr>
			</table>
			<div class="order_last_box">
				<div class="order_last">
					<p>
						<b>实付款</b><b style="font-size: 25px; color: #666;">￥</b><b
							style="font-size: 25px; color: #d7342e;" id="total_two">00.00</b>
					</p>
					<p>
						<b>寄送至：</b><span id="Oaddress_val">萧山 北干 建村花园 建村花园 建村花园
							建村花园 建村花园4幢一单元4102</span></span>
						<p>
							<b>收件人：</b><span id="name_val">陈莎莎</span><span>
						</p>
						<p></p>
				</div>
				<div style="float: left; padding: 10px;"
					onclick="window.location.href='/cart/toCart'">
					<img src="../images/back.png" width="20px" height="15px" />
					<!-- <span class="back">返回购物车</span>-->
					<span class="inventory_al_cue" id="errpay">${omsg}</span>
				</div>
				<input type="button" name="" class="order_submit" value="提交订单"
					onclick="applyOrder()" />
			</div>
		</div>

		<div class="theme-popover-mask"></div>
		<div class="theme-popover">

			<!--标题 -->
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add
						address</small>
				</div>
			</div>
			<hr />
			<form class="am-form am-form-horizontal" id="jvForm">
				<div class="am-u-md-12" style="margin: 22px 0px;">
					<input type="hidden" name="id" id="mail-id" /> <input
						type="hidden" id="retuurl" name="returnUrl" />
					<div class="am-form-group">
						<label for="user-name" class="am-form-label">收货人</label>
						<div class="am-form-content">
							<input type="text" name="name" id="user-name" placeholder="收货人"
								onblur="add_cue()" />
						</div>
					</div>

					<div class="am-form-group">
						<label for="user-phone" class="am-form-label">手机号码</label>
						<div class="am-form-content">
							<input id="user-phone" name="tel" placeholder="手机号必填" type="text"
								onblur="add_cue()" />
						</div>
					</div>

					<div class="am-form-group">
						<label for="user-intro" class="am-form-label">详细地址</label>
						<div class="am-form-content">
							<textarea class="" rows="3" name="address" id="user-intro"
								placeholder="输入详细地址" onblur="add_cue()"></textarea>
							<small>100字以内写出你的详细地址...</small><br /> <img
								src="../images/stop.png"
								style="width: 10px; margin-right: 3px; display: none;"
								id="add_address_cue_img" /> <small style="color: red;"
								id="add_address_cue"></small>
						</div>
					</div>

					<div class="am-form-group theme-poptit">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<div class="am-btn am-btn-danger close" onclick="add_address()">保存</div>
							<div class="am-btn am-btn-danger close" onclick="cancel()">取消</div>
						</div>
					</div>

				</div>
			</form>
		</div>

		<div class="clear"></div>
	</div>
	</div>
	<div class="foot ">
				<div class="wt ">
					<p>
						<a href="/aboutUs"><span>关于我们</span></a>|  <a href="# "><span>商家入驻</span></a>
						
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
</body>

</html>