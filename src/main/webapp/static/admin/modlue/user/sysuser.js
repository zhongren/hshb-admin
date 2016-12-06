$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/sysUser/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>手机号</center>", // 显示标题
                    "mData": "phone", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "5%"

                },
                {
                    "sTitle": "<center>姓名</center>", // 显示标题
                    "mData": "realName", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "5%"
                },
                {
                    "sTitle": "<center>账号</center>", // 显示标题
                    "mData": "account", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "<center>邮箱</center>", // 显示标题
                    "mData": "email", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "<center>角色</center>", // 显示标题
                    "mData": "roleName", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "<center>创建时间</center>", // 显示标题
                    "mData": "createTime", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "<center>最后登录时间</center>", // 显示标题
                    "mData": "lastLoginTime", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "3%",

                },
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "5%",
                    "mRender": function (data, style, obj) {
                        //console.log(obj);
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/sysUser/preUpdate/"+obj.id+"\" >查看详情</a>";
                        var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel("+obj.id+")\" >删除</a>";
                        return xqDom + "&nbsp;&nbsp;&nbsp;&nbsp;"
                            + delDom;
                    }
                }];
            setting.aaSorting = [[3, "desc"]];
            setting.bStateSave = false;
            dataTable = $('#datatable_tabletools').dataTable(setting);
            var rule = {
                m_phone: {
                    name: "手机号码",
                    method: {
                        required: true,
                        fixLen: 11,
                        phone: true
                    }

                },
                m_real_name: {
                    name: "姓名",
                    method: {
                        required: true,
                        lt: 10
                    }
                },
                m_account: {
                    name: "账号",
                    method: {
                        required: true
                    }
                },
                m_password: {
                    name: "密码",
                    method: {
                        required: true,
                        gt: 5,
                        lt: 10
                    }
                },
                m_email: {
                    name: "邮箱",
                    method: {
                        required: true,
                        email: true
                    }
                },
                m_role_id: {
                    name : "权限角色",
                    method : {
                        required : true
                    }
                }
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
function preDel(p_id) {
    $("#myModal").modal("show").css({
        'top' : '60px'
    });
    $("#del").attr("onClick","del("+p_id+")");

}
function del(id) {
    $.ajaxInvoke({
        url : G_CTX_ROOT+"/sysUser/delete/",
        type : "post",
        datatype : "json",
        data : {
            p_id : id
        },
        success : function(data) {
            $("#myModal").modal("hide")
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        },
    });
}
function addSysUser() {
    var phone = $("#m_phone").val();
    var real_name = $("#m_real_name").val();
    var account = $("#m_account").val();
    var password = $("#m_password").val();
    var email = $("#m_email").val();
    var role_id = $("#m_role_id").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/sysUser/add",
        type: "post",
        datatype: "json",
        data: {
            p_role_id:role_id,
            p_phone: phone,
            p_real_name: real_name,
            p_account: account,
            p_password: password,
            p_email: email
        },
        success: function (data) {
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}

function updSysUser() {

    var id = $("#m_id").val();
    var phone = $("#m_phone").val();
    var real_name = $("#m_real_name").val();
    var account = $("#m_account").val();
    var email = $("#m_email").val();
    var role_id = $("#m_role_id").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/sysUser/update",
        type: "post",
        datatype: "json",
        data: {
            p_id:id,
            p_role_id:role_id,
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