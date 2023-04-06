<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--包含导航栏所用的css-start--%>
<link rel="stylesheet" type="text/css" href="/SecondHandCar/admin/asset/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/SecondHandCar/admin/asset/css/plugins/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="/SecondHandCar/admin/asset/css/style.css" >
<%--包含导航栏所用的css-end--%>
<link rel="stylesheet" href="/SecondHandCar/admin/css/page.css" />
<script type="text/javascript" src="/SecondHandCar/admin/js/jquery.min.js" ></script>
<title>Administration System</title>
</head>
<body>
	<div id="left">
		<div class="bigTitle" style="background-color:#4E8BB8; font-size:10;">SecondHandCar Management System</div>
		<div id="left-menu">
			<div class="sub-left-menu scroll" style="width: 20%;">
				<form action="../CarList" target="frame" method="post">
						<a class="tree-toggle nav-header">&nbsp;&nbsp;<span class="fa-home fa"></span>Car<span
							class="fa-angle-right fa right-arrow text-right"></span> </a>
						<ul class="nav nav-list tree">
							<li>
								<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;">List All Cars</button>
							</li>				
						</ul>
					
				</form>	
				<form action="../OwnerList" target="frame" method="post">
						<a class="tree-toggle nav-header">&nbsp;&nbsp;<span class="fa-diamond fa"></span>Owner<span
							class="fa-angle-right fa right-arrow text-right"></span>
						</a>
						<ul class="nav nav-list tree">
							<li>
								<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;">List All Owners</button>
							</li>
						</ul>
					
				</form>
				
				<form action="../BuyerList" target="frame" method="post">
						<a class="tree-toggle nav-header">&nbsp;&nbsp;<span class="fa fa-check-square-o"></span>Buyer<span
							class="fa-angle-right fa right-arrow text-right"></span> </a>
						<ul class="nav nav-list tree">
							<li>
								<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;">List All Buyers</button>
							</li>
						</ul>
				</form>
			</div>
		</div>

	</div>
	
	<div id="right">
		<div id="right_top">
			<div class="leftTiyle" id="flTitle"></div>
		</div>
		<div id="right_bottom">
			<iframe name="frame" width="100%" height="100%" src="/SecondHandCar/admin/welcome.jsp"></iframe>
		</div>
	</div>
		
	
<%--包含导航栏所用的js-start--%>
<script src="/SecondHandCar/admin/asset/js/jquery.min.js"></script> 
<script src="/SecondHandCar/admin/asset/js/bootstrap.min.js"></script> 
<script src="/SecondHandCar/admin/asset/js/plugins/jquery.nicescroll.js"></script> 
<script src="/SecondHandCar/admin/asset/js/main.js"></script> 
<%--包含导航栏所用的js-end--%>
</body>
</html>