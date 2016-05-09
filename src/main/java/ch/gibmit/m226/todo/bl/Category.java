package ch.gibmit.m226.todo.bl;

import ch.gibmit.m226.todo.data.CategoryDAO;
import ch.gibmit.m226.todo.data.CategoryDAOImpl;
import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * @author Damian Zehnder
 * this class is the business-logic of the category class
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

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

}
