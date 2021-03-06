<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>终端类别-指静脉管理平台</title>
    </head>
    
    <body>
	    <div class="easyui-panel" data-options="border:false,fit:true">
		    <!-- datagrid -->
		    <table id="datagrid" style="width:100%;" data-options="border:false,fit:true"></table>
		    <div id="tools">
		    	<!-- search -->
		    	<form class="data-form" id="searchForm" method="post">
			    <table>
			        <tr>
			        	<td class="td-right">类别名称：</td>
			            <td><input type="text" id="nameQuery" style="width:150px;"></td>
			            <td class="td-right">创建时间：</td>
			            <td>
			            <input class="easyui-datebox" type="text" id="createDateBeginQuery" style="width:100px;">~
			            <input class="easyui-datebox" type="text" id="createDateEndQuery" style="width:100px;"></td>
			        </tr>
			        <tr>
			            <td></td>
			            <td colspan="5">
			            <a class="easyui-linkbutton" id="searchBtn" href="javascript:void(0);" data-options="iconCls:'icon-search'">查询</a>&nbsp;
			            <a class="easyui-linkbutton" id="resetBtn" href="javascript:void(0);" data-options="iconCls:'icon-back'">重置</a>
			            </td>
			        </tr>
			    </table>
			    </form>
			    <!-- search -->
		    	<div style="border-top:1px solid #DDDDDD;">
		        	<a class="easyui-linkbutton" href="javascript:void(0);" data-options="iconCls:'icon-add',plain:true" id="addBtn">新增</a>
		        	<a class="easyui-linkbutton" href="javascript:void(0);" data-options="iconCls:'icon-remove',plain:true" id="deleteBtn">删除</a>
		        	<a class="easyui-linkbutton" href="javascript:void(0);" data-options="iconCls:'icon-control_add_blue',plain:true" id="addBatchBtn">批量</a>
		        </div>
		    </div>
		    
		    <!-- datagrid -->
		    <!-- 新增 -->
		    <div class="easyui-window" id="editWin" data-options="modal:true,closed:true,resizable:false,
		                minimizable:false,
		                maximizable:false,
		                draggable:true,
		                collapsible:false"
		                style="width:330px;height:160px;padding:10px;">
		        <form id="editForm" method="post">
		        <input type="hidden" name='id' id="dataId">
		        <table class="table">
		            <tr>
					    <td align="right">类别名称：</td>
					    <td>
					    <input class="easyui-validatebox" type="text" name="name" id="nameEdit" style="width:150px;" data-options="required:true"></td>
					</tr>
					<tr>
					    <td align="right">类别编码：</td>
					    <td>
					    <input class="easyui-validatebox" type="text" name="code" id="codeEdit" style="width:150px;" data-options="required:true"></td>
					</tr>
		            <tr>
		                <td></td>
		                <td><a class="easyui-linkbutton" id="saveBtn" href="#" data-options="iconCls:'icon-save'">保存</a></td>
		            </tr>
		        </table>
		        </form>
		    </div>
		    <!-- 新增 -->
		    <!-- 批量 -->
		    <div class="easyui-window" id="addBatchWin" data-options="modal:true,closed:true,resizable:false,
		                minimizable:false,
		                maximizable:false,
		                draggable:true,
		                collapsible:false"
		                style="width:350px;height:400px;">
		        <div id="tb" style="height:auto">
		            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加行</a>
		            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除行</a>
		            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="saveBatch()">保存</a>
		        </div>
		        <table id="addBatchDatagrid" style="width:100%;">
		            <thead>
		                <tr>
		                    <th data-options="field:'name',editor:{type:'text'}">类别名称</th>
		                    <th data-options="field:'code',editor:{type:'text'}">类别编码</th>
		                </tr>
		            </thead>
		        </table>
		        <form id="addBatchForm" method="post"></form>
		    </div>
		    <!-- 批量 -->
	    </div>
	    <jscript>
	    <!-- js -->
	    <script type="text/javascript" src="${ctx}/js/format.js"></script>
	    <script type="text/javascript" src="${ctx}/js/common.js"></script>
	    <script type="text/javascript">
	    $(function() {
	        $('#datagrid').datagrid({
	            url: '${ctx}/manager/style/query',
	            toolbar: '#tools',
	            idField: 'id',
	            autoRowHeight: true,
	            fitColumns: true,
	            showFooter: true,
	            pagination: true,
	            pageNumber: 1,
	            pageSize: 20,
	            singleSelect: false,
	            rownumbers: true,
	            selectOnCheck: true,
	            checkOnSelect: true,
	            columns: [[
	                {field: 'id', title: '选择', width: 30, checkbox: true},
	                {field: 'name', title: '类别名称'},
	                {field: 'code', title: '类别编码'},
	                {field: 'createTime', title: '创建时间', formatter:function(val, row, idx) {
	                    return to_date_hms(val);
	                }},
	                {field: 'opts', title: '操作', formatter:function(val, row, idx) {
	                    return '<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="updateById(\'' + row.id + '\')">修改</a>';
	                }}
	            ]]
	        });
	        
	        $('#searchBtn').click(function() {
	            $('#datagrid').datagrid('load', {
	                name: $('#nameQuery').val(),
	                createDateBegin: $('#createDateBeginQuery').datebox('getValue'),
	                createDateEnd: $('#createDateEndQuery').datebox('getValue')
	            });
	        });
	        
	        submitForm('${ctx}/manager/style/saveOrUpdate');
	        deleteRow('${ctx}/manager/style/deleteBatch');
	    });
	    function updateById(id) {
	        $.messager.progress();
	        var url = "${ctx}/manager/style/getById"
	        var params = {id: id};
	        $.post(url, params, function(result) {
	            $.messager.progress('close');
	            if (result.status) {
	                $('#dataId').val(result.data.id);
	                $('#nameEdit').val(result.data.name);
	                $('#codeEdit').val(result.data.code);
	                $("#editWin").window({title:"修改"}).window("open").window("center");
	            } else {
	                $.messager.alert('消息', result.message, 'error');
	            }
	        }, 'json');
	    }
	    function saveBatch() {
	        if (endEditing()){
	            var rows = $('#addBatchDatagrid').datagrid('getChanges');
	            if (rows.length) {
	                var inserted = $('#addBatchDatagrid').datagrid('getChanges', "inserted");
	                if (inserted.length) {
	                    var form = $('#addBatchForm');
	                    form.children().remove();
	                    for (var i=0; i<inserted.length; i++) {
	                        form.append('<input type="hidden" name="name" value="' + inserted[i].name + '">');
	                        form.append('<input type="hidden" name="code" value="' + inserted[i].code + '">');
	                    }
	                    var url = "${ctx}/manager/style/saveBatch"
	                    $.post(url, form.serialize(), function(result) {
	                        if (result.status) {
	                            $('#addBatchWin').window('close');
	                            $('#datagrid').datagrid('reload');
	                        } else {
	                            $.messager.alert({
	                                title: '消息',
	                                ok: '确定',
	                                msg: result.message
	                            });
	                        }
	                    }, 'json');
	                }
	            }
	        }
	    }
	    </script>
	    <!-- js -->
	    </jscript>
    </body>
</html>