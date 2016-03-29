package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import org.jdesktop.swingx.JXDatePicker;

import ch.gibmit.m226.todo.gui.gui.GuiPanel;

/**
 * Created by colin on 16.03.16.
 */
public class GuiToDoRightImpl implements GuiPanel {

	private JPanel pnlToDoRight;
	private JPanel pnlToDoRightTop;
	private JPanel pnlToDoRightCenter;
	private JPanel pnlToDoRightCenterTopLeft;
	private JPanel pnlToDoRightCenterTopLeftTop;
	private JPanel pnlToDoRightCenterTopRight;
	private JPanel pnlToDoRightCenterTopRightTop;
	private JPanel pnlToDoRightCenterTopRightBottom;
	private JPanel pnlToDoRightCenterBottomLeft;
	private JPanel pnlToDoRightCenterBottomRight;
	private JPanel pnlToDoRightCenterBottomLeftTop;
	private JPanel pnlToDoRightCenterBottomLeftMid;
	private JPanel pnlToDoRightCenterBottomLeftBottom;

	private JLabel lblTitle;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblRepeat;
	private JLabel lblCategory;
	private JLabel lblPriority;
	private JLabel lblDone;

	private JButton btnRepeat;
	private JTextField txtFldTitle;
	private JXDatePicker xdpDate;
	private Calendar cdrCalendar;
	private DateFormatter dfFormatter;
	private JSpinner jspTime;
	private JSpinner.DateEditor editor;
	private SpinnerDateModel model;
	private JComboBox<String> cmbxCategory;
	private JSlider sldrPriority;
	private Hashtable<Integer, JLabel> hstbl;
	private JCheckBox chbxDone;
	private JTextArea txtAraNotes;

	private static final int MIN_PRIO = 5;
	private static final int MAX_PRIO = 1;

	public GuiToDoRightImpl() {

		setUpPanels();

		setUpComponents();

		placeComponents();

	}

	private void setUpPanels() {
		pnlToDoRight = new JPanel(new BorderLayout());
		pnlToDoRight.setBorder(new EmptyBorder(30, 30, 30, 30));
		pnlToDoRightTop = new JPanel(new BorderLayout());
		pnlToDoRightCenter = new JPanel(new GridLayout(2, 2));

		pnlToDoRightCenterTopLeft = new JPanel(new BorderLayout());
		pnlToDoRightCenterTopLeft.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlToDoRightCenterTopLeftTop = new JPanel(new GridLayout(1, 2));
		pnlToDoRightCenterTopRight = new JPanel(new GridLayout(2, 1));
		pnlToDoRightCenterTopRight.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlToDoRightCenterTopRightTop = new JPanel(new GridLayout(1, 2));
		pnlToDoRightCenterTopRightBottom = new JPanel(new GridLayout(1, 2));
		pnlToDoRightCenterBottomLeft = new JPanel(new GridLayout(3, 1));
		pnlToDoRightCenterBottomLeft.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlToDoRightCenterBottomLeftTop = new JPanel(new BorderLayout());
		pnlToDoRightCenterBottomLeftMid = new JPanel(new BorderLayout());
		pnlToDoRightCenterBottomLeftBottom = new JPanel(new BorderLayout());
		pnlToDoRightCenterBottomRight = new JPanel(new BorderLayout());
		pnlToDoRightCenterBottomRight.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlToDoRightCenterBottomRight.setBorder(new EmptyBorder(10, 30, 10, 30));
	}

