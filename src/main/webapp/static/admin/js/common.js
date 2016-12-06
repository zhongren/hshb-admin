/**
 * parse data table
 */
(function(win){
	var isHistoryFlag = $("#isHistory").val() ;
	$("#isHistory").val("0") ;
	var loadFirst = true ;
	var postDT = {
		parseDT : function( sSource , aoData , fnCallback ){
					var contextArgs = {} ;
					if(self.frameElement && self.frameElement.tagName == "IFRAME" && parent.window.contextArgs){
						contextArgs = parent.window.contextArgs ;
					}
					$("[name^='s_']").each(function(){
						var name = $(this).attr("name") ;
						var value = $(this).val() ;
						if(self.frameElement && self.frameElement.tagName == "IFRAME" 
							&& parent.window.contextArgs && loadFirst && isHistoryFlag =="0"  ){
							if( parent.window.contextArgs[name] ){
								 value =  parent.window.contextArgs[name]  ;
								 $("[name='" + name + "']").val( parent.window.contextArgs[name] ) ;
								 $("select[name='"+name+"']").attr("preVal" , parent.window.contextArgs[name] ) ;
							}
						}
						aoData.push({"name" : name , "value" : value }) ;
						contextArgs[name] = value ;
					});
					if(self.frameElement && self.frameElement.tagName == "IFRAME" ){
						parent.window.contextArgs = contextArgs ;
					}

					$.ajax({
						url 	: 	sSource ,
						type	: 	"post" ,
						async	:	true ,
						data	:	aoData ,
						success	:	fnCallback ,
						dataType:	"json" ,
						statusCode	:	{
							401	:	function(){
										console.error("401:"+sSource) ;
										//location.href="/admin/login?statusCode=401&url="+sSource ;
									},
							404	:	function(){
										console.error("404:"+sSource) ;
									},
							500	:	function(){
										console.error("500:"+sSource) ;
									},
							408	:	function(){
										console.error("408:"+sSource) ;
										//location.href=G_CTX_ROOT+"/login?statusCode=408&url="+sSource ;
									},
						},
						
					});
					loadFirst = false ;
					$("#selfFlag").val("1");
				  },
		paseStatus:	function( data , status , fnCallback ){
						
					} ,
	};
	win.util = postDT ;
})(window) ;


$(".hide-tab-panel").show();
$('.slide-tab li.active').addClass("selected1");
$(".slide-tab li.active").click(function(){
    $(".hide-tab-panel").slideToggle("fast");
    $(this).toggleClass("selected1");
});

/**
*	DataTable Setting
*/

//DataTable language setting
(function(win){
	var lan = {       
		    "sLengthMenu": "每页显示 _MENU_ 条记录",
		    "sZeroRecords": "没有检索到数据",
		    "sInfo": "共有 _TOTAL_ 条记录",
		    "sInfoEmtpy": "没有数据",
		    "sProcessing":  "<img src='"+G_CTX_ROOT+"/staticAdmin/img/lding.gif'/>",
		    "search" : "查询" ,
		    "sInfoEmpty": "共 0 条记录",
		    "bStateSave": false,
		    "oPaginate": {
		        "sFirst": "首页",
		        "sPrevious": "上一页",
		        "sNext": "下一页",
		        "sLast": "尾页"
		    }
		};
	var setting = {} ;	
	setting.iDisplayLength = 10; 
	setting.oLanguage = lan ;	//语言设置 
	setting.bPaginate = true ;  //是否分页。
	setting.sPaginationType =  "bootstrap" ;  //全分页
	setting.bJQueryUI = false ;  //jQueryUI
	setting.bAutoWidth = true ; //自动计算Table宽度
	setting.bProcessing =  true ; //当datatable获取数据时候是否显示正在处理提示信息。
	setting.sServerMethod = "POST";
	setting.bServerSide = true ;
	setting.bFilter = false;
	setting.bStateSave = true ;
	//setting.sDom="<t<'span12 center'p>>";
	setting.aLengthMenu = [[10, 25, 50,1], [10, 25, 50,1]] ;
	setting.callbackStack = {
			stack	: [] ,
	};
	setting.callbackStack.stack.push(
		function(){
			$.checkCasecade({
				parent : "checkbox-checkall" ,
				children : "item-checkbox" 
			});		
		}
	);
	setting.fnDrawCallback = function(){	
		
		for(var callback in setting.callbackStack.stack ){
			setting.callbackStack.stack[callback]() ;
		}		
		$("#datatable_tabletools tr:last-child").css("border-bottom","1px solid #CCCCCC");
		$("body").removeAttr("style");
	};
	
	
	setting.fnInitComplete = function(setting){		
		$("#datatable_tabletools").css("width","100%");
		//$("#datatable_tabletools th").css("width","auto");
		//$("#datatable_tabletools tr:last-child").css("border-bottom","1px solid #CCCCCC");
	
		
	};
	
	
	setting.fnRowCallback = function(nRow, aData, iDisplayIndex, iDisplayIndexFull){

		//$('tr', nRow).css("border-bottom","1px solid #CCCCCC");
		//$("#datatable_tabletools tr:last-child").css("border-bottom","1px solid #CCCCCC");
	};
	
	setting.fnServerData = function( sSource , aoData , fnCallback ){
		util.parseDT(sSource , aoData , fnCallback ) ;
		$('.checkbox-checkall').prop("checked",false);
	};
	var dataTable ;
	win.setting = setting ;
	win.dataTable = dataTable ;
	
	
})(window) ;





