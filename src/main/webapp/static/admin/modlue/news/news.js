$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/news/query";
            setting.aoColumns = [
                {
                    "sTitle": "<center>编号</center>", // 显示标题
                    "mData": "id", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "2%"
                },
                {
                    "sTitle": "<center>标题</center>", // 显示标题
                    "mData": "name", // 属性
                    "bSortable": false,// 排序
                    "sClass": "center",
                    "sWidth": "5%"
                },
                {
                    "sTitle": "<center>类型</center>", // 显示标题
                    "mData": "typeId", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "4%"
                },
                {
                    "sTitle": "<center>更新时间</center>", // 显示标题
                    "mData": "updateTime", // 属性
                    "bSortable": true,// 排序
                    "sClass": "center",
                    "sWidth": "4%"
                },
                {
                    "sTitle": "<center>操作</center>", // 显示标题
                    "bSortable": false,// 排序
                    "mData": "id", // 属性
                    "sClass": "center",
                    "sWidth": "2%",
                    "mRender": function (data, style, obj) {
                       // console.log(obj);
                      //  <a class="btn btn-info" href="${ctx}/news/preSave"
                        var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" onclick=\"preUpdate("+obj.id+")\" >修改</a>";
                        var delDom ="<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel("+obj.id+")\" >删除</a>";
                        return xqDom + "&nbsp;&nbsp;&nbsp;&nbsp;"
                            + delDom;
                    }
                }];
            setting.aaSorting = [[0, "desc"]];
            setting.bStateSave = false;
            dataTable = $('#datatable_tabletools').dataTable(setting);
            var rule = {
                m_name: {
                    name: "标题",
                    method: {
                        required: true,
                        lt: 50
                    }
                },
                m_author: {
                    name: "作者",
                    method: {
                        required: true,
                        lt: 20
                    }
                },
                m_typeId: {
                name: "文章类型",
                    method: {
                    required: true
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
 * 发送添加请求
 * @returns {boolean}
 */
function save() {
    var name = $("#m_name").val();
    var author = $("#m_author").val();
    var typeId = $("#m_typeId").val();
    var content = $("#m_content").val();
    if (!validator.validate())
        return false;
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/news/save",
        type: "post",
        datatype: "json",
        data: {
            typeId:typeId,
            name: name,
            author: author,
            content: content
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
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/newsType/queryById",
        type: "post",
        datatype: "json",
        data: {
            id: id
        },
        success: function (data) {
            var user=data;
             $("#m_name1").val(user.data.name);
             console.log(user);
        }
    });
    $("#updateButton").replaceWith("<button type=\"button\" onclick=\"update("+id+")\" class=\"btn btn-info\" id=\"updateButton\">确认修改</button>");
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
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/newsType/update",
        type: "post",
        datatype: "json",
        data: {
            id:id,
            name: name
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
        url: G_CTX_ROOT + "/newsType/delete",
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


