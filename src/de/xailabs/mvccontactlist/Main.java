package de.xailabs.mvccontactlist;

public class Main {

	public static void main(String[] args) {
		View view = new SwingGUI();
		SQL connection = new SQL();
		Controller controller = new Controller(view, connection);
		view.buildGUI();
	}
}
