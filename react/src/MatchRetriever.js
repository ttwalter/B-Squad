function lookup() {
    	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("firstname").innerHTML = this.responseText;
		}
	};
    	xhttp.open("GET", "/FindExistingMatches?lanID="+lanID, true);
    	xhttp.send();
    	var response = JSON.parse(xhttp.responseText);
}