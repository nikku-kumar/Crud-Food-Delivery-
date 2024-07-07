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
        List<Menu> list = (List<Menu>) request.getAttribute("menulist");
        if (list != null && !list.isEmpty()) {
            for (Menu menu : list) {
        %>
            <div class="menu-item">
                <img class="menu-img" src="<%=menu.getImagePath() %>" alt="Menu Image">
                <div class="menu-details">
                    <h4 class="menu-name"><%= menu.getName() %></h4>
                    <div class="menu-meta">
                        <p class="menu-rating">&#9733; <%= menu.getRatings() %></p>
                        <p class="menu-price">&#8377; <%= menu.getPrice() %></p>
                    </div>
                    <div class="menu-cart">
                    <p class="menu-description"><%= menu.getDescription() %></p>
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