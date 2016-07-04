<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/addCar.css"/>">
    <title>User ${username}</title>
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
                                    <th><strong>User level:</strong></th>
                                    <td><strong>User</strong></td>
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
                                <button class="btn btn-primary btn-sm open_window_add_car">Add Cars</button>
                                <button class="btn btn-info btn-sm open_window_show_list">Show Cars</button>
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
<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.11.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/carForUser.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/orderForUser.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('.popup_add_car .close_popup, .overlay').click(function (){
            $('.popup_add_car, .overlay').css({'opacity':'0', 'visibility':'hidden'});
        });
        $('.open_window_add_car').click(function (e){
            $('.popup_add_car, .overlay').css({'opacity':'1', 'visibility':'visible'});
            e.preventDefault();
        });

        $('.popup_show_list .close_popup, .overlay').click(function (){
            $('.popup_show_list, .overlay').css({'opacity':'0', 'visibility':'hidden'});
        });
        $('.open_window_show_list').click(function (e){
            $('.popup_show_list, .overlay').css({'opacity':'1', 'visibility':'visible'});
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
            show();
            showOrder();
        });

        $("#addrow").click(function () {
            addToTable();
        });
    });
</script>

<div class="overlay" title="Add Cars">Add Cars</div>
    <div class="popup_add_car">
        <div class="row centered-form">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3 control-label">Mark</label>
                        <div class="col-sm-7">
                            <input type=text class="form-control input-sm" id="mark" placeholder="Enter the mark of car">
                        </div>
                        <div>
                            <span style="color:red" id="vin_f"></span>
                        </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Color</label>
                        <div class="col-sm-7">
                            <input type=text class="form-control input-sm" id="color" placeholder="Enter the color of car">
                        </div>
                        <div>
                            <span style="color:red" id="mark_f"></span>
                        </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Vin</label>
                        <div class="col-sm-7">
                            <input type=text class="form-control input-sm" id="vin" placeholder="Enter the vin of car">
                        </div>
                        <div>
                            <span style="color:red" id="color_f"></span>
                        </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Miles</label>
                        <div class="col-sm-7">
                            <input type=text class="form-control input-sm" id="miles" placeholder="Enter the miles of car">
                        </div>
                        <div>
                            <span style="color:red" id="miles_f"></span>
                        </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-3" align="right">
                        <button type="button" id = "addrow" class="btn btn-info btn-primary">Add</button>
                    </div>
                    <div class="col-sm-7">
                        <div class="close_popup" align="right">
                            <button type="button" id = "closePopup" class="btn btn-info btn-success">Close</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

<div class="overlay" title="Show lits of car">Show lits of car</div>
    <div class="popup_show_list">
        <div class = "center" id="addList">
            <div class="container">
                <table class="table table-bordered" id="CarDataTable">
                    <thead>
                        <tr class="text-center">
                            <th class="text-center" width="52">ID</th>
                            <th class="text-center" width="262">Mark</th>
                            <th class="text-center" width="216">Color</th>
                            <th class="text-center" width="216">Vin</th>
                            <th class="text-center" width="216">Miles</th>
                            <th class="text-center" colspan="2" width="177">Action</th>
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

<div class="overlay" title="Show lits of car">Show lits of order</div>
<div class="popup_show_order">
    <div class = "center" id="addOrders">
        <div class="container">
            <table class="table table-bordered" id="OrderDataTable">
                <thead>
                <tr class="text-center">
                    <th class="text-center">ID</th>
                    <th class="text-center">Mechanic</th>
                    <th class="text-center">Mark</th>
                    <th class="text-center">Color</th>
                    <th class="text-center">Vin</th>
                    <th class="text-center">Miles</th>
                    <th class="text-center">Breaking</th>
                    <th class="text-center">Status</th>
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