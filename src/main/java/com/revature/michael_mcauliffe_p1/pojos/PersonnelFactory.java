package com.revature.michael_mcauliffe_p1.pojos;

public class PersonnelFactory {

	public Personnel getPersonnel(String personnelType) {
		
		switch (personnelType.toUpperCase()) {
		
		case "EMPLOYEE":
			return new Employee();
		
		case "MANAGER":
			return new Manager();
		
		default:
			return null;
		}
	}
}
