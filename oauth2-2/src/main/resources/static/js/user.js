$(function() {
	// 消息框配置
	toastr.options = {
		closeButton: false,
		debug: false,
		progressBar: false,
		positionClass: "toast-top-center",
		onclick: null,
		showDuration: "300",
		hideDuration: "500",
		timeOut: "2000",
		extendedTimeOut: "1000",
		showEasing: "swing",
		hideEasing: "linear",
		showMethod: "fadeIn",
		hideMethod: "fadeOut"
	};
	// CSRF
	var csrfToken = $("meta[name='_csrf']").attr("content");
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	$.ajaxSetup({
		beforeSend: function(request) {
            request.setRequestHeader(csrfHeader, csrfToken); // 添加 CSRF Token
        },
        complete: function (XMLHttpRequest, textStatus) {
        	var json = JSON.parse(XMLHttpRequest.responseText);
        	if(json.status == "900") {
        		window.location.href = "/login";
        	}
            if(json.error && json.message && json.path){
            	toastr.error(json.message + ": " + json.path);
            } else if(json.code && json.message) {
            	toastr.error("Error: " + json.message);
            }
        }
	});
	// 初始化数据表格
	$('#userList').bootstrapTable({
		url: '/user/page',
		method: 'post',
		toolbar: '#toolbar',
		striped: true,
		cache: false,
		pagination: true,
		sortable: true,
		sortOrder: "asc",
		queryParams: queryParams,
		sidePagination: "server",
		pageNumber: 1,
		pageSize: 10,
		pageList: [5, 10, 25],
		search: true,
		contentType: "application/x-www-form-urlencoded",
		// strictSearch: true,
		showColumns: true,
		showRefresh: true,
		minimumCountColumns: 2,
		clickToSelect: true,
		// height: 700,
		uniqueId: "no",
		// showToggle: true,
		cardView: false,
		detailView: false,
		columns: [
	      	{	checkbox: true
	      	}, {	
	      		field: 'id',
	      		title: 'ID'
	      	}, {
	      		field: 'username',
	      		title: '用户名',
	      		sortable: true
	      	}, {
	      		field: 'phone',
	      		title: '手机号'
	      	}, {
	      		field: 'email',
	      		title: '邮箱'
	      	}, {
	      		field: 'createTime',
	      		title: '创建时间'
	      	},
	      	{	field: 'operate',
	      		title: '操作',
	      		formatter: operateFormatter
	      	},
	      ]
	});
	// 工具栏点击按钮事件
	// 删除选择数据
	$("#delUsersButton").click(function() {
		console.log(JSON.stringify($('#userList').bootstrapTable('getSelections')));
		var selects = $('#userList').bootstrapTable('getSelections')
		var ids = $.map(selects, function (row) {
			return row.id;
		});
		console.log(ids);
		$('#userList').bootstrapTable('remove', {
			field: 'id',
			values: ids
		});
	});
});
/**
 * 生成操作按钮单元格
 * @param value
 * @param row
 * @param index
 * @returns
 */
function operateFormatter(value, row, index) {
	return [
		'<a class="btn btn-info btn-sm" role="button" href="/user/e/'+ row['id'] + '"> 修 改 </a>',
		'&nbsp;&nbsp;',
		'<a class="btn btn-info btn-sm" role="button" href="javascript:;" id="del_' + row['id'] + '" onclick="delUser(this);"> 删 除 </a>'
	].join('');
}
/**
 * 分页参数
 */
function queryParams(params) {
	console.log(params);
	var p = params.offset/params.limit + 1;
	var temp = {
		size: params.limit,
		page: p
	};
	return temp;
}
/**
 * 删除用户
 */
function delUser(node) {
	var id = node.id.split("_")[1];
	// var form = document.getElementById("user_del_form");
	// form.action = "/user/" + id;
	// form.submit();
	$.ajax({
		type: "post",
		url: "/user/d/" + id,
		dataType: "json",
		success: function(data) {
			$('#userList').bootstrapTable('refresh', { });
		}
	});
}