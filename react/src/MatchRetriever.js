$(document).ready(function() {

	$("#lookupButton").on('click', lookup());
	$("#lunchUpButton").on('click', findMatches());

	function lookup(lanID) {
		//e.stopPropagation();
		var lanID = document.URL.substring(document.URL.length - 5, document.URL.length);
		var url = "http://localhost:8080/GetUserInfo?lanID=" + lanID;
		$.ajax({ 
			type: "GET",
			dataType: "json",
			url: url,
			success: function(data){        
			  console.log("Data: " + data);
			}
		 });
		 
		 

		console.log("lanID: " + lanID);
	}
	
		function findMatches(lanID) {
		//e.stopPropagation();
		var lanID = document.URL.substring(29, 34);
		var url = "http://localhost:8080/FindMatches?lanID=" + lanID;
		$.ajax({ 
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			type: "POST",
			dataType: "json",
			data: 
			JSON.stringify({
   				 "lanID": lanID,
    			"firstName": "Bill",
    			"lastName": "Murray",
    			"availableDays": [
			        "2018-06-15",
			        "2018-06-18"
    			]
			}),
			url: url,
			success: function(data){     
			  $("#lanID").val(data.currentUserInfo.landId);  
			  var matches = "We have found the following matches: \n";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[0]][0].firstName + " ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[0]][0].lastName + ": "
			  matches += Object.keys(data.matchesByDate)[0] + " - ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[0]][0].email + "\n"
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[1]][0].firstName + " ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[1]][0].lastName + ": ";
			  matches += Object.keys(data.matchesByDate)[1] + " - ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[1]][0].email + "\n"
			  var finalText = $("#matchContent").text(matches); 
			  finalText.html(finalText.html().replace(/\n/g,'<br/>'));
			  console.log("Data: " + data);
			}
		 });
		 
		 

		console.log("lanID: " + lanID);
	}

});