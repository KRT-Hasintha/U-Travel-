package org.example.back_end.Repository;

import org.example.back_end.Entity.Role;
import org.example.back_end.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT COUNT(u) FROM User u WHERE u.role = :role")
//    Long countByRole(@Param("role") String role);
    Long countByRole(Role role);
}
