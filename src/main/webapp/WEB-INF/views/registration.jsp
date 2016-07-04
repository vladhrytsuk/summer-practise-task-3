<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/registration.css"/>">
    <title>Registration</title>
</head>
<body>
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
                                    <input type="text" id="username" class="form-control input-sm" placeholder="Login">
                                    <span style="color:red" id="username-span"></span>
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
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.11.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/registration.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/old/validate.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/bootstrap.min.js"/>"></script>
<script type="text/javascript">
    $("#register").click(function ()
    {
        makeRegistration();
    });

    $("#cancel").click(function ()
    {
        location.href='http://localhost:8080/authorization';
    });
</script>
</body>
</html>
