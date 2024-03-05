<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Note</title>
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
		String username=(String)request.getAttribute("username");
	    String password=(String)request.getAttribute("password");
	%>

<!-- Bootstrap Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="# ">Welcome</a>
</nav>

<!-- Page Content -->
<div class="container mt-4">
    <h2>Add Note</h2>
    <!-- Note Form -->
    <form action="addNote">
        <div class="form-group">
        	<input type="text" name="username" hidden="" required="required" value="<%=username %>">
        	<input type="text" name="password" hidden="" required="required" value="<%=password %>">
            <label for="noteTitle">Title:</label>
            <input type="text" class="form-control" name="title" id="noteTitle" placeholder="Enter title" required>
        </div>
        <div class="form-group">
            <label for="noteContent">Note:</label>
            <textarea class="form-control" name="note" id="noteContent" rows="3" placeholder="Enter your note" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>


</body>
</html>
