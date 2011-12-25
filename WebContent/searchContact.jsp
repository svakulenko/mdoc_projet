<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="/commonPages/checkInput.jsp" />
<jsp:include page="/commonPages/header.jsp" />


<h1>search contact</h1>
	<form name="inputForm1" method="post" action="SContactSearchContact" onsubmit="JavaScript:return checkInputFull();">
	<table><tbody>
		
		<tr>
		<td style="width: 140px;">id:</td>
		<td valign="top"> <input type="text"  name="contactID" size="25"> </td>
		</tr>
	</tbody></table>
	<br/>  <input type="submit" value="Submit">
		   <input type="reset"  value="Reset">
		   <input type="hidden" value="searchContact.jsp" name="callfrom" />
	</form>
	
<jsp:include page="/commonPages/dbdataOutput.jsp" />
</body>
</html>
