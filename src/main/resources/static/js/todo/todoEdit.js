var prefix = "/todo"
var layer
layui.use('layer', function(){
    layer = layui.layer;
})


function edit() {
    $.ajax({
        cache: true,
        type: "PUT",
        url: prefix + "/save",
        data: $('#todoForm').serialize(),
        async: false,
        error: function (request) {
            laryer.alert("Connection error");
        },
        success: function (data) {
            if (data.msg !== "success") {
                parent.layer.alert("添加失败")
            } else {
                layer.msg("添加成功");
                reLoad()
            }
        }
    });
}
