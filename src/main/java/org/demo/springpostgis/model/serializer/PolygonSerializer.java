package org.demo.springpostgis.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.locationtech.jts.geom.Polygon;

import java.io.IOException;

public class PolygonSerializer extends StdSerializer<Polygon> {

    public PolygonSerializer() {
        super(Polygon.class);
    }

    @Override
    public void serialize(Polygon value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", "Polygon");
        gen.writeArrayFieldStart("coordinates");
        // Serialize outer boundary
        gen.writeStartArray();
        for (int i = 0; i < value.getNumPoints(); i++) {
            gen.writeStartArray();
            gen.writeNumber(value.getExteriorRing().getCoordinateN(i).getX());
            gen.writeNumber(value.getExteriorRing().getCoordinateN(i).getY());
            gen.writeEndArray();
        }
        gen.writeEndArray();
        // Serialize interior rings (holes)
        for (int i = 0; i < value.getNumInteriorRing(); i++) {
            gen.writeStartArray();
            for (int j = 0; j < value.getInteriorRingN(i).getNumPoints(); j++) {
                gen.writeStartArray();
                gen.writeNumber(value.getInteriorRingN(i).getCoordinateN(j).getX());
                gen.writeNumber(value.getInteriorRingN(i).getCoordinateN(j).getY());
                gen.writeEndArray();
            }
            gen.writeEndArray();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
