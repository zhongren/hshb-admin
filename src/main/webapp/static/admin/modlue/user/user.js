$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/user/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>编号</center>", // 显示标题
                    "mData": "user_id", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "2%"
                },
                {
                    "sTitle": "<center>姓名</center>", // 显示标题
                    "mData": "name", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "2%"

                },
                {
                    "sTitle": "<center>电话</center>", // 显示标题
                    "mData": "phone", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "2%"
                },
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "user_id", // 属性
                    "sClass": "center",
                    "sWidth": "5%",
                    "mRender": function (data, style, obj) {
                        var xgDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"edit?module=user&action=update&id=" + obj.user_id + "\" >修改</a>";
                        var qrDom = "<button class=\"btn btn-round btn-info btn-xs\" onclick=\"\" >二维码</button>";
                        var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel("+obj.user_id+")\" >删除</a>";
                        return xgDom+
                            "&nbsp;"
                            + qrDom+
                            "&nbsp;&nbsp;&nbsp;"
                            + delDom;
                    }
                }];
            setting.aaSorting = [[0, "desc"]];
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
                        lt: 10
                    }
                }

            };
            validator.init(rule);
        });
function doSearch() {
    dataTable.fnDraw();
}


/**
 * 展示二维码
 * @param id
 */
function showQR(uid) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/user/queryById",
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
    $("#saveModal").modal("show").css({
        'top': '60px'
    });
}
function preDel(user_id) {
    $("#deleteModal").modal("show").css({
        'top' : '60px'
    });
    $("#deleteButton").attr("onClick","del("+user_id+")");

}
function del(user_id) {
    $.ajaxInvoke({
        url : G_CTX_ROOT+"/user/delete/",
        type : "post",
        datatype : "json",
        data : {
            id : user_id
        },
        success : function(data) {
            $("#myModal").modal("hide")
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        },
    });
}