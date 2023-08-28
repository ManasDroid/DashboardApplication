package com.mydashboard.DashboardApplication.services;

import com.mydashboard.DashboardApplication.entities.Statistics;
import com.mydashboard.DashboardApplication.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public Statistics getWebAppStatistics() {
        return statisticsRepository.findById(1L).orElse(new Statistics()); // Assuming there is only one row for statistics
    }

}
