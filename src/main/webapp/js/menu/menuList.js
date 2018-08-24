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

function lockMenu(id) {
    $.confirm({
        title: '确认信息',
        content: '确定要锁定该菜单?',
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
        content: '确定要解锁此菜单?',
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
            { "data": "active"},
            { "data": "" }
		  ],
		"columnDefs":[
			{
                "targets":6,
                "render":function( data, type, full, meta){
                	return data=="Y" ? "启用" : "禁用";
                }
			},
			{
			 "targets":7,
			 "render":function( data, type, full, meta){
			 	var btnHtml = '<button class="btn btn-success btn-sm" onclick="editMenu()"><i class="fa fa-fw fa-edit"></i></button>';
                 btnHtml += '<button class="btn btn-info btn-sm" onclick="lockMenu(this)"><i class="fa fa-fw fa-lock"></i></button>';
                 btnHtml += '<button class="btn btn-warning btn-sm" onclick="unLockMenu(this)"><i class="fa fa-fw fa-unlock"></i></button>';
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