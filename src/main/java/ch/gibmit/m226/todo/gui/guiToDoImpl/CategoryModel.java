package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * @author Damian Zehnder
 * this is the model of the category list
 */
public class CategoryModel {

    private ArrayList<CategoryDTO> categoryList;

    /**
     * constructor initializes the category list
     */
    public CategoryModel() {
        categoryList = new ArrayList<>();
    }


    /**
     * refreshes the old category list with a new one
     * @param categoryList the category list that replaces the old one
     */
    public void refreshCategoryList(ArrayList<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * get the category list with all items
     * @return the category list
     */
    public ArrayList<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    /**
     * get the category name from a specified index
     * @param index the index from the list to get the category from
     * @return the requested category
     */
    public String getCategoryName(int index) {
        return categoryList.get(index).getName();
    }

    /**
     * set a category name at a specified index
     * @param index the index of the category list, at which the category name should change
     * @param name the new name of the category
     */
    public void setCategoryName(int index, String name) {
        categoryList.get(index).setName(name);
    }

    /**
     * remove a category from the list at a specified index
     * @param index the index to delete the category from the list
     */
    public void removeCategory(int index) {
        categoryList.remove(index);
    }
}
