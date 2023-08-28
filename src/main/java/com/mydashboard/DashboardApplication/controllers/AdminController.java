package com.mydashboard.DashboardApplication.controllers;

import com.mydashboard.DashboardApplication.entities.Mentor;
import com.mydashboard.DashboardApplication.entities.MentorRequest;
import com.mydashboard.DashboardApplication.entities.Statistics;
import com.mydashboard.DashboardApplication.services.MentorRequestService;
import com.mydashboard.DashboardApplication.services.MentorService;
import com.mydashboard.DashboardApplication.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final MentorRequestService mentorRequestService;

    private final MentorService mentorService;

    private final StatisticsService statisticsService;

    @Autowired
    public AdminController(MentorRequestService mentorRequestService, MentorService mentorService, StatisticsService statisticsService) {
        this.mentorRequestService = mentorRequestService;
        this.mentorService = mentorService;
        this.statisticsService = statisticsService;
    }

    // 1. Approve or Reject Mentor Requests

    @GetMapping("/mentor-requests")
    public ResponseEntity<List<MentorRequest>> getMentorRequests() {
        List<MentorRequest> mentorRequests = mentorRequestService.getAllMentorRequests();
        return ResponseEntity.ok(mentorRequests);
    }

    @PostMapping("/mentor-requests/{requestId}/approve")
    public ResponseEntity<String> approveMentorRequest(@PathVariable Long requestId) {
        mentorRequestService.approveMentorRequest(requestId);
        String responseMessage = "Mentor request with ID " + requestId + " has been approved.";
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }

    @PostMapping("/mentor-requests/{requestId}/reject")
    public ResponseEntity<String> rejectMentorRequest(@PathVariable Long requestId) {
        mentorRequestService.rejectMentorRequest(requestId);
        String responseMessage = "Mentor request with ID " + requestId + " has been rejected.";
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }



    // 2. Add  Details to Mentor Account

    @PostMapping("/mentors")
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentorDetails) {
        Mentor newMentor = mentorService.createMentor(mentorDetails);
        return new ResponseEntity<>(newMentor, HttpStatus.CREATED);
    }

    // 3. Mentor Details

    @GetMapping("/mentors")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        List<Mentor> mentors = mentorService.getAllMentors();
        return ResponseEntity.ok(mentors);
    }

    @GetMapping("/mentors/{name}")
    public ResponseEntity<Mentor> getMentorByName(@PathVariable String name) {
        Mentor mentor = mentorService.getMentorByName(name);
        if (mentor != null) {
            return ResponseEntity.ok(mentor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // 4. Web App Statistics

    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getWebAppStatistics() {
        Statistics stats = statisticsService.getWebAppStatistics();
        return ResponseEntity.ok(stats);
    }
}

