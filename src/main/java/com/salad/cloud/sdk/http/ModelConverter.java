package com.salad.cloud.sdk.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.openapitools.jackson.nullable.JsonNullableModule;

public final class ModelConverter {

  private static final Logger logger = Logger.getLogger(ModelConverter.class.getName());
  private static final ObjectMapper mapper = new ObjectMapper();

  static {
    mapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    mapper.enable(DeserializationFeature.USE_LONG_FOR_INTS);
    mapper.registerModule(new JsonNullableModule());
  }

  private ModelConverter() {}

  public static <T> T convert(final Response response, final Class<T> clazz) {
    try {
      return convert(response.body().bytes(), clazz);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to read response body: " + e.getMessage(), e);
      return null;
    }
  }

  public static <T> T convert(final byte[] bodyBytes, final Class<T> clazz) {
    try {
      if (bodyBytes == null || bodyBytes.length == 0) {
        logger.log(Level.FINE, "Received empty response body, returning null");
        return null;
      }

      return mapper.readValue(bodyBytes, clazz);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to read response body: " + e.getMessage(), e);
      return null;
    }
  }

  public static <T> T convert(final String response, final Class<T> clazz) {
    try {
      // Handle empty responses
      if (response == null || response.trim().isEmpty()) {
        logger.log(Level.FINE, "Received empty response string, returning null");
        return null;
      }
      return mapper.readValue(response, clazz);
    } catch (MismatchedInputException e) {
      logger.log(Level.SEVERE, "Failed to parse response - invalid or malformed JSON: " + e.getMessage(), e);
      return null;
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Unexpected error parsing response: " + e.getMessage(), e);
      return null;
    }
  }

  public static <T> T convert(Response response, TypeReference<T> typeReference) {
    try {
      return convert(response.body().bytes(), typeReference);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to read response body: " + e.getMessage(), e);
      return null;
    }
  }

  public static <T> T convert(byte[] bodyBytes, TypeReference<T> typeReference) {
    try {
      if (bodyBytes == null || bodyBytes.length == 0) {
        logger.log(Level.FINE, "Received empty response body, returning null");
        return null;
      }

      return mapper.readValue(bodyBytes, typeReference);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to read response body: " + e.getMessage(), e);
      return null;
    }
  }

  public static <T> T convert(String response, TypeReference<T> typeReference) {
    try {
      // Handle empty responses
      if (response == null || response.trim().isEmpty()) {
        logger.log(Level.FINE, "Received empty response string, returning null");
        return null;
      }
      return mapper.readValue(response, typeReference);
    } catch (MismatchedInputException e) {
      logger.log(Level.SEVERE, "Failed to parse response - invalid or malformed JSON: " + e.getMessage(), e);
      return null;
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Unexpected error parsing response: " + e.getMessage(), e);
      return null;
    }
  }

  public static String readString(Response response) {
    try {
      return response.body().string();
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to read response body as string: " + e.getMessage(), e);
      return null;
    }
  }

  public static byte[] readBytes(Response response) {
    try {
      return response.body().bytes();
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to read response body as bytes: " + e.getMessage(), e);
      return null;
    }
  }

  public static String toBodyString(byte[] bodyBytes) {
    try {
      return new String(bodyBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to convert body bytes to string: " + e.getMessage(), e);
      return "";
    }
  }

  public static String modelToJson(final Object model) {
    try {
      return mapper.writeValueAsString(model);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to serialize model to JSON: " + e.getMessage(), e);
      return null;
    }
  }
}
