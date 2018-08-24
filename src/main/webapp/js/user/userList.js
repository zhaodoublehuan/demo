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

function lockMenu(id) {
    $.confirm({
        title: '确认信息',
        content: '确定要锁定该用户?',
        confirmButton: '锁定',
        confirmButtonClass:"btn-danger",
        cancelButtonClass: 'btn-info',
        cancelButton: '取消',
        confirm: function () {
            var pjUrl = getProjectUrl();
            $.ajax({
                "url":pjUrl+"/product/deleteProduct",
                "type":"GET",
                "dataType": "json",
                "contentType": "application/json",
                "data":{"id":parseInt(id)},
                success:function(data){
                    alert(data.msg);
                    product_table.ajax.reload();
                },
                error:function(){
                    alert("系统异常，请联系系统管理员");
                }
            })
        }
    })
}

function unLockMenu(id) {
    $.confirm({
        title: '确认信息',
        content: '确定要解锁此用户?',
        confirmButton: '解锁',
        confirmButtonClass:"btn-danger",
        cancelButtonClass: 'btn-info',
        cancelButton: '取消',
        confirm: function () {
            var pjUrl = getProjectUrl();
            $.ajax({
                "url":pjUrl+"/product/deleteProduct",
                "type":"GET",
                "dataType": "json",
                "contentType": "application/json",
                "data":{"id":parseInt(id)},
                success:function(data){
                    alert(data.msg);
                    product_table.ajax.reload();
                },
                error:function(){
                    alert("系统异常，请联系系统管理员");
                }
            })
        }
    })
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
				"targets":3,
				"render":function (data, type, full, meta) {
					return data==0 ? '男' : '女';
				}
			},
			{
			 "targets":6,
			 "render":function( data, type, full, meta){
			 	var btnHtml = '<button class="btn btn-success btn-xs" onclick="editUser()"><i class="fa fa-fw fa-edit"></i></button>';
                 btnHtml += '<button class="btn bg-orange btn-xs" onclick="editUser()"><i class="fa fa-fw  fa-shield"></i></button>';
                 btnHtml += '<button class="btn btn-info btn-xs" onclick="lockUser(this)"><i class="fa fa-fw fa-lock"></i></button>';
                 btnHtml += '<button class="btn btn-warning btn-xs" onclick="unLockUser(this)"><i class="fa fa-fw fa-unlock"></i></button>';
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