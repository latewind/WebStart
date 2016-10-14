<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="js/jQuery.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery.lwTables.js" type="text/javascript"
	language="javascript"></script>
<script type="text/javascript" language="javascript">

 
$(document).ready(function(){
$("#tb").lwtables({
	open:2,
	thType: "int,char,char,char,int"
});
	
});

</script>
<link href="css/CityList.css" rel="stylesheet" type="text/css">
</head>

<body>
	<table id="tb">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Country</th>
				<th>Direct</th>
				<th>Population</th>
			</tr>
		</thead>
		<tfoot></tfoot>

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



</body>
</html>