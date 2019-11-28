package polygon.services;

import polygon.models.Performance;
import polygon.models.Room;

import java.util.List;

public interface PerformanceService {
    List<Performance> allPerformances();
    List<Performance> activePerformances();
}
