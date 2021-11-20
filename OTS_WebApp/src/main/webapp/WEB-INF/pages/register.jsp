<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	Register Here Employees
<a href="loginpage">Login Here</a> 

	<div class="container">
		<form action="register" method="post">
			
			<div class="form-group">
				<label for="txtstufname">Student first Name</label> <input type="text"
					class="form-control" id="txtstuname" name="txtfename"
					placeholder="Enter First Name">
			</div>
			<div class="form-group">
				<label for="txtstulname">Student Last Name</label> <input type="text"
					class="form-control" id="txtstuname" name="txtlename"
					placeholder="Enter Last Name">
			</div>
			<div class="form-group">
				<label for="lblemail" class="form-label">Email address</label> <input
					type="email" name="txtemail" class="form-control" name="txtemail" id="lblemail"
					placeholder="name@example.com">
			</div>
			<div class="form-group">
				<label for="lblPassword1" class="form-label">Password</label>
				<input type="password" class="form-control" id="lblPassword1" name="txtpassword">
			</div>
			
			<div class="form-group">
				<label for="lblcontact" class="form-label">Contact</label>
				<input type="text" class="form-control" id="lblcontact" name="txtcontact">
			</div>
			
			
			<!--   
			<div class="form-group">
				<label for="lbladdId" class="form-label">Address id</label>
				<input type="text" class="form-control" id="lbladdId" name="txtaddid">
			</div>-->
			<div class="form-group">
				<label for="lblhouseNo" class="form-label">House no</label>
				<input type="number" class="form-control" id="lblcontact" name="txthouseno">
			</div>
			<div class="form-group">
				<label for="lblstreet" class="form-label">Street</label>
				<input type="text" class="form-control" id="lblstreet" name="txtstreet">
			</div>
			<div class="form-group">
				<label for="lblcity" class="form-label">City</label>
				<input type="text" class="form-control" id="lblcity" name="txtcity">
			</div>
			<div class="form-group">
				<label for="lblstate" class="form-label">State</label>
				<input type="text" class="form-control" id="lblstate" name="txtstate">
			</div>
			<div class="form-group">
				<label for="lblpincode" class="form-label">Pincode</label>
				<input type="number" class="form-control" id="lblpincode" name="txtpincode">
			</div>
			
			
			
			
			<div class="form-group">
				Gender
				<div class="form-check">
					<label class="form-check-label" for="flexRadioMale">Male</label>
					<input class="form-check-input" type="radio" name="txtgender"
						id="flexRadioMale" value="Male" checked="checked">
				</div>
				<div class="form-check">
					<label class="form-check-label" for="flexRadioFemale">Female</label>
					<input class="form-check-input" type="radio" name="txtgender"
						id="flexRadioFemale" value="Female">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Add Student</button>
		</form>
	</div>
</body>
</html>