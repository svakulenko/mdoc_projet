package util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;



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
	
	
	static public String generateRow(String hId, String hFN, String hLN, String E,String street, String city, String zip, String country, String pk, String pn, String gn) {
		String generatedHtml = "";
		generatedHtml += "<tr>";
		generatedHtml += "<td style=\"width: 50px;\"  >" + hId + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + hFN + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + hLN + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + street + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + city + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + zip + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + country + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + pk + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + pn + "</td>";
		generatedHtml += "<td style=\"width: 100px;\" >" + gn + "</td>";
		generatedHtml += "</tr>";
		return generatedHtml;
	}
	
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
//		generatedHtml += "<td valign=\"top\">" + c.getAddress().getStreet() + "</td>";
//		generatedHtml += "<td valign=\"top\">" + c.getAddress().getCity() + "</td>";
//		generatedHtml += "<td valign=\"top\">" + c.getAddress().getZip() + "</td>";
//		generatedHtml += "<td valign=\"top\">" + c.getAddress().getCountry()+ "</td>";
//		Set<PhoneNumber> phoneList = c.getPhoneNumbers();
//		for (PhoneNumber p : phoneList)
//		{
//			generatedHtml += "<td valign=\"top\">" + p.getPhoneKind() + "</td>";
//			generatedHtml += "<td valign=\"top\">" + p.getPhoneNumber() + "</td>";
//		}
//		Set<ContactGroup> groupList = c.getContactgroup();
//		for (ContactGroup cg: groupList)
//		{
//			generatedHtml += "<td valign=\"top\">" + cg.getGroupName() + "</td>";
//		}
//		generatedHtml += "</tr>";
		return generatedHtml;
	}
static public String generateRow(Contact c,Address a, PhoneNumber p, ContactGroup cg) {
		
		String generatedHtml = "";
		generatedHtml += "<tr>";
		if (c != null)
		{
			generatedHtml += "<td valign=\"top\">" + c.getContactId() + "</td>";
			generatedHtml += "<td valign=\"top\">" + c.getFirstName() + "</td>";
			generatedHtml += "<td valign=\"top\">" + c.getLastName() + "</td>";
			generatedHtml += "<td valign=\"top\">" + c.getEmail() + "</td>";
		}
		if (a != null)
		{
			generatedHtml += "<td valign=\"top\">" + a.getStreet() + "</td>";
			generatedHtml += "<td valign=\"top\">" + a.getCity() + "</td>";
			generatedHtml += "<td valign=\"top\">" + a.getZip() + "</td>";
			generatedHtml += "<td valign=\"top\">" + a.getCountry()+ "</td>";
		}
		if (p != null)
		{
			generatedHtml += "<td valign=\"top\">" + p.getPhoneKind() + "</td>";
			generatedHtml += "<td valign=\"top\">" + p.getPhoneNumber() + "</td>";
		}
		if (cg != null)
		{
			generatedHtml += "<td valign=\"top\">" + cg.getGroupName() + "</td>";
		}
		
		generatedHtml += "</tr>";
		return generatedHtml;
	}
	static public String generateTable(Iterator ite, String header) {
		String generatedHtml = "";
		if (ite.hasNext()) {

			generatedHtml += "<div align=\"center\">";
			generatedHtml += "<br><br>";
			generatedHtml += "<table><tbody>";
			//generatedHtml += "<TABLE BORDER=\"1\">";
			generatedHtml += "<CAPTION><B>" + header + "</B> </CAPTION>";
			generatedHtml += generateRow("<B>ID</B>", "<B>First Name</B>", "<B>Last Name</B>", "<B>Email</B>", "<B>Street</B>", "<B>City</B>", "<B>Zip</B>", "<B>Country</B>", "<B>PhoneKind</B>", "<B>PhoneNumber</B>", "<B>GroupName</B>");
			while (ite.hasNext()) {
				Object[] list = (Object[]) ite.next();
				Contact contact = (Contact) list[0];
				Address address = (Address) list[1];
				PhoneNumber phoneNumber = (PhoneNumber)list[2];
				ContactGroup contactGroup = (ContactGroup)list[3];
				generatedHtml += generateRow(contact, address, phoneNumber, contactGroup);
				System.out.println();
			}
			generatedHtml += "</tbody></table>";
			generatedHtml += "</div>";
		}
		System.out.println("gen html" + generatedHtml);
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
	
	public static String opFait = "<i><b>operation est Fait</i></b>";
	public static String opNoRecods = "<i><b>Pas de records dans base de donées</i></b>";
	public static String opTableRemoved  = "<i><b>Table est effacé</i></b>";
}
