package org.example.back_end.Controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Repository.LocationRepository;
import org.example.back_end.Repository.UserRepository;
import org.example.back_end.Repository.VehicleRepository;
import org.example.back_end.Repository.VillaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.back_end.Entity.Role;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final VillaRepository villaRepository;
    private final VehicleRepository vehicleRepository;

    @GetMapping("/stats")
    public Map<String, Long> getStats(){

        Map<String, Long> stats = new HashMap<>();

        stats.put("users", userRepository.countByRole(Role.USER));
        stats.put("providers", userRepository.countByRole(Role.PROVIDER));
        stats.put("locations", locationRepository.count());
        stats.put("villas", villaRepository.count());
        stats.put("vehicles", vehicleRepository.count());

        return stats;
    }
}
