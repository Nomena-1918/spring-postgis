package org.demo.springpostgis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.demo.springpostgis.model.State;
import org.demo.springpostgis.repository.StateRepository;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeoJsonService {

    private final StateRepository stateRepository;

    @Autowired
    public GeoJsonService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public String getStatesAsGeoJson() throws JsonProcessingException {
        List<State> states = stateRepository.findAllStates();

        Map<String, Object> featureCollection = new HashMap<>();
        featureCollection.put("type", "FeatureCollection");

        List<Map<String, Object>> features = states.stream().map(state -> {
            Map<String, Object> feature = new HashMap<>();
            feature.put("type", "Feature");

            Map<String, Object> properties = new HashMap<>();
            properties.put("name", state.getName());
            properties.put("density", state.getDensity());

            feature.put("properties", properties);

            GeoJsonWriter writer = new GeoJsonWriter();
            feature.put("geometry", writer.write(state.getGeom()));

            return feature;
        }).toList();

        featureCollection.put("features", features);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(featureCollection);
    }
}

