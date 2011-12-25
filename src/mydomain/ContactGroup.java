package mydomain;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {

	ContactGroup(){
		
	};
	long groupId = 0;
	String  groupName;
	Set<Contact> contacts = new HashSet<Contact>();
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}


	
	
}
