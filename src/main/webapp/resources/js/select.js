
$(document).ready(function () {

    $.ajax({
        url: '/getUser',
        type: 'GET',
        contentType : 'application/json',
        dataType: 'json',
        success: function(data)
        {
            var options = '';

            $(data).each(function() {
                options += '<option value="' + $(this).attr('userId') + '">' + $(this).attr(JSON.parse(data.username)) + '</option>';
            });

            $('#userId').html('<option value="0">- выберите пользователя -</option>' + options);
            $('#userId').attr('disabled', false);
        },
        error: function(data)
        {
            alert('Ошибка на сервере!\n ОШИБКА: ' + data.responseText);
            return(false);
        }
    });

    $('#userId').change(function () {

        var userId = $(this).val();

        if (userId == '0') {
            $('#carId').html('<option value="0">- выберите машину -</option>'+options);
            $('#carId').attr('disabled', true);
            return(false);
        }

        $('#carId').html('<option>загрузка...</option>');
        $('#carId').attr('disabled', true);

        var url = '/getCar';

        $.get(
            url,
            "userId=" + userId,
            function (result) {
                if (result.type == 'error') {
                    alert('error');
                    return(false);
                }
                else {

                    var options = '';

                    $(result).each(function() {
                        options += '<option value="' + $(this).attr('carId') + '">' + $(this).attr('result.mark') + '</option>';
                    });

                    $('#carId').html('<option value="0">- выберите машину -</option>'+options);
                    $('#carId').attr('disabled', false);
                }
            },
            "json"
        );
    });
});
