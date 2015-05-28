<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Site, model.Recording, java.util.ArrayList" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Ntpq Status</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
    
    <%!
    ArrayList<Site> list = new ArrayList<Site>();
    list.add(new Site());
    %>

    <%
       // Set refresh, autoload time as 5 seconds
       response.setIntHeader("Refresh", 5);
    %>

    <%
    	
    %>
    <div id="container">
    	<div id="header">
    		<table width="80%" border="0" cellspacing="0" cellpadding="0" class="center">
  				<tr>
  					<td width="20" height="20" valign="top" bgcolor="#00CC00" id="colour"> </td>
  					<td width="20" height="20" valign="top" bgcolor="#FF0000" id="colour"> </td>
    				<td width="15%" height="20" valign="top"> Remote</td>
    				<td width="15%" height="20" valign="top"> When</td>
    				<td width="15%" height="20" valign="top"> Offset</td>
    				<td width="15%" height="20" valign="top"> Jitter</td>
    				<td width="15%" height="20" valign="top"> Comment</td>
  				</tr>
    		</table>
    	</div>
        
    	<div id="mainContent">
    		<%
    		for(Site site: list) {
    		%>
    		<table width="80%" border="0" cellspacing="0" cellpadding="0" class="center">                
  				<tr>
  					<%
					if(fileHandler.ntpqList.get(i).getStatus().equals("red")){
					%>
						<td width="20" height="20" valign="top" bgcolor="#FF0000" id="colour"> </td>
					<%
  					}else{
  					%>
  						<td width="20" height="20" valign="top" bgcolor="#00CC00" id="colour"> </td>
  					<%
  					}
  					%>
  					<td width="20" height="20" valign="top"> </td>
    				<td width="15%" height="20" valign="top"><%= fileHandler.ntpqList.get(i).getRemote() %></td>
    				<%
					if(fileHandler.ntpqList.get(i).getWhen() == -1){
					%>
					<td width="15%" height="20" valign="top"> - </td>
					<%
  					}else{
  					%>
    				<td width="15%" height="20" valign="top"><%= fileHandler.ntpqList.get(i).getWhen() %></td>
    				<%
  					}
  					%>
    				<td width="15%" height="20" valign="top"><%= fileHandler.ntpqList.get(i).getOffset() %></td>
    				<td width="15%" height="20" valign="top"><%= fileHandler.ntpqList.get(i).getJitter() %></td>
    				<td width="15%" height="20" valign="top"><%= fileHandler.ntpqList.get(i).getComment() %></td>
  				</tr>
    		</table>
            
            <%
            }
            %>
        </div>
        <div id="footer">
        	<p>Hover over the header to reveal further information</p>
        </div>
    </div>
</body>
</html>