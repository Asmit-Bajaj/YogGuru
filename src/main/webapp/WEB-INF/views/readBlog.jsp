<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.yogguru.model.GuruBlog"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<%
	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1); //prevents caching at the proxy server
%>

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

<title>YogGuru | My Blogs</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<div class="container-fluid">
	<%
		if (session.getAttribute("guruId") != null) {
	%>
	<%@include file="guru_navbar.jsp"%>

	<%
		} else {
	%>
	<%@include file="index_navbar.jsp"%>
	<%
		}
	%>
	<%
		GuruBlog blog = (GuruBlog) request.getAttribute("blog");
		request.removeAttribute("blog");
		
		List<GuruBlog> allMyBlogs = (ArrayList)request.getAttribute("allMyBlogs");
		request.removeAttribute("allMyBlogs");
	%>

	<div class="readBlogHeader"
		style="background: linear-gradient(to right,rgba(0,0,0,1),rgba(0,0,0,0.5)),
	url('<c:url value="/resources/images/blog-3.jpeg" />');">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-md-12">
					<h1>YogGuru Blogs</h1>
					<h3>One Stop For All Yoga Blogs</h3>
				</div>
			</div>
		</div>

	</div>
	<br>
	<br>


	<div class="container">
		<div class="row">
			<div class="col-md-8 text-center">
				<h3><%=blog.getTitle()%></h3>
				<br> <br>
				<%
					if (blog.getThumbnail() != null) {
						String[] split_names = blog.getThumbnail().split("blog");

						String file_name = "/resources/blog/" + split_names[split_names.length - 1].substring(1);
				%>
				<img src="<c:url value="<%=file_name%>" />" style="width: 70%;">
				<%
					} else {
				%>
				<img src="<c:url value="/resources/images/Workshop.jpg" />"
					style="width: 70%;">
				<%
					}
				%>
				<br> <br>

				<div style="white-space: pre-wrap;font-size: 1.1rem;font-style: oblique;"><%=blog.getDesc()%></div>

				<br> <br>
				<h4>Related Images</h4>
				<br>
				<div class="row">
					<%
						List<String> imgs = blog.getImgs();
						String[] split_names;
						String file_name;

						for (int i = 0; i < imgs.size(); i++) {
							split_names = imgs.get(i).split("blog");
							//out.println(split_names);

							file_name = "/resources/blog/" + split_names[split_names.length - 1].substring(1);
							//file_name = "";
					%>
					<div class="col-md-6 mb-3">
						<img src="<c:url  value="<%=file_name%>" />" style="width: 100%">
					</div>


					<%
						}
					%>

				</div>
			</div>

			<div class="col-md-4 text-center" style="padding: 3%;">
				<h3>Recent Articles</h3>
				<br> <br> 
				<%
					for(GuruBlog blog1 : allMyBlogs){
						if(blog1.getId() != blog.getId()){
							if(session.getAttribute("guruId") != null){
				%>
					<a href="/YogGuru/Guru/ReadBlog?id=<%=blog1.getId()%>"><h6><%=blog1.getTitle().substring(0,Integer.min(100, blog1.getTitle().length()))%>....</h6></a> <br>
				<%
							}else{
				%>
				<a href="/YogGuru/User/ReadBlog?id=<%=blog1.getId()%>"><h6><%=blog1.getTitle().substring(0,Integer.min(100, blog1.getTitle().length()))%>....</h6></a> <br>
				<%
							}
						}
					}
				%>
				
				
				
			</div>
		</div>
		<br> <br>
		
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