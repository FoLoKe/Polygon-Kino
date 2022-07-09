package polygon.services.interfaces;

import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface SessionService {
    Map<Performance, List<Session>> findSessionsInBuilding(Building building, Timestamp timestamp);
    Session findById(int id);
    void addSession(Session session);

    void addSessions(List<Session> sessions);
    Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city, Timestamp time);
    void cancel(int id);
}
