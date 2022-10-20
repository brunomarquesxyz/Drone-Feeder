package com.feeder.drone.dto;

public class DeliveryDto {

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

  public String getLongitude() {
    return longitude;
  }
}
