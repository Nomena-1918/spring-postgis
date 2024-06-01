create table test
(
    id        serial primary key,
    test_name varchar(255),
    geog      geography
);

INSERT INTO test (test_name, geog) VALUES ('TestClass Point 1', ST_GeomFromText('POINT(-71.060316 48.432044)', 4326));
INSERT INTO test (test_name, geog) VALUES ('TestClass Line 1', ST_GeomFromText('LINESTRING(-71.060316 48.432044, -71.061123 48.431713)', 4326));
INSERT INTO test (test_name, geog) VALUES ('TestClass Polygon 1', ST_GeomFromText('POLYGON((-71.060316 48.432044, -71.061123 48.431713, -71.059612 48.430853, -71.060316 48.432044))', 4326));


CREATE TABLE us_states (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    density FLOAT,
    geom GEOMETRY(Polygon, 4326)
);