/**
*	Modal Message Alert
*/
//Alert Modal

(function(win){
	var mAlert = function (bMsg , title  , btnMsg ){
		var bodyMsg = typeof(bMsg) == "undefined" || bMsg == "" ? "" : bMsg;
		var titleMsg = typeof(title) == "undefined" || title == "" ? "提示！" : title;
		var buttonMsg = typeof(btnMsg) == "undefined" || btnMsg == "" ? "关闭" : btnMsg;
		$("#alertModelLabel").html( titleMsg ) ;
		$("#lertModelBody").html( bodyMsg ) ;
		$("#lertModelBtnClose").html( buttonMsg ) ;
		$("#alertModal").modal("show");
	};
	win.mAlert = mAlert ;
})(window);

(function(win){
	var mConfirm = function ( bMsg , callBack , title  , btnClose , btnActive ){
		var bodyMsg = typeof(bMsg) == "undefined" || bMsg == "" ? "" : bMsg;
		var titleMsg = typeof(title) == "undefined" || title == "" ? "提示！" : title;
		var btnCloseMsg = typeof(btnClose) == "undefined" || btnClose == "" ? "取消" : btnClose;
		var btnActiveMsg = typeof(btnActive) == "undefined" || btnActive == "" ? "确定" : btnActive;
		$("#confirmModelLabel").html( titleMsg ) ;
		$("#confirmModelBody").html( bodyMsg ) ;
		$("#confirmModelBtnClose").html( btnCloseMsg ) ;
		$("#confirmModelBtnActive").html( btnActiveMsg ) ;
		if( typeof(callBack) == "function" ){
			$("#confirmModelBtnActive").unbind("click");
			$("#confirmModelBtnActive").click(callBack) ;
		} 
		$("#confirmModal").modal("show");
	};
	win.mConfirm = mConfirm ;
})(window);


