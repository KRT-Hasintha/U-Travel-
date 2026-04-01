package org.example.back_end.Repository;

import org.example.back_end.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    // 🔥 Find vehicles within certain distance from lat/lng
    @Query(value = "SELECT *, " +
            "(6371 * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:lng)) " +
            "+ sin(radians(:lat)) * sin(radians(latitude)))) AS distance " +
            "FROM vehicle " +
            "HAVING distance <= :radiusKm " +
            "ORDER BY distance", nativeQuery = true)
    List<Vehicle> findNearbyVehicles(
            @Param("lat") Double lat,
            @Param("lng") Double lng,
            @Param("radiusKm") Double radiusKm
    );


    Optional<Vehicle> findByDriverUsername(String username);
}
