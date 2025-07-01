package com.salad.cloud.sdk.exceptions;

import com.salad.cloud.sdk.models.ProblemDetails;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ProblemDetails errors.
 */
@Getter
public class ProblemDetailsException extends ApiError {

  private final ProblemDetails error;

  public ProblemDetailsException(ProblemDetails error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
