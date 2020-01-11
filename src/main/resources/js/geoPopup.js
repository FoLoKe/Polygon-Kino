$(document).ready(function(){
     PopUpHide();
     lPopUpHide();
     rPopUpHide();
 });
 function PopUpSwitch(){
    rPopUpHide();
    lPopUpHide();
    if($("#geoPopup").is(":visible"))
        $("#geoPopup").hide();
    else
        $("#geoPopup").show();
 }
 function PopUpHide(){
     $("#geoPopup").hide();
 }

 function lPopUpSwitch(){
       rPopUpHide();
     if($("#loginPopup").is(":visible"))
         $("#loginPopup").hide();
     else
         $("#loginPopup").show();
 }
 function lPopUpHide(){
     $("#loginPopup").hide();
 }

  function rPopUpSwitch(){
      lPopUpSwitch();
      if($("#refundsPopup").is(":visible"))
          $("#refundsPopup").hide();
      else
          $("#refundsPopup").show();
  }
  function rPopUpHide(){
      $("#refundsPopup").hide();
  }