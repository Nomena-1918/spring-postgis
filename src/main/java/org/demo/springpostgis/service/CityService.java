package org.demo.springpostgis.service;

import org.demo.springpostgis.model.City;
import org.demo.springpostgis.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repo;

    public CityService(CityRepository repo) {
        this.repo = repo;
    }

    // WGS-84 SRID
    private final GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    public Page<City> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
    public Page<City> findAround(double lat, double lon, double distanceM, Pageable pageable){
        Point p = factory.createPoint(new Coordinate(lon, lat));
        return repo.findNearWithinDistance(p, distanceM, pageable);
    }
}