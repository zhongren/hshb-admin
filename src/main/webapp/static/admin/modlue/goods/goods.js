$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/goods/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>游戏编号</center>", //显示标题
                    "mData": "id", //属性
                    "bSortable": true,//排序
                    "sClass": "center",
                    "sWidth": "3%"

                },
                {
                    "sTitle": "<center>名称</center>", //显示标题
                    "mData": "name", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "4%"

                },
                /*
                {
                    "sTitle": "<center>区服</center>", //显示标题
                    "mData": "server", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "1%"

                },
                */
                {
                    "sTitle": "<center>状态</center>", //显示标题
                    "mData": "state", //属性
                    "bSortable": true,//排序
                    "sClass": "center",
                    "sWidth": "1%"
                },
                {
                    "sTitle": "<center>是否推荐</center>", //显示标题
                    "mData": "tuijian", //属性
                    "bSortable": true,//排序
                    "sClass": "center",
                    "sWidth": "1%"
                },
                {
                    "sTitle" : "<center>创建时间</center>", // 显示标题
                    "mData" : "createTime", // 属性
                    "bSortable" : true,// 排序
                    "sClass" : "center",
                    "sWidth" : "4%"
                },
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "3%",
                    "mRender": function (data, style, obj) {
                        console.log(obj)
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/goods/preUpdate/" + obj.id + "\" >查看详情</a>";
                        var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel(" + obj.id + ")\" >下架</a>";
                        var reAddDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preReAdd(" + obj.id + ")\" >上架</a>";
                        var tuijianDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"tuijian(" + obj.id + ")\" >推荐</a>";
                        var delTuijianDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"delTuijianDom(" + obj.id + ")\" >取消推荐</a>";
                        return xqDom + "&nbsp;"
                            + delDom + "&nbsp;" + reAddDom + "&nbsp;" + tuijianDom + "&nbsp;" + delTuijianDom;
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
                },
                m_price: {
                    name: "充值单价",
                    method: {
                        required: true,
                        isNum: true
                    }
                },

                m_price_base_user: {
                name: "普通会员价",
                    method: {
                    required: true,
                        isNum: true
                }
            },    m_price_hy_user: {
                    name: "普通会员价",
                    method: {
                        required: true,
                        isNum: true
                    }
                },
                m_score: {
                    name: "点券兑换比率",
                    method: {
                        required: true,
                        isNum: true
                    }
                },
                m_server: {
                    name: "区服(可以填默认)",
                    method: {
                        required: true
                    }
                },
                m_rate_base_user: {
                    name: "普通会员折扣",
                    method: {
                        required: true,
                        isNum: true
                    }
                },
                m_rate_hy_user: {
                    name: "付费会员折扣",
                    method: {
                        required: true,
                        isNum: true
                    }
                },
                m_type_id: {
                    name: "商品类型",
                    method: {
                        required: true
                    }
                }

            };
            validator.init(rule);
            $("#picUrl").uploadify({
                height: 20,
                removeCompleted: true,
                buttonText: '选择文件',
                swf: G_CTX_ROOT + '/staticUploadify/uploadify.swf',
                width: 100,
                uploader: "/upload/goods/picUrl",
                fileSizeLimit: 1000 * 1024,
                fileTypeExts: '*.jpg;*.png;*.gif;*.bmp;',
                fileTypeDesc: '请选择图片！',
                onSelect: function (e, queueId, fileObj) {

                },
                onClearQueue: function (queueItemCount) {
                    //mAlert(queueItemCount);
                },
                onSelectError: function (file, errorCode, errorMsg) {//当文件选定发生错误时触发
                    /*　alert( 'onSelectErrorid: ' + file.id
                     　　+ ' - 索引: ' + file.index
                     　　+ ' - 文件名: ' + file.name
                     　　+ ' - 文件大小: ' + file.size
                     　　+ ' - 类型: ' + file.type
                     　　+ ' - 创建日期: ' + file.creationdate
                     　　+ ' - 修改日期: ' + file.modificationdate
                     　　+ ' - 文件状态: ' + file.filestatus
                     　　+ ' - 错误代码: ' + errorCode
                     　　+ ' - 错误信息: ' + errorMsg);*/
                    if (file.size > 1000 * 1024) {
                        $("#picUrlClass").html("<font color=red >图片超出上传限制，请重选择！</font>");
                        //$("#picUrl").uploadifyCancel(file.id);
                        //onClearQueue();
                    } else {
                        $("#picUrlClass").html("");
                    }

                },
                onQueueComplete: function (stats) {//当队列中的所有文件全部完成上传时触发
                    /*alert( '成功上传的文件数: ' + stats.successful_uploads
                     　　+ ' - 上传出错的文件数: ' + stats.upload_errors
                     　　+ ' - 取消上传的文件数: ' + stats.upload_cancelled
                     　　+ ' - 出错的文件数' + stats.queue_errors);*/
                },
                onUploadStart: function (file) {//上传开始时触发（每个文件触发一次）
                    /*alert( 'onUploadStart id: ' + file.id
                     　　+ ' - 索引: ' + file.index
                     　　+ ' - 文件名: ' + file.name
                     　　+ ' - 文件大小: ' + file.size
                     　　+ ' - 类型: ' + file.type
                     　　+ ' - 创建日期: ' + file.creationdate
                     　　+ ' - 修改日期: ' + file.modificationdate
                     　　+ ' - 文件状态: ' + file.filestatus ); */
                    if (file.size > 1000 * 1024) {
                        //mAlert("文件超过1MB,请重新选择！","信息提示");
                        $("#picUrlClass").html("<font color=red>文件超出上传限制，请重选择！</font>");
                        onClearQueue();
                    } else {
                        $("#picUrlClass").html("");
                    }
                },
                onUploadSuccess: function (file, data, response) {
                    //var json =jQuery.parseJSON(data);
                    uploadPicUrl2 = true;
                    //div显示文件的名称 以及删除
                    $("#picUrlName").css("display", "");
                    $("#picUrlName").html(file.name);
                    $("#picUrlDel").css("display", "block");
                    $("#picUrlVal").val(data);
                },
                onUploadError: function (file, errorCode, errorMsg, errorString, swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次）
                    /*alert( ' onUploadError id: ' + file.id
                     　　+ ' - 索引: ' + file.index
                     　　+ ' - 文件名: ' + file.name
                     　　+ ' - 文件大小: ' + file.size
                     　　+ ' - 类型: ' + file.type
                     　　+ ' - 创建日期: ' + file.creationdate
                     　　+ ' - 修改日期: ' + file.modificationdate
                     　　+ ' - 文件状态: ' + file.filestatus
                     　　+ ' - 出错的文件数: ' + swfuploadifyQueue.filesErrored
                     　　+ ' - 错误信息: ' + swfuploadifyQueue.errorMsg
                     　　+ ' - 要添加至队列的数量: ' + swfuploadifyQueue.filesSelected
                     　　+ ' - 添加至对立的数量: ' + swfuploadifyQueue.filesQueued
                     　　+ ' - 队列长度: ' + swfuploadifyQueue.queueLength); */
                    //alert(errorCode + ",file :" +file);
                    //console.log(" file  " + file);
                    $("#picUrl").uploadifyCancel(errorCode);
                },
                onError: function (event, queueId, fileObj, errorObj) {

                    //alert("onError");
                    if (errorObj.type === "File Size") {
                        alert('文件超出上传大小限制！');
                        $("#picUrl").uploadifyCancel(ID);
                    }
                }
            });
            $("#picUrl2").uploadify({
                height: 20,
                buttonText: '选择文件',
                removeCompleted: true,
                swf: G_CTX_ROOT + '/staticUploadify/uploadify.swf',
                width: 100,
                uploader: "/upload/goods/picUrl2",
                fileSizeLimit: 1000 * 1024,
                fileTypeExts: '*.jpg;*.png;*.gif;*.bmp;',
                fileTypeDesc: '请选择图片！',
                onSelect: function (e, queueId, fileObj) {

                },
                onClearQueue: function (queueItemCount) {
                    //mAlert(queueItemCount);
                },
                onSelectError: function (file, errorCode, errorMsg) {//当文件选定发生错误时触发
                    /*　alert( 'onSelectErrorid: ' + file.id
                     　　+ ' - 索引: ' + file.index
                     　　+ ' - 文件名: ' + file.name
                     　　+ ' - 文件大小: ' + file.size
                     　　+ ' - 类型: ' + file.type
                     　　+ ' - 创建日期: ' + file.creationdate
                     　　+ ' - 修改日期: ' + file.modificationdate
                     　　+ ' - 文件状态: ' + file.filestatus
                     　　+ ' - 错误代码: ' + errorCode
                     　　+ ' - 错误信息: ' + errorMsg);*/
                    if (file.size > 1000 * 1024) {
                        $("#picUrl2Class").html("<font color=red >图片超出上传限制，请重选择！</font>");
                        //$("#picUrl").uploadifyCancel(file.id);
                        onClearQueue();
                    } else {
                        $("#picUrl2Class").html("");
                    }

                },
                onQueueComplete: function (stats) {//当队列中的所有文件全部完成上传时触发
                    /*alert( '成功上传的文件数: ' + stats.successful_uploads
                     　　+ ' - 上传出错的文件数: ' + stats.upload_errors
                     　　+ ' - 取消上传的文件数: ' + stats.upload_cancelled
                     　　+ ' - 出错的文件数' + stats.queue_errors);*/
                },
                onUploadStart: function (file) {//上传开始时触发（每个文件触发一次）
                    /*alert( 'onUploadStart id: ' + file.id
                     　　+ ' - 索引: ' + file.index
                     　　+ ' - 文件名: ' + file.name
                     　　+ ' - 文件大小: ' + file.size
                     　　+ ' - 类型: ' + file.type
                     　　+ ' - 创建日期: ' + file.creationdate
                     　　+ ' - 修改日期: ' + file.modificationdate
                     　　+ ' - 文件状态: ' + file.filestatus ); */
                    if (file.size > 1000 * 1024) {
                        //mAlert("文件超过1MB,请重新选择！","信息提示");
                        $("#picUrl2Class").html("<font color=red>文件超出上传限制，请重选择！</font>");
                        onClearQueue();
                    } else {
                        $("#picUrl2Class").html("");
                    }
                },
                onUploadSuccess: function (file, data, response) {
                    //var json =jQuery.parseJSON(data);
                    uploadPicUrl2 = true;
                    //div显示文件的名称 以及删除
                    $("#picUrl2Name").css("display", "");
                    $("#picUrl2Name").html(file.name);
                    $("#picUrl2Del").css("display", "block");
                    /* 	$("#imgBox").val("${loginuser.infoUserTab.u_url}"); */
                    $("#picUrl2Val").val(data);
                    //alert(data);

                },
                onUploadError: function (file, errorCode, errorMsg, errorString, swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次）
                    /*alert( ' onUploadError id: ' + file.id
                     　　+ ' - 索引: ' + file.index
                     　　+ ' - 文件名: ' + file.name
                     　　+ ' - 文件大小: ' + file.size
                     　　+ ' - 类型: ' + file.type
                     　　+ ' - 创建日期: ' + file.creationdate
                     　　+ ' - 修改日期: ' + file.modificationdate
                     　　+ ' - 文件状态: ' + file.filestatus
                     　　+ ' - 出错的文件数: ' + swfuploadifyQueue.filesErrored
                     　　+ ' - 错误信息: ' + swfuploadifyQueue.errorMsg
                     　　+ ' - 要添加至队列的数量: ' + swfuploadifyQueue.filesSelected
                     　　+ ' - 添加至对立的数量: ' + swfuploadifyQueue.filesQueued
                     　　+ ' - 队列长度: ' + swfuploadifyQueue.queueLength); */
                    //alert(errorCode + ",file :" +file);
                    //console.log(" file  " + file);
                    $("#picUrl2").uploadifyCancel(errorCode);
                },
                onError: function (event, queueId, fileObj, errorObj) {

                    //alert("onError");
                    if (errorObj.type === "File Size") {
                        alert('文件超出上传大小限制！');
                        $("#picUrl2").uploadifyCancel(ID);
                    }
                }
            });
        });
