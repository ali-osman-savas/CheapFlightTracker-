package com.ucuzgider.backend.controller;

import com.ucuzgider.backend.dto.CheapestDayDto;
import com.ucuzgider.backend.dto.FlightPriceDto;
import com.ucuzgider.backend.dto.FlightSearchRequest;
import com.ucuzgider.backend.service.FlightSearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightSearchController {
    private final FlightSearchService service;

    @PostMapping("/search")
    public List<FlightPriceDto> search(@RequestBody @Valid FlightSearchRequest req) {
        return service.search(req).stream().map(FlightPriceDto::from).toList();
    }

    @PostMapping("/cheapest-days")
    public List<CheapestDayDto> cheapest(@RequestBody @Valid FlightSearchRequest req) {
        return service.cheapestDays(req);
    }
}
