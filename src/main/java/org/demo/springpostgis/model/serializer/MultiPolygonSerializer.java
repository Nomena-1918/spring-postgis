package org.demo.springpostgis.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

import java.io.IOException;

public class MultiPolygonSerializer extends StdSerializer<MultiPolygon> {

    public MultiPolygonSerializer() {
        super(MultiPolygon.class);
    }

    @Override
    public void serialize(MultiPolygon value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", "MultiPolygon");
        gen.writeArrayFieldStart("coordinates");
        for (int i = 0; i < value.getNumGeometries(); i++) {
            gen.writeStartArray();
            // Serialize each polygon
            Polygon polygon = (Polygon) value.getGeometryN(i);
            // Use PolygonSerializer here
            //...
            gen.writeEndArray();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
