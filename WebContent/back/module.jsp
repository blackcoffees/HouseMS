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
                        					<i class="fa fa-globe"></i>系统模块列表
                        				</div>
                        				<div class="tools">
                                            <span class="btn-refresh"><i class="fa fa-refresh"></i></span>
                                        </div>
                        			</div>
                        			<div class="portlet-body flip-scroll">
                        				<div class="row table-tool">
											<div class="col-md-12">
												<input type="search" placeholder="模块名称" class="form-control input-small input-inline" style="width:165px!important" onchange="vue.milkName=this.value" onkeyup="if(event.keyCode==13){vue.milkName=this.value;init_table()}">
												<button type="button" class="btn btn-success btn-search"><i class="fa fa-search"></i>&nbsp;&nbsp;搜索</button>
												<button type="button" class="btn btn-danger btn-add"><i class="fa fa-plus"></i>&nbsp;&nbsp;新增</button>
											</div>
										</div>
                        				<table class="table table-bordered table-striped table-condensed flip-content" id="table">
                        					<thead class="flip-content">
                        						<tr>
                        							<th hidden="hidden">ID</th>
													<th>模块名称</th>
													<th>模块地址</th>
													<th>状态</th>
													<th>操作</th>
												</tr>
                        					</thead>
                        					<tbody>
                        						<tr v-for="(item, index) in data" :key="item.id">
                        							<td v-text="item.id" hidden="hidden"></td>
													<td v-text="item.name"></td>
													<td v-text="item.href"></td>
													<td>
														<div v-if="item.status == 1" @click="boot_switch(item.id, $event)" class="bootstrap-switch-on bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-small bootstrap-switch-animate"><div class="bootstrap-switch-container"><span class="bootstrap-switch-handle-on bootstrap-switch-primary">ON</span><label class="bootstrap-switch-label">&nbsp;</label><span class="bootstrap-switch-handle-off bootstrap-switch-default">OFF</span><input type="checkbox" checked="" class="make-switch" data-size="small"></div></div>
														<div v-else @click="boot_switch(item.id, $event)" class="bootstrap-switch-off bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-small bootstrap-switch-animate"><div class="bootstrap-switch-container"><span class="bootstrap-switch-handle-on bootstrap-switch-primary">ON</span><label class="bootstrap-switch-label">&nbsp;</label><span class="bootstrap-switch-handle-off bootstrap-switch-default">OFF</span><input type="checkbox" checked="" class="make-switch" data-size="small"></div></div>
													</td>
													<td>
														<button class="btn btn-sm green btn-outline filter-submit margin-bottom" @click="edit(item)"><i class="fa fa-edit"></i>&nbsp;&nbsp;编辑</button>
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
							<td><input value="0" id="id"/></td>
						</tr>
						<tr>
							<td width="70">模块名称</td>
							<td><input name="name" id="name" data-validat="true" /><span class="red"> *</span></td>
						</tr>
						<tr>
							<td width="70">模块地址</td>
							<td><input name="href" id="href" data-validat="true"/><span class="red"> *</span></td>
						</tr>
						<tr>
							<td width="70">父级模块</td>
							<td>
								<select class="form-control form-filter input-sm" id="add_all_module" style="width:157px;">
									<option value="0">一级目录</option>
								</select>
							</td>
						</tr>
					</table>
					<div class="layer-button">
						<button type="submit" class="btn btn-danger btn-submit" id="btn_current"><i class="fa fa-check"></i>&nbsp;&nbsp;确定</button>
						<button type="button" class="btn grey-cascade btn-cancle"><i class="fa fa-times"></i>&nbsp;&nbsp;取消</button>
					</div>
				</form>
			</div>
		</div>
		<!-- END Layer -->
        
        <script src="<%=request.getContextPath() %>/static/js/common.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath() %>/static/js/paginate_tool.js" type="text/javascript"></script>
        <script>
        var vue = new Vue({
			delimiters:['((', '))'],
			el:'#table',
			data:{
				data: []
			},
			methods:{
				add: function(milk){
					layer.open({
						type: '1',
						skin: 'layui-layer-molv',
						title: '编辑商品',
						area: ['362px', '368px'],
						content: $('#layer-window')
					})
				},
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
		        		url: "/HouseMS/sysModule/updateModuleStatus.action",
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
				edit: function(module){
					$("#name").val(module.name);
					$("#href").val(module.href);
					$("#id").val(module.id);
					$("#add_all_module option[value='" + module.parent_id + "']").attr("selected", true);
					layer.open({
						type: '1',
						skin: 'layui-layer-molv',
						title: '编辑模块',
						area: ['362px', '275px'],
						content: $('#layer-window')
					})
				}
			}
		})
        
        $(function(){
        	load_data();
        	getRootChildModule();
        	
        	$(".btn-add").click(function(){
        		layer.open({
					type: '1',
					skin: 'layui-layer-molv',
					title: '新增模块',
					area: ['362px', '275px'],
					content: $('#layer-window')
				})
        	})
        	
        	$("#btn_current").click(function(){
        		var name = $("#name").val();
        		var href = $("#href").val();
        		var id = $("#id").val();
        		var parent_id = $("#add_all_module option:selected").val();
        		if(name == "" || name == null){
        			layer.alert("请输入模块名称");
        			return;
        		}
        		if(href == "" || href == null){
        			layer.alet("请输入模块地址");
        			return;
        		}
        		if(parent_id == "" || parent_id == null){
        			layer.alet("请选择模块的父级模块");
        			return;
        		}
        		$.ajax({
        			type: "post",
        			url: "/HouseMS/sysModule/addModule.action",
        			data: {
        				name: name,
        				href: href,
        				parent_id: parent_id,
        				id: id
        			},
        			success:function(data){
        				layer.closeAll('loading');
            			if(data){
            				data = eval("("+data+")");
                			layer.msg(data.message);
                			if(data.succ){
                				$("#name").val("");
                        		$("#href").val("");
                        		$("#id").val(0);
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
        		url: "/HouseMS/sysModule/getAllModule.action",
        		data: {rows: rows, page: page},
        		success:function(data){
        			if(data){
        				data = eval("("+data+")");
    					pager = eval("("+data.pager+")");
    					//一共生成多少页
    					paginate_tool.init("load_data", pager, []);
    					vue.data = data.datas;
    					layer.closeAll('loading');
    					getRootChildModule();	
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
        
        function getRootChildModule(){
        	$.ajax({
        		type: 'post',
        		url: '/HouseMS/sysModule/getRootChildModule.action',
        		data: {},
        		success: function(data){
        			if(data){
        				data = eval("(" + data + ")");
        				$("#add_all_module").empty();
        				$("#add_all_module").append("<option value='0'>一级目录</option>")
    					for(var i=0;i<data.datas.length;i++){
							$("#add_all_module").append("<option value='" + data.datas[i].id + "'>" + data.datas[i].name + "</option>")    						
    					}
        			}
        		}
        	})
        }
        </script>
    </body>

</html>