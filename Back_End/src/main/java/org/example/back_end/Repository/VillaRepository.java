package org.example.back_end.Repository;

import org.example.back_end.Entity.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VillaRepository extends JpaRepository<Villa,Long> {
    List<Villa> findByDistrict(String district);
}