(function(win){
	var timer = "" ;
	var task = function(){
		$("#success-box").addClass("hidden") ;
		$("#warning-box").addClass("hidden") ;
	};
	var msgBox = function( type , body , title ){
		if( type == "fail" ){
			typeof( body ) != "undefined" ? $("#warning-box-body").text(body) :  $("#warning-box-body").text("") ;
			typeof( title ) != "undefined" ? $("#warning-box-title").text(title) :  $("#warning-box-title").text("警告！") ;
			$("#warning-box").removeClass("hidden") ;
		}else{
			typeof( body ) != "undefined" ? $("#success-box-body").text(body) :  $("#success-box-body").text("") ;
			typeof( title ) != "undefined" ? $("#success-box-title").text(title) :  $("#success-box-title").text("提示！") ;
			$("#success-box").removeClass("hidden") ;
		}
		timer = setTimeout(task , 5000 ) ;
	};
	
	$("#warning-box .close").html("");
	$("#success-box .close").html("");
	win.msgBox = msgBox ;

	
})(window) ;
/**
*	Ajax Invoke
*/
(function(jqeury){
	var ajaxInvoke = function ( args ) {
		var url = args.url ;
		var enumType = ["get","GET","post","POST"];
		var type = typeof( args.type ) != "undefined" && enumType.indexOf(args.type)!= -1? args.type : "post" ;
	
		var data = typeof( args.data ) != "undefined" ? args.data : "" ;
		var sync = typeof( args.sync ) != "boolean" ? true : args.sync ;
		var success = function(data){} ;
		if( typeof(args.success) == "string" ){
			success = function(data , state){
				mAlert( args.success ) ;
			};
		}else if( typeof(args.success) == "function" ){
			success = args.success ;
		}else{
			success = function( data , status ){
				if( data.msgType == 1 ){
					msgBox( data.state , data.msg ) ;
				}else if( data.msgType == 0 ){
					mAlert( data.msg ) ;
				}
			} ;
		}
		
		var error = null ;
		if(typeof(args.error) == "string"){
			error = function(){
				mAlert( args.error ) ;
			};
		}else if( typeof( args.error ) == "function" ){
			error = args.error ;
		}else{
			error = function (data , status ) {
				/**
				if( status == "error" ){
					mAlert("请求失败！");
				}else if( status == "parsererror"){
					mAlert("对象转换失败！");
				}
				*/
			} ;
		}
		var enumDataType = ["html" , "json" ] ;
		
		var dataType = typeof( args.dataType ) != "undefined" && enumDataType.indexOf(args.dataType) != -1 ? args.dataType :"json" ;
		var contentType = typeof( args.contentType ) != "undefined" ? args.contentType : "application/x-www-form-urlencoded" ;
		$.ajax({
			url		: 	url ,
			type	: 	type ,
			async	: 	sync ,
			data 	: 	data ,
			success	: 	success,
			error	: 	error,
			statusCode	:	{
				401	:	function(){
							console.error("401:"+url) ;
							//location.href="/admin/login?statusCode=401&url="+url ;
						},
				404	:	function(){
							console.error("404:"+url) ;
							//location.href="/admin/login?statusCode=404&url="+url ;
						},
				408	:	function(){
							console.error("408:"+url) ;
							//location.href=G_CTX_ROOT+"/login?statusCode=408&url="+url ;
						},
				500	:	function(){
							console.error("500:"+url) ;
							//location.href="/admin/login?statusCode=500&url="+url ;
						},
					},
			dataType: 	dataType ,
			cache	:	false,
			contentType : contentType ,
		});
	};
	jqeury.ajaxInvoke = ajaxInvoke ;
})($);





/**
 * Validator
 */
