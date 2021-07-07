<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>YogGuru | Registration</title>
<link rel="stylesheet" href="<c:url value="resources/css/style.css" />">
<style>
.form {
	width: 100%;
	max-width: 700px;
	padding: 15px;
	margin: 0 auto;
}

img {
	height: 200px;
}
</style>

</head>

<body>
	<div class="container-fluid">
		<!-- navigation bar starts-->
		<div class="top-Heading">
			<!-- <nav class="navbar navbar-expand-lg "> -->
			<span class="navbar-brand sign-nav-header">YogGuru</span>
			<li class="nav-item sign-nav-li" style="float: right;"><a
				class="sign-nav-link" href="index"><svg
						style="color: #00e5ff;" xmlns="http://www.w3.org/2000/svg"
						width="36" height="36" fill="currentColor" class="bi bi-x-circle"
						viewBox="0 0 16 16"> <path
						d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
					<path
						d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
					</svg> </a></li>
		</div>

		<!-- </nav> -->
		<!-- Navigation bar ends -->

		<!-- Login form starts -->
		<div class="login">
			<div class="header">
				<h1 style="text-align: center;">Create Account</h1>
			</div>
			<form id="form" class="form mainform row justify-content-md-center"
				method="post" action="RegisterGuru" onsubmit="return submission()" enctype="multipart/form-data">
				
			   <div class="form-input img-container  col-md-6 ">
                    <img id="image" src="" alt="" style="height:200px; width:200px; ">
                    <label for="file" class="imageLabel">
                        <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor"
                            class="bi bi-camera-fill" viewBox="0 0 16 16">
                            <path d="M10.5 8.5a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z" />
                            <path
                                d="M2 4a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2h-1.172a2 2 0 0 1-1.414-.586l-.828-.828A2 2 0 0 0 9.172 2H6.828a2 2 0 0 0-1.414.586l-.828.828A2 2 0 0 1 3.172 4H2zm.5 2a.5.5 0 1 1 0-1 .5.5 0 0 1 0 1zm9 2.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0z" />
                        </svg>
                    </label>
                    <input type="file" name="profile_photo" id="file" style="display: none;" onchange="return checkImage()" />
                </div>

				<div class="form-input col-md-6">
					<label for="username">Name <span style="color: red;">*</span></label>
					<input type="text" class="form-control"
						style="outline: none !important;" name="name" id="name"
						oninput="checkName()" /> <span class="nameAlert alert"></span>
				</div>
				<div class="form-input col-md-6">
					<label for="username">Contact Number <span
						style="color: red;">*</span></label> <input type="text"
						class="form-control" id="contact" name="contact"
						oninput="checkContact()" /> <span class="contactAlert alert"></span>
				</div>
				<div class="form-input col-md-6">
					<label for="username">Email <span style="color: red;">*</span></label>
					<input type="text" class="form-control" id="email" name="email"
						oninput="advanceCheckEmail();" /> <span class="emailAlert alert" id="emailAlert"></span>
				</div>
				<div class="form-input col-md-6">
					<label for="username">Password <span style="color: red;">*</span></label>
					<input type="password" class="form-control" id="password"
						name="pwd" oninput="checkPassword()" /> <span
						class="passAlert alert"></span>
				</div>
				
				<div class="form-input col-md-6">
                    <label for="username">State </label>
                    <select class="form-control" id="State" onchange="checkState(this.value)" name="state">
                        <option value="" disabled selected>Select state</option>
                        <option value="AndhraPradesh">AndhraPradesh</option>
                        <option value="ArunachalPradesh ">ArunachalPradesh </option>
                        <option value="Assam">Assam</option>
                        <option value="Bihar">Bihar </option>
                        <option value="Chhattisgarh">Chhattisgarh </option>
                        <option value="Goa">Goa</option>
                        <option value="Gujarat">Gujarat </option>
                        <option value="Haryana">Haryana </option>
                        <option value="HimachalPradesh">HimachalPradesh</option>
                        <option value="Jharkhand">Jharkhand </option>
                        <option value="Arunachal">Arunachal </option>
                        <option value="Karnataka">Karnataka</option>
                        <option value="Kerala">Kerala </option>
                        <option value="MadhyaPradesh">MadhyaPradesh </option>
                        <option value="Maharashtra">Maharashtra</option>
                        <option value="Manipur">Manipur</option>
                        <option value="Meghalaya">Meghalaya</option>
                        <option value="Mizoram">Mizoram</option>
                        <option value="Nagaland">Nagaland</option>
                        <option value="Odisha">Odisha</option>
                        <option value="Punjab">Punjab</option>
                        <option value="Rajasthan">Rajasthan</option>
                        <option value="Sikkim">Sikkim</option>
                        <option value="TamilNadu">TamilNadu</option>
                        <option value="Telangana">Telangana</option>
                        <option value="Tripura">Tripura</option>
                        <option value="UttarPradesh">UttarPradesh</option>
                        <option value="Uttarakhand">Uttarakhand</option>
                        <option value="WestBengal">WestBengal</option>

                    </select>
                    <span class="stateAlert alert"></span>

                </div>
                <div class="form-input col-md-6">
                    <label for="username">City</label>
                    <select class="form-control" id="City" name="city">
                        <option value="" disabled selected>Select city</option>
                        <option></option>

                    </select>
                    <span class="cityAlert alert"></span>

                </div>
                
				<div class="form-input col-12">
					<label for="username">Address <span style="color: red;">*</span></label>
					<input type="text" class="form-control" id="address" name="address"
						oninput="checkAddress()" /> <span class="addressAlert alert"></span>
				</div>

				<div class="col-auto submit form_submit_button">
					<button type="submit" id="submit"
						class="submit form_submit_button btn"
						style="background-color: #a4ebf3;" >Submit</button>
				</div>
			</form>

		</div>
		<!-- Login form ends -->

	</div>

	<script src="<c:url value="resources/javascript/script.js" />"></script>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">	</script>
</body>

	<script>
		function advanceCheckEmail(){
			checkEmail();
			let emailAlert = document.getElementById("emailAlert");
			if(emailAlert.innerHTML == ""){
				$.ajax({
				    type : "GET",
				    url : "checkForUniqueGuruEmail",
				    data : {
				        "email" : document.getElementById("email").value,
				    },
				    success: function(data){
				    	if(data == "yes"){
				    		document.getElementById("submit").disabled = false;
				    	}else{
				    		emailAlert.innerHTML = "This email already exist";
				    		
				    		emailAlert.style.color = "#f00";
				    		//console.log(document.getElementById("emailAlert"));
				    		document.getElementById("submit").disabled = true;
				    	}
				        //console.log(data);
				    }
				});
			}
		}
	</script>
</html>