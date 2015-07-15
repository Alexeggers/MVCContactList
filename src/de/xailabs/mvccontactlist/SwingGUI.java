package de.xailabs.mvccontactlist;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.*;

public class SwingGUI implements View {
	private JFrame contactListWindow;
	private JPanel buttonPanel;
	private JPanel tablePanel;
	
	private JButton newContactButton;
	private JButton updateContactButton;
	private JButton searchForContactButton;
	private JButton viewAllContactsButton;
	
	public SwingGUI() {
		contactListWindow = new JFrame("Contact List");
		contactListWindow.setLocationRelativeTo(null);
		
		buttonPanel = new JPanel(new FlowLayout());
		tablePanel = new JPanel();
		
		buttonPanel.add(newContactButton);
		buttonPanel.add(updateContactButton);
		buttonPanel.add(searchForContactButton);
		buttonPanel.add(viewAllContactsButton);
		
		contactListWindow.add(BorderLayout.NORTH, buttonPanel);
		contactListWindow.add(BorderLayout.CENTER, tablePanel);
	}

	@Override
	public void setController(Controller controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Contact> getUpdatedContacts() {
		// TODO Auto-generated method stub
		return null;
	}
}
