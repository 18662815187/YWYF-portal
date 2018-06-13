//地址超出三两行就自动隐藏
window.onload = function() {
	address_red()
	// 多余的字显示...
	// 可以重复使用
	var num = $('.address_text').size()
	for (var i = 0; i < num; i++) {
		var titleStr = $(".address_text").eq(i).text();
		var maxLen = 50; // 设置要显示的字符数
		if (titleStr.length > maxLen) {
			$(".address_text").eq(i)
					.html(titleStr.substring(0, maxLen) + "...");
		} else {
			$(".address_text").eq(i).html(titleStr);
		}
	}
	cue();
}
// 加载红框地址
function address_red() {

	$("#name_val").each(function() {
		var aa = $(".logo_add").text()
		var name = $(".defaultAddr").find(".buy-user").text();
		$(this).text(name);
	});
	$("#Oaddress_val").each(function() {
		var address = $(".defaultAddr").find(".buy--address-detail").text();
		$(this).text(address)
	});
	// 产商的小计
	$(".company_total").each(
			function() {
				var aa = 0
				for (i = 0; i < $(this).parents(".order_commodity").find(
						".subtotal").size(); i++) {
					aa += parseFloat($(this).parents(".order_commodity").find(
							".subtotal").eq(i).text());
				}
				$(this).text(aa.toFixed(2));
			});
	// 产商的物品数量
	$(".company_total_num").each(
			function() {
				$(this).text(
						$(this).parents(".order_commodity").find(".subtotal")
								.size());
			});
};
$(document).ready(function() {
	// 计算价格(总计)
	total()
})

$(document).on("click", "#add_address", function() {
	Jump('add_address.html')

});
// //计算价格(总计)
function total() {

	// 计算价格(小计)
	var sum = 0;
	$(".subtotal")
			.each(
					function() {
						var Osubtotal = ($(this).parents(".firm_list").find(
								".univalent").text())
								* ($(this).parents(".firm_list")
										.find(".number").text())
						sum += parseFloat(Osubtotal);
						$(this).text(Osubtotal.toFixed(2))
					})
					//运费
					var total_w =0;
					var total_leng =  $(".total_w").length
					
					for(i=0;i<total_leng;i++){
						total_w += parseFloat($(".total_w").eq(i).text());
					}
					//计算价格(总计)
					$("#total").each(function() {
						$(this).text((sum + total_w - $(".coupon_del").text()).toFixed(2))
						$("#total_two").text((sum + total_w - $(".coupon_del").text()).toFixed(2))
					})

}
// 设置默认地址
function mo_adress(ob) {
	$("#address_ul_box").find("ins").addClass("hidden")
	$(ob).parents(".user-addresslist").find("ins").removeClass("hidden")
	$("#address_ul_box").find(".mo_adress_set ,.new-addr-bar1").removeClass(
			"hidden")
	$(ob).parents(".user-addresslist").find(".mo_adress_set ,.new-addr-bar1")
			.addClass("hidden")
}
// 地址删除
function delClick(ob) {
	var mymessage = confirm("确认删除？");
	var mid =$(ob).parents(".user-addresslist").find("#midd").val();
	window.location.href = "/order/delAddr?mid="+mid+"&returnUrl="+encodeURIComponent(window.location.href);
}

// 添加收货地址提示
var btm = false

