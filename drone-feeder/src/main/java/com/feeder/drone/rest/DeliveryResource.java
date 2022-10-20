package com.feeder.drone.rest;

import com.feeder.drone.dto.DeliveryDto;
import com.feeder.drone.service.DeliveryService;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
  public Response findDeliveryId(@PathParam("id") UUID deliveryID) {
    return Response
        .ok(deliveryService.getDeliveryById(deliveryID))
        .build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createDelivery(DeliveryDto deliveryDto) {
    return Response
        .ok(deliveryService.createDelivery(deliveryDto))
        .build();
  }
}
