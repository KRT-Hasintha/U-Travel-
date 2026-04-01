package org.example.back_end.Service;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Entity.Villa;
import org.example.back_end.Repository.VillaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VillaService {

    private final VillaRepository villaRepository;

    // villa add karanna
    public Villa addVilla(Villa villa) {
        return villaRepository.save(villa);
    }

    // district ekata anuwa villa ganna
    public List<Villa> getVillasByDistrict(String district) {
        return villaRepository.findByDistrict(district);

    }
}
