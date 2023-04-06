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

<title>Second Hand Car</title>
</head>
<body>
				
	<div id="left">
		<div class="bigTitle" style="background-color:#4E8BB8; font-size:10;">Second Hand Car</div>
		<div id="left-menu">
			<div class="sub-left-menu scroll" style="width: 20%;">
			
				<form action="../UserCarList" target="frame_index" method="post">
						<a class="tree-toggle nav-header">&nbsp;&nbsp;<span class="fa-home fa"></span>My Car<span
							class="fa-angle-right fa right-arrow text-right"></span> </a>
						<ul class="nav nav-list tree">
							<li>
								<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;" formtarget="frame">List My Cars</button>
							</li>				
						</ul>
					
				</form>	
						
				<form action="../UserList" target="frame_index" method="post">
						<a class="tree-toggle nav-header">&nbsp;&nbsp;<span class="fa fa-check-square-o"></span>MY Info<span
							class="fa-angle-right fa right-arrow text-right"></span> </a>
						<ul class="nav nav-list tree">
							<li>
								<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;" formtarget="frame">List My Information</button>
							</li>
							
						</ul>
				</form>
				<form action="../index/frame.jsp" target="frame_index" method="post">
						<a class="tree-toggle nav-header">&nbsp;&nbsp;<span class="fa fa-check-square-o"></span>Home Page<span
							class="fa-angle-right fa right-arrow text-right"></span> </a>
						<ul class="nav nav-list tree">
							<li>
								<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;" formtarget="frame">return Home Page</button>
							</li>
						</ul>
					
				</form>
				<form action="../Sold_num" target="frame" method="post">
					<button type="submit" class="btn btn-warning mar-left-10" style="background-color:#C45D2B;" formtarget="frame">Administration System</button>
				</form>
			</div>
		</div>

	</div>
	
</body>
	
	<div id="right">
	<div id="right_top">
			<div class="leftTiyle" id="flTitle"></div>
			<div class="thisUser"></div>
		</div>
		<div id="right_bottom">
			<iframe name="frame" width="100%" height="100%" src="/SecondHandCar/index/welcome.jsp"></iframe>
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