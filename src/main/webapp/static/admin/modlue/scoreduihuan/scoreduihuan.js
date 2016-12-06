$(document)
		.ready(
				function() {
					setting.sAjaxSource = G_CTX_ROOT+"/scoreduihuan/query";
					setting.aoColumns = [
						{
							"sTitle" : "商品名", //显示标题
							"mData" : "score_name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "会员编号", //显示标题
							"mData" : "user_id", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "姓名", //显示标题
							"mData" : "user_name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "1%"
						},
						{
							"sTitle" : "电话", //显示标题
							"mData" : "user_phone", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "2%"
						},
						{
							"sTitle" : "地址", //显示标题
							"mData" : "user_address", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "4%"
						},
						{
							"sTitle" : "状态", //显示标题
							"mData" : "status", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "1%"
						},
						{
							"sTitle" : "创建时间", //显示标题
							"mData" : "create_time", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "完成时间", //显示标题
							"mData" : "update_time", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "处理人", //显示标题
							"mData" : "dealuser_name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "1%"
						},
						{
							"sTitle": "<center>操作</center>", // 显示标题
							"bSortable": false,// 排序
							"mData": "id", // 属性
							"sClass": "center",
							"sWidth": "3%",
							"mRender": function (data, style, obj) {
								var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" onclick=\"finish(" + obj.id + ")\" >完成兑换</a>";
								return xqDom ;
							}
						}
					];
					setting.aaSorting = [ [ 3, "desc" ] ];
					setting.bStateSave = false;
					dataTable = $('#datatable_tabletools').dataTable(setting);
				});
function doSearch() {
	dataTable.fnDraw();

}
function preFinish(id) {
	//alert(id);
	$("#myModal").modal("show").css({
		'top' : '60px'
	});
	$("#finish").attr("onClick","finish("+id+")");
}
function finish(id) {

	//alert(id);
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/scoreduihuan/finish/",
		type : "post",
		datatype : "json",
		data : {
			p_id : id
		},
		success : function(data) {
			//alert(data);
			$("#myModal").modal("hide")
			msgBox(data.state, data.msg);
			dataTable.fnDraw();
		}
	});
}

function deal(id) {
	//alert(id);
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/order/deal/",
		type : "post",
		datatype : "json",
		data : {
			p_id : id
		},
		success : function(data) {
			//alert(data);
			$("#myModal").modal("hide")
			msgBox(data.state, data.msg);
			dataTable.fnDraw();
		},
	});
}