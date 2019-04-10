<#assign jsPath="${request.getContextPath()}/js">
<#assign cssPath="${request.getContextPath()}/css">
<#assign imgPath="${request.getContextPath()}/image">
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
    <script src="${jsPath}/jquery-3.3.1.js"></script>
    <script src="${jsPath}/layui.js"></script>
    <script src="${jsPath}/todo/todo.js"></script>
</head>
<body>
<div class="ibox-content">
    <form class="form-horizontal m-t" id="todoForm">
        <div class="form-group">
            <label class="col-sm-2 control-label">任务名称：</label>
            <div class="col-sm-4">
                <input id="content" name="content" class="form-control"
                       type="text">
            </div>
        </div>
        <!--
        <div class="form-group">
            <div class="col-sm-2 col-sm-offset-3">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
        -->
    </form>
</div>
<button id="add" onclick="add()">添加</button>
<hr>
<div id="todos"></div>
<script type="text/javascript">
    layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#test1', //绑定元素
            url: '/common/sysFile/upload', //上传接口
            size: 1000,
            accept: 'file',
            done: function (r) {
                layer.msg(r.msg);
                app.getData();
            },
            error: function (r) {
                layer.msg(r.msg);
            }
        });
    });
</script>
</body>
</html>