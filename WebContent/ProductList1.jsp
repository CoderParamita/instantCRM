<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>ShowProDuctDetails</title>
	<jsp:include page="WEB-INF/css/BasicTemplate.css"/>
	<jsp:include page="WEB-INF/css/productlist.css"/>	
	<%@include file="WEB-INF/pages/template/header.jsp" %>
	<%@include file="WEB-INF/pages/template/body.jsp" %>
	<script  type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script  type="text/javascript">
	$(document).ready(function() {
		$(".Edit").click(function() {
				var productName;
				var quantity;
				 var price;
				 var vname;
			 $(this).closest('tr').find("#productName").each(function() {
			      productName= this.value;
			    });
			 $(this).closest('tr').find("#quantity").each(function() {
			      quantity= this.value;
			      alert(this.value);
			    });
			 $(this).closest('tr').find("#price").each(function() {
			       price= this.value;
			      alert(this.value);
			    });
			 
			 $(this).closest('tr').find("#vname").each(function() {
			       vname= this.value;
			      alert(this.value);
			    });
			 
			 
			 $('#productlist').attr('action', './editdetails?productName='+productName+'&quantity'+quantity+'&price'+price+'&vname'+vname );
             $('#productlist').attr('method', 'post');
             $('#productlist').submit();
		});
	});
	
	</script>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ page import="com.pms.buisnesslogic.ShowProductLIstBean" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.List" %>
	
	
	

<body>
	<h4>Product List</h4>	
		<div align="left" id="createproduct"> <a href="C reateProductDetails.jsp" >Create New Product</a> </div>
		<div id="search product" align="right">
		<form method="post" action="./searchproduct">
			<input type="text" with="10px" placeholder="name" name="productname"/>
			<input type="submit" value="Search" class="searchproductbutton"/>
		</form>
		</div>
		<form id="productlist" >
	        <table id="table">
				<tr id="firstrow"><th>Product Name</th><th>Quantity</th><th>Price/unit</th><th>Vendor's Name</th><th>actions</th></tr>
				
					<c:forEach var="current" items="${sessionScope.productname}" >
					<tr id="select_one">
					 	<input type="hidden" name="productId" value="<c:out value="${current.productId}" />"/>
						<td><input id="productName" class="box" type="" name="productName"  value="<c:out value="${current.productName}" />" readonly></td>
			  			<td><input id="quantity"  class="box"type="" name="quantity"  value="<c:out value="${current.quantity}"/>" readonly></td>
			  			<td><input id="price" class="box"type="" name="price"  value="<c:out value="${current.price}"/>" readonly></td>
			  			<td><input id="vname" class="box" type="" name="vname" value="<c:out value="${current.vname}"/>" readonly></td>
						<td>
						<input class="Edit" type="submit" name="action" value="Edit">
			  			<input type="submit" name="action" value="Delete">
						</td>
				</tr>
				</c:forEach>
						
			</table>
		</form>
		
			
     		
			


<%@include file="WEB-INF/pages/template/footer.jsp" %>