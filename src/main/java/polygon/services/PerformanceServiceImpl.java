package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polygon.daos.PerformanceRepository;
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
}
