//评价商品
function assess(ob) {
	var ma = $(ob).parents(".order-status5")
	if ($(ob).find("span").text() == "评价商品") {
		$(ob).find("span").text("提交评价")
		$(ob).parents(".order-status5").find(".order-pin").css("display",
				"table-footer-group")
	} else if ($(ob).find("span").text() == "提交评价") {
		if (ma.find("textarea").val().length < 6) {
			alert("评价至少为六个字")
		} else {
			$(ob).find("span").text("已经评论")
			alert("成功提交评论")
			$(ob).parents(".order-status5").find(".order-pin").css("display",
					"none")
		}
	} else if ($(ob).find("span").text() == "已经评论") {
	} else {
		alert("html页面出现问题")
	}

}
// 删除商品
function order_cancel(ob, oid) {
	var mymessage = confirm("确认删除订单？");
	if (mymessage == true) {
		window.location.href = "/order/delOrder?oid=" + oid;
	}
}
// 品级
function op1(ob) {
	op0(ob)
	$(ob).css("background-image", "url(../images/iconfont-good.png)")
	$(ob).attr("name", "1")
}

function op2(ob) {
	op0(ob)
	$(ob).css("background-image", "url(../images/iconfont-middle.png)")
	$(ob).attr("name", "1")
}

function op3(ob) {
	op0(ob)
	$(ob).css("background-image", "url(../images/iconfont-badon.png)")
	$(ob).attr("name", "1")
}

function op0(ob) {
	$(ob).parents(".item-opinion").find(".op1").css("background-image",
			"url(../images/iconfont-evaluate.png)").attr("name", "0")
	$(ob).parents(".item-opinion").find(".op2").css("background-image",
			"url(../images/iconfont-evaluate.png)").attr("name", "0")
	$(ob).parents(".item-opinion").find(".op3").css("background-image",
			"url(../images/iconfont-bad.png)").attr("name", "0")

}
// 提醒发货
function delivery(ob) {
	if ($(ob).text() == "提醒发货") {
		$(ob).text("已经提醒")
	} else {
		alert("一天只能提醒一次")
	}
}
// 确认收货
function recipient(ob, oid) {
	//alert($(ob).attr("name"));
	if ($(ob).attr("name") == 100) {
		var mymessage = confirm("确认收货？");
		if (mymessage == true) {
			window.location.href = "/order/Confirm?oid=" + oid;
		}
	}
}
// 一键支付
function pay() {
	window.location.href = '../other/pay.html'
}
/**/
var j = 0
var val_l = "" // 5交易成功 ； 0交易失败 ； 1待支付 ； 2待发货 ；3待收货 ；4待评论
var val_z = null
var listhtml = ""
var strhtml = ""
var listhtml2 = ""

var pinhtml = '<tfoot class="order-pin"><tr><td colspan="8"><div class="item-comment"><textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea></div><div class="item-comment"><div class="filePic"><input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"><p>晒照片(0/5)</p><img src="../images/image.jpg"></div><div class="item-opinion"><li><i class="op1" onclick="op1(this)">好评</i></li><li><i class="op2" onclick="op2(this)">中评</i></li><li><i class="op3" onclick="op3(this)">差评</i></li></div></div></td></tr></tfoot>'
var state1 = "交易成功"
var state2 = "order-status5 order-del"

