package com.shoppingcart.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shoppingcart.dataUtil.ShoppingCartUtil;
import com.shoppingcart.entity.CartHistory;
import com.shoppingcart.entity.CartProduct;
import com.shoppingcart.entity.Product;
import com.shoppingcart.entity.SendEmail;
import com.shoppingcart.entity.User;


/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/CartControllerServlet")
public class CartControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ShoppingCartUtil shoppingCartUtil;
	private SendEmail sendEmail;
	 
	@Resource(name="jdbc/Shopping")
	private DataSource dataSource;
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
    	
		try {
			
			shoppingCartUtil = new ShoppingCartUtil(dataSource);
		//super.init();
		}
		catch (Exception e){
			throw new ServletException(e);
		}
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	try {
			String theCommand=request.getParameter("command");
			//if the command is missing then display listing
			if(theCommand==null) {
			theCommand = "JACKET";
			}
			
			//routing to appropriate method
			switch(theCommand)
			{
			case "JACKET" :
				fetchJacketItems(request,response);
				break;
			case "PANTS" :
				fetchPantsItems(request,response);
				break;
			case "SHIRT" :
				fetchShirtItems(request,response);
				break;
			case "SHORT" :
				fetchShortItems(request,response);
				break;
			case "SHOE" :
				fetchShoeItems(request,response);
				break;
			case "CART" :
				fetchCartItems(request,response);
				break;
			case "ADD" :	
				addProductToCart(request,response);
				break;
			case "DELETE" :	
				deleteShoppingCartItem(request,response);
				break;
			case "UPDATE" :	
				updateShoppingCartItem(request,response);
				break;
			case "SELECTCART" :	
				displayShoppingCartItemDetails(request,response);
				break;
			case "PURCHASE" :
				puchaseItemDetail(request,response);
			default:
				fetchJacketItems(request,response);
				break;
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	
	
	private void puchaseItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("username");
		
		User userEmail = shoppingCartUtil.viewUserProfile(username);
		
		String email = userEmail.getEmail();
		
		sendEmail.sendMail(username, email);
		
		/*List<CartProduct> purchaseItem = shoppingCartUtil.getCartItems(username);
		

		List<CartHistory> cartHistory = shoppingCartUtil.addCartHistory(purchaseItem);
		
		request.setAttribute("userCartHist", cartHistory)*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cartHistory.jsp");
		dispatcher.forward(request, response);
	}

	
	
	private void fetchCartItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("username");
		
		
		try {
			List<CartProduct> cartProduct = shoppingCartUtil.getCartItems(username);
			
			
			request.setAttribute("CART_LIST", cartProduct);
			
			double payable_amount = shoppingCartUtil.getPayablePrice(username);
			
			request.setAttribute("PAYABLE", payable_amount);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private void fetchShoeItems(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Product> product = shoppingCartUtil.getShoeItems();
		
		String category = request.getParameter("category");
		
		request.setAttribute("Product_Cat", category);
		request.setAttribute("PRODUCT_LIST", product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
		dispatcher.forward(request, response);
		
	}

	private void fetchShortItems(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Product> product = shoppingCartUtil.getShortItems();
		
		String category = request.getParameter("category");
		
		request.setAttribute("Product_Cat", category);
		request.setAttribute("PRODUCT_LIST", product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
		dispatcher.forward(request, response);
		
	}

	private void fetchShirtItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> product = shoppingCartUtil.getShirtItems();
		
		String category = request.getParameter("category");
		
		request.setAttribute("Product_Cat", category);
		request.setAttribute("PRODUCT_LIST", product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
		dispatcher.forward(request, response);
	}

	private void fetchPantsItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> product = shoppingCartUtil.getPantsItems();
		
		String category = request.getParameter("category");
		
		request.setAttribute("Product_Cat", category);
		request.setAttribute("PRODUCT_LIST", product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
		dispatcher.forward(request, response);
		
	}

	private void fetchJacketItems(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Product> product = shoppingCartUtil.getJacketItems();
	
		String category = request.getParameter("category");
		
		request.setAttribute("Product_Cat", category);
		request.setAttribute("PRODUCT_LIST", product);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
		dispatcher.forward(request, response);
	}

/*	private void listCartItems(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Read username
		String username = request.getParameter("username");

		// Get students from shoppingCartUtil, set to request
		List<CartProduct> cartProducts = shoppingCartUtil.getCartItems(username);
		request.setAttribute("CART_ITEMS", cartProducts);

		// Get RequestDispatcher, forward to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
	}*/

	private void displayShoppingCartItemDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. Read username and productId from Cart
		int CartId = Integer.parseInt(request.getParameter("cartId"));
		
		// 2. Get shoppingCartItem details from DB
		CartProduct cartProductItem = shoppingCartUtil.getCartProductItem(CartId);

		// 3. Place shoppingPartItem in request attribute
		request.setAttribute("CART_ITEM", cartProductItem);

		// 4. Send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/quantityUpdate.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteShoppingCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. Read cartId from Cart
		int cartId = Integer.parseInt(request.getParameter("cartId"));

			// 2. Delete from Cart
			shoppingCartUtil.deleteShoppingCartItem(cartId);
		
		// Redirect to list shopping cart items page
		fetchCartItems(request, response);
	}

	
	private void updateShoppingCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Get add shopping cart item form parameters
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double product_price = Double.parseDouble(request.getParameter("product_price"));
		double total_quantity_price = product_price * quantity;
		
		// Add cart item to DB
	
			shoppingCartUtil.updateShoppingCartItem(cartId,quantity,total_quantity_price);
			
			
			fetchCartItems(request, response);
	}
	
	
	
	private void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub'
			//get the students from StudentDbUtil

		String username = request.getParameter("username");
		String product_name = request.getParameter("productName");
		String product_desc = request.getParameter("productDesc");
		double product_price = Double.parseDouble(request.getParameter("productPrice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double total_quantity_price = product_price * quantity;
		
		shoppingCartUtil.addCartDetails(username, product_name, product_desc, product_price, quantity, total_quantity_price );

		request.setAttribute("username", username);
		
		String category = request.getParameter("category");
		
		if(category.equals("Jackets"))
		{
			fetchJacketItems(request, response);
		}
		else if(category.equals("Pants"))
		{
			fetchPantsItems(request, response);
		}
		else if(category.equals("Shirts"))
		{
			fetchShirtItems(request, response);
		}
		else if(category.equals("Shorts"))
		{
			fetchShortItems(request, response);
		}
		else if(category.equals("Shoes"))
		{
			fetchShoeItems(request, response);
		}
		
	}
	
	

/*	private void storeCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("username");
		List<CartProduct> purchases = shoppingCartUtil.storeItems(username);
		request.setAttribute("cartHistory", purchases);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart_history.jsp");
		dispatcher.forward(request, response);
	} */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
