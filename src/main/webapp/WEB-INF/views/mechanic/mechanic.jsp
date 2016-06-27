<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>Mechanic Page</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Mechanic Name</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic" src="#" class="img-circle img-responsive"> </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Roles:</td>
                                    <td>Mechanic</td>
                                </tr>
                                <tr>
                                    <td>Login:</td>
                                    <td>login</td>
                                </tr>
                                <tr>
                                    <td>First Name:</td>
                                    <td>firstname</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>Last Name:</td>
                                    <td>lastname</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="#">email</a></td>
                                </tbody>
                            </table>

                            <a href="/list" class="btn btn-primary">Add Orders</a>
                            <a href="/list" class="btn btn-primary">Show orders</a>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Write Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="/mechanic/edit" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a href="/mechanic/delete" data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                </div>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
