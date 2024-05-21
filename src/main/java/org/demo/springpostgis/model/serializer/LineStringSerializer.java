package org.demo.springpostgis.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.locationtech.jts.geom.LineString;

import java.io.IOException;

public class LineStringSerializer extends StdSerializer<LineString> {

    public LineStringSerializer() {
        super(LineString.class);
    }

    @Override
    public void serialize(LineString value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", "LineString");
        gen.writeArrayFieldStart("coordinates");
        for (int i = 0; i < value.getNumPoints(); i++) {
            gen.writeStartArray();
            gen.writeNumber(value.getCoordinateN(i).getX());
            gen.writeNumber(value.getCoordinateN(i).getY());
            gen.writeEndArray();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
