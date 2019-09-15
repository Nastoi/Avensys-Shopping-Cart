package com.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.shoppingcart.dataUtil.UserDataUtil;
import com.shoppingcart.entity.User;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// initialize user's data util
	private UserDataUtil userDataUtil;
	
	@Resource(name="jdbc/Shopping") // TODO: add database schema name
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		try {
			// create user db util and connect to data pool
			userDataUtil = new UserDataUtil(dataSource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/**
			 * 1. get command value from form
			 * 2. run switch based off command value
			 * 3. run the method for the given command
			 */
			String theCommand = request.getParameter("command");
			if(theCommand == null) {
				theCommand = "REGISTER";
			}
			switch(theCommand) {
			case "LOGIN":
				loginUser(request,response);
				break;
			case "REGISTER":
				registerUser(request,response);
				break;
			default:
				loginUser(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub */
		/**
		 * 1. Read input that is passed in
		 * 2. create new user object to save the input
		 * 3. insert new user into database
		 */ 
		String user_firstname = request.getParameter("fname"); // TODO: find out the exact name of the input
		String user_lastname = request.getParameter("lname");
		String user_username = request.getParameter("uname");
		String user_email = request.getParameter("email");
		String user_password = request.getParameter("password");
		String user_gender = request.getParameter("optradio");
		String user_dob = request.getParameter("dob");
		String user_address = request.getParameter("address");
		String user_contact = request.getParameter("contact");
		
		
		User theUser = new User(user_username,user_password,user_firstname,user_lastname,user_email, user_gender, user_dob,user_address,user_contact);
		
		userDataUtil.registerUser(theUser);
		System.out.println("db insertion success");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/default.jsp");
		
		dispatcher.forward(request, response);
	}

	//private void viewUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * 1. retrieve user id from page
		 * 2. execute sql statement in data util and retrieve user data from the user id
		 * 3. save result set to new student object and set attribute
		 */
	/*	String user_username = request.getParameter("");
		User userProfile = userDataUtil.viewUserProfile(user_username);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/.jsp"); // TODO: change the jsp to the profile page
		request.setAttribute("", userProfile); // TODO: remember set the attribute name
		dispatcher.forward(request, response);
	}*/
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		/**
		 * 1. retrieve user email and password and verify
		 * 2. execute sql statement to find user
		 * 3. save result set into new Student object and display.
		 */
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		String errorMsg = "Username or Password is invalid.";
		User thisUser = userDataUtil.loginUser(uname,pswd);
		if(thisUser== null) { // this means no such email or password exist in the db, this will return back to login page to display error
			request.setAttribute("error", errorMsg); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); // TODO: return to login page and display error message
			dispatcher.forward(request, response);
		}else { // thisUser has data inside, meaning the username and password matches
			
			HttpSession session = request.getSession();
			
			session.setAttribute("username", uname);
			
			//request.setAttribute("user", thisUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp"); // TODO: redirect to welcome page 
			dispatcher.forward(request, response);
		}
	}

}