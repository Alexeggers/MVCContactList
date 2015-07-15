package de.xailabs.mvccontactlist;

public class Contact {
	
	private String id;
	private String name;
	private String phonenumber;
	private String notes;
	
	public Contact(String id, String name, String phonenumber, String notes) {
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
	
	public String getId() {
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
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setId(int id) {
		this.id = Integer.toString(id);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
