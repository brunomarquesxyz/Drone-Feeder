package com.feeder.drone.service;

import com.feeder.drone.dto.DroneDto;
import com.feeder.drone.entity.Drone;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class DroneService {

  @Transactional
  public void createDrone(Drone droneToAdd) {
    Drone.persist(droneToAdd);
    droneToAdd.isPersistent();
  }

  public List<Drone> getAllDrones() {
    return Drone.listAll();
  }

  public Drone getDroneByName(String droneName) {
    return Drone.findByName(droneName);
  }

  @Transactional
  public Drone updateDrone(Long id, DroneDto droneToUpdate) {
    Drone entity = Drone.findById(id);

    entity.setLatitude(droneToUpdate.getLatitude());
    entity.setLongitude(droneToUpdate.getLongitude());

    Drone.persist(entity);

    return entity;
  }

  @Transactional
  public Boolean deleteDrone(Long droneId) {
    return Drone.deleteById(droneId);
  }
}
