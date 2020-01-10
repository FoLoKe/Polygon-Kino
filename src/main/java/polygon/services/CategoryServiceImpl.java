package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polygon.models.Category;
import polygon.repos.CategoryRepository;
import polygon.services.interfaces.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public boolean safeDelete(int id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
}
