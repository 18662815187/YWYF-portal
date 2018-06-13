$(document).ready(
		function() {
			$(".am-pagination-right").each(
					function() {
						var li_max = $(this).find("li").length
						if (li_max > 7) {
							$(".am-pagination-right li").eq(li_max - 2).after(
									"<li name='1'><a>...</a></li>");
						}
						for (i = 6; i <= li_max - 1; i++) {
							$(".am-pagination-right li").eq(i).addClass(
									"hidden");
						}
					})
		})
// 页数点击
function page_number(num, ob) {
	$(".am-pagination-right li[name='1']").remove()
	var li_max = $(ob).parents(".am-pagination-right").find("li").length

	// 颜色改变
	$(ob).parents(".am-pagination-right").find("li").removeClass("am-active");
	$(ob).addClass("am-active");
	// 样式
	if (li_max > 7) {
		if (num < 4) {
			for (i = 1; i <= li_max - 1; i++) {
				$(".am-pagination-right li").eq(i).addClass("hidden");
			}
			for (i = 1; i <= 5; i++) {
				$(".am-pagination-right li").eq(i).removeClass("hidden")
			}
			for (i = li_max - 1; i <= li_max; i++) {
				$(".am-pagination-right li").eq(i).removeClass("hidden")
			}
			$(".am-pagination-right li").eq(li_max - 2).after(
					"<li name='1'><a>...</a></li>");
		} else if (num >= 4 && num <= li_max - 4) {
			for (i = 1; i <= li_max - 2; i++) {
				$(".am-pagination-right li").eq(i).addClass("hidden");
			}
			for (i = num - 2; i <= num + 2; i++) {
				$(".am-pagination-right li").eq(i).removeClass("hidden")
			}
			for (i = li_max - 1; i <= li_max; i++) {
				$(".am-pagination-right li").eq(i).removeClass("hidden")
			}
			$(".am-pagination-right li").eq(1).after(
					"<li name='1'><a>...</a></li>");
			$(".am-pagination-right li").eq(li_max - 1).after(
					"<li name='1'><a>...</a></li>");
		} else if (num > li_max - 4) {
			for (i = 1; i <= li_max - 7; i++) {
				$(".am-pagination-right li").eq(i).addClass("hidden");
			}
			for (i = li_max - 5; i <= li_max; i++) {
				$(".am-pagination-right li").eq(i).removeClass("hidden")
			}
			for (i = li_max - 1; i <= li_max; i++) {
				$(".am-pagination-right li").eq(i).removeClass("hidden")
			}
			$(".am-pagination-right li").eq(1).after(
					"<li name='1'><a>...</a></li>");
		}
	}

}

$(document).ready(function() {
	// 需求登记hover
	hov()
	// 轮播
	lun()
	// 购物车
	pop_kong()
	xiaoji_o()
	//pop_num()
	zhongji()
	// 购物车另加
	pop()
	// 评论
	discuss()

})
window.onload = function() {
	// 图片联系
	diagram()
	midimg()
	bigimg()
	// 第一个为红框
	red_first()
}
// 删除
function del() {
	$(".need_bomb_box").hide()
	$(".black").hide()
	$(".need_bomb").hide()
	$(".need_one").hide()
	$(".need_two").hide()
}
// 需求
function show() {
	$.ajax({
		url : "/login/isLogin.do",
		type : "post",
		dataType : "json",
		success : function(data) {
			// 0、1判断
			// alert(data);
			if (data.status == 1) {
				$(".need_bomb_box").show()
				$(".need_list").show()
				$(".black").show()
				$("#drug_price_1").text($(".sys_item_price").text())
				$("#drug_price_2").text($(".selected").text())
				$("#drug_price_3").text($("#text_box").val())
			} else {
				window.location.href = "/login/toLogin?returnUrl="
						+ encodeURIComponent(window.location.href);
			}
		}
	});

}
// 提示
var btm = false

