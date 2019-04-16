<#assign jsPath="${request.getContextPath()}/js">
<#assign cssPath="${request.getContextPath()}/css">
<#assign imgPath="${request.getContextPath()}/image">
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css" rel="stylesheet">
    <!--
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
          -->

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
                                <input id="todoTime" name="todoTime" value="${current?string["yyyy-MM-dd HH:mm:ss"]}"
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

    <script src="${jsPath}/jquery-3.4.0.js"></script>
    <script src="${jsPath}/bootstrap.min.js"></script>

    <script src="${jsPath}/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${jsPath}/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${jsPath}/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <script src="${jsPath}/layui/layui.js"></script>
    <script src="${jsPath}/todo/todo.js"></script>
</body>
</html>