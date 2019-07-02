"use strict";
//varible
let email = "";
let password = "";

//const
const emailFormat = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
const passwordFormat = /^[\w_-]{6,16}$/;


//function


function doSignIn(_redirect_uri)
{
	email = $("#input_email").val();
	password = $("#input_password").val();
	
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
	
	
	
	$.ajax({
		  async: false,
		  type: 'POST',
		  url: api_signIn,
		  dataType: 'json',
		  //contentType: "application/json;charset=utf-8",
		  data: 
		  {
			  'email': email,
			  'password': password
			  
		  },
		  success: function(data)
		  			{
			  			sessionStorage["name"]=data.name;
			  			sessionStorage["token"]=data.token;
			  			sessionStorage["redirect_uri"]=_redirect_uri;
			  			toRedirectURL();
		  			},
		  error: function()
		  		{
			  		alert("登入系统失败");
		  		}
		});
	
	
}

function signin_success(res)
{
	alert(res);
	//window.location.href = "index";
}


