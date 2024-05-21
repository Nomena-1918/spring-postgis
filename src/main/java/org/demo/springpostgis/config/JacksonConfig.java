package org.demo.springpostgis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.demo.springpostgis.model.serializer.*;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Point.class, new PointSerializer());
        module.addSerializer(LineString.class, new LineStringSerializer());
        module.addSerializer(Polygon.class, new PolygonSerializer());
        module.addSerializer(MultiPolygon.class, new MultiPolygonSerializer());
        mapper.registerModule(module);
        return mapper;
    }
}

