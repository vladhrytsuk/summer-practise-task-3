<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/table.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>CarList</title>
</head>
<body>
<div class="container">
    <form class="form-horizontal">
        <div class="form-group">
            <div>
                <input type=text id="carId" hidden="hidden">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Mark</label>
            <div class="col-sm-7">
                <input type=text class="form-control" id="mark" placeholder="Enter the mark of car">
            </div>
            <div>
                <span style="color:red" id="mark_f"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Color</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="color" placeholder="Enter the color of car">
            </div>
            <div>
                <span style="color:red" id="color_f"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Vin</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="vin" placeholder="Enter the vin of car">
            </div>
            <div>
                <span style="color:red" id="vin_f"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Miles</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="miles" placeholder="Enter the miles of car">
            </div>
            <div>
                <span style="color:red" id="miles_f"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-3">
                <button type="button" id = "addrow"
                        class="btn btn-primary">ADD</button>
            </div>
        </div>
    </form>
</div>

<div class = "center" id="addList">
    <div class="container">
        <table class="table table-bordered" id="CarDataTable">
            <thead>
            <tr class="text-center">
                <th class="text-center" width="330">ID</th>
                <th class="text-center" width="178">Mark</th>
                <th class="text-center" width="138">Color</th>
                <th class="text-center" width="120">Vin</th>
                <th class="text-center" width="120">Miles</th>
                <th class="text-center" colspan="2" width="180">Action</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/resources/js/functional.js"></script>
<script type="text/javascript" src="/resources/js/validate.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(window).load(function ()
    {
        show();
    });

    $("#addrow").click(function ()
    {
        if (validateAdd() == true)
        {
            addToTable();
        }
     });
</script>

</body>
</html>
