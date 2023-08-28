package com.mydashboard.DashboardApplication.services;

import com.mydashboard.DashboardApplication.entities.MentorRequest;
import com.mydashboard.DashboardApplication.repositories.MentorRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorRequestService {

    @Autowired
    private MentorRequestRepository mentorRequestRepository;

    public List<MentorRequest> getAllMentorRequests() {
        return mentorRequestRepository.findAll();
    }

    public void approveMentorRequest(Long requestId) {
        Optional<MentorRequest> mentorRequestOptional = mentorRequestRepository.findById(requestId);
        mentorRequestOptional.ifPresent(mentorRequest -> {
            mentorRequest.setStatus("Approved");
            mentorRequestRepository.save(mentorRequest);
        });
    }

    public void rejectMentorRequest(Long requestId) {
        Optional<MentorRequest> mentorRequestOptional = mentorRequestRepository.findById(requestId);
        mentorRequestOptional.ifPresent(mentorRequest -> {
            mentorRequest.setStatus("Rejected");
            mentorRequestRepository.save(mentorRequest);
        });
    }

    public MentorRequest createMentorRequest(MentorRequest mentorRequestDetails) {

        mentorRequestDetails.setStatus("Pending");
        mentorRequestRepository.save(mentorRequestDetails);

        return mentorRequestDetails;
    }

}
