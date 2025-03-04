package com.example

import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.Quotas;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: Quotas = saladCloudSdk.quotas.getQuotas("acme-corp");
    
    println(response);
}

