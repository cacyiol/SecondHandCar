<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" import="java.util.List" import="com.university.object.Car" import="com.university.impl.CarDatabaseDao" %>
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
				<h3 class="animated fadeInLeft">Car List</h3>
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
      <!-- 搜索 -->
		<div class="index-wall white " style="background-color:#4E8BB8; length:100px;">
			<div class="container"
				style="position: relative; idth: auto;">
				<form class="form-inline" method="post" >
					<div class="form-group mar-left-10" style="height:40px;color:black;"></div>
					<div style="position:absolute;left:50px;font-size:10px;top:10px;height:20px;">
						<a href="ChangeCar.jsp" target="frame" style="color:white;font-size:15px;">Choose car to Change</a>
					</div>
					<div style="position:absolute;left:250px;font-size:10px;top:10px;height:20px;">
						<a href="deleteCar.jsp" target="frame" style="color:white;font-size:15px;">Choose car to delete</a>
					</div>
					<div style="position:absolute;left:450px;font-size:10px;top:10px;height:20px;">
						<a href="addCar.jsp" target="frame" style="color:white;font-size:15px;">Add Car</a>
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
								<table class="table table-striped table-bordered dataTable no-footer">
									<thead>
										<tr role="row">
											<th class="sorting_asc" style="width:10%;">id</th>
											<th class="sorting" style="width:10%;">price</th>
											<th class="sorting" style="width:10%;">owner</th>
											<th class="sorting" style="width:10%;">brand</th>
											<th class="sorting"  style="width:10%;">model</th>
											<th class="sorting"  style="width:10%;">licensePlateNumber</th>
											
										</tr>
									</thead>
									
									<tbody>
										<%
										ServletContext sc =getServletContext();
										int j=0;
										List<Car> carlist =(List<Car>) sc.getAttribute("carlist");
										if(carlist==null)
										{
											CarDatabaseDao carDao=new CarDatabaseDao();
											carlist=carDao.listAllCar();
										}
										while(j<carlist.size())
										{
										%>
										<tr>
											<td><%=carlist.get(j).getIdCar() %></td>
											<td><%=carlist.get(j).getPrice() %></td>
											<td><%=carlist.get(j).getOwner().getName() %></td>
											<td><%=carlist.get(j).getBrand() %></td>
											<td><%=carlist.get(j).getModel() %></td>
											<td><%=carlist.get(j).getLicensePlateNumber() %></td>
											
										</tr>
										  <%
											j++;
										}
										sc.setAttribute("carlist",null);
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