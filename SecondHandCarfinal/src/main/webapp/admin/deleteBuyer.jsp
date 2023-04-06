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
<title>CarList</title>
</head>

<body>
	
   <div class="panel">
		<div class="panel-body">
			<div class="col-md-12">
				<h3 class="animated fadeInLeft">Delete Buyer</h3>
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
		<div class="index-wall white " style="length:200px;height:100px;">
			<form class="form-inline" action="../DeleteBuyer" method="post" >
					<div class="form-group mar-left-10" style="height:40px;color:black;">
						 <select style="width:180px;position:absolute;left:280px;margin-top:3px;font-size:1px;padding-left:1px;px;" name="delete_type">
       			  			 <option value="1">Id</option>
       				 		 <option value="2">Name</option>
   						 </select>
						 <input name="delete_info" type="text" class="form-control"
						style="width: 120px; margin-top:3px;position:absolute;left:480px;" id="" value="">
					</div>
					<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;position:absolute;left:620px;margin-top:5px;">Delete Buyer</button>
				</form>
		</div>
	<!-- 搜索结束 --> 
    </div>
</body>
</html>