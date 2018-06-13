//商品排列方式点击
function classify_opt(ob) {
	$(ob).parents(".sort").find("li").removeClass("first");
	$(ob).addClass("first");
}
// 弹出购物车
function shop() {
	if ($(".pop").attr("name") == 1) {
		$(".pop").animate({
			left : "-320px"
		});
		$(".pop").attr("name", "0")
	} else if ($(".pop").attr("name") == 0) {
		$(".pop").animate({
			left : "40px"
		});
		$(".pop").attr("name", "1")
	}
	//pop_num()
}
$(document).ready(function() {
	pop_kong()
	//pop_num()
	zhongji()
})
// 全部分类
function list_w(ob) {
	$(ob).find("img").attr("src", "images/cookies.png")
}

function list_b(ob) {
	$(ob).find("img").attr("src", "images/cook1.png")
}
// 触摸显示
function drug_show(ob) {
	$(ob).find(".commodity_table_black").show()
}

function drug_hide(ob) {
	$(ob).find(".commodity_table_black").hide()
}
// 加减
function pop_add(ob) {
	var pop_val = $(ob).parents(".pop_shop_2").find(".pop_shop_num").val()
	$(ob).parents(".pop_shop_2").find(".pop_shop_num").val(
			parseInt(pop_val) + 1)
	xiaoji(ob)
	zhongji()
}

function pop_reduce(ob) {
	var pop_val = $(ob).parents(".pop_shop_2").find(".pop_shop_num").val()
	if (pop_val > 1) {
		$(ob).parents(".pop_shop_2").find(".pop_shop_num").val(
				parseInt(pop_val) - 1)
		xiaoji(ob)
		zhongji()
	}
}
// 小计
function xiaoji(ob) {
	var a1 = parseFloat($(ob).parents(".pop_shop_2").find(".pop_shop_2_num")
			.text())
	var a2 = parseFloat($(ob).parents(".pop_shop_2").find(".pop_shop_num")
			.val())
	$(ob).parents(".pop_shop_2").find(".pop_shop_2_subtotal").text(
			(a1 * a2).toFixed(2))
}
// 总计
function zhongji() {
	if ($(".pop").find("tbody tr").length == 0) {
		var ww = 0.00
		$("#pop_foot_price").text(ww.toFixed(2))
	} else {
		var zh = 0
		for (i = 0; i < $(".pop").find("tbody tr").length; i++) {
			zh += parseFloat($(".pop").find("tbody tr").eq(i).find(
					".pop_shop_2_subtotal").text())
		}
		$("#pop_foot_price").text(zh.toFixed(2))
	}

}
// 购物车删除
function pop_del(ob) {
	var mymessage = confirm("确认删除？");
	if (mymessage == true) {
		$(ob).parents("tr").remove()
	}
	//pop_num()
	zhongji()
	pop_kong()
}
// 判断为空
function pop_kong() {
	var strhtml = '<tr><td><div class="pop_shop_kong"><img src="images/pop_shop.png"/><p>亲，你的购物车为空哦！</p></div></td></tr>'
	var kong = $(".pop").find("tbody tr").length
	if (kong == 0) {
		$(".pop").find("tbody").html(strhtml)
	}

}
// 购物车商品数目与价格
//function pop_num() {
	//var num = $(".pop").find("tbody tr").length
	//$("#pop_foot_num").text(num)
	//$(".cart_num").text(num)

//}
// 浮动搜索
$(window).scroll(function() {
	// 滚动条距离顶部的距离 大于 200px时
	if ($(window).scrollTop() >= 200) {
		$(".float_search_box").fadeIn(1000); // 开始淡入
	} else {
		$(".float_search_box").stop(true, true).fadeOut(1000); // 如果小于等于 200 淡出
	}
});
// 清空价格
function qin() {
	$(".select_list_price input[type='text']").val("")
}
// 判断价格高低交换位置并刷新页面
function prix(keywords, brandId, typeId, funId, disId) {
	var min = $(".select_list_price input[type='text']").eq(0)
	var max = $(".select_list_price input[type='text']").eq(1)
	var result = "";
	if (min.val() >= max.val()) {
		var n = min.val()
		var x = max.val()
		min.val(x);
		max.val(n)
	}
	if (min.val() == 0 && max.val() == 0) {
		result = "";
	} else if (min.val() == null || min.val() == null) {
		result = "";
	} else {
		result = min.val() + "-" + max.val();
	}
	window.location.href = "/product/search?keyword=" + keywords + "&price="
			+ result + "&typeId=" + typeId + "&funId=" + funId + "&disId="
			+ disId;

}


