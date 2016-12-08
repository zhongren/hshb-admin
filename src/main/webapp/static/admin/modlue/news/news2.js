$(document)
		.ready(
				function() {
					setting.sAjaxSource = G_CTX_ROOT+"/news/query";
					setting.aoColumns = [
						{
							"sTitle" : "<center>标题</center>", //显示标题
							"mData" : "title", //属性
							"bSortable" : false,//排序
							"sClass" : "center",
							"sWidth" : "5%"

						},
						{
							"sTitle" : "<center>创建人</center>", //显示标题
							"mData" : "user_id", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "<center>浏览次数</center>", //显示标题
							"mData" : "browseTime", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "<center>状态</center>", //显示标题
							"mData" : "status", //属性
							"bSortable" : true,//排序
							"sClass" : "center",
							"sWidth" : "3%"
						},
						{
							"sTitle" : "<center>操作</center>", // 显示标题
							"bSortable" : false,// 排序
							"mData" : "id", // 属性
							"sClass" : "center",
							"sWidth" : "5%",
							"mRender" : function(data, style, obj) {
								//console.log(obj);
								var xqDom = "<a class=\"btn btn-round btn-info btn-xs\" href=\"/news/preUpdate/"+obj.id+"\" >查看详情</a>";
								var delDom = "<a class=\"btn btn-round btn-danger btn-xs\" onclick=\"preDel("+obj.id+")\" >删除</a>";
								return xqDom + "&nbsp;&nbsp;&nbsp;&nbsp;"
										+ delDom;
							}
						}];
					setting.aaSorting = [ [ 3, "desc" ] ];
					setting.bStateSave = false;
					dataTable = $('#datatable_tabletools').dataTable(setting);
					var rule = {
						m_title : {
							name : "标题",
							method : {
								required : true,
							}

						}
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
function addNews() {
	var photo=$("#picUrlVal").val();
    var title= $("#m_title").val();
	var type_id = $("#m_type_id").val();
	var url = $("#m_url").val();
	//getContent();
	var htmlPart = UE.getEditor('editor').getContent();

	//alert("123"+UE.getEditor('editor').getContent());

	if (!validator.validate())
		return false;

	$.ajaxInvoke({
		url : G_CTX_ROOT+"/news/add",
		type : "post",
		datatype : "json",

		data : {
			p_type_id : type_id,
			p_title :title,
			p_photo1 : photo,
			p_url : url,
			p_htmlPart : htmlPart

		},
		success : function(data) {
			msgBox(data.state, data.msg);
		}
	});
}
function updateNews() {


	var photo=$("#picUrlVal").val();
	var id= $("#m_id").val();
	var title= $("#m_title").val();
	var type_id = $("#m_type_id").val();
	var url = $("#m_url").val();
	//getContent();
	var htmlPart = UE.getEditor('editor').getContent();

	//alert("123"+UE.getEditor('editor').getContent());

	if (!validator.validate())
		return false;

	$.ajaxInvoke({
		url : G_CTX_ROOT+"/news/update",
		type : "post",
		datatype : "json",

		data : {
			p_id:id,
			p_type_id : type_id,
			p_title :title,
			p_photo1: photo,
			p_url : url,
			p_htmlPart : htmlPart


		},
		success : function(data) {
			msgBox(data.state, data.msg);
		}
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
		url : G_CTX_ROOT+"/news/delete/",
		type : "post",
		datatype : "json",
		data : {
			p_id : id
		},
		success : function(data) {
			$("#myModal").modal("hide")
			msgBox(data.state, data.msg);
			dataTable.fnDraw();
		},
	});
}
//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
//var ue = UE.getEditor('editor');
//ue.loadServerConfig();

function isFocus(e){
	alert(UE.getEditor('editor').isFocus());
	UE.dom.domUtils.preventDefault(e)
}
function setblur(e){
	UE.getEditor('editor').blur();
	UE.dom.domUtils.preventDefault(e)
}
function insertHtml() {
	var value = prompt('插入html代码', '');
	UE.getEditor('editor').execCommand('insertHtml', value)
}
function createEditor() {
	enableBtn();
	UE.getEditor('editor');
}
function getAllHtml() {
	alert(UE.getEditor('editor').getAllHtml())
}
function getContent() {
	var arr = [];
	arr.push("使用editor.getContent()方法可以获得编辑器的内容");
	arr.push("内容为：");
	arr.push(UE.getEditor('editor').getContent());
	alert(arr.join("\n"));
}
function getPlainTxt() {
	var arr = [];
	arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
	arr.push("内容为：");
	arr.push(UE.getEditor('editor').getPlainTxt());
	alert(arr.join('\n'))
}
function setContent(isAppendTo) {
	var arr = [];
	arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
	UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
	alert(arr.join("\n"));
}
function setDisabled() {
	UE.getEditor('editor').setDisabled('fullscreen');
	disableBtn("enable");
}

function setEnabled() {
	UE.getEditor('editor').setEnabled();
	enableBtn();
}

function getText() {
	//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
	var range = UE.getEditor('editor').selection.getRange();
	range.select();
	var txt = UE.getEditor('editor').selection.getText();
	alert(txt)
}

function getContentTxt() {
	var arr = [];
	arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
	arr.push("编辑器的纯文本内容为：");
	arr.push(UE.getEditor('editor').getContentTxt());
	alert(arr.join("\n"));
}
function hasContent() {
	var arr = [];
	arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
	arr.push("判断结果为：");
	arr.push(UE.getEditor('editor').hasContents());
	alert(arr.join("\n"));
}
function setFocus() {
	UE.getEditor('editor').focus();
}
function deleteEditor() {
	disableBtn();
	UE.getEditor('editor').destroy();
}
function disableBtn(str) {
	var div = document.getElementById('btns');
	var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
	for (var i = 0, btn; btn = btns[i++];) {
		if (btn.id == str) {
			UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
		} else {
			btn.setAttribute("disabled", "true");
		}
	}
}
function enableBtn() {
	var div = document.getElementById('btns');
	var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
	for (var i = 0, btn; btn = btns[i++];) {
		UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
	}
}

function getLocalData () {
	alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
}

function clearLocalData () {
	UE.getEditor('editor').execCommand( "clearlocaldata" );
	alert("已清空草稿箱")
}

$(document).ready(function(){
	$(function() {
		$("#uploadify").uploadify({
			height        : 20,
			removeCompleted:true,
			swf           : G_CTX_ROOT+'/staticUploadify/uploadify.swf',
			width         : 100,
			uploader:  "/upload/pic",
			fileSizeLimit 	: 1000*1024 ,
			fileTypeExts       : '*.jpg;*.png;*.gif',
			fileTypeDesc	  :  '请选择图片！',
			onSelect: function(e, queueId, fileObj){

			},
			onClearQueue	: function (queueItemCount){
				//mAlert(queueItemCount);
			},
			onSelectError : function(file,errorCode,errorMsg) {//当文件选定发生错误时触发
				/*　alert( 'onSelectErrorid: ' + file.id
				 　　+ ' - 索引: ' + file.index
				 　　+ ' - 文件名: ' + file.name
				 　　+ ' - 文件大小: ' + file.size
				 　　+ ' - 类型: ' + file.type
				 　　+ ' - 创建日期: ' + file.creationdate
				 　　+ ' - 修改日期: ' + file.modificationdate
				 　　+ ' - 文件状态: ' + file.filestatus
				 　　+ ' - 错误代码: ' + errorCode
				 　　+ ' - 错误信息: ' + errorMsg);*/

				if(file.size > 1000*1024){
					$("#picUrl2Class").html("<font color=red >文件超出上传限制，请重选择！</font>");
					//$("#picUrl").uploadifyCancel(file.id);
					onClearQueue();
				}else{
					$("#picUrl2Class").html("");
				}

			},
			onQueueComplete : function(stats) {//当队列中的所有文件全部完成上传时触发
				/*alert( '成功上传的文件数: ' + stats.successful_uploads
				 　　+ ' - 上传出错的文件数: ' + stats.upload_errors
				 　　+ ' - 取消上传的文件数: ' + stats.upload_cancelled
				 　　+ ' - 出错的文件数' + stats.queue_errors);*/
			},
			onUploadStart: function(file) {//上传开始时触发（每个文件触发一次）
				/*alert( 'onUploadStart id: ' + file.id
				 　　+ ' - 索引: ' + file.index
				 　　+ ' - 文件名: ' + file.name
				 　　+ ' - 文件大小: ' + file.size
				 　　+ ' - 类型: ' + file.type
				 　　+ ' - 创建日期: ' + file.creationdate
				 　　+ ' - 修改日期: ' + file.modificationdate
				 　　+ ' - 文件状态: ' + file.filestatus ); */
				if(file.size > 1000*1024){
					//mAlert("文件超过1MB,请重新选择！","信息提示");
					$("#picUrl2Class").html("<font color=red>文件超出上传限制，请重选择！</font>");
					onClearQueue();
				}else{
					$("#picUrl2Class").html("");
				}
			},
			onUploadSuccess:function(file, data, response){
				//var json =jQuery.parseJSON(data);
				uploadPicUrl2 = true;
				//div显示文件的名称 以及删除
				$("#advice-required-picUrl2").css("display","");
				$("#advice-required-picUrl2").html(file.name);
				$("#picUrl2Btn-picUrl").css("display","block");
				/* 	$("#imgBox").val("${loginuser.infoUserTab.u_url}"); */
				$("#picUrlVal").val(data);
				//alert(data);

			},
			onUploadError : function(file,errorCode,errorMsg,errorString,swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次）
				/*alert( ' onUploadError id: ' + file.id
				 　　+ ' - 索引: ' + file.index
				 　　+ ' - 文件名: ' + file.name
				 　　+ ' - 文件大小: ' + file.size
				 　　+ ' - 类型: ' + file.type
				 　　+ ' - 创建日期: ' + file.creationdate
				 　　+ ' - 修改日期: ' + file.modificationdate
				 　　+ ' - 文件状态: ' + file.filestatus
				 　　+ ' - 出错的文件数: ' + swfuploadifyQueue.filesErrored
				 　　+ ' - 错误信息: ' + swfuploadifyQueue.errorMsg
				 　　+ ' - 要添加至队列的数量: ' + swfuploadifyQueue.filesSelected
				 　　+ ' - 添加至对立的数量: ' + swfuploadifyQueue.filesQueued
				 　　+ ' - 队列长度: ' + swfuploadifyQueue.queueLength); */
				//alert(errorCode + ",file :" +file);
				//console.log(" file  " + file);
				$("#uploadify").uploadifyCancel(errorCode);
			},
			onError:function(event,queueId,fileObj,errorObj){

				//alert("onError");
				if (errorObj.type === "File Size"){
					alert('文件超出上传大小限制！');
					$("#uploadify").uploadifyCancel(ID);
				}
			}
		});
	});
});