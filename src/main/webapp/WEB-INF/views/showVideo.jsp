<%@page import="com.yogguru.model.VideoModel"%>
<%@page import="java.util.List"%>
<%@page import="com.yogguru.model.GuruBlog"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate");  //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", -1); //prevents caching at the proxy server
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

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

<title>YogGuru | My Videos</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<div class="container-fluid">
<%
	if(session.getAttribute("guruId") != null){
%>
	<%@include file="guru_navbar.jsp"%>

<%
	}else{
%>
	<%@include file="index_navbar.jsp"%>
<%
	}
%>
	<%
		VideoModel video = (VideoModel)request.getAttribute("video");
		request.removeAttribute("video");
	%>

	<div class="readBlogHeader" style="background: linear-gradient(to right,rgba(0,0,0,1),rgba(0,0,0,0.5)),
	url('<c:url value="/resources/images/video-1.jpeg" />');">
	<div class="container h-100">
		<div class="row h-100 align-items-center">
			<div class="col-md-12">
				<h1>YogGuru Video</h1>
				<h3>One Stop For All Yoga Videos</h3>
			</div>
		</div>
	</div>

	</div>
	<br>
	<br>
	<!-- Main Video Page -->
	
	<div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2><b><%=video.getTitle()%></b></h2>
                    <br><br><br>
                    <div class="row">
                        
                        <div class="col-md-12">
                        <%
                        	String[] split_names = video.getVideo().split("videos");
                        	String file_name = "/resources/videos/"+split_names[1].substring(1);
                        %>
                            <video src="<c:url value="<%=file_name%>" />" style="width:70%;" controls> </video> 
                        </div>
                    </div>
                    <br><br>
                    <div class="row">
                        <div class="col-md-12" style="font-size: 1.1rem;font-style: oblique;white-space: pre-wrap;"><%=video.getDesc()%></div>
                    </div>
                    <br><br>
                </div>
            </div>
            <br><br>
           
           
        </div>
     <%
			if(session.getAttribute("guruId") != null){
		%>
		<%@include file="guru_footer.jsp" %>
		<%
			}else{
		%>
		<%@include file="index_footer.jsp" %>
		<%
			}
		%> 
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