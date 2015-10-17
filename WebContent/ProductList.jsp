
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>ShowProDuctDetails</title>
<%-- This jQuery code is for edit product list and delete from product list --%>
<jsp:include page="WEB-INF/css/BasicTemplate.css" />
<jsp:include page="WEB-INF/css/productlist.css" />
<%@include file="WEB-INF/pages/template/header.jsp"%>
<%@include file="WEB-INF/pages/template/body.jsp"%>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".Edit").click(function() {
			var productId = $(this).closest('tr').find("#productId").val();
			alert(productId);
			var productName = $(this).closest('tr').find("#productName").val();
			var quantity = $(this).closest('tr').find("#quantity").val();
			var price = $(this).closest('tr').find("#price").val();
			var vname = $(this).closest('tr').find("#vname").val();

			var param = {
				productId : productId,
				productName : productName,
				quantity : quantity,
				price : price,
				vname : vname
			};

			$.ajax({
				url : './editdetails',
				data : param,
				type : 'post',
				success : function(result) {
					$('#target').html(result);
					location.href = "Edit.jsp";
				}
			});
		});
		$(".delete").click(function() {

			var row = $(this).closest('tr');
			var productId = $(this).closest('tr').find("#productId").val();

			var param = {
				productId : productId
			};

			$.ajax({
				url : './deleteproduct',
				data : param,
				type : 'post',
				success : function(result) {
					row.remove();

				}
			});
		});

	});
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.pms.buisnesslogic.ShowProductLIstBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>




<body>
	<h4>Product List</h4>
	<div align="left" id="createproduct">
		<a href="CreateProductDetails.jsp">Create New Product</a>
	</div>
	<div id="search product" align="right">
		<form method="post" action="./searchproduct">
			<input type="text" with="10px" placeholder="name" name="productname" />
			<input type="submit" value="Search" class="searchproductbutton" />
		</form>
	</div>
	<form id="target">
		<table id="table">
			<tr id="firstrow">
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price/unit</th>
				<th>Vendor's Name</th>
				<th>actions</th>
			</tr>

			<c:forEach var="current" items="${sessionScope.productname}">
				<tr id="select_one">
					<input id="productId" type="hidden" name="productId"
						value="<c:out value="${current.productId}" />" />
					<td><input id="productName" class="box" type=""
						name="productName"
						value="<c:out value="${current.productName}" />" readonly></td>
					<td><input id="quantity" class="box" type="" name="quantity"
						value="<c:out value="${current.quantity}"/>" readonly></td>
					<td><input id="price" class="box" type="" name="price"
						value="<c:out value="${current.price}"/>" readonly></td>
					<td><input id="vname" class="box" type="" name="vname"
						value="<c:out value="${current.vname}"/>" readonly></td>
					<td><input class="Edit" type="button" name="action"
						value="Edit"> <input class="delete" type="button"
						name="action" value="Delete"></td>
				</tr>
			</c:forEach>

		</table>
	</form>






	<%@include file="WEB-INF/pages/template/footer.jsp"%>