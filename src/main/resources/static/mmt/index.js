"use strict";
//varible
let email = "";
let emailFormat = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;

//const



//function
function verifyEmail()
{
	
	if($("#textEmail").val()==undefined||$("#textEmail").val()==null||$("#textEmail").val()=="")
	{
		alert("邮箱不能为空");
		return
	}
	else
	{
		email = $("#textEmail").val();
		console.log(email);
	}
	
	
	if(emailFormat.test(email)==false)
	{
		
		alert("邮箱格式不正确");
		return
	}
	
	
}


function toSignUp()
{
	window.location.href = "signup";
}

function toSignIn()
{
	window.location.href = "signin";

}

function doSignUp()
{
	alert("do sign up");
	
}

function doSignIn()
{

}