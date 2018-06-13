function delClick(ob) {
	var mymessage = confirm("确认删除？");
	var mid =$(ob).parents(".user-addresslist").find("#XXID").val(); 
	window.location.href = "/user/delMailAddr?mid="+mid+"&returnUrl="+encodeURIComponent(window.location.href);
}
//动态加载地址默认
$(document).on("click", ".user-addresslist", function() {
	$(this).addClass("defaultAddr").siblings().removeClass("defaultAddr");
});
//设为默认
$(document).on("click", ".new-option-r", function() {
	$(".new-option-r").text("设为默认地址")
	$(this).text("默认地址")
});
//添加收货地址提示
var btm = false

function add_cue() {
	if($("#user-name").val() == "") {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("你的收货人为空")
		btm = false
	} else if($("#user-phone").val() == "") {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("你的手机号码为空")
		btm = false
	} else if($("#user-intro").val() == "") {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("你的详细地址为空")
		btm = false
	} else if($("#user-intro").val().length >= 100) {
		$("#add_address_cue_img").show()
		$("#add_address_cue").text("详细地址应该在100字以内")
		btm = false
	} else {
		$("#add_address_cue_img").hide()
		$("#add_address_cue").text("")
		btm = true
	}
}
//保存地址
function add_address() {
	add_cue()
	if(btm == true) { //判断是否信息都完全填写
//		if($(".user-addresslist[name='11']").attr("name") == 11) { //判断是否是新增还是修改
//			var buy = $(".user-addresslist[name='11']")
//			buy.find(".new-txt").text($("#user-name").val())
//			buy.find(".new-txt-rd2").text($("#user-phone").val())
//			buy.find(".buy--address-detail").text($("#user-intro").val())
//			//消除val
//			$("#user-name").val("")
//			$("#user-phone").val("")
//			$("#user-intro").val("")
//			buy.attr("name", "")
//		} else {
			if($("#address_ul_box").find("li").length >= 6) { //如果收货地址的数量超过6个
				alert("收货地址最多只能添加六个")}
//			} else {
//				$(".buy-user[name='zero']").parents(".user-addresslist").remove()
//				var strm = '<li class="user-addresslist"><span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span><p class="new-tit new-p-re"><span class="new-txt">' +
//					$("#user-name").val() +
//					'</span><span class="new-txt-rd2">' +
//					$("#user-phone").val() +
//					'</span></p><div class="new-mu_l2a new-p-re"><p class="new-mu_l2cw"><span class="title">地址：</span><span class="buy--address-detail">' +
//					$("#user-intro").val() +
//					'</span></p></div><div class="new-addr-btn"><a onclick="rewrite_address(this)"><i class="am-icon-edit"></i>编辑</a><span class="new-addr-bar">|</span><a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a></div></li>'
//
//				//添加
//				$("#address_ul_box").append(strm);
//				//消除val
//				$("#user-name").val("")
//				$("#user-phone").val("")
//				$("#user-intro").val("")
//			}
//		}
	}
}
//编辑（修改地址）
function rewrite_address(ob) {
	//标记li
	$(".user-addresslist").attr("name", "")
	$(ob).parents(".user-addresslist").attr("name", "11")
	//赋值
	$("#mid").val($(ob).parents(".user-addresslist").find("#XXID").val())
	$("#user-name").val($(ob).parents(".user-addresslist").find(".new-txt").text())
	$("#user-phone").val($(ob).parents(".user-addresslist").find(".new-txt-rd2").text())
	$("#user-intro").val($(ob).parents(".user-addresslist").find(".buy--address-detail").text())
}
//取消
function cancel() {
	$("#mid").val("")
	$("#user-name").val("")
	$("#user-phone").val("")
	$("#user-intro").val("")
	$(".user-addresslist[name='11']").attr("name", "")
}