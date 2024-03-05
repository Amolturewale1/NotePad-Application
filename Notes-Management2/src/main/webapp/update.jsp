<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="application.Notes" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Note</title>
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
   		 int userId = (int)request.getAttribute("userId");
        String title = (String) request.getAttribute("title");
        String note=(String)request.getAttribute("note");
        String userName=(String)request.getAttribute("userName");
        String password=(String)request.getAttribute("password");
        String dateTime=(String)request.getAttribute("dateTime");
        
    	%>

<!-- Bootstrap Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="login?username=<%=userName%>&password=<%= password %>">Welcome</a>
</nav>

<!-- Page Content -->
<div class="container mt-4">
    <h2>Update Note</h2>
    <hr>

   

    <!-- Update Note Form -->
    <form action="saveUpdateNote" method="get">
        <input type="hidden" name="userId" value="<%=userId %>" hidden>
		 <input type="hidden" name="userName" value="<%=userName %>" hidden>
		 <input type="hidden" name="password" value="<%=password %>" hidden>
		 <input type="hidden" name="dateTime" value="<%=dateTime %>" hidden>
		 <input type="hidden" name="titleOld" value="<%= title %>" hidden>
        <div class="form-group">
            <label for="noteTitle">Title:</label>
            <input type="text" class="form-control" name="title" id="noteTitle" value="<%= title %>" required>
        </div>

        <div class="form-group">
            <label for="noteContent">Note:</label>
            <textarea class="form-control" name="note" id="noteContent" rows="3" required><%=note %></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form>

    
</div>

<!-- Bootstrap JS and Popper.js (required for Bootstrap components) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
