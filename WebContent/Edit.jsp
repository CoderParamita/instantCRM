<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="WEB-INF/css/createproductdetails.css"/>
<jsp:include page="WEB-INF/css/BasicTemplate.css"/>
<%@include file="WEB-INF/pages/template/header.jsp" %>
<%@include file="WEB-INF/pages/template/body.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script  type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script  type="text/javascript" src="js/validation.js"></script>
<title>Edit Page</title>

<body>
	<div >
	<form method="post" action="./updateproductdetails">
		<div id="prdetailsdiv">
            <div id="prdetaildiv">
            <span>Edit Product Details</span><br/>
            	<input type="hidden" class="inputbox" name="productId" value="<c:out value="${productId}"/>"/>
                <label>Product Name</label>&nbsp;
                <input type="text"  class="inputbox" name="productname" value="<c:out value="${productname}" />"readonly/>
                <label>Quantity</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="inputbox" name="quantity" value="<c:out value="${quantity}"/>" id="quantity" /><br/>
                <label>Price/unit</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;
                <input type="text" class="inputbox" name="price" value="<c:out value="${price}"/>"/ id="price"><br/>
                <label>Vendor's Name</label>
                <input type="text" class="inputbox" name="vendorname" value="<c:out value="${vendorName}"/>" id="vendorname"/>
            </div>
            <div id="prdetaillowdiv">
                <input type="submit" id="#createproduct" class="button" value="Update">
                </div>
            </div>
	</form>
</div>

<%@include file="WEB-INF/pages/template/footer.jsp" %>

