package org.example.back_end.Repository;

import org.example.back_end.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {


}
