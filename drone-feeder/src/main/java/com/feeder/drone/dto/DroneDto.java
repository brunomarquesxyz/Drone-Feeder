package com.feeder.drone.dto;


/**
 * The type Drone dto.
 */
public class DroneDto {
  private String latitude;
  private String longitude;

  /**
   * Instantiates a new Drone dto.
   */
  public DroneDto() {
  }

  /**
   * Instantiates a new Drone dto.
   *
   * @param latitude  the latitude
   * @param longitude the longitude
   */
  public DroneDto(String latitude, String longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
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
   * Sets latitude.
   *
   * @param latitude the latitude
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * Sets longitude.
   *
   * @param longitude the longitude
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
}
