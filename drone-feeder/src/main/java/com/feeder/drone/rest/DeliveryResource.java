package com.feeder.drone.rest;

import com.feeder.drone.dto.DeliveryDto;
import com.feeder.drone.entity.Delivery;
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


@Path("/delivery")
public class DeliveryResource {

  @Inject
  DeliveryService deliveryService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAllDeliveries() {
    return Response
        .ok(deliveryService.getAllDelivery())
        .build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findDeliveryId(@PathParam("id") Long deliveryID) {
    return Response
        .ok(deliveryService.getDeliveryById(deliveryID))
        .build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createDelivery(DeliveryDto deliveryDto) {
    return Response
        .status(Status.CREATED)
        .entity(deliveryService.createDelivery(deliveryDto))
        .build();
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateDelivery(Delivery updatesData, @PathParam("id") Long deliveryId) {
    return Response
        .status(Status.ACCEPTED)
        .entity(deliveryService.update(updatesData, deliveryId))
        .build();
  }

  @DELETE
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteDelivery(@PathParam("id") Long deliveryId) {
    if (deliveryService.deleteDelivery(deliveryId)) {
      return Response.noContent().build();
    }
    return Response.status(Status.NOT_FOUND).build();
  }

}
