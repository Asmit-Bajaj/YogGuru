<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <title>YogGuru | Email Error</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css" />">
</head>
<body style="background-color: #a4ebf3;">
    <div class="container-fluid register_body">
        

        <div class="jumbotron validation_error">
            <img style=" max-width: 800px;" src="<c:url value="resources/images/validation_error.png" />" alt="Error">
            <h1 class="display-4" style="font-family: 'Merriweather', serif;">Error!!!</h2><br>
            <h6 class="display-4 validate_error_display">This link has already expired or broken.</h6>
            <!-- <hr class="my-4"> -->
            <p class="lead">
              <a class="register_success_btn btn btn-primary btn-lg" href="index" role="button">Click here to go back</a>
            </p>
         </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>

</html>