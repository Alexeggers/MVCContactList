package de.xailabs.mvccontactlist;

import java.util.Vector;


public interface View {
	public void setTableVector(Vector<Vector<String>> tableVector);
	public void buildGUI();
	public void setController(Controller controller);
}