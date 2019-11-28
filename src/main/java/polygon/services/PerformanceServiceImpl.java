package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polygon.repos.PerformanceRepository;
import polygon.models.Performance;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    PerformanceRepository performanceRepository;

    @Override
    public List<Performance> allPerformances() {
        return performanceRepository.findAll();
    }

    @Override
    public List<Performance> activePerformances() {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return performanceRepository.findAllActivePerformances(sqlDate);
    }
}
