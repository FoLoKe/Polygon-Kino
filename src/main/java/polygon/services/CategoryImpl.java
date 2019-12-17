package polygon.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Category;
import polygon.repos.CategoryRepository;
import polygon.repos.PerformanceRepository;

@Service
public class CategoryImpl implements CategoryService
{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<Category> allCategories() {

        List<Category> allTags=categoryRepository.findAllActiveTags();
        return null;
    }
}
