package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Category;
import polygon.repos.PerformanceRepository;
import polygon.models.Performance;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    PerformanceRepository performanceRepository;

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
            for (Category c: p.getCategories()) {
                c.getId();
            }
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
