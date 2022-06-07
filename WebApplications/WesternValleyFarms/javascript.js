function changeVisibilty(id){
    if(document.querySelector('input[id='+id+']:checked'))
    {
        document.getElementById(id+"_input").style.visibility="visible";
        document.getElementById(id+"_Add").style.visibility="visible";
        document.getElementById(id+"_Remove").style.visibility="visible";
   }else
    {
        document.getElementById(id+"_input").style.visibility='hidden';
        document.getElementById(id+"_Add").style.visibility="hidden";
        document.getElementById(id+"_Remove").style.visibility="hidden";
       }
}

function add(id){
    document.getElementById(id+"_input").value = parseInt(document.getElementById(id+"_input").value)+1;
    document.getElementById(id+"_value").innerHTML ="Item Value:$"+ parseInt(document.getElementById(id).value)*document.getElementById(id+"_input").value;
}

function remove(id){
    if(parseInt(document.getElementById(id+"_input").value)>0){
    document.getElementById(id+"_input").value = parseInt(document.getElementById(id+"_input").value)-1;
    document.getElementById(id+"_value").innerHTML ="Item Value:$"+ parseInt(document.getElementById(id).value)*document.getElementById(id+"_input").value;
}
}

function generateBill(){
    
    var formatedBill = "";
    var qty =0 ;
    var billValue = 0;
    if(document.querySelector('input[id=item1]:checked') && document.getElementById("item1_input").value >0){
        qty = document.getElementById("item1_input").value;
        billValue = billValue+qty*30;
        formatedBill = (formatedBill+"<tr id='billItem'><td>" +qty+ " Vegetable Hamper</td></tr>");
    }  if(document.querySelector('input[id=item2]:checked') &&document.getElementById("item2_input").value>0 ){
        qty = document.getElementById("item2_input").value;
        billValue = billValue+qty*20;
        formatedBill = (formatedBill+"<tr id='billItem'><td>" +qty+ " Fruit Hamper</td>  </tr>");
    }  if(document.querySelector('input[id=item3]:checked') && document.getElementById("item3_input").value >0){
        qty = document.getElementById("item3_input").value;
        billValue = billValue+qty*4;
        formatedBill = (formatedBill+"<tr id='billItem'><td>" +qty+ " Fresh Chicken </td></tr>");
    }  if(document.querySelector('input[id=item4]:checked') && document.getElementById("item4_input").value>0){
        qty = document.getElementById("item4_input").value;
        billValue = billValue+qty*5;
        formatedBill = (formatedBill+"<tr id='billItem'><td>" +qty+ " Pork</td></tr>");
    }
    var modeOfDelivery = document.getElementById('modeOfDelivery').value;
    
    document.getElementById("bill").innerHTML = '<table><tr><td>'+document.getElementById("name_input").value +'</td></tr><tr><td>'+
    document.getElementById("address_input").value + '</td><tr><td>'+
    modeOfDelivery + '<br><br></td></tr><tr id="billItem"><td>Order:'+
    formatedBill + '</td></tr><tr><td>Billing Amount:$'+billValue+ '</td></tr></table>';

}