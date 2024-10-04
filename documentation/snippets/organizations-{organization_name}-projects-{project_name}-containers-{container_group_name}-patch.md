```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.models.ContainerGroupPriority;
import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.models.ContainerGroupProbeGrpc;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttp;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeaders2;
import com.salad.cloud.sdk.models.ContainerGroupProbeTcp;
import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.models.ContainerProbeHttpScheme;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.DatadogTags3;
import com.salad.cloud.sdk.models.HttpCompression3;
import com.salad.cloud.sdk.models.HttpFormat3;
import com.salad.cloud.sdk.models.HttpHeaders4;
import com.salad.cloud.sdk.models.LoggingAxiom3;
import com.salad.cloud.sdk.models.LoggingDatadog3;
import com.salad.cloud.sdk.models.LoggingHttp3;
import com.salad.cloud.sdk.models.LoggingNewRelic3;
import com.salad.cloud.sdk.models.LoggingSplunk3;
import com.salad.cloud.sdk.models.LoggingTcp3;
import com.salad.cloud.sdk.models.QueueAutoscaler;
import com.salad.cloud.sdk.models.RegistryAuthenticationAwsEcr2;
import com.salad.cloud.sdk.models.RegistryAuthenticationBasic2;
import com.salad.cloud.sdk.models.RegistryAuthenticationDockerHub2;
import com.salad.cloud.sdk.models.RegistryAuthenticationGcpGar2;
import com.salad.cloud.sdk.models.RegistryAuthenticationGcpGcr2;
import com.salad.cloud.sdk.models.Resources;
import com.salad.cloud.sdk.models.UpdateContainer;
import com.salad.cloud.sdk.models.UpdateContainerGroup;
import com.salad.cloud.sdk.models.UpdateContainerGroupNetworking;
import com.salad.cloud.sdk.models.UpdateContainerLogging;
import com.salad.cloud.sdk.models.UpdateContainerRegistryAuthentication;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    List<String> gpuClasses = Arrays.asList("gpu_classes");

    Resources resources = Resources
      .builder()
      .cpu(3L)
      .memory(14678L)
      .gpuClasses(gpuClasses)
      .storageAmount(47984533464L)
      .build();

    List<String> command = Arrays.asList("command");

    LoggingAxiom3 loggingAxiom3 = LoggingAxiom3
      .builder()
      .host("aute veniam exercitation eiusmod et")
      .apiToken("mollit")
      .dataset("nisi in Lorem")
      .build();

    DatadogTags3 datadogTags3 = DatadogTags3.builder().name("name").value("value").build();

    List<DatadogTags3> tags = Arrays.asList(datadogTags3);

    LoggingDatadog3 loggingDatadog3 = LoggingDatadog3
      .builder()
      .host("velit officia consequat")
      .apiKey("sit in veniam")
      .tags(tags)
      .build();

    LoggingNewRelic3 loggingNewRelic3 = LoggingNewRelic3
      .builder()
      .host("consequat sed")
      .ingestionKey("tempor exercitation")
      .build();

    LoggingSplunk3 loggingSplunk3 = LoggingSplunk3
      .builder()
      .host("qui enim Ut nostrud deserunt")
      .token("cillum sint ullamco veniam occaecat")
      .build();

    LoggingTcp3 loggingTcp3 = LoggingTcp3.builder().host("Ut amet").port(30110L).build();

    HttpHeaders4 httpHeaders4 = HttpHeaders4.builder().name("name").value("value").build();

    List<HttpHeaders4> headers = Arrays.asList(httpHeaders4);

    LoggingHttp3 loggingHttp3 = LoggingHttp3
      .builder()
      .host("eiusmod labore proident sit ut")
      .port(17490L)
      .user("user")
      .password("password")
      .path("path")
      .format(HttpFormat3.JSON)
      .headers(headers)
      .compression(HttpCompression3.NONE)
      .build();

    UpdateContainerLogging updateContainerLogging = UpdateContainerLogging
      .builder()
      .axiom(loggingAxiom3)
      .datadog(loggingDatadog3)
      .newRelic(loggingNewRelic3)
      .splunk(loggingSplunk3)
      .tcp(loggingTcp3)
      .http(loggingHttp3)
      .build();

    RegistryAuthenticationBasic2 registryAuthenticationBasic2 = RegistryAuthenticationBasic2
      .builder()
      .username("username")
      .password("password")
      .build();

    RegistryAuthenticationGcpGcr2 registryAuthenticationGcpGcr2 = RegistryAuthenticationGcpGcr2
      .builder()
      .serviceKey("service_key")
      .build();

    RegistryAuthenticationAwsEcr2 registryAuthenticationAwsEcr2 = RegistryAuthenticationAwsEcr2
      .builder()
      .accessKeyId("access_key_id")
      .secretAccessKey("secret_access_key")
      .build();

    RegistryAuthenticationDockerHub2 registryAuthenticationDockerHub2 = RegistryAuthenticationDockerHub2
      .builder()
      .username("username")
      .personalAccessToken("personal_access_token")
      .build();

    RegistryAuthenticationGcpGar2 registryAuthenticationGcpGar2 = RegistryAuthenticationGcpGar2
      .builder()
      .serviceKey("service_key")
      .build();

    UpdateContainerRegistryAuthentication updateContainerRegistryAuthentication = UpdateContainerRegistryAuthentication
      .builder()
      .basic(registryAuthenticationBasic2)
      .gcpGcr(registryAuthenticationGcpGcr2)
      .awsEcr(registryAuthenticationAwsEcr2)
      .dockerHub(registryAuthenticationDockerHub2)
      .gcpGar(registryAuthenticationGcpGar2)
      .build();

    UpdateContainer updateContainer = UpdateContainer
      .builder()
      .image("labore")
      .resources(resources)
      .command(command)
      .priority(ContainerGroupPriority.HIGH)
      .environmentVariables(new HashMap())
      .logging(updateContainerLogging)
      .registryAuthentication(updateContainerRegistryAuthentication)
      .build();

    List<CountryCode> countryCodes = Arrays.asList(CountryCode.AF);

    UpdateContainerGroupNetworking updateContainerGroupNetworking = UpdateContainerGroupNetworking
      .builder()
      .port(35022L)
      .build();

    ContainerGroupProbeTcp containerGroupProbeTcp = ContainerGroupProbeTcp.builder().port(61900L).build();

    ContainerGroupProbeHttpHeaders2 containerGroupProbeHttpHeaders2 = ContainerGroupProbeHttpHeaders2
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeaders2> headers = Arrays.asList(containerGroupProbeHttpHeaders2);

    ContainerGroupProbeHttp containerGroupProbeHttp = ContainerGroupProbeHttp
      .builder()
      .path("path")
      .port(58759L)
      .scheme(ContainerProbeHttpScheme.HTTP)
      .headers(headers)
      .build();

    ContainerGroupProbeGrpc containerGroupProbeGrpc = ContainerGroupProbeGrpc
      .builder()
      .service("service")
      .port(32748L)
      .build();

    List<String> command = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(command).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(6L)
      .periodSeconds(10L)
      .timeoutSeconds(30L)
      .successThreshold(1L)
      .failureThreshold(3L)
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(4L)
      .periodSeconds(1L)
      .timeoutSeconds(1L)
      .successThreshold(1L)
      .failureThreshold(3L)
      .build();

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(10L)
      .periodSeconds(3L)
      .timeoutSeconds(10L)
      .successThreshold(2L)
      .failureThreshold(1200L)
      .build();

    QueueAutoscaler queueAutoscaler = QueueAutoscaler
      .builder()
      .minReplicas(96L)
      .maxReplicas(190L)
      .desiredQueueLength(42L)
      .pollingPeriod(684L)
      .maxUpscalePerMinute(95L)
      .maxDownscalePerMinute(10L)
      .build();

    UpdateContainerGroup updateContainerGroup = UpdateContainerGroup
      .builder()
      .displayName("01n75")
      .container(updateContainer)
      .replicas(232L)
      .countryCodes(countryCodes)
      .networking(updateContainerGroupNetworking)
      .livenessProbe(containerGroupLivenessProbe)
      .readinessProbe(containerGroupReadinessProbe)
      .startupProbe(containerGroupStartupProbe)
      .queueAutoscaler(queueAutoscaler)
      .build();

    ContainerGroup response = saladCloudSdk.containerGroupsService.updateContainerGroup(
      "oji7lyvxb3ca5hc",
      "olb1uzytbhhukf1u0-ahl0b9oqfjj",
      "s7z7dvdopv2czgde1zrufxgiv5tp-j",
      updateContainerGroup
    );

    System.out.println(response);
  }
}

```
