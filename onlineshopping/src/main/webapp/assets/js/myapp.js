
$(function() {
	
	switch(menu) {
	
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;		
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;		
		deafult:
			if(menu == "Home") break;
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
			
	} 
		
		
	var table = $('#productListTable');
	
	if(table.length) {
		
		var jsonUrl = '';
		
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + "/json/data/all/products";
		}
		else{
			jsonUrl = window.contextRoot + "/json/data/category/"+ window.categoryId+"/products";
		}
		
		table.DataTable({			
			ajax: {
				url : jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'name'					
				},
				{
					data: 'brand'					
				},
				{
					data: 'unitPrice'					
				},
				{
					data: 'quantity'					
				},
				{
					data: 'id',
					mRender: function(data, type, row) {
						
						var str = '';
						
						str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-default">View</a>';
						str += ' | ';
						str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-default">Add to Cart</a>';
						
						return str;
					}
				},
			]
		});
		
	}
	
});