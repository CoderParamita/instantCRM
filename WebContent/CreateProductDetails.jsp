<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="WEB-INF/css/createproductdetails.css"/>
<jsp:include page="WEB-INF/css/BasicTemplate.css"/>
<%@include file="WEB-INF/pages/template/header.jsp" %>
<%@include file="WEB-INF/pages/template/body.jsp" %>
<script  type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script  type="text/javascript" src="js/validation.js"></script>
<title>Create Product</title>
<body>
	<div >
	<form method="post" action="./createproductddetails">
		<div id="prdetailsdiv">
            <div id="prdetaildiv">
            <span>Create Product Details</span><br/>
                <label>Product Name</label>&nbsp;
                <input type="text" class="inputbox" name="productname" id="prdname"/>
                <label>Quantity</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="inputbox" name="quantity" id="quantity"/><br/>
                <label>Price/unit</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;
                <input type="text" class="inputbox" name="price" id="price"/><br/>
                <label>Vendor's Name</label>
                <input type="text" class="inputbox" name="vendorname" id="vendorname"/>
            </div>
            <div id="prdetaillowdiv">
                <input type="submit" id="#createproduct" class="button" value="Create">
                </div>
            </div>
	</form>
</div>


<%@include file="WEB-INF/pages/template/footer.jsp" %>