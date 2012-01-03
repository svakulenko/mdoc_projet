<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="cssStyle.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>

</head>
<body>

<h1>Search contact</h1>
<h4>Please enter one of search criteria :</h4>
<jsp:include page="/commonPages/header.jsp" />
<jsp:include page="/commonPages/checkInput.jsp" />

 
 

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
<form name="myForm" method="post" action="SearchContact/EntrepriseSimple" onsubmit="">
    <br/>
    <input type="submit" value="Search"> 
    <input type="reset"  value="Clear">
    <label for="lab">Simple search (find with ?)</label>
    
    <table><tbody>
            <tr>
                <td style="width: 140px;">ID:</td>
                <td valign="top"> <input type="text"  name="id" size="25" value="" > </td>
            </tr>
    </tbody></table>
</form>

</div>
<div id='div1' style='display:block'>
<form name="myForm" method="post" action="SearchContact/ContactSimple" onsubmit="">
    <br/>
    <input type="submit" value="Search"> 
    <input type="reset"  value="Clear">
    <label for="lab">Simple search (find with ?)</label>

    <table><tbody>
            <tr>
                <td style="width: 140px;">ID:</td>
                <td valign="top"> <input type="text"  name="id" size="25" value=""> </td>
            </tr>
    </tbody></table>
</form>


</div>

<div id='div2' style='display:none'>
<form name="myForm" method="post" action="SearchContact/EntrepriseCriteria" onsubmit="">
    <br/>
    <input type="submit" value="Search"> 
    <input type="reset"  value="Clear">
    <label for="lab">Simple search (find by Criteria)</label>

	

    <table><tbody>
            <tr>
                <td style="width: 140px;">NumSiret:</td>
                <td valign="top"> <input type="text"  name="numsiret" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstname" size="25" value=""> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastname" size="25" value=""> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phonekind" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phonenumber" size="25" value="" > </td>
            </tr>

    </tbody></table>
</form>

</div>
<div id='div1' style='display:block'>
<form name="myForm" method="post" action="SearchContact/ContactCriteria" onsubmit="">
    <br/>
    <input type="submit" value="Search"> 
    <input type="reset"  value="Clear">
    <label for="lab">Simple search (find by Criteria)</label>

    <table><tbody>

            <tr>
                <td style="width: 140px;">First Name:</td>
                <td valign="top"> <input type="text"  name="firstname" size="25" value=""> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Last Name:</td>
                <td valign="top"> <input type="text"  name="lastname" size="25" value=""> </td>
            </tr>

            <tr>
                <td style="width: 140px;">Email:</td>
                <td valign="top"> <input type="text"  name="email" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Street:</td>
                <td valign="top"> <input type="text"  name="street" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*City:</td>
                <td valign="top"> <input type="text"  name="city" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*zip:</td>
                <td valign="top"> <input type="text"  name="zip" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*Country:</td>
                <td valign="top"> <input type="text"  name="country" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneKind:</td>
                <td valign="top"> <input type="text"  name="phonekind" size="25" value="" > </td>
            </tr>

            <tr>
                <td style="width: 140px;">*PhoneNumber:</td>
                <td valign="top"> <input type="text"  name="phonenumber" size="25" value="" > </td>
            </tr>

    </tbody></table>
</form>


</div>








</body>
</html>
