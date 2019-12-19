package polygon.services;

import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface SessionService {

    public List<Session> findSessionsInCity(City city);
    public Map<Timestamp, Map<Performance, List<Session>>> findSessionsInBuilding(Building building);
    Session findById(int id);
    void addSession(Session session);
    Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city, Timestamp time);
}
