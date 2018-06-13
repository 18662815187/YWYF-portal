//全部分类
function list_w(ob) {
}

function list_b(ob) {
}
//触摸显示
function drug_show(ob) {
	$(ob).find(".commodity_table_black").show()
}

function drug_hide(ob) {
	$(ob).find(".commodity_table_black").hide()
}
//
function drug_show_b(ob) {
	$(ob).show()
}
function drug_hide_b(ob) {
	$(ob).hide()
}
//加入购物车
function addshop(ob) {
	var ra = $(ob).parents(".commodity_table_d ").find(".price").text()
	var co = $(ob).parents(".commodity_table_d ").find(".commodity").text()
	var img = $(ob).parents(".commodity_table_d ").find(".comm_img").attr("src")
	strhtml = '<tr><td><div class="pop_shop "><p class="pop_shop_head ">' +
		co +
		'</p><div class="pop_shop_container "><div class="pop_shop_1 "><img src="' +
		img +
		'"/></div><div class="pop_shop_2 "><p>单价：¥ <span class="pop_shop_2_num ">' +
		ra +
		'</span></p><p>小计：¥ <span  class="pop_shop_2_subtotal ">16.80</span></p><div style="width: 100px;padding: 10px; "><div class="pop_shop_add pop_shop_an "  onclick="pop_reduce(this) ">-</div><input type="text " class="pop_shop_num "  value="1 " /><div class="pop_shop_reduce pop_shop_an " onclick="pop_add(this) ">+</div></div></div><div class="pop_shop_3 " ><img src="images/ca.png " style="width: 22px; margin: 5px 10px; " onclick="pop_del(this) "/></div></div></div></td></tr>'
	$("body").find('#pop_list').append(strhtml);
	pop_kong();
	xiaoji_o();
	//pop_num();
	zhongji();

}
//浮动搜索
$(window).scroll(function() {
	// 滚动条距离顶部的距离 大于 200px时
	if($(window).scrollTop() >= 200) {
		$(".float_search_box").fadeIn(1000); // 开始淡入
		$("#searchInput").val($("#searchInput2").val())
		$(".search_list_ul_box").css({ "position": "fixed", "top": "55px", "left": "0px" })

	} else {
		$(".float_search_box").stop(true, true).fadeOut(1000); // 如果小于等于 200 淡出
		$("#searchInput2").val($("#searchInput").val())
		$(".search_list_ul_box").css({ "position": "absolute", "top": "100px" })
	}
});
//动画效果
function animation_shop() {
	strhtml = '<div class="animation_shop" ><img src="images/fishs.png"/></div>'
	$(".animation").append(strhtml);
	$(".animation_shop").show()
	$(".animation_shop").animate({ left: "-10px" });
	setTimeout('$(".animation_shop").hide()', 300);
	setTimeout('$(".animation_shop").remove()', 310);
}
//与头部的搜索框进行核对
function search_list2() {
	$("#searchInput").val($("#searchInput2").val())
	search_list()
}

$(document).ready(function(){
	//商城头条超过3个
	chao()
	//自适应高度
	height()
	//判断为空
	pop_kong()
	//小计
	xiaoji_o()
	//pop_num()
	zhongji()
	//购物车另加
	pop()
})
//页面加载加载完成后
window.onload=function(){
	
	//商城头头条
	title()
	//商城轮播
	ad3()
	//产品轮播
	ad2()
	//推荐轮播
	reco()
	//商品数量不足8个
	wu_tu()
}
//加减
function pop_add(ob) {
	var pop_val = $(ob).parents(".pop_shop_2").find(".pop_shop_num").val()
	$(ob).parents(".pop_shop_2").find(".pop_shop_num").val(parseInt(pop_val) + 1)
	xiaoji(ob)
	zhongji()
}

