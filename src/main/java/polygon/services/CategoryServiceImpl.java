package polygon.services;

import org.springframework.stereotype.Service;
import polygon.models.Category;
import polygon.repos.CategoryRepository;
import polygon.repos.PerformanceRepository;
import polygon.services.interfaces.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    private final PerformanceRepository performanceRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               PerformanceRepository performanceRepository) {
        this.categoryRepository = categoryRepository;
        this.performanceRepository = performanceRepository;
    }

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
            Category category = findById(id);

            if(category != null && performanceRepository.countByTag(category) == 0) {
                categoryRepository.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}
