package de.xailabs.mvccontactlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class SwingGUI implements View {
	private JFrame contactListWindow;
	
	private JPanel buttonPanel;
	private JPanel tablePanel;
	
	private JButton deleteContactButton;
	private JButton newContactButton;
	private JButton searchForContactButton;
	private JButton updateContactButton;
	private JButton viewAllContactsButton;
	
	private ContactTable contactTable;
	private DefaultTableModel contactTableModel;
	
	private static Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<String>> tableData;
	
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
		
		buildButtons();
		
		buttonPanel.add(newContactButton);
		buttonPanel.add(searchForContactButton);
		buttonPanel.add(updateContactButton);
		buttonPanel.add(deleteContactButton);
		buttonPanel.add(viewAllContactsButton);
		
		contactTableModel = new DefaultTableModel(tableData, columnNames);
		contactTable = new ContactTable(contactTableModel);
		tablePanel.add(new JScrollPane(contactTable));
		
		contactListWindow.add(BorderLayout.NORTH, buttonPanel);
		contactListWindow.add(BorderLayout.CENTER, tablePanel);
		
		contactListWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactListWindow.setVisible(true);
	}

	@Override
	public void setTableData(Vector<Vector<String>> tableVector) {
		this.tableData = tableVector;
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public Contact buildSelectedContact() {
		int selectedRow = contactTable.getSelectedRow();
		Contact contact = new Contact(Integer.parseInt(tableData.get(selectedRow).get(0)), 
				tableData.get(selectedRow).get(1), tableData.get(selectedRow).get(2), 
				tableData.get(selectedRow).get(3));
		return contact;
	}
	
	public void refreshTable() {
		tablePanel.removeAll();
		tablePanel.revalidate();
		TableModel contactModel = new DefaultTableModel(tableData, columnNames);
		contactTable = new ContactTable(contactModel);
		contactTable.setBackground(Color.WHITE);
		JScrollPane tableContainer = new JScrollPane(contactTable);
		tablePanel.add(tableContainer);
	}
	
	public void buildButtons() {
		deleteContactButton = new JButton("Delete Contact");
		deleteContactButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contactTable.getSelectedRow() != -1) {
					controller.deleteContact(buildSelectedContact());
					refreshTable();
				}
			}
		});
		newContactButton = new JButton("New Contact");
		newContactButton.addActionListener(new NewContactSubclass());
		
		searchForContactButton = new JButton("Search");
		searchForContactButton.addActionListener(new SearchForContactSubclass());
		
		updateContactButton = new JButton("Update Contact");
		updateContactButton.addActionListener(new UpdateContactSubclass());
		
		viewAllContactsButton = new JButton("View all Contacts/Refresh Table");
		viewAllContactsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateView();
				refreshTable();
			}
		});
	}
	
	private class NewContactSubclass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			NewContactWindow newContactWindow = new NewContactWindow(contactListWindow, controller);
		}
	}
	
	private class SearchForContactSubclass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			SearchForContactWindow searchWindow = new SearchForContactWindow(contactListWindow, controller);
		}
	}
	
	private class UpdateContactSubclass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(contactTable.getSelectedRow() != -1) {
				@SuppressWarnings("unused")
				UpdateContactWindow updateWindow = new UpdateContactWindow(contactListWindow, controller, contactTable.getSelectedRow(), tableData);
			}
		}
	}
}
