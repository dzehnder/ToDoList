package ch.gibmit.m266.todo.category;

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

    @Test
    public void testAddCategory() {
        CategoryDTO categoryDTO = new CategoryDTO(catname);
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
}
