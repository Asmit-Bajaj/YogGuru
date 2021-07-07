<%@page import="com.yogguru.model.VideoModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate");  //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", -1); //prevents caching at the proxy server
%>


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

    <title>YogGuru | Edit Video</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
		
	
</head>
<body>

<%
	if(session.getAttribute("editVideoMsg") != null){
%>
<div class="modal fade " id="EditVideoModal" data-bs-backdrop="static" data-bs-keyboard="false" 
tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
        <%=(String)session.getAttribute("editVideoMsg")%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script>
let myModal = new bootstrap.Modal(document.getElementById("EditVideoModal"), {});
	myModal.show();
</script>

<%
		session.removeAttribute("editVideoMsg");
	}
%>

<%
	VideoModel video = (VideoModel)request.getAttribute("video");
%>
	<div class="container-fluid">
			
        <%@include file="guru_navbar.jsp" %>

        <!-- Registration form starts -->
        <div class="login">
            <div class="header">
                <h1 style="text-align: center;">Edit Video</h1>
            </div>

            <form id="form" method="post" action="EditVideoSubmit"
                class="form mainform row justify-content-md-center" onsubmit="return submission()"
                 enctype="multipart/form-data" >
                 
				<div class="form-input col-md-12">
				
                    <label for="thumbnailChg">Do You Want To Change The Thumbnail ? </label>
                    <select class="form-control" id="thumbnailChg" onchange="thumbnailChgFunc(this.value);" name="thumbnailChg">
                        <option value="0">No</option>
                        <option value="1">Yes</option>
                    </select>
                    
                    <span class="stateAlert alert"></span>    
                </div>
                <br><br>
                <div class="form-input img-container  col-md-6 " style="display: none;" id="thumbnailDiv">
                    <img id="image" src="" alt="" style="height:200px; width:200px; ">
                    
                    <label for="file" class="imageLabel">
                        Thumbnail
                    </label>
                    <input type="file" id="file" name="videoThumbnail" style="display: none;" onchange="return checkImage()" />
                </div>

                <div class="form-input col-md-12">
                    <label for="username">Title <span style="color: red;">*</span></label>
                    <input type="text" name="title" class="form-control" style="outline: none !important;" id="blog_title"
                        oninput="checkBlogTitle()" maxlength="200" value="<%=video.getTitle()%>" />
                    <span class="nameAlert alert"></span>
                </div>
                

                <div class="form-input col-12">
                    <label for="username">Description <span style="color: red;">*</span></label>
                    <textarea class="form-control" name="desc" id="blog_desc" cols="30" rows="10"
                    oninput="checkBlogDesc()"><%=video.getDesc()%></textarea>
                    
                    <span class="addressAlert alert"></span>
                </div>
                
                <div class="form-input col-md-12">
				
                    <label for="videoChg">Do You Want To Change The Video File ? </label>
                    <select class="form-control" id="videoChg" onchange="videoChgFunc(this.value);" name="videoChg">
                        <option value="0">No</option>
                        <option value="1">Yes</option>
                    </select>
                    
                    <span class="stateAlert alert"></span>    
                </div>

                <div class="form-input col-12" style="display:none;" id="videoDiv">
                    <label for="exampleFormControlFile1">Choose Video <span style="color: red;">*</span> : </label>
                    <input type="file" class="form-control-file" id="videofile" name="mainVideo" 
                    onchange="return checkVideo()">
                </div>
                
                <input type="hidden" name="id" value="<%=video.getId()%>">

                <div class="col-auto submit form_submit_button">
                    <button type="submit" id="submit" class="submit form_submit_button btn"
                        style="background-color: #a4ebf3;">Save Changes</button>
                </div>
                
                
            </form>

        </div>
        <!-- registration form ends -->
	<%@include file="guru_footer.jsp" %>
    </div>
	
	
	
	<script src="<c:url value="/resources/javascript/script.js" />"></script>
	
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
<script>
		function thumbnailChgFunc(value){
			if(value == "1"){
				document.getElementById("thumbnailDiv").style.display = "";
			}else{
				document.getElementById("thumbnailDiv").style.display = "none";
			}
		}
		
		function videoChgFunc(value){
			if(value == "1"){
				document.getElementById("videoDiv").style.display = "";
				document.getElementById("videofile").setAttribute("required","true");
			}else{
				document.getElementById("videofile").removeAttribute("required");
				document.getElementById("videoDiv").style.display = "none";
			}
		}
</script>
</html>