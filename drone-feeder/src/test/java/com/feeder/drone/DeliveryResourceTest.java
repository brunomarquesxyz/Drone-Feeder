package com.feeder.drone;

import com.feeder.drone.entity.Delivery;
import com.feeder.drone.entity.Drone;
import com.feeder.drone.enums.DeliveryStatus;
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
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;


/**
 * The type Delivery resource test.
 */
@QuarkusTest
public class DeliveryResourceTest {


  /**
   * Find all deliverys.
   */
  @Test
  @DisplayName("Should find all deliverys")
  public void findAllDeliverys() {
    Drone drone = new Drone(genNames(), "100", "234");

    Delivery newDelivery = new Delivery(drone, "-100", "4567");
    restSut()
        .when()
        .body(newDelivery)
        .post("/delivery")
        .as(Delivery.class);

    restSut()
        .body(newDelivery)
        .when()
        .get("/delivery/")
        .then().statusCode(HttpStatus.SC_OK)
        .body("id", hasItem(2))
        .body("status", hasItems("PENDING", "PENDING"));
  }

  /**
   * Create delivery.
   */
  @Test
  @DisplayName("Should create new Delivery when all fields are corrects and return status code 201")
  public void createDelivery() {
    Drone drone = new Drone(genNames(), "100", "234");

    Delivery delivery1 = new Delivery(drone, "-100", "4567");
    restSut()
        .when()
        .body(delivery1)
        .post("/delivery")
        .then()
        .statusCode(HttpStatus.SC_CREATED);
  }

  /**
   * Update delivery.
   */
  @Test
  @DisplayName("Should update delivery status, latitude and longitude")
  public void updateDelivery() {
    Drone drone = new Drone("Drone", "100", "234");

    Delivery setDelivery = new Delivery(drone, "-100", "4567");
    Delivery newDelivery =
        restSut()
            .when()
            .body(setDelivery)
            .post("/delivery")
            .as(Delivery.class);

    Random randomGenerator = new Random();
    float randomCoordinate = randomGenerator.nextFloat();
    String newLatitude = Float.toString(randomCoordinate);
    String newLongitude = Float.toString(randomCoordinate);


    newDelivery.setLatitude(newLatitude);
    newDelivery.setLongitude(newLongitude);
    newDelivery.setStatus(DeliveryStatus.PROCESSING);

    restSut()
        .body(newDelivery)
        .when()
        .put("/delivery/" + newDelivery.id)
        .then().statusCode(HttpStatus.SC_ACCEPTED)
        .body("latitude", is(newLatitude))
        .body("status", is("PROCESSING"))
        .body("longitude", is(newLongitude));
  }

  /**
   * Delete delivery.
   */
  @Test
  @DisplayName("Should delete a delivery by his ID")
  public void deleteDelivery() {
    Drone drone = new Drone(genNames(), "100", "234");

    Delivery setDelivery = new Delivery(drone, "-100", "4567");
    Delivery newDelivery =
        restSut()
            .when()
            .body(setDelivery)
            .post("/delivery")
            .as(Delivery.class);

    restSut()
        .body(newDelivery)
        .when()
        .delete("/delivery/" + newDelivery.id)
        .then().statusCode(HttpStatus.SC_NO_CONTENT);
  }


  /**
   * Find delivery by id.
   */
  @Test
  @DisplayName("Should find a delivery by his ID")
  public void findDeliveryById() {
    Drone drone = new Drone(genNames(), "100", "234");

    Delivery setDelivery = new Delivery(drone, "-100", "4567");
    Delivery newDelivery =
        restSut()
            .when()
            .body(setDelivery)
            .post("/delivery")
            .as(Delivery.class);

    restSut()
        .body(newDelivery)
        .when()
        .get("/delivery/" + newDelivery.id)
        .then().statusCode(HttpStatus.SC_OK)
        .body("id", equalTo(2))
        .body("status", equalTo("PENDING"))
        .body("latitude", equalTo("-100"))
        .body("longitude", equalTo("4567"));
  }

  /**
   * Rest sut request specification.
   *
   * @return the request specification
   */
  public RequestSpecification restSut() {
    return given()
        .contentType(MediaType.APPLICATION_JSON);
  }

  /**
   * Gen names string.
   *
   * @return the string
   */
  public String genNames() {
    return new Faker().name().toString();
  }
}
