<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" import="java.util.List" import="com.university.object.Buyer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
<link href="asset/css/style.css" rel="stylesheet">
<title>CarList</title>
</head>

<body>
	
   <div class="panel">
		<div class="panel-body">
			<div class="col-md-12">
				<h3 class="animated fadeInLeft">Buyer List</h3>
			</div>
		</div>
		<div id="right">
				<div id="right_top">
					<div class="leftTiyle" id="flTitle"></div>
					<div class="thisUser" style="font-size:20px;margin-left:90%;">
						<a href="/SecondHandCar/admin/frame.jsp" target="frame">HomePage</a>
					</div>
				</div>
			</div>
    </div>
	
	
    <div class="col-md-12 padding-0 form-element" style="width:1000px; margin-left:10%;">
      <!-- 搜索 -->
		<div class="index-wall white " style="background-color:#4E8BB8; length:100px;">
			<div class="container"
				style="position: relative; idth: auto;">
				<form class="form-inline" action="../ListBuyerByInfo" method="post" >
					<div class="form-group mar-left-10" style="height:40px;color:black;">
						 <select style="width:230px;position:absolute;left:250px;margin-top:3px;font-size:1px;padding-left:1px;px;" name="type">
       			  			 <option value="1">List Buyer By Id</option>
       				 		 <option value="2">List Buyer By Name</option>
   						 </select>
						 <input name="info" type="text" class="form-control"
						style="width: 100px; margin-top:3px;position:absolute;left:500px;" id="" value="">
					</div>
					<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;position:absolute;left:620px;margin-top:5px;">List Buyer</button>
					<div style="position:absolute;left:750px;font-size:10px;top:10px;height:20px;">
						<a href="deleteBuyer.jsp" target="frame" style="color:white;font-size:15px;">Choose Buyer to delete</a>
					</div>
				</form>
			</div>
		</div>
	<!-- 搜索结束 -->
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
										</tr>
									</thead>
									
									<tbody>
										<%
										ServletContext sc =getServletContext();
										int j=0;
										List<Buyer> Buyerlist =(List<Buyer>) sc.getAttribute("buyerlist");
										
										while(j<Buyerlist.size())
										{
										%>
										<tr>
											<td><%=Buyerlist.get(j).getId()%></td>
											<td><%=Buyerlist.get(j).getName() %></td>
											
										</tr>
										  <%
											j++;
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