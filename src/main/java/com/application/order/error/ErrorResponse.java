package com.application.order.error;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilder.class)
public class ErrorResponse {

  private final int status;
  private final List<String> erroritems;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class ErrorResponseBuilder {
  }
}
