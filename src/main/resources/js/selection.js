
//дожидаемся полной загрузки страницы
window.onload = function () {

    //получаем идентификатор элемента
    var a = document.querySelectorAll('.seat');

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
                return false;
            }
        }
        else
        el.className = 'hseat'
    });

    var a = document.getElementById('buy');

            //вешаем на него событие
            a.onclick = function() {
                var b = document.querySelectorAll('.sseat');
                      if(b.length <= 5) {
                           if(b.length >= 1) {
                                var s = '?ticketsId=';
                                [].forEach.call( b, function(el) {
                                    s += el.attributes.ticket.value;
                                    s += '%20';
                                });
                                a.href = '/buy' + s;
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
