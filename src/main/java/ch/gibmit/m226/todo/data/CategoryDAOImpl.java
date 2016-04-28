package ch.gibmit.m226.todo.data;

import ch.gibmit.m226.todo.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * Created by zehnder on 21/04/16.
 */
public class CategoryDAOImpl implements CategoryDAO {

    private ArrayList<CategoryDTO> categoryList;

    public CategoryDAOImpl() {
        categoryList = new ArrayList<>();
        categoryList.add(new CategoryDTO("Work"));
        categoryList.add(new CategoryDTO("School"));
        categoryList.add(new CategoryDTO("Theater"));
        categoryList.add(new CategoryDTO("Movies"));
    }

    @Override
    public void addCategory(CategoryDTO category) {
        categoryList.add(category);
    }

    @Override
    public ArrayList<CategoryDTO> getCategories() {
        return  categoryList;
    }

}
