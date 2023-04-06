<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./Register" method="post">
 
        <p><label class="label_input">name</label><input type="text" name="username" /></p>
        <p><label class="label_input">password</label><input type="text" name="password" /></p>
 		
      <select name="status">
         <option value="0">owner</option>
         <option value="1">buyer</option>
      </select>
        
      
        <div id="login_control">
            <input type="submit" id="btn_login" value="Register"/>
            
        </div>
    </form>
</body>
</html>