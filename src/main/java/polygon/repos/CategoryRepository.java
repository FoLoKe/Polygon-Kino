package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polygon.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
