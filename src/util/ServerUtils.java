package util;

import java.util.List;

import domain.Contact;



public class ServerUtils {
	private ServerUtils() {
	}

	static public String getNewParameter(String name, String value) {
		return ("?" + name + "=" + value);
	}

	/*
	static public String generateRow(String key, String value) {
		String generatedHtml = "";
		generatedHtml += "<tr>";
		generatedHtml += "<td style=\"width: 140px;\">" + key + "</td>";
		generatedHtml += "<td valign=\"top\">" + value + "</td>";
		generatedHtml += "</tr>";
		return generatedHtml;
	}
	*/
	static public String generateRow(String hId, String hFN, String hLN, String E) {
		String generatedHtml = "";
		generatedHtml += "<tr>";
		generatedHtml += "<td style=\"width: 50px;\"  >" + hId + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + hFN + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + hLN + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + E + "</td>";

		generatedHtml += "</tr>";
		return generatedHtml;
	}
	static public String generateRow(Contact c) {
		
		String generatedHtml = "";
		generatedHtml += "<tr>";
		generatedHtml += "<td valign=\"top\">" + c.getContactId() + "</td>";
		generatedHtml += "<td valign=\"top\">" + c.getFirstName() + "</td>";
		generatedHtml += "<td valign=\"top\">" + c.getLastName() + "</td>";
		generatedHtml += "<td valign=\"top\">" + c.getEmail() + "</td>";
		generatedHtml += "</tr>";
		return generatedHtml;
	}

	static public String generateTable(List<Contact> lst, String header) {
		String generatedHtml = "";
		if (lst.size() != 0) {

			generatedHtml += "<div align=\"center\">";
			generatedHtml += "<br><br>";
			generatedHtml += "<table><tbody>";
			//generatedHtml += "<TABLE BORDER=\"1\">";
			generatedHtml += "<CAPTION><B>" + header + "</B> </CAPTION>";
			generatedHtml += generateRow("<B>ID</B>", "<B>First Name</B>", "<B>Last Name</B>", "<B>Email</B>");
			for (Contact c : lst) {
				
				generatedHtml += generateRow(c);
//				generatedHtml += generateRow("ID", ""+c.getId());
//				generatedHtml += generateRow("FirstName", c.getFirstName());
//				generatedHtml += generateRow("LastName ", c.getLastName());
//				generatedHtml += generateRow("Email ", c.getEmail());
			}
			generatedHtml += "</tbody></table>";
			generatedHtml += "</div>";
		}
		System.out.println("gen html" + generatedHtml);
		return generatedHtml;
	}
	
	static public void showParameters(
			String firstName
			, String lastName
			, String email
			, String street
			, String city
			, String zip
			, String country
			, String phoneKind
			, String phoneNumber
			, String numSiret
			){
		
		System.out.println("firstname="+ firstName);
		System.out.println("lastname="+ lastName);
		System.out.println("email="+ email);
		System.out.println("street="+ street);
		System.out.println("city="+ city);
		System.out.println("zip="+ zip);
		System.out.println("country="+ country);
		System.out.println("phonekind="+ phoneKind);
		System.out.println("phonenumber="+ phoneNumber);
		System.out.println("numSiret="+ numSiret);
	}
	
	
	
	public static String opFait = "<i><b>operation est Fait</i></b>";
	public static String opNoRecods = "<i><b>Pas de records dans base de donées</i></b>";
	public static String opTableRemoved  = "<i><b>Table est effacé</i></b>";
}
