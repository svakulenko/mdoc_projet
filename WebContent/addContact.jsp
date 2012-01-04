<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>add contact</title>

</head>
<body>
<jsp:include page="/commonPages/header.jsp" />
<jsp:include page="/commonPages/checkInput.jsp" />

 
 
<h1>add contact input form:</h1>
<jsp:include page="/commonPages/dbdataOutput.jsp" />

<script>
    function toggle(arg){
	var div1 = document.getElementById('div1')
	var div2 = document.getElementById('div2')
        if (arg == 'contact'){
            if (div1.style.display == 'none') {
                div1.style.display = 'block'
                div2.style.display = 'none'
                } 
            } else {
            if (div1.style.display == 'block') {
                div1.style.display = 'none'
                div2.style.display = 'block'
                } 

        }
}
</script>





<form>
<input type="radio" name="type" value="contact" CHECKED onclick="toggle('contact')" /> Contact
<input type="radio" name="type" value="entreprise" onclick="toggle('entreprise')"/> Entreprise
</form> 
<div id='div2' style='display:none'>
<form name="myForm" method="post" action="AddEntreprise">
    <br/>  <input type="submit" value="Save"> <input type="reset"  value="Clear">

	

    <table><tbody>
            <tr>
                <td style="width: 140px;">NumSiret:</td>
                <td valign="top"> <input type="text"  name="numsiret" size="25" value="1234" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstname" size="25" value="Beckham"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastname" size="25" value="David"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="email david@mu.com " > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="Jussieu" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="Paris" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="75000 " > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="France" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phonekind" size="25" value="Cell Phone " > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phoneNumber" size="25" value="01 23 45 67 89" > </td>
            </tr>


			<tr>
                <td style="width: 140px;">*GroupName:</td>
                <td valign="top"> <input type="text"  name="groupName" size="25" value="Buddy" > </td>
            </tr>
    </tbody></table>
</form>

</div>
<div id='div1' style='display:block'>
<form name="myForm" method="post" action="AddContact">
    <br/>  <input type="submit" value="Save"> <input type="reset"  value="Clear">

    <table><tbody>

            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstName" size="25" value="Bill"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastname" size="25" value="Gate"> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="bill@mycrosoft.com" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="Gare de Lyon" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="Paris" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="75000" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="France" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phonekind" size="25" value="Offical Phone" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phoneNumber" size="25" value="09 87 65 43 21 " > </td>
            </tr>


			<tr>
                <td style="width: 140px;">*GroupName:</td>
                <td valign="top"> <input type="text"  name="groupName" size="25" value="Entreprise " > </td>
            </tr>
    </tbody></table>
</form>


</div>






</body>
</html>
