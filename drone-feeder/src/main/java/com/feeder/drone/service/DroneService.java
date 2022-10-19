package com.feeder.drone.service;

import com.feeder.drone.entity.Drone;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class DroneService {

  @Transactional
  public void createDrone(Drone droneToAdd) {
    Drone.persist(droneToAdd);
  }
}
