package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Performance;
import polygon.models.Room;
import polygon.models.Session;
import polygon.repos.CinemasRepository;
import polygon.repos.PerformanceRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    PerformanceRepository performanceRepository;

    @Autowired
    CinemasRepository cinemasRepository;

    @Override
    public List<Performance> allPerformances() {
        return performanceRepository.findAll();
    }

    @Override
    public Performance findById(int id) {
        return performanceRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Performance> activePerformances() {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> performances = performanceRepository.findAllActivePerformances(sqlDate);
        for (Performance p: performances) {
            p.getCategories().size();
        }
        return performances;
    }



    @Override
    @Transactional
    public List<Performance> activeimaxPerformances() {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> performances = performanceRepository.findAllActivePerformances(sqlDate);
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
    public void writeImageToResponse(Integer id, HttpServletResponse response) {
        //store image in browser cache
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.setHeader("Cache-Control", "max-age=2628000");

        //obtaining bytes from DB
        Performance performance = performanceRepository.findById(id).orElse(null);
        if(performance != null) {
            byte[] imageData = performance.getPoster();

            //Some conversion
            //Maybe to base64 string or something else
            //Pay attention to encoding (UTF-8, etc)
            //Base64.Decoder dec = Base64.getDecoder();
            //byte[] convertedStringBytes = dec.decode(imageData);

            //write result to http response
            try (OutputStream out = response.getOutputStream()) {
                out.write(imageData);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
