<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="signin.css">
</head>
<body>
<div class="container">
        <div class="title">Sign In</div>
        <div class="content">
            <form action="Callingvalidservlet1" method="post">
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Username</span>
                        <input type="text" placeholder="username" name="username" required>
         
                        <span class="details">Password</span>
                        <input type="password" placeholder="password" name="password" required>
                    </div>
                </div>
                <div class="button">
                    <input type="submit" value="Login">  
                    <pre>new user ?</pre>
                    <a href="Signup.jsp" class="signup-link">Sign Up</a>
                </div>   
             
            </form>
        </div>
    </div>

</body>
</html>