function add_cue() {
	var need = $(".need_bomb").attr("name")
	if (need == 2) {
		$("#add_address_cue_img").hide()
		$("#add_address_cue").text("")
		btm = true
	} else {
		if ($("#user-name").val() == "") {
			$("#add_address_cue_img").show()
			$("#add_address_cue").text("你的名字为空")
			btm = false
		} else if ($("#user-address").val() == "") {
			$("#add_address_cue_img").show()
			$("#add_address_cue").text("你的地址为空")
			btm = false
		} else if ($("#user-years").val() == "") {
			$("#add_address_cue_img").show()
			$("#add_address_cue").text("你的年龄为空")
			btm = false
		} else if ($("#user-hospital").val() == "") {
			$("#add_address_cue_img").show()
			$("#add_address_cue").text("你的医院为空")
			btm = false
		} else if ($("#user-doctor").val() == "") {
			$("#add_address_cue_img").show()
			$("#add_address_cue").text("你的医生为空")
			btm = false
		} else {
			$("#add_address_cue_img").hide()
			$("#add_address_cue").text("")
			btm = true
		}
	}

}
// 选择第一种
function need_one() {
	$('.need_bomb').show().attr("name", "1");
	$('.need_list').hide();
	$('.need_one').show();

}
// 选择第二种
function need_two() {
	$('.need_bomb').show().attr("name", "2");
	$('.need_list').hide();
	$('.need_two').show()
}
// 提交
function add_button() {
	add_cue()
	if (btm == true) { // 判断是否信息都完全填写
		$.ajax({
			url : '/user/preApply', //地址
			dataType : "json",
			data : $('#jvForm').serialize(),
			type : "post",
			timeout : 50000,
			success : function(data) {
				if(data.status==10000){
					$("#preId").val(data.preId);
					$(".need_bomb_box").hide()
					$(".black").hide()
					$(".need_bomb").hide()
					$(".need_one").hide()
					$(".need_two").hide()
					$("#prescription_yes").hide()
				}else if(data.status==10002){
					window.location.href="/login/toLogin?returnUrl="+encodeURIComponent(window.location.href);
				}else{
					$("#add_address_cue_img").show()
					$("#add_address_cue").text("提交失败,请重试!")
				}
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				/*alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);*/
				alert("网络请求失败，请检查输入的内容是否有误，比如年龄必须是数字，或者联系网站管理员!");
			},

		})
		
	}
}
// 优惠券
function gold(ob) {
	$(ob).css("background-image", "url(images/couponli2.png)")
	$(ob).text("已领取")
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

function xiaoji_o() {
	$(".pop_shop_2_subtotal").each(function() {
		var al = $(this).parents(".pop_shop_2").find(".pop_shop_2_num").text()
		$(this).text(al)
	})
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
//}
// 弹出购物车
function shop() {
	if ($(".pop").attr("name") == 1) {
		window.parent.$(".iframe_tip").css("width", "340px")
		$(".pop").animate({
			left : "35px"
		});
		setTimeout('$(".pop").attr("name", "0")', 300)
	} else if ($(".pop").attr("name") == 0) {
		/*
		 * setTimeout('window.parent.$(".iframe_tip").css("width","40px")',
		 * 500); setTimeout('$(".pop").animate({ left: "-300px" })', 300);
		 * setTimeout('$(".pop").attr("name", "1")', 300);
		 */

	}
	//pop_num()
}
/* 上传图片 */
function getPath(obj, fileQuery, transImg) {
	var imgSrc = '', imgArr = [], strSrc = '';
	if (window.navigator.userAgent.indexOf("MSIE") >= 1) { // IE浏览器判断
		if (obj.select) {
			obj.select();
			var path = document.selection.createRange().text;
			alert(path);
			obj.removeAttribute("src");
			imgSrc = fileQuery.value;
			imgArr = imgSrc.split('.');
			strSrc = imgArr[imgArr.length - 1].toLowerCase();
			if (strSrc.localeCompare('jpg') === 0
					|| strSrc.localeCompare('jpeg') === 0
					|| strSrc.localeCompare('gif') === 0
					|| strSrc.localeCompare('png') === 0) {
				obj.setAttribute("src", transImg);
				obj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
						+ path + "', sizingMethod='scale');"; // IE通过滤镜的方式实现图片显示
			} else {
				// try{
				throw new Error('File type Error! please image file upload..');
				// }catch(e){
				// alert('name: ' + e.name + 'message: ' + e.message) ;
				// }
			}
		} else {
			// alert(fileQuery.value) ;
			imgSrc = fileQuery.value;
			imgArr = imgSrc.split('.');
			strSrc = imgArr[imgArr.length - 1].toLowerCase();
			if (strSrc.localeCompare('jpg') === 0
					|| strSrc.localeCompare('jpeg') === 0
					|| strSrc.localeCompare('gif') === 0
					|| strSrc.localeCompare('png') === 0) {
				obj.src = fileQuery.value;
			} else {
				// try{
				throw new Error('File type Error! please image file upload..');
				// }catch(e){
				// alert('name: ' + e.name + 'message: ' + e.message) ;
				// }
			}
		}
	} else {
		var file = fileQuery.files[0];
		var reader = new FileReader();
		reader.onload = function(e) {
			imgSrc = fileQuery.value;
			imgArr = imgSrc.split('.');
			strSrc = imgArr[imgArr.length - 1].toLowerCase();
			if (strSrc.localeCompare('jpg') === 0
					|| strSrc.localeCompare('jpeg') === 0
					|| strSrc.localeCompare('gif') === 0
					|| strSrc.localeCompare('png') === 0) {
				obj.setAttribute("src", e.target.result);
			} else {
				// try{
				throw new Error('File type Error! please image file upload..');
				// }catch(e){
				// alert('name: ' + e.name + 'message: ' + e.message) ;
				// }
			}
			// alert(e.target.result);
		}
		reader.readAsDataURL(file);
	}
}

function show1() {
	// 以下即为完整客户端路径
	var file_img = document.getElementById("img"), iptfileupload = document
			.getElementById('iptfileupload');
	getPath(file_img, iptfileupload, file_img);
}
// 加入购物车
function addshop(ob) {
	var ra = $(ob).parents(".item-inform ").find(".sys_item_price").text() // 价格
	var co = $(ob).parents(".item-inform ").find(".tb-detail-hd").text() // 名字
	var img = $(ob).parents(".item-inform ").find(".comm_img").attr("src") // 图片
	var val = $(ob).parents(".item-inform ").find("#text_box").val() // 数量
	strhtml = '<tr><td><div class="pop_shop "><p class="pop_shop_head ">'
			+ co
			+ '</p><div class="pop_shop_container "><div class="pop_shop_1 "><img src="'
			+ img
			+ '"/></div><div class="pop_shop_2 "><p>单价：¥ <span class="pop_shop_2_num ">'
			+ ra
			+ '</span></p><p>小计：¥ <span  class="pop_shop_2_subtotal ">16.80</span></p><div style="width: 100px;padding: 10px; "><div class="pop_shop_add pop_shop_an "  onclick="pop_reduce(this) ">-</div><input type="text " class="pop_shop_num "  value="'
			+ val
			+ ' " /><div class="pop_shop_reduce pop_shop_an " onclick="pop_add(this) ">+</div></div></div><div class="pop_shop_3 " ><img src="../images/ca.png " style="width: 22px; margin: 5px 10px; " onclick="pop_del(this) "/></div></div></div></td></tr>'
	$('#pop_list').append(strhtml);
	pop_kong();
	xiaoji_o();
	//pop_num();
	zhongji();
}
// 浮动搜索
$(window).scroll(function() {
	// 滚动条距离顶部的距离 大于 200px时
	if ($(window).scrollTop() >= 200) {
		$(".float_search_box").fadeIn(1000); // 开始淡入
		$("#searchInput").val($("#searchInput2").val())
		$(".search_list_ul_box").css({
			"position" : "fixed",
			"top" : "55px"
		})

	} else {
		$(".float_search_box").stop(true, true).fadeOut(1000); // 如果小于等于 200 淡出
		$("#searchInput2").val($("#searchInput").val())
		$(".search_list_ul_box").css({
			"position" : "absolute",
			"top" : "100px"
		})
	}
});
// 动画效果
function animation_shop() {
	strhtml = '<div class="animation_shop" ><img src="../images/fishs.png"/></div>'
	$(".animation").append(strhtml);
	$(".animation_shop").show()
	$(".animation_shop").animate({
		left : "-10px"
	});
	setTimeout('$(".animation_shop").hide()', 300);
	setTimeout('$(".animation_shop").remove()', 310);
}
// 与头部的搜索框进行核对
function search_list2() {
	$("#searchInput").val($("#searchInput2").val())
	search_list()
}
// 购物车商品数目与价格
//function pop_num() {
//	var num = $(".pop").find("tbody tr").length
//	$("#pop_foot_num").text(num)
	//$(".cart_num").text(num)

//}
// 判断是否有弹框
function addshop_i(ob) {
		animation_shop();
		var isCoounter = $("#cccounter").val();
		var preId = $("#preId").val();
		//alert(isCoounter);
		if (isCoounter == 1) {
			if (null == preId || "" == preId) {
				alert("此商品为处方药品，请先登记处方，再提交购买!");
				return;
			}
		}
		window.location.href = '/cart/addToCart?skuId=' + skuId
				+ "&amount=" + $("#text_box").val() + "&preId=" + preId
				+ "&returnUrl="
				+ encodeURIComponent(window.location.href);
	
}
// 弹框确认
function addshop_but(ob) {
	addshop(ob)
	animation_shop()
	//$(".theme-popover").css("display", "none")
}
// 购物车缩回
function pop() {
	$(document)
			.bind(
					'click',
					function(e) {
						var e = e || window.event; // 浏览器兼容性
						var elem = e.target || e.srcElement;
						while (elem) { // 循环判断至跟节点，防止点击的是div子元素
							if (elem.id && elem.id == 'pop') {
								return;
							}
							elem = elem.parentNode;
						}
						if ($(".pop").attr("name") == 0) {
							setTimeout(
									'window.parent.$(".iframe_tip").css("width","40px")',
									500);
							setTimeout('$(".pop").animate({ left: "-300px" })',
									300);
							setTimeout('$(".pop").attr("name", "1")', 300);
						}
					});
}
// 计算评价比例
function discuss() {
	if ($(".good_ratio_total").text() > 0) {
		var total = $(".good_ratio_1").text() / $(".good_ratio_total").text()
		$("#good_ratio").text(Math.round(total * 100))
		bili()
	} else {
		$("#good_ratio").text(0)
	}
}
// 各个评论比例
function bili() {
	var num1 = $(".good_ratio_1").text() / $(".good_ratio_total").text()
	var num2 = $(".good_ratio_2").text() / $(".good_ratio_total").text()
	var num3 = $(".good_ratio_3").text() / $(".good_ratio_total").text()
	$(".bili_1").text(Math.round(num1 * 100))
	$(".bili_2").text(Math.round(num2 * 100))
	$(".bili_3").text(Math.round(num3 * 100))
	// 做css
	for (i = 0; i < 3; i++) {
		if ($(".bili_list").eq(i).find("label").text() < 10) {
			$(".bili_list").eq(i).find(".bili").css("margin-left", "38px")
		} else if ($(".bili_list").eq(i).find("label").text() == 100) {
			$(".bili_list").eq(i).find(".bili").css("margin-left", "22px")
		}
		// 红色比例
		$(".bili_list").eq(i).find(".bili_red").width(
				parseInt($(".bili_list").eq(i).find("label").text()) + "%")
	}
}
// 详细图联系
function diagram() {
	var img = $(".tb-selected img").attr("src")
	$(".tb-s310 img").attr("src", img).width("400px").height("400px")

}
function midimg() {
	$("#thumblist").click(function() {
		diagram()
	})
}
function bigimg() {
	$(".tb-s310 a")
			.hover(
					function() {
						var img = $(".tb-selected img").attr("src")
						$(".bigimg")
								.attr(
										{
											"src" : img,
											"onerror" : "javascript:this.src='../images/kong.jpg'"
										}).width("800px").height("800px")
					})

}
// 轮播图
function lun() {
	$(".slides").empty()
	var strhtml = ""
	for (i = 0; i < 3; i++) {
		src = $("#thumblist li").eq(i).find("img").attr("src")
		strhtml += '<li><img src="' + src + '" /></li>'
	}
	$(".slides").append(strhtml);
}
// 第一个为红框
function red_first() {
	$("#thumblist li").removeClass("tb-selected")
	$("#thumblist li").eq(0).addClass("tb-selected")
}
// 登记分类hover
function hov() {
	$(".need_list_n a").eq(0).hover(
			function() {
				$(".need_list_n a").eq(0).find("img").attr("src",
						"../images/record (1).png");
				$(".need_list_n a").eq(0).css({
					"color" : "#0B74DF",
					"border" : "5px solid #0B74DF"
				})
			},
			function() {
				$(".need_list_n a").eq(0).find("img").attr("src",
						"../images/record (3).png")
				$(".need_list_n a").eq(0).css({
					"color" : "#cdcdcd",
					"border" : "5px solid #ccc"
				})
			})
	$(".need_list_n a").eq(1).hover(
			function() {
				$(".need_list_n a").eq(1).find("img").attr("src",
						"../images/record (2).png");
				$(".need_list_n a").eq(1).css({
					"color" : "#0B74DF",
					"border" : "5px solid #0B74DF"
				})
			},
			function() {
				$(".need_list_n a").eq(1).find("img").attr("src",
						"../images/record (4).png")
				$(".need_list_n a").eq(1).css({
					"color" : "#cdcdcd",
					"border" : "5px solid #ccc"
				})
			})
}
