$(document).ready(function() {

	// 给ul赋予值
	for (i = 0; i <= $(".body").find("ul").length; i++) {
		$(".body").find("ul").eq(i).attr("name", i)
	}
	//
	// 给li赋予值
	oli()
	// 判断是否选中
	$(".choice").change(function() {
		if ($(this).is(':checked')) {
			$(this).attr("checked", true)
		} else {
			$(this).attr("checked", false)
		}
		aggregate()
	})
	aggregate()
	xiaoji()
	//shop_kong()
})
// 小计
function xiaoji() {
	$(".subtotal").each(function() {
		var num1 = $(this).parents("tbody").find(".univalent").text()
		var num2 = $(this).parents("tbody").find(".val").val()
		$(this).text((num1 * num2).toFixed(2))
	})
}
// 判断是否产商下全选
function box(ob) {
	for (j = 0; j <= $(".body").find("ul").index(); j++) {
		var pp = 0
		for (i = 1; i <= $("ul[name='" + j + "']").find("li").index(); i++) {
			var o = $("ul[name='" + j + "']").find("li[name='" + i + "']")
			if (o.find(".choice").is(':checked')) {
				pp++
				o.attr("uname", "22")
			} else {
				o.attr("uname", "11")
			}
		}
		if (pp == $("ul[name='" + j + "']").find("li").index()) {
			$(".body").find("ul[name='" + j + "']").find(".factory_choice")
					.attr("checked", "true");
		} else {
			$(".body").find("ul[name='" + j + "']").find(".factory_choice")
					.removeAttr("checked");
		}
	}
	big_box()
}
// 全选
function big_box() {
	var aa = 0
	for (j = 0; j <= $(".body").find(".shop_list").length; j++) {
		var che = $(".shop_list").eq(j).find("li").eq(0)
				.find(".factory_choice").attr("checked")
		if (che == "checked") {
			aa++
		}
	}
	if (aa == $(".body").find(".shop_list").length) {
		$(".whole_choice").attr("checked", true)
	} else {
		$(".whole_choice").attr("checked", false)
	}
}

