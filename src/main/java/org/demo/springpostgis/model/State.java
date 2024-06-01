package org.demo.springpostgis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;

@Getter
@Setter
@Entity(name = "us_states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ogc_fid")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "density")
    private double density;

    @Column(name = "wkb_geometry", columnDefinition = "geometry(Polygon,4326)")
    private Polygon geom;
}
