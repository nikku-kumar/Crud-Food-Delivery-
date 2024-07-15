<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert User</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 400px;
        margin: 50px auto;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 40px;
    }
    h1 {
        text-align: center;
        margin-bottom: 30px;
    }
    .login-group {
        margin-bottom: 20px;
    }
    label {
        font-weight: bold;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #ff5700;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    input[type="submit"]:hover {
        background-color: #e65100;
    }
    .button-group {
        display:flex;
        justify-content: center;
        margin-top: 20px;
    }
    .button-group form{
    margin:0 10px;
    }
    .button-group button {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    .button-group button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Enter Your Information Here</h1>
    <form action="CreateServlet" method="post">
        <div class="login-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Enter your name"/>
        </div> 
        <div class="login-group">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" placeholder="Enter your email"/>
        </div> 
        <div class="login-group">
            <label for="age">Age</label>
            <input type="text" id="age" name="age" placeholder="Enter your age"/>
        </div>
        <input type="submit" value="Submit"/>
    </form>
    
    <div class="button-group">
        <form action="delete.jsp" method="get">
        <button type="submit">Delete Data</button>
       </form>
        <form action="retrieve.jsp" method="get">
        <button type="submit">Retrieve Data</button>
       </form>
    </div>
    
    
</div>

</body>
</html>
