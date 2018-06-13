<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="x-ua-compatible" content="IE=10" />
<title>院外要热搜、热门搜索</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/admin.css" rel="stylesheet" type="text/css" />

<link href="../css/demo.css" rel="stylesheet" type="text/css" />

<link href="../css/seastyle.css" rel="stylesheet" type="text/css" />
<link href="../css/new.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script type="text/javascript" src="../js/search.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
<script type="text/javascript">
	//全局变量
	//keyword是从前面的URL中传来的要用param取
	//后台传来的直接用el表达式取
	var keyword = '${param.keyword}';
	var price = '${price}';
	var brandId = '${brandId}';
	var typeId = '${typeId}';
	var funId = '${funId}';
	var disId = '${disId}';
	
	//搜索
	function serachKeyword() {
		window.location.href = "/search?keyword=" + $("#keyword").val();
	}
	//过滤条件
	//点击 品牌   id == 品牌ID
	//判断是否已经过滤价格，price存在则已过滤
	function fqBrand(id) {
		//判断是否有价格
		if (price != '') {
			window.location.href = "/search?keyword=" + keyword + "&brandId="
					+ id + "&price=" + price;
		} else {
			window.location.href = "/search?keyword=" + keyword + "&brandId="
					+ id;
		}
	}
	//点击价格 id == 价格区间
	//判断此前是否已做品牌过滤，brandId存在则已经过滤
	function fqPrice() {
		if (brandId != '') {
			//刷新
			window.location.href = "/search?keyword=" + keyword + "&price="
					+ id + "&brandId=" + brandId;
		} else {
			//刷新
			window.location.href = "/search?keyword=" + keyword + "&price="
					+ id;
		}
	}
	//移除已选条件
	function move(id) {
		if (id == '品牌') {
			if (price != '') {
				window.location.href = "/search?keyword=" + keyword + "&price="
						+ price;
			} else {
				window.location.href = "/search?keyword=" + keyword;
			}
		} else {
			if (brandId != '') {
				window.location.href = "/search?keyword=" + keyword
						+ "&brandId=" + brandId;
			} else {
				window.location.href = "/search?keyword=" + keyword;
			}
		}

	}

	//登陆
	function login() {
		window.location.href = "http://localhost:8087/shopping/login.aspx?returnUrl="
				+ encodeURIComponent(window.location.href);
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

	/*类型太多超出隐藏*/
	function beyond(ob) {
		if ($(ob).find("span").text() == "更多") {
			$(ob).find("span").text("收起")
			$(ob).find(".area-beyimg").attr("src", "../images/beyond2.png")
			$(ob).parents(".dd-conent").css("max-height", "none")
		} else {
			$(ob).find("span").text("更多")
			$(ob).find(".area-beyimg").attr("src", "../images/beyond1.png")
			$(ob).parents(".dd-conent").css("max-height", "60px")
		}

	}
	window.onload = function() {
		var ondhtml = '<div class="area-beyond" onclick="beyond(this)"><span href="#">更多</span><img src="../images/beyond1.png" class="area-beyimg"/></div>'
		for (i = 0; i < $(".select-list").length; i++) {
			if ($(".select-list").eq(i).find(".dd-conent").height() >= 60) {
				$(".select-list").eq(i).find(".dd-conent").css("max-height",
						"60px")
				$(".select-list").eq(i).find(".dd-conent").append(ondhtml)
			}
		}
		$(".select-list")
	}
</script>
<script type="text/javascript">
	var keyword = '${keyword}';
	var brandId = '${brandId}';
	var typeId = '${typeId}';
	var funId = '${funId}';
	var disId = '${disId}';
	function TP() {
		prix('${keyword}', '${brandId}', '${typeId}', '${funId}', '${disId}')
	}
	function bs(id) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&typeId=" + typeId + "&funId=" + funId + "&disId=" + disId
				+ "&brandId=" + id;
	}
	function ts(id) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&typeId=" + id + "&funId=" + funId + "&disId=" + disId
				+ "&brandId=" + brandId;
	}
	function fs(id) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&typeId=" + typeId + "&funId=" + id + "&disId=" + disId
				+ "&brandId=" + brandId;
	}
	function ds(id) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&typeId=" + typeId + "&funId=" + funId + "&disId=" + id
				+ "&brandId=" + brandId;
	}
	function searchK() {
		var k = $("#searchInput").val();
		window.location.href = "/product/search?keyword=" + k;

	}
	function comprehensive() {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&typeId=" + typeId + "&funId=" + funId + "&disId=" + disId
				+ "&brandId=" + brandId;
	}
	function priceFirst(id) {
		window.location.href = "/product/search?keyword=" + keyword + "&price="
				+ price + "&typeId=" + typeId + "&funId=" + funId + "&disId="
				+ disId + "&brandId=" + brandId + "&priceType=" + id;
	}
	function datil(id) {
		window.location.href = "/product/query?id=" + id;
	}
	function XXLogout() {
		window.location.href = "/login/exit";
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
	function first() {
		window.location.href = "/"
	}
	function bbs() {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&typeId=" + typeId + "&disId=" + disId + "&funId=" + funId;
	}
	function tts(keyword, bid, tid, fid, did) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&brandId=" + brandId + "&funId=" + funId + "&disId=" + disId;
	}
	function ffs(keyword, bid, tid, fid, did) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&brandId=" + brandId + "&typeId=" + typeId + "&disId="
				+ disId;
	}
	function dds(keyword, bid, tid, fid, did) {
		window.location.href = "/product/search?keyword=" + keyword
				+ "&brandId=" + brandId + "&typeId=" + typeId + "&funId="
				+ funId;
	}
	function qcc() {
		window.location.href = "/product/search?keyword=" + keyword;
	}
