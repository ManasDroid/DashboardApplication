package com.mydashboard.DashboardApplication.controllers;

import com.mydashboard.DashboardApplication.entities.MentorRequest;
import com.mydashboard.DashboardApplication.services.MentorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/mentor-requests")
public class MentorRequestController {

    private final MentorRequestService mentorRequestService;

    @Autowired
    public MentorRequestController(MentorRequestService mentorRequestService) {
        this.mentorRequestService = mentorRequestService;
    }

    // Create Mentor Request
    @PostMapping("/create")
    public ResponseEntity<MentorRequest> createMentorRequest(@RequestBody MentorRequest mentorRequestDetails) {
        MentorRequest newMentorRequest = mentorRequestService.createMentorRequest(mentorRequestDetails);
        return new ResponseEntity<>(newMentorRequest, HttpStatus.CREATED);
    }
}
