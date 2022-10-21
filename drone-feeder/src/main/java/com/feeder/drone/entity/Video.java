package com.feeder.drone.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Video.
 */
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

  /**
   * Instantiates a new Video.
   */
  public Video() {
  }

  /**
   * Find video by name video.
   *
   * @param name the name
   * @return the video
   */
  public static Video findVideoByName(String name) {
    return Video.find("name", name).firstResult();
  }
}
