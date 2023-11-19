<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Student</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
        <a class="navbar-brand m-1" href="#">STUDENT DATABASE MANAGEMENT SYSTEM</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/students">Student Details</a></li>
            </ul>
        </div>
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
        </ul>
    </nav>
    
    <div class="container">
        <h1>Add Student</h1>
        <form:form method="POST" modelAttribute="stud">
        	<div class="mb-3">
                <label for="name" class="form-label">ID:</label>
                <form:input type="text" id="id" name="id" path="id" class="form-control" required="required"/>
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <form:input type="text" id="name" name="name" path="name" class="form-control" required="required"/>
            </div>
            
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number:</label>
                <form:input type="text" id="phonenumber" name="phonenumber" path="phonenumber" class="form-control" required="required"/>
            </div>
            
            <div class="mb-3">
                <label for="address" class="form-label">Address:</label>
                <form:input type="text" id="address" name="address" path="address" class="form-control" required="required"/>
            </div>
            
            <div class="mb-3">
                <label for="bg" class="form-label">Blood Group:</label>
                <form:input type="text" id="bg" name="bg" path="bg" class="form-control" required="required"/>
            </div>
            
            <button type="submit" class="btn btn-success">Update Student</button>
        </form:form>
    </div>
    
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
