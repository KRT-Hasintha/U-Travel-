package org.example.back_end.Controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Entity.Location;
import org.example.back_end.Repository.LocationRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {
    private final LocationRepository repo;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','PROVIDER')")
    public Location add(@RequestBody Location l){
        return repo.save(l);
    }

    @GetMapping
    public List<Location> getAll(){
        return repo.findAll();
    }
}