function DataValidator(){
	
	this.rule = {} ;
	this.isBlur = true ; 
	var required = function(field , active , message){
		if( active == "false" ) return true ;
		var msg = message + "不能为空!" ;
		var val = $("#"+field).val() ;
		var bRtn = val!=null && typeof(val) != "undefined" && val.replace(/(^\s*)|(\s*$)/g,"") != "" ;		
		setMsg(field , msg , bRtn ) ;
		return  bRtn;
	};
	var gt = function( field , number , message ){
		if($("#"+field).val()=="")return true ;
		var msg = message + "长度大于等于"+number+"!" ;
		var val = $("#"+field).val() ;
		var bRtn = val.length >= parseInt( number ) ;
		setMsg(field , msg , bRtn ) ;
		return  bRtn;
	} ;
	var lt = function( field , number , message ){
		if($("#"+field).val()=="")return true ;
		var msg = message + "长度小于等于"+number+"!" ;
		var val = $("#"+field).val() ;
		var bRtn = val.length <= parseInt( number ) ;
		setMsg(field , msg , bRtn ) ;
		return  bRtn;
	};
	var email = function( field , active , message ){
		if($("#"+field).val()=="")return true ;
		if( active == "false")return true ;
		var msg = message + "email格式不正确"+"!" ;
		 var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/; 
		 var val = $("#"+field).val() ;
		 var bRtn =pattern.test(val);
		 setMsg(field , msg , bRtn ) ;
		return  bRtn;
	};
	var phone = function( field , active , message ){
		if($("#"+field).val()=="")return true ;
		if( active == "false")return true ;
		var msg = message + "格式不正确";
		//var isMobile=/^1[3|4|5|8][0-9]\d{4,8}$/; 
		var isMobile=/^[0-9]{11}$/;
		var bRtn = isMobile.test($("#"+field).val()) ;
		setMsg(field , msg , bRtn ) ;
		return bRtn ;
	};
	var isNum = function( field , active , message ){
		if($("#"+field).val()=="")return true ;
		if( active == "false" ) return true ;
		var msg = message + "不是数字类型" ;
		var bRtn = !isNaN( $("#"+field).val()) ;
		setMsg(field , msg , bRtn ) ;
		return bRtn ;
		
	};
	var notNum = function( field , active , message ){
		if($("#"+field).val()=="")return true ;
		if( active == "false" ) return true ;
		var msg = message + "不能全部是数字" ;
		var bRtn = isNaN( $("#"+field).val()) ;
		setMsg(field , msg , bRtn ) ;
		return bRtn ;
		
	};
	var eq = function( field , val , message ){
		if($("#field").val() == "" ) return true ;
		var msg = message + "不一致" ;
		var bRtn = ($("#"+field).val() == $("#"+val).val()) ;
		setMsg( field , msg , bRtn ) ;
		return bRtn ;
	};
	var fixLen = function( field , val , message ){
		var msg = message + "长度应为"+ val + "位" ;
		var bRtn = ($("#"+field).val().length == val) ;
		setMsg( field , msg , bRtn ) ;
		return bRtn ;
	};
	var setMsg = function( field , msg , b){	
		if(b){
			$("#"+field).prevAll().filter("span").html("") ;
			return ;
		}
		$("#"+field).prevAll().filter("span").html("<font color=red >" +msg+ "</font>") ;
	};
	this.clearForm = function(){
		for( var field in this.rule ){
			if( this.rule[field].defaultValue != "undefined" ){
				$("#"+field).val( this.rule[field].defaultValue ) ;
			}else{
				$("#"+field).val("") ;
			}
			setMsg( field , "" ) ;
		}
	};
	
	var Callback = function(){
		var blurCallbackStack = [];
		var focusCallbackStack = [] ;
		this.setBlurCallback = function(bcs){
			blurCallbackStack = bcs ;
		};
		this.setFocusCallback = function(fcs){
			focusCallbackStack = fcs ;
		};
		this.blureCallback = function(){
			if( blurCallbackStack.length  == 0 ) return false ;
			for( var bc in blurCallbackStack ){
				if( typeof( blurCallbackStack[bc] ) == "function" ){
					if(!blurCallbackStack[bc]() ) break;
				}else if( typeof(blurCallbackStack[bc]) == "string"){
					if(!eval(blurCallbackStack[bc]))break ;
				}
			}
		};
		this.focusCallback = function(){
			if(focusCallbackStack.length == 0 ) return false ;
			for(var fc in focusCallbackStack ){
				if( typeof(focusCallbackStack[fc]) == "function"){
					if(!focusCallbackStack[fc]()) break ;
				}else if(typeof(focusCallbackStack[fc]) == "string"){
					if(!eval(focusCallbackStack[fc]))break ;
				}
				
			}
		};
	};
	
	this.init = function( rule ){
		this.rule = rule ;
		for( var r in rule ){
			var blurCallbackStack = [] ;
			var focusCallbackStack = [] ;
			if(! document.getElementById(r)){

			}
			
			
			var field = r ;
			var name = rule[r].name ;
			var ms = rule[r].method ;
			for( var m in ms ){
				var func = m + "('" + field + "','" + ms[m]+"','" + name +"')" ; 
				blurCallbackStack.push(func) ;
			}
			if( typeof( rule[r].onBlur ) == "function" ){
				blurCallbackStack.push( rule[r].onBlur );
			}
			if( typeof( rule[r].onFocus ) == "function" ){
				focusCallbackStack.push( rule[r].onFocus );
			}
			var callBackObj = new Callback() ;
			callBackObj.setBlurCallback(blurCallbackStack) ;
			callBackObj.setFocusCallback(focusCallbackStack) ;
			if(document.getElementById(r)){
				document.getElementById(r).onblur = callBackObj.blureCallback ;
				document.getElementById(r).onfocus = callBackObj.focusCallback ;
			}
			
		}
	};
	this.validate = function(){
		var success = true ;
		for( var field in this.rule ){
			var fieldSuccess = true;
			var msg = this.rule[field].name ;
			var vs = this.rule[field].method ;
			for( var m in vs ){
				var func = m+"('"+field+"' , '"+vs[m]+"' , '"+ msg +"' )" ;
				if( !eval( func) ){
					success = false ;
					fieldSuccess = false;
					break ;
				}
			}
			
			if(fieldSuccess){
				$("#"+field).nextAll().filter("span").html("") ;
			}
			
		}
		return success ;
	};
}
(function(win){win.validator = new DataValidator() ;})(window) ;

