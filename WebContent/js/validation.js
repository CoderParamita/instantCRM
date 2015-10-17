$(document).ready(function() {
	
	$("#uname").focusout(function () {
		
	    if (!$(this).val()) {
	        alert("User Name is required");
	        $(this).focus();
	    }
	});
	$("#pass").focusout(function () {
	    if (!$(this).val()) {
	        alert("Password is required");
	        $(this).focus();
	    }
	});
	$("#cmnpass").focusout(function () {
	    if (!$(this).val()) {
	        alert("Confirm is required");
	        $(this).focus();
	    }
	});
	$("#prdname").focusout(function () {
	    if (!$(this).val()) {
	        alert("Product Name required");
	        $(this).focus();
	    }
	});
	$("#quantity").focusout(function () {
	    if (!$(this).val()) {
	        alert("Quantity is  required");
	        $(this).focus();
	    }
	});
	$("#price").focusout(function () {
	    if (!$(this).val()) {
	        alert("Price is required");
	        $(this).focus();
	    }
	});
	$("#vendorname").focusout(function () {
	    if (!$(this).val()) {
	        alert("Vendor Name is required");
	        $(this).focus();
	    }
	});
	
});