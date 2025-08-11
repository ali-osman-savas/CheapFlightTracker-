package com.ucuzgider.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flight_routes",
       uniqueConstraints = @UniqueConstraint(columnNames = {"origin", "destination"}))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FlightRoute extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String origin;

    @Column(nullable = false, length = 100)
    private String destination;
}
