$(document)
		.ready(
				function() {
					var roleId=$("#roleId").val();
					//console.log(roleId);
					var role={};
					if(roleId != ""){
						role.roleId=roleId;
						$.ajaxInvoke({
							url 	: 	G_CTX_ROOT+"/role/getAllPermissionByRoleId" ,
							data :role,
							success	:	function(returnData){
								returnData= JSON.parse(returnData);
								console.log(returnData);
								$.each(returnData.aaData, function(key,value) {

									$('.permission-checkbox').each(function(key1,value1){
										var policyidcheckbox=$.trim($(this).attr("value"));
										if(value.p_permission_id==policyidcheckbox){
											$(this).prop("checked",true);
											//$(this).prop("disabled",true);
										}
									});

								});

							},
							error	:	"操作失败",
							dataType:	"html"
						});


					}
				});
function addPermission(){
	var role={};
	role.roleName=$("#roleName").val();
	role.roleDesc=$("#roleDesc").val();
	var permList="";
	$('input:checkbox:checked').each(function() {
		var id=$.trim($(this).attr("value"));
		permList=permList+";"+id;
	});
	var postURL = G_CTX_ROOT+"/role/add";

	role.permissionlist=permList;
	$.ajaxInvoke({
		url : postURL,
		type : "post",
		data : role,
		success : function(data) {
			msgBox(data.state, data.msg);
		},
	});
}
function updatePermission(){
	var role={};
	role.roleName=$("#roleName").val();
	role.roleDesc=$("#roleDesc").val();
	role.roleId=$("#roleId").val();
	var permList="";
	$('input:checkbox:checked').each(function() {
		var id=$.trim($(this).attr("value"));
		permList=permList+";"+id;
	});
	var postURL	 = G_CTX_ROOT+"/role/update";
	role.permissionlist=permList;
	$.ajaxInvoke({
		url : postURL,
		type : "post",
		data : role,
		success : function(data) {
			msgBox(data.state, data.msg);
		}
	});
}
