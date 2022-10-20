package com.feeder.drone.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Drone extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", length = 36)
  @NonNull
  private UUID id;

  @NonNull
  @Column(unique = true)
  private String name;

  @NonNull
  private String latitude;

  @NonNull
  private String longitude;

  @OneToMany(targetEntity=Delivery.class)
  private List<Delivery> deliveries;

  public Drone() {}

  public static Drone findByName(String name){
    return find("name", name).firstResult();
  }
}
