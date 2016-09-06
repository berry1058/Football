<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.sanFranTeam.DAO" 
    		import = "com.sanFranTeam.*"	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1>49ers Current PLayer Roster</h1>
						
						<table style="width: 80%;">
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Position</th>
								<th>Team</th>
								<th>Years on Team</th>
								<th>Jersey Number</th>
							</tr>
							<% DAO.readFromDB(); %>
							<% 
							footBall readToJSP = new footBall();
							for(int i = 0;i< DAO.ourfootBall.size();i++){ 
							readToJSP = DAO.ourfootBall.get(i);
							
							%>
							<tr>
								<td><%= readToJSP.getFirstName() %></td>
								<td><%= readToJSP.getLastName() %></td>
								<td><%= readToJSP.getPosition() %></td>
								<td><%= readToJSP.getTeam() %></td>
								<td><%= readToJSP.getYearsOnTeam() %></td>
								<td><%= readToJSP.getJerseyNumber() %></td>
							</tr>
							
							<%
							
							} 
							
							DAO.ourfootBall.clear();
							%>
						</table>

					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
</body>
</html>