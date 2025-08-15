package com.ucuzgider.backend.controller;

import com.ucuzgider.backend.entity.FlightPrice;
import com.ucuzgider.backend.service.BaseService;
import com.ucuzgider.backend.service.FlightPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flight-prices")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FlightPriceController extends BaseController<FlightPrice, Long> {

    private final FlightPriceService flightPriceService;

    @Override
    protected BaseService<FlightPrice, Long> getService() {
        return flightPriceService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightPrice>> search(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end,
            @RequestParam(required = false) BigDecimal maxPrice,
            Pageable pageable) {
        
        List<FlightPrice> results = flightPriceService.search(origin, destination, start, end, maxPrice, pageable);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/cheapest-days")
    public ResponseEntity<List<Object[]>> findCheapestDays(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end,
            @RequestParam(required = false) BigDecimal maxPrice) {
        
        List<Object[]> results = flightPriceService.findCheapestDays(origin, destination, start, end, maxPrice);
        return ResponseEntity.ok(results);
    }
}