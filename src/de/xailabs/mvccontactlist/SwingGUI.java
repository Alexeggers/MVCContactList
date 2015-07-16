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
	
	private Controller controller;
	
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
				
			}
		});
		newContactButton = new JButton("New Contact");
		newContactButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonFrame newContactFrame = new ButtonFrame("New Contact");
			}
		});
		searchForContactButton = new JButton("Search");
		searchForContactButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonFrame searchForContactFrame = new ButtonFrame("Search for Contact");
			}
		});
		updateContactButton = new JButton("Update Contact");
		updateContactButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonFrame updateContactFrame = new ButtonFrame("Update Contact");
			}
		});
		viewAllContactsButton = new JButton("View all Contacts/Refresh Table");
		viewAllContactsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
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

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
}
