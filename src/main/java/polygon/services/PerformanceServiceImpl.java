package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.*;

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
    public Map<Timestamp, Map<Building, List<Session>>> getSchedule(Performance performance, City city) {
        Date utilDate = new Date();
        Calendar ac = Calendar.getInstance();
        ac.setTime(utilDate);
        Timestamp time = new Timestamp(ac.getTime().getTime());
        Map<Timestamp, Map<Building, List<Session>>> result = new HashMap<>();
        List<Building> buildings = buildingRepository.allByCity(city);
        for (int i = 0; i < 14; i++, ac.add(Calendar.DATE, 1), time.setTime(ac.getTime().getTime())) {
            Map<Building, List<Session>> byByBuildingSchedule = new HashMap<>();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            calendar.add(Calendar.HOUR, 23);
            calendar.add(Calendar.MINUTE, 59);
            Timestamp endTime = new Timestamp(calendar.getTime().getTime());
            for (Building building : buildings) {
                byByBuildingSchedule.put(building, sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(building, performance, time, endTime));
            }
            result.put(time, byByBuildingSchedule);
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
        List<Performance> performances = performanceRepository.findAllActivePerformances(sqlDate, city);
        List<Performance> imax=new ArrayList<>();
        for (Performance p: performances) {
            p.getSessions().size();
            p.getCategories().size();
            for (Session s: p.getSessions()) {
                Room r = s.getRoom();
                Hibernate.initialize(r);
                if (r instanceof HibernateProxy) {
                    r = (Room) ((HibernateProxy) r).getHibernateLazyInitializer()
                            .getImplementation();
                }
                if (r.getType().equals("IMAX")) {
                    imax.add(p);
                }
            }
        }
        return imax;
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
}
