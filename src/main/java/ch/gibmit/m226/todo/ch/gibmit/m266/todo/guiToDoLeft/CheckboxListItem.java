package ch.gibmit.m226.todo.ch.gibmit.m266.todo.guiToDoLeft;

/**
 * Created by colin on 24.02.16.
 */
public class CheckboxListItem {
    private String label;
    private boolean isSelected = false;

    public CheckboxListItem(String label) {
        this.label = label;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String toString() {
        return label;
    }
}
