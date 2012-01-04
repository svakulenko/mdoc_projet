<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>AddContact Spring</title>
</head>
<body>
	<jsp:include page="/commonPages/header.jsp" />
	<jsp:include page="/commonPages/checkInput.jsp" />
	<h1>Add contact input form:</h1>
	<jsp:include page="/commonPages/dbdataOutput.jsp" />
	<form name="form1" method="post" action="AddWithSpring/Contact"
		onsubmit="">
		<br /> <input type="submit" value="AddContact"> <input
			type="reset" value="Clear">
	</form>
	<form name="form2" method="post" action="AddWithSpring/Entreprise"
		onsubmit="">
		<br /> <input type="submit" value="AddEntreprise"> <input
			type="reset" value="Clear">
	</form>
</body>
</html>