<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>STUDENT DATABASE MANAGEMENT SYSTEM</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
            <a class="navbar-brand m-1" href="#">STUDENT DATABASE MANAGEMENT SYSTEM</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/students">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/students">Student Details</a></li>
                </ul>
            </div>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            </ul>
        </nav>

        <!-- Search Bar Form -->
        <form action="/search" method="GET" class="mb-3">
            <label for="searchInput">Search Student:</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Enter Student Name:" required="required"/>
            <button type="submit" class="btn btn-primary">Search</button>
            <a href="/students" class="btn btn-secondary">Get All Students</a>
        </form>
        
        

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Blood Group</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${stud}" var="i">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.name}</td>
                        <td>${i.phonenumber}</td>
                        <td>${i.address}</td>
                        <td>${i.bg}</td>
                        <td><a href="/delete-student?id=${i.id}" class="btn btn-warning">Delete</a></td>
                        <td><a href="/update-student?id=${i.id}" class="btn btn-success">Update</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/add-student" class="btn btn-success">Add Student</a>
    </div>
</body>
</html>
