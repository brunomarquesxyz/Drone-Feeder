package com.feeder.drone.service;

import com.feeder.drone.dto.DeliveryDto;
import com.feeder.drone.entity.Delivery;
import com.feeder.drone.entity.Drone;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

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

  public Delivery getDeliveryById(Long deliveryId) {
    return Delivery.findById(deliveryId);
  }

  @Transactional
  public Delivery update(Delivery updatesData, Long deliveryId) {
    var toUpdate = Delivery.findById(deliveryId);

    if (toUpdate == null) throw new NotFoundException("Delivery not found");

    Delivery.update(
        "status = ?1, latitude = ?2, longitude = ?3 where id = ?4",
        updatesData.getStatus(),
        updatesData.getLatitude(),
        updatesData.getLongitude(),
        deliveryId
    );
    return updatesData;
  }

  @Transactional
  public Boolean deleteDelivery(Long deliveryID) {
    return Delivery.deleteById(deliveryID);
  }
}
