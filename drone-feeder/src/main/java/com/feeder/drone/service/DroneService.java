package com.feeder.drone.service;

import com.feeder.drone.dto.DroneDto;
import com.feeder.drone.entity.Drone;
import com.feeder.drone.exceptions.ExceptionsDefinitions;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * The type Drone service.
 */
@ApplicationScoped
public class DroneService {

  /**
   * Create drone.
   *
   * @param droneToAdd the drone to add
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @Transactional
  public void createDrone(Drone droneToAdd) throws ExceptionsDefinitions {
    Drone.persist(droneToAdd);
    if (!droneToAdd.isPersistent()) {
      throw new ExceptionsDefinitions("Invalid", "Operation");
    }
  }

  /**
   * Gets all drones.
   *
   * @return the all drones
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  public List<Drone> getAllDrones() throws ExceptionsDefinitions {
    List<Drone> allDrones = Drone.listAll();
    if (allDrones == null) {
      throw new ExceptionsDefinitions("Bad", "Request");
    }
    return allDrones;
  }

  /**
   * Gets drone by name.
   *
   * @param droneName the drone name
   * @return the drone by name
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  public Drone getDroneByName(String droneName) throws ExceptionsDefinitions {
    Drone droneRegistered = Drone.findByName(droneName);
    if (droneRegistered == null) {
      throw new ExceptionsDefinitions(droneName, "not found");
    }
    return droneRegistered;
  }

  /**
   * Update drone drone.
   *
   * @param id            the id
   * @param droneToUpdate the drone to update
   * @return the drone
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @Transactional
  public Drone updateDrone(Long id, DroneDto droneToUpdate) throws ExceptionsDefinitions {
    Drone entity = Drone.findById(id);
    if (entity == null) {
      throw new ExceptionsDefinitions(id.toString(), "is not a valid ID");
    }

    entity.setLatitude(droneToUpdate.getLatitude());
    entity.setLongitude(droneToUpdate.getLongitude());

    Drone.persist(entity);

    return entity;
  }

  /**
   * Delete drone boolean.
   *
   * @param droneId the drone id
   * @return the boolean
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @Transactional
  public Boolean deleteDrone(Long droneId) throws ExceptionsDefinitions {
    boolean droneDeleted = Drone.deleteById(droneId);
    if (droneDeleted) {
      return droneDeleted;
    }
    throw new ExceptionsDefinitions(droneId.toString(), "is not a valid ID");
  }
}
