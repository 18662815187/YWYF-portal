<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人账单</title>
		<script src="../js/jquery-1.8.3.min.js"></script>
		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/blstyle.css" rel="stylesheet" type="text/css">
		<script src="../js/jquery.min.js"></script>
		<link href="../css/search_list.css" rel="stylesheet" type="text/css" />
		<script src="../js/search_list.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				var mydate = new Date();
				$(".month").text(mydate.getMonth() + 1)
				$(".nian").text(mydate.getFullYear())
				//支出总费用
				money()
			})
			function money(){
				var money = 0
				for(i=0;i<$(".delete-false").length;i++){
					 money += parseFloat($(".delete-false").eq(i).find(".fn-right").text())
				}
				$("#expenditure").text(money.toFixed(2))
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
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<span>欢迎来到生医容美大药房！</span>
						<a href="../other/login.html" target="_top" class="h">亲，请登录</a>
						<a href="../other/register.html" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="index.html" target="_top">个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="../other/shopcart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="person/collection.html" target="_top"><i class="am-icon-user am-icon-fw"></i><span>客服中心</span></a>
					</div>
				</div>
			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="nav white">
			<div class="logoBig">
				<li>
					<a href="../home.html"><img src="../images/logobig.png" /></a>
				</li>
			</div>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form>
					<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off" oninput="search_list()">
					<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="button" onclick="location.href='../other/search.html';">
				</form>
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

					<div class="user-bill">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">账单</strong> / <small>Electronic&nbsp;bill</small></div>
						</div>
						<hr/>

						<div class="ebill-section">
							<div class="ebill-title-section">
								<h2 class="trade-title section-title">
                                                                                                                                     交易
                            <span class="desc">（金额单位：元）</span>
                        </h2>

								<div class=" ng-scope">
									<div class="trade-circle-select  slidedown-">
										<a href="javascript:void(0);" class="current-circle ng-binding"><span class="nian">2015</span>/<span class="month">11</span>/01 - <span class="nian">2015</span>/<span class="month">11</span>/30</a>

									</div>
									<span class="title-tag"><i class="num ng-binding month" >12</i>月</span>
								</div>
							</div>

							<div class="module-income ng-scope">
								<div class="income-slider ">
									<div class="block-income block  fn-left">
										<h3 class="income-title block-title">
                                        		 支出
                                      	<span class="num ng-binding" id="expenditure">
                                              119.80
                                      	 </span>
                                    <span class="desc ng-binding">
                                         </span>
                                             </h3>

										<div ng-class="shoppingChart" class="catatory-details  fn-hide shopping">
											<div class="catatory-detail fn-left">
												<div class="title ng-binding bili_price_l">
													购买商品
												</div>
												<div class="bili_price_r">
													价格
												</div>
												<ul class="bili_list_box">

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="呢子大衣">
																<span class="emoji-span ng-binding">呢子大衣</span>
																<span class="amount fn-right ng-binding">349.00</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="金士顿羊年限量版16gU盘">
																<span class="emoji-span ng-binding">金士顿羊年限量版16gU盘</span>
																<span class="amount fn-right ng-binding">39.00</span>
															</a>
														</div>
													</li>
													<li class="ng-scope  delete-false">

														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="呢子大衣">
																<span class="emoji-span ng-binding">呢子大衣</span>
																<span class="amount fn-right ng-binding">349.00</span>
															</a>
														</div>
													</li>
													<li class="ng-scope  delete-false">

														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="金士顿羊年限量版16gU盘">
																<span class="emoji-span ng-binding">金士顿羊年限量版16gU盘</span>
																<span class="amount fn-right ng-binding">39.00</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="呢子大衣">
																<span class="emoji-span ng-binding">呢子大衣</span>
																<span class="amount fn-right ng-binding">349.00</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="羊毛毡底鞋垫">
																<span class="emoji-span ng-binding">羊毛毡底鞋垫</span>
																<span class="amount fn-right ng-binding">9.90</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="羊毛毡底鞋垫">
																<span class="emoji-span ng-binding">羊毛毡底鞋垫</span>
																<span class="amount fn-right ng-binding">9.90</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="羊毛毡底鞋垫">
																<span class="emoji-span ng-binding">羊毛毡底鞋垫</span>
																<span class="amount fn-right ng-binding">9.90</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="羊毛毡底鞋垫">
																<span class="emoji-span ng-binding">羊毛毡底鞋垫</span>
																<span class="amount fn-right ng-binding">9.90</span>
															</a>
														</div>
													</li>

													<li class="ng-scope  delete-false">
														<div class="  ng-scope">
															<a href="#" class="text fn-left " title="羊毛毡底鞋垫">
																<span class="emoji-span ng-binding">羊毛毡底鞋垫</span>
																<span class="amount fn-right ng-binding">239.90</span>
															</a>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="block-expense block  fn-left">
										<div class="slide-button right"></div>
									</div>
									<div class="clear"></div>

									<!--收入-->
									<h3 class="expense income-title block-title">
                                    <span class="desc ng-binding">
                                           <a href="billlist.html" class="blue_a">查看收入明细</a>
                                    </span>
                                </h3>
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
					<li class="person">
						<a href="index.html">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
							<li>
								<a href="information.html">个人信息</a>
							</li>
							<li>
								<a href="safety.html">安全设置</a>
							</li>
							<li>
								<a href="address.html">收货地址</a>
							</li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li>
								<a href="order.html">订单管理</a>
							</li>
							<li>
								<a href="change.html">退款售后</a>
							</li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的小窝</a>
						<ul>
							<li class="active">
								<a href="bill.html">账单明细</a>
							</li>
							<li>
								<a href="collection.html">收藏</a>
							</li>
							<li>
								<a href="comment.html">评价</a>
							</li>
							<li>
								<a href="news.html">消息</a>
							</li>
						</ul>
					</li>
				</ul>
			</aside>
		</div>

	</body>

</html>