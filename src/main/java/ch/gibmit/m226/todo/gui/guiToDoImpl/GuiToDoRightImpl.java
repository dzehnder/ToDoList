package ch.gibmit.m226.todo.gui.guiToDoImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import org.jdesktop.swingx.JXDatePicker;

import ch.gibmit.m226.todo.bl.Category;
import ch.gibmit.m226.todo.dto.ToDoDTO;
import ch.gibmit.m226.todo.gui.interfaces.GuiPanel;

/**
 * Created by colin on 16.03.16.
 */
public class GuiToDoRightImpl implements ActionListener {

	private ToDoModel toDoModel;
	private ToDoController controller;

	private JPanel pnlToDoRight;
	private JPanel pnlToDoRightTop;
	private JPanel pnlToDoRightCenter;
	private JPanel pnlToDoRightCenterNorth;
	private JPanel pnlToDoRightCenterCenter;
	private JPanel pnlToDoRightCenterTopLeft;
	private JPanel pnlToDoRightCenterTopLeftTop;
	private JPanel pnlToDoRightCenterTopLeftTopTop;
	private JPanel pnlToDoRightCenterTopLeftTopBottom;
	private JPanel pnlToDoRightCenterTopRight;
	private JPanel pnlToDoRightCenterTopRightTop;
	private JPanel pnlToDoRightCenterTopRightBottom;
	private JPanel pnlToDoRightCenterBottomLeft;
	private JPanel pnlToDoRightCenterBottomRight;
	private JPanel pnlToDoRightCenterBottomLeftTop;
	private JPanel pnlToDoRightCenterBottomLeftTopTop;
	private JPanel pnlToDoRightCenterBottomLeftMid;
	private JPanel pnlToDoRightCenterBottomLeftBottom;
	private GuiToDoEditCategoriesImpl guiToDoEditCategories = GuiToDoEditCategoriesImpl.getInstance();

	private JScrollPane scrPnNoteArea;

	private JLabel lblTitle;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblRepeat;
	private JLabel lblCategory;
	private JLabel lblPriority;

	private JButton btnRepeat;
	private JButton btnAddCategory;
	private JTextField txtFldTitle;
	private JXDatePicker xdpDate;
	private Calendar cdrCalendar;
	private DateFormatter dfFormatter;
	private JSpinner jspTime;
	private JSpinner.DateEditor editor;
	private SpinnerDateModel model;
	private JComboBox<String> cmbxCategory;
	private JSlider sldrPriority;
	private JCheckBox chbxDone;
	private JTextArea txtAreaNotes;

	private ArrayList<JComponent> objects;

	private static final int MIN_PRIO = 5;
	private static final int MAX_PRIO = 1;

