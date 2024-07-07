<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tap.model.Order" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
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
        }
        h1 {
            color: #AF0000;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
   <div class="confirmation-container">
        <h1>Hey <%= session.getAttribute("name") %>, Your Past Order Is Here!</h1>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Restaurant ID</th>
                <th>Total Amount</th>
                <th>Status</th>
                <th>more</th>
               
            </tr>
            <% List<Order> order = (List<Order>) session.getAttribute("order2");
               for (Order o : order) { %>
                <tr>
                    <td><%= o.getOrderId() %></td>
                    <td><%= o.getOrestaurantId() %></td>
                    <td><%= o.getTotalAmount() %></td>
                    <td><%= o.getStatus() %></td>
                    <td><a href="historydetailsservlet?historyId=<%= o.getHistoryId() %>">details</a></td>
                    
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>