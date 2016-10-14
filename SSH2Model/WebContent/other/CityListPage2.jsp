<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>City</title>
<link href="css/jquery.dataTables.min.css" rel="stylesheet"
	type="text/css" />


<script src="http://code.jquery.com/jquery-1.12.0.min.js"
	type="text/javascript">

</script>



<script type="text/javascript" language="javascript"
	src="js/jquery.dataTables.min.js">

</script>

<script>
//
$(document).ready(function() {
    $('#example').DataTable( {
    	"paging":   true
    } );
} );
</script>
</head>
<body>
	City 列表iterator
	<br>
	<table id="example" class="display" width="100%" cellspacing="0">
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