function add_cue() {
	if ($("#user-name").val() == "") {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("你的收货人为空")
		btm = false
	} else if ($("#user-phone").val() == "") {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("你的手机号码为空")
		btm = false
	} else if ($("#user-intro").val() == "") {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("你的详细地址为空")
		btm = false
	} else if ($("#user-intro").val().length >= 100) {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("详细地址应该在100字以内")
		btm = false
	} else {
		$("#add_address_cue_img").hide()
		$("#add_address_cue").text("")
		btm = true
	}
}
// 保存地址
function add_address() {
	add_cue()
	if (btm == true) { // 判断是否信息都完全填写
		if ($(".user-addresslist[name='11']").attr("name") == 11) { // 判断是否是新增还是修改
			var buy = $(".user-addresslist[name='11']")
			buy.find(".buy-user").text($("#user-name").val())
			buy.find(".buy-phone").text($("#user-phone").val())
			buy.find(".buy--address-detail").text($("#user-intro").val())
			
			buy.attr("name", "")
			//alert($("#user-name").val());
			$.ajax({
				url : '/order/mailSaveOrUpdate', // 地址
				dataType : "json",
				data : $('#jvForm').serialize(),
				type : "post",
				timeout : 5000,
				success : function(data) {
					if (data.status == 1005) {
						window.location.href = "/login/toLogin?returnUrl="
								+ data.returnUrl;
					} else {
						window.location.top.href = data.returnUrl;
					}
					// 消除val
					$("#user-name").val("")
					$("#user-phone").val("")
					$("#user-intro").val("")
					$("#mail-id").val("")

				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("更新失败!");
				},

			})
		} else {
			if ($("#address_ul_box").find("li").length >= 6) { // 如果收货地址的数量超过6个
				alert("收货地址最多只能添加六个")

			} else {
				$.ajax({
					url : '/order/mailSaveOrUpdate', // 地址
					dataType : "json",
					data : $('#jvForm').serialize(),
					type : "post",
					timeout : 5000,
					success : function(data) {
						if (data.status == 1000) {
							window.location.href = "/order/toPay?skuId="
									+ $("#skkuId").val() + "&amount="
									+ $("#amtt").val() + "&preId="
									+ $("#ppreId").val() + "&type=1";
						} else {
							window.location.top.href = data.returnUrl;
						}

					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("新增失败!");
					},

				})
			}
		}
	}
	address_red()
}
// 取消
function cancel() {
	$(".user-addresslist[name='11']").attr("name", "")
	// 消除val
	$("#user-name").val("")
	$("#user-phone").val("")
	$("#user-intro").val("")
}

// 编辑（修改地址）
function rewrite_address(ob) {
	// 标记li
	$(".user-addresslist").attr("name", "")
	$(ob).parents(".user-addresslist").attr("name", "11")
	// 弹出
	$(document.body).css("overflow", "hidden");

	$(this).addClass("selected");
	$(this).parent().addClass("selected");

	$('.theme-popover-mask').show();
	$('.theme-popover-mask').height($(window).height());
	$('.theme-popover').slideDown(200);
	// 赋值
	$("#user-name").val(
			$(ob).parents(".user-addresslist").find(".buy-user").text())
	$("#user-phone").val(
			$(ob).parents(".user-addresslist").find(".buy-phone").text())
	$("#user-intro").val(
			$(ob).parents(".user-addresslist").find(".buy--address-detail")
					.text())
	$("#mail-id").val($(ob).parents(".user-addresslist").find("#midd").val())
	//alert($("#mail-id").val()+"----")
}

// 使用优惠券
function coupon(ob) {
	// 给予扣除值
	$(".coupon_li_hide").removeClass("coupon_on");
	$(ob).find(".coupon_li_hide").toggleClass("coupon_on");
	// 改变颜色
	var col = $(ob).find(".coupon_li_blue")
	if (col.css("background-color") == "rgb(205, 205, 205)") {
		var aa = 0
		for (i = 0; i < $(".company_total").parents(".order_commodity").find(
				".subtotal").size(); i++) {
			aa += parseFloat($(".company_total").parents(".order_commodity")
					.find(".subtotal").eq(i).text());
		}
		if ($(".coupon_on").find(".coupon_b").text() <= aa) { // 判断总金额是否可用优惠券
			$(".coupon_li_blue").css("background-color", "#cdcdcd")
			col.css("background-color", "#74d2d4")

			$(".coupon_s").removeClass("coupon_del");
			$(ob).find(".coupon_s").toggleClass("coupon_del");
			// 计算余额
			total()

		}

	} else {
		col.css("background-color", "#cdcdcd")
		$(".coupon_s").removeClass("coupon_del");
		// 计算余额
		total()
	}

}

// 隐藏优惠券
function coupon_hide() {
	var dowm = $(".coupon_dowm")
	if (dowm.attr("name") == 1) {
		dowm.css("background-position", "-83px -76px")
		dowm.attr("name", "0")
		$(".coupon_ul_b").css("display", "none")
	} else {
		dowm.css("background-position", "-69px -76px")
		dowm.attr("name", "1")
		$(".coupon_ul_b").css("display", "block")
	}

}
/*无存提示*/
function inventory_cue(){
	$(".inventory_al_cue").fadeIn(1000);
	$(".inventory_al_cue").fadeOut(1000);
}
function cue(){
	$(".inventory_cue").each(function(){
		if($(this).text()==""){
			$(this).hide()
		}
	})
}