function doSearch() {
    dataTable.fnDraw();
}
//删除图片
function delFj1(id) {
    $("#" + id).css("display", "none");
    //进行删除处理操作
    var fileUrl = $("#picUrlVal").val();//
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/upload/delFj/goods",
        type: "post",
        data: {
            "fileUrl": fileUrl
        },
        //success	   : 	"操作成功",
        success: function (data) {
            msgBox(data.state, data.msg);
            $("#picUrlVal").val("");
            $("#picUrlName").css("display", "none");
        },
        error: "操作失败"

    });
}
//删除图片
function delFj2(id) {
    $("#" + id).css("display", "none");
    //进行删除处理操作
    var fileUrl = $("#picUrl2Val").val();//
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/upload/delFj/goods",
        type: "post",
        data: {
            "fileUrl": fileUrl
        },
        //success	   : 	"操作成功",
        success: function (data) {
            msgBox(data.state, data.msg);
            $("#picUrl2Val").val("");
            $("#picUrl2Name").css("display", "none");
        },
        error: "操作失败"

    });
}
function addGoods() {
    editor.sync();
    var photo1 = $("#m_photo1").val();
    var photo2 = $("#m_photo2").val();
    var name = $("#m_name").val();
    var server = $("#m_server").val();
    var type_id = $("#m_type_id").val();

    var price_base_user = $("#m_price_base_user").val();

    var price_hy_user = $("#m_price_hy_user").val();
    var price = $("#m_price").val();
    var score = $("#m_score").val();
    var rate_base_user = $("#m_rate_base_user").val();
    var rate_hy_user = $("#m_rate_hy_user").val();
    var url = $("#m_url").val();

    //var desc = UE.getEditor('editor').getContent();
    var desc = $('#editor').val();
    if (!validator.validate())
        return false;

    $.ajaxInvoke({
        url: G_CTX_ROOT + "/goods/add",
        type: "post",
        datatype: "json",
        data: {
            p_type_id: type_id,
            p_server: server,
            p_name: name,
            p_photo1: photo1,
            p_photo2: photo2,
            p_price: price,
            p_price_base_user:price_base_user,
            p_price_hy_user:price_hy_user,
            p_score: score,
            p_rate_base_user: rate_base_user,
            p_rate_hy_user: rate_hy_user,
            p_url: url,
            p_sequence: 1,
            p_desc: desc

        },
        success: function (data) {
            msgBox(data.state, data.msg);
        },
    });
}
function updGoods() {
    editor.sync();
    var photo1 = $("#m_photo1").val();//小图片
    var photo2 = $("#m_photo2").val();//大图片
    var id = $("#m_id").val();
    var name = $("#m_name").val();
    var server = $("#m_server").val();
    var type_id = $("#m_type_id").val();
    var price = $("#m_price").val();
    var price_base_user = $("#m_price_base_user").val();

    var price_hy_user = $("#m_price_hy_user").val();
    var score = $("#m_score").val();
    var rate_base_user = $("#m_rate_base_user").val();
    var rate_hy_user = $("#m_rate_hy_user").val();
    var url = $("#m_url").val();
    var desc = $('#editor').val();
    //alert(server)
    if (!validator.validate())
        return false;

    $.ajaxInvoke({
        url: G_CTX_ROOT + "/goods/update",
        type: "post",
        datatype: "json",

        data: {
            p_id: id,
            p_type_id: type_id,
            p_name: name,
            p_server: server,
            p_photo1: photo1,
            p_photo2: photo2,
            p_price: price,
            p_score: score,
            p_rate_base_user: rate_base_user,
            p_rate_hy_user: rate_hy_user,
            p_url: url,
            p_sequence: 1,
            p_desc: desc,
            p_price_base_user:price_base_user,
            p_price_hy_user:price_hy_user,
        },
        success: function (data) {
            msgBox(data.state, data.msg);
        },
    });
}

function preReAdd(id) {
    //alert(id);
    $("#myModal2").modal("show").css({
        'top': '60px'
    });
    $("#reAdd").attr("onClick", "reAdd(" + id + ")");
}
function reAdd(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/goods/reAdd/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id
        },
        success: function (data) {
            $("#myModal2").modal("hide")
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        },
    });
}

function preDel(id) {
    //alert(id);
    $("#myModal").modal("show").css({
        'top': '60px'
    });
    $("#del").attr("onClick", "del(" + id + ")");
}
function del(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/goods/delete/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id
        },
        success: function (data) {
            $("#myModal").modal("hide")
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        },
    });
}
function tuijian(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/goods/tuijian/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id
        },
        success: function (data) {
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}

function delTuijianDom(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/goods/delTuijian/",
        type: "post",
        datatype: "json",
        data: {
            p_id: id
        },
        success: function (data) {
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}