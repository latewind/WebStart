<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="">

<head runat="server">

<title>jquery 表格排序</title>

<style type="text/css">
thead {
	background-color: Blue;
	color: White;
}

tr.odd {
	background-color: #ddd;
}

tr.even {
	background-color: #eee;
}

.clickable {
	text-decoration: underline;
}

.hover {
	background-color: #5dd354;
}

.sorted {
	background-color: #ded070;
}

.page-number {
	color: Black;
	margin: 2px 10px;
	padding: 2px 5px;
}

.active {
	border: solid 1px red;
	background-color: #76a7d2;
}

.pager {
	margin-bottom: 10px;
	margin-left: 20px;
}
</style>

<script type="text/javascript" language="javascript" src="js/jQuery.js"></script>

<script type="text/javascript" language="javascript">

$(function() {

jQuery.fn.alternateRowColors = function() { //做成插件的形式

$('tbody tr:odd', this).removeClass('even').addClass('odd'); //隔行变色 奇数行

$('tbody tr:even', this).removeClass('odd').addClass('even'); //隔行变色 偶数行

return this;

};

$('table.myTable').each(function() {
	
var $table = $(this); //将table存储为一个jquery对象
var $tbody=$table.find('tbody');
var $th=$table.find('th');
$table.alternateRowColors($table); //在排序时隔行变色


$th.each(function(column) {//表头遍历
//alert(counttest+"test th");

	
var findSortKey;

	if ($(this).is('.sort-alpha')) { //按字母排序

	findSortKey = function($cell) {

			return $cell.find('sort-key').text().toUpperCase() + '' + $cell.text().toUpperCase();

									};

	} else if ($(this).is('.sort-numeric')) { //按数字排序

										findSortKey = function($cell) {

				var key = parseFloat($cell.text().replace(/^[^\d.]*/, ''));

					return isNaN(key) ? 0 : key;

									};

		} else if ($(this).is('.sort-date')) { //按日期排序

									findSortKey = function($cell) {

												return Date.parse('1 ' + $cell.text());

																	};

											}//end if

	if (findSortKey) {//如果为正数，表示可排序，高亮

$(this).addClass('clickable').hover(function() { $(this).addClass('hover'); }, function() { $(this).removeClass('hover'); }).click(function() {//点击事件

//反向排序状态声明

var newDirection = 1;

if ($(this).is('.sorted-asc')) {

newDirection = -1;

}
var d1=new Date();
var t1=d1.getTime();//时间起点
var rows = $tbody.find('tr').get(); //将数据行转换为数组
var d2=new Date();
var t2=d2.getTime();//获取表格时间点


$.each(rows, function(index, row) {
row.sortKey = findSortKey($(row).find('td').eq(column));
//row.sortKey=$(row).children('td').eq(column).text();
});
var d3=new Date();
var t3=d3.getTime();//排序起点
rows.sort(function(a, b) {//数组排序

if (a.sortKey < b.sortKey) return -newDirection;

if (a.sortKey > b.sortKey) return newDirection;

return 0;

});
var d4=new Date();
var t4=d4.getTime();//排序结束
$tbody.empty();//先清空,再后续增加


/*
$.each(rows, function(index, row) {
$table.children('tbody').append(row);
//$("table tbody tr:eq(index)").replaceWith(row);效率低
row.sortKey = null;

});
*/
//用 for()速度要比each快一些，差别不是很大，10ms左右
//var $newtbody=$table.find('tbody');
for(var j=0;j<rows.length;j++){
	$tbody.append(rows[j]);
	//alert($(rows[j]).text());
	
	//var str=$(rows[j]).text();
	//if(str.indexOf("1")>0){
		//alert("1 is in the row"+j+""); search
	//}
	
	rows[j].sortKey=null;
}

/**/
var d5=new Date();
var t5=d5.getTime();//输出结束结束

//alert("get Data="+(t2-t1)+"set sort key="+(t3-t2)+"sort ="+(t4-t3)+"input ="+(t5-t4)+"sum="+(t5-t1)+" ");//获取各部分运行时间 set sort key 150ms   input 200ms
  // alert("sum="+(t5-t1)+" ");
	$table.find('th').removeClass('sorted-asc').removeClass('sorted-desc');

var $sortHead = $table.find('th').filter(':nth-child(' + (column + 1) + ')');

//实现反向排序

if (newDirection == 1) {

$sortHead.addClass('sorted-asc');

} else {

$sortHead.addClass('sorted-desc');

}

//调用隔行变色的函数

$table.alternateRowColors($table);

//移除已排序的列的样式,添加样式到当前列

$table.find('td').removeClass('sorted').filter(':nth-child(' + (column + 1) + ')').addClass('sorted');

$table.trigger('repaginate');

});

}

});

});

});

//分页

$(function() {


$('table.paginated').each(function() {

var currentPage = 0;

var numPerPage = 10;

var $table = $(this);

$table.bind('repaginate', function() {

$table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();//全部隐藏hide，slice（选择）  0-10（init）展示

});

var numRows = $table.find('tbody tr').length;

var numPages = Math.ceil(numRows / numPerPage);

var $pager = $('<div class="pager"></div>');



for (var page = 0; page < numPages; page++) {

$('<span class="page-number"></span>').text(page + 1)

.bind('click', { newPage: page }, function(event) {

currentPage = event.data['newPage'];

$table.trigger('repaginate');

$(this).addClass('active').siblings().removeClass('active');

}).appendTo($pager).addClass('clickable');

}

$pager.insertBefore($table);

$table.trigger('repaginate');

$pager.find('span.page-number:first').addClass('active');

});

});
/**/
</script>

</head>

<body>

	<form id="form1" runat="server">

		<div>

			<table class="myTable paginated">

				<thead>

					<tr>

						<th class="sort-numeric">ID</th>

						<th class="sort-alpha">Name</th>

						<th class="sort-alpha">country</th>

						<th class="sort-alpha">direct</th>

						<th class="sort-numeric">population</th>



					</tr>

				</thead>

				<tbody>
					<s:iterator value="cities">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="countryCode" /></td>
							<td><s:property value="district" /></td>
							<td><s:property value="population" /></td>
						</tr>
					</s:iterator>

					<tr>
						<td>5000</td>
						<td>龙口</td>
						<td>中国</td>
						<td>亚洲</td>
						<td>75000</td>
					</tr>

					<tr>
						<td>5001</td>
						<td>烟台</td>
						<td>中国</td>
						<td>亚洲</td>
						<td>150000</td>
					</tr>
				</tbody>

			</table>

		</div>

	</form>

</body>

</html>