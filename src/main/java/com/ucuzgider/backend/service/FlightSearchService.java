package com.ucuzgider.backend.service;

import com.ucuzgider.backend.dto.CheapestDayDto;
import com.ucuzgider.backend.dto.FlightSearchRequest;
import com.ucuzgider.backend.entity.FlightPrice;
import com.ucuzgider.backend.repository.FlightPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightSearchService {
    private final com.ucuzgider.backend.repository.FlightPriceRepository priceRepo;

    public List<FlightPrice> search(FlightSearchRequest req) {
        var pageable = PageRequest.of(0, req.getLimit() == null ? 50 : req.getLimit());
        return priceRepo.search(
                req.getOrigin(), req.getDestination(),
                req.getStartDate(), req.getEndDate(),
                req.getMaxPrice(), pageable
        );
    }

    public List<CheapestDayDto> cheapestDays(FlightSearchRequest req) {
        var rows = priceRepo.findCheapestDays(
                req.getOrigin(), req.getDestination(),
                req.getStartDate(), req.getEndDate(),
                req.getMaxPrice()
        );
        return rows.stream()
                .map(r -> new CheapestDayDto((java.time.LocalDate) r[0], (java.math.BigDecimal) r[1]))
                .toList();
    }
}
