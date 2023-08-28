package com.mydashboard.DashboardApplication.services;

import com.mydashboard.DashboardApplication.entities.Mentor;
import com.mydashboard.DashboardApplication.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }


    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Mentor getMentorByName(String name) {
        return mentorRepository.findByName(name).orElse(null);
    }

    public Mentor createMentor(Mentor mentorDetails) {
        Mentor newMentor = new Mentor();
        newMentor.setName(mentorDetails.getName());
        newMentor.setAge(mentorDetails.getAge());
        newMentor.setPhoneNo(mentorDetails.getPhoneNo());
        newMentor.setCv(mentorDetails.getCv());
        mentorRepository.save(newMentor);

        // Save the new mentor to the repository
        mentorRepository.save(newMentor);

        return newMentor;
    }

}
