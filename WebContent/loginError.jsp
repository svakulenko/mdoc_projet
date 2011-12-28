<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>jsp login page: error</title>
</head>
<body>

Sorry Mr. <%= request.getParameter("username")%>, your login operation is failed
please try it again
<a href="<%= request.getParameter("indexPage") %>"> login page</a>

</body>
</html>