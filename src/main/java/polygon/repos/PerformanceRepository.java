package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polygon.models.Category;
import polygon.models.City;
import polygon.models.Performance;

import java.sql.Date;
import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

    @Query("select p from Performance p join p.sessions js join js.room r join r.building b where js.time >= :date and p.date <= :date and p.sessions.size > 0 and b.city = :city group by p.id")
    List<Performance> findAllActivePerformances(@Param("date") Date date, City city);

    @Query("select p from Performance p join p.sessions js join js.room r join r.building b where p.date >= :date and p.sessions.size > 0 and b.city = :city group by p.id")
    List<Performance> findAllPremiers(@Param("date") Date date, City city);

    @Query("select p from Performance p join p.categories c where c = :cat")
    List<Performance> getAllFilmsByTag(Category cat);
}
