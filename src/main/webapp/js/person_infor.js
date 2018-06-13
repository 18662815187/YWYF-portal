$(document).ready(function(){
				//生日
				var str1 = ""
				var str2 = ""
				var str3 = ""
				$(".birth-select select").empty();
				$(".birth-select2 select").empty();
				
				for(i=1987;i<=2018;i++){
					str1 += '<option value="'+i+'">'+i+'</option>'
				}
				for(i=1;i<=12;i++){
					str2 += '<option value="'+i+'">'+i+'</option>'
				}
				for(i=1;i<=30;i++){
					str3 += '<option value="'+i+'">'+i+'</option>'
				}
				
				$(".birth-select select").append(str1); 
				$(".birth-select_one select").append(str2); 
				$(".birth-select_two select").append(str3); 
			})
			//验证邮箱
			function email(){
				if(isemail($("#user-email").val())){
					$("#user-email").css({"border":"1px solid #0b74df"})
				}
				else{
					if($("#user-email").val()==""){
						$("#user-email").css({"border":"1px solid #E4EAEE"})
					}
					else{
						$("#user-email").css({"border":"1px solid red"})
					}
				}
			}
			function isemail(str){ 
				var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
				return reg.test(str); 
			}
			//验证手机
			function phone(){
				if(isphone($("#user-phone").val())){
					$("#user-phone").css({"border":"1px solid #0b74df"})
				}
				else{
					if($("#user-phone").val()==""){
						$("#user-phone").css({"border":"1px solid #E4EAEE"})
					}
					else{
						$("#user-phone").css({"border":"1px solid red"})
					}
				}
			}
			function isphone(str){ 
				var reg = /^[1][3,4,5,7,8][0-9]{9}$/;  
				return reg.test(str); 
			}