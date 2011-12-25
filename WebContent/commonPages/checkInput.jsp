<script type="text/javascript">
function checkInputFormStop(){

	var formElements = document.getElementById('myForm').elements
	for(var i = 0; i < formElements.length && formElements[i].type == "text"; i++) {
			if (formElements[i].name == "contactID" && isNaN(parseInt(formElements[i].value)) ){
			alert("did you use numbers for field " + formElements[i].name + " ?" )
			return false
		}
		else if (formElements[i].value == "" || formElements[i].value == null ) {
			alert("please check input field " + formElements[i].name)
			return false
		}
	}

	return true
}



</script>