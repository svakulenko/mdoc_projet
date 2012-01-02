package domain;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {

	long groupId;
	String groupName;
	Set<Contact> contacts = new HashSet<Contact>();

	public ContactGroup() {
	};

	public ContactGroup(String groupName)
	{
		this.groupName = groupName;
	}
	
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
