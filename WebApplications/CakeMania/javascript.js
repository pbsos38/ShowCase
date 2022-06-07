var type = "";
window.addEventListener("load", registerListeners, false);
var asynchrequest;
var dimensions = "";
var totalCost=0;
var position=1;
var images = ['https://lh3.googleusercontent.com/proxy/YcvLaj1aBF0vPiVK_Wp86hAuhe08310EbX1Bv-0jLpf5KeO5iOONy-hn8HVKU7wAvNfBHkg_OYIkb9YAguS7MZ_iFnKDp6TkkIQVOCOUpKsZRORKU0chs9qYm9gUx95wV3q801hq4M24ezXIOT_xtE56NL-sgWaIhSAOpw',
                'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSugFowZp8ikUva93gDtTj1CCAuOnAxtX1SXin0kURvI2MG6qESLi4S4Vjw3tm-BtbYjF4&usqp=CAU',
                'https://static.thenounproject.com/png/634271-200.png','https://static.thenounproject.com/png/405751-200.png'];
var captions = ['Square/Rectangular Cubes','Flat bottomed cylinders','½ Spherical','Truncated cone'];

function registerListeners() {	
    var img;
    img=document.getElementById("squarebtn");
    img.addEventListener("click", function () {type = "Square/Rectangular Cubes"; getContent("cube.html");}, false);
    img=document.getElementById("cylinderbtn");
    img.addEventListener("click", function () {type = "Flat bottomed cylinders"; getContent("cylinder.html");}, false);
    img=document.getElementById("spherebtn");
    img.addEventListener("click", function () {type = "Spherical"; getContent("sphere.html");}, false);
    img=document.getElementById("conebtn");
    img.addEventListener("click", function () {type = "Truncated cone"; getContent("truncatedCone.html");}, false);
    img=document.getElementById("BackArrow");
    img.addEventListener("click", function () {position--,setCard(position);}, false);
    img=document.getElementById("NextArrow");
    img.addEventListener("click", function () {position++,setCard(position);}, false);
    setCard(position);
}

function getContent(infopage) {
    document.getElementById("elementCard").style.display = 'none';
    document.getElementById("results").style.display = 'block';
    asynchrequest= new XMLHttpRequest();
    asynchrequest.onreadystatechange = function() {
    if (asynchrequest.readyState == 4 && asynchrequest.status == 200) {
        document.getElementById("add").innerHTML = asynchrequest.responseText;
        }
    };
    asynchrequest.open("GET", infopage, true);
    asynchrequest.send();
}

function clearContent() {
    document.getElementById("results").style.display='none';
    document.getElementById("elementCard").style.display='block';
}

function setCard(pos){
    if(position>captions.length){
        pos = position = 1;
    }
    if(position<=0){
        pos = position =  captions.length;
    }
    document.getElementById("resourcePic").src = images[pos-1]
    document.getElementById("resourceCaptions").innerHTML = captions[pos-1]
    // document.querySelector.id = images[pos]
    if(pos==1){
        document.getElementById("squarebtn").style.display="block";
        document.getElementById("cylinderbtn").style.display="none";
        document.getElementById("spherebtn").style.display="none";
        document.getElementById("conebtn").style.display="none";
    } else if(pos==2){
        document.getElementById("squarebtn").style.display="none";
        document.getElementById("cylinderbtn").style.display="block";
        document.getElementById("spherebtn").style.display="none";
        document.getElementById("conebtn").style.display="none";
    } else if(pos==3){
        document.getElementById("squarebtn").style.display="none";
        document.getElementById("cylinderbtn").style.display="none";
        document.getElementById("spherebtn").style.display="block";
        document.getElementById("conebtn").style.display="none";
    }else if(pos==4){
        document.getElementById("squarebtn").style.display="none";
        document.getElementById("cylinderbtn").style.display="none";
        document.getElementById("spherebtn").style.display="none";
        document.getElementById("conebtn").style.display="block";
    }
}

function generateResult(){
    var calculatedVolume = 0;
    if(type==="Square/Rectangular Cubes"){
        calculatedVolume = cube();
        totalCost = (calculatedVolume*0.001).toFixed(2);
    }else if(type==="Flat bottomed cylinders"){
        calculatedVolume = cylinder();
        totalCost = (calculatedVolume*0.0012).toFixed(2);
    }else if(type==="Spherical"){
        calculatedVolume = sphere();
        totalCost = (calculatedVolume*0.0015).toFixed(2);
    }else{
        calculatedVolume = cone();
        totalCost = (calculatedVolume*0.002).toFixed(2);
    }

    document.getElementById("output").innerHTML = '<table style="text-align:left"><tr><th>'+document.getElementById("FirstnameInput").value + " " +document.getElementById("LastnameInput").value +'</th></tr><tr><th>'+
    document.getElementById("addressInput").value + '</th></tr><tr><th>'+
    document.getElementById("postalCodeInput").value + '</th></tr><tr><th>'+
    document.getElementById("phoneInput").value + '</th></tr><tr><th>'+
    document.getElementById("emailInput").value + '</th></tr><tr><th></th></tr><tr><th><br>Type of Planter:</th><th><br>'+
    type + '</th></tr><tr><th>Dimensions and Volume:</th><th>'+dimensions+" And "+calculatedVolume+' &#13220;'+'</th></tr><tr><th>Total Cost:</th><th>$'+totalCost+'</th></tr></table>';
}

function cube(){
    var result = 0;
    var input1 = document.getElementById("length_cube").value;
    var input2 = document.getElementById("width_cube").value;
    var input3 = document.getElementById("height_cube").value;
    result = (input1*input2*input3).toFixed(2);
    dimensions = input1+"*"+input2+"*"+input3;
    return result;    
}
function cylinder(){
    var result = 0;
    var input1 = document.getElementById("radius_cylinder").value;
    var input2 = document.getElementById("height_cylinder").value;
    result = (3.14*input1*input1*input2).toFixed(2);
    dimensions = input1+"*"+input2;
    return result;    
    
}
function sphere(){
    var result = 0;
    var input1 = document.getElementById("radius_sphere").value;
    result = (0.5*(1.33*3.14*input1*input1*input1)).toFixed(2);
    dimensions = input1;
    return result;    
    
}
function cone(){
    var result = 0;
    var input1 = document.getElementById("radius1_cone").value;
    var input2 = document.getElementById("radius2_cone").value;
    var input3 = document.getElementById("height_cone").value;
    result = (0.33*3.14*(input1*input1+input1*input2+input2*input2)*input3).toFixed(2);
    dimensions = input1+"*"+input2+"*"+input3;
    return result;    
    
}