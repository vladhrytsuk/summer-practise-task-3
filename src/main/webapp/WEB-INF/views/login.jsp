<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/registration.css"/>">
    <title>LOGIN</title>
</head>
<body>
<%--<div class="container">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form class="form-horizontal" action="${loginUrl}" method="post">
        <h2>Login in</h2>

        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Invalid username or password.</p>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>

        <div class="form-group">
            <label class="col-sm-3 control-label">Login:</label>
            <div class="col-sm-7">
                <input type=text class="form-control" name="f_username" placeholder="Enter your login">
            </div>
            <div>
                <span style="color:red" id="username_span"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Password:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" name="f_password" placeholder="Enter your password">
            </div>
            <div>
                <span style="color:red" id="password_span"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-3">
                <button type="submit" class="btn btn-primary">Login</button>
                <button type="button" id = "registration" class="btn btn-primary">Registration</button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </div>
    </form>
</div>--%>

<div class="container">
    <div class="row">
        <div class="col-md-5 col-md-offset-4 top-padding">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title" align="center">Log in</h2>
                </div>
                <div class="panel-body">
                    <c:url value="/j_spring_security_check" var="loginUrl"/>
                    <form action="${loginUrl}" method="post">

                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Invalid username or password.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>You have been logged out successfully.</p>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <input type="text" name="f_username" class="form-control" placeholder="Login">
                            <span style="color:red" id="username_span"></span>
                        </div>

                        <div class="form-group">
                            <input type="password" name="f_password" class="form-control" placeholder="Password">
                            <span style="color:red" id="password_span"></span>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Login</button>
                            <button type="button" id = "registration" class="btn btn-primary">Registration</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.11.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/bootstrap.min.js"/>"></script>
<script type="text/javascript">
    /*    $("#loginIn").click(function ()
     {
     /!*Authorization();*!/
     });*/

    $("#registration").click(function ()
    {
        location.href='http://localhost:8080/registration';
    });
</script>
</body>
</html>
