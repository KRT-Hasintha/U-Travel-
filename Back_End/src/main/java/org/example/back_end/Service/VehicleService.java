package org.example.back_end.Service;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Dto.LocationDTO;
import org.example.back_end.Entity.User;
import org.example.back_end.Entity.Vehicle;
import org.example.back_end.Repository.UserRepository;
import org.example.back_end.Repository.VehicleRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;


    public Vehicle save(Vehicle vehicle){
        // get logged in provider
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User driver = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        vehicle.setDriver(driver);
        return vehicleRepository.save(vehicle);
    }


    public Vehicle updateLocation(Long vehicleId, Double lat, Double lng){
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setLatitude(lat);
        vehicle.setLongitude(lng);
        return vehicleRepository.save(vehicle);
    }


    public List<Vehicle> getAll(){
        return vehicleRepository.findAll();
    }

//    public List<Vehicle> getNearby(Double lat, Double lng, Double radiusKm){
//        return vehicleRepository.findNearbyVehicles(lat, lng, radiusKm);
//    }

    public List<Vehicle> getNearby(Double lat, Double lng, Double radiusKm){
        return vehicleRepository.findNearbyVehicles(lat, lng, radiusKm);
    }



    public void updateLocation(String username, LocationDTO dto) {

        Vehicle vehicle = vehicleRepository.findByDriverUsername(username)
                .orElseThrow();

        vehicle.setLatitude(dto.getLatitude());
        vehicle.setLongitude(dto.getLongitude());

        vehicleRepository.save(vehicle);
    }


}
