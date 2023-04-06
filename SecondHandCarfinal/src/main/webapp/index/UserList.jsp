<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" import="java.util.List" import="com.university.object.Buyer" import="com.university.object.Owner"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
<link rel="styjstl/core" prefix="c"%>
<body>
    <div class="panel">
		<div class="panel-body">
			<div class="col-md-12">
				<h3 class="animated fadeInLeft">User List</h3>
			</div>
		</div>
		<div id="right">
				<div id="right_top">
					<div class="leftTiyle" id="flTitle"></div>
					<div class="thisUser" style="font-size:20px;margin-left:90%;">
						<a href="/SecondHandCar/index/frame.jsp" target="frame">User Center</a>
					</div>
				</div>
			</div>
    </div>
	
	
    <div class="col-md-12 padding-0 form-element" style="width:1000px; margin-left:10%;">

		<div class="index-wall white " style="background-color:#4E8BB8; length:100px;">
			<div class="container"
				style="position: relative; idth: auto;">
				<form class="form-inline" action="../ListBuyerByInfo" method="post" target="frame_index">
					<div class="form-group mar-left-10" style="height:40px;color:black;"></div>
					<div style="position:absolute;left:750px;font-size:10px;top:10px;height:20px;">
						<a href="ChangeUser.jsp" target="frame" style="color:white;font-size:15px;">Change My Information</a>
					</div>
				</form>
			</div>
		</div>
		
        <div class="panel">
			<div class="panel-body">
				<div class="responsive-table">
					<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-striped table-bordered dataTable no-footer" style="width:600px;margin-left:20%;margin-right:50%;">
									<thead>
										<tr role="row">
											<th class="sorting_asc" style="width:300px;">id</th>
											<th class="sorting" style="width:300px;">name</th>
											<th class="sorting" style="width:300px;">drivingLicenseNumber</th>
										</tr>
									</thead>
									
									<tbody>
										<%
										ServletContext sc =getServletContext();
										
										int status = (int) session.getAttribute("BO");
										if(status==1){
										
											Buyer byuer=(Buyer)sc.getAttribute("buyer");
										
											%>
											<tr>
												<td><c:out value="${buyer.getId()}"></c:out></td>
												<td><c:out value="${buyer.getName()}"></c:out></td>
												
											</tr>
										<%
										}
										else{
											Owner owner=(Owner)sc.getAttribute("owner");
										
										%>
										<tr>
												<td><c:out value="${owner.getIdOwner()}"></c:out></td>
												<td><c:out value="${owner.getName()}"></c:out></td>
												<td><c:out value="${owner.getDrivingLicenseNumber()}"></c:out></td>
											</tr>
											<%
											}
											%>
									</tbody>
								</table>
								
							</div>
						</div>
					</div>
				</div>
			</div>
        </div>
    </div>
</body>
</html>