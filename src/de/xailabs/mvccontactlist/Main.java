package de.xailabs.mvccontactlist;

public class Main {

	public static void main(String[] args) {
		Contact model = new Contact("Test", "Test", "Test");
		SQL sql = new SQL();
		sql.addNewContact(model);
	}
}
