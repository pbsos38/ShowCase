//using ajax to retrieve content of web page
//based on example page 578 Internet and world wide web by Deitel et al


window.addEventListener("load", registerListeners, false);
var asynchrequest;

function registerListeners() {
	getContent("data1.html");
	var img;
	getContent('dataset1.html');
	img=document.getElementById("item1");
	img.addEventListener("click", function () {getContent("dataset1.html");}, false);
	img=document.getElementById("item2");
	img.addEventListener("click", function () { getContent("dataset2.html");}, false);
	img=document.getElementById("item3");
	img.addEventListener("click", function () {  getContent("dataset3.html");}, false);
	img=document.getElementById("item4");
	img.addEventListener("click", function () {  getContent("dataset4.html");}, false);
	
}

function getContent(infopage) {
	clearSearchResults();

		asynchrequest= new XMLHttpRequest();
		asynchrequest.onreadystatechange = function() {
    if (asynchrequest.readyState == 4 && asynchrequest.status == 200) {
      document.getElementById("subView").innerHTML = asynchrequest.responseText;
        if(infopage=="dataset1.html") {
			setTimeout(pageSetup1(), 1000);
		}
        else if(infopage=="dataset2.html") {
			setTimeout(pageSetup2(), 1000);
		}
        else if(infopage=="dataset3.html")
		    setTimeout(pageSetup3(), 1000);
        else
            setTimeout(pageSetup4(), 1000);
        
    }   
  };
  asynchrequest.open("GET", infopage, true);
  asynchrequest.send();
}


function clearSearchResults() {
	
	document.getElementById("data1Table").innerHTML="";
	document.getElementById("data2Table").innerHTML="";
	document.getElementById("data3Table").innerHTML="";
	document.getElementById("data4Table").innerHTML="";

}