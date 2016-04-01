package ch.gibmit.m226.todo; /**
 * Created by zehnder on 27/01/16.
 */

import ch.gibmit.m226.todo.gui.*;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        new GuiMainImpl();
    }

}