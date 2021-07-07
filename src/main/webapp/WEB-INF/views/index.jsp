<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">


    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,300&display=swap" rel="stylesheet">

    <title>YogGuru | Home</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">

</head>

<body>

   

<div class="container-fluid">
 <!-- NavBar -->
 
 <%@include file="index_navbar.jsp" %>
			<!-- Top image -->
        <div class="content">
            <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active home-index-img-container" style="text-align: center; align-content: center;">
                        <img class="d-block w-100" src="<c:url value="resources/images/main-1.jpg" />" alt="First slide">

                        <div class="carousel-caption home-img-content" style="display: block;  bottom:35%; text-align: center; ">
                            <h1>Let's make our health better</h1>
                         </div>
                    </div>
                </div>
            </div>

            <!-- About Us Section starts-->
            
            <div class="card" style="border:none">
                <div class="row row-home about-YogGuru-row" style="float: right;">
                    <div class="col-sm-4" style="text-align: center;">
                             <h1 class="about-yogGuru-header section-1-header">About<br> YogGuru</h1>
                        
                    </div>
                    <div class="col-sm-4">
                        <div class="img-content" style="display: block; text-align: center;">
                            <svg xmlns="http://www.w3.org/2000/svg" style="color: #a4ebf3; margin: 2% 30% 2% 30%;"
                                width="76" height="76" fill="currentColor" class="bi bi-brightness-alt-high-fill"
                                viewBox="0 0 16 16">
                                <path
                                    d="M8 3a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 3zm8 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zm-13.5.5a.5.5 0 0 0 0-1h-2a.5.5 0 0 0 0 1h2zm11.157-6.157a.5.5 0 0 1 0 .707l-1.414 1.414a.5.5 0 1 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm-9.9 2.121a.5.5 0 0 0 .707-.707L3.05 5.343a.5.5 0 1 0-.707.707l1.414 1.414zM8 7a4 4 0 0 0-4 4 .5.5 0 0 0 .5.5h7a.5.5 0 0 0 .5-.5 4 4 0 0 0-4-4z" />
                            </svg>
                            <h4>Inspire Everyone</h4>
                            <p>If you're an expert in yoga. So, be the one who inspire everyone</p>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="img-content" style="display: block; text-align: center;">
                            <svg style="margin:2% 30% 2% 30%; color: #a4ebf3; " xmlns="http://www.w3.org/2000/svg"
                                width="76" height="76" fill="currentColor" class="bi bi-rainbow" viewBox="0 0 16 16">
                                <path
                                    d="M8 4.5a7 7 0 0 0-7 7 .5.5 0 0 1-1 0 8 8 0 1 1 16 0 .5.5 0 0 1-1 0 7 7 0 0 0-7-7zm0 2a5 5 0 0 0-5 5 .5.5 0 0 1-1 0 6 6 0 1 1 12 0 .5.5 0 0 1-1 0 5 5 0 0 0-5-5zm0 2a3 3 0 0 0-3 3 .5.5 0 0 1-1 0 4 4 0 1 1 8 0 .5.5 0 0 1-1 0 3 3 0 0 0-3-3zm0 2a1 1 0 0 0-1 1 .5.5 0 0 1-1 0 2 2 0 1 1 4 0 .5.5 0 0 1-1 0 1 1 0 0 0-1-1z" />
                            </svg>
                            <h4>Expertised Learning</h4>
                            <p>Gain Strength, balance, flexibility and many more health benifits.
                            </p>
                        </div>
                    </div>

                    <div class="col-sm-8">
                        <p style="color:#03535c; text-align: center; font-size: 1.1rem;">Yoga is a balanced state of the body, mind,
                            emotions, thoughts and behaviour. We are
                            excited in the situation of pleasure and we become sad when it is a negative
                            situation. Yoga is to maintain equilibrium of the mind in any situation. This
                            equanimity of mind is the ultimate objective of yoga.

                        </p>
                    </div>
                </div>
            </div>
            <!-- About Us Section ends -->



            <!-- section-1 whatWehave -->
            <div class="index-main">
                <div class="index-header text-center">

                    <h1 class="home-whatWehave-header">What We Have</h1>

                </div>
            </div>

            <div class="index-home card-group">
                <div class="card index-card">
                    <img class="card-img-top" src="<c:url value="resources/images/blogs.jpg" />" alt="Card image cap">
                    <div class="card-img-overlay card-img-content">
                        <h5 class="card-title">Blogs</h5>
                    </div>
                </div>

                <div class="card index-card ">
                    <img class="card-img-top" src="<c:url value="resources/images/LiveClass.jpg" />" alt="Card image cap">
                    <div class="card-img-overlay card-img-content">
                        <h5 class="card-title">LiveClass</h5>
                    </div>
                </div>

                <div class="card index-card">
                    <img class="card-img-top" src="<c:url value="resources/images/Workshop.jpg" />" alt="Card image cap">
                    <div class="card-img-overlay card-img-content">
                        <h5 class="card-title">Workshop and Video</h5>
                        </p>
                    </div>
                </div>
            </div>


            <!-- section-1 whatWehave end -->


            <!-- Our footer -->
            <!-- <div class="container-fluid"> -->
            
        </div>
        
        <%@include file="index_footer.jsp" %>
    </div>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>