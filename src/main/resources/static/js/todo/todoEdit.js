var prefix = "/todo"
var layer
layui.use('layer', function(){
    layer = layui.layer;
})


function edit() {
    $.ajax({
        cache: true,
        type: "POST",
        url: prefix + "/modify",
        data: $('#todoForm').serialize(),
        async: false,
        error: function (request) {
            console.error("Connection error")
            parent.location.reload()
        },
        success: function (data) {
            if (data.msg !== "success") {
                console.error("Connection error")
            } else {
                console.info("modify success")
            }

            parent.location.reload()
        }
    });
}
