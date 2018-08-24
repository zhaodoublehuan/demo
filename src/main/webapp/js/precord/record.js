function editRecord(id){
    $("#updateRecordForm input[ name='inoutDate' ] ").datepicker({
        language:"zh-CN"
    });
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/product/getAllProduct",
        "type":"POST",
        "dataType": "json",
        success:function(data){
            var html ="";
            $.each(data,function (i,v) {
                html+="<option value='"+v.id+"'>"+v.name+"</option>"
            })
            $("#updateRecordForm select[name='product.id']").html(html);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
    $.ajax({
        "url":pjUrl+"/pshop/getAllShop",
        "type":"POST",
        "dataType": "json",
        success:function(data){
            var html ="";
            $.each(data,function (i,v) {
                html+="<option value='"+v.id+"'>"+v.name+"</option>"
            })
            $("#updateRecordForm select[name='productShop.id']").html(html);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
    $.ajax({
        "url":pjUrl+"/precord/getRecordById",
        "type":"POST",
        "dataType": "json",
        "data":{"id":parseInt(id)},
        success:function(record){
            $("#updateRecordForm input[name='id']").val(record.id);
            $("#updateRecordForm select[name='product.id']").val(record.product.id);
            $("#updateRecordForm input[name='productCount']").val(record.productCount);
            $("#updateRecordForm input[name='productPrice']").val(record.productPrice);
            $("#updateRecordForm select[name='productShop.id']").val(record.productShop.id);
            $("#updateRecordForm select[name='productInoutType.id']").val(record.productInoutType.id);
            $("#updateRecordForm input[name='inoutDate']").val(record.inoutDate);
            $('#editRecordModal .modal').modal('show');
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })

}

function editRecordSave() {
    $('#editRecordModal .modal').modal('hide');
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/precord/editRecord",
        "type":"POST",
        "dataType": "json",
        "data":$("#updateRecordForm").serialize(),
        success:function(data){

            if(data.status==0){
                alert(data.msg);
            }else{
                alert(data.msg);
            }
            record_table.ajax.reload();
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
}
/**
 * 点击添加用户，展示添加modal
 */
function addRecordShow(){
    $("input[ name='inoutDate' ] ").datepicker({
        language:"zh-CN"
    });
    $("input[ type='text' ] ").val("");
    $('#addRecordModal .modal').modal('show');
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/product/getAllProduct",
        "type":"POST",
        "dataType": "json",
        success:function(data){
            var html ="";
            $.each(data,function (i,v) {
                html+="<option value='"+v.id+"'>"+v.name+"</option>"
            })
            $("#addRecordForm select[name='product.id']").html(html);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
    $.ajax({
        "url":pjUrl+"/pshop/getAllShop",
        "type":"POST",
        "dataType": "json",
        success:function(data){
            var html ="";
            $.each(data,function (i,v) {
                html+="<option value='"+v.id+"'>"+v.name+"</option>"
            })
            $("#addRecordForm select[name='productShop.id']").html(html);
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
}
function addRecordSave(){
    $('#addRecordModal .modal').modal('hide');
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/precord/addRecord",
        "type":"POST",
        "dataType": "json",
        "data":$("#addRecordForm").serialize(),
        success:function(data){
            if(data.status==0){
                alert(data.msg);
            }else{
                alert(data.msg);
            }
            record_table.ajax.reload();
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
}

function delRecord(id) {
    $.confirm({
        title: '确认信息',
        content: '确定要删除该信息么?',
        confirmButton: '删除',
        confirmButtonClass:"btn-danger",
        cancelButtonClass: 'btn-info',
        cancelButton: '取消',
        confirm: function () {
            var pjUrl = getProjectUrl();
            $.ajax({
                "url":pjUrl+"/precord/deleteReccord",
                "type":"GET",
                "dataType": "json",
                "contentType": "application/json",
                "data":{"id":parseInt(id)},
                success:function(data){
                    if(data.status==0){
                        alert(data.msg);
                    }else{
                        alert(data.msg);
                    }
                    record_table.ajax.reload();
                },
                error:function(){
                    alert("系统异常，请联系系统管理员");
                }
            })
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
    record_table = $("#record_table").DataTable({
    	"searching":false,
    	"ordering":false,
    	"pagingType":"full_numbers",
    	"lengthChange":false,
    	"bServerSide": true,
    	"columns": [
		    { "data": "product.name" },
		    { "data": "productCount"},
            { "data": "productPrice"},
            { "data": "productShop.name"},
            { "data": "productInoutType.name"},
            { "data": "inoutDate"},
		    { "data": "" }
		  ],
		"columnDefs":[
			{
			 "targets":6,
			 "render":function( data, type, row, meta){
			 	var btnHtml = '<button class="btn btn-success btn-sm" onclick="editRecord('+row.id+')"><i class="fa fa-fw fa-edit"></i></button>';
			 	btnHtml += '<button class="btn btn-danger btn-sm" onclick="delRecord('+row.id+')"><i class="fa fa-fw fa-remove"></i></button>';
			 	return btnHtml;
			 }
			}
		],
    	"sAjaxSource":pjUrl+"/precord/recordPage",
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