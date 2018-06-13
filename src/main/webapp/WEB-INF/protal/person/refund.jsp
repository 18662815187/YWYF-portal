<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />
<title>退换货</title>
<script src="../js/jquery-1.8.3.min.js" type="text/javascript"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/refstyle.css" rel="stylesheet" type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<script src="../js/search_list.js"></script>
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/picture.js" type="text/javascript"></script> 
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript">
function refund(){
	var ref = false;
	var tet = ""
	if($(".am-form-group").eq(0).find(".am-selected-list").find("li").eq(0).attr("class")=="am-checked"){
		ref = false;
		tet = "请选择退款类型";
	}
	else if($(".am-form-group").eq(1).find(".am-selected-list").find("li").eq(0).attr("class")=="am-checked"){
		ref = false;
		tet = "请选择售后原因";
	}else if($("textarea").val().length<=6){
		ref = false;
		tet = "退款说明至少6个字";
	}
	else{
		ref = true;
	}
	
	if(ref == true){
		$.ajax({
			url: '/order/applyRefund', //地址
			dataType: "json",
			type: "post",
			timeout: 5000,
			data: $('#jvForm').serialize(),
			success: function(data) {
				if(data.status==1){
					window.location.href="/order/toChange";
				}else if(data.status==-2){
					window.location.href="/login/toLogin?returnUrl="+encodeURIComponent(window.location.href);
				}else {
					alert("提交失败，请重试!");
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				//alert("请求超时，请保证网络畅通并重试!");
				/*alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);*/
			},

		})
	}else{
		alert(tet);
	}
	
}
//上传图片
function uploadPic() {
	//alert(1);
	//jquery.form.js
	var options = {
		//url : "/upload/uploadFck.do",
		url : "/upload/uploadPic1.do",
		dataType : "json",
		type : "post",
		success : function(data) {
			//alert(2);
			//返回的数据通过下方控件的id给他们设置值,src需要通过attr属性去设置，val可以直接设置
			//原数据存在图片时，重新上传替换URL需对此两个地方进行回显设置
			$("#img").attr("src", data.url);
			$("#imgUrl").val(data.url);
		}
	}
	//ajax模拟jvForm这个form的提交
	$("#jvForm").ajaxSubmit(options);
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
				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf">
						<strong class="am-text-danger am-text-lg">退换货申请</strong> / <small>Apply&nbsp;for&nbsp;returns</small>
					</div>
				</div>
				<hr />
				<div class="comment-list">
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step"> <em class="u-progress-stage-bg"></em>
								<i class="u-stage-icon-inner">1<em class="bg"></em></i>
								<p class="stage-name">买家申请售后</p>
							</span> <span class="step-2 step"> <em
								class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">2<em
									class="bg"></em></i>
								<p class="stage-name">商家处理售后</p>
							</span> <span class="step-3 step"> <em
								class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">3<em
									class="bg"></em></i>
								<p class="stage-name">售后处理完成</p>
							</span> <span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner"></div>
						</div>
					</div>

					<div class="refund-aside">
						<div class="item-pic">
							<a href="#" class="J_MakePoint"> <img
								src="${orderProduct.sku.product.pic}" class="itempic" onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'"/></a>
						</div>

						<div class="item-title">

							<div class="item-name">
								<a href="#">
									<p class="item-basic-info">${orderProduct.sku.product.name}</p>
								</a>
							</div>
							<div class="info-little">
								<span>规格：${orderProduct.sku.spec}</span> 
							</div>
						</div>
						<div class="item-info">
							<div class="item-price">
								<span class="info-title">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</span><span
									class="price">${orderProduct.sku.price}元</span> <span class="number">×</span><span
									class="item-title">${orderProduct.num}</span>
							</div>
						
							<div class="item-amountall">
								<span class="info-title">总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计：</span><span
									class="amountall">${orderProduct.sku.price * orderProduct.num}元</span>
							</div>
							<div class="item-time">
								<span class="info-title">成交时间：</span><span class="time"><date:date value="${orderProduct.addtime}"/></span>
							</div>

						</div>
						<div class="clear"></div>
					</div>
					<form action="" id="jvForm">
						<div class="refund-main">
							<div class="item-comment">
								<div class="am-form-group">
									<label for="refund-type" class="am-form-label">售后类型</label>
									<div class="am-form-content">
										<select data-am-selected="" name="reStyle">
											<option value="0" selected>请选择类型</option>
											<option value="1">退款/退货(已发货的必须选此项否则不受理)</option>
											<option value="2">换货</option>
											<option value="3">未发货,仅退款</option>
										</select>
									</div>
								</div>
								<input type="hidden" name="opId" value="${orderProduct.id}"/>
								<div class="am-form-group">
									<label for="refund-reason" class="am-form-label">售后原因</label>
									<div class="am-form-content">
										<select data-am-selected="" name="style">
											<option value="0" selected>请选择售后原因</option>
											<option value="1">不想要了</option>
											<option value="2">买错了</option>
											<option value="3">与说明不符</option>
											<option value="4">有破损</option>
											<option value="5">商家发错货</option>
										</select>
									</div>
								</div>

								<div class="am-form-group">
									<label for="refund-money" class="am-form-label">产品金额<span>（不可修改）</span></label>
									<div class="am-form-content">
										<input type="text" id="refund-money" readonly="readonly" placeholder="${orderProduct.sku.price * orderProduct.num}"/>
									</div>
								</div>
								<div class="am-form-group">
									<label for="refund-info" class="am-form-label">售后说明<span>（可不填）</span></label>
									<div class="am-form-content">
										<textarea placeholder="请输入退款说明" name="note"></textarea>
									</div>
								</div>

							</div>
							<div class="refund-tip">
								<div class="filePic">
									<input type="file" class="inputPic" name="pic" id='iptfileupload'
										onchange='uploadPic()' value="选择凭证图片"  max="5"
										maxsize="5120" allowexts="gif,jpeg,jpg,png,bmp"
										accept="image/*">
										<input type="hidden" name="img" id="imgUrl" />
										 <img src='../images/camera.png'
										alt='' class="img" width="52px" id="img" >
								</div>
								<span class="desc">上传凭证&nbsp;最多一张,如商品有破损请清晰拍出破损处</span>
							</div>
							<div class="info-btn">
								<div class="am-btn am-btn-danger" onclick="refund(this)">提交申请</div>
							</div>
						</div>
					</form>
					<div class="refund-success hidden">
						<img src="../images/wait.png" />
						<p>商家正在处理</p>
						<a href="order.html">点击返回订单管理</a>
					</div>
				</div>
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