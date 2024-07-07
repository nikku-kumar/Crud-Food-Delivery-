<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Signup.css">
</head>
<body>
<div class="container">
    <div class="title">Order Confirmation</div>
    <div class="content">
      <form action="confirmservlet">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Name</span>
            <input type="text" placeholder="Enter your name" name="name" required>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input type="email" placeholder="Enter your username" name="email" required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="number" placeholder="Enter your number" name="number" required>
          </div>
          <div class="input-box">
            <span class="details">Address</span>
            <input type="text" placeholder="Enter your number" name="address" required>
          </div>
          <div class="input-box">
            <span class="details">State </span>
            <input type="text" placeholder="Enter your password" name="state" required>
          </div>
          <div class="input-box">
            <span class="details">City</span>
            <input type="text" placeholder="Enter your password" name="city" required>
          </div>
          <div class="input-box">
            <span class="details">zip code</span>
            <input type="number" placeholder="Enter your password" name="zipcode" required>
          </div>
          <div class="input-box">
            <span class="details">Suggestion for order</span>
            <input type="text" placeholder="Enter your password" name="suggestion" required>
          </div>
       <div class="input-box">   
  <span class="details">Choose a payment method:</span>
  <select id="payment-method" name="payment_method" required>
    <option value="cash">Cash on Delivery (COD)</option>
    <option value="UPI">Unified Payments Interface (UPI)</option>
    <option value="debitCard">Debit Card</option>
    <option value="creditCard">Credit Card</option>
  </select>
  </div>
        
          <div class="button">
          
           <input type="submit" value="Confirm">
           
          </div>
       </div>
      </form>
    </div>
  </div>

</body>
</html>