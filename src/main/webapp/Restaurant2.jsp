<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.daoimpl.RestaurantDaoI" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Restaurant.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
<section class="menu">
    <div class="nav">
        <div class="logo"><h1>Food<b>ie</b></h1></div>
        <ul>
            <li>
  <form action="searchServlet" method="get">
    <input type="text" name="search" placeholder="Search...">
    <button type="submit">Search</button>
  </form>
</li>
            <li><a href="RestaurantAllServlet">Restaurant</a></li>
            <li><a href="menuallservlet">Menu</a></li>
            <li><a href="callservlethistory">OrderHistory</a></li>
            <li><a href="CallingServlet">Log Out</a></li>
            <li><a href="cart.jsp"><i class="fas fa-shopping-cart cart-logo">Cart</i> </a></li>
        </ul>
     <%--   <div class="input-group"> <a href="login.jsp">
            <input class="signin" type="submit" value="Sign In" name="singin">
            </a>
         <a href="Signup.jsp">
            <input class="signUp" type="submit" value="Sign Up" name="singup">
            </a>
        </div>  --%>
    </div>    
</section>   

 <main>
        <section class="hero">
            <h1><%= request.getAttribute("name") %> your favourite item is here , order now.</h1>
            
        </section>
<div class="scrollable-wrapper">
   <div class="items">
   
   <div >  <a href="menuservletsearch?s=pizza">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029856/PC_Creative%20refresh/3D_bau/banners_new/Pizza.png">
  </a>
   </div>
   <div > <a href="menuservletsearch?s=biryani">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667625/PC_Creative%20refresh/Biryani_2.png">
     </a>   
</div>
   
   <div ><a href="menuservletsearch?s=burger">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029845/PC_Creative%20refresh/3D_bau/banners_new/Burger.png">
   </a>
</div>
   <div ><a href="menuservletsearch?s=roll">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029858/PC_Creative%20refresh/3D_bau/banners_new/Rolls.png">
   </a>
</div>
   <div >
   <a href="menuservletsearch?s=cake">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029845/PC_Creative%20refresh/3D_bau/banners_new/Cakes.png">
   </a>
</div>
   <div >
   <a href="menuservletsearch?s=poori">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029855/PC_Creative%20refresh/3D_bau/banners_new/Poori.png">
</a>   
</div>
   <div >
   <a href="menuservletsearch?s=idli">
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029846/PC_Creative%20refresh/3D_bau/banners_new/Idli.png">
  </a>
 </div>
   <div >
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029850/PC_Creative%20refresh/3D_bau/banners_new/Dosa.png">
   </div>
   <div >
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667625/PC_Creative%20refresh/North_Indian_4.png">
   </div>
   <div >
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029859/PC_Creative%20refresh/3D_bau/banners_new/Salad.png">
   </div>
   <div >
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029844/PC_Creative%20refresh/3D_bau/banners_new/Chole_Bature.png">
   </div>
<div >
   <img class="item-img" src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667626/PC_Creative%20refresh/South_Indian_4.png">
   </div>
</div>
</div>

<h1>welcome <%= request.getAttribute("name")  %> Your favourite restaurant is here</h1>
   
<div class="restaurant container">
   <% 
       
   List<Restaurant> restaurants =(List<Restaurant>)request.getAttribute("restaurantList");
   int userId=(int)request.getAttribute("userId");
   session.setAttribute("userId", userId);
   for(Restaurant restaurant:restaurants){  
   
   %>
   <div class="image-container">
      <a href="menuServlet?restaurantId=<%=restaurant.getRestaurantId() %>">
      <img class="restaurant-img" src="<%=restaurant.getImagePath() %>" alt="img">
      </a>
    <h4><%= restaurant.getName() %></h4>
        <p>&#9733 <%= restaurant.getRatings() %></p>
        <p> <%= restaurant.getCuisinType() %></p>
        <p>ETA: <%= restaurant.getEta() %>min</p>
   </div>
   
  <% }
  %>
   </div>
    

</body>
</html>