package polygon.services;

import polygon.models.City;
import polygon.models.Performance;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PerformanceService {

    List<Performance> allPerformances();
    List<Performance> activePerformances(City city);
    List<Performance> activeIMAXPerformances(City city);
    List<Performance> premiers(City city);
    List<Performance> allPresentPerformances();
    List<Performance> activePerformances(Integer id);
    void add(List<Performance> performance);
    Performance findById(int id);
    void writeImageToResponse(Integer id, HttpServletResponse response);
    void writePreviewToResponse(Integer id, HttpServletResponse response);
}
