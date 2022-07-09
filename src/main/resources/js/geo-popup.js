$(document).ready(function(){
     PopUpHide();
     lPopUpHide();
     rPopUpHide();
 });
 function PopUpSwitch(){
    rPopUpHide();
    lPopUpHide();
    if($("#geo-popup").is(":visible"))
        $("#geo-popup").hide();
    else
        $("#geo-popup").show();
 }
 function PopUpHide(){
     $("#geo-popup").hide();
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