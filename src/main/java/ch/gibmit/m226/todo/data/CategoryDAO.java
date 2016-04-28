package ch.gibmit.m226.todo.data;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * Created by zehnder on 21/04/16.
 */
public interface CategoryDAO {
    void  addCategory(CategoryDTO cateroy);
    ArrayList<CategoryDTO> getCategories();
}
