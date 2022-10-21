package com.feeder.drone.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.springframework.http.HttpStatus;

@Provider
public class ExceptionHandler implements ExceptionMapper<ExceptionsDefinitions> {

  /**
   * Map an exception to a {@link Response}. Returning {@code null} results in a
   * {@link Response.Status#NO_CONTENT} response. Throwing a runtime exception results in a
   * {@link Response.Status#INTERNAL_SERVER_ERROR} response.
   *
   * @param exception the exception to map to a response.
   *
   * @return a response mapped from the supplied exception.
   */
  @Override
  public Response toResponse(ExceptionsDefinitions exception) {
    var mensagemErro = exception.getMessage();
    var erro = new Error(mensagemErro).getMessage();
    var message = new MessageError(erro);
    return Response
        .status(HttpStatus.NOT_FOUND.value())
        .entity(message)
        .build();
  }
}
