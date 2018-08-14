function editUser(){
	 $('#editUserModal .modal').modal('show');
}
/**
 * 点击添加用户，展示添加modal
 */
function addUserShow(){
	$(':input','#addUserModal form')
	.not(':button,:submit,:reset')
	.val('')
	.removeAttr('checked')
	.removeAttr('selected');
	$('#addUserModal .modal').modal('show');
}
function addUserSave(){
	var pjUrl = getProjectUrl();
	var user={};
	$.ajax({
		"url":pjUrl+"/user/addUser",
		"type":"POST",
		"dataType": "json",
		"data":$("#addUserForm").serialize(),
		success:function(data){
			alert(data.msg);
            user_table.ajax.reload();
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
    user_table = $("#user_table").DataTable({
    	"searching":false,
    	"ordering":false,
    	"pagingType":"full_numbers",
    	"lengthChange":false,
    	"bServerSide": true, 
    	"columns": [
		    { "data": "loginNo" },
		    { "data": "userName"},
            { "data": "userAge" },
            { "data": "userSex"},
            { "data": "mobile" },
            { "data": "email"},
		    { "data": "" }
		  ],
		"columnDefs":[
			{
			 "targets":6,
			 "render":function( data, type, full, meta){
			 	var btnHtml = '<button class="btn btn-success btn-sm" onclick="editUser()"><i class="fa fa-fw fa-edit"></i>编辑</button>';
			 	btnHtml += '<button class="btn btn-danger btn-sm" onclick="delUser(this)"><i class="fa fa-fw fa-remove"></i>删除</button>';
			 	return btnHtml;
			 }
			}
		],
    	"sAjaxSource":pjUrl+"/user/userPage",
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