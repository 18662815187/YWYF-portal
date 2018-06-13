window.onload = function() {
	//订单数量
	len()
}
//选择支付
function pay(ob) {
	var price = $("#payment_price").text();
	var mon = '<div class="money">支付<b >' + price + '</b>元</div>';
	$(".money").remove();
	$(".payment").removeClass('payment_w');
	$(ob).addClass('payment_w');
	$(ob).find('input[type="radio"]').attr("checked", "true");
	$(ob).append(mon);
}
//订单详情
function details() {
	if($("#table_1").is(":hidden")) {
		$("#table_1").show()
		$(".details_sdf").attr("src","../images/la.png")
	} else {
		$("#table_1").hide()
		$(".details_sdf").attr("src","../images/qu.png")
	}
}
//订单数量
function len() {
	var len = $("#table_1 tbody tr").length
	$(".payment_len").text(len)
}