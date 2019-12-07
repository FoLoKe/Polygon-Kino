package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    //@Query(select * from polygon.sessions left join polygon.Rooms on Room_id = Rooms.id left join polygon.buildings on building_id = buildings.id left join polygon.cities on city_id = cities.id ;
    //        select * from polygon.sessions;
    //       select * from polygon.buildings;);

    @Query("select s from Session s inner join s.room r inner join r.building b where b.city = :city")
    List<Session> findAllActiveSessionForCity(@Param("city") City city);

    @Query("select s from Session s inner join s.room r where r.building = :building and s.performance = :performance")
    List<Session> findAllActiveSessionsOnPerformanceForBuilding(@Param("building") Building building, @Param("performance") Performance performance);
}
