package de.xailabs.mvccontactlist;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame {
	
	Contact contact;
	
	public ButtonFrame() {
		super();
		this.setBounds(200, 200, 400, 200);
	}
	
	public ButtonFrame(String frameTitle) {
		super(frameTitle);
	}
	
	public ButtonFrame(Contact contact) {
		this();
		this.contact = contact;
	}
	
	public ButtonFrame(String frameTitle, Contact contact) {
		this(frameTitle);
		this.contact = contact;
	}
}