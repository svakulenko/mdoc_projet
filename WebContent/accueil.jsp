<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>acceuil page</title>
</head>
<body>

<h1>acceuil page</h1>

<a href="addContact.jsp">add contact</a>
<a href="removeContact.jsp">remove contact</a>
<a href="searchContact.jsp">search contact</a>
<a href="updateContact.jsp">update contact</a>
<a href="SContactClearTable">clear table</a>
<a href="SContactShowAll">showTable</a>

<br/>
<jsp:include page="/commonPages/dbdataOutput.jsp" />
</body>
</html>