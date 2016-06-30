function Authorization()
{
    var username = $('#username').val();
    var password = $('#password').val();

    $.ajax(
        {
            url: '/login',
            type: 'POST',
            contentType : 'application/json',
            data: JSON.stringify(
                {
                    'login': username,
                    'password': password
                }),
            success: function(data)
            {
                $.ajax(
                    {
                        url: '/user/' + username,
                        type: 'GET',
                        contentType : 'application/json',
                        data: {
                                'login': data.username,
                               // 'role': data.role,
                                'email': data.email,
                                'firstName': data.firstName,
                                'lastName': data.lastName
                            },
                        success: function(data)
                        {
                            location.href = 'http://localhost:8080/user/' + username;
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
        case 'username':
            $('#username-err').text(message);
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
    $('#username-err').text('');
    $('#password-err').text('');
}