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
            <th>Last Update</th>
        </tr>
    </thead>
    <tbody>
    <%= //for(Site site:list){ %>
        <%if(site.getLastRecording().reach!= 45){ %>
        <tr class="danger">
            <td><%= site.location %></td>
            <td><%= site.getLastRecording().timestamp %></td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <%} else{ %>
        <tr class="success">
            <td><%= site.location %></td>
            <td><%= site.getLastRecording().timestamp %></td>
            <td><%= site.getLastRecording().offset %></td>
            <td><%= site.getLastRecording().jitter %></td>
            <td><%= site.getLastRecording().lastUpdate %></td>
        </tr>
		<% } %>
    </tbody>
</table>
    
        <div id="footer">
        	
        </div>
</body>
</html>