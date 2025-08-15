package com.ucuzgider.backend.controller;

import com.ucuzgider.backend.entity.FlightRoute;
import com.ucuzgider.backend.service.BaseService;
import com.ucuzgider.backend.service.FlightRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/flight-routes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FlightRouteController extends BaseController<FlightRoute, Long> {

    private final FlightRouteService flightRouteService;

    @Override
    protected BaseService<FlightRoute, Long> getService() {
        return flightRouteService;
    }

    @GetMapping("/search")
    public ResponseEntity<FlightRoute> findByOriginAndDestination(
            @RequestParam String origin,
            @RequestParam String destination) {
        
        Optional<FlightRoute> route = flightRouteService.findByOriginAndDestination(origin, destination);
        return route.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}