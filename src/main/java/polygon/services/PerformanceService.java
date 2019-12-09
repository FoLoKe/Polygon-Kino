package polygon.services;

import polygon.models.Performance;
import polygon.models.Room;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PerformanceService {
    List<Performance> allPerformances();
    List<Performance> activePerformances();
    Performance findById(int id);
    public void writeImageToResponse(Integer id, HttpServletResponse response);
}
