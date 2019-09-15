<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Avensys ShopLah!</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link type="text/css" rel="stylesheet" href="css/stylesheet.css">
		
		<style>
		body {
			font-family: "Times New Roman", Georgia, Serif;
		}
		
		h1, h2, h3, h4, h5, h6 {
			font-family: "Playfair Display";
			letter-spacing: 5px;
		}
		</style>
	</head>
	<body>
	
		<!-- Navbar (sit on top) -->
		<div class="w3-top">
			<div class="w3-bar w3-white w3-padding w3-card"
				style="letter-spacing: 4px;">
				<a href="index.html" class="w3-bar-item w3-button">Avensys
					ShopLah!</a>
				<!-- Right-sided navbar links. Hide them on small screens -->
				<div class="w3-right w3-hide-small">
					<a href="registrationForm.html" class="w3-bar-item w3-button">Register</a>
					<a href="aboutUs.html" class="w3-bar-item w3-button">About Us</a>
					<a href="contact.html" class="w3-bar-item w3-button">Contact Us</a>
	
				</div>
			</div>
		</div>
	
		<!-- Header -->
		<header class="w3-display-container w3-content w3-wide"
			style="max-width: 1600px; min-width: 500px" id="home">
			<div class="w3-display-bottomleft w3-padding-large w3-opacity">
				<h1 class="w3-xxlarge"></h1>
			</div>
		</header>
	
		<!-- Page content -->
		<div class="w3-content" style="max-width: 1100px">
	
			<div class="w3-row w3-padding-64" id="about">
				<div class="w3-col m6 w3-padding-large w3-hide-small">
					<br /> <img src="images/shoppingmall.jpg"
						class="w3-round w3-image w3-opacity-min" alt="Login Image"
						width="600" height="730">
				</div>
	
	
				<div class="w3-col m6 w3-padding-large">
					<h1 class="w3-center">Login</h1>
					<br>
					<form action="UserControllerServlet" class="was-validated">
						<input type="hidden" name="command" value="LOGIN">
						<div class="form-group">
							<label for="uname">Username: </label> <input type="text"
								class="form-control" id="uname" placeholder="Enter username"
								name="uname" required>
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
	
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" placeholder="Enter password"
								name="pswd" required>
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
	
						<p>
							<button class="w3-button w3-light-grey w3-section" type="submit">Login</button>
						</p>
					</form>
	
				</div>
			</div>
	
			<!-- End page content -->
		</div>
	
		<!-- Footer -->
		<!-- Footer -->
		<footer class="w3-center w3-light-grey w3-padding-32">
			<p>Avensys ShopLah! Copyright 2019</p>
		</footer>
	
	</body>
</html>