var state3 = "1916308509171539" // 订单编号
var state4 = "2016-05-19" // 订单时间
var state5 = "../images/kouhong.jpg_80x80.jpg" // 商品图片
var state6 = "美康粉黛醉美唇膏 持久保湿滋润防水不掉色"
var state7 = "颜色" // 规格1名字
var state8 = "红色" // 规格1内容
var state9 = "包装" // 规格2名字
var state10 = "裸妆" // 规格2内容
var state11 = "253.00" // 单价
var state12 = "2" // 数量
var state13 = "退款/退货"
var state14 = "506.00" // 总价
var state15 = "交易成功"
var state16 = "订单详情"
var state16_h = ""
var state17 = "查看物流"
var state17_h = ""
var state18 = "删除订单"
var state18_h = ""
var state19 = ""
// 添加商品列表
function add2() {
	listhtml = '<tr><td class="order_tab1"><img src="'
			+ state5[i][j]
			+ '"/></td><td class="order_tab2"><div class="order_tab2_t"><p>'
			+ state6[i][j]
			+ '</p><p><span>'
			+ state7
			+ '</span>：<span>'
			+ state8[i][j]
			+ '</span></p><p><span>'
			+ state9
			+ '</span>：<span>'
			+ state10
			+ '</span></p></div></td><td class="order_tab3"><div >￥<span>'
			+ state11[i][j]
			+ '</span></div></td><td class="order_tab4"><div ><span>'
			+ state12[i][j]
			+ '</span></div></td><td class="order_tab5"><div ><a href="refund.html">'
			+ state13
			+ '</a></div></td><td class="order_tab6" ><div >￥<span class="summation">'
			+ state14 + '</span></div></td><td class="order_tab7" ><div ><p>'
			+ state15 + '</p> <a href="orderinfo.html">' + state16 + '</a> <a '
			+ state16_h + '>' + state17
			+ '</a></div></td><td class="order_tab8" ><div ' + state17_h
			+ '><span>' + state18 + '</span></div></td></tr>'

}
function add() {

	strhtml = '<!--'
			+ state1
			+ '--><div class="'
			+ state2
			+ '"><table class="order_table"><thead><tr><td colspan="2">订单编号：<span>'
			+ state3[i][j] + '</span></td><td colspan="6">成交时间：<span>'
			+ state4[i][j] + '</span></td></tr></thead><tbody>' + state18_h
			+ '</tbody>' + state19 + '</table></div>'

}
// 判断订单类型
function list(nu) {
	val = nu
	if (val == 5) {
		state1 = "交易成功";
		state2 = "order-status5 order-del";
		state13 = "退款/退货"
		state15 = "交易成功"
		state16 = "订单详情"
		state16_h = "href='logistics.html'"
		state17 = "查看物流"
		state17_h = "onclick='order_cancel(this)'"
		state18 = "删除订单"
		state19 = ""
	}
	if (val == 4) {
		state1 = "评价商品";
		state2 = "order-status4 ";
		state13 = "退款/退货"
		state15 = "交易成功"
		state16 = "订单详情"
		state16_h = "href='logistics.html'"
		state17 = "查看物流"
		state17_h = "onclick='assess(this)'"
		state18 = "评价商品"
		state19 = pinhtml
	}
	if (val == 3) {
		state1 = "待收货";
		state2 = "order-status3 ";
		state13 = "退款/退货"
		state15 = "卖家已发货"
		state16 = "订单详情"
		state16_h = "href='logistics.html'"
		state17 = "查看物流"
		state17_h = "onclick='recipient(this)'"
		state18 = "确认收货"
		state19 = ""
	}
	if (val == 2) {
		state1 = "待发货";
		state2 = "order-status2 ";
		state13 = "退款"
		state15 = "买家已付款"
		state16 = "订单详情"
		state16_h = "href='logistics.html'"
		state17 = ""
		state17_h = "onclick='delivery(this)'"
		state18 = "提醒发货"
		state19 = ""
	}
	if (val == 1) {
		state1 = "待付款";
		state2 = "order-status1 order-del";
		state13 = ""
		state15 = "等待买家付款"
		state16 = ""
		state16_h = "href='#' onclick='order_cancel(this)'"
		state17 = "取消订单"
		state17_h = "onclick='pay()'"
		state18 = "一键支付"
		state19 = ""
	}
	if (val == 0) {
		state1 = "交易失败";
		state2 = "order-status0 order-del";
		state13 = ""
		state15 = "交易关闭"
		state16 = ""
		state16_h = "href='logistics.html'"
		state17 = ""
		state17_h = "onclick='order_cancel(this)'"
		state18 = "删除订单"
		state19 = ""
	}
}
window.onload = function() {

	// 添加
	var html = ""
	var leng1 = 2 // 几个总商品
	var leng2 = 2 // 每个总商品有几个次商品
	for (i = 0; i < leng1; i++) {
		add()
		state18_h = ""
		for (j = 0; j < leng2; j++) {
			val_z = 1
			// 选择订单类型

			list(val_l[i][j])
			// 添加订单
			add2()

			// 每个小单记录
			state18_h += listhtml
			// 计入总订单
			add()
		}

		html += strhtml
	}
	$(".order-list").append(html)

	// 计算合计
	var summation = 0
	$(".summation").each(
			function() {
				var mo = $(this).parents(".order_table tbody").find("tr")
				for (i = 0; i < mo.length; i++) {
					summation = mo.eq(i).find(".order_tab3 span").text()
							* mo.eq(i).find(".order_tab4 span").text()
				}
				$(this).text(parseFloat(summation).toFixed(2))
			})
}