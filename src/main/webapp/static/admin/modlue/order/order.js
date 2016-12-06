$(document)
		.ready(
				function() {
					setting.sAjaxSource = G_CTX_ROOT+"/order/query";
					setting.aoColumns = [
						{
							"sTitle" : "订单号", //显示标题
							"mData" : "id", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "用户编号", //显示标题
							"mData" : "user_id", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "充值账号", //显示标题
							"mData" : "user_account", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "商品编号", //显示标题
							"mData" : "goods_id", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "商品名称", //显示标题
							"mData" : "goods_name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
							/*
						{
							"sTitle" : "区服", //显示标题
							"mData" : "server", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
							*/
						{
							"sTitle" : "金额", //显示标题
							"mData" : "total_price", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "下单时间", //显示标题
							"mData" : "create_time", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "4%"
						},
						{
							"sTitle" : "完成时间", //显示标题
							"mData" : "update_time", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "4%"
						},
						{
							"sTitle" : "订单状态", //显示标题
							"mData" : "status", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "处理人", //显示标题
							"mData" : "dealuser_name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "2%"
						},
						{
							"sTitle" : "<center>操作</center>", // 显示标题
							"bSortable" : false,// 排序
							"mData" : "id", // 属性
							"sClass" : "center",
							"sWidth" : "5%",
							"mRender" : function(data, style, obj) {
								var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" onclick=\"preDeal(" + obj.id + ")\" >完成订单</a>";
								var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preCancel("+obj.id+")\" >取消订单</a>";
								return xqDom + "&nbsp;&nbsp;"
										+ delDom;
							}
						}];
					setting.aaSorting = [ [ 7, "desc" ] ];
					setting.bStateSave = false;
					dataTable = $('#datatable_tabletools').dataTable(setting);
				});
function doSearch() {
	dataTable.fnDraw();

}

function updateGoodsType() {

	var id=$("#m_id").val();
	var name = $("#m_name").val();
	var desc = $("#m_desc").val();
	if (!validator.validate())
		return false;
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/goodsType/update",
		type : "post",
		datatype : "json",
		data : {
			p_id:id,
			p_type_name : name,
			p_desc : desc,
		},
		success : function(data) {
			msgBox(data.state, data.msg);
		},
	});
}
function preDeal(id) {
	//alert(id);
	$("#myModal").modal("show").css({
		'top' : '60px'
	});
	$("#deal").attr("onClick","deal("+id+")");
}
function preCancel(id) {
	//alert(id);
	$("#myModal2").modal("show").css({
		'top' : '60px'
	});
	$("#cancel").attr("onClick","cancel("+id+")");
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
function cancel(id) {
	//alert(id);
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/order/cancel/",
		type : "post",
		datatype : "json",
		data : {
			p_id : id
		},
		success : function(data) {
			//alert(data);
			$("#myModal2").modal("hide")
			msgBox(data.state, data.msg);
			dataTable.fnDraw();
		},
	});
}