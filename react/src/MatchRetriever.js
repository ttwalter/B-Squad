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
		var date1 = document.URL.substring(document.URL.indexOf("date1") + 6, document.URL.indexOf("date1") + 16);
		var date2 = document.URL.substring(document.URL.indexOf("date2") + 6, document.URL.indexOf("date2") + 16);
		var date3 = document.URL.substring(document.URL.indexOf("date3") + 6, document.URL.indexOf("date3") + 16);
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
    			"availableDays": [
			        date1,
			        date2,
			        date3
    			]
			}),
			url: url,
			success: function(data){     
			  $("#lanID").val(data.currentUserInfo.landId);  
			  
			  $("#firstName").val(data.currentUserInfo.firstName);  
			  $("#lastName").val(data.currentUserInfo.lastName);  
			  $("#dept").val(data.currentUserInfo.department);  
			  $("#team").val(data.currentUserInfo.team);  
			  
			  var matches = "We have found the following matches: \n";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[0]].firstName + " ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[0]].lastName + ": "
			  matches += Object.keys(data.matchesByDate)[0] + " - ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[0]].email + "\n"
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[1]].firstName + " ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[1]].lastName + ": ";
			  matches += Object.keys(data.matchesByDate)[1] + " - ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[1]].email + "\n"
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[2]].firstName + " ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[2]].lastName + ": ";
			  matches += Object.keys(data.matchesByDate)[2] + " - ";
			  matches += data.matchesByDate[Object.keys(data.matchesByDate)[2]].email + "\n"
			  
			  var finalText = $("#matchContent").text(matches); 
			  finalText.html(finalText.html().replace(/\n/g,'<br/>'));
			  console.log("Data: " + data);  
			}
		 });
		 
		 

		console.log("lanID: " + lanID);
	}

});