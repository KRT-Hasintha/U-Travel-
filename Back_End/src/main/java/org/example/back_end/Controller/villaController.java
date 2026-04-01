package org.example.back_end.Controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Entity.Villa;
import org.example.back_end.Repository.VillaRepository;
import org.example.back_end.Service.VillaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/villas")
@RequiredArgsConstructor
@CrossOrigin( origins = "http://localhost:5500", // ඔබේ frontend URL
        allowedHeaders = "*",
        exposedHeaders = "*",
        allowCredentials = "true")
public class villaController {


    private final VillaService villaService;


    @PostMapping
    @PreAuthorize("hasAnyRole('PROVIDER','ADMIN')")
    public Villa addVilla(@RequestBody Villa villa){
        return villaService.addVilla(villa);
    }


    @GetMapping("/by-district")
    @PreAuthorize("hasRole('USER')")
    public List<Villa> getByDistrict(@RequestParam String district){
        return villaService.getVillasByDistrict(district);


    }
}
