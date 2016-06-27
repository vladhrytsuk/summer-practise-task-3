<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>LOGIN</title>
</head>
<body>
<div class="container">
    <form class="form-horizontal">
        <h2>Login in</h2>
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
            <div class="col-sm-offset-3 col-sm-3">
                <button type="button" id = "loginIn" class="btn btn-primary">Login</button>
            </div>
            <div class="col-sm-offset-3 col-sm-3">
                <button type="button" id = "registration" class="btn btn-primary">Registration</button>
            </div>
        </div>
    </form>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/resources/js/authorization.js"></script>
<script type="text/javascript" src="/resources/js/validate.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#loginIn").click(function ()
    {
        Authorization();
    });

    $("#registration").click(function ()
    {
        location.href='http://localhost:8080/registration';
    });
</script>
</body>
</html>
