//点击更多
function more() {
	if($(".i-load-more-item").attr("name") == 0) {
		$(".i-load-more-item").html('<i class="am-icon-refresh am-icon-fw"></i>上拉')
		for(i = 7; i <= $(".s-item-wrap").length; i++) {
			$(".s-content").find(".s-item-wrap").eq(i - 1).show()
		}
		$(".i-load-more-item").attr("name", "1")
	} else if($(".i-load-more-item").attr("name") == 1) {
		$(".i-load-more-item").html('<i class="am-icon-refresh am-icon-fw"></i>更多')
		for(i = 7; i <= $(".s-item-wrap").length; i++) {
			$(".s-content").find(".s-item-wrap").eq(i - 1).hide()
		}
		$(".i-load-more-item").attr("name", "0")
	}
}
//跳转
function jump() {
	window.location.href = '../other/introduction.html'
}

function comjump(ht) {
	window.parent.location.href = ht
}
window.onload = function() {
	var height = $(".main-wrap").height();
	window.parent.$("#person").height(height)
}
//批量删除
function batch_del() {
	if($(".s-bar-del").text() == "批量删除") {
		$(".s-bar-del").text("确认删除")
		$(".s-bar-del").css({ "color": "#fff", "background-color": "#dd514c" })
		$(".s-item-wrap").attr("name", "1")
	} else {
		var mymessage = confirm("确认删除？");
		if(mymessage == true) {
			$(".s-item-wrap[name='2']").remove()
			$(".s-bar-del").text("批量删除")
			$(".s-bar-del").css({ "color": "#dd514c", "background-color": "#fff" })
			$(".s-item-wrap").attr("name", "0")
		}
	}
}

function selected_del(ob) {
	if($(ob).attr("name") == 0) {
		comjump('../other/introduction.html')
	} else if($(ob).attr("name") == 1) {
		$(ob).find(".s-item").css("border", "1px solid #dd514c")
		$(ob).attr("name", "2")
	} else if($(ob).attr("name") == 2) {
		$(ob).find(".s-item").css("border", "0px")
		$(ob).attr("name", "1")
	}
}