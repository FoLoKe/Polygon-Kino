package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Category;
import polygon.repos.CategoryRepository;
import polygon.services.interfaces.CategoryService;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryImplTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void allCategories() {
        Category category = new Category();
        category.setId(1);
        List<Category> categories = List.of(category);
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> expected=categoryService.allCategories();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void findById() {
        Category category = new Category();
        category.setId(1);
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        Category expected = categoryService.findById(1);
        Assert.assertNotNull(expected);
        Mockito.verify(categoryRepository,Mockito.times(1)).findById(1);
    }

    @Test
    public void save() {
        Category category = new Category();
        category.setId(1);
        categoryService.save(category);
        Mockito.verify(categoryRepository,Mockito.times(1)).saveAndFlush(category);
    }

    @Test
    public void safeDelete() {
        Category category = new Category();
        category.setId(1);
        categoryService.safeDelete(1);
        Mockito.verify(categoryRepository,Mockito.times(1)).deleteById(1);
    }

}