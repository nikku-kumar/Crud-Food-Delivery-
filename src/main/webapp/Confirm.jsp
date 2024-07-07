<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FDFCCD;
            text-align: center;
        }
        .confirmation-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            align-content: centre;
        }
        h1 {
            color: #AF0000;
        }
        .order-details {
            margin-top: 20px;
        }
        .order-details p {
            font-size: 16px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
 <div class="confirmation-container">
        <h1>Congratulations <%= session.getAttribute("name") %>, your Order is confirmed!</h1>
        <div class="order-details">
            <p>Order ID: <%= session.getAttribute("orderId") %></p>
            <p>Name: <%= session.getAttribute("name") %></p>
            <p>Mode of payment: <%= session.getAttribute("payment_method") %></p>
            <p>Status of order: <%= session.getAttribute("status") %></p>
            <p>Total Amount: <%= session.getAttribute("total") %></p>
            <p>Delivery Address: <%= session.getAttribute("address") %>, <%= session.getAttribute("city") %>, <%= session.getAttribute("zipcode") %></p>
        </div>
        <a href="callservlethistory">view history</a>
    </div>
</body>
</html>