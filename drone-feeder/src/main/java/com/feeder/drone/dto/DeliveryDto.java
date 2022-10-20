package com.feeder.drone.dto;

public class DeliveryDto {

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Long droneID;

  public String latitude;

  public String longitude;

  public DeliveryDto() {
  }

  public DeliveryDto(Long droneID, String latitude, String longitude) {
    this.droneID = droneID;
    this.latitude = latitude;
    this.longitude = longitude;
  }
  public Long getDroneID() {
    return droneID;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }
}
