package de.xailabs.mvccontactlist;

import java.util.ArrayList;
import java.util.Vector;

public class Controller {
	
	private SQL connection;
	private SwingGUI view;
	private ArrayList<Contact> contactContainer;
	private Vector<Vector<String>> tableVector;
	
	public Controller(SwingGUI view, SQL connection) {
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
	
	public void convertToTableVector(ArrayList<Contact> foundContacts) {
		tableVector = new Vector<Vector<String>>();
		Vector<String> intermediaryVector;
		
		for(Contact contact : foundContacts) {
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
	
	public void updateTableData(Vector<Vector<String>> tableVector) {
		view.setTableData(tableVector);
	}
	
	public void updateView() {
		getUpdatedContactsFromSQL();
		convertToTableVector();
		updateTableData(tableVector);
		view.refreshTable(tableVector);
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
		ArrayList<Contact> foundContacts = connection.searchForContact(searchParameter);
		convertToTableVector();
		updateTableData(tableVector);
		view.refreshTable(tableVector);
	}
}
