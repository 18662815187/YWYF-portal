<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>${product.name}</title>
<script src="../js/jquery-1.8.3.min.js"></script>
<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../css/demo.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="../css/optstyle.css" rel="stylesheet" />
<link type="text/css" href="../css/style.css" rel="stylesheet" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<link href="../css/introduction.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/quick_links.js"></script>
<script type="text/javascript"
	src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<script type="text/javascript" src="../js/jquery.imagezoom.min.js"></script>
<script type="text/javascript" src="../js/jquery.flexslider.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
<script type="text/javascript" src="../js/search_list.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript">

	function first() {
		window.location.href = "/"
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

	//上传图片
	function uploadPic() {
		//jquery.form.js
		var options = {
			//url : "/upload/uploadFck.do",
			url : "/upload/uploadPic1.do",
			dataType : "json",
			type : "post",
			success : function(data) {
				//alert(1);
				//返回的数据通过下方控件的id给他们设置值,src需要通过attr属性去设置，val可以直接设置
				//原数据存在图片时，重新上传替换URL需对此两个地方进行回显设置
				$("#img").attr("src", data.url);
				$("#imgUrl").val(data.url);
			}
		}
		//ajax模拟jvForm这个form的提交
		$("#jvForm").ajaxSubmit(options);
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
	<!--动画效果-->
	<div class="animation"></div>
	<!--动画效果-->
	<!--相关连接-->
	<div class="search_list_ul_box" onmouseout="search_hide()"
		onmouseover="search_show()">
		<div class="search_list_ul_box1">
			<div class="search_list_ul_box2">
				<ul class="search_list_ul">
				</ul>
			</div>
		</div>
	</div>
	<!--相关连接-->
	<!--黑幕-->
	<div class="black"></div>
	<!--需求登记 2018-4-28-->

	<div class="need_bomb_box">
		<div class="need_list">
			<div class="need_list_select">
				<div class="need_list_n">
					<a onclick="need_one()">我没有处方，我要填写需求登记</a> <a onclick="need_two()">我有处方，我直接拍照上传</a>
				</div>
			</div>
		</div>
		<form action="" id="jvForm" method="post"
			enctype="multipart/form-data">
			<table class="need_bomb" name="0">
				<thead>
					<tr>
						<td><strong>处方登记</strong></td>
						<td><span style="color: #fff;">/</span><img
							src="../images/ca.png" width="20px"
							style="margin: 5px; margin-left: 336px;" onclick="del()" /></td>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td style="border-bottom: 1px dashed #cdcdcd;"><span>温馨提示：</span></td>
						<td style="border-bottom: 1px dashed #cdcdcd;"><span>该药品为处方药，我们会通知门店为您审核！</span></td>
					</tr>
					<!--  
				<tr>
					<td><span>价格：</span></td>
					<td><span class="drug_price">￥</span><span class="drug_price"
						id="drug_price_1">192.00</span></td>
				</tr>
				<tr>
					<td><span>套餐：</span></td>
					<td>
						<div class="drug_price_text" id="drug_price_2">4盒优惠装</div>
					</td>
				</tr>
				<tr>
					<td style="border-bottom: 1px dashed #cdcdcd;"><span>数量：</span></td>
					<td style="border-bottom: 1px dashed #cdcdcd;">
						<div class="drug_price_text" id="drug_price_3">2</div>
					</td>
				</tr>-->
					<!-- 
				<tr>
					<td class="drug_bomb_person"><span>登录状态：</span></td>
					<td class="drug_bomb_person"><span style="color: red">你尚未登录——<a
							href="#" onclick="">请登录</a></span></td>
				</tr> -->
					<input type="hidden" id="preId" value="${preId}" />
					<tr class="need_one">
						<td class="drug_bomb_person"><span>姓名：</span><span
							style="color: red;">*</span></td>
						<td class="drug_bomb_person"><span><input type="text"
								id="user-name" name="userName" placeholder="请输入姓名"
								onblur="add_cue()"></span></td>
					</tr>
					<tr class="need_one">
						<td class="drug_bomb_person"><span>年龄：</span><span
							style="color: red;">*</span></td>
						<td class="drug_bomb_person"><span> <input type="text"
								id="user-years" name="age" placeholder="请输入年龄"
								onblur="add_cue()"></span></td>
					</tr>
					<tr class="need_one">
						<td class="drug_bomb_person"><span>就诊医院：</span><span
							style="color: red;">*</span></td>
						<td class="drug_bomb_person"><span> <input type="text"
								id="user-hospital" name="hospital" placeholder="请输入医院"
								onblur="add_cue()"></span></td>
					</tr>
					<tr class="need_one">
						<td class="drug_bomb_person"><span>处方医生：</span><span
							style="color: red;">*</span></td>
						<td class="drug_bomb_person"><span> <input type="text"
								id="user-doctor" name="doc" placeholder="请输入医生"
								onblur="add_cue()"></span></td>
					</tr>
					<tr class="need_one">
						<td class="drug_bomb_person"><span>性别：</span><span
							style="color: red;">*</span></td>
						<td class="drug_bomb_person"><span> <input
								type="radio" id="" name="sex" value="0" checked="checked">女
									<input type="radio" id="" name="sex" value="1">男 </span></td>
					</tr>
					<tr class="need_two">
						<td class="drug_bomb_person"><span
							style="padding-bottom: 80px;">上传处方：</span></td>
						<td class="drug_bomb_person"><span> <input type='file'
								name="pic" id='iptfileupload' onchange='uploadPic()' value='' />
								<input type="hidden" name="pic" id="imgUrl" value="" /> <img
								src='../images/camera.png' alt='' id='img' width="100px" />

						</span></td>
					</tr>
					<tr class="need_one">
						<td class="drug_bomb_person"><span>病情概述：</span></td>
						<td class="drug_bomb_person"><span><input type="text"
								id="remarks" name="disContent" placeholder="请输入概述"></span></td>
					</tr>
					<tr>
						<td class="drug_bomb_person"></td>
						<td class="drug_bomb_person">
							<p>
								<img src="../images/stop.png"
									style="width: 15px; margin-right: 3px; display: none; margin-top: -4px;"
									id="add_address_cue_img" /><small style="color: red;"
									id="add_address_cue"></small>
							</p>
						</td>
						<tr>
							<td class="drug_bomb_person drug_bomb_button" colspan="2"
								style="border-bottom: 1px dashed #cdcdcd;"><input
								type="button" name="" id="" value="提交" onclick="add_button()" />
								<input type="button" name="" id="" value="取消" onclick="del()" />
							</td>
						</tr>

						<tr>
							<td colspan="2" style="text-align: center;"><label>如需帮助请拨打客服热线：0571-83731253</label></td>
						</tr>
				</tbody>

			</table>
		</form>
	</div>

	<!--需求登记 2018-4-28-->

	<!--顶部导航条 -->
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
	<!--顶部导航条 -->
		<!--悬浮搜索框-->
		<div class="nav white">
			<div class="logo">
				<img src="images/logo.png" onclick="first()" />
			</div>
			<div class="logoBig">
				<li><a href="#"><img src="images/logobig.png"
						onclick="first()" /></a></li>
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
		<!--悬浮搜索框-->
		<!--悬浮搜索框-->
		<div class="float_search_box">
			<div class="float_search">
				<div class="float_search_b">
					<form>
						<input type="text" name="" id="searchInput2" placeholder="搜索"
							autocomplete="off" oninput="search_list2();" /> <input
							type="button" name="" id="" value="搜索" onclick="searchKeyword1()" />
					</form>
				</div>
			</div>
		</div>
	<!--悬浮搜索框，自动提示-->
	<div class="clear"></div>
	<b class="line"></b>
	<div class="listMain">
		<!--分类-->
		<div class="nav-table">
			<div class="long-title">
				<span class="all-goods">${product.name}</span>
			</div>
		</div>

		<script type="text/javascript">
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation : "slide",
					start : function(slider) {
						$('body').removeClass('loading');
					}
				});
			});
			//初始化
			$(function() {
				//初始化加载，触发click事件,选中第一个规格,li标签
				$("#size_spec li:first").trigger("click");
			});
			var skuId;
			//点击价格变动、库存变动
			function disprice(price, kc, id) {
				//颜色Id
				if (price != null && price != '') {
					//设置售价
					$("#sku_p").html(price);
					skuId = id;
				} else {
					$("#sku_p").html('此商品暂时无法销售!');
					$("#prescription_no").hide();
				}
				if (kc != null && kc != '') {
					//设置库存
					$("#kc").html("库存" + kc + "件");
				} else {
					$("#kc").html('该商品暂不支持销售!');
					$("#prescription_no").hide();
				}
				if (kc == 0) {
					$("#kc").html('该商品暂时无货!');
					$("#prescription_no").hide();
					$("#prescription_yes").hide();
				}
			}
			function is_login() {
				//去判断是否登录 0、1
				$.ajax({
					url : "/login/isLogin.do",
					type : "post",
					dataType : "json",
					success : function(data) {
						//0、1判断
						//alert(data);
						if (data.status == 1) {

						} else {
							window.location.href = "/login/tologin?returnUrl="
									+ encodeURIComponent(window.location.href);
						}
					}
				});
			}
			//立即购买
			function imdBuy() {
				var isCoounter = $("#cccounter").val();
				var preId = $("#preId").val();
				//alert(isCoounter);
				if (isCoounter == 1) {
					if (null == preId || "" == preId) {
						alert("此商品为处方药品，请先登记处方，再提交购买!");
						return;
					} else {
						window.location.href = '/order/toPay?skuId=' + skuId
								+ "&amount=" + $("#text_box").val()
								+ "&returnUrl="
								+ encodeURIComponent(window.location.href)
								+ "&preId=" + preId + "&type=0"
								+ "&orderType=0";

					}
				} else {
					window.location.href = '/order/toPay?skuId=' + skuId
							+ "&amount=" + $("#text_box").val() + "&returnUrl="
							+ encodeURIComponent(window.location.href)
							+ "&type=0" + "&orderType=0";
				}

			}
			//购物车
			function addToCart() {
				var isCoounter = $("#cccounter").val();
				var preId = $("#preId").val();
				//alert(isCoounter);
				if (isCoounter == 1) {
					if (null == preId || "" == preId) {
						alert("此商品为处方药品，请先登记处方，再提交购买!");
						return;
					}
				}
				window.location.href = '/cart/addToCart?skuId=' + skuId
						+ "&amount=" + $("#text_box").val() + "&preId=" + preId
						+ "&returnUrl="
						+ encodeURIComponent(window.location.href);
			}
		</script>
		<div class="scoll">
			<section class="slider">
			<div class="flexslider">
				<ul class="slides">

					<li><img src="../images/01.jpg" title="pic" /></li>
					<li><img src="../images/02.jpg" /></li>
					<li><img src="../images/03.jpg" /></li>
				</ul>
			</div>
			</section>
		</div>

		<!--放大镜-->

		<div class="item-inform">
			<div class="clearfixLeft" id="clearcontent">

				<div class="box">
					<script type="text/javascript">
						$(document).ready(
								function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(
											function() {
												$(this).parents("li").addClass(
														"tb-selected")
														.siblings()
														.removeClass(
																"tb-selected");
												$(".jqzoom").attr(
														'src',
														$(this).find("img")
																.attr("mid"));
												$(".jqzoom").attr(
														'rel',
														$(this).find("img")
																.attr("big"));
											});
								});
					</script>

					<div class="tb-booth tb-pic tb-s310">
						<a href="${product.pics[0]}"><img src="${product.pics[0]}"
							alt="细节展示放大镜特效" rel="${product.pics[0]}" class="jqzoom"
							onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" /></a>
					</div>
					<ul class="tb-thumb" id="thumblist">
						<c:choose>
							<c:when test="${product.pics!=null}">
								<c:forEach items="${product.pics}" var="pics">
									<li class="tb-selected">
										<div class="tb-pic tb-s40">
											<a href="#"><img src="${pics}" mid="${pics}"
												big="${pics}" class="comm_img"
												onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'" /></a>
										</div>
									</li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="tb-pic tb-s40">
									<a href="#"><img
										src="<%=request.getContextPath()%>/images/kong.jpg"
										mid="<%=request.getContextPath()%>/images/kong.jpg"
										big="<%=request.getContextPath()%>/images/kong.jpg"
										class="comm_img" /></a>
								</div>
							</c:otherwise>
						</c:choose>


					</ul>
				</div>

				<div class="clear"></div>
			</div>

			<div class="clearfixRight">

				<!--规格属性-->
				<!--名称-->
				<div class="tb-detail-hd">
					<c:if test="${product.isCounter}">
						<input type="hidden" id="cccounter" value="1" />
						<img src="../images/ico_bs2.jpg" />
					</c:if>
					<c:if test="${!product.isCounter}">
						<input type="hidden" id="cccounter" value="0" />
						<img src="../images/ico_bs1.jpg" />
					</c:if>
					<h1>${product.name}</h1>
				</div>
				<div class="tb-detail-list">
					<!--价格-->
					<div class="tb-detail-price">
						<li class="price iteminfo_price">
							<dt>零售价</dt>
							<dd>
								<em>¥</em><b class="sys_item_price" id="sku_p">56.00</b>
							</dd>
						</li>
						<div class="clear"></div>
					</div>

					<!--地址-->
					<dl class="iteminfo_parameter freight">
						<dt>运费</dt>
						<div class="iteminfo_freprice">
							<div class="pay-logis">
								<b class="sys_item_freprice"> <c:if
										test="${product.whetherFee}">
										<span style="color: red">包邮</span>
									</c:if> <c:if test="${!product.whetherFee}">
										<c:choose>
											<c:when test="${null!=product.mailFee}">${product.mailFee.money}</c:when>
											<c:otherwise>
												<span style="color: red">包邮</span>
											</c:otherwise>
										</c:choose>
									</c:if>

								</b>
							</div>
						</div>
					</dl>
					<div class="clear"></div>

					<!--销量-->
					<ul class="tm-ind-panel">
						<li class="tm-ind-item tm-ind-sellCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">浏览量</span><span class="tm-count">${product.clickNum}</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-sumCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">累计销量</span><span class="tm-count">${product.sales}</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
							<div class="tm-indcon">
								<span class="tm-label">累计评价</span><span class="tm-count">${disComments.allComments}</span>
							</div>
						</li>
					</ul>
					<div class="clear"></div>

					<!--各种规格-->
					<dl class="iteminfo_parameter sys_item_specpara">
						<dt class="theme-login">
							<div class="cart-title">
								可选规格<span class="am-icon-angle-right"></span>
							</div>
						</dt>
						<dd>
							<!--操作页面
								<div class="theme-popover-mask"></div>-->

							<div class="theme-popover">
								<div class="theme-span"></div>
								<div class="theme-poptit">
									<a href="javascript:;" title="关闭" class="close">×</a>
								</div>
								<div class="theme-popbod dform">
									<form class="theme-signin" name="loginform" action=""
										method="post">

										<div class="theme-signin-left">

											<div class="theme-options" id="size_spec">
												<div class="cart-title">规格</div>
												<ul>
													<c:choose>
														<c:when test="${fn:length(product.skus)>0}">
															<c:forEach items="${product.skus}" var="sku">
																<li class="sku-line"
																	onclick="disprice('${sku.price}','${sku.stock}','${sku.id}')">${sku.spec}<i></i></li>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<li class="sku-line" onclick="disprice()">暂无可售规格<i></i></li>
														</c:otherwise>
													</c:choose>
												</ul>
											</div>
											<div class="theme-options">
												<div class="cart-title number">数量</div>
												<dd>
													<input id="min" class="am-btn am-btn-default" name=""
														type="button" value="-" /> <input id="text_box" name=""
														type="text" value="1" style="width: 30px;" /> <input
														id="add" class="am-btn am-btn-default" name=""
														type="button" value="+" /> <span id="Stock"
														class="tb-hidden"><span id="kc" class="stock">库存1000件</span>
													</span>
												</dd>

											</div>
											<div class="clear"></div>

											<div class="btn-op">
												<div class="btn am-btn am-btn-warning"
													onclick="addshop_but(this)">确认</div>
												<div class="btn close am-btn am-btn-warning">取消</div>
											</div>
										</div>
										<div class="theme-signin-right">
											<div class="img-info">
												<img src="../../images/songzi.jpg" />
											</div>
											<div class="text-info">
												<span class="J_Price price-now">¥39.00</span> <span
													id="Stock" class="tb-hidden">库存<span id="kc"
													class="stock">1000</span>件
												</span>
											</div>
										</div>

									</form>
								</div>
							</div>

						</dd>
					</dl>
					<div class="clear"></div>
					<!--活动	-->
					<div class="shopPromotion gold">
						<div class="clear"></div>
						<div class="coupon">
							<dt class="tb-metatit">优惠券</dt>
							<div class="gold-list">
								<ul>
									<li onclick="gold(this)">125减5<i class="gold-list-i"></i></li>
									<li onclick="gold(this)">198减10</li>
									<li onclick="gold(this)">298减20</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="pay">
					<div class="pay-opt">
						<a href="../home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
						<a><span class="am-icon-heart am-icon-fw">收藏</span></a>

					</div>
					<c:if test="${product.isCounter}">
						<div id="prescription_yes" onclick="show()">
							<div class=" tb-btn ">
								<a title="点此按钮到下一步确认购买信息" href="#"
									style="border: 1px solid #0b74df; background-color: #0b74df; color: #fff; margin-top: 20px; padding: 5px;">处方登记</a>
							</div>
							<p class="prompt_drug">本品为处方药，您成功预订后，展示药品的药店会根据处方审核结果主动与您联系。（如需协助请拨打0571-83731253）</p>
						</div>
					</c:if>
					<div id="prescription_no">
						<li>
							<div class="clearfix tb-btn tb-btn-buy theme-login">
								<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#"
									onclick="imdBuy()">立即购买</a>
							</div>
						</li>
						<li>
							<div class="clearfix tb-btn tb-btn-basket theme-login">
								<a id="LikBasket" title="加入购物车" onclick="addshop_i(this)"><i></i>加入购物车</a>
							</div>
						</li>
					</div>
				</div>

			</div>
			<div class="clear"></div>
		</div>


		<!-- introduce-->

		<div class="introduce">
			<div class="browse">
				<div class="mc">
					<ul>
						<div class="mt">
							<h2>相关推荐</h2>
						</div>
						<c:forEach items="${product.products}" var="p2">
							<li>
								<div class="p-img">
									<a href="#"> <img class="" src="${p2.pic}"
										onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'"></a>
								</div>
								<div class="p-name">
									<a href="#"> ${p2.name} </a>
								</div>
								<div class="p-price">
									<strong>￥ <c:choose>
											<c:when test="${p2.price>=0}">${p2.price}</c:when>
											<c:otherwise>此商品暂不销售</c:otherwise>
										</c:choose>
									</strong>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="introduceMain">
				<div class="am-tabs" data-am-tabs>
					<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#"> <span
								class="index-needs-dt-txt">宝贝详情</span>
						</a></li>

						<li><a href="#"> <span class="index-needs-dt-txt">全部评价</span>
						</a></li>
						<!--  
							<li>
								<a href="#">
									<span class="index-needs-dt-txt">猜你喜欢</span>
								</a>
							</li>-->
					</ul>

					<div class="am-tabs-bd">
						<div class="am-tab-panel am-fade am-in am-active">
							<div class="J_Brand">
								<div class="attr-list-hd tm-clear">
									<h4>产品参数：</h4>
								</div>
								<div class="clear"></div>
								<ul id="J_AttrUL">
									<li title="">生产厂家:&nbsp;${product.fac_name}</li>
									<li title="">产品规格:&nbsp;${product.specs}</li>
									<li title="">包装清单:&nbsp;${product.packageList}</li>
									<li title="">是否处方:&nbsp;<c:if test="${product.isCounter}">需要处方</c:if>
										<c:if test="${!product.isCounter}">不需要处方</c:if>
									</li>
									<li title="">经营药房:&nbsp;${product.ph_name}</li>
									<li title="">批准文号:&nbsp;${product.batchNum}</li>
									<li title="">剂型:&nbsp;${product.dosage}</li>
								</ul>
								<div class="clear"></div>
							</div>

							<div class="details">
								<div class="attr-list-hd after-market-hd">
									<h4>商品细节</h4>
								</div>
								<div class="twlistNews">${product.description}</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="am-tab-panel am-fade">
							<div class="actor-new">
								<div class="rate">
									<strong><b id="good_ratio">${disComments.accountGood}</b><span>%</span></strong><br>
										<span>好评度</span>
								</div>
							</div>
							<div class="bili_box">
								<div class="bili_list">
									<span>好评（<label class="bili_1">${disComments.accountGood}</label>%）
									</span>
									<div class="bili">
										<div class="bili_red"></div>
									</div>
								</div>
								<div class="bili_list">
									<span>中评（<label class="bili_2">${disComments.accountMid}</label>%）
									</span>
									<div class="bili">
										<div class="bili_red"></div>
									</div>
								</div>
								<div class="bili_list">
									<span>差评（<label class="bili_3">${disComments.accountLow}</label>%）
									</span>
									<div class="bili">
										<div class="bili_red"></div>
									</div>
								</div>
							</div>
							<div class="clear"></div>
							<div class="tb-r-filter-bar">
								<ul class=" tb-taglist am-avg-sm-4">
									<li class="tb-taglist-li tb-taglist-li-current">
										<div class="comment-info">
											<span>全部评价</span> <span class="tb-tbcr-num">(<span
												class="good_ratio_total">${disComments.allComments}</span>)
											</span>
										</div>
									</li>

									<li class="tb-taglist-li tb-taglist-li-1">
										<div class="comment-info">
											<span>好评</span> <span class="tb-tbcr-num">(<span
												class="good_ratio_1">${disComments.good}</span>)
											</span>
										</div>
									</li>

									<li class="tb-taglist-li tb-taglist-li-0">
										<div class="comment-info">
											<span>中评</span> <span class="tb-tbcr-num">(<span
												class="good_ratio_2">${disComments.mid}</span>)
											</span>
										</div>
									</li>

									<li class="tb-taglist-li tb-taglist-li--1">
										<div class="comment-info">
											<span>差评</span> <span class="tb-tbcr-num">(<span
												class="good_ratio_3">${disComments.low}</span>)
											</span>
										</div>
									</li>
								</ul>
							</div>
							<div class="clear"></div>

							<ul class="am-comments-list am-comments-list-flip">
								<c:forEach items="${disComments.comments}" var="coms">
									<li class="am-comment">
										<!-- 评论容器 --> <a href=""> <img class="am-comment-avatar"
											src="${coms.user.pic}"
											onerror="javascript:this.src='<%=request.getContextPath()%>/images/hwbn40x40.jpg'" />
											<!-- 评论者头像 -->
									</a>

										<div class="am-comment-main">
											<!-- 评论内容容器 -->
											<header class="am-comment-hd"> <!--<h3 class="am-comment-title">评论标题</h3>-->
											<div class="am-comment-meta">
												<!-- 评论元数据 -->
												<a href="#link-to-user" class="am-comment-author">${coms.user.nickname}</a>
												<!-- 评论者 -->
												评论于
												<time datetime=""> <date:date value="${coms.addtime}" /></time>
											</div>
											</header>

											<div class="am-comment-bd">
												<div class="tb-rev-item " data-id="255776406962">
													<div class="J_TbcRate_ReviewContent tb-tbcr-content ">
														${coms.content}</div>

													<div class="tb-r-act-bar">
														评价：
														<c:choose>
															<c:when test="${coms.greade==0}">好评</c:when>
															<c:when test="${coms.greade==1}">中评</c:when>
															<c:otherwise>差评</c:otherwise>
														</c:choose>
													</div>
												</div>

											</div>
											<!-- 评论内容 -->
										</div>
									</li>
								</c:forEach>

							</ul>

							<div class="clear"></div>

							<!--分页 -->

							<ul class="am-pagination am-pagination-right">
								<!-- <li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active" onclick="page_number(1,this)"><a>1</a>
								</li>
								<li onclick="page_number(2,this)"><a>2</a></li>
								<li onclick="page_number(3,this)"><a>3</a></li>
								<li onclick="page_number(4,this)"><a>4</a></li>
								<li onclick="page_number(5,this)"><a>5</a></li>
								<li onclick="page_number(6,this)"><a>6</a></li>
								<li><a>&raquo;</a></li>-->
							</ul>
							<div class="clear"></div>

							<div class="tb-reviewsft">
								<div class="tb-rate-alert type-attention">
									购买前请查看该商品的 <a href="#" target="_blank">购物保障</a>，明确您的售后保障权益。
								</div>
							</div>

						</div>

						<div class="am-tab-panel am-fade">
							<div class="like">
								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<a href="introduction.html"> <img
												src="../images/imgsearch1.jpg" />
												<p>
													【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>298.00</strong>
												</p>
											</a>
										</div>
									</li>

								</ul>
							</div>
							<div class="clear"></div>

							<!--分页 -->
							<ul class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active" onclick="page_number(1,this)"><a>1</a>
								</li>
								<li onclick="page_number(2,this)"><a>2</a></li>
								<li onclick="page_number(3,this)"><a>3</a></li>
								<li onclick="page_number(4,this)"><a>4</a></li>
								<li onclick="page_number(5,this)"><a>5</a></li>
								<li><a>&raquo;</a></li>
							</ul>
							<div class="clear"></div>

						</div>

					</div>

				</div>

				<div class="clear"></div>

				<div class="footer">
						<div class="footer-hd">
							<p>
								<a href="/aboutUs">杭州临武医药科技有限公司</a>
								<b>|</b>
								<a href="/">商城首页</a>
								
							</p>
						</div>
						<div class="footer-bd">
							<p>
								<a href="/aboutUs">关于临武医药</a>
							</p>
						</div>
					</div>

		</div>
	</div>
	<!--菜单 2018-5-22-->
	<div class="tip1">
		<div id="sidebar">
			<div id="wrap ">
				<div id="prof " class="item ">
					<a onclick="window.location.href='/user/userCenter'"> <span
						class="setting "></span>
					</a>
				</div>
				<div id="shopCart " class="item "
					onclick="window.location.href='/cart/toCart'">
					<a> <span class="message "></span>
					</a>
					<p>购物车</p>
					<p class="cart_num ">${countCart}</p>
				</div>

				<div class="quick_toggle">
				<!-- 
					<li class="qtitem "><a href="# "><span class="kfzx "></span></a>
					</li> -->
					<!--二维码 -->
					<li class="qtitem "><a href="#none " id="weixin_hover"><span
							class="mpbtn_qrcode "></span></a>
						<div class="mp_qrcode " style="display: none;">
							<img src="/images/weixin_code_145.png " /><i
								class="icon_arrow_white "></i>
						</div>
						<div class="QR_weixin" style="display:none;">
							<div class="QR_weixin_d"></div>
							<img src="/images/weixin_code_145.png" />
							<p>扫码关注微信公众号</p>
						</div></li>
					<li class="qtitem "><a href="#top " class="return_top "><span
							class="top "></span></a></li>
				</div>
				<!--回到顶部 -->
			</div>
		</div>

	</div>
	<!--菜单 -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write('<script src="basic/js/jquery.min.js "><\/script>');
		$("#weixin_hover").hover(function(){$(".QR_weixin").show();},function(){$(".QR_weixin").hide();});
	</script>
	
</body>

</html>