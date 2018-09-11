
<div class="container">

	<div class="row">
			
        <div class="col-lg-3">
        
			<%@include file="./shared/sidebar.jsp" %>
			
        </div>
		
		<div class="col-md-9">
		
			<div class="row">
			
				<div class="col-lg-12">
								
					<nav aria-label="breadcrumb">	
					<c:if test="${userClickAllProducts == true }">					
					<ol class="breadcrumb">
					
						<li class"breadcrumb-item"><a href="${contextRoot}/home" ></a></li>
						<li class="breadcrumb-item active">All Products</li>
						
					
					</ol>
					</c:if>
					
					
					<c:if test="${userClickCategoryProducts == true }">					
					<ol class="breadcrumb">
					
						<li class"breadcrumb-item"><a href="${contextRoot}/home" ></a></li>
						<li class"breadcrumb-item"><a href="${contextRoot}/show/all/products" >Category</a></li>
						<li class="breadcrumb-item active">${category.name}</li>
						
					
					</ol>
					</c:if>
					</nav>
					
				</div>
			
			</div>
		
		</div>
	
	</div>

</div>