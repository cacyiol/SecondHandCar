<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" import="java.util.List" import="com.university.object.Car"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
<link href="asset/css/style.css" rel="stylesheet">
<title>Add Car</title>
</head>

<body>
	
   <div class="panel">
		<div class="panel-body">
			<div class="col-md-12">
				<h3 class="animated fadeInLeft">Add Car</h3>
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
	
	
    <div class="col-md-12 padding-0 form-element" style="width:1000px; margin-left:10px;">

		<div class="index-wall white " style="length:200px;height:100px;">
				<form class="form-inline" action="../AddCar" method="post" style="margin-left:420px;font-size:20px;">
					<ul><li>
						 <label style="position:absolute;top:-10px;">brand:</label><input name="brand" type="text" class="form-control"
						style="width: 120px;position:absolute;left:650px;height:40px;top:-10px;" id="" value="">
					</li></ul><br>
					<ul><li>
						 <label style="position:absolute;top:40px;">model:</label><input name="model" type="text" class="form-control"
						style="width: 120px;position:absolute;left:650px;height:40px;top:40px;" id="" value="">
					</li></ul>
					<ul><li>
						 <label style="position:absolute;top:100px;">Owner:</label><input name="owner" type="text" class="form-control"
						style="width:120px;position:absolute;left:650px;height:40px;top:100px;" id="" value="">
					</li></ul>
					<ul><li>
						 <label style="position:absolute;top:160px;">Price:</label><input name="price" type="text" class="form-control"
						style="width: 120px;position:absolute;left:650px;height:40px;top:160px;" id="" value="">
					</li></ul>
					<ul><li>
						 <label style="position:absolute;top:220px;">LicensePlateNumber:</label><input name="lpn" type="text" class="form-control"
						style="width: 120px;position:absolute;left:650px;height:40px;top:220px;" id="" value="">
					</li></ul>
					<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;position:absolute;left:670px;top:290px;">Add Car</button>
				</form>
		</div>
    </div>
</body>
</html>