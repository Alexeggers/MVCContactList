package de.xailabs.mvccontactlist;

import java.util.ArrayList;
import java.util.Vector;

public class Controller {
	
	private SQL connection;
	private SwingGUI view;
	
	public Controller(SwingGUI view, SQL connection) {
		this.view = view;
		this.connection = connection;
	}
	
	public void start() {
		view.setController(this);
		convertToTableVector(connection.getContacts());
		view.buildGUI();
	}
	
	public void convertToTableVector(ArrayList<Contact> dataArrayList) {
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Vector<String> intermediaryVector; 
		
		for(Contact contact : dataArrayList) {
			intermediaryVector = new Vector<String>();
			intermediaryVector.add(String.valueOf(contact.getId()));
			intermediaryVector.add(contact.getName());
			intermediaryVector.add(contact.getPhonenumber());
			intermediaryVector.add(contact.getNotes());
			dataVector.add(intermediaryVector);
		}
		view.setTableData(dataVector);
	}
	
	public void setView(SwingGUI view) {
		this.view = view;
	} 
	
	public void setSQL(SQL sql) {
		this.connection = sql;
	}
	
	public void deleteContact(Contact contact) {
		connection.deleteContact(contact);
		updateView();
	}
		
	public void updateView() {
		convertToTableVector(connection.getContacts());
		view.refreshTable();
	}
	
	public void newContact(Contact contact) {
		connection.addNewContact(contact);
		updateView();
	}
	
	public void updateContact(Contact contact) {
		connection.updateContact(contact);
		updateView();
	}
	
	public void searchContact(String searchParameter) {
		connection.searchForContact(searchParameter);
		convertToTableVector(connection.searchForContact(searchParameter));
		view.refreshTable();
	}
}
