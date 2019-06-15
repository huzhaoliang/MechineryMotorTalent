"use strict";
//varible
let username = "";
let email = "";
let password = "";
let passcode = "";
//const
const emailFormat = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
const passwordFormat = /^[\w_-]{6,16}$/;

//function
function doSignUp()
{
	username= $("#username_input").val();
	email = $("#email_input").val();
	password = $("#password_input").val();
	passcode = $("#passcode_input").val();
	
	if(username==undefined||username==null||username=="")
	{
		alert("用户名不能为空");
	}
	
	if(email==undefined||email==null||email=="")
	{
		alert("邮箱不能为空");
		return
	}
	
	if(emailFormat.test(email)==false)
	{
		alert("邮箱格式不正确");
		return
	}
	
	if(password==undefined||password==null||password=="")
	{
		alert("密码不能为空");
		return
	}
	
	if(passwordFormat.test(password)==false)
	{
		alert("密码不符合要求");
		return
	}
	
	
	if(passcode==undefined||passcode==null||passcode=="")
	{
		alert("密码需要确认");
		return
	}
	
	if(passcode!=password)
	{
		alert("密码两次输入不一致");
		return
	}
	

	$.ajax({
		  type: 'POST',
		  url: api_signUp,
		  dataType: "text",
		  //contentType: "application/json;charset=utf-8",
		  async: false,
		  data: 
		  {
			  "name" : username,
			  "email" : email,
			  "password" : password
		  },
		  success: function(res)
		  			{
			  			alert(res);
			  			//window.location.href = "signin";
			  			//sessionStorage["redirect_uri"] = "/index"
			  			toSignIn("/index");
			  		},
		  error: function(res)
		  			{
			  			alert(res);
			  		}
		  
		});
	
	
}

function signup_success(res)
{
	alert(res);
}
