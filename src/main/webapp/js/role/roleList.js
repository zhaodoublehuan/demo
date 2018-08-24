function editRole(){
	 $('#editRoleModal .modal').modal('show');
}
/**
 * 点击添加用户，展示添加modal
 */
function addRoleShow(){
	$(':input','#addRoleModal form')
	.not(':button,:submit,:reset')
	.val('')
	.removeAttr('checked')
	.removeAttr('selected');
	$('#addRoleModal .modal').modal('show');
}
function addRoleSave(){
	var pjUrl = getProjectUrl();
	$.ajax({
		"url":pjUrl+"/role/addRole",
		"type":"POST",
		"dataType": "json",
		"data":$("#addRoleForm").serialize(),
		success:function(data){
			alert(data.msg);
            role_table.ajax.reload();
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
    role_table = $("#role_table").DataTable({
    	"searching":false,
    	"ordering":false,
    	"pagingType":"full_numbers",
    	"lengthChange":false,
    	"bServerSide": true, 
    	"columns": [
		    { "data": "name" },
		    { "data": "code"},
            { "data": "description" },
            { "data": "active"},
		    { "data": "" }
		  ],
		"columnDefs":[
            {
                "targets":3,
                "render":function (data, type, full, meta) {
                    return data=='Y' ? '启用' : '禁用';
                }
            },
			{
			 "targets":4,
			 "render":function( data, type, full, meta){
			 	var btnHtml = '<button class="btn btn-success btn-xs" onclick="editRole()"><i class="fa fa-fw fa-edit"></i></button>';
			 	btnHtml += '<button class="btn btn-danger btn-xs" onclick="delRole(this)"><i class="fa fa-fw fa-remove"></i></button>';
			 	return btnHtml;
			 }
			}
		],
    	"sAjaxSource":pjUrl+"/role/rolePage",
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