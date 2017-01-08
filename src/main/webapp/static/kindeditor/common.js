/**
 * Created by Server on 2016/7/15.
 */
KindEditor.ready(function () {
    //创建富文本编辑器
    editor = KE.createEditor("#editor");
    KE.init();
});


var KE = {
    kingEditorParams: {
        //指定上传文件参数名称
        filePostName: "uploadFile",
        //指定上传文件请求的url。
        //uploadJson: '/testUpload',
        uploadJson: '/file/upload',
        //上传类型，分别为image、flash、media、file
        dir: "file"
    },

    createEditor: function (select) {
        return KindEditor.create(select, KE.kingEditorParams);
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
                KindEditor.editor(KE.kingEditorParams).loadPlugin('image', function () {
                    this.plugin.imageDialog({
                        showRemote: false,
                        clickFn: function (url, title, width, height, border, align) {
                            $("#"+id).remove();
                            $(e).next("div").remove();
                            $(e).after("<input type='hidden' id='" + id + "' value='" + url + "'>" +
                                "<div style='margin-top: 20px;'><a href='" + url + "' target='_blank'><img src='" + url + "' width='80' height='80'/></a></div>");
                            this.hideDialog();
                        }
                    });
                });
            });
        });
    }
};
