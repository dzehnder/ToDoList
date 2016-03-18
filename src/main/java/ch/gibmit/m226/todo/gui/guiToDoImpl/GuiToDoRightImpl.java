package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.gui.guiToDo.GuiToDo;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.util.Calendar;

/**
 * Created by colin on 16.03.16.
 */
public class GuiToDoRightImpl implements GuiToDo {

    private JPanel pnlToDoRight;
    private JPanel pnlToDoRightTop;
    private JPanel pnlToDoRightCenter;
    private JPanel pnlToDoRightCenterTop;
    private JPanel pnlToDoRightCenterTopLeft;
    private JPanel pnlToDoRightCenterTopRight;

    private JLabel lblTitle;
    private JTextField txtFldTitle;
    private JLabel lblDate;
    private JXDatePicker xdpDate;
    private Calendar cdrCalendar;
    private DateFormatter dfFormatter;
    private JSpinner jspSpinner;


    public GuiToDoRightImpl() {
        pnlToDoRight = new JPanel(new BorderLayout());
        pnlToDoRightTop = new JPanel(new BorderLayout());
        pnlToDoRightCenter = new JPanel(new BorderLayout());
        pnlToDoRightCenterTop = new JPanel(new GridLayout(1,2));
        pnlToDoRightCenterTopLeft = new JPanel(new BorderLayout());
        pnlToDoRightCenterTopRight = new JPanel(new BorderLayout());

        lblTitle = new JLabel("Titel:");
        pnlToDoRightTop.add(lblTitle, BorderLayout.WEST);
        txtFldTitle = new JTextField();
        pnlToDoRightTop.add(txtFldTitle, BorderLayout.CENTER);

        lblDate = new JLabel("Datum:");
        pnlToDoRightCenterTopLeft.add(lblDate, BorderLayout.WEST);
        xdpDate = new JXDatePicker();
        pnlToDoRightCenterTopLeft.add(xdpDate, BorderLayout.CENTER);
        pnlToDoRightCenterTop.add(pnlToDoRightCenterTopLeft, BorderLayout.WEST);

        cdrCalendar = Calendar.getInstance();
        cdrCalendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        cdrCalendar.set(Calendar.MINUTE, 0);
        cdrCalendar.set(Calendar.SECOND, 0);

        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(cdrCalendar.getTime());

        jspSpinner = new JSpinner(model);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jspSpinner, "HH:mm");
        dfFormatter = (DateFormatter)editor.getTextField().getFormatter();
        dfFormatter.setAllowsInvalid(false);
        dfFormatter.setOverwriteMode(true);

        jspSpinner.setEditor(editor);

        lblDate = new JLabel("Uhrzeit:");
        pnlToDoRightCenterTopRight.add(lblDate, BorderLayout.WEST);
        pnlToDoRightCenterTopRight.add(jspSpinner, BorderLayout.CENTER);
        pnlToDoRightCenterTop.add(pnlToDoRightCenterTopRight, BorderLayout.EAST);

        pnlToDoRightCenter.add(pnlToDoRightCenterTop, BorderLayout.NORTH);

        pnlToDoRight.add(pnlToDoRightTop, BorderLayout.NORTH);
        pnlToDoRight.add(pnlToDoRightCenter, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel() {
        return pnlToDoRight;
    }

}
