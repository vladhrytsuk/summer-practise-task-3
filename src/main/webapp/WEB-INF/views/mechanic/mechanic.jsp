<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>Mechanic ${login}</title>
</head>
<body>
<br><br><br>
<div class="container">
    <div class="row">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2 align="center">Dear ${pageContext.request.userPrincipal.name}, welcome to Client Page</h2>
        </c:if>
        <div class="col-md-5 toppad pull-right col-md-offset-3">
            <a href="<c:url value="/"/>" >Home</a>
            <a href="<c:url value="/logout"/>" >Logout</a>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">User: ${username}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic" src="/resources/image/userpic.png" class="img-circle img-responsive"> </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <th><strong>User level:</strong></th>
                                    <td><strong>Mechanic</strong></td>
                                </tr>
                                <tr>
                                    <th>First Name:</th>
                                    <td>${firstName}</td>
                                </tr>

                                <tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td>${lastName}</td>
                                </tr>
                                <tr>
                                    <th>E-mail:</th>
                                    <td><a href="#">${email}</a></td>
                                </tbody>
                            </table>

                            <a href="#" class="btn btn-primary">Add Orders</a>
                            <a href="#" class="btn btn-primary">Show orders</a>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Write Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="#" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a href="#" data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                </div>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
