package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupQueueConnection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupQueueConnectionValidator extends AbstractModelValidator<ContainerGroupQueueConnection> {

  public ContainerGroupQueueConnectionValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupQueueConnectionValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupQueueConnection containerGroupQueueConnection) {
    return new ViolationAggregator()
      .add(new StringValidator("path").minLength(1).maxLength(1024), containerGroupQueueConnection.getPath())
      .add(new NumericValidator<Long>("port").min(1L).max(65535L), containerGroupQueueConnection.getPort())
      .add(
        new StringValidator("queueName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        containerGroupQueueConnection.getQueueName()
      )
      .aggregate();
  }
}
