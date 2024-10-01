package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.GpuClassesList;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OrganizationDataService Service
 */
public class OrganizationDataService extends BaseService {

  public OrganizationDataService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List the GPU Classes
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code GpuClassesList}
   */
  public GpuClassesList listGpuClasses(@NonNull String organizationName) throws ApiException, ValidationException {
    Request request = this.buildListGpuClassesRequest(organizationName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<GpuClassesList>() {});
  }

  /**
   * List the GPU Classes
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code GpuClassesList}
   */
  public CompletableFuture<GpuClassesList> listGpuClassesAsync(@NonNull String organizationName)
    throws ApiException, ValidationException {
    Request request = this.buildListGpuClassesRequest(organizationName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<GpuClassesList>() {});
    });
  }

  private Request buildListGpuClassesRequest(@NonNull String organizationName) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .validate(organizationName)
      )
      .validateAll();

    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "organizations/{organization_name}/gpu-classes")
      .setPathParameter("organization_name", organizationName)
      .build();
  }
}
