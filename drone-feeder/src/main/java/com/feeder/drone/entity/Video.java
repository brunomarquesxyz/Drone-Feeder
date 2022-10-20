package com.feeder.drone.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.Serializable;
import javax.persistence.Entity;
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
public class Video extends PanacheEntity implements Serializable {

  private static final long serialVersionUID = -3670232159675112853L;

  @NonNull
  private Byte[] data;

  @NonNull
  private String name;

  public Video() {}

  public static Video findVideoByName(String name) {
    return Video.find("name", name).firstResult();
  }
}
