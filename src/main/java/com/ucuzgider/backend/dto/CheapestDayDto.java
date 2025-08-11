package com.ucuzgider.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CheapestDayDto(LocalDate day, BigDecimal minPrice) {}
