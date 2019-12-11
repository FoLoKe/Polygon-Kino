$(document).ready(function(){
     PopUpHide();
     lPopUpHide();
 });
 function PopUpSwitch(){
    if($("#geoPopup").is(":visible"))
        $("#geoPopup").hide();
    else
        $("#geoPopup").show();
 }
 function PopUpHide(){
     $("#geoPopup").hide();
 }

 function lPopUpSwitch(){
     if($("#loginPopup").is(":visible"))
         $("#loginPopup").hide();
     else
         $("#loginPopup").show();
 }
 function lPopUpHide(){
     $("#loginPopup").hide();
 }