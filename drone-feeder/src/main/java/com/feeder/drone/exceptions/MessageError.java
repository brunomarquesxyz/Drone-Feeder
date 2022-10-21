package com.feeder.drone.exceptions;

import lombok.Data;
import lombok.NonNull;

/**
 * The type Message error.
 */
@Data
public class MessageError {
  @NonNull
  private String message;
}
