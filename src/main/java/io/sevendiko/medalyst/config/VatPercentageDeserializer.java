package io.sevendiko.medalyst.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.sevendiko.medalyst.model.VatPercentage;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;


public class VatPercentageDeserializer extends JsonDeserializer<VatPercentage> {

    @Override
    public VatPercentage deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        int value = jsonParser.getIntValue();
        return VatPercentage.fromValue(value);
    }

}
