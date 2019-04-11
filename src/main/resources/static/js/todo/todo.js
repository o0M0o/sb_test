var prefix = "/todo"
var layer
layui.use('layer', function(){
    layer = layui.layer;
})

$(function () {
    load()
})

function load() {
    $('#todoTable')
        .bootstrapTable(
            {
                method: 'get',
                url: prefix + "/todos1",
                iconSize: 'outline',
                //toolbar : '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json",
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "client", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        visible: false,
                        field: 'id',
                        title: '编号'
                    },

                    {
                        field: 'content',
                        title: '内容',
                        formatter: function (value, row, index) {
                            return '<a href="#" onclick="edit(\'' + row.id + '\')">' + value + '</a>';
                        }
                    },
                    {
                        field: 'todoTime',
                        title: '备忘时间'
                    },
                    {
                        field: 'createTime',
                        title: '创建时间'
                    },
                    {
                        field: 'active',
                        title: '状态',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (value === 1) {
                                return '<span class="label label-danger">有效</span>';
                            } else {
                                return '<span class="label label-primary">无效</span>';
                            }
                        }
                    },
                    {
                        title: '操作',
                        field: 'operation',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;
                        }
                    }]
            });

}

function reLoad() {
    $('#todoTable').bootstrapTable('refresh');
}

function add() {
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

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            cache: true,
            type: "DELETE",
            url: prefix + "/remove/" + id,
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.msg !== "success") {
                    parent.layer.alert("删除失败")
                } else {
                    layer.msg("删除成功");
                    reLoad()
                }
            }
        });
    })
}

function edit(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
