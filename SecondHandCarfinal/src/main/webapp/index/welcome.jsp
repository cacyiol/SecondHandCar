<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" import="java.util.List" import="com.university.object.Car" import="com.university.impl.CarDatabaseDao"%>

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
	
   <div class="panel" >
		<div class="panel-body">
			<div class="col-md-12">
				<h3 class="animated fadeInLeft">Car List</h3>
			</div>
		</div>
    </div>
	
    <div class="col-md-12 padding-0 form-element" style="width:1000px; margin-left:10px;">
      <!-- 搜索 -->
		<div class="index-wall white " style="background-color:#4E8BB8; length:100px;">
			<div class="container"
				style="position: relative; idth: auto;">
				<form class="form-inline" action="../IndexListCarByInfo" method="post" >
					<div class="form-group mar-left-10" style="height:40px;color:black;">
						 <select style="width:230px;position:absolute;left:250px;margin-top:3px;font-size:1px;padding-left:1px;px;" name="index_type">
       			  			 <option value="1">List Car By brand</option>
       				 		 <option value="2">List Car By model</option>
   						 </select>
						 <input name="info" type="text" class="form-control"
						style="width: 100px; margin-top:3px;position:absolute;left:500px;" id="" value="">
					</div>
					<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;position:absolute;left:620px;margin-top:5px;">List Car</button>
				</form>
			</div>
		</div>
	<!-- 搜索结束 -->
        <div class="panel" style="width:1000px;">
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