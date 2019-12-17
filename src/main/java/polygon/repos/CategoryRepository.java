package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import polygon.models.Category;
import polygon.models.Performance;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select p from Performance p where :categories in p.categories")
    public List<Performance> getAllFilmsByTag(@Param("categories") Set<Category> categories);
}