</script>
</head>

<body>
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
	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<a>欢迎来到生医容美大药房！</a> <a href="#" onclick="XXLogin()" target="_top"
						class="h" id="login">[亲，请登录]</a> <a href="#"
						onclick="XXRegister()" target="_top" id="regist">[免费注册]</a><a
						href="javascript:;" onclick="XXLogout()" id="logout">[退出]</a> <a
						href="#" id="usName" onclick="toUserCenter('${uid}')"></a>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top" id="uscc"
						onclick="toUserCenter('${uid}')">个人中心</a>
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
						class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
				</div>
			</div>-->
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="../images/logo.png" />
		</div>
		<div class="logoBig">
			<li><a href="#" onclick="first()"><img
					src="../images/logobig.png" /></a></li>
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form>
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off" oninput="search_list()">
					<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="button" onclick="searchK()">
			</form>
		</div>
	</div>
	<!--悬浮搜索框-->
	<div class="float_search_box">
		<div class="float_search">
			<div class="float_search_b">
				<form>
					<input type="text" name="" id="searchInput2" placeholder="搜索"
						autocomplete="off" oninput="search_list2()" /> <input
						type="button" name="" id="" value="搜索" onclick="searchK()" />
				</form>
			</div>
		</div>
	</div>
	<!--悬浮搜索框-->
	<div class="clear"></div>
	<b class="line"></b>
	<div class="search">
		<div class="search-list">
			<div class="nav-table">
				<div class="long-title">
					<span class="all-goods">全部分类</span>
				</div>
				<div class="nav-cont">
					<ul>

					</ul>
				</div>
			</div>

			<div class="am-g am-g-fixed">
				<div class="am-u-sm-12 am-u-md-12">
					<div class="theme-popover">
						<ul class="select">
							<div class="clear"></div>
							<li class="select-result">
								<dl>
									<dt>已选</dt>
									<dd class="select-no"></dd>
									<p class="eliminateCriteria" onclick="qcc()">清除</p>

									<c:forEach items="${brands}" var="bs">
										<c:if test="${bs.id==brandId}">
											<dd class="selected" id="selectA">
												<a href="#" onclick="bbs()">${bs.brandName}</a>
											</dd>
										</c:if>
									</c:forEach>

									<c:forEach items="${proTypes}" var="pts">
										<c:if test="${pts.id==typeId}">
											<dd class="selected" id="selectB">
												<a href="#" onclick="tts()">${pts.typeName}</a>
											</dd>
										</c:if>
									</c:forEach>

									<c:forEach items="${funTypes}" var="ftts">
										<c:if test="${ftts.id==funId}">
											<dd class="selected" id="selectC">
												<a href="#" onclick="ffs()">${ftts.name}</a>
											</dd>
										</c:if>
									</c:forEach>

									<c:forEach items="${diseases}" var="diss">
										<c:if test="${diss.id==disId}">
											<dd class="selected" id="selectD">
												<a href="#" onclick="dds()">${diss.name}</a>
											</dd>
										</c:if>
									</c:forEach>
								</dl>
							</li>
							<div class="clear"></div>
							<c:if test="${empty brandId}">
								<li class="select-list">
									<dl id="select1">
										<dt class="am-badge am-round">品牌</dt>

										<div class="dd-conent">
											<dd class="select-all selected">
												<a href="#">全部</a>
											</dd>
											<c:forEach items="${brands}" var="brand">
												<dd>
													<a href="#" onclick="bs('${brand.id}')">${brand.brandName}</a>
												</dd>
											</c:forEach>
										</div>
									</dl>
								</li>
							</c:if>
							<c:if test="${empty typeId}">
								<li class="select-list">
									<dl id="select2">
										<dt class="am-badge am-round">产品类型</dt>
										<div class="dd-conent">
											<dd class="select-all selected">
												<a href="#">全部</a>
											</dd>
											<c:forEach items="${proTypes}" var="proType">
												<dd>
													<a href="#" onclick="ts('${proType.id}')">${proType.typeName}</a>
												</dd>
											</c:forEach>
										</div>
									</dl>
								</li>
							</c:if>
							<c:if test="${empty funId}">
								<li class="select-list">
									<dl id="select3">
										<dt class="am-badge am-round">适应范围</dt>
										<div class="dd-conent">
											<dd class="select-all selected">
												<a href="#">全部</a>
											</dd>
											<c:forEach items="${funTypes}" var="funType">
												<dd>
													<a href="#" onclick="fs('${funType.id}')">${funType.name}</a>
												</dd>
											</c:forEach>
										</div>
									</dl>
								</li>
							</c:if>
							<c:if test="${empty disId}">
								<li class="select-list">
									<dl id="select4">
										<dt class="am-badge am-round">对应症</dt>
										<div class="dd-conent">
											<dd class="select-all selected">
												<a href="#">全部</a>
											</dd>
											<c:forEach items="${diseases}" var="disease">
												<dd>
													<a href="#" onclick="ds('${disease.id}')">${disease.name}</a>
												</dd>
											</c:forEach>
										</div>
									</dl>
								</li>
							</c:if>
							<!-- 
							<c:if test="${empty price}">
								<li class="select-list">
									<dl id="select3">
										<dt class="am-badge am-round">价格范围</dt>
										<div class="dd-conent">
											<dd class="select-all selected">
												<a href="#" onclick="qin()">全部</a>
											</dd>
											<div class="select_list_price">
												<input type="text" placeholder="￥" size="22" /> - <input
													type="text" placeholder="￥" size="22" /> <input
													type="button" value="确定" onclick="TP()" />
											</div>
										</div>
									</dl>
								</li>
							</c:if> -->
						</ul>
						<div class="clear"></div>
					</div>
					<div class="search-content">
						<div class="sort">
							<li class="first" onclick="classify_opt(this)"><a title="综合"
								onclick="comprehensive()">综合排序</a></li>
							<li onclick="classify_opt(this)"><a title="价格"
								onclick="priceFirst(2)">价格优先</a></li>
						</div>
						<div class="clear"></div>

						<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
							<c:forEach items="${pagination.list}" var="spro">
								<li onclick="datil('${spro.id}')">
									<div class="i-pic limit">
										<img src="${spro.pic}" />
										<p class="title fl">${spro.name}</p>
										<p class="price fl">
											<b>¥</b> <strong>${spro.price}</strong>
										</p>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="clear"></div>
					<!--分页 -->
					<ul class="am-pagination am-pagination-right">
						<span style="font-size: 15px;">当前数据总数
							${pagination.totalCount} 条,单页最大显示 ${pagination.pageSize} 条. </span>
						&nbsp&nbsp&nbsp
						<c:forEach items="${pagination.pageView}" var="page">
				${page}
				</c:forEach>
					</ul>

				</div>
			</div>
		</div>

	</div>

	<!--引导 -->
	<div class="navCir">
		<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="shopcart.html"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a>
		</li>
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
						<div class="QR_weixin" style="display: none;">
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
	<div class="foot ">
		<div class="wt ">
			<p>
				<a href="/aboutUs"><span>关于我们</span></a>| <a href="# "><span>商家入驻</span></a>

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
<script type="text/javascript">
		
		$("#weixin_hover").hover(function(){$(".QR_weixin").show();},function(){$(".QR_weixin").hide();});
	</script>
</body>

</html>