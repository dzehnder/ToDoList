package ch.gibmit.m226.todo;

/**
 * @author Damian Zehdner
 * Starter class initializes the main gui and sets the look and feel.
*/

import ch.gibmit.m226.todo.gui.GuiMainImpl;

import javax.swing.*;

public class Start {

	/**
	 * set the look and feel to the system look and feel.
	 * Initializes the main gui.
	 * @param args system arguments
     */
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

	/**
	 * Set the look and feel to the system look and feel.
	 * Initialize the main gui, with existing todos.
	 * @param categoryDAO the category data access object
	 * @param toDoDAO the todo data access object
	 * @param fileToOpen filepath, to the file, which contains the existing todos.
     */
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