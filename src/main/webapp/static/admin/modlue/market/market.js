$(document)
		.ready(
				function() {
					setting.sAjaxSource = G_CTX_ROOT+"/market/query";
					setting.aoColumns = [
						{
							"sTitle" : "会员编号", //显示标题
							"mData" : "user_id", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},

						{
							"sTitle" : "销售员编号", //显示标题
							"mData" : "sys_user_id", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "销售员姓名", //显示标题
							"mData" : "sys_user_name", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "创建时间", //显示标题
							"mData" : "create_time", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "5%"
						},
					];
					setting.aaSorting = [ [ 3, "desc" ] ];
					setting.bStateSave = false;
					dataTable = $('#datatable_tabletools').dataTable(setting);
					var rule = {
						m_sys_user_id: {
							name: "销售员编号",
							method: {
								required: true,
							}

						},
						m_user_id: {
							name: "会员编号",
							method: {
								required: true,

							}

						}
					};
					validator.init(rule);
				});
function doSearch() {
	dataTable.fnDraw();

}

function add() {

	var user_id=$("#m_user_id").val();
	var sys_user_id = $("#m_sys_user_id").val();
	if (!validator.validate())
		return false;
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/market/add",
		type : "post",
		datatype : "json",
		data : {
			p_user_id:user_id,
			p_sys_user_id : sys_user_id
		},
		success : function(data) {
			msgBox(data.state, data.msg);
		}
	});
}
function preDeal(id) {
	//alert(id);
	$("#myModal").modal("show").css({
		'top' : '60px'
	});
	$("#deal").attr("onClick","deal("+id+")");
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