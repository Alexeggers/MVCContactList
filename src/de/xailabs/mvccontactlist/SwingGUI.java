package de.xailabs.mvccontactlist;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.*;

public class SwingGUI implements View {
	private JFrame contactListWindow;
	private JPanel buttonPanel;
	private JPanel tablePanel;
	
	private JButton deleteContactButton;
	private JButton newContactButton;
	private JButton searchForContactButton;
	private JButton updateContactButton;
	private JButton viewAllContactsButton;
	
	
	private Vector<Vector<String>> tableVector;
	
	private Controller controller;
	
	public SwingGUI() {
		contactListWindow = new JFrame("Contact List");
		contactListWindow.setLocationRelativeTo(null);
		
		buttonPanel = new JPanel(new FlowLayout());
		tablePanel = new JPanel();
		
		buttonPanel.add(deleteContactButton);
		buttonPanel.add(newContactButton);
		buttonPanel.add(searchForContactButton);
		buttonPanel.add(updateContactButton);
		buttonPanel.add(viewAllContactsButton);
		
		contactListWindow.add(BorderLayout.NORTH, buttonPanel);
		contactListWindow.add(BorderLayout.CENTER, tablePanel);
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void updateContacts(Vector<Vector<String>> tableVector) {
		this.tableVector = tableVector;
	}
}
