package de.xailabs.mvccontactlist;

import java.util.ArrayList;
import java.util.Vector;

public class Controller {
	
	private SQL connection;
	private View view;
	private ArrayList<Contact> contactContainer;
	private Vector<Vector<String>> tableVector;
	
	public Controller(View view, SQL connection) {
		this.view = view;
		this.connection = connection;
		getUpdatedContactsFromSQL();
		convertToTableVector();
		updateTableData(tableVector);
	}
	
	public void convertToTableVector() {
		tableVector = new Vector<Vector<String>>();
		Vector<String> intermediaryVector;
		
		for(Contact contact : contactContainer) {
			intermediaryVector = new Vector<String>();
			intermediaryVector.add(String.valueOf(contact.getId()));
			intermediaryVector.add(contact.getName());
			intermediaryVector.add(contact.getPhonenumber());
			intermediaryVector.add(contact.getNotes());
			tableVector.add(intermediaryVector);
		}
	}
	
	public void getUpdatedContactsFromSQL() {
		contactContainer = connection.getContacts();
	}
	
	public void setView(View view) {
		this.view = view;
	} 
	
	public void setSQL(SQL sql) {
		this.connection = sql;
	}
	
	public void deleteContact(Contact contact) {
		connection.deleteContact(contact);
		getUpdatedContactsFromSQL();
		convertToTableVector();
		updateTableData(tableVector);
	}
	
	public void updateTableData(Vector<Vector<String>> tableVector) {
		view.setTableData(tableVector);
	}
	
}
