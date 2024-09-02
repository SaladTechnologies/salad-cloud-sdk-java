package com.salad.cloud.sdk.hook;

import java.util.Map;
import okhttp3.Request;
import okhttp3.Response;

/** Liblab Hook interface */
public interface Hook {
  /**
   * Is called before the request is made to the API
   *
   * @param request the request about to be made by the SDK
   * @return the modified request to proceed with
   */
  Request beforeRequest(Request request, Map<String, String> additionalParameters);

  /**
   * Is called after the response has returned
   *
   * @param request the request that was made by the SDK
   * @param response the response coming back from the API the SDK has called
   * @return the modified response to proceed with
   */
  Response afterResponse(Request request, Response response, Map<String, String> additionalParameters);

  /**
   * Is called when an error occurs in the SDK
   *
   * @param request the request that was made by the SDK
   * @param exception The Exception thrown
   */
  void onError(Request request, Exception exception, Map<String, String> additionalParameters);
}
