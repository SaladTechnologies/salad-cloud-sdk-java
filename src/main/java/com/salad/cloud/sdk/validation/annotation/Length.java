package com.salad.cloud.sdk.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validates that a string is within a certain length range.
 * <p><b>min</b> is the lower boundary, default is 0</p>
 * <p><b>max</b> is the upper boundary, default is Integer.MAX_VALUE</p>
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Valid
public @interface Length {
  int min() default 0;

  int max() default Integer.MAX_VALUE;
}
