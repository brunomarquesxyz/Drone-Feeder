package com.feeder.drone;

import com.feeder.drone.entity.Drone;
import com.github.javafaker.Faker;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


@QuarkusTest
public class DroneResourceTest {

  @Test
  @DisplayName("Should create new Drone when all fields are corrects and return status code 201")
  public void createDrone() {
    var drone1 = new Drone("drone1", "-100", "4567");
    restSut()
        .when()
        .body(drone1)
        .post("/drone")
        .then()
        .statusCode(HttpStatus.SC_CREATED);
  }

  @Test
  @DisplayName("Should update drone name")
  public void updateDrone() {
    RestAssured.defaultParser = Parser.JSON;
    var drone = new Drone("Drone", "100", "234");
    var newDrone = restSut()
        .when()
        .body(drone)
        .post("/drone")
        .as(Drone.class);

    String newName = genNames().name().toString();

    newDrone.setName(newName);
    System.out.println(newDrone.id);
    restSut()
        .body(newDrone)
        .when()
        .post("/drone" + newDrone)
        .then()
        .body("name", is(newName));
  }

  public RequestSpecification restSut() {
    return given()
        .contentType(MediaType.APPLICATION_JSON);
  }

  public Faker genNames() {
    return new Faker();
  }
}