package de.xailabs.mvccontactlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {
	
	private Connection connection = null;
    private Statement stmt = null;
	
	public SQL () {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:database/ContactList.sqlite");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
	    }
	}
	
	public ArrayList<Contact> getContacts() {
		ResultSet rs = executeQuery("SELECT * FROM CONTACTS;");
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			while(rs.next()) {
				String id = Integer.toString(rs.getInt("ID"));
				String name = rs.getString("Name");
				String number = rs.getString("Phonenumber");
				String notes = rs.getString("Notes");
				Contact contact = new Contact(id, name, number, notes);
				contacts.add(contact);
			}
		} catch(SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return contacts;
	}
	
	public ArrayList<Contact> searchForContact(String searchParameter) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM CONTACTS WHERE Name LIKE '%");
		sb.append(searchParameter);
		sb.append("%' or Notes LIKE '%");
		sb.append(searchParameter);
		sb.append("%';");
		ResultSet rs = executeQuery(sb.toString());
		ArrayList<Contact> foundContacts = new ArrayList<Contact>();
		try {
			while(rs.next()) {
				String id = Integer.toString(rs.getInt("ID"));
				String name = rs.getString("Name");
				String number = rs.getString("Phonenumber");
				if (number == null) {
					number = "";
				}
				String notes = rs.getString("Notes");
				Contact contact = new Contact(id, name, number, notes);
				foundContacts.add(contact);
			}
		} catch(SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("hi");
		return foundContacts;
	}
	
	public void addNewContact(Contact contact) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CONTACTS (Name, Phonenumber, Notes) VALUES ('");
		sb.append(contact.getName());
		sb.append("', '");
		sb.append(contact.getPhonenumber());
		sb.append("', '");
		sb.append(contact.getNotes());
		sb.append("');");
		executeUpdate(sb.toString());
	}
	
	public void updateContact(Contact contact) {
		StringBuilder sb = new StringBuilder();
			sb.append("UPDATE CONTACTS SET Name = '");
			sb.append(contact.getName());
			sb.append("', Phonenumber = '");
			sb.append(contact.getPhonenumber());
			sb.append("', Notes = '");
			sb.append(contact.getNotes());
			sb.append("' WHERE ID = ");
			sb.append(contact.getId());
			executeUpdate(sb.toString());
	}
	
	public boolean deleteContact(Contact contact) {
		boolean deleted = executeUpdate("DELETE FROM CONTACTS WHERE ID = " + contact.getId() + ";");
		return deleted;
	}
	
	public boolean executeUpdate(String sql) {
		boolean executed = true;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			executed = false;
		}
		return executed;
	}
	
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch(SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return rs;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch(Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
}