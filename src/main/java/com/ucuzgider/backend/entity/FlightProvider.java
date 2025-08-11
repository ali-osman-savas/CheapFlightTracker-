package com.ucuzgider.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flight_providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightProvider extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "base_url", length = 255)
    private String baseUrl;

    @Column(name = "api_key", length = 255)
    private String apiKey;
}
