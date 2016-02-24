package ch.gibmit.m226.todo.ch.gibmit.m266.todo.guiToDoLeft;

import javax.swing.*;
import java.awt.*;

/**
 * Created by colin on 24.02.16.
 */
class CheckboxListRenderer extends JCheckBox implements
        ListCellRenderer<CheckboxListItem> {

    public Component getListCellRendererComponent(
            JList<? extends CheckboxListItem> list, CheckboxListItem value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setEnabled(list.isEnabled());
        setSelected(value.isSelected());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setText(value.toString());
        return this;
    }
}
