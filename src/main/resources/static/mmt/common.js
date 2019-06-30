"use strict";
//request uri
const api_verifyToken = "/api/verifyToken";
const api_signUp = "/api/signUp";
const api_signIn = "/api/signIn";
const api_hotJobs = "/api/hotJobs?pageNumber=";

//variable
let username;

//function
function toSignIn()
{
	window.location.href = "signin";
	//sessionStorage["backurl"] = "\";
}

function toSignUp()
{
	window.location.href = "signup";
	//sessionStorage["backurl"] = "\";
}

function toRedirectURL()
{
	alert(sessionStorage["redirect_uri"]);
	if(sessionStorage["redirect_uri"]!=null||sessionStorage["redirect_uri"]!=undefined||sessionStorage["redirect_uri"]!='')
	{
		window.location.href = sessionStorage["redirect_uri"];
	}
}

function toshowUserName()
{
	if (sessionStorage["name"] !=undefined && sessionStorage["name"] !=null && sessionStorage["name"] !="")
		{
			$("#sign_in").hide();
			$("#sign_up").hide();
			$("#userProfile").show();
			$("#userProfile").children().first().text("欢迎，" + sessionStorage["name"] + "!");
		}
	else
		{
			$("#userProfile").hide();
			$("#sign_in").show();
			$("#sign_up").show();
		}
}

function verifyToken()
{
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
			  		alert("check token Error");
		  		}
		});
	}
}




function getUserName()
{
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
			  			if(data==true)
			  			{
			  				
			  			}
			  			
			  			
		  			},
		  error: function()
		  		{
			  		alert("check token Error");
		  		}
		});
	}
}
