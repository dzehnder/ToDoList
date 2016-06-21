package ch.gibmit.m226.todo.data;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * @author Damian Zehnder
 */
public interface CategoryDAO {

    /**
     * add a new category to the existing list
     * @param cateroy the category that should be added
     */
    void  addCategory(CategoryDTO cateroy);

    /**
     * get all categories from the list
     * @return the category list
     */
    ArrayList<CategoryDTO> getCategories();
}
