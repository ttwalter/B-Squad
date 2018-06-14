$(document).ready(function() {

	$("#lookupButton").on('click', lookup());

	function lookup(lanID) {
		//e.stopPropagation();
		var lanID = document.URL.substring(document.URL.length - 5, document.URL.length);
		var url = "http://localhost:8080/FindExistingMatches?lanID=" + lanID;
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

});