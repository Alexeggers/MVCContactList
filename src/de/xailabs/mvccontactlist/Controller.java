package de.xailabs.mvccontactlist;

import java.util.List;
import java.util.Vector;

public class Controller {

	private SQL connection;
	private SwingGUI view;

	public Controller(SwingGUI view, SQL connection) {
		this.view = view;
		this.connection = connection;
		view.setController(this);
	}

	public void start() {
		setTableData();
		view.buildGUI();
	}

	private void setTableData() {

		Vector<Vector<String>> dataVector = convertToTableVector(connection
				.getContacts());
		view.setTableData(dataVector);
	}

	private Vector<Vector<String>> convertToTableVector(List<Contact> contactList) {
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Vector<String> intermediaryVector;

		for (Contact contact : contactList) {
			intermediaryVector = new Vector<String>();
			intermediaryVector.add(String.valueOf(contact.getId()));
			intermediaryVector.add(contact.getName());
			intermediaryVector.add(contact.getPhonenumber());
			intermediaryVector.add(contact.getNotes());
			dataVector.add(intermediaryVector);
		}
		return dataVector;
	}

	public void deleteContact(Contact contact) {
		connection.deleteContact(contact);
		updateView();
	}

	public void updateView() {
		setTableData();
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
		view.setTableData(convertToTableVector(connection.searchForContact(searchParameter)));
		view.refreshTable();
	}
}