function pop_reduce(ob) {
	var pop_val = $(ob).parents(".pop_shop_2").find(".pop_shop_num").val()
	if(pop_val > 1) {
		$(ob).parents(".pop_shop_2").find(".pop_shop_num").val(parseInt(pop_val) - 1)
		xiaoji(ob)
		zhongji()
	}
}
//小计
function xiaoji(ob) {
	var a1 = parseFloat($(ob).parents(".pop_shop_2").find(".pop_shop_2_num").text())
	var a2 = parseFloat($(ob).parents(".pop_shop_2").find(".pop_shop_num").val())
	$(ob).parents(".pop_shop_2").find(".pop_shop_2_subtotal").text((a1 * a2).toFixed(2))
}

function xiaoji_o() {
	$(".pop_shop_2_subtotal").each(function() {
		var al = $(this).parents(".pop_shop_2").find(".pop_shop_2_num").text()
		$(this).text(al)
	})
}
//总计
function zhongji() {
	if($(".pop").find("tbody tr").length == 0) {
		var ww = 0.00
		$("#pop_foot_price").text(ww.toFixed(2))
	} else {
		var zh = 0
		for(i = 0; i < $(".pop").find("tbody tr").length; i++) {
			zh += parseFloat($(".pop").find("tbody tr").eq(i).find(".pop_shop_2_subtotal").text())
		}
		$("#pop_foot_price").text(zh.toFixed(2))
	}

}
//购物车删除
function pop_del(ob) {
	var mymessage = confirm("确认删除？");
	if(mymessage == true) {
		$(ob).parents("tr").remove()
	}
	//pop_num()
	zhongji()
	pop_kong()
}
//判断为空
function pop_kong() {
	var strhtml = '<tr><td><div class="pop_shop_kong"><img src="images/pop_shop.png"/><p>亲，你的购物车为空哦！</p></div></td></tr>'
	var kong = $(".pop").find("tbody tr").length
	if(kong == 0) {
		$(".pop").find("tbody").html(strhtml)
	} else {
		$(".pop_shop_kong").parents("tr").remove()
	}

}

//购物车商品数目与价格
//function pop_num() {
//	var num = $(".pop").find("tbody tr").length
//	$("#pop_foot_num").text(num)
//	$(".cart_num").text(num)

