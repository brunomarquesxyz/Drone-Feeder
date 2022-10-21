package com.feeder.drone.exceptions;

import lombok.Data;
import lombok.NonNull;

@Data
public class MessageError {
  @NonNull
  private String message;
}
