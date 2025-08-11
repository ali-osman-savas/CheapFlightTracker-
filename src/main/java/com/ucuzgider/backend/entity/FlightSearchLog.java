package com.ucuzgider.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "flight_search_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightSearchLog extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 100)
    private String origin;

    @Column(length = 100)
    private String destination;

    @Column(name = "departure_start")
    private LocalDate departureStart;

    @Column(name = "departure_end")
    private LocalDate departureEnd;

    @Column(name = "max_price", precision = 10, scale = 2)
    private BigDecimal maxPrice;
}