//}
//弹出购物车
function shop() {
	if($(".pop").attr("name") == 1) {
		window.parent.$(".iframe_tip").css("width", "340px")
		$(".pop").animate({ left: "35px" });
		setTimeout('$(".pop").attr("name", "0")', 300)
	} else if($(".pop").attr("name") == 0) {
		/*setTimeout('window.parent.$(".iframe_tip").css("width","40px")', 500);
		setTimeout('$(".pop").animate({ left: "-300px" })', 300);
		setTimeout('$(".pop").attr("name", "1")', 300);*/

	}
}
//顶部
function goTop() {
	$('html, body').animate({ scrollTop: 0 }, 'slow');
}
//加入购物车添加入浮动框
function addshop1(ob) {
	var ra = $(ob).parents(".commodity_table_d ").find(".price").text()
	var co = $(ob).parents(".commodity_table_d ").find(".commodity").text()
	var img = $(ob).parents(".commodity_table_d ").find(".comm_img").attr("src")
	strhtml = '<tr><td><div class="pop_shop "><p class="pop_shop_head ">' +
		co +
		'</p><div class="pop_shop_container "><div class="pop_shop_1 "><img src="' +
		img +
		'"/></div><div class="pop_shop_2 "><p>单价：¥ <span class="pop_shop_2_num ">' +
		ra +
		'</span></p><p>小计：¥ <span  class="pop_shop_2_subtotal ">16.80</span></p><div style="width: 100px;padding: 10px; "><div class="pop_shop_add pop_shop_an "  onclick="pop_reduce(this) ">-</div><input type="text " class="pop_shop_num "  value="1 " /><div class="pop_shop_reduce pop_shop_an " onclick="pop_add(this) ">+</div></div></div><div class="pop_shop_3 " ><img src="images/ca.png " style="width: 22px; margin: 5px 10px; " onclick="pop_del(this) "/></div></div></div></td></tr>'
	$('#pop_list').append(strhtml);
	pop_kong()
	//pop_num()
	zhongji()
}
//推荐的轮播
function reco(){
	times1 = null
	var ran = -205
	var min = (8+1)*-205  //8个
	times1=setInterval(function(){
			if(ran <= min){
				ran = 0
				$(".reco_tj_b").find(".reco_tj").css("left","0px");
				ran = ran-205
				$(".reco_tj_b").find(".reco_tj").animate({left:""+ran+"px"});
				ran = ran-205
			}
			else{
				$(".reco_tj_b").find(".reco_tj").animate({left:""+ran+"px"});
				ran = ran-205
			}
	},4000)
}
//高度自适应
function height(){
	$(".category-info").height($(".appliance").height())
}
//商城头条轮播
function ad3(){
	var ad = 1;
	var nu = 0
	times3 = null;
	var len =  $(".advTip img").length;
	times3=setInterval(function(){
		if(nu >(len-1)*-200){
			nu=nu-220
			$(".advTip").animate({left:""+nu+"px"})
			ad=ad+1
		}
		else{
			$(".advTip").css("left","0px")
			nu = 0
		}
	},3000)	
}
//产品广告轮播
function ad2(){
	guan_ad(0,1500)
	guan_ad(1,2000)
	guan_ad(2,1500)
	guan_ad(3,2000)
	guan_ad(4,1500)
	guan_ad(5,2000)
}
function guan_ad(i,sec){
		var ad = 1;
		var len = $(".guan_ad").eq(i).find(".guan_ad_img").length;
		time =setInterval(function(){
			if(ad == len){
				$(".guan_ad").eq(i).find(".guan_ad_img").css("left","-220px")
				$(".guan_ad").eq(i).find(".guan_ad_img").eq(ad-1).animate({left:"0px"})
				ad = 1;
			}
			else{
				$(".guan_ad").eq(i).find(".guan_ad_img").css("left","-220px")
				$(".guan_ad").eq(i).find(".guan_ad_img").eq(ad-1).animate({left:"0px"})
				ad = ad+1
			}
		},sec)
}
//购物车缩回
function pop(){
		$(document).bind('click',function(e){ 
			var e = e || window.event; //浏览器兼容性 
			var elem = e.target || e.srcElement; 
			while (elem) { //循环判断至跟节点，防止点击的是div子元素 
				if (elem.id && elem.id=='pop') { 
					return; 
				} 
				elem = elem.parentNode; 
			} 
			if($(".pop").attr("name")==0){
				setTimeout('window.parent.$(".iframe_tip").css("width","40px")', 500);
				setTimeout('$(".pop").animate({ left: "-300px" })', 300);
				setTimeout('$(".pop").attr("name", "1")', 300);
			}
		}); 
}
//商品没有8个的时候
function wu_tu(){
	var num =  $(".floodFour").length
	for(i=0;i<num;i++){
		$(".floodFour").eq(i).find(".commodity_table_cp").each(function(){
			var len = $(this).find(".commodity_table_d").length
			if(len<8){
				strhtml = ''
				for(j = 0;j<(8-len);j++){
					strhtml += '<div class="commodity_table_d commodity_table_wu"></div>'
				}
				$(this).append(strhtml); 
			}
		})
	}
	
}
//商城头条没有3个的时候
function title(){
	$("#title_news").each(function(){
		var len = $(this).find(".title-first").length
		if(len<3){
			strhtml = ''
			for(i = 0;i<(3-len);i++){
				strhtml += '<li class="title-first"><a target="_blank" href="other/introduction.html"><span></span></a></li>'
			}
			$("#title_news").append(strhtml); 
		}
	})
}
//商城头条如果超过3个
function chao(){
	for(i=3;i<=$("#title_news li").length;i++){
		$("#title_news li").eq(i).hide()
	}
}
