package com.mydashboard.DashboardApplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String age;
    private String phoneNo;
    private String cv;

    public Mentor(String mentor1, int i, String number, String cv1) {
    }
}
