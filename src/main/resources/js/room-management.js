var d = document;

function addRow()
{

    // Находим нужную таблицу
    var tbody = d.getElementById('rowsTable').getElementsByTagName('TBODY')[0];

    // Создаем строку таблицы и добавляем ее
    var row = d.createElement("TR");
    tbody.appendChild(row);

    var rc = d.getElementById('rowsCount').value = tbody.rows.length - 1;
    // Создаем ячейки в вышесозданной строке
    // и добавляем тх
    var td1 = d.createElement("TD");

    var b1 = d.createElement("a");
    b1.className="management-text";
    b1.innerHTML="+";

    var b2 = d.createElement("a");
    b2.className="management-text";
    b2.innerHTML="-";

    row.appendChild(td1);

    td1.appendChild(b1);
    td1.appendChild(b2);

    var rc = document.createElement('input');
                                 rc.type = "hidden";
                                 rc.name = "seatsCount";
                                 rc.value = 0;
                                 rc.id = "id";
    td1.appendChild(rc)

    td1.row-number = (tbody.rows.length - 1);
    b1.addEventListener("click", function(me) {
        rc.value = td1.childElementCount - 2;
        var first = b1;
        var div = document.createElement('div');
        div.style.display = "inline-flex";
        var checkbox = document.createElement('input');
                    checkbox.type = "checkbox";
                    checkbox.name = "seat";
                    checkbox.value = td1.row-number + " " + (td1.childElementCount - 2);
                    checkbox.id = "id";
        var label = document.createElement('label');
        label.innerText  = "" + (td1.childElementCount - 2);

        div.appendChild(label);
        div.appendChild(checkbox);
        first.parentNode.insertBefore(div, first);
    });

    b2.addEventListener("click", function(me) {

        var first = b1;
        if(b1.previousSibling!=null)
            b1.previousSibling.remove();
        rc.value = td1.childElementCount - 3;
    });
}

function delRow() {
    var tbody = d.getElementById('rowsTable').getElementsByTagName('TBODY')[0];
    tbody.removeChild(tbody.lastChild);
    var rc = d.getElementById('rowsCount').value = tbody.rows.length - 1;
}
