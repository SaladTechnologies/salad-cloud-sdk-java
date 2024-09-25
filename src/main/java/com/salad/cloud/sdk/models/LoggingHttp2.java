package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class LoggingHttp2 {

  @NonNull
  private String host;

  @NonNull
  private Long port;

  @NonNull
  private HttpFormat2 format;

  @NonNull
  private HttpCompression2 compression;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String user;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String password;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String path;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<HttpHeaders3> headers;
}
