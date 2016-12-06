$(document)
		.ready(
				function() {
					setting.sAjaxSource = G_CTX_ROOT+"/newsType/query";
					setting.aoColumns = [
						{
							"sTitle" : "<center>类型名称</center>", //显示标题
							"mData" : "type_name", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "5%",

						},
						{
							"sTitle" : "<center>描述</center>", //显示标题
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
								var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/newsType/preUpdate/"+obj.id+"\" >查看详情</a>";
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
							name : "类型名称",
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
function addNewsType() {

	var type_name = $("#m_type_name").val();
	var desc = $("#m_desc").val();
	if (!validator.validate())
		return false;
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/newsType/add",
		type : "post",
		datatype : "json",
		data : {
			p_type_name : type_name,
			p_desc : desc
		},
		success : function(data) {
			msgBox(data.state, data.msg);
		},
	});
}
function updateGoodsType() {

	var id=$("#m_id").val();
	var name = $("#m_name").val();
	var desc = $("#m_desc").val();
	if (!validator.validate())
		return false;
	$.ajaxInvoke({
		url : G_CTX_ROOT+"/newsType/update",
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
		url : G_CTX_ROOT+"/newsType/delete/",
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