package by.epam.javawebtraining.kunitski.task05.util;

import by.epam.javawebtraining.kunitski.task05.model.resource.Parking;
import by.epam.javawebtraining.kunitski.task05.model.thread.Car;

import java.util.Random;

public class CarGenerator {
  private static final int MAX_WAITING_TIME = 2_000;
  private static final int MAX_STAYING_TIME = 1_000;
  private static final int CAR_COUNT = 20;
  private static Random random = new Random();

  public static Car[] createCars(Parking parking){
    Car[] cars = new Car[CAR_COUNT];

    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(parking, random.nextInt(MAX_WAITING_TIME), random.nextInt(MAX_STAYING_TIME));
    }
    return cars;
  }
}
