var prefix = "/todo"
$(function() {
    loadTodos();
});

function loadTodos(){
    $.ajax({
        url : prefix + '/todos',
        success : function(data) {
            var html = '<ul>';
            for(var i=0; i<data.length; i++) {
                html += '<li>' + data[i].content + '<button class="remove" id="' + data[i].id  + '">x</button></li>';
            };
            html += '</ul>';

            document.getElementById('todos').innerHTML = html;

            var buttons = document.getElementsByClassName('remove');
            for (var i=0; i < buttons.length; i++) {
                buttons[i].addEventListener('click', remove);
            };
        }
    });
}

function add() {
    $.ajax({
        cache : true,
        type : "PUT",
        url : prefix + "/save",
        data : $('#todoForm').serialize(),
        async : false,
        error : function(request) {
            laryer.alert("Connection error");
        },
        success : function(data) {
            if (data.msg != "success") {
                parent.layer.alert("保存失败")
            }

            loadTodos();
        }
    });
}


function remove() {
    var id = this.getAttribute('id');
    $.ajax({
        cache : true,
        type : "DELETE",
        url : prefix + "/remove/" + id,
        async : false,
        error : function(request) {
            laryer.alert("Connection error");
        },
        success : function(data) {
            if (data.msg != "success") {
                parent.layer.alert("删除失败")
            }

            loadTodos();
        }
    });
}

