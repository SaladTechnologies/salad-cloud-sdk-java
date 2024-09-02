package com.salad.cloud.sdk.http.serialization;

public enum QuerySerializationStyle {
  FORM(SerializationStyle.FORM),
  SPACE_DELIMITED(SerializationStyle.SPACE_DELIMITED),
  PIPE_DELIMITED(SerializationStyle.PIPE_DELIMITED),
  DEEP_OBJECT(SerializationStyle.DEEP_OBJECT);

  public final SerializationStyle style;

  QuerySerializationStyle(SerializationStyle style) {
    this.style = style;
  }
}
