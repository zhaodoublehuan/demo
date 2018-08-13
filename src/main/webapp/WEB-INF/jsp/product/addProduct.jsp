<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div id="addProductModal">
        <div class="modal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加产品</h4>
              </div>
              <div class="modal-body">
	             <form id="addProductForm" class="form-horizontal">
	             	<div class="form-group">
	                  <label  class="col-sm-2 control-label">产品名称</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" autocomplete="off" name="name" placeholder="产品名称">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-sm-2 control-label">产品描述</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" autocomplete="off" name="remark" placeholder="产品描述">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-sm-2 control-label">产品类型</label>
	
	                  <div class="col-sm-10">
	                    <select class="form-control" name="productType.id">
							<option value="1" selected>办公用品</option>
							<option value="2">交通用品</option>
						</select>
	                  </div>
	                </div>
					 <div class="form-group">
						 <label class="col-sm-2 control-label">单位</label>
						 <div class="col-sm-10">
							 <select class="form-control" name="unitData.id">
								 <option value="3" selected>吨</option>
								 <option value="4">件</option>
							 </select>
						 </div>
					 </div>
	            </form>
           	  </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addProductSave()">保存</button>
              </div>
            </div>
          </div>
        </div>
      </div>