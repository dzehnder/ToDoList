package ch.gibmit.m266.todo.category;

import ch.gibmit.m226.todo.bl.Category;
import ch.gibmit.m226.todo.dto.CategoryDTO;
import ch.gibmit.m226.todo.gui.guiToDoImpl.CategoryController;
import ch.gibmit.m226.todo.gui.guiToDoImpl.CategoryModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Damian Zehnder
 */
public class CategoryTest {

    private CategoryModel categoryModel = new CategoryModel();
    private CategoryController categoryController = new CategoryController(categoryModel);

    private String catname = "a category";

    private CategoryDTO categoryDTO = new CategoryDTO(catname);

    @Test
    public void testAddCategory() {

        categoryController.addCategory(categoryDTO);

        assertEquals(categoryModel.getCategoryName(categoryModel.getCategoryList().size()-1), catname);
    }

    @Test
    public void testRemoveCategory() {
        categoryController.getAllCategories();
        int size = categoryModel.getCategoryList().size();
        categoryModel.removeCategory(size-1);

        assertEquals(categoryModel.getCategoryList().size(), size-1);
    }

    @Test
    public void testCategoryBLAdd() {
        Category category = new Category();
        category.add(categoryDTO);

        // expected return value must be 4 because there are three default categories.
        assertEquals(category.getCategories().size(), 4);

        // index must be 3 because 3 default categories are already in the list
        assertEquals(category.getCategories().get(3), categoryDTO);
    }
}
