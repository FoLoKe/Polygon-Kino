$(document).ready(function(){
     $("#cpswErr").hide();
 });
 function check(){
    if($("#psw").val() == $("#cpsw").val())
        $("#reg").submit();
    else
        $("#cpswErr").show();
 }