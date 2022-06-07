// https://data.calgary.ca/Services-and-Amenities/Waste-and-Recycling-Collection-Schedule/jq4t-b745

var xhr = new XMLHttpRequest;//XMLHTTPRequest object
var parsedrecord;//parsed JSON file
//load pageSetup
window.onload = pageSetup2;
var dropDownValues = [];
function pageSetup2() {

    //event listener
    document.getElementById("requestData21").addEventListener("keyup", function () { searchByPattern21(this.value); }, false);
    document.getElementById("requestData22").addEventListener("keyup", function () { searchByPattern22(this.value); }, false);
    document.getElementById("requestData23").addEventListener("change", function () { searchByPattern23(this.value); }, false);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            parsedrecord = JSON.parse(xhr.responseText);
            //displayData(r);
            setUpDropDown2();
        }
    };
    xhr.open("GET", " https://data.calgary.ca/resource/jq4t-b745.json", true);
    xhr.send();
    while(!xhr.readyState==4) {}
}


function setUpDropDown2(){
    dropDownValues.length=0;
    for (var i = 0; i < parsedrecord.length; i++){
        if(!dropDownValues.includes(parsedrecord[i].community)){
            dropDownValues.push(parsedrecord[i].community);
        }
    }
    dropDownValues.sort();
    var options="'<option value='Select'>Select</option>'";
    dropDownValues.forEach(element => {
        options+='<option value='+element+'>'+element+'</option>';
    });
    document.getElementById('requestData23').innerHTML = options;

}
function searchByPattern21(bp) {
    //set up table
    var output = "<tr><th>Address</th><th>Quadrant</th><th>Community</th><th>Collection Day</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.address;//assign
        if (permitnum.startsWith(bp.toUpperCase()))//partial match on string
        {
            output += "<tr><td>";
            output += record.address;
            output += "</td><td>"
            output += record.quadrant;
            output += "</td><td>";
            output += record.community;
            output += "</td><td>";
            output += record.collection_day;
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
    document.getElementById("data2Table").innerHTML = output;

}

function searchByPattern22(bp) {
    
    var output = "<tr><th>Address</th><th>Quadrant</th><th>Community</th><th>Collection Day</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.quadrant;//assign
        if (permitnum.startsWith(bp.toUpperCase()))//partial match on string
        {
            output += "<tr><td>";
            output += record.address;
            output += "</td><td>"
            output += record.quadrant;
            output += "</td><td>";
            output += record.community;
            output += "</td><td>";
            output += record.collection_day;
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
    document.getElementById("data2Table").innerHTML = output;

}

function searchByPattern23(bp) {
//set up table
var output = "<tr><th>Address</th><th>Quadrant</th><th>Community</th><th>Collection Day</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
var permitnum;
var gmap;//creates hyperlink
var position = "";
for (var i = 0; i < parsedrecord.length; i++) {
    var record = parsedrecord[i];
    //check
    permitnum = record.community;//assign
    if (permitnum.startsWith(bp.toUpperCase()))//partial match on string
    {
        output += "<tr><td>";
        output += record.address;
        output += "</td><td>"
        output += record.quadrant;
        output += "</td><td>";
        output += record.community;
        output += "</td><td>";
        output += record.collection_day;
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
document.getElementById("data2Table").innerHTML = output;

}

