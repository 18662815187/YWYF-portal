//提示
			var btm = false
			function add_cue(){
				if($("#user-old-password").val() == "" ){
					$("#add_address_cue_img").show()
					$("#add_address_cue").text("你的原密码为空")
					btm = false
				}else if($("#user-new-password").val() == ""){
					$("#add_address_cue_img").show()
					$("#add_address_cue").text("你的新密码为空")
					btm = false
				}
				else if($("#user-confirm-password").val() == ""){
					$("#add_address_cue_img").show()
					$("#add_address_cue").text("你的确认密码为空")
					btm = false
				}
				else if($("#user-new-password").val() != $("#user-confirm-password").val()){
					$("#add_address_cue_img").show()
					$("#add_address_cue").text("你的密码不一致")
					btm = false
				}else{
					$("#add_address_cue_img").hide()
					$("#add_address_cue").text("")
					 btm = true
				}
			}
			//保存地址
			function add_address(){
				add_cue()
				if(btm == true){ //判断是否信息都完全填写
//					alert("修改成功")
//					binding_success()
					$.ajax({
						url: '/user/applyUpPwd', //地址
						dataType: "json",
						type: "post",
						timeout: 5000,
						data: $('#jvForm').serialize(),
						success: function(data) {
							if(data.status==1){
								window.location.href="/login/toLogin";
							}else {
								$("#add_address_cue_img").show()
								$("#add_address_cue").text(data.msg)
							}
						},
						error: function(XMLHttpRequest, textStatus, errorThrown) {
							//alert("请求超时，请保证网络畅通并重试!");
							/*alert(XMLHttpRequest.status);
							alert(XMLHttpRequest.readyState);
							alert(textStatus);*/
						},

					})
				}
			}
			//修改成功
			function binding_success(){
				//改变图标
				$(".step-1 .u-stage-icon-inner .bg").css("background-position","-103px -135px")
				$(".step-2 .u-stage-icon-inner .bg ").css({"background-position":"-103px -135px","opacity":"1"})
				//加载
				srthtml = '<div style="text-align: center;"><img src="../images/gou.png" width="100px"/><p style="margin: 25px;color: #0b74df;">修改成功</p><p style="margin: 10px;color: #666;">自动跳转到<a href="index.html" style="text-decoration: underline;color: #0b74df;">个人中心</a>，<span id="count_down_second">5</span>秒</p></div>'
				$(".am-form-horizontal").html(srthtml)
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