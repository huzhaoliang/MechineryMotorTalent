"use strict";
//request uri
const api_verifyToken = "/api/verifyToken";
const api_signUp = "/api/signUp";
const api_signIn = "/api/signIn";

//variable


//function
function toSignUp()
{
	window.location.href = "signup";
}

function toSignIn()
{
	window.location.href = "signin";
}


if(sessionStorage["token"]!= null)
{
	
	alert("start to verify token");
	$.ajax({
		  async: false,
		  type: 'POST',
		  url: api_verifyToken,
		  dataType: 'json',
		  contentType: "application/json;charset=utf-8",
		  data: 
		  {
			  "token": sessionStorage["token"]
		  },
		  success: function(data)
		  			{
			  			console.log(data);	
		  			},
		  error: function()
		  		{
			  		alert("chech token Error");
		  		}
		});
}