/**
 * 省市区级联操作
 * 使用方法
 * 
 * 方法描述
 * load( parentId ) 根据parentId加载选项
 * init 初始化控件 使用参数依次为 标签ID、ajaxSource、下一结点对象、默认第一行显示文字【key为-1】
 * 使用方法
 * var selCasecade = new SelectCasecade() ;
 * var selCity = new SelectCasecade() ;
 * var selArea = new SelectCasecade() ;
 * selCasecade.init("provence" ,"${ctx}/sysArea/findProvinces" , selCity , "请选择省" ).load() ;
 * selCity.init("city" ,"${ctx}/sysArea/findCities" , selArea , "请选择市") ;
 * selArea.init("area" , "${ctx}/sysArea/findAreas" ,"" , "请选择区" ) ;
 */
function SelectCasecade(){
	var field ;
	var ajaxSource ;
	var nextNode ;
	var key ;
	var fillValue = "" ;
	var header ;
	var dataAllFlag = false ;
	var selectedIndex = 0 ;
	this.load = function( parentId , callback,nodeid,value ){
		var url = ajaxSource ;
		if( parentId == "" ){
			parentId = "-2" ;
		}
		if( typeof( parentId ) != "undefined" && parentId != "-1"){
			url +=  "/" + parentId ;
		}

		$.ajaxInvoke({
			url		:	url ,
			type	:	"post" ,
			dtaType	:	"json" ,
			cache	:	false,
			data	:	{
							dataAllFlag  : dataAllFlag ,
						},
			success	:	function( data , status ){
							if( data.state == "fail" ){
								mAlert( data.msg ) ;
							}else{
								initOption( data.data ) ;
								if( typeof(fillValue)!="undefined" && fillValue!="" ){
									$("#"+field).val(fillValue) ;
								}
								if( selectedIndex != 0 && selectedIndex < $("#"+field).get(0).length ){
									$("#"+field).get(0).selectedIndex =  selectedIndex ;
								}
								if( $("#"+field).attr("preVal") &&  $("#"+field).attr("preVal")!= "" ){
									$("#"+field).val($("#"+field).attr("preVal")) ;
								}
								selectedIndex = 0 ;
								if( typeof( nextNode ) == "object"){
									childNodeLoad() ;
								}
							}
						},
			sync	:	false 
		});
		
		if(typeof( callback ) == "function"){
			callback();
		}
	};
	this.setValue = function ( value ){
		fillValue = value ;
	};
	this.setSelectedIndex = function( index ){
		selectedIndex = index ;
	};
	this.setDataScopeAll = function( flag ){
		if( typeof( flag ) == "boolean" ){
			dataAllFlag = flag ;
		}
	};
	var initOption = function( data ){
		$("#"+field).empty() ;
		if( data.length != 1 ){
			if( typeof( header ) != "undefined" ){
				$("#"+field).append("<option value=''>"+header+"</option>") ;
			}
		}
		data.sort(function(a,b){
			if(a && b){
				return a.name.localeCompare(b.name)
			};//汉字拼音排序方法
		});
		
		for( i = 0 ; i < data.length ; i ++ ){
			$("#"+field).append("<option value='"+data[i].id+"'>"
					+data[i].name+"</option>") ;
		}
		if( data.length == 1 && typeof(nextNode) == "object" ){
			nextNode.load($("#"+field+" option:first").val());
		}
		
	};
	var childNodeLoad = function(){
		nextNode.load( $("#"+field).val() ) ;
	};
	this. init = function( argField , argAjaxSource , argNextNode 
			,  argHeader ,  argValue  ){
		
		if( typeof($("#"+argField).val()) == "undefined" ){
			return this;
		}
		field = argField ;
		ajaxSource = argAjaxSource ;
		nextNode = argNextNode ;
		header = argHeader ;
		fillValue = argValue ;
		
		if( typeof(argNextNode) == "object"){
			nextNode = argNextNode ;
			document.getElementById(field).onchange=childNodeLoad ;
		}
		$("#"+field).empty() ;
		if( typeof( header ) != "undefined" ){
			$("#"+field).append("<option value=''>"+header+"</option>") ;
		}
		return this ;
	};
	this.clearOption = function(){
		$("#"+field).empty() ;
		if( typeof( header ) != "undefined" ){
			$("#"+field).append("<option value=''>"+header+"</option>") ;
		}
	};
	this.val = function(value){
		if(typeof( value ) != "undefined"){
			if( typeof(argNextNode) == "object"){
				childNodeLoad() ;
			}
			return $("#"+field).val(value) ;
		}else{
			return $("#"+field).val() ;
		}
	};

};
/**
 *  	$.checkCasecade({
			parent : "checkbox-checkall" ,
			children : "item-checkbox" 
		});
 */
