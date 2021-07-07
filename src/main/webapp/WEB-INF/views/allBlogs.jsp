<%@page import="java.util.ArrayList"%>
<%@page import="com.yogguru.model.GuruBlog"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<%
	response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate");  //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", -1); //prevents caching at the proxy server
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

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        
<title>YogGuru | My Blogs</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
<div class="container-fluid">
<%@include file="index_navbar.jsp"%>

	<%
		List<GuruBlog> allBlogs = (ArrayList<GuruBlog>)request.getAttribute("allBlogs");
		//out.print(allBlogs);
	%>
	
	<div class="header">
		<h3 style="text-align: center;">Blogs</h3>
	</div>

	<div class="container">
		<br>

		<div class="row">
			<div class="col-md-6">
				<div>
					<input class="form-control mr-sm-2 search" type="search"
						placeholder="Search" aria-label="Search" oninput="search(this.value);">
				</div>
			</div>

		</div>

		<br><br><br>


		<div class="row text-center" id="mainBlogDiv">
			<%
				for (GuruBlog blog : allBlogs) {
			%>
			<div class="col-12 mb-2">
				<div class="card mb-4 blog-card">
					<div class="row no-gutters">
						<div class="col-md-4">
							<%
								if (blog.getThumbnail() != null) {

										String[] split_names = blog.getThumbnail().split("blog");

										String file_name = "/resources/blog/" + split_names[split_names.length - 1].substring(1);
										//out.print(file_name);
							%>
							<img src="<c:url value="<%=file_name%>" />" class="card-img"
								alt="..." style="max-height: 200px;">
							<%
								} else {
							%>
							<img src="<c:url value="/resources/images/Workshop.jpg" />"
								class="card-img" alt="..." style="max-height: 200px;">
							<%
								}
							%>

						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><%=blog.getTitle()%></h5>
								<p class="card-text">
									<%
										if (blog.getDesc().length() > 150) {
									%>
									<%=blog.getDesc().substring(0, 149)%>......
									<%
										} else {
									%>
									<%=blog.getDesc()%>......
									<%
										}
									%>
								</p>
								<p class="card-text">
									<div class="row">
										<div class="col md-12">
										<a href="/YogGuru/User/ReadBlog?id=<%=blog.getId()%>">
											<button id="myBtn" class="submit form_submit_button btn"
											style="background-color: #a4ebf3;">Read Full Blog</button>
										</a>
										</div>
										
									</div>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>

	

		</div>

	</div>
	<%@include file="index_footer.jsp" %>
</div>

	<script src="<c:url value= "/resources/javascript/script.js" />"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
		
	<script>
		function search(search_text) {
			search_text = search_text.toUpperCase();
			let ele = document.getElementById("mainBlogDiv");
			
			let div = ele.getElementsByClassName("col-12");
			let card,value;
			
			for(let i=0;i<div.length;i++){
				card = div[i].getElementsByClassName("card-title")[0];
				//console.log(card);
				value = card.textContent || card.innerText;
				if(value.toUpperCase().indexOf(search_text) > -1){
					div[i].style.display = "";
				}else{
					div[i].style.display = "none";
				}
			}
		}
		
	</script>
	
	
</body>
</html>