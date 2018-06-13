<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="x-ua-compatible" content="IE=10" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>关于我们</title>
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<link href="../css/new.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/concerning.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function show_con(i){
				$(".concerning_body li").hide();
				$(".concerning_list li").removeClass("concerning_show");
				$(".concerning_body li").eq(i).show()
				$(".concerning_list li").eq(i).addClass("concerning_show");
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
		</script>
	</head>
	<body>
		<!--顶部导航条 -->
		<div style="background-color: #f1f1f1;">
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
					<!--  
					<div class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="shopcart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a>
						</div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
						</div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="../person/collection.html" target="_top"><i class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
						</div>
					</div>-->
				</ul>
			</div>
		</div>
		

		<!--body-->
		<div class="body">
			<div class="body_wt">
				<div class="concerning_list">
					<ul>
						<li onclick="show_con(0)" class="concerning_show"><span>关于我们</span></li>
						<li onclick="show_con(1)"><span>产家入驻</span></li>
						<li onclick="show_con(2)"><span>联系我们</span></li>
						<li onclick="show_con(3)"><span>退货流程</span></li>
					</ul>
				</div>
				<div class="concerning_body">
					<ul>
						<li >
							<div class="concerning_body_h">
								<h6>关于我们</h6>
							</div>
							<p>临武商城（www.51ywyf.com），全国首家合法网上药店(隶属杭州临武医药科技有限公司)。临武商城通过搭建开放式的医药零售电子商务平台为全球网上购物人群提供全面的（中西药品、保健品、成人用品、母婴用品、中药饮片、医疗器械等）健康医药信息与交易服务。</p>
							<p>临武商城致力于提供专业药品导购服务的第三方互联网药品交易服务平台，已获得国家食品药品监督管理局颁发的互联网药品交易服务资格证书，证书号：湘ICP备18006584号。</p>
							<p>临武商城立足于面向中小药店提供电子商务服务，推出“一小时开店”服务体系。借助平台权威完善的药品基础数据库系统，依托平台流量，大量药店实现了当日开店即有订单的良好局面。临武商城有近千家药店签约入驻，累计药品类目在售品规数达到8万余种。临武商城发展至今拥有庞大、权威的医药数据库，详尽介绍了近20余万种药品，收录10万多家药店，近2万家医院，5千多家药厂的信息。</p>
							<p>药品齐全——提供上万品规的药品、保健品、中药材及医疗器械等，全方位覆盖慢性疾病、老年科、男科、妇科、儿科病种用药，满足男女老少人群各类需求。</p>
							<p>渠道齐全——官方网站购药、临武商城微信端购药线上线下全渠道均可方便服务顾客。</p>
							<p>专业服务——超300位专业药师提供线上线下咨询购药、药事跟踪和售后药事服务。</p>
							<p>专业仓储——超10000方专业仓储配送基地，流水电子传送带作业，半自动包裹进出仓管理，订单全链条数据监控管理。</p>
						</li>
						<li >
							<div class="concerning_body_h">
								<h6>产家入驻</h6>
							</div>
							<p>浙江省萧山区萧山经济技术开发区启迪路198号B1-603室</p>
						</li>
						<li >
							<div class="concerning_body_h">
								<h6>联系我们</h6>
							</div>
							<p>企业所在地：浙江省萧山区萧山经济技术开发区启迪路198号B1-603室</p>
							<p>长沙分公司所在地：长沙市雨花区环保中路169号科研办公楼6005房</p>
							<p>网址：www.51ywyf.com</p>
							<p>客服热线：0571-8373-1253</p>
							<p>全国药店加盟商加盟、收购，商品代理、战略商品合作</p>
						</li>
						<li >
							<div class="concerning_body_h">
								<h6>退货流程</h6>
							</div>
							<img src="../images/con-ss1.jpg"/>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--body-->

		<div class="foot" >
			<div class="wt">
				<p>
					<a href="# "><span>关于我们</span></a>|
					<a href="# "><span>商家入驻</span></a>
				</p>
				<p><a href="http://www.miibeian.gov.cn" target=_blank><span>湘ICP备18006584号</span></a></p>
				<p>©2013-2018版权所有 杭州临武医药科技有限公司</p>
				<p></p>
			</div>
		</div>

	</body>

</html>