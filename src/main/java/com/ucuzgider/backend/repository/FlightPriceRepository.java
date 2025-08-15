package com.ucuzgider.backend.repository;

import com.ucuzgider.backend.entity.FlightPrice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface FlightPriceRepository extends BaseRepository<FlightPrice, Long> {

    @Query("""
      SELECT fp FROM FlightPrice fp
      WHERE fp.route.origin = :origin
        AND fp.route.destination = :destination
        AND (:start IS NULL OR fp.departureDate >= :start)
        AND (:end   IS NULL OR fp.departureDate <= :end)
        AND (:maxPrice IS NULL OR fp.price <= :maxPrice)
      ORDER BY fp.price ASC, fp.departureDate ASC
    """)
    List<FlightPrice> search(@Param("origin") String origin,
                             @Param("destination") String destination,
                             @Param("start") LocalDate start,
                             @Param("end") LocalDate end,
                             @Param("maxPrice") BigDecimal maxPrice,
                             Pageable pageable);

    @Query("""
      SELECT fp.departureDate as day, MIN(fp.price) as minPrice
      FROM FlightPrice fp
      WHERE fp.route.origin = :origin
        AND fp.route.destination = :destination
        AND (:start IS NULL OR fp.departureDate >= :start)
        AND (:end   IS NULL OR fp.departureDate <= :end)
        AND (:maxPrice IS NULL OR fp.price <= :maxPrice)
      GROUP BY fp.departureDate
      ORDER BY MIN(fp.price) ASC
    """)
    List<Object[]> findCheapestDays(@Param("origin") String origin,
                                    @Param("destination") String destination,
                                    @Param("start") LocalDate start,
                                    @Param("end") LocalDate end,
                                    @Param("maxPrice") BigDecimal maxPrice);
}
