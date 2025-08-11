package com.ucuzgider.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite_routes",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","route_id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteRoute extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "route_id", nullable = false)
    private FlightRoute route;
}
