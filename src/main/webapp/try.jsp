<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f2f2f2;
  }

  header {
    background-color: #333;
    color: #fff;
    padding: 20px;
    text-align: center;
  }

  nav {
    background-color: #444;
    color: #fff;
    padding: 10px;
  }

  nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    text-align: center;
  }

  nav ul li {
    display: inline;
      margin-right: 20px;
  }

  nav ul li a {
    color: #fff;
    text-decoration: none;
    font-weight: bold;
  }

  nav ul li a:hover {
    color: #ff6600;
  }

  .container {
    max-width: 480px;
    margin: 20px auto;
    padding: 0 20px;
  }

  .menu-item {
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
    overflow: hidden;
  }

  .menu-item img {
    width: 100%;
    height: auto;
  }

  .menu-item-details {
    padding: 20px;
  }
      .menu-item-details h2 {
    margin-top: 0;
  }

  .menu-item-details p {
    margin-bottom: 0;
  }
</style>
     
</head>
<body>
  <div class="container">
  <div class="menu-item">
    <img src="https://via.placeholder.com/300" alt="Item 1">
    <div class="menu-item-details">
      <h2>burger</h2>
      <p>Description of burger </p>
    </div>
  </div>

  <div class="menu-item">
    <img src="https://via.placeholder.com/300" alt="Item 2">
    <div class="menu-item-details">
      <h2>pizza</h2>
      <p>Description of pizza</p>
    </div>
  </div>

  <div class="menu-item">
    <img src="https://via.placeholder.com/300" alt="Item 3">
    <div class="menu-item-details">
      <h2>pasta</h2>
      <p>Description of Pasta</p>
    </div>
  </div>
</div>
  
</body>
</html>