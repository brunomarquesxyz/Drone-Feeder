package com.feeder.drone.service;

import com.feeder.drone.dto.DeliveryDto;
import com.feeder.drone.entity.Delivery;
import com.feeder.drone.entity.Drone;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class DeliveryService {

  @Transactional
  public Delivery createDelivery(DeliveryDto deliveryDto) {
    Drone drone = Drone.find("id", deliveryDto.getDroneID()).firstResult();
    Delivery deliveryRegistred = new Delivery(
        drone,
        deliveryDto.getLatitude(),
        deliveryDto.getLongitude()
    );

    deliveryRegistred.setDrone(drone);
    Delivery.persist(deliveryRegistred);
    deliveryRegistred.isPersistent();
    return deliveryRegistred;
  }

  public List<Delivery> getAllDelivery() {
    return Delivery.listAll();
  }

  public Delivery getDeliveryById(UUID deliveryId) {
    return (Delivery) Delivery.list("SELECT '*' FROM Drone WHERE id = :droneId", deliveryId);
  }
}
