"use strict";
//request uri


const localStorage = window.localStorage;
const api_verifyToken = "/api/verifyToken";
const api_signup = "/api/signup";
const api_signin = "/api/signin";

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



if(localStorage != null)
{
	$ajax({
		async: false,
		  type: 'POST',
		  url: api_verifyToken,
		  dataType: 'json',
		  contentType: "application/json;charset=utf-8",
		  data: 
		  {
			  "token": localStorage["token"],  
		  },
		  success: function(data)
		  			{
			  			alert("verified");
		  			},
		  error: function()
			  		{
				  		alert("Error");
			  		}		
		});
}

