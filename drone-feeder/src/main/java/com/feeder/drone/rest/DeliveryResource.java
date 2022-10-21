package com.feeder.drone.rest;

import com.feeder.drone.dto.DeliveryDto;
import com.feeder.drone.entity.Delivery;
import com.feeder.drone.exceptions.ExceptionsDefinitions;
import com.feeder.drone.service.DeliveryService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * The type Delivery resource.
 */
@Path("/delivery")
public class DeliveryResource {

  /**
   * The Delivery service.
   */
  @Inject
  DeliveryService deliveryService;

  /**
   * Find all deliveries response.
   *
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAllDeliveries() throws ExceptionsDefinitions {
    return Response
        .ok(deliveryService.getAllDelivery())
        .build();
  }

  /**
   * Find delivery id response.
   *
   * @param deliveryID the delivery id
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findDeliveryId(@PathParam("id") Long deliveryID) throws ExceptionsDefinitions {
    return Response
        .ok(deliveryService.getDeliveryById(deliveryID))
        .build();
  }

  /**
   * Create delivery response.
   *
   * @param deliveryDto the delivery dto
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createDelivery(DeliveryDto deliveryDto) throws ExceptionsDefinitions {
    return Response
        .status(Status.CREATED)
        .entity(deliveryService.createDelivery(deliveryDto))
        .build();
  }

  /**
   * Update delivery response.
   *
   * @param updatesData the updates data
   * @param deliveryId  the delivery id
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateDelivery(Delivery updatesData, @PathParam("id") Long deliveryId)
      throws ExceptionsDefinitions {
    return Response
        .status(Status.ACCEPTED)
        .entity(deliveryService.update(updatesData, deliveryId))
        .build();
  }

  /**
   * Delete delivery response.
   *
   * @param deliveryId the delivery id
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @DELETE
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteDelivery(@PathParam("id") Long deliveryId) throws ExceptionsDefinitions {
    if (deliveryService.deleteDelivery(deliveryId)) {
      return Response.noContent().build();
    }
    return Response.status(Status.NOT_FOUND).build();
  }

}
