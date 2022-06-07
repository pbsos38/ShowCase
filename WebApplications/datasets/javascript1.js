

var xhr = new XMLHttpRequest;//XMLHTTPRequest object
var parsedrecord;//parsed JSON file
//load pageSetup
window.onload = pageSetup1;
var dropDownValues = [];
function pageSetup1() {

    //event listener
    document.getElementById("requestData11").addEventListener("keyup", function () { searchByPattern11(this.value); }, false);
    document.getElementById("requestData12").addEventListener("keyup", function () { searchByPattern12(this.value); }, false);
    document.getElementById("requestData13").addEventListener("change", function () { searchByPattern13(this.value); }, false);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            parsedrecord = JSON.parse(xhr.responseText);
            setUpDropDown1();
        }
    };
    xhr.open("GET", " https://data.calgary.ca/resource/848s-4m4z.json", true);
    xhr.send();
    while (!xhr.readyState == 4) { }
}
var s = {
    "sector": "NORTH",
    "community_name": "THORNCLIFFE",
    "group_category": "Crime",
    "category": "Theft FROM Vehicle",
    "count": "9", "resident_count": "8474",
    "date": "2018-03-01T12:00:00.000",
    "year": "2018",
    "month": "MAR",
    "id": "2018-MAR-THORNCLIFFE-Theft FROM Vehicle-9",
    "geocoded_column": {
        "latitude": "51.103099554741",
        "longitude": "-114.068779421169",
        "human_address": "{\"address\": \"\", \"city\": \"\", \"state\": \"\", \"zip\": \"\"}"
    },
    ":@computed_region_4a3i_ccfj": "2",
    ":@computed_region_p8tp_5dkv": "4",
    ":@computed_region_4b54_tmc4": "2",
    ":@computed_region_kxmf_bzkv": "192"
};

function setUpDropDown1() {
    dropDownValues.length=0;
    for (var i = 0; i < parsedrecord.length; i++) {
        if (!dropDownValues.includes(parsedrecord[i].year)) {
            dropDownValues.push(parsedrecord[i].year);
        }
    }

    var options = "'<option value='Select'>Select</option>'";
    dropDownValues.forEach(element => {
        options += '<option value=' + element + '>' + element + '</option>';
    });
    document.getElementById('requestData13').innerHTML = options;
}
function searchByPattern11(bp) {
    //set up table
    var output = "<tr><th>Sector</th><th>Community Name</th><th>Group Category</th><th>Category</th><th>Year</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.sector;//assign
        if (permitnum.startsWith(bp.toUpperCase()))//partial match on string
        {
            output += "<tr><td>";
            output += record.sector;
            output += "</td><td>"
            output += record.community_name;
            output += "</td><td>";
            output += record.group_category;
            output += "</td><td>";
            output += record.category;
            output += "</td><td>";
            output += record.year;
            output += "</td><td>";
            output += record.geocoded_column.latitude;
            //add latitude to postition
            position = record.geocoded_column.latitude;
            position += ","
            output += "</td><td>";
            output += record.geocoded_column.longitude;
            //add longitude to position
            position += record.geocoded_column.longitude;
            output += "</td><td>";
            //create hyperlink gmap
            gmap = "<a href=https://www.google.com/maps/search/?api=1&query=" + position + " target=_blank>Click here to see map</a> ";


            output += gmap;

            output += "</td></tr>";
        }
    }
    document.getElementById("data1Table").innerHTML = output;

}

function searchByPattern12(bp) {
    //set up table
    var output = "<tr><th>Sector</th><th>Community Name</th><th>Group Category</th><th>Category</th><th>Year</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.community_name;//assign
        if (permitnum.startsWith(bp))//partial match on string
        {
            output += "<tr><td>";
            output += record.sector;
            output += "</td><td>"
            output += record.community_name;
            output += "</td><td>";
            output += record.group_category;
            output += "</td><td>";
            output += record.category;
            output += "</td><td>";
            output += record.year;
            output += "</td><td>";
            output += record.geocoded_column.latitude;
            //add latitude to postition
            position = record.geocoded_column.latitude;
            position += ","
            output += "</td><td>";
            output += record.geocoded_column.longitude;
            //add longitude to position
            position += record.geocoded_column.longitude;
            output += "</td><td>";
            //create hyperlink gmap
            gmap = "<a href=https://www.google.com/maps/search/?api=1&query=" + position + " target=_blank>Click here to see map</a> ";


            output += gmap;

            output += "</td></tr>";
        }
    }
    document.getElementById("data1Table").innerHTML = output;

}

function searchByPattern13(bp) {
    //set up table
    var output = "<tr><th>Sector</th><th>Community Name</th><th>Group Category</th><th>Category</th><th>Year</th><th>Latitude</th><th>Longitude</th><th>View on Google Maps</th></tr>";
    var permitnum;
    var gmap;//creates hyperlink
    var position = "";
    for (var i = 0; i < parsedrecord.length; i++) {
        var record = parsedrecord[i];
        //check
        permitnum = record.year;//assign
        if (permitnum.startsWith(bp))//partial match on string
        {
            output += "<tr><td>";
            output += record.sector;
            output += "</td><td>"
            output += record.community_name;
            output += "</td><td>";
            output += record.group_category;
            output += "</td><td>";
            output += record.category;
            output += "</td><td>";
            output += record.year;
            output += "</td><td>";
            output += record.geocoded_column.latitude;
            //add latitude to postition
            position = record.geocoded_column.latitude;
            position += ","
            output += "</td><td>";
            output += record.geocoded_column.longitude;
            //add longitude to position
            position += record.geocoded_column.longitude;
            output += "</td><td>";
            //create hyperlink gmap
            gmap = "<a href=https://www.google.com/maps/search/?api=1&query=" + position + " target=_blank>Click here to see map</a> ";


            output += gmap;

            output += "</td></tr>";
        }
    }
    document.getElementById("data1Table").innerHTML = output;

}

