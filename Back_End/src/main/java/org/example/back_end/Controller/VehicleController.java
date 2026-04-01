package org.example.back_end.Controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Dto.LocationDTO;
import org.example.back_end.Entity.Vehicle;
import org.example.back_end.Service.VehicleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleController {

    private final VehicleService vehicleService;


    @PostMapping
    @PreAuthorize("hasAnyRole('PROVIDER','ADMIN')")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }


    @PutMapping("/update-location")
    @PreAuthorize("hasAnyRole('PROVIDER','ADMIN')")
    public void updateLocation(@RequestBody LocationDTO dto, Authentication auth) {
        vehicleService.updateLocation(auth.getName(), dto);
    }


    @GetMapping("/nearby")
    @PreAuthorize("hasRole('USER')")
//    public List<Vehicle> getNearby(@RequestParam Double lat,
//                                   @RequestParam Double lng){
//        return vehicleService.getAll();
//    }
    public List<Vehicle> getNearby(@RequestParam Double lat,
                                   @RequestParam Double lng) {
        return vehicleService.getNearby(lat, lng, 10.0); // 10km radius
    }
}
