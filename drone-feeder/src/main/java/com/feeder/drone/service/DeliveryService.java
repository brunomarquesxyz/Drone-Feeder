package com.feeder.drone.service;

import com.feeder.drone.dto.DeliveryDto;
import com.feeder.drone.entity.Delivery;
import com.feeder.drone.entity.Drone;
import com.feeder.drone.exceptions.ExceptionsDefinitions;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * The type Delivery service.
 */
@ApplicationScoped
public class DeliveryService {

  /**
   * Create delivery delivery.
   *
   * @param deliveryDto the delivery dto
   * @return the delivery
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @Transactional
  public Delivery createDelivery(DeliveryDto deliveryDto) throws ExceptionsDefinitions {
    Drone drone = Drone.find("id", deliveryDto.getDroneID()).firstResult();
    Delivery deliveryRegistred = new Delivery(
        drone,
        deliveryDto.getLatitude(),
        deliveryDto.getLongitude()
    );

    deliveryRegistred.setDrone(drone);
    Delivery.persist(deliveryRegistred);
    if (!deliveryRegistred.isPersistent()) {
      throw new ExceptionsDefinitions("Invalid", "Operation");
    }

    return deliveryRegistred;
  }

  /**
   * Gets all delivery.
   *
   * @return the all delivery
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  public List<Delivery> getAllDelivery() throws ExceptionsDefinitions {
    List<Delivery> allDeliveries = Delivery.listAll();
    if (allDeliveries == null) {
      throw new ExceptionsDefinitions("Bad", "Request");
    }
    return allDeliveries;
  }

  /**
   * Gets delivery by id.
   *
   * @param deliveryId the delivery id
   * @return the delivery by id
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  public Delivery getDeliveryById(Long deliveryId) throws ExceptionsDefinitions {
    Delivery deliveryRegistered = Delivery.findById(deliveryId);
    if (deliveryRegistered == null) {
      throw new ExceptionsDefinitions(deliveryId.toString(), "is not a valid ID");

    }
    return deliveryRegistered;
  }

  /**
   * Update delivery.
   *
   * @param updatesData the updates data
   * @param deliveryId  the delivery id
   * @return the delivery
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @Transactional
  public Delivery update(Delivery updatesData, Long deliveryId) throws ExceptionsDefinitions {
    Delivery toUpdate = Delivery.findById(deliveryId);

    if (toUpdate == null) {
      throw new ExceptionsDefinitions(deliveryId.toString(), "is not a valid ID");
    }

    toUpdate.setStatus(updatesData.getStatus());
    toUpdate.setLatitude(updatesData.getLatitude());
    toUpdate.setLongitude(updatesData.getLongitude());

    Delivery.persist(toUpdate);

    return toUpdate;
  }

  /**
   * Delete delivery boolean.
   *
   * @param deliveryID the delivery id
   * @return the boolean
   * @throws ExceptionsDefinitions the exceptions definitions
   */
  @Transactional
  public Boolean deleteDelivery(Long deliveryID) throws ExceptionsDefinitions {
    boolean deliveryDeleted = Delivery.deleteById(deliveryID);
    if (deliveryDeleted) {
      return deliveryDeleted;
    }
    throw new ExceptionsDefinitions(deliveryID.toString(), "is not a valid ID");
  }
}
