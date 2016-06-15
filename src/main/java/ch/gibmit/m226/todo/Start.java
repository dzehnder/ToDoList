package ch.gibmit.m226.todo;

/**
* @author Damian Zehdner
 *
*/

import ch.gibmit.m226.todo.gui.GuiMainImpl;

import javax.swing.*;

public class Start {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		System.getProperties().put("apple.laf.useScreenMenuBar", "true");
		new GuiMainImpl();
	}
	
	public static void update(Object categoryDAO, Object toDoDAO, String fileToOpen) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		System.getProperties().put("apple.laf.useScreenMenuBar", "true");
		new GuiMainImpl(categoryDAO, toDoDAO, fileToOpen);
	}

}