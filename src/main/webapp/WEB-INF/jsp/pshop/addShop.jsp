<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div id="addShopModal">
        <div class="modal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加合作商</h4>
              </div>
              <div class="modal-body">
	             <form id="addShopForm" class="form-horizontal">
	             	<div class="form-group">
	                  <label  class="col-sm-2 control-label">合作商名称</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" autocomplete="off" name="name" placeholder="合作商名称">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-sm-2 control-label">合作商描述</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" autocomplete="off" name="remark" placeholder="合作商描述">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-sm-2 control-label">合作商分类</label>
	
	                  <div class="col-sm-10">
	                    <select class="form-control" name="shopType.id">
							<option value="5" selected>供货商</option>
							<option value="6">出货商</option>
						</select>
	                  </div>
	                </div>
	            </form>
           	  </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addShopSave()">保存</button>
              </div>
            </div>
          </div>
        </div>
      </div>