package ch.gibmit.m226.todo.gui.guiToDoImpl;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Damian Zehnder
 * This class generates the repeater settings - dialog
 */


public class GuiToDoRepeatImpl extends JFrame implements ActionListener {

    private static final String[] REPEATRATES = {"Never", "Daily", "Weekly", "Monthly", "Yearly"};
    private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    private JDialog dlgRepeater;
    private JPanel pnlRepeater;
    private JPanel pnlRepeaterCenter;
    private JPanel pnlRepeaterCenterComp;
    private JPanel pnlRepeaterBottom;
    private JPanel pnlRepeaterUntilDate;
    private JLabel lblRepetition;
    private JSpinner spnrTime;
    private JLabel lblRate;
    private JButton btnOk;
    private JButton btnCancel;
    private JCheckBox[] chbxWeekdays = new JCheckBox[WEEKDAYS.length];
    private JComboBox<String> cmbxRepeatRate;
    private JComboBox<String> cmbxEndDate;
    private JXDatePicker xdpEndDate;


    /**
     * constructor sets up the dialog, according to the selected repeater options
     */
    public GuiToDoRepeatImpl() {

        dlgRepeater = new JDialog();

        btnOk = new JButton("Ok");
        dlgRepeater.getRootPane().setDefaultButton(btnOk);
        btnOk.isDefaultButton();
        btnOk.addActionListener(this);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(this);

        cmbxEndDate = new JComboBox<>(new String[]{"No end date", "End by date: "});
        cmbxEndDate.addActionListener(this);

        for (int i = 0; i < chbxWeekdays.length; i++) {
            chbxWeekdays[i] = new JCheckBox(WEEKDAYS[i]);
        }

        setUpPanels();
        setUpComponents();
        updateContentToSelection();

        dlgRepeater.setTitle("Repeater options");
        setResizable(false);
        dlgRepeater.setSize(new Dimension(300, 160));
        dlgRepeater.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dlgRepeater.setModal(true);
        dlgRepeater.setVisible(true);
        dlgRepeater.setResizable(false);
    }

    /**
     * creates and adds all panels in the dialog window
     */
    private void setUpPanels() {
        pnlRepeater = new JPanel(new BorderLayout());
        pnlRepeaterCenter = new JPanel(new BorderLayout());
        pnlRepeaterBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlRepeaterCenterComp = new JPanel();
        pnlRepeaterUntilDate = new JPanel(new BorderLayout());

        dlgRepeater.add(pnlRepeater);
        pnlRepeater.add(pnlRepeaterBottom, BorderLayout.PAGE_END);
        pnlRepeater.add(pnlRepeaterCenter, BorderLayout.CENTER);
        pnlRepeaterCenter.add(pnlRepeaterCenterComp, BorderLayout.CENTER);
        pnlRepeaterCenter.add(pnlRepeaterUntilDate, BorderLayout.PAGE_END);
    }

    /**
     * creates and adds all components to the dialog window
     */
    private void setUpComponents() {
        cmbxRepeatRate = new JComboBox<>();
        lblRepetition = new JLabel("Every: ");
        spnrTime = new JSpinner();
        spnrTime.setPreferredSize(new Dimension(55, 20));
        lblRate = new JLabel();
        xdpEndDate = new JXDatePicker();

        placeComponents();

        for (String rep : REPEATRATES) {
            cmbxRepeatRate.addItem(rep);
        }

        cmbxRepeatRate.addActionListener(this);
        pnlRepeater.add(cmbxRepeatRate, BorderLayout.PAGE_START);

        pnlRepeaterBottom.add(btnCancel);
        pnlRepeaterBottom.add(btnOk);
    }

    /**
     * adds the necessary components for the day, month and year repeat rate
     */
    private void placeComponents() {
        pnlRepeaterCenterComp.setLayout(new FlowLayout());
        pnlRepeaterCenterComp.add(lblRepetition);
        pnlRepeaterCenterComp.add(spnrTime);
        pnlRepeaterCenterComp.add(lblRate);
        pnlRepeaterUntilDate.add(cmbxEndDate, BorderLayout.LINE_START);

        updateRepeatDateToSelection();
        pnlRepeaterUntilDate.repaint();
        pnlRepeaterCenterComp.repaint();
    }

    /**
     * removes the necessary components for the day, month and year repeat rate
     */
    private void removeComponents() {
        pnlRepeaterCenterComp.removeAll();
        pnlRepeaterCenterComp.repaint();
        pnlRepeaterUntilDate.removeAll();
        pnlRepeaterUntilDate.repaint();

        dlgRepeater.setMinimumSize(new Dimension(300, 160));
        dlgRepeater.setSize(new Dimension(300, 160));
    }

    /**
     * places the weekday-checkboxes in the center of the dialog
     */
    private void placeWeekComponents() {
        pnlRepeaterCenterComp.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel fillLeft = new JPanel();
        fillLeft.setPreferredSize(new Dimension(dlgRepeater.getWidth()/3, 1));
        c.gridx = 0;
        c.gridy = 0;
        pnlRepeaterCenterComp.add(fillLeft, c);

        JPanel fillRight = new JPanel();
        fillRight.setPreferredSize(new Dimension(dlgRepeater.getWidth()/3, 1));
        c.gridx = 2;
        c.gridy = 0;
        pnlRepeaterCenterComp.add(fillRight, c);

        for (int i = 0; i < chbxWeekdays.length; i++) {
            JCheckBox chbxWeekday = chbxWeekdays[i];
            c.gridx = 1;
            c.gridy = i;
            c.anchor = GridBagConstraints.LINE_START;
            pnlRepeaterCenterComp.add(chbxWeekday, c);
        }
        pnlRepeaterUntilDate.add(cmbxEndDate, BorderLayout.LINE_START);
        updateRepeatDateToSelection();
        dlgRepeater.setMinimumSize(new Dimension(300, 300));

        pnlRepeaterUntilDate.repaint();
        pnlRepeaterCenterComp.revalidate();

    }


    /**
     * removes or adds the components needed for the selected repeat rate
     */
    private void updateContentToSelection() {
        switch (cmbxRepeatRate.getSelectedIndex()) {
            case 0:
                removeComponents();
                break;
            case 1:
                removeComponents();
                placeComponents();
                lblRate.setText("Day(s)");
                break;
            case 2:
                removeComponents();
                placeWeekComponents();
                break;
            case 3:
                removeComponents();
                placeComponents();
                lblRate.setText("Month(s)");
                break;
            case 4:
                removeComponents();
                placeComponents();
                lblRate.setText("Year(s)");
        }
    }

    /**
     * adds or removes the until date-picker according to the selected option
     */
    private void updateRepeatDateToSelection() {
        switch (cmbxEndDate.getSelectedIndex()) {
            case 0:
                pnlRepeaterUntilDate.remove(xdpEndDate);
                pnlRepeaterUntilDate.revalidate();
                break;
            case 1:
                pnlRepeaterUntilDate.add(xdpEndDate, BorderLayout.CENTER);
                pnlRepeaterUntilDate.revalidate();
        }
    }

    /**
     * Handles the actions performed in the dialog
     *
     * @param e the fired action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cmbxRepeatRate) {
            updateContentToSelection();
        }
        if (e.getSource() == this.cmbxEndDate) {
            updateRepeatDateToSelection();
        }
        if (e.getSource() == this.btnCancel) {
            dlgRepeater.dispose();
        }
        if (e.getSource() == this.btnOk) {
            // do stuff
        }

    }
}
