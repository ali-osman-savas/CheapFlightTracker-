package com.ucuzgider.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "flight_prices",
       uniqueConstraints = @UniqueConstraint(columnNames = {"route_id","departure_date","provider"}),
       indexes = @Index(name = "idx_prices_route_date_price", columnList = "route_id, departure_date, price"))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FlightPrice extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "route_id", nullable = false)
    private FlightRoute route;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(length = 50)
    private String provider;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 10, nullable = false)
    @Builder.Default
    private String currency = "TRY";
}
