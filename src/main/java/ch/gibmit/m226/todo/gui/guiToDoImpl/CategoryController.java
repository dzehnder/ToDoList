package ch.gibmit.m226.todo.gui.guiToDoImpl;

import ch.gibmit.m226.todo.bl.Category;
import ch.gibmit.m226.todo.dto.CategoryDTO;
import ch.gibmit.m226.todo.gui.interfaces.ICategoryController;

/**
 * @author Damian Zehnder
 * this class is the controller of the category list
 */
public class CategoryController implements ICategoryController {

    private Category category = new Category();
    private CategoryModel categoryModel;

    public CategoryController(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }


    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        category.add(categoryDTO);
        getAllCategories();
    }

    @Override
    public void getAllCategories() {
        categoryModel.refreshCategoryList(category.getCategories());

    }


	public Category getCategory() {
		return category;
	}
}
