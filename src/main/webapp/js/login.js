/*密码*/
$(document).ready(function() {
	var name = $.cookie('the_name')
	var pass = $.cookie('the_password')
	if (name == "null") {
		$("#user").val("")
		$("#password").val("")
	} else if (name != "null") {
		$("#user").val(name)
		$("#password").val(pass)
	}

})
/* 记住密码 */
var rem = null
function mima() {
	var mi = $("#remember-me").attr("checked")
	if (mi == "checked") {
		rem = true
	} else {
		rem = false
	}
}
/* 提示 */
var login_phone = false
function login() {
	if ($("#user").val() == "") {
		$("#cue_text").text("你输入你的手机")
		$("#cue_text_box").css("opacity", "1")
		login_phone = false
	} else if ($("#password").val() == "") {
		$("#cue_text").text("你输入的密码为空")
		$("#cue_text_box").css("opacity", "1")
		login_phone = false
	} else if ($("#user-test").val() == "") {
		$("#cue_text").text("你输入的验证码为空")
		$("#cue_text_box").css("opacity", "1")
		login_phone = false
	} else {
		$.ajax({
			url : '/login/apply', // 地址
			dataType : "json",
			data : $('#jvForm').serialize(),
			type : "post",
			timeout : 5000,
			success : function(data) {
				if (data.result == 1) {
					login_phone = true;
					if (null != data.returnUrl && "" != data.returnUrl) {
						window.location.href = data.returnUrl;
					} else {
						window.location.href = "/"
					}

				}else{
					$("#cue_text").html(data.msg);
					var a = $("#returnUrl").val();
					window.location.href = "/login/toLogin?returnUrl="+ encodeURIComponent(a);
				}

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				/*
				 * alert(XMLHttpRequest.status);
				 * alert(XMLHttpRequest.readyState); alert(textStatus);
				 */
				//alert("网络请求异常,请稍后重试或联系管理员!")
			},

		})

	}
}
/* 点击登录 */
function login_true() {
	login()
	mima()
	if (login_phone == true) {
		if (rem == true) { // 假如为true 用cookie储存密码
			$.cookie('the_name', $("#user").val(), {
				expires : 7
			});
			$.cookie('the_password', $("#password").val(), {
				expires : 7
			});
		} else {
			$.cookie('the_name', null);
			$.cookie('the_password', null);
		}
	}
}