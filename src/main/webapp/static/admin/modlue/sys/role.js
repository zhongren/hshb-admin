$(document)
		.ready(
				function() {
					setting.sAjaxSource = G_CTX_ROOT+"/role/query";
					setting.aoColumns = [
						{
							"sTitle" : "<center>权限角色名称</center>", //显示标题
							"mData" : "name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "5%",

						},
						{
							"sTitle" : "<center>备注</center>", //显示标题
							"mData" : "desc", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "5%"
						},
						{
							"sTitle" : "<center>操作</center>", // 显示标题
							"bSortable" : false,// 排序
							"mData" : "id", // 属性
							"sClass" : "center",
							"sWidth" : "5%",
							"mRender" : function(data, style, obj) {
								var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/role/preUpdate/"+obj.id+"\" >修改</a>";
								var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel("+obj.id+")\" >删除</a>";
								return xqDom + "&nbsp;&nbsp;&nbsp;&nbsp;"
										+ delDom;
							}
						}];
					setting.aaSorting = [ [ 3, "desc" ] ];
					setting.bStateSave = false;
					dataTable = $('#datatable_tabletools').dataTable(setting);
					var rule = {
						m_type_name : {
							name : "角色名称",
							method : {
								required : true,
							},

						},
						m_desc : {
							name : "描述",
							method : {
								required : true,
							},
						},
					};
					validator.init(rule);
				});
function doSearch() {
	dataTable.fnDraw();
}
function preAdd() {
	$("#myModal").modal("show").css({
		'top' : '60px'
	});
}
function preDel(p_id) {
	$("#myModal").modal("show").css({
		'top' : '60px'
	});
	$("#del").attr("onClick","del("+p_id+")");

}
function del(id) {
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/role/delete/",
		type : "post",
		datatype : "json",
		data : {
			p_id : id
		},
		success : function(data) {
			$("#myModal").modal("hide");
			msgBox(data.state, data.msg);
			dataTable.fnDraw();
		}
	});
}

