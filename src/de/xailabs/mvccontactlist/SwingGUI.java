package de.xailabs.mvccontactlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SwingGUI implements View {
	private JFrame contactListWindow;
	private JPanel buttonPanel;
	private JPanel tablePanel;
	
	private JButton deleteContactButton;
	private JButton newContactButton;
	private JButton searchForContactButton;
	private JButton updateContactButton;
	private JButton viewAllContactsButton;
	
	private JTable contactTable;
	
	private static Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<String>> tableVector;
	
	@Override
	public void buildGUI() {
		columnNames.add("ID");
		columnNames.add("Name");
		columnNames.add("Phone Number");
		columnNames.add("Notes");
		contactListWindow = new JFrame("Contact List");
		contactListWindow.setLocationRelativeTo(null);
		contactListWindow.setBackground(Color.WHITE);
		contactListWindow.setBounds(0, 0, 1024, 768);
		
		buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(Color.WHITE);
		tablePanel = new JPanel();
		tablePanel.setBackground(Color.WHITE);
		
		deleteContactButton = new JButton("Delete Contact");
		deleteContactButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame deleteContactFrame = new JFrame("Delete Contact");
			}
		});
		newContactButton = new JButton("New Contact");
		searchForContactButton = new JButton("Search");
		updateContactButton = new JButton("Update Contact");
		viewAllContactsButton = new JButton("View all Contacts/Refresh Table");
		
		buttonPanel.add(deleteContactButton);
		buttonPanel.add(newContactButton);
		buttonPanel.add(searchForContactButton);
		buttonPanel.add(updateContactButton);
		buttonPanel.add(viewAllContactsButton);
		
		DefaultTableModel contactTableModel = new DefaultTableModel(tableVector, columnNames);
		contactTable = new JTable(contactTableModel);
		tablePanel.add(new JScrollPane(contactTable));
		
		contactListWindow.add(BorderLayout.NORTH, buttonPanel);
		contactListWindow.add(BorderLayout.CENTER, tablePanel);
		
		contactListWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactListWindow.setVisible(true);
	}

	@Override
	public void setTableVector(Vector<Vector<String>> tableVector) {
		this.tableVector = tableVector;
	}
}
