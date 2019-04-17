"use strict";
//varible
let email = "";
let password = "";

//const
const emailFormat = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
const passwordFormat = /^[\w_-]{6,16}$/;


//function
function doSignIn()
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
	
	//alert(api_signin);
	$.ajax({
		  type: 'POST',
		  url: api_signin,
		  dataType: "json",
		  //contentType: "application/json;charset=utf-8",
		  data: 
		  {
			  "email" : email,
			  "password" : password
		  },
		  success: signin_success()
		  
		});
	
	
}

function signin_success(res)
{
	alert(res);
}
