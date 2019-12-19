package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.BuildingRepository;
import polygon.repos.SessionRepository;
import polygon.repos.TicketRepository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private TicketRepository ticketRepository;

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
    @Transactional
    public Session findById(int id) {
        Session s = sessionRepository.findById(id).orElse(null);
        if(s != null) {
            s.getTickets().size();
        }
        return s;
    }
}
