<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="com.yogguru.model.GuruModel"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<%
	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1); //prevents caching at the proxy server
%>
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
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">


<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,300&display=swap"
	rel="stylesheet">

<title>YogGuru | Query</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>


</head>
<body>

	<%
		if (session.getAttribute("addQueryMsg") != null) {
	%>
	<div class="modal fade " id="AddQueryModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<%=(String) session.getAttribute("addQueryMsg")%>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<script>
		let myModal = new bootstrap.Modal(document
				.getElementById("AddQueryModal"), {});
		myModal.show();
	</script>

	<%
		session.removeAttribute("addQueryMsg");
		}
	%>
	
	<%
		List<GuruModel> gurus = (ArrayList)request.getAttribute("allGurus");
		request.removeAttribute("allGurus");
	%>
	<div class="container-fluid">

		<%@include file="index_navbar.jsp"%>

		<!-- Registration form starts -->
		<div class="login">
			<div class="header">
				<h1 style="text-align: center;">Welcome to Chat Box</h1>
				<h6 style="text-align: center;">Feel free to ask any query
					or chat with the instructors</h6>
				<h6 style="text-align: center;">Note : Please Provide A Valid Email address as it will be used to send the response back to you</h6>
			</div>

			<br>
			<br>

			<form id="form" method="post" action="SubmitChatForm"
				class="form mainform row justify-content-md-center"
				onsubmit="return submission()">

				<div class="form-input col-md-12">
                    <label for="username">Your Name <span style="color: red;">*</span></label>
                    <input type="text" class="form-control" style="outline: none !important;" id="name"
                        oninput="checkName()" name="name"/>
                    <span class="nameAlert alert"></span>
                </div>
                
                <div class="form-input col-md-12">
                    <label for="username">Your Email <span style="color: red;">*</span></label>
                    <input type="text" class="form-control" id="email" oninput="checkEmail()" name="email_id"/>
                    <span class="emailAlert alert"></span>
                </div>


				<div class="form-input col-12">
					<label for="username">Type Your Text Chat Here <span
						style="color: red;">*</span></label>
					<textarea class="form-control" name="query" id="blog_desc" cols="30"
						rows="10" required></textarea>


				</div>

				<div class="form-input col-md-12">
					<label for="username">Select The Instructor </label> 
					<select
						class="form-control"  name="guru" required>
						<%
							for(GuruModel guru : gurus){
						%>
						<option value="<%=guru.getId()%>"><%=guru.getName()%></option>
						<%
							}
						%>
						
					</select>

				</div>

				<div class="col-auto submit form_submit_button">
					<button type="submit" id="submit"
						class="submit form_submit_button btn"
						style="background-color: #a4ebf3;">Submit</button>
				</div>
			</form>

		</div>
		<!-- registration form ends -->
		<%@include file="index_footer.jsp"%>

	</div>




	<script src="<c:url value="/resources/javascript/script.js" />"></script>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>