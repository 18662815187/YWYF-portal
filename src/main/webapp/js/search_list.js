$(document).ready(function(){
	//页码
	pages1()
})


//判断搜索是否有文字
function search_list() {
	var val = $("#searchInput").val()
	if($("#searchInput").val() == "") {
		$(".search_list_ul_box").hide()
		$(".search_list_ul").empty();
	} else {
		$(".search_list_ul").empty();
		$(".search_list_ul_box").show()
		$.ajax({
			url: '/rest/searchKeywords?keyword=' + val + '', //地址
			dataType: "json",
			type: "get",
			timeout: 5000,
			success: function(data) {
				var html = ""
				for(i = 0; i < data.length; i++) {
					var Cts = data[i].name
					if(Cts.indexOf(val) >= 0) {
						html += "<li onclick='search_w(this)'><span id='cts'>" + Cts + "</span></li>"
					}
				}
				$(".search_list_ul").append(html);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert("请求超时，请保证网络畅通并重试!");
				/*alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);*/
			},

		})
	}
}
//点击搜索
function search_w(obj) {
	var k= $(obj).text();
	$("#searchInput").val(k);
	$("#searchInput2").val(k);
}
//随着浏览器可视区变化
$(window).resize(function() { /*浏览器可视区域变化*/
	if(document.body.clientWidth >= 1025) {
		search_list()
	} else if(document.body.clientWidth < 1025) {
		$(".search_list_ul_box").hide()
	}
});
//移出隐藏
function search_hide() {
	$(".search_list_ul_box").css("display", "none")
}

function search_show() {
	$(".search_list_ul_box").css("display", "block")
}
//上/下一页
function pages(ob) {
	var num = $(ob).parent(".order-pages").find(".pages_num").text()
	if($(ob).val() == "下一页") {
		$(ob).parent(".order-pages").find(".pages_num").text(parseInt(num) + 1)
	} else if($(ob).val() == "上一页") {
		if($(ob).parent(".order-pages").find(".pages_num").text() > 1) {
			$(ob).parent(".order-pages").find(".pages_num").text(parseInt(num) - 1)
		}
	}
	pages1()
}
function pages1(){
	$(".order-pages").each(function(){
		if($(this).find(".pages_num").text()==1){
			$(this).find(".pages_up").css({"border":"1px solid #ccc","color":"#ccc"})
		}
		else{
			$(this).find(".pages_up").css({"border":"1px solid #0b74df","color":"#0b74df"})
		}
	})
	
}
