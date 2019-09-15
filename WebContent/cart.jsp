<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>

<title>Shopping Cart</title>
 <link type="text/css" rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
		<title>Shopping Cart</title>
		<style>
				body {font-family: "Times New Roman", Georgia, Serif;}
				h1, h2, h3, h4, h5, h6 {
				  font-family: "Playfair Display";
				  letter-spacing: 5px;
				}
				
				table {
				
				font-family: "Calibri";
				width: 100%;
				
				}
				
				tr, th, td {
				border-bottom: 1px solid #ddd;
				text-align: center;
			
				}
				
				td:hover{font-weight:bold;}
				
				tr:hover {background-color: #f5f5f5;}
				
		</style>
</head>
<body>
 <div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="#home" class="w3-bar-item w3-button">Avensys ShopLah!</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="catalogue.jsp" class="w3-bar-item w3-button">continue shopping</a>
    </div>
  </div>
</div>
        
     
<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->

    <div class="w3-col m6 w3-padding-large">
        <br>
      <h1 class="w3-center">Review your purchase</h1><br>
      <table>
        <tr>
            <th>Product_Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total Price Of Item</th>
            
            
        </tr>  
        <c:forEach var="cartItems" items="${CART_LIST}">
      	  <tr>
        
        	 <c:url var="deleteCartId" value="CartControllerServlet">
				<c:param name="command" value="DELETE" />
				<c:param name="cartId" value="${ cartItems.cartId }"/>
				<c:param name="username" value="${ cartItems.user }"/>
			</c:url>
			
			<c:url var="updateCartId" value="CartControllerServlet">
				<c:param name="command" value="SELECTCART" />
				<c:param name="cartId" value="${ cartItems.cartId }"/>
				<c:param name="username" value="${ cartItems.user }"/>
			</c:url>
        	
        		<!--  <td>${ cartItems.cartId }</td>
                <td>${ cartItems.user } </td> -->
               	<td>${ cartItems.product_name }</td>
               	<td>${ cartItems.product_desc }</td>
               	<td>${ cartItems.product_price }</td>
               	<td>${ cartItems.quantity }</td>
               	<td>${ cartItems.total_Quantity_Price }</td>
           		<td><a href="${ deleteCartId }" class="w3-bar-item w3-button">Remove Item</a></td>
           		<td><a href="${ updateCartId }" class="w3-bar-item w3-button">Update Quantity</a></td>
           		
          </tr>	
         
        </c:forEach> 
            	
          <!--   	<c:forEach var="cartItems" items="${CART_LIST}"> -->
            	
            	<c:url var="purchase" value="CartControllerServlet">
					<c:param name="command" value="PUCHASE" />
					<c:param name="cartId" value="${ cartItems.cartId }"/>
					<c:param name="username" value="${ cartItems.user }"/>
				<!-- 	<c:param name="product_name" value="${ cartItems.product_name }"/>
		            <c:param name="product_desc" value="${ cartItems.product_desc }"/>
		            <c:param name="product_price" value="${ cartItems.product_price }"/>
		            <c:param name="quantity" value="${ cartItems.quantity }"/>
		            <c:param name="total_Quantity_Price" value="${ cartItems.total_Quantity_Price }"/>
		            <c:param name="payable" value="${ PAYABLE }"/>  -->
					
				</c:url>
		<!-- 	</c:forEach>-->
			
             <tr>
	          	<td></td>
	          	<td></td>
	          	<td></td>
	          	<td></td>
	          	<td><input name="payable_amount" value="${ PAYABLE }" readonly></td>
	          	<td><a href="${ purchase }" class="w3-bar-item w3-button">Pay</a></td>
         	 </tr>
          
       
          
      </table>
    </div>
    
  </div>
       
  
  <hr>
  
 

  <hr>

  <!-- Contact Section -->
  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  
<!-- End page content -->


<!-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-32">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer>




</body>
</html>

