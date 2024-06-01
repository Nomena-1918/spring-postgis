package org.demo.springpostgis.controller;

import org.demo.springpostgis.service.GeoJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoJsonController {
    private final GeoJsonService geoJsonService;

    @Autowired
    public GeoJsonController(GeoJsonService geoJsonService) {
        this.geoJsonService = geoJsonService;
    }
    @GetMapping("/geojson")
    public String getGeoJson() {
        try {
            return geoJsonService.getStatesAsGeoJson();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
