package com.salad.cloud.sdk.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TypeUtils {

  public static String getJsonPropertyName(Field type) {
    JsonProperty annotation = type.getAnnotation(JsonProperty.class);
    if (annotation != null) {
      return annotation.value();
    }
    return type.getName();
  }

  public static <Type> List<Type> createGenericList(Class<Type> type, Object... params) {
    List<Type> list = new ArrayList<>();
    for (Object param : params) {
      list.add((Type) param);
    }
    return list;
  }
}
