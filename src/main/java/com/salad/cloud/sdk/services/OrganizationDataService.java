package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiError;
import com.salad.cloud.sdk.exceptions.ProblemDetailsException;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.CpuAvailability;
import com.salad.cloud.sdk.models.CpuAvailabilityPrototype;
import com.salad.cloud.sdk.models.GpuAvailability;
import com.salad.cloud.sdk.models.GpuAvailabilityPrototype;
import com.salad.cloud.sdk.models.GpuClassesList;
import com.salad.cloud.sdk.models.ProblemDetails;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.GpuAvailabilityPrototypeValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OrganizationDataService Service
 */
public class OrganizationDataService extends BaseService {

  public OrganizationDataService(@NonNull OkHttpClient httpClient, SaladCloudSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * List the GPU Classes
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code GpuClassesList}
   */
  public GpuClassesList listGpuClasses(@NonNull String organizationName) throws ApiError, ValidationException {
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildListGpuClassesRequest(organizationName);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<GpuClassesList>() {});
  }

  /**
   * List the GPU Classes
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code CompletableFuture<GpuClassesList>}
   */
  public CompletableFuture<GpuClassesList> listGpuClassesAsync(@NonNull String organizationName)
    throws ApiError, ValidationException {
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildListGpuClassesRequest(organizationName);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<GpuClassesList>() {});
    });
  }

  private Request buildListGpuClassesRequest(@NonNull String organizationName) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/gpu-classes"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .build();
  }

  /**
   * Get CPU Availability
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param cpuAvailabilityPrototype {@link CpuAvailabilityPrototype} Request Body
   * @return response of {@code CpuAvailability}
   */
  public CpuAvailability getCpuAvailability(
    @NonNull String organizationName,
    @NonNull CpuAvailabilityPrototype cpuAvailabilityPrototype
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(401, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(403, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildGetCpuAvailabilityRequest(organizationName, cpuAvailabilityPrototype);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<CpuAvailability>() {});
  }

  /**
   * Get CPU Availability
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param cpuAvailabilityPrototype {@link CpuAvailabilityPrototype} Request Body
   * @return response of {@code CompletableFuture<CpuAvailability>}
   */
  public CompletableFuture<CpuAvailability> getCpuAvailabilityAsync(
    @NonNull String organizationName,
    @NonNull CpuAvailabilityPrototype cpuAvailabilityPrototype
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(401, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(403, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildGetCpuAvailabilityRequest(organizationName, cpuAvailabilityPrototype);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<CpuAvailability>() {});
    });
  }

  private Request buildGetCpuAvailabilityRequest(
    @NonNull String organizationName,
    @NonNull CpuAvailabilityPrototype cpuAvailabilityPrototype
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/availability/sce-cpu-availability"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setJsonContent(cpuAvailabilityPrototype)
      .build();
  }

  /**
   * Get GPU Availability
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param gpuAvailabilityPrototype {@link GpuAvailabilityPrototype} Request Body
   * @return response of {@code GpuAvailability}
   */
  public GpuAvailability getGpuAvailability(
    @NonNull String organizationName,
    @NonNull GpuAvailabilityPrototype gpuAvailabilityPrototype
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(401, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(403, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildGetGpuAvailabilityRequest(organizationName, gpuAvailabilityPrototype);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<GpuAvailability>() {});
  }

  /**
   * Get GPU Availability
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param gpuAvailabilityPrototype {@link GpuAvailabilityPrototype} Request Body
   * @return response of {@code CompletableFuture<GpuAvailability>}
   */
  public CompletableFuture<GpuAvailability> getGpuAvailabilityAsync(
    @NonNull String organizationName,
    @NonNull GpuAvailabilityPrototype gpuAvailabilityPrototype
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(401, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(403, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildGetGpuAvailabilityRequest(organizationName, gpuAvailabilityPrototype);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<GpuAvailability>() {});
    });
  }

  private Request buildGetGpuAvailabilityRequest(
    @NonNull String organizationName,
    @NonNull GpuAvailabilityPrototype gpuAvailabilityPrototype
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(
        new GpuAvailabilityPrototypeValidator("gpuAvailabilityPrototype").required().validate(gpuAvailabilityPrototype)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/availability/sce-gpu-availability"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setJsonContent(gpuAvailabilityPrototype)
      .build();
  }
}
