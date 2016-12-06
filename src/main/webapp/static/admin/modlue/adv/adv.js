$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/adv/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>标题</center>", //显示标题
                    "mData": "title", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "3%"

                },
                {
                    "sTitle": "<center>状态</center>", //显示标题
                    "mData": "status", //属性
                    "bSortable": true,//排序
                    "sClass": "center",
                    "sWidth": "3%"
                },

                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "3%",
                    "mRender": function (data, style, obj) {
                        //console.log(obj);
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/adv/preUpdate/" + obj.id + "\" >查看详情</a>";
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
                m_title: {
                    name: "标题",
                    method: {
                        required: true
                    }
                },
                m_type: {
                    name: "类型",
                    method: {
                        required: true,
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
                uploader: "/upload/adv/picUrl",
                fileSizeLimit: 1000 * 1024,
                fileTypeExts: '*.jpg;*.png;*.gif;*.bmp;',
                fileTypeDesc: '请选择图片！',
                onSelect: function (e, queueId, fileObj) {

                },
                onClearQueue: function (queueItemCount) {
                   // mAlert(queueItemCount);
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
                       // onClearQueue();
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


        });
function preReAdd(id) {
    //alert(id);
    $("#myModal2").modal("show").css({
        'top': '60px'
    });
    $("#reAdd").attr("onClick", "reAdd(" + id + ")");
}
function reAdd(id) {
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/adv/reAdd/",
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

//删除图片
function delFj(id){
    $("#"+id).css("display","none");
    //进行删除处理操作
    var fileUrl = $("#picUrlVal").val();//
    $.ajaxInvoke({
        url		   : 	G_CTX_ROOT+"/upload/delFj/adv",
        type	   : 	"post",
        data	   :	{
            "fileUrl"	: fileUrl
        },
        //success	   : 	"操作成功",
        success	   : function(data){
            msgBox(data.state, data.msg);
            $("#picUrlVal").val("");
            $("#picUrlName").css("display", "none");
        },
        error	   : "操作失败"

    });


}

function doSearch() {
    dataTable.fnDraw();
}
function addAdv() {
    editor.sync();
    var goods_id = $("#m_goods_id").val();
    var title = $("#m_title").val();
    var content = $('#editor').val();
    var url = $("#m_url").val();
    var photo = $("#m_photo").val();
    var type = $("#m_type").val();

    if (!validator.validate())
        return false;

    $.ajaxInvoke({
        url: G_CTX_ROOT + "/adv/add",
        type: "post",
        datatype: "json",

        data: {
            p_goods_id: goods_id,
            p_title: title,
            p_content: content,
            p_url:url,
            p_photo: photo,
            p_type: type
        },
        success: function (data) {
            msgBox(data.state, data.msg);
        }
    });
}
function updAdv() {
    editor.sync();
    var id = $("#m_id").val();
    var goods_id = $("#m_goods_id").val();
    var title = $("#m_title").val();
    var content = $('#editor').val();
    var url = $("#m_url").val();
    var photo = $("#m_photo").val();
    var type = $("#m_type").val();

    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/adv/update",
        type: "post",
        datatype: "json",
        data: {
            p_id: id,
            p_goods_id: goods_id,
            p_title: title,
            p_content: content,
            p_url:url,
            p_photo: photo,
            p_type: type
        },
        success: function (data) {
            msgBox(data.state, data.msg);
        }
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
        url: G_CTX_ROOT + "/adv/delete/",
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

