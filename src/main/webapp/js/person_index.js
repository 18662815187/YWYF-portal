/*总分类*/
function cla(ob) {
	$(".main-wrap").hide()
	$(".main-wrap").eq(ob).show()
}
window.onload=function(){
	//轮播
	ad()
	//订单详情超过三个隐藏
	order_form()
}

$(document).ready(function() {
	/*日历 */
	calendar()
	//index 收藏
	like()
})
//日历
function calendar() {
	var mydate = new Date();
	var t = mydate.toLocaleString();
	$("#time_date").text(mydate.getDate())
	$("#time_day").text("星期 " + "天一二三四五六 ".charAt(new Date(mydate).getDay()))
	$("#time_year").text(mydate.getFullYear() + "." + (parseInt(mydate.getMonth()) + 1))
}
/*我的物流*/
function confirm_receipt(ob) {
	if($(ob).find(".i-btn-typical").text() == "确认收货") {
		var mymessage = confirm("确认已经收货？");
		if(mymessage == true) {
			$(ob).find(".i-btn-typical").text("去评价")
		}

	} else {
		window.location.href='order.html'
	}

}
/*个人资料*/
$(document).ready(function() {
	//生日
	var str1 = ""
	var str2 = ""
	var str3 = ""
	$(".birth-select select").empty();
	$(".birth-select2 select").empty();

	for(i = 1987; i <= 2018; i++) {
		str1 += '<option value="' + i + '">' + i + '</option>'
	}
	for(i = 1; i <= 12; i++) {
		str2 += '<option value="' + i + '">' + i + '</option>'
	}
	for(i = 1; i <= 30; i++) {
		str3 += '<option value="' + i + '">' + i + '</option>'
	}

	$(".birth-select select").append(str1);
	$(".birth-select_one select").append(str2);
	$(".birth-select_two select").append(str3);
})
//验证邮箱
function email() {
	if(isemail($("#user-email").val())) {
		$("#user-email").css({ "border": "1px solid #0b74df" })
	} else {
		if($("#user-email").val() == "") {
			$("#user-email").css({ "border": "1px solid #E4EAEE" })
		} else {
			$("#user-email").css({ "border": "1px solid red" })
		}
	}
}

function isemail(str) {
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}
//验证手机
function phone() {
	if(isphone($("#user-phone").val())) {
		$("#user-phone").css({ "border": "1px solid #0b74df" })
	} else {
		if($("#user-phone").val() == "") {
			$("#user-phone").css({ "border": "1px solid #E4EAEE" })
		} else {
			$("#user-phone").css({ "border": "1px solid red" })
		}
	}
}

function isphone(str) {
	var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
	return reg.test(str);
}
/*订单管理*/
//评价商品
function assess(ob) {
	$(ob).find(".anniu").text("提交评价")
	$(ob).parents(".order-content").find(".evaluate").css("display", "block")
}
//删除商品
function order_cancel(ob) {
	var mymessage = confirm("确认删除订单？");
	if(mymessage == true) {
		$(ob).parents(".order-del").remove()
	}
}
//品级
function op1(ob) {
	op0(ob)
	$(ob).css("background-image", "url(../images/iconfont-good.png)")
}

function op2(ob) {
	op0(ob)
	$(ob).css("background-image", "url(../images/iconfont-middle.png)")
}

function op3(ob) {
	op0(ob)
	$(ob).css("background-image", "url(../images/iconfont-badon.png)")
}

function op0(ob) {
	$(ob).parents(".item-opinion").find(".op1").css("background-image", "url(../images/iconfont-evaluate.png)")
	$(ob).parents(".item-opinion").find(".op2").css("background-image", "url(../images/iconfont-evaluate.png)")
	$(ob).parents(".item-opinion").find(".op3").css("background-image", "url(../images/iconfont-bad.png)")
}
//我的收藏（随着尺寸的变化而变化）
$(window).resize(function() { /*浏览器可视区域变化*/
	like()
});

//
function like() {
	var len = $(".you-like .s-item-wrap").length
	if(document.body.clientWidth >= 1200) {
		if(len > 8) {
			$(".you-like .s-item-wrap").show()
			for(i = 8; i <= len; i++) {
				$(".you-like .s-item-wrap").eq(i).hide()
			}
		}
	} else if(document.body.clientWidth < 1200 && document.body.clientWidth >= 1025) {

		if(len > 8) {
			$(".you-like .s-item-wrap").show()
			for(i = 8; i <= len; i++) {
				$(".you-like .s-item-wrap").eq(i).hide()
			}
		}
	} else if(document.body.clientWidth < 1025 && document.body.clientWidth >= 640) {
		if(len > 6) {
			$(".you-like .s-item-wrap").show()
			for(i = 6; i <= len; i++) {
				$(".you-like .s-item-wrap").eq(i).hide()
			}
		}
	}
}
//轮播图
function ad(){
	strhtml = '<img src="'+$(".preson_ad_list img").eq(0).attr("src")+'"/>'
	$(".preson_ad_list").append(strhtml)
	
	var wi = 154   //图片的宽度
	var dir = (-1)*wi  
	var times = null;
	var num =$(".preson_ad_list img").length;
	$(".preson_ad_list").width(wi*num)
	$(".preson_ad_list").css("left",""+(dir)*(num-1)+"px")
	var lef =(dir)*(num-2)
	times = setInterval(function(){
		if(lef <154){
			$(".preson_ad_list").animate({left:""+(lef)+"px"});
			lef = lef+154
		}else{
			$(".preson_ad_list").css("left",""+(dir)*(num-1)+"px")
			
			lef =(dir)*(num-2)
		}
	},1000);
}
//订单详情超过三个隐藏
function order_form(){
	var len = $(".lg-list li").length
	if(len == 0){
		$(".lg-list-hide").show()
		$(".lg-list_too").hide()
	}else{
		for(i=3;i<=len;i++){
			$(".lg-list li").eq(i).hide()
			$(".lg-list-hide").hide()
			
		}
	}
	
}
