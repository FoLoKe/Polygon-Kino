package polygon.services.interfaces;

import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface SessionService {

    List<Session> findSessionsInCity(City city);
    Map<Performance, List<Session>> findSessionsInBuilding(Building building, Timestamp timestamp);
    Session findById(int id);
    void addSession(Session session);
    Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city, Timestamp time);
    boolean cancel(int id);
}
