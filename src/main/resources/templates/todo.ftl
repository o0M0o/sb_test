<#assign jsPath="${request.getContextPath()}/js">
<#assign cssPath="${request.getContextPath()}/css">
<#assign imgPath="${request.getContextPath()}/image">
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="${jsPath}/jquery-3.3.1.js"></script>
    <script src="${jsPath}/todo/todo.js"></script>
</head>
<body>
<input id="task">
<button id="add" onclick="add()">添加</button>
<hr>
<div id="todos"></div>
</body>
</html>