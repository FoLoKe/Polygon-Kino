package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;
import polygon.repos.BuildingRepository;
import polygon.repos.SessionRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<Session> findSessionsInCity(City city) {
        return sessionRepository.findAllActiveSessionForCity(city);
    }

    @Override
    public Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city) {

        List <Building> buildings = buildingRepository.findByCity(city);
        Map<Building, List<Session>> orderedSessions = new LinkedHashMap<>();
        for (Building b: buildings) {
           List<Session> sessions = sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(b, performance);
           orderedSessions.put(b, sessions);
        }

         return orderedSessions;
    }

    @Override
    @Transactional
    public Session findById(int id) {
        Session s = sessionRepository.findById(id).orElse(null);
        if(s != null) {
            s.getTickets().size();
        }
        return s;
    }
}
