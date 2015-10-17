$(document).ready(function() {
		$(".Edit").click(function() 
		{
			var productId=$(this).closest('tr').find("#productId").val();
			alert(productId);
			var productName = $(this).closest('tr').find("#productName").val();
			var quantity = $(this).closest('tr').find("#quantity").val();
			 var price = $(this).closest('tr').find("#price").val();
			 var vname = $(this).closest('tr').find("#vname").val();
			 
			 var param = {productId:productId,productName: productName, quantity: quantity, price: price, vname: vname};

			$.ajax({
			  url: './editdetails',
			   data: param, 
			   type: 'post',
			  	success: function(result) {
				$('#target').html(result);
				location.href = "Edit.jsp";
			  }
			});
		});
		$(".delete").click(function() 
				{
					alert("delete");			
					var productId=$(this).closest('tr').find("#productId").val();
					
					var param = {productId:productId};
					$.ajax({
					  url: './deleteproduct',
					   data: param, 
					   type: 'post',
					  	success: function(result) {
					  		$(this).remove('tr');
					  		//location.reload();
						
					  }
					});
				});
		
	});