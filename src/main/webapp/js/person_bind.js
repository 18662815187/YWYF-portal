function sendMobileCode(ob) {
				if($(ob).find(".am-btn-danger").text()=="验证码"){
					clearInterval(times);
					$(ob).find("div").css({ "background-color": "#cdcdcd", "color": "#fff" ,"border-color":"#cdcdcd"})
					var times = ""
					var num = 30
					$(ob).find("div").disabled = true;
					times = setInterval(function() {
						num--
						if(num <= 0) {
							clearInterval(times); //清除js定时器
							$(ob).find("div").disabled = false;
							$(ob).find("div").text("验证码");
							nums = 30; //重置时间
							$(ob).find("div").css({ "background-color": "#0b74df", "color": "#fff" ,"border-color":"#0b74df"})
						} else {
							$(ob).find("div").text("剩"+num+"s");
						}
					}, 1000);
				}
			}
			var register_phone = false
			function binding_phone(){
				var password1 = $("#password1").val()
				var passwordRepeat1 = $("#passwordRepeat1").val()
				
				if($("#user-code").val()==""){
					$("#cue_text").text("你输入的验证码为空")
					$("#cue_text_box").css("opacity","1")
					register_phone = false
				}else if($("#user-new-phone").val()==""||$("#user-new-phone").val().length<11){
					$("#cue_text").text("你输入的手机号码不正确")
					$("#cue_text_box").css("opacity","1")
					register_phone = false
				}else if($("#user-new-code").val()==""){
					$("#cue_text").text("你输入的验证码为空")
					$("#cue_text_box").css("opacity","1")
					register_phone = false
				}
				else{
					$("#cue_text_box").css("opacity","0")
					register_phone = true
				}
			}
			//点击修改按钮
			function binding_true(){
				
				binding_phone()
				if(register_phone == true){
					alert("修改成功")
					//修改成功
					binding_success()
				}
			}
			//修改成功
			function binding_success(){
				//改变图标
				$(".step-1 .u-stage-icon-inner .bg").css("background-position","-103px -135px")
				$(".step-2 .u-stage-icon-inner .bg ").css({"background-position":"-103px -135px","opacity":"1"})
				//加载
				srthtml = '<div style="text-align: center;"><img src="../images/gou.png" width="100px"/><p style="margin: 25px;color: #0b74df;">修改成功</p><p style="margin: 10px;color: #666;">自动跳转到<a href="index.html" style="text-decoration: underline;color: #0b74df;">个人中心</a>，<span id="count_down_second">5</span>秒</p></div>'
				$("#am-form-horizontal").html(srthtml)
				//倒计时
				var times1 = ""
				var num = 5
				times1 = setInterval(function() {
					num--
					if(num <= 0) {
						clearInterval(times1); //清除js定时器
						window.location.href='index.html'
					}else{
						$("#count_down_second").text(num);
					}
				}, 1000);			
			}