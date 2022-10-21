package com.feeder.drone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

/**
 * The type Drone.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Drone extends PanacheEntity implements Serializable {

  private static final long serialVersionUID = -3670232159675112851L;

  @NonNull
  @Column(unique = true)
  private String name;

  @NonNull
  private String latitude;

  @NonNull
  private String longitude;

  @JsonBackReference
  @OneToMany(targetEntity = Delivery.class)
  @ToString.Exclude
  private List<Delivery> deliveries;

  /**
   * Instantiates a new Drone.
   */
  public Drone() {
  }

  /**
   * Find by name drone.
   *
   * @param name the name
   * @return the drone
   */
  public static Drone findByName(String name) {
    return find("name", name).firstResult();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    Drone drone = (Drone) o;
    return Objects.equals(id, drone.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
