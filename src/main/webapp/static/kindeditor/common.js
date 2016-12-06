/**
 * Created by Server on 2016/7/15.
 */
KindEditor.ready(function () {
    //创建富文本编辑器
    editor = LB.createEditor("#editor");
    LB.init();
});


var LB = {
    kingEditorParams: {
        //指定上传文件参数名称
        filePostName: "uploadFile",
        //指定上传文件请求的url。
        uploadJson: '/testUpload',
        //上传类型，分别为image、flash、media、file
        dir: "image"
    },

    createEditor: function (select) {
        return KindEditor.create(select, LB.kingEditorParams);
    },

    init: function () {
        // 初始化图片上传组件
        this.initPicUpload();
    },
    // 初始化图片上传组件
    initPicUpload: function () {
        $(".uploadPicture").each(function (i, e) {
            $(e).click(function () {
                var id = $(e).attr("name");
                KindEditor.editor(LB.kingEditorParams).loadPlugin('image', function () {
                    this.plugin.imageDialog({
                        showRemote: false,
                        clickFn: function (url, title, width, height, border, align) {
                            $(e).prev("#"+id).remove();
                            $(e).next("img").remove();
                            $(e).after("<input type='hidden' id='" + id + "' value='" + url + "'>" +
                                "<a href='" + url + "' target='_blank'><img src='" + url + "' width='80' height='80'/></a>");
                            this.hideDialog();
                        }
                    });
                });
            });
        });
    }
};
