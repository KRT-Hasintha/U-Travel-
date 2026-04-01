package org.example.back_end.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ride {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Double pickupLat;
//    private Double pickupLng;
//
//    private Double dropLat;
//    private Double dropLng;
//
//    private String status;
//
//    @Column(nullable = true)
//    private Double currentLat;//new
//
//    @Column(nullable = true)
//    private Double currentLng;//new
//
//    @ManyToOne
//    private User user;
//
//    @ManyToOne
//    private Vehicle vehicle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double userLat;
    private Double userLng;

    private String status; // PENDING / ACCEPTED / COMPLETED

    @ManyToOne
    private User user;

    @ManyToOne
    private Vehicle vehicle;

}
