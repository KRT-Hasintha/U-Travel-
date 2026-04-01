package org.example.back_end.Repository;

import org.example.back_end.Entity.Ride;
import org.example.back_end.Entity.User;
import org.example.back_end.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface RideRepository extends JpaRepository<Ride, Long> {
//    // Find all rides by a user
//    List<Ride> findByUser(User user);
//
//    // Find all rides by vehicle
//    List<Ride> findByVehicle(Vehicle vehicle);
//
//    // Find rides by status (REQUESTED, ACCEPTED, COMPLETED)
//    List<Ride> findByStatus(String status);
//
//    // Combined example: rides by user and status
//    List<Ride> findByUserAndStatus(User user, String status);


    // user ekata adala ride eka
    Optional<Ride> findTopByUserUsernameOrderByIdDesc(String username);

    // provider ekata requests
    List<Ride> findByVehicleDriverUsernameAndStatus(String username, String status);

    List<Ride> findByStatus(String status);





}
