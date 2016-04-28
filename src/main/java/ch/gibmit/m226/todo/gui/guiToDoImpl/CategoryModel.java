package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * @author Damian Zehnder
 * this is the model of the category list
 */
public class CategoryModel {

    private ArrayList<CategoryDTO> categoryList;

    public CategoryModel() {
        categoryList = new ArrayList<>();
    }



    public void refreshCategoryList(ArrayList<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public ArrayList<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public String getCategoryName(int index) {
        return categoryList.get(index).getName();
    }

    public void setCategoryName(int index, String name) {
        categoryList.get(index).setName(name);
    }

    public void removeCategory(int index) {
        categoryList.remove(index);
    }
}
