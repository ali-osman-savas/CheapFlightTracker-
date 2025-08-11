package com.ucuzgider.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FlightSearchRequest {
    @NotBlank private String origin;
    @NotBlank private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal maxPrice;
    private Integer limit = 50;
}
