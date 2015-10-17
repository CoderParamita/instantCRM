<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<title>ShowProDuctDetails</title>
	<jsp:include page="WEB-INF/css/BasicTemplate.css"/>
	<jsp:include page="WEB-INF/css/productlist.css"/>	
	<%@include file="WEB-INF/pages/template/header.jsp" %>
	<%@include file="WEB-INF/pages/template/body.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ page import="com.pms.buisnesslogic.ShowProductLIstBean" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.List" %>
<body>
<div id="searchresult">
<h4>Search Result</h4>
<div align="center" id="createproduct"> <a href="./gobackproductlist" >Go To ProductList</a> </div>
				<table class="table">
						<tr class="firstrow"><th>Product Name</th><th>Quantity</th><th>Price/unit</th><th>Vendor's Name</th></tr>
						<c:forEach var="search" items="${sessionScope.searchproductname}" >
							<tr>
								<td><c:out value="${search.productName}"/></td>
								<td><c:out value="${search.quantity}"/></td>
								<td><c:out value="${search.price}"/></td>
								<td><c:out value="${search.vname}"/></td>
								
							
							</tr>
						</c:forEach>
					
				</table>
			
			</div>
			
<%@include file="WEB-INF/pages/template/footer.jsp" %>