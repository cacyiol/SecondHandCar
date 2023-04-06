<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" import="java.util.List" import="com.university.object.Car"%>

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
				<h3 class="animated fadeInLeft">Change Car</h3>
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
		<div class="index-wall white " style="length:200px;height:100px;">
			<form class="form-inline" action="../ChangeCar" method="post" >
					<div class="form-group mar-left-10" style="height:40px;color:black;">
						 <label class="label_input">ID of the car:</label>
						 <input name="change_id" type="text" class="form-control"
						style="width: 120px; margin-top:3px;position:absolute;left:120px;" id="" value="">
						 <select style="width:180px;position:absolute;left:280px;margin-top:3px;font-size:1px;padding-left:1px;px;" name="select_type">
       			  			 <option value="1">brand</option>
       				 		 <option value="2">model</option>
       				 		 <option value="3">LisencePlateNumber</option>
   						 </select>
						 <input name="change_info" type="text" class="form-control"
						style="width: 120px; margin-top:3px;position:absolute;left:480px;" id="" value="">
					</div>
					<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;position:absolute;left:620px;margin-top:5px;">Change</button>
				</form>
		</div>
	<!-- 搜索结束 --> 
    </div>
</body>
</html>