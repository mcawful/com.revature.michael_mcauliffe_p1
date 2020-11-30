package com.revature.michael_mcauliffe_p1.pojos;

public class Person extends AbstractPerson implements Contact {

	private String firstName, lastName, address, city, state, postalCode, phoneNumber, email;

	public Person() {

		super();

		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.phoneNumber = "";
		this.email = "";
		this.postalCode = "";
	}

	public Person(String firstName, String lastName, String address, String city, String state, String postalCode,
			String phoneNumber, String email) {

		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.postalCode = postalCode;
	}

	@Override
	public String getPhoneNumber() {

		return this.phoneNumber;
	}

	@Override
	public String getEmail() {

		return this.email;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

	@Override
	public void setEmail(String email) {

		this.email = email;
	}

	@Override
	public String getFirstName() {

		return this.firstName;
	}

	@Override
	public String getLastName() {

		return this.lastName;
	}

	@Override
	public String getAddress() {

		return this.address;
	}

	@Override
	public String getCity() {

		return this.city;
	}

	@Override
	public String getState() {

		return this.state;
	}

	@Override
	public String getPostalCode() {

		return this.postalCode;
	}

	@Override
	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	@Override
	public void setAddress(String address) {

		this.address = address;
	}

	@Override
	public void setCity(String city) {

		this.city = city;
	}

	@Override
	public void setState(String state) {

		this.state = state;
	}

	@Override
	public void setPostalCode(String postalCode) {

		this.postalCode = postalCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "]";
	}

}
