function lookup() {

	var xhttp = new XMLHttpRequest();
	
	xhttp.onerror = function() {
		console.log("Error");
	};
	
	function ProcessRequest() 
	{
	    if (this.readyState == 4 && this.status == 200) {
            console.log("Response: " + this.responseText);
       }
	}
	
	var lanID = document.getElementById("lanID").value;
	var url = "http://localhost:8080/FindExistingMatches?lanID=" + lanID;
    xhttp.open("GET", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    //xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    //xhttp.setRequestHeader("Access-Control-Allow-Methods", "GET");
    //xhttp.setRequestHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,Accept,Origin,Referer,User-Agent");
    
    xhttp.onreadystatechange = ProcessRequest;
    xhttp.send();
    
}