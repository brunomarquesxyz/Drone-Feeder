package com.feeder.drone.exceptions;

/**
 * The type Exceptions definitions.
 */
public class ExceptionsDefinitions extends Exception {
    private static final long serialVersionUID = -8590604125147171026L;

    private String entity;

  /**
   * Instantiates a new Exceptions definitions.
   *
   * @param entity  the entity
   * @param message the message
   */
  public ExceptionsDefinitions(String entity, String message) {
      super(String.format("%s %s", entity, message));
    }
}
