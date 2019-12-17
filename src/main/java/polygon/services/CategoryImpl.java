package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Category;
import polygon.repos.CategoryRepository;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService
{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<Category> allCategories() {

        List<Category> allTags=categoryRepository.findAllActiveTags();
        return allTags;
    }
}
