<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${base}/static/common/css/bootstrap.min.css">


<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
<script src="${base}/static/admin/js/header/adminHeader.js"></script>
<link href="${base}/static/common/css/fileinput.css" media="all"
	rel="stylesheet" type="text/css" />
<script src="${base}/static/common/js/fileinput.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="${base}/static/common/css/dataTables.bootstrap.min.css">
<script
	src=" ${base}/static/common/js/jquery.dataTables.min.js"></script>
<script
	src="${base}/static/common/js/dataTables.bootstrap.min.js"></script>
<script src="${base}/static/common/js/zh.js"></script>


  <style>
td.details-control {
    background: url('${base}/static/admin/image/order/details_open.png') no-repeat center center;
    cursor: pointer;
}
tr.shown td.details-control {
    background: url('${base}/static/admin/image/order/details_close.png') no-repeat center center;
}    
</style>


</head>
<body data-spy="scroll" data-target=".nav-pills" data-offset="100">
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 加入头Header-->
				<jsp:include page="/WEB-INF/layout/admin/adminHeader.jsp"></jsp:include>
				<div class="row clearfix">
					<div class="col-md-2 column">
						<!-- 加入右侧-->
						<jsp:include page="/WEB-INF/layout/admin/adminPanel.jsp"></jsp:include>
					</div>
					<div class="col-md-10 column">
				<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th></th>
                <th>订单号</th>
                 <th>总价</th>
                <th>收件人</th>
                <th>地址</th>
                <th>联系方式</th>
                <th>快递方式</th>
                <th>订单状态</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th></th>
        		<th>订单号</th>
                 <th>总价</th>
                <th>收件人</th>
                <th>地址</th>
                <th>联系方式</th>
                <th>快递方式</th>
                <th>订单状态</th>
            </tr>
        </tfoot>
    </table>

						<script>
						
						
						/* Formatting function for row details - modify as you need */
function format ( d ) {
	$.ajax({
		url : 
				"${base}"+"/admin/order/ajax/packInfo",
		type : "post",
		dataType : "json",
		data : {
			orderId : d.orderId
		},
		success : function(data) {
			

		var obj=eval(data);
		for(var index in data){
			
			console.log(data[index]+"123");
		}
		
	
		},
		error : function() {

			console.log("error");
		}
	});
	var array=new Array('info','','info','','warning','','success');
	
	var $table=$("<table  class ='table table-bordered text-center' cellspacing='0' border='0' style='padding-left:50px;'><tr > "+'<td>商品ID:</td>'+
			'<td>商品名:</td>'+
			 '<td>购买数量:</td>'+
	+"</tr></table>");
	for(var index in d.productPacks){
					
	var $tr=$( '<tr class='+array[index%2]+'>'+
			 
			 '<td>'+d.productPacks[index].productInfo.prtId+'</td>'+
            
            '<td>'+d.productPacks[index].productInfo.prtName+'</td>'+
           
            '<td>'+d.productPacks[index].quantity+'</td>'+
        '</tr>');
	$table.append($tr);
	}
	
						
    // `d` is the original data object for the row
    return  $table;
}
						
var delivery=function(elem, orderId){
	
	$.ajax({
		url : 
				"${base}"+"/admin/order/ajax/delivery",
		type : "post",
		dataType : "html",
		data : {
			orderId : orderId
		},
		success : function(data) {
			console.log(data);	
			$td=$(elem).parent();
			$td.empty();
			$td.append(data)
		},
		error : function() {

			console.log("error");
		}
	});
	
}						
						
 
$(document).ready(function() {
	

    var table = $('#example').DataTable( {
        "ajax": "${base}"+"/admin/ajax/orders/loadOrders",
        "columns": [
            {
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''
            },
            { "data": "orderId" },
            { "data": "totalPrice" },
            { "data": "name" },
            { "data": "address" },
            { "data": "contact" },
            { "data": "delivery"},
            { "orderable":      false,
               "data":  "orderStatus",
               "render": function ( data, type, full, meta ) {
            	
            	   console.log(data);
            	   if(data=='完成付款'){
            	   return "<button onclick='delivery(this,"+full.orderId+")'>发货</button>";
            	   }
            		 return data;
               }
            }
        ],
        "order": [[1, 'asc']]
    } );
     
    // Add event listener for opening and closing details
    $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 	if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
} );
						
						
						</script>
						<!-- 加入具体内容-->

					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>