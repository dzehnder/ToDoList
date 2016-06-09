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

    /**
     * constructor initializes the category data access object with a new object
     */
    public Category() {
        this(new CategoryDAOImpl());
    }

    /**
     * second constructor initializes the category data access object with a given object
     *
     * @param categoryDAO the category data access object
     */
    public Category(CategoryDAO categoryDAO) {
    	this.categoryDAO = categoryDAO;
	}

    /**
     * add a new category
     * @param category the new category
     */
	public void add(CategoryDTO category) {
        categoryDAO.addCategory(category);
    }

    /**
     * get all categories from the category list
     * @return all categories
     */
    public ArrayList<CategoryDTO> getCategories() {
        return categoryDAO.getCategories();
    }

    /**
     * get the category data access object
     * @return the category data access object
     */
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

    /**
     * (re)set the category data access object with a new one
     * @param categoryDAO the category data access object
     */
	public void setCategoriyDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}


}
