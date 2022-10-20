package com.feeder.drone.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Delivery extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", length = 36)
  @NonNull
  private UUID id;

  @NonNull
  @Column(name = "delivered_at")
  private String deliveredAt;

  @NonNull
  private DeliveryStatus status = DeliveryStatus.PENDING;

  @OneToOne
  private Video video;

  private String latitude;
  private String longitude;

  @ManyToOne
  private Drone drone;

  public Delivery() {
  }

  public Delivery(Drone drone, String latitude, String longitude) {
    this.drone = drone;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
