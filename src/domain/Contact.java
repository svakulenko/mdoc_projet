package domain;

import java.util.HashSet;
import java.util.Set;



public class Contact {
	
	private long contactId;
	private String email;
	private String firstName;
	private String lastName;
	
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>(); 
	private Set<ContactGroup> contactgroup = new HashSet<ContactGroup>();;
	private Address address;
	
	public Contact()
	{
		contactId = -1;
    }
	

	
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<ContactGroup> getContactgroup() {
		return contactgroup;
	}
	public void setContactgroup(Set<ContactGroup> contactgroup) {
		this.contactgroup = contactgroup;
	}



	
	
	





	

}
