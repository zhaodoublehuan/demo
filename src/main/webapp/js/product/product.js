function editProduct(id){
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/product/getProductById",
        "type":"POST",
        "dataType": "json",
        "data":{"id":parseInt(id)},
        success:function(product){
            $("#updateProductForm input[name='id']").val(product.id);
            $("#updateProductForm input[name='name']").val(product.name);
            $("#updateProductForm input[name='remark']").val(product.remark);
            $("#updateProductForm select[name='productType.id']").val(product.productType.id);
            $("#updateProductForm select[name='unitData.id']").val(product.unitData.id);
            $('#editProductModal .modal').modal('show');
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })

}

function editProductSave() {
    $('#editProductModal .modal').modal('hide');
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/product/editProduct",
        "type":"POST",
        "dataType": "json",
        "data":$("#updateProductForm").serialize(),
        success:function(data){

            if(data.status==0){
                alert(data.msg);
            }else{
                alert(data.msg);
            }
            product_table.ajax.reload();
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
}
/**
 * 点击添加用户，展示添加modal
 */
function addProductShow(){
    $("input[ type='text' ] ").val("");
    $('#addProductModal .modal').modal('show');
}
function addProductSave(){
    $('#addProductModal .modal').modal('hide');
    var pjUrl = getProjectUrl();
    $.ajax({
        "url":pjUrl+"/product/addProduct",
        "type":"POST",
        "dataType": "json",
        "data":$("#addProductForm").serialize(),
        success:function(data){
            alert(data.msg);
            product_table.ajax.reload();
        },
        error:function(){
            alert("系统异常，请联系系统管理员");
        }
    })
}

function delProduct(id) {
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
    product_table =  $("#product_table").DataTable({
    	"searching":false,
    	"ordering":false,
    	"pagingType":"full_numbers",
    	"lengthChange":false,
    	"bServerSide": true, 
    	"columns": [
		    { "data": "name" },
		    { "data": "remark"},
            { "data": "productType.name"},
            { "data": "unitData.name"},
		    { "data": "" }
		  ],
		"columnDefs":[
			{
			 "targets":4,
			 "render":function( data, type, row, meta){
			 	var btnHtml = '<button class="btn btn-success btn-sm" onclick="editProduct('+row.id+')"><i class="fa fa-fw fa-edit"></i></button>';
			 	btnHtml += '<button class="btn btn-danger btn-sm" onclick="delProduct('+row.id+')"><i class="fa fa-fw fa-remove"></i></button>';
			 	return btnHtml;
			 }
			}
		],
    	"sAjaxSource":pjUrl+"/product/productPage",
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