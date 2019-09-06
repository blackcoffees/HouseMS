<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="utf-8" />
        <title>房地产后台管理系统</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="author" />
        <%@include file="/back/base/header.jsp"%>
        <link rel="shortcut icon" href="favicon.ico" />
	</head>

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
        	
            <%@include file="/back/base/head.jsp"%>
            
            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                
                <!-- BEGIN SIDEBAR -->
                <%@include file="/back/base/menu.jsp"%>
                <!-- END SIDEBAR -->
                
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <div class="page-content">

                        <!-- BEGIN PAGE BAR -->
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="javascript:void(0)">Module</a>
                                </li>
                            </ul>
                            <div class="page-toolbar">
                                <div id="dashboard-report-range" class="pull-right tooltips btn btn-sm" data-container="body" data-placement="bottom" data-original-title="Change dashboard date range">
                                    <i class="icon-calendar"></i>&nbsp;
                                    <span class="thin uppercase hidden-xs"></span>&nbsp;
                                    <i class="fa fa-angle-down"></i>
                                </div>
                            </div>
                        </div>
                        <!-- END PAGE BAR -->
                        
                        <!-- BEGIN PAGE TITLE-->
                        <h1 class="page-title"> Module
                            <small>系统模块</small>
                        </h1>
                        <!-- END PAGE TITLE-->
                        
                         <!-- BEGIN PAGE MAIN-->
                        <div class="row">
                        	<div class="col-md-12">
                        		<!-- BEGIN TABLE-->
                        		<div class="portlet box green">
                        			<div class="portlet-title">
                        				<div class="caption">
                        					<i class="fa fa-globe"></i>系统用户列表
                        				</div>
                        				<div class="tools">
                                            <span class="btn-refresh"><i class="fa fa-refresh"></i></span>
                                        </div>
                        			</div>
                        			<div class="portlet-body flip-scroll">
                        				<div class="row table-tool">
											<div class="col-md-12">
												<button type="button" class="btn btn-danger btn-add"><i class="fa fa-plus"></i>&nbsp;&nbsp;新增</button>
											</div>
										</div>
                        				<table class="table table-bordered table-striped table-condensed flip-content" id="table">
                        					<thead class="flip-content">
                        						<tr>
                        							<th>ID</th>
													<th>用户名称</th>
													<th>状态</th>
													<th>操作</th>
												</tr>
                        					</thead>
                        					<tbody>
                        						<tr v-for="(item, index) in data" :key="item.id">
                        							<td v-text="item.id"></td>
													<td v-text="item.username"></td>
													<td>
														<div @click="boot_switch(item.id, $event)" class="bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-small bootstrap-switch-animate bootstrap-switch-on"><div class="bootstrap-switch-container"><span class="bootstrap-switch-handle-on bootstrap-switch-primary">ON</span><label class="bootstrap-switch-label">&nbsp;</label><span class="bootstrap-switch-handle-off bootstrap-switch-default">OFF</span><input type="checkbox" checked="" class="make-switch" data-size="small"></div></div>
													</td>
													<td>
														<button class="btn btn-sm green btn-outline filter-submit margin-bottom" @click="resetPassword(item.id)"><i class="fa fa-edit"></i>&nbsp;&nbsp;重置密码</button>
														<button class="btn btn-sm purple btn-outline filter-submit margin-bottom" @click="deliverPower(item.id)"><i class="fa fa-users"></i>&nbsp;&nbsp;分配权限</button>
													</td>
												</tr>
                        					</tbody>
                        				</table>
                        				<div class="bottom-tool row">
											<wear-paginate></wear-paginate>
										</div>
                        			</div>
                        		</div>
                        		<!-- END TABLE-->
                        		
                        	</div>
                        </div>
                        <!-- END PAGE MAIN-->
                    </div>
                </div>
                <!-- END CONTENT -->
                
            </div>
            <!-- END CONTAINER -->
            
            <!-- BEGIN FOOTER -->
            <div class="page-footer"></div>
            <!-- END FOOTER -->
            
        </div>
        
        <!-- BEGIN Layer -->
		<div id="layer-window" style="display:none">
			<div class="col-mid-6">
				<form class="layer-form" data-parsley-validate onsubmit="return false">
					<table>
						<tr hidden="hidden">
							<td width="70"></td>
							<td><input value="0" id="user_id"/></td>
						</tr>
						<tr>
							<td width="70">用户名称</td>
							<td><input name="username" id="username" data-validat="true" /><span class="red"> *</span></td>
						</tr>
					</table>
					<div class="layer-button">
						<button type="submit" class="btn btn-danger btn-submit" id="btn_current"><i class="fa fa-check"></i>&nbsp;&nbsp;确定</button>
						<button type="button" class="btn grey-cascade btn-cancle"><i class="fa fa-times"></i>&nbsp;&nbsp;取消</button>
					</div>
				</form>
			</div>
		</div>
		
		<div id="layer-power" style="display:none">
			<div class="col-mid-6">
				<div class="portlet-body" style="height:270px;overflow-y:auto">
					<div id="powerTree" class="tree-demo"></div>
				</div>
				<div class="layer-button" style="width:324px;">
					<button type="submit" class="btn btn-danger btn-submit" id="btn_current_power"><i class="fa fa-check"></i>&nbsp;&nbsp;确定</button>
					<button type="button" class="btn grey-cascade btn-cancle" id="btn_cancel"><i class="fa fa-times"></i>&nbsp;&nbsp;取消</button>
				</div>
			</div>
		</div>
		<!-- END Layer -->
        
        <script src="<%=request.getContextPath() %>/static/js/common.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath() %>/static/js/paginate_tool.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath() %>/static/js/jstree.min.js" type="text/javascript"></script>
		<link href="<%=request.getContextPath() %>/static/css/style.min.css?v=10001" rel="stylesheet" type="text/css" />
        <script>
        var moduleIds = Array();
        var vue = new Vue({
			delimiters:['((', '))'],
			el:'#table',
			data:{
				data: []
			},
			methods:{
				boot_switch: function(id, event){
					var btn_switch = $(event.target).parent().parent();
		        	var status = 1;
		        	if(btn_switch.hasClass("bootstrap-switch-on")){
		        		btn_switch.removeClass("bootstrap-switch-on");
		        		btn_switch.addClass("bootstrap-switch-off");
		        		status = 0;
		        	}
		        	else{
		        		btn_switch.removeClass("bootstrap-switch-off");
		        		btn_switch.addClass("bootstrap-switch-on");
		        		status = 1;
		        	}
		        	$.ajax({
		        		type: "post",
		        		url: "/HouseMS/sysUser/updateUserStatus.action",
		        		data: {
		        			id: id,
		        			status: status
		        		},
		        		success: function(data){
		        			layer.closeAll("loading");
		        			if(data){
		        				data = eval("(" + data + ")");
		        				layer.closeAll();
		        				layer.msg(data.message);
		        			}
		        		},
		        		beforeSend:function(){
							layer.load(1, {
								shade: [0.1, '#fff']
							});
						},
						error: function(){
							layer.closeAll("loading");
						}
		        	})
				},
				resetPassword: function(id){
					$.ajax({
						type: "post",
	        			url: "/HouseMS/sysUser/resetPassword.action",
	        			data: {
	        				id: id
	        			},
	        			success:function(data){
	        				layer.closeAll('loading');
	            			if(data){
	            				data = eval("("+data+")");
	                			layer.msg(data.message);
	            			}
	            		},
	            		beforeSend:function(){
	    					layer.load(1, {
	    						shade: [0.1, '#fff']
	    					});
	    				},
	    				error: function(){
	    					layer.closeAll("loading");
	    				}
					})
				},
				deliverPower: function(user_id){
					$.ajax({
						type: "post",
						url: "/HouseMS/sysModule/getModuleTree.action",
						data: {"user_id": user_id},
						async: true,
						success: function(data){
							data = eval("(" + data + ")");
							var powerTree = $('#powerTree');
							if(powerTree.jstree(true)){
								powerTree.data("jstree", false).empty();
							}
							powerTree.jstree({
								'plugins': ["wholerow", "checkbox", "types"],
								'core': {
									"check_callback" : true,
									'data': data.data
								},
								"types" : {
									"default" : {
										"icon" : "fa fa-folder icon-state-warning icon-lg"
									}
								}
							})
							.bind("activate_node.jstree", function(obj, e){
								moduleIds.push(e.node.id);
							});
							$("#user_id").val(user_id);
							layer.open({
								type: '1',
								skin: 'layui-layer-molv',
								title: '权限分配',
								area: ['362px', '400px'],
								content: $('#layer-power')
							})
						}
					});
				}
			}
		})
        
        $(function(){
        	load_data();
        	
        	$(".btn-add").click(function(){
        		layer.open({
					type: '1',
					skin: 'layui-layer-molv',
					title: '新增用户',
					area: ['362px', '175px'],
					content: $('#layer-window')
				});
        	})
        	
        	$("#btn_current").click(function(){
        		var username = $("#username").val();
        		if(username == "" || username == null){
        			layer.alert("请输入用户名称");
        			return;
        		}
        		$.ajax({
        			type: "post",
        			url: "/HouseMS/sysUser/addUser.action",
        			data: {
        				username: username
        			},
        			success:function(data){
        				layer.closeAll('loading');
            			if(data){
            				data = eval("("+data+")");
                			layer.msg(data.message);
                			if(data.succ){
                				setTimeout(layer.closeAll(), 1500);
                				load_data();
                			}
            			}
            		},
            		beforeSend:function(){
    					layer.load(1, {
    						shade: [0.1, '#fff']
    					});
    				},
    				error: function(){
    					layer.closeAll("loading");
    				}
        		})
        	});
        	
        	$(".bootstrap-switch").click(function(){
        		if(this.hasClass("bootstrap-switch-off")){
        			this.removeClass("bootstrap-switch-off");
        			this.addClass("bootstrap-switch-on");
        		}
        		else{
        			this.removeClass("bootstrap-switch-on");
        			this.addClass("bootstrap-switch-off");
        		}
        	});
		})
        
        function load_data(rows, page){
        	if(typeof(rows) == "undefined")
        		rows = 10
        	if(typeof(page) == "undefined")
        		page = 1;
        	$.ajax({
        		type: "post",
        		url: "/HouseMS/sysUser/getAllUser.action",
        		data: {rows: rows, page: page},
        		success:function(data){
        			if(data){
        				data = eval("("+data+")");
    					pager = eval("("+data.pager+")");
    					//一共生成多少页
    					paginate_tool.init("load_data", pager, []);
    					vue.data = data.datas;
    					layer.closeAll('loading');
        			}
        		},
        		beforeSend:function(){
					layer.load(1, {
						shade: [0.1, '#fff']
					});
				},
				error: function(){
					layer.closeAll("loading");
				}
        	})
        }
        
        $("#btn_current_power").click(function(){
        	$.ajax({
        		type: "post",
        		url: "/HouseMS/sysUserPermission/updateUserPermission.action",
        		traditional: true,
        		data: {"moduleIds": moduleIds, "user_id": $("#user_id").val()},
        		success: function(data){
        			data = eval("(" + data + ")");
        			layer.closeAll();
        			layer.msg(data.message);
        		},
        		beforeSend:function(){
					layer.load(1, {
						shade: [0.1, '#fff']
					});
				},
				error: function(){
					layer.closeAll("loading");
				}
        	})
        })
        
        $("#btn_cancel").click(function(){
        	layer.closeAll("layer-power");
        })
        </script>
    </body>

</html>