package org.demo.springpostgis;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.demo.springpostgis.model.TestClass;
import org.demo.springpostgis.repository.TestRepository;
import org.demo.springpostgis.service.GeoJsonService;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringPostgisApplicationTests {

    TestRepository testRepository;
    GeoJsonService geoJsonService;


    public SpringPostgisApplicationTests(TestRepository testRepository, GeoJsonService geoJsonService) {
        this.testRepository = testRepository;
        this.geoJsonService = geoJsonService;
    }

    @Test
    void contextLoads() {
        List<TestClass> testClasses = testRepository.findAll();
        System.out.println("\n\n\n"+testClasses+"\n\n\n");
    }

    @Test
    void name() throws JsonProcessingException {
        String geojson = geoJsonService.getStatesAsGeoJson();
        System.out.println("\n\n"+geojson+"\n\n");
    }
}
