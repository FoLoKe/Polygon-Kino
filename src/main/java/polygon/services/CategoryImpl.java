package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polygon.models.Category;
import polygon.repos.CategoryRepository;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
}
