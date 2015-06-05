<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Site, model.Recording, java.util.ArrayList" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Ntpq Status</title>
    <link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
 	<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</head>
<%! ArrayList<Site> list = new ArrayList<Site>(); %>
<%     // Set refresh, autoload time as 5 seconds
       //response.setIntHeader("Refresh", 5); %>
<%  list.add(new Site()); %>

<body>
    <table class="table" style="width: auto;" align="center">
    <thead>
        <tr>
            <th>Remote</th>
            <th>When</th>
            <th>Offset</th>
            <th>Jitter</th>
            <th>Comment</th>
        </tr>
    </thead>
    <tbody>
    <%= for(Site site:list){ 
    System.out.println("Hei");%>
        <tr class="active">
            <td>1</td>
            <td>Credit Card</td>
            <td>04/07/2014</td>
            <td>Call in to confirm</td>
            <td>Dette ses på som test</td>
        </tr>
        <tr class="success">
            <td>2</td>
            <td>Water</td>
            <td>01/07/2014</td>
            <td>Paid</td>
            <td>Dette ses på som test</td>
        </tr>
        <tr class="info">
            <td>3</td>
            <td>Internet</td>
            <td>05/07/2014</td>
            <td>Change plan</td>
            <td>Dette ses på som test</td>
        </tr>
        <tr class="warning">
            <td>4</td>
            <td>Electricity</td>
            <td>03/07/2014</td>
            <td>Pending</td>
            <td>Dette ses på som test</td>
        </tr>
        <tr class="danger">
            <td>5</td>
            <td>Telephone</td>
            <td>06/07/2014</td>
            <td>Due</td>
            <td>Dette ses på som test</td>
        </tr>
    </tbody>
</table>
    <% } %>
        <div id="footer">
        	
        </div>
</body>
</html>