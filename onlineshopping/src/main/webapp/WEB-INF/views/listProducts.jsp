<div class="container">
	<div class="row">
		<!--display sidebar  -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>


		</div>
		<!--display the actual products  -->
		<div class="col-md-9">
			<!--Added breadcrumb component  -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item">Category</li>
							<li class="breadcrumb-item active" aria-current="page">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>

		</div>

	</div>


</div>


