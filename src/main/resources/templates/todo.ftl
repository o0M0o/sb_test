<#assign jsPath="${request.getContextPath()}/js">
<#assign cssPath="${request.getContextPath()}/css">
<#assign imgPath="${request.getContextPath()}/image">
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <link href="${cssPath}/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content ">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="todoForm">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">todo内容：</label>
                            <div class="col-sm-4">
                                <input id="content" name="content" class="form-control"
                                       type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">todo时间：</label>
                            <div class="col-sm-4">
                                <input id="todoTime" name="todoTime" value="${current}"
                                       class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-3">
                                <button type="submit" class="btn btn-primary" onclick="add()">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>
<table id="todoTable" data-mobile-responsive="true">


    <script src="https://code.jquery.com/jquery-3.4.0.js"
            integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
            crossorigin="anonymous"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>


    <script src="${jsPath}/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${jsPath}/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${jsPath}/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <script src="${jsPath}/layui/layui.js"></script>
    <script src="${jsPath}/todo/todo.js"></script>
</body>
</html>