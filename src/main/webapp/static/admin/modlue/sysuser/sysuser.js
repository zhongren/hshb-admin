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

                }
                ,
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
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "2%",
                    "mRender": function (data, style, obj) {
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/user/preUpdate/" + obj.id + "\" >修改</a>";
                        var delDom = "<button class=\"btn btn-round btn-danger btn-xs\" onclick=\"\" >删除</button>";
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
    $("#myModal").modal("show").css({
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
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}
function updUser() {

    var id = $("#m_id").val();
    var phone = $("#m_phone").val();
    var real_name = $("#m_real_name").val();
    var account = $("#m_account").val();
    var email = $("#m_email").val();
    var role_id = $("#m_role_id").val();

    var lebi = $("#m_lebi").val();

    $.ajaxInvoke({
        url: G_CTX_ROOT + "/user/update",
        type: "post",
        datatype: "json",
        data: {
            p_lebi: lebi,
            p_id: id,
            p_role_id: role_id,
            p_phone: phone,
            p_real_name: real_name,
            p_account: account,
            p_email: email
        },
        success: function (data) {
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}