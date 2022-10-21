package com.feeder.drone.exceptions;

public class ExceptionsDefinitions extends Exception {
    private static final long serialVersionUID = -8590604125147171026L;

    private String entity;

    public ExceptionsDefinitions(String entity, String message) {
      super(String.format("%s %s", entity, message));
    }
}
