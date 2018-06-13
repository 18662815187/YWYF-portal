<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>我的购物车</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/shop.js"></script>
<link rel="stylesheet" type="text/css" href="../css/shop.css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/demo.css" rel="stylesheet" type="text/css" />
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
	<!--顶部导航条 -->
	<div style="background-color: #f1f1f1;">
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="/">欢迎来到医院处方药配送平台！</a> <a href="#" onclick="XXLogin()"
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
							<a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
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

	<div class="clear"></div>
	<div class="concent">
		<!--购物车-->
		<div class="body wt">
			<div style="margin-bottom: 20px;"></div>
			<div class="">
				<table>
					<tr>
						<td class="shop_head_text"><b class="shop_head_text_b">全部商品<span
								id="shop_head_text_num">3</span></b> <b class="shop_head_text_r">已选商品（不含运费）<span>￥</span><span
								id="shop_head_text_set">250.00</span></b></td>
					</tr>
				</table>
			</div>
			<div class="shop_list_kong">
				<img src="../images/pop_shop.png" width="100px" />
				<p>
					你的购物车还是空的，你还可以<a class="shop_list_jump" href="/cart/toCart">进入购物页面！</a>
				</p>

				<p style="font-size: 14px; color: #cdcdcd;">
					您也可以去首页，<a class="shop_list_jump" href="/">返回首页！</a>
				</p>
			</div>
			<div class="shop_list_box">
				<div>
					<table class="shop_nav_text">
						<tr>
							<th width="13px"><input type="checkbox" name=""
								class="whole_choice" id="whole_choice" onclick="whole(this)" /></th>
							<th width="50px" style="padding-left: 10px;"><span>全选</span>
							</th>
							<th style="padding-left: 30px;">商品信息</th>
							<td width="125px"><span>单价</span></td>
							<td width="125px"><span>数量</span></td>
							<td width="125px"><span>金额</span></td>
							<td width="60px"><span>操作</span></td>
							<td width="90px"><span></span></td>
						</tr>
					</table>
				</div>
				<c:forEach items="${buyerCart}" var="bc">
					<ul class="shop_list">
						<li>
							<div class="factory">
								<input type="checkbox" name="" class="factory_choice choice"
									onclick="factory(this)" /> <span
									style="background-color: #FFF; padding: 3px 10px;">${bc.phName}</span>
							</div>
						</li>
						<c:forEach items="${bc.buyerItems}" var="by">
							<li>
								<table>
									<tr>
										<td rowspan="2" width="13px"><input type="checkbox"
											class="choice" name="ids" id="skuIdd" onclick="box(this)"
											value="${by.sku.id}" /></td>
										<td rowspan="2" width="13px"><img src="${by.product.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" /></td>
										<td><span>${by.product.name}</span></td>
										<td width="125px">￥<span class="univalent">${by.sku.price}</span></td>
										<td width="125px">
											<div
												style="border: 1px solid #CDCDCD; height: 27px; width: 72px;">
												<input type="button" name="min" id="omin" class="omin an"
													value="-" onclick="omin(0,this)" /> <input id="val"
													class="val" type="text" placeholder="1"
													value="${by.amount}" onfocus="modify_num1(this)"
													onblur="modify_num2(this)" /> <input type="button"
													name="max" id="omax" class="omax an" value="+"
													onclick="omin(1,this)" />
											</div>
										</td>
										<td width="125px">￥<span class="subtotal">0</span></td>
										<td class="delete_shop" onclick="rec(this)" width="60px">删除</td>
										<td width="80px"><c:if test="${!by.isHave}">库存不足</c:if></td>
									</tr>
									<tr>
										<td colspan="5">${by.sku.spec}</td>
									</tr>
								</table>
							</li>
						</c:forEach>
					</ul>
				</c:forEach>
				<div>
					<table class="settlement_table">
						<tr>
							<td width="50px"><input type="checkbox" name=""
								onclick="whole(this)" class="whole_choice" /> <span>全选</span></td>
							<td width="60px"><span class="whole_delete"
								onclick="whole_del()">删除</span></td>
							<td width="120px"><span class="whole_delete">移入收藏夹</span></td>
							<td></td>
							<td style="position: relative;"><b
								style="position: absolute; right: 10px; top: 8px;">合计(不含运费)：<span
									style="color: red; font-size: 20px;">￥<span
										id="aggregate" style="font-size: 20px;">50000.00</span></span></b></td>
							<td width="100px">
								<div id="settle" onclick="zero_j()"
									style="text-align: center; background-color: #0b74df; color: #fff; line-height: 40px">结算</div>
							</td>
						</tr>
					</table>
				</div>
			</div>

		</div>
		<!--购物车-->
		<!--推荐产品-->
		<!--  
			<div class=" wt recommend" style="margin-bottom: 20px;">
				<div style="font-size: 18px;padding: 5px;">
					商品推荐
				</div>
				
					<table >
						<tbody>
							<tr>
								<td>
									<a href="introduction.html">
										<img src="../images/cp.jpg"/>
										<div class="recommend_text text_box">
											<span>麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box">
											<span class="font_999">30g*5</span>
										</div>
										<div class="recommend_text">
											<span class="limit_text font_999" >麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box red" style="color:red;">
											￥
											<span>25.00</span>
										</div>
									</a>
								</td>
								<td>
									<a href="introduction.html">
										<img src="../images/cp.jpg"/>
										<div class="recommend_text text_box">
											<span>麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box">
											<span class="font_999">30g*5</span>
										</div>
										<div class="recommend_text">
											<span class="limit_text font_999" >麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box red" style="color:red;">
											￥
											<span>25.00</span>
										</div>
									</a>
								</td>
								<td>
									<a href="introduction.html">
										<img src="../images/cp.jpg"/>
										<div class="recommend_text text_box">
											<span>麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box">
											<span class="font_999">30g*5</span>
										</div>
										<div class="recommend_text">
											<span class="limit_text font_999" >麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box red" style="color:red;">
											￥
											<span>25.00</span>
										</div>
									</a>
								</td>
								<td>
									<a href="introduction.html">
										<img src="../images/cp.jpg"/>
										<div class="recommend_text text_box">
											<span>麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box">
											<span class="font_999">30g*5</span>
										</div>
										<div class="recommend_text">
											<span class="limit_text font_999" >麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box red" style="color:red;">
											￥
											<span>25.00</span>
										</div>
									</a>
								</td>
								<td>
									<a href="introduction.html">
										<img src="../images/cp.jpg"/>
										<div class="recommend_text text_box">
											<span>麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box">
											<span class="font_999">30g*5</span>
										</div>
										<div class="recommend_text">
											<span class="limit_text font_999" >麒麟牌 麒麟丸麒麟牌 麒麟丸麒麟牌 麒麟丸</span>
										</div>
										<div class="recommend_text text_box red" style="color:red;">
											￥
											<span>25.00</span>
										</div>
									</a>
								</td>
							</tr>
						</tbody>
					</table>
				
			</div>-->
		<!--推荐产品-->
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