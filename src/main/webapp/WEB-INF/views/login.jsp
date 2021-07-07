<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <title>YogGuru | Login</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css" />">

</head>

<body>
    <div class="container-fluid" >
        <!-- navigation bar starts-->
        <!-- <nav class="navbar navbar-expand-lg "> -->
            
        <div class="top-Heading">
            <span class="navbar-brand sign-nav-header">YogGuru</span>
            <li class="nav-item sign-nav-li" style="float: right;">
                <a class="sign-nav-link" href="index"><svg style="color: #00e5ff;" xmlns="http://www.w3.org/2000/svg"
                        width="36" height="36" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
                        <path
                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                    </svg>
                </a>
            </li>
        </div>
        
        <!-- </nav> -->
        <!-- Navigation bar ends -->

        <!-- Login form starts -->
        <div class="login">
            <div class="header">
                <h1 style="text-align: center;">Sign In</h1>
                <br>
                    <%
                    if(request.getAttribute("msg") != null){
                    	String msg = (String)request.getAttribute("msg");
                    %>
                    <h6 style="text-align: center;color:#f00;"><%=msg%></h6>
                    <%
                    }
                    %>
                    
            </div>
            <form method="post" action="loginCheck" id="login_form" class="form mainform" onsubmit="return submission();">
                <div class="form-input">
                    <label for="username">Email <span style="color: red;">*</span></label>
                    <input type="text" class="form-control" placeholder="Enter your Name" id="email" name="email" oninput="checkEmail()"/>
                    <span class="emailAlert alert"></span>
                </div>
                <div class="form-input">
                    <label for="username">Password <span style="color: red;">*</span></label>
                    <input type="password" class="form-control" placeholder="Enter your Password" id="password" name="pwd" oninput="checkPassword()"/>
                    <span class="passAlert alert"></span>
                </div>
                <div class="col-auto submit form_submit_button">
                    <button type="submit" class="submit form_submit_button btn" id="submit" style="background-color: #a4ebf3;">Submit</button>
                    
                </div>
                <p style="text-align: center;">Don't have an account?<a href="GuruRegistration"> <span style="font-weight: 600; font-size: large; color:#276678 ;">Sign Up</span> </a></p>
            </form>
        </div>
        <!-- Login form ends -->

    </div>
    
    <script src="<c:url value="resources/javascript/script.js" />"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>

</html>