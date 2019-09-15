package com.shoppingcart.dataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.shoppingcart.entity.Product;
import com.shoppingcart.entity.User;

public class UserDataUtil {
	
	@Resource(name="jdbc/shopping")
	private DataSource dataSource;

	public UserDataUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	private void close(Connection con,Statement stmt, ResultSet rs) {
		try {
			if(rs!= null) {
				rs.close();
			}
			if(stmt!= null) {
				stmt.close();
			}
			if(con!= null) {
				con.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void registerUser(User theUser) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "INSERT INTO shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, theUser.getUsername());
			pstmt.setString(2, theUser.getPassword());
			pstmt.setString(3, theUser.getFirst_name());
			pstmt.setString(4, theUser.getLast_name());
			pstmt.setString(5, theUser.getEmail());
			pstmt.setString(6, theUser.getGender());
			pstmt.setString(7, theUser.getDate_of_birth());
			pstmt.setString(8, theUser.getAddress());
			pstmt.setString(9, theUser.getContact());
			boolean registrationSuccess = pstmt.execute();
			
			System.out.println("registration sql statement success (false = success): "+registrationSuccess);
			
		}finally {
		close(con, pstmt, null);
		}
		
	}
	
	
	public User loginUser(String input_email, String input_password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		User theUser = null;
		try {
			con = dataSource.getConnection();
			String query = "SELECT * FROM user WHERE Username = ? AND Password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, input_email);
			pstmt.setString(2, input_password);
			rst = pstmt.executeQuery();
			if(rst.next()) { // this is only returning 1 row; the registered user
				theUser = new User();
				theUser.setUsername(rst.getString("Username"));
				theUser.setPassword(rst.getString("password"));
				theUser.setFirst_name(rst.getString("Firstname"));
				theUser.setLast_name(rst.getString("Lastname"));
				theUser.setEmail(rst.getString("Email"));
				theUser.setGender(rst.getString("Gender"));
				theUser.setDate_of_birth(rst.getString("Dob"));
				theUser.setAddress(rst.getString("Address"));
				theUser.setContact(rst.getString("Contact"));
				System.out.println("profile retrieve done.");
			}
			
			return theUser;
		}finally {
		close(con, pstmt, rst);
		}
	}
	
	public List<Product> getProducts() throws SQLException {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rst = null;
		
		try {
			con = dataSource.getConnection();
			
			String qry="select * from shopping.product";
			
			stmt=con.prepareStatement(qry);
			
			rst=stmt.executeQuery(qry);
			
			while(rst.next()) {
				int product_Id= rst.getInt("Product_Id");
				String product_Name= rst.getString("Product_Name");
				String product_Desc= rst.getString("Product_Desc");
				double product_Price= rst.getInt("Product_Price");
				
				
				Product tempProduct = new Product(product_Id, product_Name, product_Desc, product_Price);
				
				products.add(tempProduct);
			}
			return products;
		}
		finally {
			close(con,stmt,rst);
		}
	}
	
	
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}