package com.ucuzgider.backend.repository;

import com.ucuzgider.backend.entity.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FlightRouteRepository extends JpaRepository<FlightRoute, Long> {
    Optional<FlightRoute> findByOriginAndDestination(String origin, String destination);
}
