package com.mydashboard.DashboardApplication.repositories;

import com.mydashboard.DashboardApplication.entities.MentorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRequestRepository extends JpaRepository<MentorRequest, Long> {
    // Custom query methods if needed
}
