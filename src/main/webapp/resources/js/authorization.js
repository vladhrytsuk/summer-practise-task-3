function Authorization()
{
    var login = $('#login').val();
    var password = $('#password').val();

    $.ajax(
        {
            url: '/authorization',
            type: 'POST',
            contentType : 'application/json',
            data: JSON.stringify(
                {
                    'login': login,
                    'password': password,
                }),
            success: function(data)
            {
                $.ajax(
                    {
                        url: '/user/' + login,
                        type: 'GET',
                        contentType : 'application/json',
                        data: {'login': login},
                        success: function(data)
                        {
                            location.href = 'http://localhost:8080/user/' + login;
                        }
                    }
                );
            },
            error: function(error) {
                showErrors(error);
            }
        }
    );
}

function showErrors(error) {
    clearSpan();
    for (var i = 0; i < error.responseJSON.errors.length; ++i) {
        var arr = error.responseJSON.errors[i].split(',');
        var field = arr[0].trim();
        var message = arr[1].trim();
        addErrorMessageToField(field, message);
    }
}

function addErrorMessageToField(field, message) {
    switch (field) {
        case 'login':
            $('#login-err').text(message);
            break;
        case 'password':
            $('#password-err').text(message);
            break;
        default:
            alert(message);
            break;
    }
}

function clearSpan() {
    $('#login-err').text('');
    $('#password-err').text('');
}