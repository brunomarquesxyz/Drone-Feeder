package com.feeder.drone;

import com.feeder.drone.entity.Drone;
import com.github.javafaker.Faker;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.specification.RequestSpecification;
import java.util.Random;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;


@QuarkusTest
public class DroneResourceTest {


  @Test
  @DisplayName("Should create new Drone when all fields are corrects and return status code 201")
  public void createDrone() {

    Drone drone1 = new Drone(genNames(), "-100", "4567");
    restSut()
        .when()
        .body(drone1)
        .post("/drone")
        .then()
        .statusCode(HttpStatus.SC_CREATED);
  }

  @Test
  @DisplayName("Should update drone latitude and longitude")
  public void updateDrone() {
    Drone drone = new Drone(genNames(), "100", "234");

    Drone newDrone = restSut()
        .when()
        .body(drone)
        .post("/drone")
        .as(Drone.class);

    Random randomGenerator = new Random();
    float randomCoordinate = randomGenerator.nextFloat();
    String newLatitude = Float.toString(randomCoordinate);
    String newLongitude = Float.toString(randomCoordinate);


    newDrone.setLatitude(newLatitude);
    newDrone.setLongitude(newLongitude);


    restSut()
        .body(newDrone)
        .when()
        .put("/drone/" + newDrone.id)
        .then().statusCode(HttpStatus.SC_ACCEPTED)
        .body("latitude", is(newLatitude))
        .body("longitude", is(newLongitude));
  }

  @Test
  @DisplayName("Should delete a drone by his ID")
  public void deleteDrone() {
    Drone drone = new Drone(genNames(), "100", "234");

    Drone newDrone = restSut()
        .when()
        .body(drone)
        .post("/drone")
        .as(Drone.class);


    restSut()
        .body(newDrone)
        .when()
        .delete("/drone/" + newDrone.id)
        .then().statusCode(HttpStatus.SC_NO_CONTENT);
  }

  @Test
  @DisplayName("Should find all drones")
  public void findAllDrones() {
    String droneName = genNames();

    Drone drone = new Drone(droneName, "100", "234");

    Drone newDrone = restSut()
        .when()
        .body(drone)
        .post("/drone")
        .as(Drone.class);

    restSut()
        .body(newDrone)
        .when()
        .get("/drone")
        .then().statusCode(HttpStatus.SC_OK)
        .body("name", hasItem(droneName))
        .body("latitude", hasItem("100"))
        .body("longitude", hasItem("234"));
  }

  @Test
  @DisplayName("Should find a drone by his name")
  public void findDroneById() {
    String droneName = genNames();
    Drone drone = new Drone(droneName, "100", "234");

    Drone newDrone = restSut()
        .when()
        .body(drone)
        .post("/drone")
        .as(Drone.class);

    restSut()
        .body(newDrone)
        .when()
        .get("/drone/" + newDrone.getName())
        .then().statusCode(HttpStatus.SC_OK)
        .body("name", equalTo(droneName))
        .body("latitude", equalTo("100"))
        .body("longitude", equalTo("234"));
  }

  public RequestSpecification restSut() {
    return given()
        .contentType(MediaType.APPLICATION_JSON);
  }

  public String genNames() {
    return new Faker().name().toString();
  }
}