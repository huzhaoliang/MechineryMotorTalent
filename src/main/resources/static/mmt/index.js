"use strict";
//varible


//const



//function
function getHotJobs()
{
	$.ajax({
		  async: false,
		  type: 'GET,
		  url: api_getHotJobs,
		  dataType: 'json',
		  //contentType: "application/json;charset=utf-8",
		  
		  success: function(data)
		  			{
			  			
			  			
		  			},
		  error: function()
		  		{
			  		alert("查询数据为空");
		  		}
		});
}



