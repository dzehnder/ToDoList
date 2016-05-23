package ch.gibmit.m226.todo; /**
								* Created by zehnder on 27/01/16.
								*/

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.ToDoDAO;
import ch.gibmit.m226.todo.gui.GuiMainImpl;

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