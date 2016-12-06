$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/type/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>类型编号</center>", //显示标题
                    "mData": "id", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "3%"

                },
                {
                    "sTitle": "<center>类型名称</center>", //显示标题
                    "mData": "name", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "<center>状态</center>", //显示标题
                    "mData": "status", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "1%"
                },
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "3%",
                    "mRender": function (data, style, obj) {
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/type/preUpdate/" + obj.id + "\" >查看详情</a>";
                        var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel(" + obj.id + ")\" >下架</a>";
                        var reAddDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preReAdd(" + obj.id + ")\" >上架</a>";
                        return xqDom + "&nbsp;&nbsp;&nbsp;&nbsp;"
                            + delDom + "&nbsp;&nbsp;&nbsp;&nbsp;"+ reAddDom;
                    }
                }];
            setting.aaSorting = [[3, "desc"]];
            setting.bStateSave = false;
            dataTable = $('#datatable_tabletools').dataTable(setting);
            var rule = {
                m_name: {
                    name: "类型名称",
                    method: {
                        required: true
                    }
                }
            };
            validator.init(rule);
        });
function preReAdd(id) {
    $("#myModal2").modal("show").css({
        'top': '60px'
    });
    $("#reAdd").attr("onClick", "reAdd(" + id + ")");
}
function reAdd(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/type/reAdd/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id
        },
        success: function (data) {
            $("#myModal2").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}


function doSearch() {
    dataTable.fnDraw();
}
function addType() {
    var name = $("#m_name").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/type/add",
        type: "post",
        datatype: "json",
        data: {
            p_name: name
        },
        success: function (data) {
            msgBox(data.state, data.msg);
        }
    });
}
function updType() {
    var id = $("#m_id").val();
    var name = $("#m_name").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/type/update",
        type: "post",
        datatype: "json",
        data: {
            p_id: id,
            p_name: name
        },
        success: function (data) {
            msgBox(data.state, data.msg);
        }
    });
}
function preDel(id) {
    $("#myModal").modal("show").css({
        'top': '60px'
    });
    $("#del").attr("onClick", "del(" + id + ")");
}
function del(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/type/delete/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id
        },
        success: function (data) {
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}

