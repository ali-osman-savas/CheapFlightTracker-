package com.ucuzgider.backend.dto;

import com.ucuzgider.backend.entity.FlightPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightPriceDto {
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private String provider;
    private BigDecimal price;
    private String currency;

    public static FlightPriceDto from(FlightPrice fp) {
        return new FlightPriceDto(
                fp.getRoute().getOrigin(),
                fp.getRoute().getDestination(),
                fp.getDepartureDate(),
                fp.getProvider(),
                fp.getPrice(),
                fp.getCurrency()
        );
    }
}
