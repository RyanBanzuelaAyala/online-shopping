$(function() {

	switch (menu) {

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
		deafult: if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

//	------------------------------------------------------------------------------
//	List of all products for guest

	var table = $('#productListTable');

	if (table.length) {

		var jsonUrl = '';

		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + "/json/data/all/products";
		} else {
			jsonUrl = window.contextRoot + "/json/data/category/"
			+ window.categoryId + "/products";
		}

		table
		.DataTable({

			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice'
				},
				{
					data : 'quantity'
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {

						var str = '';

						str += '<a href="'
							+ window.contextRoot
							+ '/show/'
							+ data
							+ '/product" class="btn btn-primary">View</a> &#160;';

						str += '<a href="'
							+ window.contextRoot
							+ '/manage/'
							+ data
							+ '/product" class="btn btn-warning">Manage</a>';

						return str;

					}

				} ]
		});

	}

//	------------------------------------------------------------------------------
//	for fading out the alert message after 3 seconds
	$alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

//	------------------------------------------------------------------------------
//	List of all products for admin

	var $productsTable = $('#productsTable');

	if ($productsTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		console.log(jsonUrl);

		$productsTable
		.DataTable({

			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row) {
						return '&#8377; ' + data
					}
				},
				{
					data : 'quantity',
					mRender : function(data, type, row) {

						if (data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}

						return data;

					}
				},
				{
					data : 'active',
					mRender : function(data, type, row) {
						var str = '';

						if (data) {
							str += '<label class="switch"> <input type="checkbox" value="'
								+ row.id
								+ '" checked>  <div class="slider round"> </div></label>';

						} else {
							str += '<label class="switch"> <input type="checkbox" value="'
								+ row.id
								+ '"> <div class="slider round"> </div></label>';
						}

						return str;
					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {

						var str = '';
						str += '<a href="'
							+ window.contextRoot
							+ '/manage/'
							+ data
							+ '/product" class="btn btn-primary">Edit</a>';

						str += '<button class="btn btn-primary del" title="'
							+ row.id + '"> Delete </button>';

						return str;
					}
				} ],
				initComplete : function() {

					var api = this.api();

					api
					.$('.switch input[type="checkbox"]')
					.on(
							'change',
							function() {
								var dText = (this.checked) ? 'You want to activate the Product?'
										: 'You want to de-activate the Product?';
								var checked = this.checked;
								var checkbox = $(this);
								debugger;
								bootbox
								.confirm({
									size : 'medium',
									title : 'Product Activation/Deactivation',
									message : dText,
									callback : function(
											confirmed) {
										if (confirmed) {
											$
											.ajax({
												type : 'GET',
												url : window.contextRoot
												+ '/manage/product/'
												+ checkbox
												.prop('value')
												+ '/activation',
												timeout : 100000,
												success : function(
														data) {
													bootbox
													.alert(data);
												},
												error : function(
														e) {
													bootbox
													.alert('ERROR: '
															+ e);
													// display(e);
												}
											});
										} else {
											checkbox.prop(
													'checked',
													!checked);
										}
									}
								});
							});

					$('.del')
					.on(
							'click',
							function() {
								var dText = 'are you sure you want to delete this Product?';
								var val = $(this).attr('title');
								bootbox
								.confirm({
									size : 'medium',
									title : 'Product Delettion',
									message : dText,
									callback : function(
											confirmed) {
										if (confirmed) {
											$
											.ajax({
												type : 'GET',
												url : window.contextRoot
												+ '/manage/product/'
												+ val
												+ '/delete',
												timeout : 100000,
												success : function(
														data) {
													bootbox
													.alert(data);
													/*
													 * $(
													 * '#productsTable')
													 * .DataTable().ajax
													 * .reload();
													 */
													window.location = window.contextRoot
													+ '/manage/products';
												},
												error : function(
														e) {
													bootbox
													.alert('ERROR: '
															+ e);
													// display(e);
												}
											});
										} else {

										}
									}
								});
							});

				}

		});
	}

});