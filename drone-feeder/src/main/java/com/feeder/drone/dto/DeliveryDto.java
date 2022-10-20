package com.feeder.drone.dto;

import java.util.UUID;

public class DeliveryDto {

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public UUID droneID;

  public String latitude;

  public String longitude;

  public DeliveryDto() {
  }

  public DeliveryDto(UUID droneID, String latitude, String longitude) {
    this.droneID = droneID;
    this.latitude = latitude;
    this.longitude = longitude;
  }
  public UUID getDroneID() {
    return droneID;
  }

  public void setDroneID(UUID droneID) {
    this.droneID = droneID;
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
