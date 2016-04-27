package ch.gibmit.m226.todo.gui.interfaces;

import ch.gibmit.m226.todo.dto.CategoryDTO;

/**
 * Created by zehnder on 22/04/16.
 */
public interface ICategoryController {

    void addCategory(CategoryDTO categoryDTO);
    void getAllCategories();

}
