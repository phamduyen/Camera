<%@page import="bean.IsProduct"%>
<%@page import="bean.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>
<%@include file="/templates/public/inc/slider.jsp"%>
         <div class="container_fullwidth">
         <%
	ArrayList<Products> listProduct = (ArrayList<Products>)request.getAttribute("listProduct");
	ArrayList<IsProduct> listIsProduct = (ArrayList<IsProduct>)request.getAttribute("listIsProduct");%>
            <div class="container">
               <div class="hot-products">
                <h3 class="title"><strong>Search Result  </strong> Products</h3>
                  <div class="control"><a id="prev_hot" class="prev" href="#">&lt;</a><a id="next_hot" class="next" href="#">&gt;</a></div>
                  <ul id="hot">
                  <%
                  	int count = 0;
                  	int indexPrint = 0;
                  	for(;count<listProduct.size();){
                  %>
                     <li>
                        <div class="row">
                        <%
                        	for(;count<listProduct.size();count++){
                    	 		/* if(listProduct.get(count).getIsProduct() == 3){ */
                    	 		indexPrint++;
                    	 		if((indexPrint!=1) && (indexPrint % 4 == 1)){indexPrint = 0;break;}
                    	 %>
                           <div class="col-md-3 col-sm-6">
                              <div class="products">
                                 
                                 <div class="thumbnail"><a href="detail?id=<%=listProduct.get(count).getIdProduct()%>"><img src="<%=request.getContextPath() %>/files/<%=listProduct.get(count).getPhotoProduct() %>" alt="Product Name"></a></div>
                                 <div class="productname"><%=listProduct.get(count).getNameProduct() %></div>
								 <div class="productname desc">
								 </div>
                                 <div class="button_group">
									<i class="price">$<%=listProduct.get(count).getPrice() %></i>
									<button class="button add-cart" type="button" onclick="mua('<%=listProduct.get(count).getIdProduct()%>','<%=listProduct.get(count).getNameProduct()%>',1,<%=listProduct.get(count).getPrice()%>,'<%=listProduct.get(count).getPhotoProduct()%>');">Add To Cart</button>
								 </div>
                              </div>
                           </div>
                           <%
                    	 	}%>
                        </div>
                        
                     </li>
                     <%} %>
                  </ul>
               </div>
               <div class="clearfix"></div>
               
<script type="text/javascript">
		function mua(idProduct,nameProduct,quality,price,picture){
				$.ajax({
				url: '<%=request.getContextPath()%>/basket',
				type: 'POST',
				cache: false,
				data: {idProduct: idProduct, nameProduct: nameProduct, quality: quality, price: price, picture: picture},
				success: function(data){
					//alert(data);
					$('.option-cart').html(data);
				},
				error: function (){
					alert('Something went wrong!');
				}
			});
			return false;
		}
</script>
<%@include file="/templates/public/inc/footer.jsp"%>
