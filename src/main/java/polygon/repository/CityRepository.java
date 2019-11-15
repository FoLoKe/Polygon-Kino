package polygon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import polygon.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}