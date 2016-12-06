$(document)
    .ready(
        function () {
            setting.sAjaxSource = G_CTX_ROOT + "/marketInfo/queryLiushui";
            setting.aoColumns = [
                {
                    "sTitle": "会员编号", //显示标题
                    "mData": "user_id", //属性
                    "bSortable": true,//排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "充值金额", //显示标题
                    "mData": "price", //属性
                    "bSortable": false,//排序
                    "sClass": "center",
                    "sWidth": "3%"
                },
                {
                    "sTitle": "充值时间", //显示标题
                    "mData": "create_time", //属性
                    "bSortable": true,//排序
                    "sClass": "center",
                    "sWidth": "5%"
                }
            ];
            setting.aaSorting = [[2, "desc"]];
            setting.bStateSave = false;
            dataTable = $('#datatable_tabletools').dataTable(setting);
        });
function doSearch() {
    dataTable.fnDraw();

}
