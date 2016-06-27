<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>Registration</title>
</head>
<body>
<%--<div class="container">
    <form class="form-horizontal">
        <h2>Registration</h2>
        <div class="form-group">
            <label class="col-sm-3 control-label">Login:</label>
            <div class="col-sm-7">
                <input type=text class="form-control" id="login" placeholder="Enter your login">
            </div>
            <div>
                <span style="color:red" id="login_span"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Password:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="password" placeholder="Enter your password">
            </div>
            <div>
                <span style="color:red" id="password_span"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Email:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="email" placeholder="Enter your email">
            </div>
            <div>
                <span style="color:red" id="email_span"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">First Name:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="firstName" placeholder="Enter your First Name">
            </div>
            <div>
                <span style="color:red" id="firstName_span"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Last Name:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="lastName" placeholder="Enter your Last Name">
            </div>
            <div>
                <span style="color:red" id="lastName_span"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Secret Code:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="secretCode" placeholder="Enter your Secret Code if you mechanic">
            </div>
            <div>
                <span style="color:red" id="secretCode_span"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-3">
                <button type="button" id = "registration" class="btn btn-primary">Registration</button>
            </div>
            <div class="col-sm-offset-3 col-sm-3">
                <button type="button" id = "cancel" class="btn btn-primary" onclick="location.href='/login'">Cancel</button>
            </div>
        </div>
    </form>
</div>--%>
<br>
<br>
<br>
<br>
<br>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Registration</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" id="firstName" class="form-control input-sm floatlabel" placeholder="First Name">
                                    <span style="color:red" id="first-name-span"></span>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" id="lastName" class="form-control input-sm" placeholder="Last Name">
                                    <span style="color:red" id="last-name-span"></span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
                            <span style="color:red" id="email-span"></span>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" id="login" class="form-control input-sm" placeholder="Login">
                                    <span style="color:red" id="login-span"></span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" id="password" class="form-control input-sm" placeholder="Password">
                                    <span style="color:red" id="password-span"></span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control input-sm" id="secretCode" placeholder="Secret Code if you mechanic">
                            <span style="color:red" id="secret-code-span"></span>
                        </div>
                        <button type="button" id = "register" class="btn btn-info btn-block btn-primary">Register</button>
                        <button type="button" id = "cancel" class="btn btn-info btn-block btn-primary">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/resources/js/registration.js"></script>
<script type="text/javascript" src="/resources/js/validate.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#register").click(function ()
    {
        makeRegistration();
    });

    $("#cancel").click(function ()
    {
        location.href='http://localhost:8080/login';
    });
</script>
</body>
</html>
