<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>City</title>
<style type="text/css">
div {
	width: 1024px;
	margin: 0 auto; /*div相对屏幕左右居中*/
}

table {
	border: solid 1px #666;
	border-collapse: collapse;
	width: 100%;
	cursor: default; /*该属性定义了鼠标指针放在一个元素边界范围内时所用的光标形状,default默认光标（通常是一个箭头）*/
}

tr {
	border: solid 1px #666;
	height: 30px;
}

table thead tr {
	background-color: #ccc;
}

td {
	border: solid 1px #666;
}

th {
	border: solid 1px #666;
	text-align: center;
	cursor: pointer; /*光标呈现为指示链接的指针（一只手）*/
}

.sequence {
	text-align: center;
}

.hover {
	background-color: #3399FF;
}
</style>


<script src="http://code.jquery.com/jquery-1.12.0.min.js"
	type="text/javascript">

</script>



<pre class="javascript" name="code">
	<script type="text/javascript">  
        $(function () {  
            var tableObject = $('#tableSort'); //获取id为tableSort的table对象  
            var tbHead = tableObject.children('thead'); //获取table对象下的thead  
            var tbHeadTh = tbHead.find('tr th'); //获取thead下的tr下的th  
            var tbBody = tableObject.children('tbody'); //获取table对象下的tbody  
            var tbBodyTr = tbBody.find('tr'); //获取tbody下的tr  
  
            var sortIndex = -1;  
  
            tbHeadTh.each(function () {//遍历thead的tr下的th  
                var thisIndex = tbHeadTh.index($(this)); //获取th所在的列号  
                //给表态th增加鼠标位于上方时发生的事件  
                $(this).mouseover(function () {  
                    tbBodyTr.each(function () {//编列tbody下的tr  
                        var tds = $(this).find("td"); //获取列号为参数index的td对象集合  
                        $(tds[thisIndex]).addClass("hover"); //给列号为参数index的td对象添加样式  
                    });  
                }).mouseout(function () {//给表头th增加鼠标离开时的事件  
                    tbBodyTr.each(function () {  
                        var tds = $(this).find("td");  
                        $(tds[thisIndex]).removeClass("hover"); //鼠标离开时移除td对象上的样式  
                    });  
                });  
  
                $(this).click(function () {//给当前表头th增加点击事件  
                    var dataType = $(this).attr("type"); //点击时获取当前th的type属性值  
                    var trsValue = new Array();            //先声明一维  
                    for (var i = 0; i < tbBodyTr.length; i++) {  
                        trsValue[i] = new Array();         //在声明二维   
                        var tds = $(tbBodyTr[i]).find('td');  
                        trsValue[i][1] = $(tds[$(this).index()]).html();  
                        trsValue[i][2] = $(tbBodyTr[i]).html();  
                        $(tbBodyTr[i]).html("");  
                    }  
                    var len = trsValue.length;  
  
                    if ($(this).index() == sortIndex) {  
                        //如果已经排序了则直接倒序  
                        trsValue.reverse();  
                    } else {  
                        trsValue.sort(createCompact(dataType));  
                    }  
                    for (var i = 0; i < len; i++) {  
                        $("tbody tr:eq(" + i + ")").html(trsValue[i][2]);  
                    }  
  
                    sortIndex = $(this).index();  
                });  
            });  
  
            $("tbody tr").removeClass(); //先移除tbody下tr的所有css类  
            //table中tbody中tr鼠标位于上面时添加颜色,离开时移除颜色  
            $("tbody tr").mouseover(function () {  
                $(this).addClass("hover");  
            }).mouseout(function () {  
                $(this).removeClass("hover");  
            });  
  
        });  
  
        function createCompact(styType) {  
            return function (object1, object2) {  
                var value1 = object1[1];  
                var value2 = object2[1];  
                if (styType == "number") {  
                //处理数字排序  
                    return value2 - value1;  
                } else {  
                    if (value1 < value2) {  
                        return -1;  
                    } else if (value1 > value2) {  
                        return 1;  
                    } else {  
                        return 0;  
                    }   
                }  
  
            }  
        }  
    </script>
</pre>
</head>
<body>
	City 列表iterator
	<br>
	<table id="tableSort" width="100%" cellspacing="0">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>countryCode</th>
				<th>district</th>
				<th>population</th>

			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>countryCode</th>
				<th>district</th>
				<th>population</th>
			</tr>
		</tfoot>
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
		</tbody>
	</table>
</body>
</html>