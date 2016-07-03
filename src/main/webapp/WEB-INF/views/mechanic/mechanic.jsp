<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/"/>">
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

<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/select.js"/>" ></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('.popup_add_order .close_popup, .overlay').click(function (){
            $('.popup_add_order, .overlay').css({'opacity':'0', 'visibility':'hidden'});
        });
        $('.open_window_add_order').click(function (e){
            $('.popup_add_order, .overlay').css({'opacity':'1', 'visibility':'visible'});
            e.preventDefault();
        });

        $('.popup_show_list .close_popup, .overlay').click(function (){
            $('.popup_show_list, .overlay').css({'opacity':'0', 'visibility':'hidden'});
        });
        $('.open_window_show_order').click(function (e){
            $('.popup_show_list, .overlay').css({'opacity':'1', 'visibility':'visible'});
            e.preventDefault();
        });
    });
</script>

<div class="overlay" title="Add order"></div>
<div class="popup_add_order">
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

    <form action="#" method="get">
        Пользователь:<br />
        <select name="userId" id="userId" class="StyleSelectBox">
            <option value="0">- выберите пользователя -</option>
        </select></td><td>
        Машины:<br />
        <select name="carId" id="carId" disabled="disabled" class="StyleSelectBox">
            <option value="0">- выберите машину -</option>
        </select></td><td>
    </form>

</div>

</body>
</html>