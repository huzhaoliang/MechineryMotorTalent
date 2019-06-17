"use strict";
//varible


//const



//function

function getAdvertisement()
{
	//alert("ad");

}


function getHotJobs()
{
	$.ajax({
		  async: false,
		  type: 'GET',
		  url: api_hotJobs,
		  dataType: 'json',
		  //contentType: "application/json;charset=utf-8",
		  success: function(data)
		  			{
			  			console.log(data);
			  			
			  			
		  			},
		  error: function(data)
		  		{
			  		alert(data);
			  		alert("查询数据为空");
		  		}
		});
}


function getCompanyInfo()
{
	
	//alert("comp info");
}
