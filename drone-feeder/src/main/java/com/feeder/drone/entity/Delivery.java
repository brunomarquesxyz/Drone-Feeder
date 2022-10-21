package com.feeder.drone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.feeder.drone.enums.DeliveryStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

/**
 * The type Delivery.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Delivery extends PanacheEntity implements Serializable {

  private static final long serialVersionUID = -3670232159675112852L;

  @Column(name = "delivered_at")
  private String deliveredAt;

  @NonNull
  private DeliveryStatus status = DeliveryStatus.PENDING;

  @OneToOne
  private Video video;

  private String latitude;
  private String longitude;

  @JsonBackReference
  @ManyToOne
  private Drone drone;

  /**
   * Instantiates a new Delivery.
   *
   * @param drone     the drone
   * @param latitude  the latitude
   * @param longitude the longitude
   */
  public Delivery(Drone drone, String latitude, String longitude) {
    this.drone = drone;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    Delivery delivery = (Delivery) o;
    return Objects.equals(id, delivery.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
