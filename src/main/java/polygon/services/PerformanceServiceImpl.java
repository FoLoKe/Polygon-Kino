package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Category;
import polygon.repos.PerformanceRepository;
import polygon.models.Performance;

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
}
