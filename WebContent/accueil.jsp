<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>Mdoc projet (JSP, Hibernate, Spring)</title>
</head>
<body>


<div class="MainDiv">

  <div class="header">
    <div align="center"><h4>MDOC Projet: accueil page</h4></div>
  </div>
  
  <div class="sidebar">
<a href="addContact.jsp">add contact</a><br>
<a href="removeContact.jsp">remove contact</a><br>
<a href="searchContact.jsp">search contact</a><br>
<a href="updateContact.jsp">update contact</a><br>
<a href="ClearTable">clear table</a><br>
<a href="ShowAllContact">showTable</a><br>
  </div>
  
  <div class="mainBody" style="overflow:auto">
  <jsp:include page="/commonPages/dbdataOutput.jsp" /><br>
  </div>
  
  <jsp:include page="/commonPages/footer.jsp" />

</div>



</body>

</html>