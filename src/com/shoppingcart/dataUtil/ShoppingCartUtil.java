package com.shoppingcart.dataUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.shoppingcart.entity.CartHistory;
import com.shoppingcart.entity.CartProduct;
import com.shoppingcart.entity.Product;
import com.shoppingcart.entity.User;

public class ShoppingCartUtil {

	@Resource(name = "jdbc/Shopping")
	private DataSource dataSource;

	
	
	public ShoppingCartUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<CartProduct> getCartItems(String username) throws Exception {

			List<CartProduct> cartProduct = new ArrayList<>();
			CartProduct tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM shopping.cart WHERE Username=?";
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1, username);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int cartId= rs.getInt("Cart_Id");
					String user = rs.getString("Username");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					int quantity = rs.getInt("Quantity");
					double Total_Quantity_Price = rs.getDouble("Total_Quantity_Price");
					// Create new product object
					tempProduct = new CartProduct(cartId, user, product_name, product_desc, product_price, quantity, Total_Quantity_Price);
					cartProduct.add(tempProduct);
				}
				
				return cartProduct;
				}
				finally
				{
				close(con,pstmt,rs);
				}
	}

	public CartProduct getCartProductItem(int CartId) throws Exception {

		CartProduct cart = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String query;
		try {
			// Connect to DB
			con = dataSource.getConnection();

			// Create SQL statement to get Cart
			query = "SELECT * FROM shopping.cart WHERE Cart_Id=?";

			// Create prepared statement
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, CartId);

			// Execute query
			rst = pstmt.executeQuery();

			// Return cart
			if (rst.next()) {
				
				int cartId = rst.getInt("Cart_Id");
				String username = rst.getString("Username");
				String productName = rst.getString("Product_name");
				String productDesc = rst.getString("product_desc");
				double productPrice = rst.getDouble("Product_Price");
				int quantity = rst.getInt("Quantity");
				cart = new CartProduct(cartId, username, productName, productDesc, productPrice, quantity);
				
			}

			// Return CartProduct
			return cart;

		} finally {
			// Close JDBC
			close(con, pstmt, rst);
		}
	}
	
	public void updateShoppingCartItem(int cartId, int quantity, double total_quantity_price) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String query;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			query = "UPDATE shopping.cart SET Quantity=?, Total_Quantity_Price=? WHERE Cart_Id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, quantity);
			pstmt.setDouble(2, total_quantity_price);
			pstmt.setInt(3, cartId);
			pstmt.executeUpdate();

		} finally {
			// Close JDBC connection
			close(con, pstmt, rst);
		}
	}
	

	public void deleteShoppingCartItem(int cartId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String query;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			query = "DELETE FROM shopping.cart WHERE Cart_Id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cartId);
			pstmt.executeUpdate();

		} finally {
			// Close JDBC connection
			close(con, pstmt, rst);
		}
	}

	public void addCartDetails(String username, String product_name, String product_desc, Double product_price, int quantity, Double total_quantity_price) throws Exception {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
			//create a connection
			con = dataSource.getConnection();
			//create sql query 
			String qry = "INSERT INTO shopping.cart(Username, Product_Name, Product_Desc, Product_Price, Quantity, Total_Quantity_Price) VALUES(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			//set the parameters for the students
			pstmt.setString(1, username);
			pstmt.setString(2, product_name);
			pstmt.setString(3, product_desc);
			pstmt.setDouble(4, product_price);
			pstmt.setInt(5, quantity);
			pstmt.setDouble(6, total_quantity_price);
			
			//execute the sql query
			pstmt.execute();
			}
			finally
			{
			close(con,pstmt,null);
			}
		}
    
    	private void close(Connection con, Statement stmt, ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

    	
		public List<Product> getJacketItems() throws SQLException {
			
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_jacket";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Jacket_id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
			
	    
		}

		public List<Product> getPantsItems() throws Exception {
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_pants";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Pants_id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<Product> getShirtItems() throws Exception {
			
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_shirt";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Shirt_id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<Product> getShortItems() throws Exception {
			
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_shorts";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Shorts_Id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<Product> getShoeItems() throws SQLException {

			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_shoe";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Shoe_Id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public double getPayablePrice(String username) throws SQLException {
			
			double payable = 0;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT ROUND(sum(Product_Price),2) AS Payable FROM shopping.cart WHERE Username=? ";
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1, username);
				//execute the sql query
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					payable = rs.getDouble("Payable");
				}
				
				return payable;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<CartHistory> addCartHistory(List<CartProduct> purchaseItem) {
			// TODO Auto-generated method stub
			return null;
		}

		public User viewUserProfile(String username) throws SQLException {

			User user = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rst = null;
			String query;
			try {
				// Connect to DB
				con = dataSource.getConnection();

				// Create SQL statement to get Cart
				query = "SELECT Username, Email FROM user WHERE Username=?";

				// Create prepared statement
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);

				// Execute query
				rst = pstmt.executeQuery();

				// Return cart
				if (rst.next()) {
					
					String username1 = rst.getString("Username");
					String email = rst.getString("Email");
					user = new User(username1, email);
					
				}

				// Return CartProduct
				return user;

			} finally {
				// Close JDBC
				close(con, pstmt, rst);
			}
		}


		

/*		public List<CartHistory> storeItems(String username) throws Exception {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
			con = dataSource.getConnection();
			String qry = "INSERT INTO shopping.cart (Username, ItemName, ItemDesc, ItemPrice, Quantity, TotalItemPrice, TotalPurchasePrice, Date_Of_Purchase"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			List<CartProduct> cartProduct = getCartItems(username);
			double totalPrice = 0;
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			List<CartHistory> cartHis = new ArrayList();
			for(int i=0; i<cartProduct.size();i++) {
				
				totalPrice = totalPrice + cartProduct.get(i).getTotal_Quantity_Price();
				cartHis.add(new CartHistory(username, cartProduct.get(i).getProduct_name(),cartProduct.get(i).getProduct_desc(), 
						cartProduct.get(i).getProduct_price(), cartProduct.get(i).getQuantity(), cartProduct.get(i).getTotal_Quantity_Price(),
						totalPrice, formatter.format(date)));
			}
			
			for(int i=0; i<cartProduct.size(); i++) {
			pstmt.setString(1, username);
			pstmt.setString(2, cartProduct.get(i).getProduct_name());
			pstmt.setString(3, cartProduct.get(i).getProduct_desc());
			pstmt.setDouble(4, cartProduct.get(i).getProduct_price());
			pstmt.setInt(5, cartProduct.get(i).getQuantity());
			pstmt.setDouble(6, cartProduct.get(i).getTotal_Quantity_Price());
			pstmt.setDouble(7, totalPrice);
			pstmt.setString(8, formatter.format(date));
			pstmt.execute();
			}
			return cartHis;
			}finally {
				close(con,pstmt,null);
			}
		}*/


}