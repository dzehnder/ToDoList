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

    /**
     * constructor adds the category model to this controller
     * @param categoryModel the category model
     */
    public CategoryController(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    /**
     * give the category that needs to be added to the business logic of the category
     * @param categoryDTO the category to add
     */
    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        category.add(categoryDTO);
        getAllCategories();
    }

    /**
     * get all categories from the model
     */
    @Override
    public void getAllCategories() {
        categoryModel.refreshCategoryList(category.getCategories());

    }

    /**
     * get the category class from the business logic
     * @return the category class
     */
	public Category getCategory() {
		return category;
	}
}
