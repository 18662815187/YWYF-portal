//未选分类时。
function dom(){
	var brandId = $("#selectA").text();
	var typeId = $("#selectB").text();
	var funId = $("#selectC").text();
	var disId = $("#selectD").text();
	
	for(i=0;i<$("#select1 dd").length;i++){
		if($.trim($("#select1 dd").eq(i).text())==brandId){
			$("#select1 dd").eq(i).addClass("selected").siblings().removeClass("selected");
		}
	}
	for(i=0;i<$("#select2 dd").length;i++){
		if($.trim($("#select2 dd").eq(i).text())==brandId){
			$("#select2 dd").eq(i).addClass("selected").siblings().removeClass("selected");
		}
	}
	for(i=0;i<$("#select3 dd").length;i++){
		if($.trim($("#select3 dd").eq(i).text())==brandId){
			$("#select3 dd").eq(i).addClass("selected").siblings().removeClass("selected");
		}
	}
	for(i=0;i<$("#select4 dd").length;i++){
		if($.trim($("#select4 dd").eq(i).text())==brandId){
			$("#select4 dd").eq(i).addClass("selected").siblings().removeClass("selected");
		}
	}
	
	if(brandId == "" && typeId == "" && funId == "" && disId == ""){
		$(".select-result").hide();
	}
	else{
		$(".eliminateCriteria").show()
	 	$(".select-result").show();
		if(brandId == ""){
			$("#selectA").hide()
		}
		if(typeId == ""){
			$("#selectB").hide()
		}
		if(funId == ""){
			$("#selectC").hide()
		}
		if(disId == ""){
			$("#selectD").hide()
		}
	}
}

$(document).ready(function() {
	dom()
	//
	var hh = document.documentElement.clientHeight;
	var ls = document.documentElement.clientWidth;
	if (ls < 640) {
		$(".select dt").click(function() {
			if ($(this).next("div").css("display") == 'none') {
				$(".theme-popover-mask").height(hh);
				$(".theme-popover").css("position", "fixed");
				$(this).next("div").slideToggle("slow");
				$(".select div").not($(this).next()).hide();
			}
          else{
          	$(".theme-popover-mask").height(0);
			$(".theme-popover").css("position", "static");
			$(this).next("div").slideUp("slow");;
          }
		})

		$(".eliminateCriteria").live("click", function() {
			$(".dd-conent").hide();
		})

		$(".select dd").live("click", function() {
			$(".theme-popover-mask").height(0);
			$(".theme-popover").css("position", "static");
			$(".dd-conent").hide();
		});
		$(".theme-popover-mask").live("click", function() {
			$(".theme-popover-mask").height(0);
			$(".theme-popover").css("position", "static");
			$(".dd-conent").hide();
		});
	}


	$("span.love").click(function() {
		$(this).toggleClass("active");
	});


	$("#select1 dd").click(function() {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectA a").text("");
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectA").length > 0) {
				$("#selectA").show();
				$("#selectA a").html($(this).text());
			} else {
				$("#selectA").show();
				$("#selectA a").html($(this).text());
			}
		}
		dom()
	});
	$("#select2 dd").click(function() {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectB a").text("");
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectB").length > 0) {
				$("#selectB").show();
				$("#selectB a").html($(this).text());
			} else {
				$("#selectB").show();
				$("#selectB a").html($(this).text());
			}
		}
		dom()
	});
	$("#select3 dd").click(function() {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectC a").text("");
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectC").length > 0) {
				$("#selectC").show();
				$("#selectC a").html($(this).text());
			} else {
				$("#selectC").show();
				$("#selectC a").html($(this).text());
			}
		}
		dom()
	});
	$("#select4 dd").click(function() {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectD a").text("");
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectD").length > 0) {
				$("#selectD").show();
				$("#selectD a").html($(this).text());
			} else {
				$("#selectD").show();
				$("#selectD a").html($(this).text());
			}
		}
		dom()
	});


	$("#selectA").live("click", function() {
		$("#selectA a").text("");
		$(this).hide();
		$("#select1 .select-all").addClass("selected").siblings().removeClass("selected");
		dom()
	});

	$("#selectB").live("click", function() {
		$("#selectB a").text("");
		$(this).hide();
		$("#select2 .select-all").addClass("selected").siblings().removeClass("selected");
		dom()
	});

	$("#selectC").live("click", function() {
		$("#selectC a").text("");
		$(this).hide();
		$("#select3 .select-all").addClass("selected").siblings().removeClass("selected");
		dom()
	});
	$("#selectD").live("click", function() {
		$("#selectD a").text("");
		$(this).hide();
		$("#select4 .select-all").addClass("selected").siblings().removeClass("selected");
		dom()
	});


	$(".eliminateCriteria").live("click", function() {
		$("#selectA a").text("");
		$("#selectB a").text("");
		$("#selectC a").text("");
		$("#selectD a").text("");
		$("#selectA").hide();
		$("#selectB").hide();
		$("#selectC").hide();
		$("#selectD").hide();
		$(".select-all").addClass("selected").siblings().removeClass("selected");
		$(".eliminateCriteria").hide();
		$(".select-no").show();
		$(".select-result").hide();

	});


});