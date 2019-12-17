package polygon.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import polygon.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
    @Query("select p from Category p")
    List<Category> findAllActiveTags();
}
