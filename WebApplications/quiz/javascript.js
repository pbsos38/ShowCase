window.onload=getXMLFile;
var ans;
var totalScore=0;
function getXMLFile() {
	var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      processXML(xhr);
    }
  };
  xhr.open("GET", "finalquiz.xml", true);
  xhr.send();
	
}

function processXML(xhr) {

var i;
var xmldoc = xhr.responseXML;

var question='<table style="text-align:left">';
var x = xmldoc.getElementsByTagName("question");
  for (i = 0; i <x.length; i++) { 
      var aop=x[i].getElementsByTagName("a")[0].childNodes[0].nodeValue ;
      var bop=x[i].getElementsByTagName("b")[0].childNodes[0].nodeValue ;
      var cop=x[i].getElementsByTagName("c")[0].childNodes[0].nodeValue ;
      var dop=x[i].getElementsByTagName("d")[0].childNodes[0].nodeValue ;
    question += "<tr><th>" +
    x[i].getElementsByTagName("qnumber")[0].childNodes[0].nodeValue + "). " + x[i].getElementsByTagName("qtitle")[0].childNodes[0].nodeValue +
    '</th></tr><tr><td><input type="radio" name="ques'+(i+1)+'" id="a'+(i+1)+'" value="'+aop+'"><label for="'+aop+'">'+aop+'</label> ' +
    '</td></tr><tr><td><input type="radio" name="ques'+(i+1)+'" id="b'+(i+1)+'" value="'+bop+'"><label for="'+bop+'">'+bop+'</label> ' +
    '</td></tr><tr><td><input type="radio" name="ques'+(i+1)+'" id="c'+(i+1)+'" value="'+cop+'"><label for="'+cop+'">'+cop+'</label> ' +
    '</td></tr><tr><td><input type="radio" name="ques'+(i+1)+'" id="d'+(i+1)+'" value="'+dop+'"><label for="'+dop+'">'+dop+'</label> ' +
    '</td></tr>';
  }
  ans= (xmldoc.getElementsByTagName("rightanswers")[0].childNodes[0].nodeValue).split(',');
  document.getElementById("parsedxml").innerHTML = question+"</table>";

}
function calculate(){    
    for(var j=0;j<ans.length;j++){
        var correctOption=ans[j];
        var selectedOption="";
        if(document.querySelector('input[id="a'+(j+1)+'"]:checked'))
            selectedOption="a";
        else if(document.querySelector('input[id="b'+(j+1)+'"]:checked'))
            selectedOption="b";
        else if(document.querySelector('input[id="c'+(j+1)+'"]:checked'))
            selectedOption="c";
        else if(document.querySelector('input[id="d'+(j+1)+'"]:checked'))
            selectedOption="d";

        if(correctOption==selectedOption)   
            totalScore++;
    }
    document.getElementById('btn').disabled=true;
    document.getElementById('marks').innerHTML='Marks You Scored: '+totalScore;
}
