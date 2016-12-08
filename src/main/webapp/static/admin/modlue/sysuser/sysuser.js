$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/sysUser/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>用户编号</center>", // 显示标题
                    "mData": "user_id", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "5%"
                },
                {
                    "sTitle": "<center>用户名</center>", // 显示标题
                    "mData": "name", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "5%"

                },
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "user_id", // 属性
                    "sClass": "center",
                    "sWidth": "2%",
                    "mRender": function (data, style, obj) {
                       // console.log(obj);
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" onclick=\"preUpdate("+obj.user_id+")\" >修改</a>";
                        var delDom ="<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel("+obj.user_id+")\" >删除</a>";
                        return xqDom + "&nbsp;&nbsp;&nbsp;&nbsp;"
                            + delDom;
                    }
                }];
            setting.aaSorting = [[0, "desc"]];
            setting.bStateSave = false;
            dataTable = $('#datatable_tabletools').dataTable(setting);
            var rule = {
                m_name: {
                    name: "用户名",
                    method: {
                        required: true,
                        lt: 10
                    }
                },
                m_password: {
                    name: "密码",
                    method: {
                        required: true,
                        gt: 8,
                        lt: 18
                    }
                }

            };
            validator.init(rule);
        });
/**
 * 查询
 */
function doSearch() {
    dataTable.fnDraw();
}
/**
 * 显示添加窗口
 */
function preSave() {
    $("#m_name").val("");
    $("#m_password").val("");
    $("#saveModal").modal("show").css({
        'top': '60px'
    });
}
/**
 * 发送添加请求
 * @returns {boolean}
 */
function save() {
    var name = $("#m_name").val();
    var password = $("#m_password").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/sysUser/save",
        type: "post",
        datatype: "json",
        data: {
            name: name,
            password: password
        },
        success: function (data) {
            $("#saveModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}

/**
 * 显示更新窗口
 * @param id
 */
function preUpdate(id) {
    var user_id=id;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/sysUser/queryById",
        type: "post",
        datatype: "json",
        data: {
            id: id
        },
        success: function (data) {
            var user=data;
             $("#m_name1").val(user.data.name);
             $("#m_password1").val(user.data.password);
             console.log(user);
        }
    });
    $("#updateButton").replaceWith("<button type=\"button\" onclick=\"update("+user_id+")\" class=\"btn btn-info\" id=\"updateButton\">确认修改</button>");
    $("#updateModal").modal("show").css({
        'top': '60px'
    });
}
/**
 * 发送更新请求
 * @param id
 */
function update(id) {
    var name = $("#m_name1").val();
    var password = $("#m_password1").val();
    console.log(id);
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/sysUser/update",
        type: "post",
        datatype: "json",
        data: {
            id:id,
            name: name,
            password: password
        },
        success: function (data) {
            $("#updateModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}
/**
 * 显示删除窗口
 */
function preDel(id) {
    $("#deleteButton").replaceWith("<button type=\"button\" onclick=\"del("+id+")\" class=\"btn btn-danger\" id=\"deleteButton\">确认删除</button>");
    $("#deleteModal").modal("show").css({
        'top': '60px'
    });
}
/**
 * 发送删除请求
 * @param id
 */
function del(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/sysUser/delete",
        type: "post",
        datatype: "json",
        data: {
            id: id
        },
        success: function (data) {
            $("#deleteModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}