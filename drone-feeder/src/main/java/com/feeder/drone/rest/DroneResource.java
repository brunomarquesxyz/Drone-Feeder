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

/**
 * The type Drone resource.
 */
@Path("/drone")
public class DroneResource {

  /**
   * The Drone service.
   */
  @Inject
  DroneService droneService;

  /**
   * Create drone response.
   *
   * @param droneToAdd the drone to add
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createDrone(Drone droneToAdd) throws ExceptionsDefinitions {
    droneService.createDrone(droneToAdd);
    return Response.status(Status.CREATED).entity(droneToAdd).build();
  }

  /**
   * Gets all drones.
   *
   * @return the all drones
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllDrones() throws ExceptionsDefinitions {
    List<Drone> allDrones = droneService.getAllDrones();
    return Response.ok(allDrones).build();
  }

  /**
   * Gets drone by id.
   *
   * @param droneName the drone name
   * @return the drone by id
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getDroneById(@PathParam("name") String droneName) throws ExceptionsDefinitions {
    Drone droneRegistered = droneService.getDroneByName(droneName);
    return Response.ok(droneRegistered).build();
  }

  /**
   * Update drone response.
   *
   * @param droneId     the drone id
   * @param droneUpdate the drone update
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @PUT
  @Path("/{drone_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateDrone(@PathParam("drone_id") Long droneId, DroneDto droneUpdate) throws ExceptionsDefinitions {
    Drone droneEntity = droneService.updateDrone(droneId, droneUpdate);
    return Response.accepted(droneEntity).build();
  }

  /**
   * Delete drone response.
   *
   * @param id the id
   * @return the response
   * @throws ExceptionsDefinitions the exceptions definitions
   */
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
