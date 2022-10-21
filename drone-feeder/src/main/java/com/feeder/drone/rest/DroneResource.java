package com.feeder.drone.rest;

import com.feeder.drone.dto.DroneDto;
import com.feeder.drone.entity.Drone;
import com.feeder.drone.exceptions.ExceptionsDefinitions;
import com.feeder.drone.service.DroneService;
import java.util.List;
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

@Path("/drone")
public class DroneResource {

  @Inject
  DroneService droneService;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createDrone(Drone droneToAdd) throws ExceptionsDefinitions {
    droneService.createDrone(droneToAdd);
    return Response.status(Status.CREATED).entity(droneToAdd).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllDrones() throws ExceptionsDefinitions {
    List<Drone> allDrones = droneService.getAllDrones();
    return Response.ok(allDrones).build();
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getDroneById(@PathParam("name") String droneName) throws ExceptionsDefinitions {
    Drone droneRegistered = droneService.getDroneByName(droneName);
    return Response.ok(droneRegistered).build();
  }

  @PUT
  @Path("/{drone_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateDrone(@PathParam("drone_id") Long droneId, DroneDto droneUpdate) throws ExceptionsDefinitions {
    Drone droneEntity = droneService.updateDrone(droneId, droneUpdate);
    return Response.accepted(droneEntity).build();
  }

  @DELETE
  @Path("/{drone_id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteDrone(@PathParam("drone_id") Long id) throws ExceptionsDefinitions {
    boolean isDeleted = droneService.deleteDrone(id);
    if (isDeleted) return Response.noContent().build();
    return Response.status(Response.Status.BAD_REQUEST).build();
  }

}
