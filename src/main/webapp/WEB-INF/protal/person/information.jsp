<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0" />
<title>${user.nickname}的个人资料</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
<link href="../css/personal.css" rel="stylesheet" type="text/css" />
<link href="../css/infstyle.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/amazeui.js" type="text/javascript"></script>
<script src="../js/search_list.js"></script>
<script src="../js/person_infor.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript">
	function info() {
		window.location.href = "/user/info";
	}
	function userCenter() {
		window.location.href = "/user/userCenter";
	}
	function apply() {
		var nickname = $("#user-name2").val();
		var sex = $("#sex").val();
		var pic = $("#imgUrl").val();
		window.location.href = "/user/apply?nickname=" + nickname + "&sex="
				+ sex + "&pic=" + pic;
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
				$("#allUrl").attr("src", data.url);
				$("#imgUrl").val(data.url);
			}
		}
		//ajax模拟jvForm这个form的提交
		$("#jvForm").ajaxSubmit(options);
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
					<div class="menu-hd">
						<a href="person/collection.html" target="_top"><i
							class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
				</div>-->
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

				<div class="user-info">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small>
						</div>
					</div>
					<hr />
					<form id="jvForm" method="post" enctype="multipart/form-data">
						<!--头像 -->
						<div class="user-infoPic">
							<!--  
						<form id="jvForm" method="post"  enctype="multipart/form-data">-->
							<div class="filePic">
								<input type="file" id="picFile" name="pic" class="inputPic"
									onchange="uploadPic()" /><input type="hidden" name="pic"
									id="imgUrl" value="${user.pic}" /> <img id="allUrl"
									class="am-circle am-img-thumbnail" src="${user.pic}" alt=""
									onerror="javascript:this.src='<%=request.getContextPath()%>/images/getAvatar.do.jpg'" /></br>
								点击图片更换头像
							</div>
							<!--</form>  -->

							<p class="am-form-help">头像</p>

							<div class="info-m">
								<div>
									<b>用户名：<i>${user.nickname}</i></b>
								</div>
								<div class="u-level">
									<span class="rank r2"> <s class="vip1"></s><a
										class="classes" href="#">您是尊敬的处方外配平台会员</a>
									</span>
								</div>

							</div>
						</div>


						<!--个人信息 -->
						<div class="info-main">
							<form class="am-form am-form-horizontal">

								<div class="am-form-group">
									<label for="user-name2" class="am-form-label">昵称</label>
									<div class="am-form-content">
										<input type="text" name="nickname" id="user-name2"
											placeholder="nickname" value="${user.nickname}" />
									</div>
								</div>
								<!-- 
								<div class="am-form-group">
									<label for="user-name" class="am-form-label">姓名</label>
									<div class="am-form-content">
										<input type="text" id="user-name2" placeholder="name">

									</div>
								</div> -->

								<div class="am-form-group">
									<label class="am-form-label">性别</label>
									<div class="am-form-content sex">
										<label class="am-radio-inline"> <input id="sex"
											type="radio" name="sex" value="1"
											<c:if test="${user.sex==1}">checked="checked"</c:if>
											data-am-ucheck /> 男
										</label> <label class="am-radio-inline"> <input id="sex"
											type="radio" name="sex" value="0" checked="checked"
											<c:if test="${user.sex==0}">checked="checked"</c:if>
											data-am-ucheck /> 女
										</label>
									</div>
								</div>
								<!--  
								<div class="am-form-group">
									<label for="user-birth" class="am-form-label">生日</label>
									<div class="am-form-content birth">
										<div class="birth-select">
											<select style="overflow: scroll;" data-am-selected >
												<option value="a">2015</option>
												<option value="b">1970</option>
											</select>
											<em>年</em>
										</div>
										<div class="birth-select2 birth-select_one">
											<select data-am-selected>
												<option value="a">12</option>
												<option value="b">8</option>
											</select>
											<em>月</em></div>
										<div class="birth-select2 birth-select_two">
											<select data-am-selected>
												<option value="a">21</option>
												<option value="b">23</option>
											</select>
											<em>日</em></div>
									</div>
							
								</div>-->
								<div class="am-form-group">
									<label for="user-phone" class="am-form-label">电话</label>
									<div class="am-form-content">
										<input id="user-phone" placeholder="telephonenumber"
											type="tel" name="tel" disabled="disabled" onblur="phone()"
											value="${user.tel}" />
									</div>
								</div>
							</form>
							<!--  
								<div class="am-form-group">
									<label for="user-email" class="am-form-label" >电子邮件</label>
									<div class="am-form-content">
										<input id="user-email" placeholder="Email" type="email" onblur="email()">

									</div>
								</div>-->
							<div class="am-form-group address">
								<label for="user-address" class="am-form-label">收货地址</label>
								<div class="am-form-content address">
									<a href="address.html">
										<p class="new-mu_l2cw">
											<span class="province">湖北</span>省 <span class="city">武汉</span>市
											<span class="dist">洪山</span>区 <span class="street">雄楚大道666号(中南财经政法大学)</span>
											<span class="am-icon-angle-right"></span>
										</p>
									</a>

								</div>
							</div>
							<div class="am-form-group safety">
								<label for="user-safety" class="am-form-label">账号安全</label>
								<div class="am-form-content safety">
									<a href="safety.html"> <span class="am-icon-angle-right"></span>

									</a>

								</div>
							</div>
							<div class="info-btn">
								<div class="am-btn am-btn-danger" onclick="apply()">保存修改</div>
							</div>
					</form>
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