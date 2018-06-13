<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0"/>
		<title>商品评价</title>
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>
		<link href="../css/personal.css" rel="stylesheet" type="text/css"/>
		<link href="../css/orstyle.css" rel="stylesheet" type="text/css"/>
		<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
		<script src="../js/search_list.js"></script>
		<script src="../js/person_order.js"></script>
		<script src="../js/jquery.min.js"></script>
		<script src="../js/amazeui.js"></script>
		<script type="text/javascript" src="../js/jquery.form.js"></script>
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
			/*去除多余*/
			window.onload = function() {
				//加载状态
				flow()
			}
			//评价商品
			function assess(ob) {
				var va = 0;
				var imgs = "";
				var xxxopid = $(ob).parents(".order-pin").find("#XXXXOPID").val();
				if($(ob).find("span").text() == "评价商品") {
					$(".order_button").show();
					$(ob).hide();
					$(ob).parents(".order-status5").find(".order-pin").css("display", "table-row");
				} else if($(ob).val() == "提交评论") {
					//判断评价是否小于六个字
					if($(ob).parents(".order-pin").find("textarea").val().length < 6){
						alert("你的评论至少为六个字")
					}
					else{
						//ajax
						var comm_id = $(ob).parents(".order-pin").prev().find(".order_tab2_t").find("p").eq(0).text(); //商品名字
						//评论文字
						var comm_val = $(ob).parents(".order-pin").find("textarea").val();
						//评论等级
						for(i=0;i<$(ob).parents(".order-pin").find(".item-opinion li").length;i++){
						if($(ob).parents(".order-pin").find(".item-opinion li").eq(i).find("i").attr("name")== 1 ){
						var comm_item = i; //0 ：好评  1：中评 2：差评 
						}
						}
						//alert(comm_item)
						//图片
						for(i=1;i<$(ob).parents(".order-pin").find(".filePic").length;i++){
							if(i == $(ob).parents(".order-pin").find(".filePic").length-1){
								imgs += $(ob).parents(".order-pin").find(".filePic").eq(i).find(".fileimg_imgs").attr("src")
							}
							else{
								imgs += $(ob).parents(".order-pin").find(".filePic").eq(i).find(".fileimg_imgs").attr("src")+","
							}
						}

						var comm_img = imgs   //评价图片
						//alert(imgs)
						 $.ajax({
             				type: "POST",
             				url: "/order/applyComm",
             				data: {
             					opId:xxxopid, 
             					content:comm_val,
             					imgs:comm_img,
             					evaluation:comm_item
             				},
             				dataType: "json",
             				success: function(data){
             					if(data.status==1){
             						alert("评论成功!");
             						//取值之后
            						$(ob).parents(".order-pin").css("display", "none")
             					}else if(data.status==-1){
             						window.location.href="/login/toLogin";
             					}else{
             						alert(data.msg);
             					}
             					
                         				
                      		}
         			});
						
						//alert("评价成功")
					}
				}else {
					alert("html页面出现问题");
				}

			}
			/*显示状态*/
			function flow() {
				var flow = 3
				if(flow == "" || flow == 0) {
					$(".step-1").find(".bg").addClass("flow_order2");
					$(".step-2").find(".bg").addClass("flow_order1");
				} else if(flow == 1) {
					$(".step-1").find(".bg").addClass("flow_order2");
					$(".step-2").find(".bg").addClass("flow_order2");
					$(".step-3").find(".bg").addClass("flow_order1");
				} else if(flow == 2) {
					$(".step-1").find(".bg").addClass("flow_order2");
					$(".step-2").find(".bg").addClass("flow_order2");
					$(".step-3").find(".bg").addClass("flow_order2");
					$(".step-4").find(".bg").addClass("flow_order1");
				} else if(flow == 3 || flow == 5) {
					$(".step-1").find(".bg").addClass("flow_order2");
					$(".step-2").find(".bg").addClass("flow_order2");
					$(".step-3").find(".bg").addClass("flow_order2");
					$(".step-4").find(".bg").addClass("flow_order2");
					$(".step-5").find(".bg").addClass("flow_order2");
				} else if(flow == 6) {
					$(".step-1").find(".bg").addClass("flow_order2");
					$(".step-6").find(".bg").addClass("flow_order1");
					$(".after_sale_hide").show()
				}
			}
			/*添加图片*/
			function upimg(obj) {
				//var imgFile = obj.files[0];
				//var img = new Image();
				//var fr = new FileReader();
				var xxpid = $(obj).parents(".order-pin").find("#XXXXOPID").val();
				//alert(xxpid);
				var options = {
						//url : "/upload/uploadFck.do",
						url : "/upload/uploadPic1.do",
						dataType : "json",
						type : "post",
						success : function(data) {
							//alert(2);
							//返回的数据通过下方控件的id给他们设置值,src需要通过attr属性去设置，val可以直接设置
							//原数据存在图片时，重新上传替换URL需对此两个地方进行回显设置
							//$("#img").attr("src", data.url);
							//$("#imgUrl").val(data.url);
							var htmlStr = '<div class="filePic"><input type="file" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" onchange="upimg(this)" class="fileimg_f" onmouseout="normalimg1(this)" onmouseover="normalimg2(this)"/><img src="' + data.url + '" alt="" class="fileimg_imgs"/><img src="../images/ca1.png" class="fileimg_del" onclick="fileimg_del(this)" onmouseout="normalimg1(this)" onmouseover="normalimg2(this)"/></div>'
							if($(obj).parents('.imgOnloadWrap').find(".filePic").length <= 4) {
								$(obj).parents('.imgOnloadWrap').append(htmlStr);
								$(obj).parents('.item-comment').find(".fileimg_num").text($(obj).parents('.imgOnloadWrap').find(".filePic").length - 1)
							} else if($(obj).parents('.imgOnloadWrap').find(".filePic").length == 5) {
								$(obj).parents('.imgOnloadWrap').find(".filePic").eq(0).hide()
								$(obj).parents('.imgOnloadWrap').append(htmlStr);
								$(obj).parents('.item-comment').find(".fileimg_num").text($(obj).parents('.imgOnloadWrap').find(".filePic").length - 1)
							} else {
								alert("最多只能传五张图片")
							}
							obj.value = '';
						}
					}
					//ajax模拟jvForm这个form的提交
					$("#jvForm"+xxpid).ajaxSubmit(options);
			}
			
			/*图片删除*/
			function fileimg_del(ob) {
				$(ob).parents('.item-comment').find(".fileimg_num").text($(ob).parents('.imgOnloadWrap').find(".filePic").length - 2)
				$(ob).parents('.item-comment').find(".filePic").eq(0).show()
				$(ob).parents(".filePic").remove();
			}
			/*移入移出*/
			//移出
			function normalimg1(ob){
				$(ob).parent(".filePic").find(".fileimg_del").hide()
			}
			//移入
			function normalimg2(ob){
				$(ob).parent(".filePic").find(".fileimg_del").show()
			}
			/*提交评论*/
			function sub_comment(ob){
				
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
		<header>
			<article>
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
								<li>
									<a href="/"><img src="../images/logobig.png" /></a>
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
			</article>
		</header>
		<div class="nav-table">
			<div class="long-title"><span class="all-goods">全部分类</span></div>
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
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">商品评价</strong> / <small>Order&nbsp;details</small></div>
						</div>
						<hr/>
						<!--进度条-->
						<div class="m-progress">
							<div class="m-progress-list">
								<span class="step-1 step">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">1<em class="bg "></em></i>
                                   <p class="stage-name">拍下商品</p>
                                </span>
								<span class="step-2 step">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">2<em class="bg "></em></i>
                                   <p class="stage-name">已付款</p>
                                </span>
								<span class="step-3 step">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">3<em class="bg"></em></i>
                                   <p class="stage-name">卖家发货</p>
                                </span>
								<span class="step-4 step">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">4<em class="bg"></em></i>
                                   <p class="stage-name" >确认收货</p>
                                </span>
								<span class="step-5 step">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">5<em class="bg"></em></i>
                                   <p class="stage-name">交易完成</p>
                                </span>
								<span class="u-progress-placeholder"></span>
							</div>
							<div class="u-progress-bar total-steps-2">
								<div class="u-progress-bar-inner"></div>
							</div>
							<div class="after_sale_hide">
								<div class="after_sale">
									<div class=""></div>
								</div>
								<span class="step-6 step">
	                                <em class="u-progress-stage-bg"></em>
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

								<!--交易成功-->
								<div class="order-status5 order-del">
									<div class="comm_total_head">
										<span>订单编号：<span>${order.orderNum}</span></span>
										<span>成交时间：<span><date:date value="${order.addtime}"/></span></span>
									</div>
									<c:forEach items="${order.orderProducts}" var="op">
									<c:if test="${!op.isOnline}">
									<form id="jvForm${op.id}">
									<table class="order_table">
										<tbody>
											<tr>
												<td class="order_tab1">
													<img src="${op.sku.product.pic}" onerror="javascript:this.src='<%=request.getContextPath()%>/images/kong.jpg'"/>
												</td>
												<td class="order_tab2">
													<div class="order_tab2_t">
														<p>${op.sku.product.name}</p>
														<p>规格：${op.sku.spec}</p>
													</div>
												</td>
												<td class="order_tab3">
													<div>￥<span>${op.sku.price}</span></div>
												</td>
												<td class="order_tab4">
													<div><span>${op.num}</span></div>
												</td>
												<td class="order_tab5">
													<div>
														<c:choose>
																	<c:when test="${od.reNum >0}"><a href="/order/toChange">查看售后进度</a></c:when>
																	<c:when test="${order.orderStatus==1 or order.orderStatus==2}"><a href="/order/toRefund?opId=${od.id}">退货/退款</a></c:when>
																	</c:choose>
													</div>
												</td>
												<td class="order_tab6 order_tab_hide">
													<div>￥<span>${op.sku.price * op.num}</span></div>
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
												</td>
											</tr>
											<tr class="order-pin">
											<input type="hidden" id="XXXXOPID" value="${op.id}"/>
												<td colspan="8">
													<div class="item-comment"><textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea></div>
													<div class="item-comment">
														<p>晒照片(<label class="fileimg_num">0</label>/5)</p>
														<div class="imgOnloadWrap">
															<div class="filePic">
																<input type="file" name="pic" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" onchange="upimg(this)" class="fileimg_f" />
																<img src="../images/image.jpg" />
																<img src="../images/ca1.png" class="fileimg_del" onclick="fileimg_del(this)" />
															</div>
														</div>
														
														<div class="item-opinion">
															<li><i class="op1" name="1" onclick="op1(this)" >好评</i></li>
															<li><i class="op2" onclick="op2(this)" >中评</i></li>
															<li><i class="op3" onclick="op3(this)" >差评</i></li>
														</div>
													</div>
													<div class="sub_comment">
														<input type="button" name="" id="" value="提交评论" onclick="assess(this)"/>
													</div>
												</td>
											</tr>
											
										</tbody>
									</table>
									</form>
									</c:if>
									</c:forEach>
									
								</div>
							</div>
						</div>
					</div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">杭州临武医药科技有限公司</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于临武医药</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
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