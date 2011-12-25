package mydomain;

import java.util.HashSet;
import java.util.Set;



public class Contact {
	public Contact(){ 
    	id = -1;
    }
	long   id;
	String email;
	String firstName;
	String lastName;
	
	Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>(); 
	Set<ContactGroup> contactgroup = new HashSet<ContactGroup>();;
	Address add;
	public Address getAdd() {
		return add;
		
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
