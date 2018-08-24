<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="editRecordModal">
    <div class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改记录</h4>
                </div>
                <div class="modal-body">
                    <form id="updateRecordForm" class="form-horizontal">
                        <input name="id" type="hidden">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">产品</label>

                            <div class="col-sm-10">
                                <select class="form-control" name="product.id"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">产品数量</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" autocomplete="off" name="productCount"
                                       placeholder="产品数量">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">产品价格</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" autocomplete="off" name="productPrice"
                                       placeholder="产品价格">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">合作商</label>

                            <div class="col-sm-10">
                                <select class="form-control" name="productShop.id">

                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">进出货</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="productInoutType.id">
                                    <option value="7" selected>进货</option>
                                    <option value="8">出货</option>
                                </select>
                            </div>
                        </div>
                       <%-- <div class="form-group">
                            <label class="col-sm-2 control-label">操作时间</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" autocomplete="off" name="inoutDate"
                                       placeholder="操作时间">
                            </div>
                        </div>--%>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="editRecordSave()">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>