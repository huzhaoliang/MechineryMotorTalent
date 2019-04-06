"use strict";
//varible
let email = "";
let emailFormat = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
let password = "";
let passwordFormat = /^[\w_-]{6,16}$/;
//const






//function
function doSignUp()
{
	if($("#Email").val()==undefined||$("#Email").val()==null||$("#Email").val()=="")
	{
		alert("邮箱不能为空");
		return
	}
	
	if(emailFormat.test(email)==false)
	{
		alert("邮箱格式不正确");
		return
	}
	
	if($("#Password1").val()==undefined||$("#Email").val()==null||$("#Email").val()=="")
	{
		alert("密码不能为空");
		return
	}
	
	if($("#Password1").val()!=$("#Password2").val())
	{
		alert("密码与确认密码不一致");
		return
	}
	
	email = $("Email").val();
	password = $("#Password1").val();
	
	$.ajax({
		  type: 'POST',
		  url: url,
		  data: data,
		  success: success,
		  dataType: dataType
		});
	
	
}


