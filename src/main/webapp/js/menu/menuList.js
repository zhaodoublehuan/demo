function editMenu(){
	 $('#editMenuModal .modal').modal('show');
}
/**
 * 点击添加用户，展示添加modal
 */
function addMenuShow(){
	$(':input','#addMenuModal form')
	.not(':button,:submit,:reset')
	.val('')
	.removeAttr('checked')
	.removeAttr('selected');
	$('#addMenuModal .modal').modal('show');
}
function addMenuSave(){
	var pjUrl = getProjectUrl();
	var menu={};
	$.ajax({
		"url":pjUrl+"/menu/addMenu",
		"type":"POST",
		"dataType": "json",
		"data":$("#addMenuForm").serialize(),
		success:function(data){
			alert(data.msg);
            menu_table.ajax.reload();
		},
		error:function(){
			alert("系统异常，请联系系统管理员");
		}
	})
}
function getProjectUrl(){
	var curWwwPath = window.document.location.href;
	var pathName =  window.document.location.pathname;
	console.log(pathName);
	var pos = curWwwPath.indexOf(pathName);
	console.log(pos);
	var localhostPaht = curWwwPath.substring(0,pos);
	console.log(localhostPaht);
	var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	console.log(projectName);
	return localhostPaht+projectName;
}
$(function () {
	var pjUrl = getProjectUrl();
    menu_table = $("#menu_table").DataTable({
    	"searching":false,
    	"ordering":false,
    	"pagingType":"full_numbers",
    	"lengthChange":false,
    	"bServerSide": true, 
    	"columns": [
            { "data": "menuName" },
            { "data": "menuUrl"},
            { "data": "description" },
            { "data": "iconClass"},
            { "data": "parentId" },
            { "data": "sort"},
            { "data": "" }
		  ],
		"columnDefs":[
			{
			 "targets":6,
			 "render":function( data, type, full, meta){
			 	var btnHtml = '<button class="btn btn-success btn-sm" onclick="editMenu()"><i class="fa fa-fw fa-edit"></i>编辑</button>';
			 	btnHtml += '<button class="btn btn-danger btn-sm" onclick="delMenu(this)"><i class="fa fa-fw fa-remove"></i>删除</button>';
			 	return btnHtml;
			 }
			}
		],
    	"sAjaxSource":pjUrl+"/menu/menuPage",
    	"fnServerData":function(sSource, aoData, fnCallback){
    		$.ajax( {    
    	        "contentType": "application/json",    
    	        "url": sSource,     
    	        "dataType": "json",    
    	        "data": { aoData: JSON.stringify(aoData) }, // 以json格式传递  
    	        "success": function(resp) {   
    	            fnCallback(resp);   
    	        }    
    	    });    
    	}
    });
  });