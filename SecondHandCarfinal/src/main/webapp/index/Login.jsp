<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta >
<title>login</title>
</head>
<body>
	<form action="../Login" target="frame" method="post">
 		 <p><label class="label_input">name</label><input type="text" name="username" /></p>
       	 <p><label class="label_input">password</label><input type="text" name="password" /></p>
 
       	 <div id="login_control">
            <input type="submit" id="btn_login" value="Login"/>
            <input type="button" onclick="window.location.href='../Register.jsp';" value="Register">
          </div>
    </form>
</body>
</html>