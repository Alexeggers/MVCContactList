package de.xailabs.mvccontactlist;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		View view = new SwingGUI();
		SQL connection = new SQL();
		controller.setView(view);
		controller.setSQL(connection);
	}
}
