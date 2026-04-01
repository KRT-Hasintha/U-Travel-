package org.example.back_end.Service;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Entity.Ride;
import org.example.back_end.Entity.User;
import org.example.back_end.Entity.Vehicle;
import org.example.back_end.Repository.RideRepository;
import org.example.back_end.Repository.UserRepository;
import org.example.back_end.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RideService {

private final RideRepository rideRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;


    public Ride requestRide(String username, Long vehicleId, Double lat, Double lng){

        User user = userRepository.findByUsername(username).orElseThrow();
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();

        Ride ride = Ride.builder()
                .user(user)
                .vehicle(vehicle)
                .userLat(lat)
                .userLng(lng)
                .status("PENDING")
                .build();

        return rideRepository.save(ride);
    }

//    public Ride requestRide(String username, Long vehicleId, Double lat, Double lng){
//
//        User user = userRepository.findByUsername(username).orElseThrow();
//
//        Ride ride = Ride.builder()
//                .user(user)
//                .userLat(lat)
//                .userLng(lng)
//                .status("PENDING")
//                .build();
//
//        return rideRepository.save(ride);
//    }


//    public Ride requestRide(String username, Double lat, Double lng){
//
//        User user = userRepository.findByUsername(username).orElseThrow();
//
//        Ride ride = Ride.builder()
//                .user(user)
//                .userLat(lat)
//                .userLng(lng)
//                .status("PENDING")
//                .build();
//
//        return rideRepository.save(ride);
//    }


    public Ride getMyRide(String username){
        return rideRepository
                .findTopByUserUsernameOrderByIdDesc(username)
                .orElse(null);
    }


    public List<Ride> getMyRequests(String username){
        return rideRepository
                .findByVehicleDriverUsernameAndStatus(username, "PENDING");
    }


//    public Ride acceptRide(Long rideId){
//
//        Ride ride = rideRepository.findById(rideId).orElseThrow();
//
//        ride.setStatus("ACCEPTED");
//
//        return rideRepository.save(ride);
//    }

//    public Ride acceptRide(Long rideId, String username){
//
//        Ride ride = rideRepository.findById(rideId).orElseThrow();
//
//        Vehicle vehicle = vehicleRepository
//                .findByDriverUsername(username)
//                .orElseThrow();
//
//        ride.setVehicle(vehicle);
//        ride.setStatus("ACCEPTED");
//
//        return rideRepository.save(ride);
//    }
public Ride acceptRide(Long rideId, String username){

    Ride ride = rideRepository.findById(rideId)
            .orElseThrow(() -> new RuntimeException("Ride not found"));

    Vehicle vehicle = vehicleRepository
            .findByDriverUsername(username)
            .orElseThrow(() -> new RuntimeException("Vehicle not found"));

    ride.setVehicle(vehicle);
    ride.setStatus("ACCEPTED");

    return rideRepository.save(ride);
}

    public List<Ride> getAllPending(){
        return rideRepository.findByStatus("PENDING");
    }

}
