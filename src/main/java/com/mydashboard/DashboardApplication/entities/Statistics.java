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
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalConsultants;
    private int totalClients;
    private int totalSessionsBooked;


    // Constructors , Getters and setters


}