// 登录弹窗消失
function shop_sign() {
	$(".sign_box").remove()
}
// 是否跳转
var arr = new Array()
//提交
function zero_j() {
	if ($("[name='ids'][checked]").size()==0) {
		alert('请勾选需要结算的商品')
	} else {
		var myArray = new Array()
		$("[name='ids'][checked]").each(function() {
			myArray.push($(this).val());
		})

		window.location.href="/cart/cartMid?ids="+myArray+"&returnUrl"+encodeURIComponent(window.location.href);
	}
}
// 判断全选中商品数量/金额
function anum() {
	$("#shop_head_text_num").text(
			$(".shop_list").find("li").length - $(".shop_list").length)
	$("#shop_head_text_set").text($("#aggregate").text())
}
// 判断是否有价格
function zero() {
	anum()
	if ($("#aggregate").text() == 0.00) {
		$("#settle").css("background-color", "#B0B0B0").attr('disabled', true);
	} else {
		$("#settle").css("background-color", "#0b74df").attr('disabled', false);
	}
	// 判断商品数量
	// 如果没有商品
	shop_kong()
}
// 给li重新计数
function oli() {

	var myarray = new Array()
	for (j = 0; j <= $(".body").find("ul").index(); j++) {
		for (i = 0; i <= $("ul[name='" + j + "']").find("li").index(); i++) {
			$("ul[name='" + j + "']").find("li").eq(i).attr("name", i)
			$("ul[name='" + j + "']").find("li").eq(i).attr("uname", "11")
		}
	}

}
// 判断是否还存在厂商
function exist() {
	var nu = $(".body").find("ul").length
	for (i = 0; i < nu; i++) {
		if ($(".body").find("ul").eq(i).children().length <= 1) {
			$(".body").find("ul").eq(i).attr("uname", "4")
		}
	}
	$(".shop_list[uname='4']").remove()

}
// 总计
function aggregate() {
	var aa = new Array()
	var aa_and = 0
	for (j = 0; j <= $(".body").find("ul").index(); j++) {
		for (i = 0; i <= $("body").find("li").index() * 2; i++) {
			aa[i] = $("ul[name='" + j + "']").find("li[name='" + i + "']")
					.find(".subtotal").text()
			if (aa[i] != ""
					&& $("ul[name='" + j + "']").find("li[name='" + i + "']")
							.find(".choice").attr("checked")) {
				aa_and = aa_and + Number(aa[i])
			}
		}
	}

	$("#aggregate").text(aa_and.toFixed(2))
	zero()
}
// 加减
function omin(va, ob) {

	num = $(ob).parents("li").attr("name")
	numl = $(ob).parents("ul").attr("name")
	var Oval = $("ul[name='" + numl + "']").find("li[name='" + num + "']")
			.find("input[type='text']")
	var skuId = $(ob).parents("li").find("#skuIdd").val();
	var amount = parseInt($(ob).parents("li").find("#val").val()) + 1;
	var amount1 = parseInt($(ob).parents("li").find("#val").val()) - 1;
	if (va == 0) {
		if (Oval.val() > 1) {
			$.ajax({
				url : "/cart/modifyAmount", // 请求的url地址
				dataType : "json", // 返回格式为json
				async : true, // 请求是否异步，默认为异步，这也是ajax重要特性
				data : {
					"skuId" : skuId,
					"amount" : amount1,
					"returnUrl" : encodeURIComponent(window.location.href)
				}, // 参数值
				type : "POST", // 请求方式
				timeout : 5000,
				success : function(data) {
					if (data.status == 101) {
						alert(data.msg)
						window.location.href = data.domain
								+ "/login/tiLogin?returnUrl=" + data.returnUrl;
					} else if (data.status == 102) {
						alert(data.msg);
					} else {
						if (Oval.val() > 1) {
							Oval.val(parseInt(Oval.val()) - 1)
						}
						xj(ob)
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("请求超时，请保证网络畅通并重试!");
					/*
					 * alert(XMLHttpRequest.status);
					 * alert(XMLHttpRequest.readyState); alert(textStatus);
					 */
				},
			});
		}
	} else if (va == 1) {
		$.ajax({
			url : "/cart/modifyAmount", // 请求的url地址
			dataType : "json", // 返回格式为json
			async : true, // 请求是否异步，默认为异步，这也是ajax重要特性
			data : {
				"skuId" : skuId,
				"amount" : amount,
				"returnUrl" : encodeURIComponent(window.location.href)
			}, // 参数值
			type : "POST", // 请求方式
			timeout : 5000,
			success : function(data) {
				if (data.status == 101) {
					window.location.href = data.domain
							+ "/login/tiLogin?returnUrl=" + data.returnUrl;
				} else if (data.status == 102) {
					alert(data.msg);
				} else {
					Oval.val(parseInt(Oval.val()) + 1);
					xj(ob)
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("请求超时，请保证网络畅通并重试!");
				/*
				 * alert(XMLHttpRequest.status);
				 * alert(XMLHttpRequest.readyState); alert(textStatus);
				 */
			},
		});

	}

}
// 同步小计
function xj(ob) {
	num = $(ob).parents("li").attr("name")
	numl = $(ob).parents("ul").attr("name")
	var Oval = $("ul[name='" + numl + "']").find("li[name='" + num + "']")
			.find("input[type='text']")
	// 小计
	var Osubtotal = $("ul[name='" + numl + "']").find("li[name='" + num + "']")
			.find(".univalent").text()
	var Osubtotal_text = (Osubtotal * Oval.val()).toFixed(2)
	$("ul[name='" + numl + "']").find("li[name='" + num + "']").find(
			".subtotal").text(Osubtotal_text)
	//
	aggregate()
	// exist()
}
// 单商品删除
function del(ob) {
	// num = $(ob).parents("li").attr("name")
	// numl = $(ob).parents("ul").attr("name")
	// $("ul[name='" + numl + "']").find("li[name='" + num + "']").remove()
	var skuIds = $(ob).parents("li").find("#skuIdd").val();
	window.location.href = "/cart/delByIds?skuIds=" + skuIds;
	aggregate()
	oli()
}
// 删除提示
function rec(ob) {
	var mymessage = confirm("确认删除？");
	if (mymessage == true) {
		del(ob)
	}
	exist()
}
// 厂商选择
function factory(ob) {
	if ($(ob).is(':checked')) {
		$(ob).parents("ul").find(".choice").attr({
			"checked" : "checked",
			"uname" : "1"
		});

	} else {
		$(ob).parents("ul").find(".choice").removeAttr("checked");
		$(ob).parents("ul").find(".choice").attr("uname", "0");
	}
	;
	aggregate()
	box(ob)
}
// 全选
function whole(ob) {
	if ($(ob).is(':checked')) {
		$(".choice").attr({
			"checked" : "true",
			"uname" : "1"
		});
		$(".shop_list li").attr("uname", "22")
		$(".shop_list li:first-child").attr("uname", "11") // 22选中
	} else {
		$(".choice").removeAttr("checked");
		$(".choice").attr("uname", "0");
		$(".shop_list li").attr("uname", "11")
		$(".shop_list li:first-child").attr("uname", "11") // 11未选中
	}
	;
	aggregate()
};
// 选中删除
function whole_del() {
	var myArray = new Array()
	$("[name='ids'][checked]").each(function() {
		myArray.push($(this).val());
	})
	//alert(myArray);
	window.location.href="/cart/delByIds?skuIds=" + myArray;
	// 重新计算
	oli()
	// 判断产商
	exist()
	// 计价
	aggregate()
	// 如果没有商品
	shop_kong()
}
// 跳转
function Jump(hre) {
	location.href = hre;
}

// 超出字隐藏
window.onload = function() {
	// 多余的字显示...
	// 可以重复使用
	var num = $('.limit_text').size()
	for (var i = 0; i < num; i++) {
		var titleStr = $(".limit_text").eq(i).text();
		var maxLen = 20; // 设置要显示的字符数
		if (titleStr.length > maxLen) {
			$(".limit_text").eq(i).html(titleStr.substring(0, maxLen) + "...");
		} else {
			$(".limit_text").eq(i).html(titleStr);
		}
	}
}

// 购物车为空
function shop_kong() {
	if ($(".shop_list").length < 1) {
		$(".shop_list_box").css("display", "none")
		$(".shop_list_kong").css("display", "block")
		var clock = '';
		var nums = 5;
		clock = setInterval(function() {
			nums--;
			if (nums > 0) {
				$("#sec").text(nums)
			} else {
				clearInterval(clock); // 清除js定时器
				window.location.href = 'home.html'
			}
		}, 1000)
	} else if ($(".shop_list").length >= 1) {
		$(".shop_list_kong").css("display", "none")

	}
}
// cookie
// 手动修改数量
var newnum = ""
function modify_num1(ob) {
	newnum = $(ob).val()
}
function modify_num2(ob) {
	var skuId = $(ob).parents("li").find("#skuIdd").val();
	if ($(ob).val() <= 0) {
		$(ob).val(newnum)
	} else {
		var amount = $(ob).val();
		$.ajax({
			url : "/cart/modifyAmount", // 请求的url地址
			dataType : "json", // 返回格式为json
			async : true, // 请求是否异步，默认为异步，这也是ajax重要特性
			data : {
				"skuId" : skuId,
				"amount" : amount,
				"returnUrl" : encodeURIComponent(window.location.href)
			}, // 参数值
			type : "POST", // 请求方式
			timeout : 5000,
			success : function(data) {
				if (data.status == 101) {
					window.location.href = data.domain
							+ "/login/tiLogin?returnUrl=" + data.returnUrl;
				} else if (data.status == 102) {
					alert(data.msg);
				} else {
					alert(data.msg);
					$(ob).val(amount);
					xj(ob)
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("请求超时，请保证网络畅通并重试!");
				/*
				 * alert(XMLHttpRequest.status);
				 * alert(XMLHttpRequest.readyState); alert(textStatus);
				 */
			},
		});

	}
}

if(window.name !="bencalie"){
	location.reload();
	window.name ="bencalie";
}else{
	 window.name ="";
}