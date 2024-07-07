<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.daoimpl.RestaurantDaoI" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="Restaurant.css">
</head>
<body>
 
 <header class="menu">
        <nav class="nav">
            <div class="logo"><h1>Food<b>ie</b></h1></div>
            <ul>
             <li>  <form action="searchServlet" method="get">
    <input type="text" name="search" placeholder="Search...">
    <button type="submit">Search</button>
  </form>
</li>
                <li><a href="RestaurantAllServlet">Restaurants</a></li>
                <li><a href="menuallservlet">Menu</a></li>
                <li><a href="#">Help</a></li>
                <li><a href="#">Services</a></li>
            </ul>
            <div class="input-group">
                <a href="login.jsp" class="signin">Sign In</a>
                <a href="Signup.jsp" class="signUp">Sign Up</a>
            </div>
        </nav>
        
    </header>

    <main>
        <section class="hero">
            <h1>Your favourite item is here , order now.</h1>
            
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

<h1>Your favourite restaurant is here</h1>
   
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
        <p>ETA: <%= restaurant.getEta() %>min</p>
   </div>
   
  <% }
  %>
   </div>
    </main>
     <!-- Footer Section -->
        <footer class="footer">
            <div class="footer-content">
                <div class="points">
                    COMPANY
                    <ul class="footer-ul">
                        <li class="footer-li"><a href="#">About us</a></li>
                        <li class="footer-li"><a href="#">Team</a></li>
                        <li class="footer-li"><a href="#">Careers</a></li>
                        <li class="footer-li"><a href="#">Foodie Blog</a></li>
                        <li class="footer-li"><a href="#">Bug Bounty</a></li>
                        <li class="footer-li"><a href="#">Foodie Super</a></li>
                        <li class="footer-li"><a href="#">Foodie Corporate</a></li>
                        
                    </ul>
                </div>
                <div class="points">
                    CONTACT
                    <ul class="footer-ul">
                        <li class="footer-li"><a href="#">Help & Support</a></li>
                        <li class="footer-li"><a href="#">Partner with us</a></li>
                        <li class="footer-li"><a href="#">Ride with us</a></li>
                    </ul>
                </div>
                <div class="points">
                    LEGAL
                    <ul class="footer-ul">
                        <li class="footer-li"><a href="#">Terms & Conditions</a></li>
                        <li class="footer-li"><a href="#">Refund & Cancellation</a></li>
                        <li class="footer-li"><a href="#">Privacy Policy</a></li>
                        <li class="footer-li"><a href="#">Cookie Policy</a></li>
                        <li class="footer-li"><a href="#">Offer Terms</a></li>
                        <li class="footer-li"><a href="#">Phishing & Fraud</a></li>
                    </ul>
                </div>
                <div class="points">
                    <img src="https://static.naukimg.com/s/0/0/i/new-homepage/ios-app_v1.png"
                        height="54" />
                    <img src="https://static.naukimg.com/s/0/0/i/new-homepage/android-app_v1.png"
                        height="54" />
                </div>
            </div>
       </footer>

   
</body>
</html>
