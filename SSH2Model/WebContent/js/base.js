function sendJSONData() {

	var dataObj = {
		"data" : [ {
			"active" : "true",
			"color" : "orange",
			"date" : "2008-01-01",
			"id" : "1",
			"name" : "Chris"
		}, {
			"active" : "false",
			"color" : "blue",
			"date" : "2013-03-03",
			"id" : "2",
			"name" : "Kate"
		}, {
			"active" : "true",
			"color" : "black",
			"date" : "2013-05-03",
			"id" : "3",
			"name" : "Blade"
		}, {
			"active" : "false",
			"color" : "yellow",
			"date" : "2013-01-01",
			"id" : "4",
			"name" : "Zack"
		} ]
	};

	var data1 = JSON.stringify(dataObj);
	
	$.ajax({
		url : "json/writeJSON.action",
		data : data1,
		dataType : 'json',
		contentType : 'application/json',
		type : 'POST',
		async : true,
		success : function(res) {
			console.log(res.data.length);
			for(var i=0; i<res.data.length;i++){
				console.log(" "+res.data[i].name+"-"+res.data[i].id+"-"+res.data[i].active+"-"+res.data[i].date);
			}
		}
	});

	console.log("Quite Method ");
}


function getJSONData() {
	console.log("Read JSON Data");
	$.getJSON("readJSON.action", function(res) {
		console.log(res.data.length);
		for(var i=0; i<res.data.length;i++){
			console.log(" "+res.data[i].name+"-"+res.data[i].id+"-"+res.data[i].active+"-"+res.data[i].date);
		}
	});
	console.log("Method Over");

}