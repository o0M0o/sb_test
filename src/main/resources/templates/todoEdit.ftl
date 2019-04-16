<#assign jsPath="${request.getContextPath()}/js">
<#assign cssPath="${request.getContextPath()}/css">
<#assign imgPath="${request.getContextPath()}/image">
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css" rel="stylesheet">

    <link href="${cssPath}/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content ">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="todoForm">
                        <input type="hidden" name="id" id="id" value="${todo.id}">
                        <input type="hidden" name="createTime" id="createTime" value="${todo.createTime?string["yyyy-MM-dd HH:mm"]}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">todo内容：</label>
                            <div class="col-sm-2">
                                <input id="content" name="content" value="${todo.content}"
                                       type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">todo时间：</label>
                            <div class="col-sm-2">
                                <input id="todoTime" name="todoTime" value="${todo.todoTime?string["yyyy-MM-dd HH:mm"]}"
                                       class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">是否有效：</label>
                            <div class="col-sm-2">
                                <select id="active" name="active" class="dropdown">
                                    <!--<option value="">请选择是否有效</option>-->
                                    <option <#if todo.active == 1> selected="selected" </#if> value="1">有效</option>
                                    <option <#if todo.active != 1> selected="selected" </#if> value="0">无效</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2 col-sm-offset-3">
                                <button type="submit" class="btn btn-primary" onclick="edit()">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
    <script src="${jsPath}/jquery-3.4.0.js"></script>
    <script src="${jsPath}/bootstrap.min.js"></script>

    <script src="${jsPath}/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${jsPath}/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${jsPath}/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <script src="${jsPath}/layui/layui.js"></script>
    <script src="${jsPath}/todo/todoEdit.js"></script>
</body>
</html>