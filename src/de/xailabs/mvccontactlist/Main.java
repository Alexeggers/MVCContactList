package de.xailabs.mvccontactlist;

public class Main {

	public static void main(String[] args) {
		
		SwingGUI GUI = new SwingGUI();
		SQL connection = new SQL();
		Controller controller = new Controller(GUI, connection);
		GUI.setController(controller);
		GUI.buildGUI();
	}
}
