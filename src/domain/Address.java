package domain;

//ADRESS INNER CLASS START
public class Address 
{
	long addressId;
	String street;
	String city;
	String zip;
	String country;
	public Address() {}
	
	
	public long getAddressId() {
		return addressId;
	}


	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		result.append("Id: " + this.addressId + "\n");
		result.append("Street: " + this.street + "\n");
		result.append("City: " + this.city + "\n");
		result.append("Zip: " + this.zip + "\n");
		result.append("Country: " + this.country + "\n");
		return result.toString();
	}
}
// ADRESS INNER CLASS END
