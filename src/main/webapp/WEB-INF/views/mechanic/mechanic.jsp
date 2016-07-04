<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/JosefinSans-Thin.ttf"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/glyphicons-halflings-regular.ttf"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/glyphicons-halflings-regular.woff"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/glyphicons-halflings-regular.woff2"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/addCar.css"/>">
    <title>Mechanic ${pageContext.request.userPrincipal.name}</title>
</head>
<body>
<br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-5 toppad pull-right col-md-offset-3">
            <a href="<c:url value="/"/>" >Home</a>
            <a href="<c:url value="/logout"/>" >Logout</a>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-info">
                <div class="panel-heading">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h3 class="panel-title" align="center">User: ${pageContext.request.userPrincipal.name}</h3>
                    </c:if>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic" src="<c:url value="/resources/image/userpic.png"/>" class="img-circle img-responsive"> </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <th>User level:</th>
                                    <td>Mechanic</td>
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
                            <div class="btn-group" align="center">
                                <button class="btn btn-primary btn-sm open_window_add_order">Add Orders</button>
                                <button class="btn btn-info btn-sm open_window_show_order">Show Orders</button>
                            </div>
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

<script type="text/javascript" src="<c:url value="/resources/js/lib/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.11.3.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/orderForMechanic.js"/>" ></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('.popup_add_order .close_popup, .overlay').click(function (){
            $('.popup_add_order, .overlay').css({'opacity':'0', 'visibility':'hidden'});
        });
        $('.open_window_add_order').click(function (e){
            $('.popup_add_order, .overlay').css({'opacity':'1', 'visibility':'visible'});
            e.preventDefault();
        });

        $('.popup_show_order .close_popup, .overlay').click(function (){
            $('.popup_show_order, .overlay').css({'opacity':'0', 'visibility':'hidden'});
        });
        $('.open_window_show_order').click(function (e){
            $('.popup_show_order, .overlay').css({'opacity':'1', 'visibility':'visible'});
            e.preventDefault();
        });

        $(window).load(function () {
            showOrder();
        });

        $("#addOrder").click(function () {
            addToTable();
        });
    });
</script>

<div class="overlay" title="Add order"></div>
<div class="popup_add_order">
    <div class="row centered-form">
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label">Username:</label>
                <div class="col-sm-7">
                    <input type=text class="form-control input-sm" id="username" placeholder="Enter the user">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">Car:</label>
                <div class="col-sm-7">
                    <input type=text class="form-control input-sm" id="carId" placeholder="Enter the car of user">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">Breaking:</label>
                <div class="col-sm-7">
                    <textarea class="form-control input-sm" id="breaking" cols="40" rows="3" placeholder="Enter the Breaking"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3" align="right">
                    <button type="button" id = "addOrder" class="btn btn-info btn-primary">Add</button>
                </div>
                <div class="col-sm-7">
                    <div class="close_popup" align="right">
                        <button type="button" id = "closePopup" class="btn btn-info btn-success">Close</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

   <%-- <form action="#" method="get">
        <div class="form-group">
            <label class="col-sm-3 control-label">Пользователь:</label>
                <div class="col-sm-7">
                    <select name="userId" id="userId" class="form-control">
                        <option value="0">- выберите пользователя -</option>
                    </select>
                </div>

            <label class="col-sm-3 control-label">Машины:</label>
                <div class="col-sm-7">
                    <select name="carId" id="carId" disabled="disabled" class="form-control">
                        <option value="0">- выберите машину -</option>
                    </select>
                </div>
        </div>
    </form>--%>

</div>


<div class="overlay" title="Show lits of order">Show lits of order</div>
<div class="popup_show_order">
    <div class = "center" id="addOrders">
        <div class="container">
            <table class="table table-bordered" id="OrderDataTable">
                <thead>
                <tr class="text-center">
                    <th class="text-center">ID</th>
                    <th class="text-center">User</th>
                    <th class="text-center">Mark</th>
                    <th class="text-center">Color</th>
                    <th class="text-center">Vin</th>
                    <th class="text-center">Miles</th>
                    <th class="text-center">Breaking</th>
                    <th class="text-center">Status</th>
                    <th class="text-center" colspan="2">Action</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <div class="close_popup" align="right">
        <button type="button" class="btn btn-info btn-success">Close</button>
    </div>
</div>

</body>
</html>