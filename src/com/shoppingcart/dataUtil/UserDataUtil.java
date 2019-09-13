package com.shoppingcart.dataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.shoppingcart.entity.User;

public class UserDataUtil {
	
	@Resource(name="jdbc/shopping") // TODO: add database schema name
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
			String query = "INSERT INTO `shopping`.`user` (`Username`, `Password`, `Firstname`, `Lastname`, `Email`, `Gender`, `Dob`, `Address`, `Contact`)"
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
			System.out.println("registration sql statement success: "+registrationSuccess);
			
		}finally {
		close(con, pstmt, null);
		}
		
	}

}