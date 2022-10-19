package com.feeder.drone.rest;

import com.feeder.drone.entity.Drone;
import com.feeder.drone.service.DroneService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/drone")
public class DroneResource {

  @Inject
  DroneService droneService;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createDrone(Drone droneToAdd) {
    droneService.createDrone(droneToAdd);
    return Response.ok(droneToAdd).build();
  }

}
