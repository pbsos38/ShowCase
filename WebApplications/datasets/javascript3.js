// https://data.calgary.ca/Services-and-Amenities/School-Locations/fd9t-tdn2

var xhr = new XMLHttpRequest;//XMLHTTPRequest object
var parsedrecord;//parsed JSON file
//load pageSetup
window.onload = pageSetup3;
var dropDownValues = [];
function pageSetup3() {

    //event listener
    document.getElementById("requestData31").addEventListener("keyup", function () { searchByPattern31(this.value); }, false);
    document.getElementById("requestData32").addEventListener("keyup", function () { searchByPattern32(this.value); }, false);
    document.getElementById("requestData33").addEventListener("keyup", function () { searchByPattern33(this.value); }, false);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            parsedrecord = JSON.parse(xhr.responseText);
        }
    };
    xhr.open("GET", "https://data.calgary.ca/resource/fd9t-tdn2.json", true);
    xhr.send();
    while(!xhr.readyState==4) {}
}
function searchByPattern31(bp) {
    //set up table
    var output = "<tr><th>School Name</th><th>Education Board</th><th>Address</th><th>Grade</th><th>type</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.name;//assign
        if (permitnum!=undefined && permitnum.startsWith(bp))//partial match on string
        {
            output += "<tr><td>";
            output += record.name_ab;
            output += "</td><td>"
            output += record.board;
            output += "</td><td>";
            output += record.address_ab+" "+record.city+" "+record.province;
            output += "</td><td>";
            output += record.grades;
            output += "</td><td>";
            output += record.type;
            output += "</td><td>";
            output += record.latitude;
            //add latitude to postition
            position = record.latitude;
            position += ","
            output += "</td><td>";
            output += record.longitude;
            //add longitude to position
            position += record.longitude;
            output += "</td><td>";
            //create hyperlink gmap
            gmap = "<a href=https://www.google.com/maps/search/?api=1&query=" + position + " target=_blank>Click here to see map</a> ";


            output += gmap;

            output += "</td></tr>";
        }
    }
    document.getElementById("data3Table").innerHTML = output;

}


function searchByPattern32(bp) {
    //set up table
    var output = "<tr><th>School Name</th><th>Education Board</th><th>Address</th><th>Grade</th><th>type</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        permitnum = record.board;//assign
        // alert(permitnum);
        if (permitnum!=undefined &&  permitnum.startsWith(bp))//partial match on string
        {
            output += "<tr><td>";
            output += record.name_ab;
            output += "</td><td>"
            output += record.board;
            output += "</td><td>";
            output += record.address_ab+" "+record.city+" "+record.province;
            output += "</td><td>";
            output += record.grades;
            output += "</td><td>";
            output += record.type;
            output += "</td><td>";
            output += record.latitude;
            //add latitude to postition
            position = record.latitude;
            position += ","
            output += "</td><td>";
            output += record.longitude;
            //add longitude to position
            position += record.longitude;
            output += "</td><td>";
            //create hyperlink gmap
            gmap = "<a href=https://www.google.com/maps/search/?api=1&query=" + position + " target=_blank>Click here to see map</a> ";
            output += gmap;

            output += "</td></tr>";
        }
    }
    document.getElementById("data3Table").innerHTML = output;

}


function searchByPattern33(bp) {
    //set up table
    var output = "<tr><th>School Name</th><th>Education Board</th><th>Address</th><th>Grade</th><th>type</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.type;//assign
        if (permitnum!=undefined && permitnum.startsWith(bp))//partial match on string
        {
            output += "<tr><td>";
            output += record.name_ab;
            output += "</td><td>"
            output += record.board;
            output += "</td><td>";
            output += record.address_ab+" "+record.city+" "+record.province;
            output += "</td><td>";
            output += record.grades;
            output += "</td><td>";
            output += record.type;
            output += "</td><td>";
            output += record.latitude;
            //add latitude to postition
            position = record.latitude;
            position += ","
            output += "</td><td>";
            output += record.longitude;
            //add longitude to position
            position += record.longitude;
            output += "</td><td>";
            //create hyperlink gmap
            gmap = "<a href=https://www.google.com/maps/search/?api=1&query=" + position + " target=_blank>Click here to see map</a> ";


            output += gmap;

            output += "</td></tr>";
        }
    }
    document.getElementById("data3Table").innerHTML = output;

}


