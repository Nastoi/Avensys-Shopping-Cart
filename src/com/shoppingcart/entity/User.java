package com.shoppingcart.entity;

public class User {
	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String date_of_birth;
	private String address;
	private String contact;
	
	//3 constructor methods
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * this constructor is with id
	 * @param user_id
	 * @param username
	 * @param password
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param gender
	 * @param date_of_birth
	 * @param address
	 * @param contact
	 */
	public User(int user_id, String username, String password, String first_name, String last_name, String email,
			String gender, String date_of_birth, String address, String contact) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.contact = contact;
	}

	/**
	 *  this constructor is without id
	 * @param username
	 * @param password
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param gender
	 * @param date_of_birth
	 * @param address
	 * @param contact
	 */
	public User(String username, String password, String first_name, String last_name, String email, String gender,
			String date_of_birth, String address, String contact) {
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.contact = contact;
	}
	public User(String username, String email) {
		this.username=username;
		this.email=email;
	}

	// setter getter methods
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", email=" + email + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", address=" + address + ", contact=" + contact + "]";
	}
}
