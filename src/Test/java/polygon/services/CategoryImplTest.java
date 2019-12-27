package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Category;
import polygon.services.interfaces.CategoryService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void allCategories() {
        List<Category> expected=categoryService.allCategories();
        Assert.assertNotNull(expected);
        Assert.assertEquals(9,expected.size());
    }
}