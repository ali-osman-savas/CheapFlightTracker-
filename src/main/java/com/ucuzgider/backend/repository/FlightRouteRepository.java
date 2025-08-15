package com.ucuzgider.backend.repository;

import com.ucuzgider.backend.entity.FlightRoute;
import java.util.Optional;

public interface FlightRouteRepository extends BaseRepository<FlightRoute, Long> {
    Optional<FlightRoute> findByOriginAndDestination(String origin, String destination);
}
