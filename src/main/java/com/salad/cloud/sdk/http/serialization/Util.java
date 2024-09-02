package com.salad.cloud.sdk.http.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salad.cloud.sdk.json.TypeUtils;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.SneakyThrows;

public class Util {

  public static Map<String, Object> getPropertiesWithJsonPropertyNames(Object value) {
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> properties = objectMapper.convertValue(value, new TypeReference<Map<String, Object>>() {});

    // Use the json property name if it exists, otherwise use the regular property name
    return properties
      .entrySet()
      .stream()
      .collect(
        Collectors.toMap(
          entry -> {
            try {
              Field field = entry.getValue().getClass().getField(entry.getKey());
              return TypeUtils.getJsonPropertyName(field);
            } catch (NoSuchFieldException e) {
              return entry.getKey();
            }
          },
          Map.Entry::getValue
        )
      );
  }

  @SneakyThrows
  public static String urlEncode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
  }

  public static boolean isPrimitive(Object value) {
    return (
      value instanceof Long ||
      value instanceof Integer ||
      value instanceof Double ||
      value instanceof Float ||
      value instanceof Boolean ||
      value instanceof String ||
      value instanceof Character
    );
  }

  public static boolean isObject(Object value) {
    return !isPrimitive(value) && !(value instanceof Iterable);
  }
}
