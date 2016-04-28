package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * Created by zehnder on 25/04/16.
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
}
