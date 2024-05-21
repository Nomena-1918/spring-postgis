package org.demo.springpostgis.repository;

import org.demo.springpostgis.model.City;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    @Query(value="SELECT * from us_cities us where ST_DistanceSphere(us.wkb_geometry, :p) < :distanceM", nativeQuery = true)
    Page<City> findNearWithinDistance(Point p, double distanceM, Pageable pageable);
}
