package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class LoggingHttp3 {

  @NonNull
  private String host;

  @NonNull
  private Long port;

  @NonNull
  private HttpFormat3 format;

  @NonNull
  private HttpCompression3 compression;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String user;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String password;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String path;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<HttpHeaders4> headers;
}
