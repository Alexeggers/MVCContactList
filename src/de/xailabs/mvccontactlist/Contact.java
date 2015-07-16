package de.xailabs.mvccontactlist;

public class Contact {
	private int id;
	private String name;
	private String phonenumber;
	private String notes;
	
	public Contact(int id, String name, String phonenumber, String notes) {
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.notes = notes;
	}
	
	public Contact(String name, String phonenumber, String notes) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.notes = notes;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhonenumber(String phonenumber) {
		if(phonenumber == null) {
			this.phonenumber = "";
		} else {
			this.phonenumber = phonenumber;
		}
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}