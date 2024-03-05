<%@page import="application.Notes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add your custom styles here */
        body {
            padding-top: 56px; /* Adjusted for fixed navbar */
        }
        .custom-row {
      border: 1px solid #ccc; /* Border for the row */
      padding: 10px; /* Adjust padding as needed */
      margin-bottom: 15px; /* Adjust margin as needed */
    }

    
    .delete {
            opacity: 0; /* Initially hide the button */
            transition: opacity 0.3s ease-in-out; /* Add a smooth transition effect */
        }
    .custom-row:hover .delete {
      opacity: 1; /* Show the button on hover */
    }
    
    

    
    </style>
</head>
<body>
	<%	
	List<Notes> noteList=(List<Notes>)request.getAttribute("noteList");
    String username=(String)request.getAttribute("username");
    String password=(String)request.getAttribute("password");
    int userId=(int)request.getAttribute("userId");
            
	%>
<!-- Bootstrap Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   <a class="navbar-brand" href="login?username=<%= username %>&password=<%= password %>">Welcome</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" >Name : <%= username %>	<span class="sr-only"></span></a>
            </li>
        </ul>
         <ul class="navbar-nav">
            <li class="nav-item">
                <form class="form-inline" action="search">
                	<input type="text" name="userName" value="<%= username %>" hidden readonly="readonly">
     				<input type="text" name="password" value="<%= password %>" hidden readonly="readonly">
                    <input class="form-control mr-sm-2" name="searchTitle" style="width:800px" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
                </form>
            </li>
        </ul>
        
        <ul class="navbar-nav">
           
            <li class="nav-item">
                <a class="nav-link" href="index.html">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<%! String note = null ; %>

<!-- Page Content -->
<div class=" m-4" >
	  
    <!-- Add Note Button -->
    <a href="forword?username=<%=username%>&password=<%= password %>" ><button type="button" class="btn btn-primary mb-2">Add Note</button></a>
	<hr>
	<div class="row " align="center">
	 		<div class="col"> <h5>Notes</h5> </div>
	 </div>
	 <hr>
	 <div class="m-4">
  <div class="row custom-row" align="center">
    <div class="col-md-3">Title</div>
    <div class="col-md-3">Date & Time</div>
    <div class="col-md-3">Content</div>
    <div class="col-md-3 "></div>
  </div>

  <!-- Add more rows if needed -->

</div>
	<%for(Notes n1:noteList){ %>
    <!-- Note Display -->
   <div class="m-4">
           <a style="color:black" href="viewNote?username=<%= username %>&title=<%= java.net.URLEncoder.encode(n1.getTitle(), "UTF-8") %>&password=<%= java.net.URLEncoder.encode(password, "UTF-8") %>">
    
  <div class="row custom-row">
  
    <div class="col-md-3"> <h5 class="card-text ">Note Title: <%= n1.getTitle() %></h5> </div>
    <div class="col-md-3"> <p class="card-text ">Date & Time: <%=n1.getDateTime() %> </p></div>
    <div class="col-md-3 ml-3"><p class="card-text ">
                    	<% 
                    	 note = n1.getNote();
                    		if(note.length() >30 ){
                    			for(int i =0 ; i<20 ; i++)
                    			{
                    				out.print(note.charAt(i));
                    			}
                    			out.print(" ..... ");
                    		}else{
                    			out.print(note);
                    		}
                    		%>
                    
                     </p> </div>
                     
     <form action="update">
     		<input type="text" name="userName" value="<%= username %>" hidden readonly="readonly">
     		<input type="text" name="userId" value="<%= userId  %>" hidden readonly="readonly">
     		<input type="text" name="password" value="<%= password %>" hidden readonly="readonly">
     		<input type="text" name="title" value="<%= n1.getTitle() %>" hidden readonly="readonly">
     		<input type="text" name="note" value="<%= n1.getNote() %>" hidden readonly="readonly">
    		 <button class="btn btn-primary delete " type="submit"> Edit</button>
       </form>
                   
     <form action="delete">
     		<input type="text" name="username" value="<%= username %>" hidden readonly="readonly">
     		<input type="text" name="password" value="<%= password %>" hidden readonly="readonly">
     		<input type="text" name="title" value="<%= n1.getTitle() %>" hidden readonly="readonly">
    		 <button class="btn btn-danger delete ml-2" type="submit"> Delete</button>
       </form>
          
       
                    
  </div>
  </a>
    
  <!-- Add more rows if needed -->

</div>
    <%} %>
    
</div>

<!-- Bootstrap JS and Popper.js (required for Bootstrap components) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
