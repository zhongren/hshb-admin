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
