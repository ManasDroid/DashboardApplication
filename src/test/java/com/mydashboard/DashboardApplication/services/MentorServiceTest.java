package com.mydashboard.DashboardApplication.services;

import com.mydashboard.DashboardApplication.entities.Mentor;
import com.mydashboard.DashboardApplication.repositories.MentorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MentorServiceTest {

    @Autowired
    private MentorRepository mentorRepository;

    @Test
    public void testGetAllMentors() {
        // Populate the H2 database with test data
        mentorRepository.save(new Mentor("Mentor1", 30, "1234567890", "CV1"));
        mentorRepository.save(new Mentor("Mentor2", 35, "9876543210", "CV2"));

        // Call the method to be tested
        MentorService mentorService = new MentorService(mentorRepository);
        List<Mentor> result = mentorService.getAllMentors();

        // Assert that the result contains the expected number of mentors
        assertEquals(2, result.size());
    }
}