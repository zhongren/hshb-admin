$(document)
		.ready(
				function() {
					var order_id=$("#order_id").val();
					setting.sAjaxSource = G_CTX_ROOT+"/orderDetail/query/"+order_id+"";
					setting.aoColumns = [
						{
							"sTitle" : "商品编号", //显示标题
							"mData" : "goods_id", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "4%"
						},
						{
							"sTitle" : "购买数量", //显示标题
							"mData" : "num", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "金额", //显示标题
							"mData" : "price", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "充值账户", //显示标题
							"mData" : "account", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "账户密码", //显示标题
							"mData" : "account_password", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						]
					setting.aaSorting = [ [ 3, "desc" ] ];
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
function preDel(id) {
	//alert(id);
	$("#myModal").modal("show").css({
		'top' : '60px'
	});
	$("#d").attr("onClick","del("+id+")");
}
function del(id) {
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/goodsType/delete/",
		type : "post",
		datatype : "json",
		data : {
			p_id : id,
		},
		success : function(data) {
			$("#myModal").modal("hide")
			msgBox(data.state, data.msg);
			dataTable.fnDraw();
		},
	});
}