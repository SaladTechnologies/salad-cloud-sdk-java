package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class RecipesQuotas {

  @NonNull
  @JsonProperty("max_created_recipe_deployments")
  private Long maxCreatedRecipeDeployments;

  @NonNull
  @JsonProperty("recipe_instance_quota")
  private Long recipeInstanceQuota;
}
