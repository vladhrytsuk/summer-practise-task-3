orderArray = [];
var successRowIndex = 0;

/*function showOrder()
{
    $.ajax({
        url: '/order',
        type: 'GET',
        contentType: 'application/json',
        success: function(data)
        {
            for (var i = 0; i < data.length; ++i)
            {
                orderArray[i] = data[i];
                addRow('OrderDataTable', data[i]);
            }
        }
    });
}*/

function addToTable(){

    var username = $('#username').val();
    var carId = $('#carId').val();
    var breaking = $('#breaking').val();

    $.ajax({
            url: '/order/add',
            type: 'POST',
            contentType : 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                    'username': username,
                    'carId': carId,
                    'breaking': breaking
                }),
            success: function(data){
                orderArray.push(data);
                addRow('OrderDataTable', data);
                clearAddInput();
            },
            error: function (data){
                alert("Ошибка на сервере!");
            }
        }
    );
}

function addRow(tableID, data){
    var tableElem = document.getElementById(tableID);
    var newRow = tableElem.insertRow(-1);
    newRow.className = "text-center";

    addCol(newRow, 0, data.orderId);
    addCol(newRow, 1, data.username);
    addCol(newRow, 2, data.mark);
    addCol(newRow, 3, data.color);
    addCol(newRow, 4, data.vin);
    addCol(newRow, 5, data.miles);
    addCol(newRow, 6, data.breaking);
    addCol(newRow, 7, data.status);

    var buttonSuccess = document.createElement('button');
    buttonSuccess.setAttribute('class','btn btn-success btn-sm');
    buttonSuccess.innerHTML = 'Success';

    addCol(newRow, 8, buttonSuccess);

    buttonSuccess.addEventListener('click', function() {
        x = confirm('Вы действительно хотите подтвердить заказ?');
        if (x == true) {
            var index = getSuccessRowIndex(this);
            $.ajax({
                    url: '/order/success',
                    type: 'POST',
                    contentType : 'application/json',
                    data: JSON.stringify(orderArray[index - 1].orderId),
                    dataType: 'json',
                    success: function()                    {
                        DeleteRow('CarDataTable', index);
                        alert('Подтверждение успешно!\n ID: ' + orderArray[index - 1].orderId);
                        orderArray.splice(index - 1, 1);
                    },
                    error: function(data)                    {
                        alert('Ошибка на сервере!\n ОШИБКА: ' + data.responseText);
                    }
                });
            }
        });
}

function addCol(row, cellNum, value) {
    if (typeof value === 'string' || typeof value === 'number') {
        row.insertCell(cellNum).innerHTML = value;
    } else {
        row.insertCell(cellNum).appendChild(value);
    }
}

function getSuccessRowIndex($this) {
    successRowIndex = $this.parentNode.parentNode.rowIndex;
    return successRowIndex;
}

function clearAddInput()
{
    $('#username').val('');
    $('#carId').val('');
    $('#breaking').val('');
}
