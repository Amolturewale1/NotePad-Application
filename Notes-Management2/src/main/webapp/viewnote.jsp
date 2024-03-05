<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="application.Notes" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Notes</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add your custom styles here */
        body {
            padding-top: 56px; /* Adjusted for fixed navbar */
        }
    </style>
</head>
<body>
	<%
		Notes n1=(Notes)request.getAttribute("note");
	    int userId=(int)request.getAttribute("userId");
        String userName=(String)request.getAttribute("userName");
        String password=(String)request.getAttribute("password");
	%>

<!-- Bootstrap Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="login?username=<%=userName%>&password=<%= password %>">welcome</a>
</nav>

<!-- Page Content -->
<div class="container mt-4">
    <h2>View Notes</h2>
    <hr>  
    <form action="update"> 
        <!-- Note Display -->
        <input name="userName" type="text" required="required" value="<%=userName %>" hidden readonly="readonly">
        <input name="password" type="text" required="required" value="<%=password%>" hidden readonly="readonly">
        <input name="userId" type="text" required="required" value="<%=userId %>" hidden readonly="readonly">
        <input name="title" type="text" required="required" value="<%=n1.getTitle() %>" hidden readonly="readonly">
         <input name="dateTime" type="text" required="required" value="<%=n1.getDateTime()%>" hidden readonly="readonly">
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">Note Title: <%=n1.getTitle() %></h5>
         	 </div>
         </div>
         <input name="note" type="text" required="required" value="<%=n1.getNote() %>" hidden readonly="readonly">
                <p class="card-text">Content: <%=n1.getNote()%></p>
              <button type="submit" class="btn btn-primary">update</button>
              
      </form>      
        
   
</div>

<!-- Bootstrap JS and Popper.js (required for Bootstrap components) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
