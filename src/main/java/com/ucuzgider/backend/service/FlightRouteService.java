package com.ucuzgider.backend.service;

import com.ucuzgider.backend.entity.FlightRoute;
import com.ucuzgider.backend.repository.BaseRepository;
import com.ucuzgider.backend.repository.FlightRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightRouteService extends BaseService<FlightRoute, Long> {

    private final FlightRouteRepository flightRouteRepository;

    @Override
    protected BaseRepository<FlightRoute, Long> getRepository() {
        return flightRouteRepository;
    }

    public Optional<FlightRoute> findByOriginAndDestination(String origin, String destination) {
        return flightRouteRepository.findByOriginAndDestination(origin, destination);
    }
}