<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>jsp login page: success</title>
</head>



<script type="text/javascript">
function redirectPage(){
	 window.location="<%=request.getParameter("acceuil")%>";
}
</script>

<body onLoad="setTimeout('redirectPage()', 1000)">

<h2> Hello mr  '<%= request.getParameter("username")%>' ,  Your password is  '<%= request.getParameter("password")%>'</h2>
<h2>Wait a second, you will be redirected to accueil page <%= request.getParameter("acceuil")%> !</h2>
</body>
</html>