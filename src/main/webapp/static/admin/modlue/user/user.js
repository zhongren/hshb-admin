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
                        var qrDom = "<button class=\"btn btn-round btn-info btn-xs\" onclick=\"showQR('"+obj.qr+"')\" >二维码</button>";
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
function showQR(qr) {
    $("#qrModal").modal("show").css({
        'top': '60px'
    });
    $("#qrTemp").html("<div style='border: 1px black'><a href='" + qr + "' target='_blank'><img src='" + qr + "' width='200' height='200'/></a></div>");

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
            $("#deleteModal").modal("hide")
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        },
    });
}
/**
 * Created by HQ on 2017/1/8.
 */
var p = ((function () {
    //返回当前 URL 的查询部分（问号 ? 之后的部分）。
    var urlParameters = location.search;
    //声明并初始化接收请求参数的对象
    var requestParameters = new Object();
    //如果该求青中有请求的参数，则获取请求的参数，否则打印提示此请求没有请求的参数
    if (urlParameters.indexOf('?') != -1) {
        //获取请求参数的字符串
        var parameters = decodeURI(urlParameters.substr(1));
        //将请求的参数以&分割中字符串数组
        parameterArray = parameters.split('&');
        //循环遍历，将请求的参数封装到请求参数的对象之中
        for (var i = 0; i < parameterArray.length; i++) {
            requestParameters[parameterArray[i].split('=')[0]] = (parameterArray[i].split('=')[1]);
        }
        console.info('theRequest is =====', requestParameters);
    }
    else {
        console.info('There is no request parameters');
    }
    return requestParameters;
})());
console.log(p);
function edit(action) {
    if (action === "save") {
        addUser();
        console.log("save");
    }
    else if (action === "update") {
        updateUser();
        console.log("update");
    }
}
function addUser() {
    var depart=[];
    $( ".m_depart:checked").each(function(){depart.push(this.value);});
    var user_image=$("#m_user_image").val();
    var name = $("#m_name").val();
    var sex = $("#m_sex").val();

    var position = $("#m_position").val();
    var edu = $("#m_edu").val();
    var phoneNumber = $("#m_phoneNumber").val();
    var remark = $("#m_remark").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/user/save",
        type: "post",
        datatype: "json",
        data: {
            name: name,
            pic: user_image,
            sex: sex,
            eduLevel: edu,
            position: position,
            phone: phoneNumber,
            desc: remark,
            departmentIds: depart
        },
        success: function (data) {
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}
function updateUser() {
    var depart=[];
    $( ".m_depart:checked").each(function(){depart.push(this.value);});
    var id=$("#id").val();
    var user_image=$("#m_user_image").val();
    var name = $("#m_name").val();
    var sex = $("#m_sex").val();
    var position = $("#m_position").val();
    var edu = $("#m_edu").val();
    var phoneNumber = $("#m_phoneNumber").val();
    var remark = $("#m_remark").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/user/update",
        type: "post",
        datatype: "json",
        data: {
            id:id,
            name: name,
            pic: user_image,
            sex: sex,
            eduLevel: edu,
            position: position,
            phone: phoneNumber,
            desc: remark,
            departmentIds: depart
        },
        success: function (data) {
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}
