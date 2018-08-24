<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div id="addMenuModal">
        <div class="modal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增菜单</h4>
              </div>
              <div class="modal-body">
	             <form class="form-horizontal" id="addMenuForm">
	             	<div class="form-group">
	                  <label class="col-sm-2 control-label">菜单名称</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" name="loginNo" autocomplete="off" >
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-sm-2 control-label">菜单地址</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" name="userName" autocomplete="off">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-sm-2 control-label">菜单描述</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" name="password" autocomplete="off" >
	                  </div>
	                </div>
					 <div class="form-group">
						 <label class="col-sm-2 control-label">菜单样式</label>

						 <div class="col-sm-10">
							 <input type="text" class="form-control" name="mobile" autocomplete="off">
						 </div>
					 </div>
					 <div class="form-group">
						 <label class="col-sm-2 control-label">父级菜单</label>

						 <div class="col-sm-10">
							 <input type="text" class="form-control" name="mobile" autocomplete="off">
						 </div>
					 </div>
					 <div class="form-group">
						 <label class="col-sm-2 control-label">菜单顺序</label>

						 <div class="col-sm-10">
							 <input type="text" class="form-control" name="mobile" autocomplete="off">
						 </div>
					 </div>
					 <div class="form-group">
						 <label class="col-sm-2 control-label">是否启用</label>

						 <div class="col-sm-10">
							 <select>
								 <option value="Y">启用</option>
								 <option value="N">禁用</option>
							 </select>
						 </div>
					 </div>
	            </form>
           	  </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addMenuSave()">保存</button>
              </div>
            </div>
          </div>
        </div>
      </div>