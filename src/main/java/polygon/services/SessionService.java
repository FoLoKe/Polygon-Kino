package polygon.services;

import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface SessionService {
    public List<Session> findSessionsInCity(City city);
    Session findById(int id);
    Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city);
}
