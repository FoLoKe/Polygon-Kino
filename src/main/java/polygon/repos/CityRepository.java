package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polygon.models.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Modifying
    @Query("delete from City c where c.name=:name")
    List<Integer> deleteCity(@Param("name") String name);

}
