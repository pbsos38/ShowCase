// https://data.calgary.ca/Health-and-Safety/Calgary-Police-Service-Office-Locations/ap4r-bav3

var xhr = new XMLHttpRequest;//XMLHTTPRequest object
var parsedrecord;//parsed JSON file
//load pageSetup
window.onload = pageSetup4;
var dropDownValues = [];
function pageSetup4() {

    //event listener
    document.getElementById("requestData41").addEventListener("keyup", function () { searchByPattern41(this.value); }, false);
    document.getElementById("requestData42").addEventListener("keyup", function () { searchByPattern42(this.value); }, false);
    document.getElementById("requestData43").addEventListener("keyup", function () { searchByPattern43(this.value); }, false);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            parsedrecord = JSON.parse(xhr.responseText);
        }
    };
    xhr.open("GET", " https://data.calgary.ca/resource/ap4r-bav3.json", true);
    xhr.send();
    while(!xhr.readyState==4) {}
}
var s = {
            "name":"AIRPORT OFFICE",
            "station_ty":"COPS Stn.",
            "address":"2000 AIRPORT RD NE",
            "info":"(403)735-1200",
            "latitude":"51.134558527481666",
            "longitude":"-114.01152041826636",
            "location":
                {"latitude":"51.134558527481666",
                "longitude":"-114.01152041826636",
                "human_address":"{\"address\": \"\", \"city\": \"\", \"state\": \"\", \"zip\": \"\"}"
            },
            ":@computed_region_4a3i_ccfj":"4",
            ":@computed_region_4b54_tmc4":"11",
            ":@computed_region_kxmf_bzkv":"86",
            ":@computed_region_hq2j_w7j9":"226"
        };

function searchByPattern41(bp) {
    //set up table
    var output = "<tr><th>Name</th><th>Station Name</th><th>Address</th><th>Info</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.name;//assign
        if (permitnum.startsWith(bp.toUpperCase()))//partial match on string
        {
            output += "<tr><td>";
            output += record.name;
            output += "</td><td>"
            output += record.station_ty;
            output += "</td><td>";
            output += record.address;
            output += "</td><td>";
            output += record.info;
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
    document.getElementById("data4Table").innerHTML = output;

}

function searchByPattern42(bp) {
    //set up table
    var output = "<tr><th>Name</th><th>Station Name</th><th>Address</th><th>Info</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
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
            output += record.name;
            output += "</td><td>"
            output += record.station_ty;
            output += "</td><td>";
            output += record.address;
            output += "</td><td>";
            output += record.info;
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
    document.getElementById("data4Table").innerHTML = output;

}

function searchByPattern43(bp) {
    //set up table
    var output = "<tr><th>Name</th><th>Station Name</th><th>Address</th><th>Info</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.info;//assign
        if (permitnum.startsWith(bp.toUpperCase()))//partial match on string
        {
            output += "<tr><td>";
            output += record.name;
            output += "</td><td>"
            output += record.station_ty;
            output += "</td><td>";
            output += record.address;
            output += "</td><td>";
            output += record.info;
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
    document.getElementById("data4Table").innerHTML = output;

}


