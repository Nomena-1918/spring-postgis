package org.demo.springpostgis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Geometry;

import java.util.StringJoiner;

@Setter
@Getter
@Entity
@Table(name = "test")
public class TestClass {
    @Id
    private Long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "geog")
    private Geometry geog;

    @Override
    public String toString() {
        return new StringJoiner(", ", TestClass.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("testName='" + testName + "'")
                .add("geog=" + geog.toString())
                .toString();
    }
}
