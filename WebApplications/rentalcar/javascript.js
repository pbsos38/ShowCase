
var date = new Date();
window.onload = setUp;
var columns = ['firstname', 'lastname', 'address', 'prov', 'phone', 'email', 'btnCompact', 'btnMidSize', 'btnLuxary', 'btnVan', 'noOfDays', 'check1', 'check2', 'check3', 'btnRent', 'btnClear'];
var xhr = new XMLHttpRequest();
var parsedrecord = [];
var dropDownValues = [];
var selectedItems = "";
function setUp() {
    changeAbility(false);
    loaddata();
}
function changeAbility(action) {
    if (action == false) {
        columns.forEach(element => {
            document.getElementById(element).disabled = true;
        });
    } else if (action == true) {
        columns.forEach(element => {
            document.getElementById(element).disabled = false;
        });
    }
}

function loaddata() {
    //event listener
    document.getElementById("searchLastname").addEventListener("keyup", function () { setElement(this.value) }, false);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            parsedrecord = JSON.parse(xhr.responseText);
        }
    };
    xhr.open("GET", "rentalclients.json", true);
    xhr.send();

}

function setElement(value) {

    var output = "<table><tr><th>Last Name</th><th>First Name</th></tr>";
    var data;
    for (var i = 0; i < parsedrecord.length; i++) {
        var obj = parsedrecord[i];
        data = obj.last_name;
        if (data.startsWith(value)) {
            output += '<tr><td onclick="changeAbility(true);setData(' + i + ')" style="cursor:pointer">' + obj.last_name + '</td><td> ' + obj.first_name + '</td></tr>'
        }

    }   
    document.getElementById("searchResults").innerHTML = output+'</table>';
}
function setData(val) {
    var obj = parsedrecord[val];
    document.getElementById("firstname").value = obj.first_name;
    document.getElementById("lastname").value = obj.last_name;
    document.getElementById("address").value = obj.address;
    document.getElementById("prov").value = obj.state_prov;
    document.getElementById("phone").value = obj.phone;
    document.getElementById("email").value = obj.email;
}

function chooseItem(data) {
    if (data == 'btnCompact') {
        selectedItems += "1,";
    } else if (data == 'btnMidSize') {
        selectedItems += "2,";
    } else if (data == 'btnLuxary') {
        selectedItems += "3,";
    } else if (data == 'btnVan') {
        selectedItems += "4";
    }
    document.getElementById(data).innerHTML = "Selected";
    document.getElementById(data).disabled = true;

}
function calc() {
    var output = "";
    var totalAmount = 0;
    var days = document.getElementById("noOfDays").value;
    if (days < 1 || days > 30) {
        alert("Please Choose days from 1 To 30");
        return;
    }
    output = document.getElementById("firstname").value + " " + document.getElementById("lastname").value + "<br>";
    output += document.getElementById("address").value + "<br>" + document.getElementById("prov").value + "<br>";
    output += document.getElementById("phone").value + "<br>" + document.getElementById("email").value + "<br>" + "<br>";
    if (selectedItems.includes('1')) {
        totalAmount += 15*days;
        output += "<tr><td>Compact Vehicle for " + days + " days </td><td>  $" + (days * 15) + "</td></tr>"
    }
    if (selectedItems.includes('2')) {
        totalAmount += 20*days;
        output += "<tr><td>Mid Size Vehicle for " + days + " days </td><td>  $" + (days * 20) + "</td></tr>"
    }
    if (selectedItems.includes('3')) {
        totalAmount += 35*days;
        output += "<tr><td>Luxury Vehicle for " + days + " days </td><td>  $" + (days * 35) + "</td></tr>"
    }
    if (selectedItems.includes('4')) {
        totalAmount += 40 *days;
        output += "<tr><td>Van/Truck Vehicle for " + days + " days </td><td>  $" + (days * 40) + "</td></tr>"
    }
    if (document.getElementById("check1").checked) {
        totalAmount += 5 *days;
        output += "<tr><td>Roof Rack or Bicycle Rack for " + days + " days </td><td>  $" + (days * 5) + "</td></tr>"
    }
    if (document.getElementById("check2").checked) {
        totalAmount += 10;
        output += "<tr><td> $10 for GPS System </td><td>$10</td></tr>"
    }
    if (document.getElementById("check3").checked) {

        output += "<tr><td>Free Child Seat</td><td>  $0</td></tr>"
    }
    output += "<tr><td>Total:</td><td>$" + (totalAmount) + "</td></tr>"
    document.getElementById("output").innerHTML = output + '';
}