package org.demo.springpostgis;

import org.demo.springpostgis.model.TestClass;
import org.demo.springpostgis.repository.TestRepository;
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

    @Autowired
    public SpringPostgisApplicationTests(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    @Test
    void contextLoads() {
        List<TestClass> testClasses = testRepository.findAll();
        System.out.println("\n\n\n"+testClasses+"\n\n\n");
    }
}
