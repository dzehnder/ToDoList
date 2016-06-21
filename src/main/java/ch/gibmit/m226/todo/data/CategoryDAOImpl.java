package ch.gibmit.m226.todo.data;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Damian Zehnder
 */
public class CategoryDAOImpl implements CategoryDAO, Serializable {

	private static final long serialVersionUID = -8477959614797354048L;
	private ArrayList<CategoryDTO> categoryList;

    /**
     * constructor generates default categories and adds them to the list
     */
    public CategoryDAOImpl() {
        categoryList = new ArrayList<>();
        categoryList.add(new CategoryDTO("Work"));
        categoryList.add(new CategoryDTO("School"));
        categoryList.add(new CategoryDTO("Private"));
    }

    /**
     * add a category to the existing list
     * @param category the category that shoudl be added to the list
     */
    @Override
    public void addCategory(CategoryDTO category) {
        categoryList.add(category);
    }

    /**
     * get the category list
     * @return the category list
     */
    @Override
    public ArrayList<CategoryDTO> getCategories() {
        return  categoryList;
    }

}
