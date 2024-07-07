<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tap.model.Menu" %>
    <%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="menu.css">
</head>
<body>
<div class="menu-list">
    <% 
    List<Menu> list = (List<Menu>) request.getAttribute("menus");
    if(session.getAttribute("userId") !=null) {
   int userId= (int)session.getAttribute("userId");
   session.setAttribute("userId",userId);
   }
    if (list != null && !list.isEmpty()) {
        for (Menu menu : list) {
    %>
        <div class="menu-item">
            <img class="menu-img" src="<%=menu.getImagePath() %>" alt="<%= menu.getName() %>">
            <div class="menu-content">
                <h4 class="menu-name"><%= menu.getName() %></h4>
                <div class="menu-meta">
                    <span class="menu-rating">&#9733; <%= menu.getRatings() %> </span>
                    <span class="menu-price">&#8377;<%= menu.getPrice() %></span>
                </div>
                <p class="menu-description"><%= menu.getDescription() %></p>
                
                <a href="#" class="menu-more">more</a>
                <form action="CallServletCart" method="post" class="menu-cart">
                   
                    <input type="hidden" name="name" value="<%= menu.getName() %>">
                    <input type="hidden" name="imagepath" value="<%= menu.getImagePath() %>">
                    <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                    <input type="hidden" name="restaurantId" value="<%= menu.getRestaurantId() %>">
                    <input type="hidden" name="ratings" value="<%= menu.getRatings() %>">
                    <input type="hidden" name="price" value="<%= menu.getPrice() %>">
                    <input type="hidden" name="description" value="<%= menu.getDescription() %>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="submit" value="ADD" class="btn-add-cart">
                </form>
            </div>
        </div>
    <% 
        }
    } else {
    %>
        <div class="no-menus">No menus found.</div>
    <% 
    }
    %>
</div>


</body>
</html>