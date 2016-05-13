package ch.gibmit.m226.todo; /**
								* Created by zehnder on 27/01/16.
								*/

import java.awt.GraphicsConfiguration;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		ObjectInputStream oin;
		Object categoryDAO = null;
		Object toDoDAO = null;
		try {
			oin = new ObjectInputStream(new FileInputStream("output.bin"));
			categoryDAO = oin.readObject();
			toDoDAO = oin.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		new GuiMainImpl(categoryDAO, toDoDAO);
	}

}