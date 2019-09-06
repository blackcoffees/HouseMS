var menu_vue = new Vue({
	delimiters:['((', '))'],
	el:'.page-sidebar-menu',
	data:{
//		menu_list:[{
//			span_icon:'icon-home',
//			title:'HOME',
//			href:'index.jsp'
//		},{
//			span_icon:'icon-diamond',
//			title:'商品管理',
//			href:'milk.jsp'
//		},{
//			span_icon: 'icon-user',
//			title:'商家管理',
//			href:'distributor.jsp'
//		},{
//			span_icon: 'icon-basket',
//			title: '采购管理',
//			href: 'purchase.jsp'
//		},{
//			span_icon: 'icon-drawer',
//			title: '销售管理',
//			href: 'sale.jsp'
//		},{
//			span_icon: 'icon-social-dropbox',
//			title: '库存管理',
//			href: 'stock.jsp'
//		},{
//			span_icon: 'icon-layers',
//			title: '报表中心',
//			href: 'javascript:void(0)',
//			children: [{
//				span_icon: 'icon-pie-chart',
//				title: '  采购报表',
//				href: 'purchaseReport.jsp'
//			},{
//				span_icon: 'icon-briefcase',
//				title: '  销售报表',
//				href: 'saleReport.jsp'
//			},{
//				span_icon: 'icon-paper-plane',
//				title: '  分析报表',
//				href: 'goodsAnalysisReport.jsp'
//			}]
//		}],
		menu_list: []
	},
	mounted: function(){
		$.ajax({
			type: "post",
			url: "/HouseMS/sysModule/getUserModules.action",
			success: function(data){
				data = eval("(" + data + ")");
				menu_vue.menu_list = data.data;
				nowHref = window.location.href.split(":8080")[1];
				menu_vue.menu_list.forEach(function(menuItem){
					var children = menuItem.children;
					if(children.length>0){
						children.forEach(function(childItem){
							if(childItem.href = nowHref){
								menuItem.state.selected = true;
								menuItem.state.opented = true;
								return;
							}
						})
					}
					else if(menuItem.href == nowHref){
						menuItem.state.selected = true;
						menuItem.state.opented = true;
						return;
					}
				});
			}
		});
	}
});
1

//function get_page_total(total, rows){
//	var shang = Math.floor(total/rows);
//	var yushu = total%rows;
//	if(yushu > 0)
//		shang += 1;
//	return shang;
//}

$(function(){
	$('form').parsley();//调用parsley表单验证插件(提交时才会验证 是否必填和输入格式)
	//$('form').parsley().validate();//调用parsley表单验证插件(页面加载时就验证 是否必填和输入格式)
	

	$("#btn_login_out").click(function(){
		$.ajax({
			type: "post",
			url: "/HouseMS/sysUser/userLoginOut.action",
			success: function(data){
				data = eval("(" + data + ")");
				layer.msg(data.message);
				if(data.succ){
					setTimeout(location.href='/HouseMS/back/login.jsp', 1500);
				}
			}
		})
	})
});




$.ajaxSetup( {
	//设置ajax请求结束后的执行动作
    complete :
        function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus
            var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
            if (sessionstatus == "LOGIN") {
                var win = window;
                while (win != win.top){
                    win = win.top;
                }
                win.location.href= XMLHttpRequest.getResponseHeader("CONTENTPATH");
            }
        }
});
