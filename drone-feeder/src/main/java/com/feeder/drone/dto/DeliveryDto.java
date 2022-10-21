package com.feeder.drone.dto;

/**
 * The type Delivery dto.
 */
public class DeliveryDto {

  /**
   * The Drone id.
   */
  public Long droneID;

  /**
   * The Latitude.
   */
  public String latitude;

  /**
   * The Longitude.
   */
  public String longitude;

  /**
   * Instantiates a new Delivery dto.
   */
  public DeliveryDto() {
  }

  /**
   * Instantiates a new Delivery dto.
   *
   * @param droneID   the drone id
   * @param latitude  the latitude
   * @param longitude the longitude
   */
  public DeliveryDto(Long droneID, String latitude, String longitude) {
    this.droneID = droneID;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Gets drone id.
   *
   * @return the drone id
   */
  public Long getDroneID() {
    return droneID;
  }

  /**
   * Gets latitude.
   *
   * @return the latitude
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }
}
