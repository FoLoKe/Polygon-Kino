package polygon.services.interfaces;

import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface PerformanceService {

    List<Performance> allPerformances();
    List<Performance> activePerformances(City city);
    List<Performance> allPremiers();
    List<Performance> activeIMAXPerformances(City city);
    List<Performance> premiers(City city);
    List<Performance> allPresentPerformances();
    List<Performance> activePerformances(Integer id);

    void add(List<Performance> performance);
    Performance findById(int id);
    Performance findByIdFullLoad(int id);
    Map<Timestamp, Map<Building, List<Session>>> getSchedule(Performance performance, City city);

    void writeImageToResponse(Integer id, HttpServletResponse response);
    void writePreviewToResponse(Integer id, HttpServletResponse response);
}
