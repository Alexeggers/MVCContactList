package de.xailabs.mvccontactlist;

import java.util.ArrayList;
import java.util.Vector;

public class Controller {
	
	private SQL connection;
	private View view;
	
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
	
	public ArrayList<Contact> getUpdatedContactsFromSQL() {
		ArrayList<Contact> contactArrayList = connection.getContacts();
		return contactArrayList;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void setSQL(SQL sql) {
		this.connection = sql;
	}
}
