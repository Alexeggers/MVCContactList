package de.xailabs.mvccontactlist;

import java.util.Vector;


public interface View {
	public void setController(Controller controller);
	public void updateContacts(Vector<Vector<String>> tableVector);
}