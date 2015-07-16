package de.xailabs.mvccontactlist;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6074235324460299227L;
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