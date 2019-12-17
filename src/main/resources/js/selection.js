

//дожидаемся полной загрузки страницы
window.onload = function () {
    PopUpHide();
    //получаем идентификатор элемента
    //var userAttributes = model.get("purchaseInfo");
    var number = "[[${purchaseInfo.tel}]]";
    var message = "[[${message}]]";
    var a = document.querySelectorAll('.seat');
    var price = document.getElementById('price');

    [].forEach.call( a, function(el) {
        //вешаем событие
        if (el.attributes.value.value == 'false') {
            el.onclick = function(e) {
                var b = document.querySelectorAll('.sseat');

                if (this.attributes.value.value == 'false') {
                     if (b.length < 5) {
                         this.attributes.value.value = 'true';
                         this.className = 'sseat';

                     } else {
                         alert('5 билетов в 1 руки');
                     }
                } else {
                    this.attributes.value.value = 'false';
                    this.className = 'seat';
                }
                var b = document.querySelectorAll('.sseat');
                price.textContent = (b.length)*this.attributes.ticketPrice.value;
                return false;
            }
        }
        else
        el.className = 'hseat'
    });

    var a = document.getElementById('confirmBuy');

    var form = document.getElementById('infoForm');
            //вешаем на него событие
            a.onclick = function() {
                var b = document.querySelectorAll('.sseat');
                      if(b.length <= 5) {
                           if(b.length >= 1) {
                                var s = 'ticketsId=';
                                [].forEach.call( b, function(el) {
                                    s += el.attributes.ticket.value;
                                    s += '%20';
                                });
                                //a.href = '/buy' + "?byBalance=0&" + s;
                                form.action = '/selectSeat' + "?byBalance=0&" + s;
                                form.submit();
                           } else {
                                alert('выбирете места');
                                return false;
                           }
                      } else {
                            alert('перестаньте читерить');
                            return false;
                      }
            }
    var c = document.getElementById('confirmBalance');
    if(c!=null) {
            c.onclick = function() {
                            var b = document.querySelectorAll('.sseat');
                                  if(b.length <= 5) {
                                       if(b.length >= 1) {
                                            var s = 'ticketsId=';
                                            [].forEach.call( b, function(el) {
                                                s += el.attributes.ticket.value;
                                                s += '%20';
                                            });
                                            //a.href = '/buy' + "?byBalance=0&" + s;
                                            form.action = '/selectSeat' + "?byBalance=1&" + s;
                                            form.submit();
                                       } else {
                                            alert('выбирете места');
                                            return false;
                                       }
                                  } else {
                                        alert('перестаньте читерить');
                                        return false;
                                  }
               }
    }
}

function PopUpSwitch(){
    if($("#buyPopup").is(":visible"))
        $("#buyPopup").hide();
    else
        $("#buyPopup").show();
 }
 function PopUpHide(){
     $("#buyPopup").hide();
 }
