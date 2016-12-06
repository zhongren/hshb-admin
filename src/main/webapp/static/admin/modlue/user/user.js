$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/user/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>用户编号</center>", // 显示标题
                    "mData": "id", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "3%"

                },
                {
                    "sTitle": "<center>手机号</center>", // 显示标题
                    "mData": "userPhone", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "3%",

                },
                {
                    "sTitle": "<center>姓名</center>", // 显示标题
                    "mData": "userName", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "2%",
                },
                {
                    "sTitle": "<center>账号</center>", // 显示标题
                    "mData": "userAccount", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "2%"
                },
                {
                    "sTitle": "<center>用户类型</center>", // 显示标题
                    "mData": "userType", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "2%"
                }, {
                    "sTitle": "<center>乐币</center>", // 显示标题
                    "mData": "lebi", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "2%"
                },
                {
                    "sTitle": "<center>创建时间</center>", // 显示标题
                    "mData": "createTime", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "4%"
                },
                {
                    "sTitle": "<center>最后登录时间</center>", // 显示标题
                    "mData": "lastLoginTime", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "4%"

                },
                {
                    "sTitle": "<center>会员到期时间</center>", // 显示标题
                    "mData": "hyEndTime", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "4%"

                },
                {
                    "sTitle": "<center>会员时间添加</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "5%",
                    "mRender": function (data, style, obj) {
                        var timeDom1 = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"hyAdd(" + obj.id + ",1)\" >1个月</a>";
                        var timeDom2 = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"hyAdd(" + obj.id + ",3)\" >3个月</a>";
                        var timeDom3 = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"hyAdd(" + obj.id + ",6)\" >半年</a>";
                        var timeDom4 = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"hyAdd(" + obj.id + ",12)\" >一年</a>";
                        return timeDom1 + "&nbsp;" + timeDom2 + "&nbsp;" + timeDom3 + "&nbsp;" + timeDom4;
                    }
                }
                ,
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "2%",
                    "mRender": function (data, style, obj) {
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/user/preUpdate/" + obj.id + "\" >查看详情</a>";
                       // var delDom = "<button class=\"btn btn-round btn-danger btn-xs\" onclick=\"\" >锁定</button>";
                        return xqDom
                            //"&nbsp;&nbsp;&nbsp;&nbsp;"
                           // + delDom;
                    }
                }];
            setting.aaSorting = [[3, "desc"]];
            setting.bStateSave = false;
            dataTable = $('#datatable_tabletools').dataTable(setting);
            var rule = {
                m_phoneNumber: {
                    name: "手机号码",
                    method: {
                        required: true,
                        fixLen: 11,
                        phone: true
                    },

                },
                m_name: {
                    name: "姓名",
                    method: {
                        required: true,
                        lt: 10,
                    },
                },
                m_account: {
                    name: "账号",
                    method: {
                        required: true,
                    },
                },
                m_password: {
                    name: "密码",
                    method: {
                        required: true,
                        gt: 8,
                        lt: 18
                    },
                },

            };
            validator.init(rule);
        });
function doSearch() {
    dataTable.fnDraw();
}
function preAdd() {
    $("#myModal").modal("show").css({
        'top': '60px'
    });
}

function hyAdd(id, month) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/user/hyTimeUpdate/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id,
            p_month: month
        },
        success: function (data) {
            $("#myModal").modal("hide")
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        },
    });
}
function addUser() {
    var phoneNumber = $("#m_phoneNumber").val();
    var name = $("#m_name").val();
    var account = $("#m_account").val();
    var password = $("#m_password").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/user/add",
        type: "post",
        datatype: "json",
        data: {
            p_user_name: name,
            p_account: account,
            p_user_phone: phoneNumber,
            p_password: password
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