	public GuiToDoRightImpl(ToDoModel toDoModel, ToDoController controller) {

		this.toDoModel = toDoModel;
		this.controller = controller;

		guiToDoEditCategories.addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				Object item = cmbxCategory.getSelectedItem();

				updateCategorySelectBox();

				cmbxCategory.setSelectedItem(item);
			}
		});

		setUpPanels();

		setUpComponents();

		placeComponents();

		updateCategorySelectBox();
	}

	private void setUpPanels() {
		pnlToDoRight = new JPanel(new BorderLayout());
		pnlToDoRight.setBorder(new EmptyBorder(30, 30, 30, 30));
		pnlToDoRightTop = new JPanel(new BorderLayout());
		pnlToDoRightCenter = new JPanel(new BorderLayout());
		pnlToDoRightCenterNorth = new JPanel(new GridLayout(1, 2));
		pnlToDoRightCenterCenter = new JPanel(new GridLayout(1, 2));

		pnlToDoRightCenterTopLeft = new JPanel(new BorderLayout());
		pnlToDoRightCenterTopLeft.setBorder(new EmptyBorder(5, 0, 5, 5));
		pnlToDoRightCenterTopLeftTop = new JPanel(new GridLayout(2, 1));
		pnlToDoRightCenterTopLeftTopTop = new JPanel(new FlowLayout());
		pnlToDoRightCenterTopLeftTopBottom = new JPanel(new BorderLayout());
		pnlToDoRightCenterTopRight = new JPanel(new GridLayout(2, 1));
		pnlToDoRightCenterTopRight.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlToDoRightCenterTopRightTop = new JPanel(new FlowLayout());
		pnlToDoRightCenterTopRightBottom = new JPanel(new GridLayout(1, 2));
		pnlToDoRightCenterBottomLeft = new JPanel(new GridLayout(3, 1));
		pnlToDoRightCenterBottomLeft.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlToDoRightCenterBottomLeftTop = new JPanel(new BorderLayout());
		pnlToDoRightCenterBottomLeftTopTop = new JPanel(new BorderLayout());
		pnlToDoRightCenterBottomLeftTopTop.setBorder(new EmptyBorder(60, 0, 0, 0));
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
		sldrPriority.setMajorTickSpacing(1);
		sldrPriority.setMaximum(10);
		sldrPriority.setPaintTicks(true);
		sldrPriority.setSnapToTicks(true);
		// label table for priority
		sldrPriority.setPaintLabels(true);

		lblTitle = new JLabel("Title:");
		lblDate = new JLabel("Date:");
		lblTime = new JLabel("Time:");
		lblCategory = new JLabel("Category:");
		lblPriority = new JLabel("Priority:");
		lblRepeat = new JLabel();

		txtFldTitle = new JTextField();
		xdpDate = new JXDatePicker();
		btnRepeat = new JButton("Repeat");
		btnRepeat.addActionListener(this);
		btnAddCategory = new JButton("Edit");
		btnAddCategory.addActionListener(this);
		cmbxCategory = new JComboBox<>();
		chbxDone = new JCheckBox("Done:");
		chbxDone.setHorizontalTextPosition(SwingConstants.LEFT);
		txtAreaNotes = new JTextArea();
		txtAreaNotes.setLineWrap(true);
		txtAreaNotes.setWrapStyleWord(true);
		Color randomColor = new Color(255, 255, 154);
		txtAreaNotes.setBackground(randomColor);
		scrPnNoteArea = new JScrollPane(txtAreaNotes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		objects = new ArrayList<JComponent>();
		objects.add(btnRepeat);
		objects.add(btnAddCategory);
		objects.add(txtFldTitle);
		objects.add(xdpDate);
		objects.add(jspTime);
		objects.add(editor);
		objects.add(cmbxCategory);
		objects.add(sldrPriority);
		objects.add(chbxDone);
		objects.add(txtAreaNotes);
	}

	private void placeComponents() {
		pnlToDoRightTop.add(lblTitle, BorderLayout.WEST);
		pnlToDoRightTop.add(txtFldTitle, BorderLayout.CENTER);

		pnlToDoRightCenter.add(pnlToDoRightCenterNorth, BorderLayout.NORTH);
		pnlToDoRightCenter.add(pnlToDoRightCenterCenter, BorderLayout.CENTER);

		pnlToDoRightCenterTopLeftTop.add(pnlToDoRightCenterTopLeftTopTop);
		pnlToDoRightCenterTopLeftTop.add(pnlToDoRightCenterTopLeftTopBottom);
		pnlToDoRightCenterTopLeftTopTop.add(lblDate);
		pnlToDoRightCenterTopLeftTopTop.add(xdpDate);
		pnlToDoRightCenterTopLeftTopTop.add(lblTime);
		pnlToDoRightCenterTopLeftTopTop.add(jspTime);
		pnlToDoRightCenterTopLeft.add(pnlToDoRightCenterTopLeftTop);
		pnlToDoRightCenterNorth.add(pnlToDoRightCenterTopLeft);

		pnlToDoRightCenterTopRight.add(pnlToDoRightCenterTopRightTop);
		pnlToDoRightCenterTopRightTop.add(btnRepeat);
		pnlToDoRightCenterTopRightTop.add(lblRepeat);
		pnlToDoRightCenterTopRight.add(pnlToDoRightCenterTopRightBottom);
		pnlToDoRightCenterNorth.add(pnlToDoRightCenterTopRight);

		pnlToDoRightCenterBottomLeftTop.add(pnlToDoRightCenterBottomLeftTopTop, BorderLayout.NORTH);
		pnlToDoRightCenterBottomLeftTopTop.add(lblCategory, BorderLayout.WEST);
		pnlToDoRightCenterBottomLeftTopTop.add(cmbxCategory, BorderLayout.CENTER);
		pnlToDoRightCenterBottomLeftTopTop.add(btnAddCategory, BorderLayout.EAST);
		pnlToDoRightCenterBottomLeft.add(pnlToDoRightCenterBottomLeftTop);

		pnlToDoRightCenterBottomLeftMid.add(lblPriority, BorderLayout.WEST);
		pnlToDoRightCenterBottomLeftMid.add(sldrPriority, BorderLayout.CENTER);
		pnlToDoRightCenterBottomLeft.add(pnlToDoRightCenterBottomLeftMid);

		pnlToDoRightCenterBottomLeftBottom.add(chbxDone, BorderLayout.CENTER);
		pnlToDoRightCenterBottomLeft.add(pnlToDoRightCenterBottomLeftBottom);

		pnlToDoRightCenterCenter.add(pnlToDoRightCenterBottomLeft);

		pnlToDoRightCenterBottomRight.add(scrPnNoteArea, BorderLayout.CENTER);
		pnlToDoRightCenterCenter.add(pnlToDoRightCenterBottomRight);

		pnlToDoRight.add(pnlToDoRightTop, BorderLayout.NORTH);
		pnlToDoRight.add(pnlToDoRightCenter, BorderLayout.CENTER);
	}

	private void updateCategorySelectBox() {
		cmbxCategory.removeAllItems();
		CategoryModel categoryModel = GuiToDoEditCategoriesImpl.getInstance().getCategoryModel();

		for (int i = 0; i < categoryModel.getCategoryList().size(); i++) {
			cmbxCategory.addItem(categoryModel.getCategoryList().get(i).getName());
		}
	}

	public JPanel getPanel() {
		return pnlToDoRight;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnAddCategory) {
			guiToDoEditCategories.setVisible(true);
		}
		if (e.getSource() == this.btnRepeat) {
			new GuiToDoRepeatImpl();
		}
	}

	/**
	 * Sets the values from the selected todo to the right panel
	 * 
	 * @param dto
	 *            selected todo
	 */
	public void updateValues(ToDoDTO dto) {
		if (dto.getRepeat() != null) {
			lblRepeat.setText(dto.getRepeat());
		} else {
			lblRepeat.setText("---");
		}
		if (dto.getName() != null) {
			txtFldTitle.setText(dto.getName());
		}
		if (dto.getDateTime() != null) {
			xdpDate.setDate(dto.getDateTime());
			jspTime.setValue(dto.getDateTime());
		} else {
			xdpDate.setDate(null);
			jspTime.setValue(new Date());
		}
		// jspTime.setValue(dto.getDateTime());
		if (dto.getCategory() != null) {
			cmbxCategory.setSelectedItem(dto.getCategory());
		} else {
			cmbxCategory.setSelectedIndex(0);
		}
		if (dto.getPriority() <= 10 && dto.getPriority() >= 1) {
			sldrPriority.setValue(dto.getPriority());
		} else {
			sldrPriority.setValue(5);
		}
		chbxDone.setSelected(dto.isDone());
		if (dto.getNote() != null) {
			txtAreaNotes.setText(dto.getNote());
		} else {
			txtAreaNotes.setText("");
		}
	}

	public void disableAll() {
		for (JComponent o : this.objects) {
			o.setEnabled(false);
		}
		this.clearValues();
	}

	public void enableAll() {
		for (JComponent o : this.objects) {
			o.setEnabled(true);
		}
	}

	public void clearValues() {
		lblRepeat.setText("");
		txtFldTitle.setText("");
		xdpDate.setDate(null);
		cmbxCategory.setSelectedItem("");
		sldrPriority.setValue(5);
		chbxDone.setSelected(false);
		txtAreaNotes.setText("");
	}

	@SuppressWarnings("deprecation")
	public ToDoDTO getChangedToDo() {
		if (jspTime.getValue() == null && xdpDate.getDate() == null) {
			jspTime.setValue(new Date());
			xdpDate.setDate(new Date());
		} else if (jspTime.getValue() == null) {
			jspTime.setValue(new Date());
		} else if (xdpDate.getDate().toString() == "") {
			xdpDate.setDate(new Date());
		}
		Date date = (Date) jspTime.getValue();
		date.setDate(xdpDate.getDate().getDate());
		date.setMonth(xdpDate.getDate().getMonth());
		date.setYear(xdpDate.getDate().getYear());

		return new ToDoDTO(this.txtFldTitle.getText(), date, this.sldrPriority.getValue(), this.chbxDone.isSelected(),
				this.txtAreaNotes.getText(), new Category(), "");

	}
}
