package polygon.services.interfaces;


import polygon.models.Category;

import java.util.List;


public interface CategoryService
{
    List<Category> allCategories();
    Category findById(int id);

    void save(Category category);
    boolean safeDelete(int id);

}
