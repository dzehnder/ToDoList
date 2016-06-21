package ch.gibmit.m226.todo.gui.interfaces;

import ch.gibmit.m226.todo.dto.CategoryDTO;

/**
 * @author Damian Zehnder
 */
public interface ICategoryController {

    /**
     * give the category that needs to be added to the business logic of the category
     * @param categoryDTO the category to add
     */
    void addCategory(CategoryDTO categoryDTO);

    /**
     * get all Categories from the model
     */
    void getAllCategories();

}
