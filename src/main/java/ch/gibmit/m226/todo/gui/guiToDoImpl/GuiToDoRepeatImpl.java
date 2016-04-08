package ch.gibmit.m226.todo.gui.guiToDoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel pnlRepeaterBottom;
    private JLabel lblRepetition;
    private JSpinner spnrTime;
    private JLabel lblRate;
    private JButton btnOk;
    private JButton btnCancel;
    private JCheckBox[] chbxWeekdays = new JCheckBox[WEEKDAYS.length];
    private JComboBox<String> cmbxRepeatRate;
    private JComboBox<String> cmbxEndDate;


    /**
     * constructor sets up the dialog, according to the selected repeater options
     */
    public GuiToDoRepeatImpl() {

        dlgRepeater = new JDialog();
        btnOk = new JButton("Ok");
        dlgRepeater.getRootPane().setDefaultButton(btnOk);
        btnOk.isDefaultButton();
        btnCancel = new JButton("Cancel");
        cmbxEndDate = new JComboBox<>(new String[]{"No end date", "End by date: "});

        for (int i = 0; i < chbxWeekdays.length; i++) {
            chbxWeekdays[i] = new JCheckBox(WEEKDAYS[i]);
        }

        setUpPanels();
        setUpComponents();
        updateContentToSelection();

        dlgRepeater.setTitle("Repeater options");
        //setResizable(false);
        dlgRepeater.setSize(new Dimension(300, 200));
        dlgRepeater.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dlgRepeater.setModal(true);
        dlgRepeater.setVisible(true);
    }

    /**
     * creates and adds all panels in the dialog window
     */
    private void setUpPanels() {
        pnlRepeater = new JPanel(new BorderLayout());
        pnlRepeaterCenter = new JPanel();
        pnlRepeaterBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        dlgRepeater.add(pnlRepeater);
        pnlRepeater.add(pnlRepeaterBottom, BorderLayout.PAGE_END);
        pnlRepeater.add(pnlRepeaterCenter);
    }

    /**
     * creates and adds all components to the dialog window
     */
    private void setUpComponents() {
        cmbxRepeatRate = new JComboBox<>();
        lblRepetition = new JLabel("Every: ");
        spnrTime = new JSpinner();
        lblRate = new JLabel();

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
        pnlRepeaterCenter.setLayout(new FlowLayout());
        pnlRepeaterCenter.add(lblRepetition);
        pnlRepeaterCenter.add(spnrTime);
        pnlRepeaterCenter.add(lblRate);
        //pnlRepeaterCenter.add(cmbxEndDate, BorderLayout.PAGE_END);

        pnlRepeaterCenter.repaint();
    }

    /**
     * removes the necessary components for the day, month and year repeat rate
     */
    private void removeComponents() {
        pnlRepeaterCenter.removeAll();
        pnlRepeaterCenter.repaint();
    }

    private void placeWeekComponents() {
        pnlRepeaterCenter.setLayout(new BoxLayout(pnlRepeaterCenter, BoxLayout.PAGE_AXIS));
        for (JCheckBox chbxWeekday : chbxWeekdays) {
            pnlRepeaterCenter.add(chbxWeekday, Component.CENTER_ALIGNMENT);
        }
        pnlRepeaterCenter.revalidate();
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
     * Handles the actions performed in the dialog
     *
     * @param e the fired action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cmbxRepeatRate) {
            updateContentToSelection();
        }

    }
}
