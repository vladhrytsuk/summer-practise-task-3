function makeRegistration() {
    var login = $('#login').val();
    var password = $('#password').val();
    var email = $('#email').val();
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var secretCode = $('#secretCode').val();

    $.ajax( {
        type: 'POST',
        contentType: 'application/json',
        url: '/makeRegistration',
        data: JSON.stringify(
            {
                'login':login,
                'password':password,
                'email':email,
                'firstName':firstName,
                'lastName':lastName,
                'secretCode':secretCode
            }),
        dataType: 'json',
        success: function(data, response) {
            clearSpan();
            if (response == 'success') {
                alert('User with login ' + data.login + ' successfully registered.\n' +
                    'Click OK and log in using your username');
                location.href = 'http://localhost:8080/login';
            } else {
                $('#error').text('Unknown error!');
            }
        },
        error: function(error) {
            showErrors(error);
        }
    });
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
            $('#login-span').text(message);
            break;
        case 'password':
            $('#password-span').text(message);
            break;
        case 'email':
            $('#email-span').text(message);
            break;
        case 'firstName':
            $('#first-name-span').text(message);
            break;
        case 'lastName':
            $('#last-name-span').text(message);
            break;
        case 'secretCode':
            $('#secret-code-span').text(message);
            break;
        default:
            alert(message);
            break;
    }
}

function clearSpan() {
    $('#login-span').text('');
    $('#password-span').text('');
    $('#email-span').text('');
    $('#first-name-span').text('');
    $('#last-name-span').text('');
    $('#secret-code-span').text('');
}