(function(jquery){
	var checkCasecade = function (arg){
		
		var parent = arg.parent ;
		var children = arg.children ;
		gloParent = parent ;
		gloChildren = children ;
		$("."+parent).unbind("change").bind("change",function(){
			changeChild( children , $(this).is(":checked") ) ;
		});
		
	};
	
	var changeChild = function( name , status ){
			$("."+name).prop("checked" , status );
			
	};
	var checkValues = function( arg ){
		var className = "item-checkbox";
		if(typeof( arg ) != "undefined" ){
			className = arg ;
		}
		var values = [] ;
		$("."+className).each(function(){
			if($(this).is(":checked")){
				values.push($(this).val()) ;
			}
		});
		return values ;
	};
	jquery.checkCasecade = checkCasecade ;
	jquery.checkedValues = checkValues ;
})($) ;


(function(){
	if(self.frameElement && self.frameElement.tagName == "IFRAME") {
		document.body.style.overflow = "scroll" ;
	}
})() ;

/**
*	combox
*/
(function ( jquery ){
	var funBox = function( arg ){
		var combox = {
				arg		:	{
								size	:	10 ,
							},
				data	:	{
					
							},
				init	:	function( arg ){
								if( typeof(arg.url) == "string" && arg.url != ""  ){
									combox.arg.url = arg.url ;
								}else{
									console.error("arg.url is undefined") ;
									return ;
								}
								if( typeof(arg.size) == "number" ){
									combox.arg.size = arg.size ;
								}
								if( typeof( arg.key ) == "string" && arg.key != "" ){
									combox.arg.key = arg.key ;
								}else{
									console.error("arg.key is undefined") ;
									return ;
								}
								if( typeof( arg.value ) == "string" && arg.value != "" ){
									combox.arg.value = arg.value ;
								}else{
									console.error("arg.value is undefined") ;
									return ;
								}
								if( typeof( arg.field ) == "string" && arg.field != "" ){
									combox.arg.field = arg.field ;
								}else{
									console.error("arg.field is undefined") ;
									return ;
								}
								if( typeof(arg.callBack) == "function" ){
									combox.callBack = arg.callBack ;
								}

								if( typeof( arg.callbackField ) == "string" && arg.key != "" ){
									combox.arg.callbackField = arg.callbackField ;
								}
								if( typeof( arg.blurCallback ) == "function" ){
									combox.arg.blurCallback = arg.blurCallback ;
									$("#"+combox.arg.field).blur(function(){
										arg.blurCallback() ;
									});
								}
								$("#"+combox.arg.field).keyup(combox.loadData) ;
								$("#"+combox.arg.field).click(function(){
									$('#'+combox.arg.field).next("ul").toggle() ;
									if($('#'+combox.arg.field).css("display")!="none"){
										combox.loadData() ;
									}
								});
								$("#"+combox.arg.field).blur(function(){
									setTimeout(function(){
										$('#'+combox.arg.field).next("ul").hide() ;
									},300);
								});
								$('#'+combox.arg.field).next("ul").css("width" , $('#'+combox.arg.field).css('width'));
								return combox ;
							},
				loadData:	function(){
								
								var value = $("#"+combox.arg.field).val() ;
								if( value == combox.oldValue ){
									return ;
								}
								combox.selectedValue.inputBody = value ;
								combox.selectedValue.value ="" ;
								combox.selectedValue.text = "" ;
								if( typeof(combox.callBack) == "function" ){
									(combox.callBack)(combox.selectedValue.value, combox.arg.callbackField) ;
								}
								
								$('#'+combox.arg.field).next('ul').empty() ;
								if( typeof(value) == "undefined" ) return  ;
								value = value.replace(/(^\s+)|(\s+$)/g,"");
								if( value ==  "" ){
									$('#'+combox.arg.field).attr("val", value);
									//return  ;
								}
								url = combox.arg.url ;
								$.ajaxInvoke({
									url		:	url,
									data	:	{
													args :	value ,
												},
										
									success	:	function( content , status ){
													var data = content.data ;
													if(data == null){
														$('#'+combox.arg.field).next('ul').hide() ;
														return ;
													}
													var count = 0 ;
													for( var d in data ){

														var areaId = data[d]['areaId'] ;
														var cityId = data[d]['cityId'] ;
														var provinceId = data[d]['provinceId'] ;
														var text = data[d][combox.arg.value] +  "-" + areaId ;
														
														$('#'+combox.arg.field).next('ul').append("<li><a title='"+(text+"-" + cityId +"-" + provinceId)+"' href=\"javascript:$."+combox.arg.field+".fixOpt('"+data[d][combox.arg.key]+"' , '"+data[d][combox.arg.value]+"')\">"+text+"</a></li>") ;
														if( ++ count >= combox.arg.size){
															break ;
														}
													}
													$('#'+combox.arg.field).next('ul').show() ;
												}
								});
							},
							fixOpt			:	function(value , text){
													if( typeof( value ) != "undefined" ){
														combox.selectedValue.value = value ;
														
														$('#'+combox.arg.field).attr("val", value);
														if($('#'+combox.arg.field).next('ul').next('span')){
															$('#'+combox.arg.field).next('ul').next('span').html('');	
														}
													}
													if( typeof( value ) != "undefined" ){
														combox.selectedValue.text = text ;
														$('#'+combox.arg.field).val(text) ;
														combox.oldValue = text;
														
													}
													$('#'+combox.arg.field).next("ul").hide() ;
													if( typeof(combox.callBack) == "function" ){
														(combox.callBack)(value, combox.arg.callbackField) ;
													}
												},
							selectedValue	:	{
													value		:	"" ,
													text	:	"" ,
													inputBody	:	"" ,
												},
							val				:	function( key ){
														return combox.selectedValue[key] ;
												}
				
			};
		return combox.init( arg );
	};
	jquery.combox = funBox ;
})( $ ) ;

function dynamicSelect(){
	$(".ajaxDynamicData").each(function(){
		var src = $(this).attr("ajaxSource") ;
		var key = $(this).attr("key");
		var text = $(this).attr("text") ;
		if( src == "" || key =="" || text == "" ) return ;
		var obj = $(this) ;
		$.ajaxInvoke({
			url		:	src ,
			success	:	function( content ){
							if(content.data == null){
								return  ;
							}
							var data = content.data ;
							for( var row in data ){
								obj.append("<option value='"+data[row][key]+"'>"+data[row][text]+"</option>") ;
							}
						},
		});
	});
} ;


