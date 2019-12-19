package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.BuildingRepository;
import polygon.repos.PerformanceRepository;
import polygon.repos.SessionRepository;
import polygon.repos.TicketRepository;

import java.sql.Timestamp;
import java.util.*;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public void addSession(Session session) {
        sessionRepository.save(session);
        sessionRepository.flush();
    }

    @Override
    public List<Session> findSessionsInCity(City city) {
        return sessionRepository.findAllActiveSessionForCity(city);
    }

    @Override
    public Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city, Timestamp time) {

        List <Building> buildings = buildingRepository.findByCity(city);
        Map<Building, List<Session>> orderedSessions = new LinkedHashMap<>();
        Calendar ac = Calendar.getInstance();
        ac.setTime(time);
        ac.add(Calendar.HOUR, - time.getHours());
        ac.add(Calendar.MINUTE, - time.getMinutes());
        time = new Timestamp(ac.getTime().getTime());


        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.DATE, 1);
        Timestamp endTime = new Timestamp(c.getTime().getTime());
        for (Building b: buildings) {
           List<Session> sessions = sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(b, performance, time, endTime);
           orderedSessions.put(b, sessions);
        }

         return orderedSessions;
    }

    @Override
    public Map<Timestamp,Map<Performance, List<Session>>> findSessionsInBuilding(Building building) {
        Timestamp time = new Timestamp(new Date().getTime());

        Calendar c = Calendar.getInstance();
        c.set(time.getYear(), time.getMonth(), time.getDay());
        Map<Timestamp,Map<Performance, List<Session>>> timestampMapMap = new LinkedHashMap<>();
        for (int i=1; i < 14; i++) {
            c.setTime(time);
            c.add(Calendar.DATE, 14);
            Timestamp endTime = new Timestamp(c.getTime().getTime());

            Map<Performance, List<Session>> performanceSessionMap = new LinkedHashMap<>();
            List<Performance> performances = performanceRepository.findAll();
            for (Performance p : performances) {
                performanceSessionMap.put(p, sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(building, p, time, endTime));
            }

            timestampMapMap.put(time, performanceSessionMap);
            time=endTime;
        }
        return timestampMapMap;
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
