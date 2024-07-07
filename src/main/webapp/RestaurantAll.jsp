<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.daoimpl.RestaurantDaoI" %>
<%@ page import="javax.servlet.http.HttpSession" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Restaurant.css">
</head>
<body>
<section class="menu">
    <div class="nav">
        <div class="logo"><h1>Food<b>ie</b></h1></div>
        <ul>
            <li><a href="CallingServlet" class="active">Home</a></li>
            <li><a href="RestaurantAllServlet">Restaurant</a></li>
            <li><a href="menuallservlet">Menu</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="#">Service</a></li>
        </ul>
      
    </div>    
</section>  
<div class="restaurant container">
   <% 
       
   List<Restaurant> restaurants =(List<Restaurant>)request.getAttribute("restaurantList");
   
   for(Restaurant restaurant:restaurants){  
   
   %>
   <div class="image-container">
      <a href="menuServlet?restaurantId=<%=restaurant.getRestaurantId() %>">
      <img class="restaurant-img" src="<%=restaurant.getImagePath() %>" alt="img">
      </a>
    <h4><%= restaurant.getName() %></h4>
        <p>&#9733 <%= restaurant.getRatings() %></p>
        <p> <%= restaurant.getCuisinType() %></p>
        <p>ETA: <%= restaurant.getEta() %></p>
   </div>
   
  <% }
  %>
   </div>
    
</body>
</html>