	private void setUpComponents() {
		cdrCalendar = Calendar.getInstance();
		cdrCalendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
		cdrCalendar.set(Calendar.MINUTE, 0);

		model = new SpinnerDateModel();
		model.setValue(cdrCalendar.getTime());

		jspTime = new JSpinner(model);

		editor = new JSpinner.DateEditor(jspTime, "HH:mm");
		dfFormatter = (DateFormatter) editor.getTextField().getFormatter();
		dfFormatter.setAllowsInvalid(false);
		dfFormatter.setOverwriteMode(true);

		jspTime.setEditor(editor);

		// Create the slider
		sldrPriority = new JSlider(JSlider.HORIZONTAL, MAX_PRIO, MIN_PRIO, 3);
		// sldrPriority.addChangeListener(this);
		sldrPriority.setMajorTickSpacing(10);
		sldrPriority.setPaintTicks(true);

		// Create the label table
		hstbl = new Hashtable<Integer, JLabel>();
		hstbl.put(new Integer(MIN_PRIO), new JLabel("Unwichtig"));
		hstbl.put(new Integer(MAX_PRIO), new JLabel("Sehr wichtig"));
		sldrPriority.setLabelTable(hstbl);
		sldrPriority.setPaintLabels(true);

		lblTitle = new JLabel("Titel:");
		lblDate = new JLabel("Datum:");
		lblTime = new JLabel("Uhrzeit:");
		lblRepeat = new JLabel("---");
		lblCategory = new JLabel("Kategorie:");
		lblPriority = new JLabel("Priorit�t:");
		lblDone = new JLabel("Erledigt:");

		txtFldTitle = new JTextField();
		xdpDate = new JXDatePicker();
		btnRepeat = new JButton("Wiederholen");
		cmbxCategory = new JComboBox<String>();
		cmbxCategory.addItem("testkat 1");
		cmbxCategory.addItem("testkat 2");
		chbxDone = new JCheckBox();
		txtAraNotes = new JTextArea();
		txtAraNotes.setText("Notiz..");
		txtAraNotes.setBackground(Color.YELLOW);
	}

	private void placeComponents() {
		pnlToDoRightTop.add(lblTitle, BorderLayout.WEST);
		pnlToDoRightTop.add(txtFldTitle, BorderLayout.CENTER);

		pnlToDoRightCenterTopLeftTop.add(lblDate, BorderLayout.WEST);
		pnlToDoRightCenterTopLeftTop.add(xdpDate, BorderLayout.CENTER);
		pnlToDoRightCenterTopLeft.add(pnlToDoRightCenterTopLeftTop);
		pnlToDoRightCenter.add(pnlToDoRightCenterTopLeft);

		pnlToDoRightCenterTopRightTop.add(lblTime);
		pnlToDoRightCenterTopRightTop.add(jspTime);
		pnlToDoRightCenterTopRight.add(pnlToDoRightCenterTopRightTop);
		pnlToDoRightCenterTopRightBottom.add(btnRepeat);
		pnlToDoRightCenterTopRightBottom.add(lblRepeat);
		pnlToDoRightCenterTopRight.add(pnlToDoRightCenterTopRightBottom);
		pnlToDoRightCenter.add(pnlToDoRightCenterTopRight);

		pnlToDoRightCenterBottomLeftTop.add(lblCategory, BorderLayout.WEST);
		pnlToDoRightCenterBottomLeftTop.add(cmbxCategory, BorderLayout.CENTER);
		pnlToDoRightCenterBottomLeft.add(pnlToDoRightCenterBottomLeftTop);

		pnlToDoRightCenterBottomLeftMid.add(lblPriority, BorderLayout.WEST);
		pnlToDoRightCenterBottomLeftMid.add(sldrPriority, BorderLayout.CENTER);
		pnlToDoRightCenterBottomLeft.add(pnlToDoRightCenterBottomLeftMid);

		pnlToDoRightCenterBottomLeftBottom.add(lblDone, BorderLayout.WEST);
		pnlToDoRightCenterBottomLeftBottom.add(chbxDone, BorderLayout.CENTER);
		pnlToDoRightCenterBottomLeft.add(pnlToDoRightCenterBottomLeftBottom);

		pnlToDoRightCenter.add(pnlToDoRightCenterBottomLeft);

		pnlToDoRightCenterBottomRight.add(txtAraNotes, BorderLayout.CENTER);
		pnlToDoRightCenter.add(pnlToDoRightCenterBottomRight);

		pnlToDoRight.add(pnlToDoRightTop, BorderLayout.NORTH);
		pnlToDoRight.add(pnlToDoRightCenter, BorderLayout.CENTER);
	}

	@Override
	public JPanel getPanel() {
		return pnlToDoRight;
	}

}
