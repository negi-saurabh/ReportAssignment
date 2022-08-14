package com.surepay.reports.utilities;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Map;

public class JSONDeserializer extends JsonDeserializer<Map<String, Object>> {

  @Override
  public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JacksonException {
    return null;
  }


}
