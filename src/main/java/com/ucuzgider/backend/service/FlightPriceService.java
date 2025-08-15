package com.ucuzgider.backend.service;

import com.ucuzgider.backend.entity.FlightPrice;
import com.ucuzgider.backend.repository.BaseRepository;
import com.ucuzgider.backend.repository.FlightPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightPriceService extends BaseService<FlightPrice, Long> {

    private final FlightPriceRepository flightPriceRepository;

    @Override
    protected BaseRepository<FlightPrice, Long> getRepository() {
        return flightPriceRepository;
    }

    public List<FlightPrice> search(String origin, String destination, LocalDate start, LocalDate end, BigDecimal maxPrice, Pageable pageable) {
        return flightPriceRepository.search(origin, destination, start, end, maxPrice, pageable);
    }

    public List<Object[]> findCheapestDays(String origin, String destination, LocalDate start, LocalDate end, BigDecimal maxPrice) {
        return flightPriceRepository.findCheapestDays(origin, destination, start, end, maxPrice);
    }
}