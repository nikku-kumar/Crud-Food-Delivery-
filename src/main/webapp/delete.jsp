<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
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
    input[type="text"] {
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
</style>
<script>
    function confirmDelete() {
        return confirm('Are you sure you want to delete this user?');
    }
</script>
</head>
<body>
<div class="container">
    <h1>Delete User</h1>
    <form action="DeleteServlet" method="post" onsubmit="return confirmDelete();">
        <div class="login-group">
            <label for="id">Enter ID to Delete</label>
            <input type="text" id="id" name="id" placeholder="Enter ID"/>
        </div>
        <input type="submit" value="Delete"/>
    </form>
</div>
</body>
</html>
