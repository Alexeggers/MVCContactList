package de.xailabs.mvccontactlist;

import java.util.Vector;

public class Controller {
	
	SQL connection = new SQL();
	
	public Vector<Vector<String>> convertToTableVector(Vector<Contact> contactVector) {
		Vector<Vector<String>> tableVector = new Vector<Vector<String>>();
		Vector<String> intermediaryVector;
		
		for(Contact contact : contactVector) {
			intermediaryVector = new Vector<String>();
			intermediaryVector.add(contact.getId());
			intermediaryVector.add(contact.getName());
			intermediaryVector.add(contact.getPhonenumber());
			intermediaryVector.add(contact.getNotes());
			tableVector.add(intermediaryVector);
		}
		return tableVector;
	}
}
