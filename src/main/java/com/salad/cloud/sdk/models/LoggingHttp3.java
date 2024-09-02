package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salad.cloud.sdk.validation.annotation.Length;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
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
public class LoggingHttp3 {

  @NonNull
  @Length(min = 1, max = 1000)
  private String host;

  @NonNull
  @Max(65535)
  @Min(1)
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
