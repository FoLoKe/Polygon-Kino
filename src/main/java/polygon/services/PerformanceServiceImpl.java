package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.*;
import polygon.services.interfaces.BuildingService;
import polygon.services.interfaces.PerformanceService;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.*;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    PerformanceRepository performanceRepository;

    @Autowired
    PreviewRepository previewRepository;

    @Autowired
    CinemasRepository cinemasRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Performance> allPerformances() {
        return performanceRepository.findAll();
    }

    @Override
    @Transactional
    public Performance findById(int id) {
        Performance performance = performanceRepository.findById(id).orElse(new Performance());
        performance.getCategories().size();
        return performance;
    }

    @Autowired
    private BuildingService buildingRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    @Transactional
    public Map<Timestamp, Map<Building, List<Session>>> getSchedule(Performance performance, City city, String type) {
        Date utilDate = new Date();
        Calendar ac = Calendar.getInstance();
        ac.setTime(utilDate);
        ac.set(Calendar.SECOND, 0);
        ac.set(Calendar.MILLISECOND, 0);
        Timestamp time = new Timestamp(ac.getTime().getTime());
        Map<Timestamp, Map<Building, List<Session>>> result = new LinkedHashMap<>();
        List<Building> buildings = buildingRepository.allByCity(city);
        for (int i = 0; i < 14; i++) {
            Map<Building, List<Session>> byByBuildingSchedule = new LinkedHashMap<>();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            //calendar.add(Calendar.DATE, 1);
            Timestamp endTime = new Timestamp(calendar.getTime().getTime());
            for (Building building : buildings) {
                List<Session> sessions = new ArrayList<>();
                if(type.length() == 0) {
                    sessions = sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(building, performance, time, endTime);
                } else {
                    sessions = sessionRepository.findAllActiveSessionsOnPerformanceForBuildingByType(building, performance, time, endTime, type);
                }
                for(Session s: sessions) {
                    Hibernate.initialize(s);
                    Room room = s.getRoom();
                    if (room instanceof HibernateProxy) {
                        room = (Room) ((HibernateProxy) room).getHibernateLazyInitializer()
                                .getImplementation();
                    }
                }
                if(sessions.size() > 0)
                byByBuildingSchedule.put(building, sessions);
            }
            if(byByBuildingSchedule.size() != 0)
                result.put(time, byByBuildingSchedule);
            calendar.add(Calendar.MINUTE, 1);
            time = new Timestamp(calendar.getTime().getTime());
        }
        return result;
    }

    @Override
    @Transactional
    public Performance findByIdFullLoad(int id) {
        Performance performance = performanceRepository.findById(id).orElse(new Performance());
        performance.getCategories().size();
        performance.getPreviews().size();
        return performance;
    }

    @Override
    @Transactional
    public List<Performance> activePerformances(City city) {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> performances = performanceRepository.findAllActivePerformances(sqlDate, city);
        for (Performance p: performances) {
            p.getCategories().size();
        }
        return performances;
    }

    @Override
    @Transactional
    public List<Performance> allPremiers() {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> performances = performanceRepository.findPremiers(sqlDate);
        for (Performance p: performances) {
            p.getCategories().size();
        }
        return performances;
    }

    @Override
    @Transactional
    public List<Performance> allPresentPerformances() {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return performanceRepository.findAllPresent(sqlDate);
    }

    @Override
    @Transactional
    public List<Performance> premiers(City city) {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> performances = performanceRepository.findAllPremiers(sqlDate, city);
        for (Performance p: performances) {
            p.getCategories().size();
        }
        return performances;
    }

    @Override
    @Transactional
    public List<Performance> activeIMAXPerformances(City city) {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> performances = performanceRepository.findIMAX(sqlDate, city);
        for (Performance p: performances) {
            p.getCategories().size();
        }

//        List<Performance> imax=new ArrayList<>();
//        for (Performance p: performances) {
////            p.getSessions().size();
////            p.getCategories().size();
//            for (Session s: p.getSessions()) {
//                Room r = s.getRoom();
//                Hibernate.initialize(r);
//                if (r instanceof HibernateProxy) {
//                    r = (Room) ((HibernateProxy) r).getHibernateLazyInitializer()
//                            .getImplementation();
//                }
//                if (r.getType().equals("IMAX")) {
//                    imax.add(p);
//                }
//            }
//        }
        return performances;
    }

    @Override
    @Transactional
    public List<Performance> activePerformances(Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        List<Performance> performances = new ArrayList<>();
        if(category != null)
            performances =  performanceRepository.getAllFilmsByTag(category);
        for (Performance p: performances) {
            p.getCategories().size();
        }
        return performances;
    }

    @Override
    public void writeImageToResponse(Integer id, HttpServletResponse response) {
        //store image in browser cache
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.setHeader("Cache-Control", "max-age=2628000");

        //obtaining bytes from DB
        Performance performance = performanceRepository.findById(id).orElse(null);
        if(performance != null) {
            byte[] imageData = performance.getPoster();

            //write result to http response
            try (OutputStream out = response.getOutputStream()) {
                out.write(imageData);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public void writePreviewToResponse(Integer id, HttpServletResponse response) {
        //store image in browser cache
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.setHeader("Cache-Control", "max-age=2628000");

        //obtaining bytes from DB
        Preview preview = previewRepository.findById(id).orElse(null);
        if(preview != null) {
            byte[] imageData = preview.getImage();

            //write result to http response
            try (OutputStream out = response.getOutputStream()) {
                out.write(imageData);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }


    @Override
    @Transactional
    public void add(List<Performance> performance) {
        performanceRepository.saveAll(performance);
        performanceRepository.flush();
    }

    @Override
    @Transactional
    public boolean cancel(int id) {
        try {
            Performance performance = performanceRepository.findById(id).orElse(null);

            if(performance != null && performance.getSessions().size() == 0) {
                performanceRepository.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    @Override
    @Transactional
    public void save(Performance performance) {
        performanceRepository.saveAndFlush(performance);
    }
}
