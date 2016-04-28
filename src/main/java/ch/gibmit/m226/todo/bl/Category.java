package ch.gibmit.m226.todo.bl;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.CategoryDAOImpl;
import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * Created by zehnder on 21/04/16.
 */
public class Category {

    private CategoryDAO categoryDAO;

    public Category() {
        categoryDAO = new CategoryDAOImpl();
    }

    public void add(CategoryDTO category) {
        categoryDAO.addCategory(category);
    }

    public ArrayList<CategoryDTO> getCategories() {
        return categoryDAO.getCategories();
    }

}
